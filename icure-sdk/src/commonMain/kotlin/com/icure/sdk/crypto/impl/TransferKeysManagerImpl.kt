package com.icure.sdk.crypto.impl

import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.sdk.crypto.TransferKeysManager
import com.icure.sdk.crypto.UserEncryptionKeysManager
import com.icure.sdk.crypto.entities.CandidateTransferKey
import com.icure.sdk.crypto.entities.IcureKeyInfo
import com.icure.sdk.model.CryptoActorStubWithType
import com.icure.sdk.model.base.CryptoActor
import com.icure.sdk.model.extensions.publicKeysSpki
import com.icure.sdk.model.specializations.KeypairFingerprintV1String
import com.icure.sdk.storage.IcureStorageFacade
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.collections.DirectedGraph
import com.icure.sdk.utils.collections.StronglyConnectedGraph
import com.icure.sdk.utils.ensure
import com.icure.sdk.utils.ensureNonNull

@InternalIcureApi
internal class TransferKeysManagerImpl(
	private val encryptionKeysManager: UserEncryptionKeysManager,
	private val icureStorage: IcureStorageFacade
) : TransferKeysManager {
	override suspend fun updateTransferKeys(self: CryptoActorStubWithType) {
		val newEdgesByTarget = getSuggestedTransferKeys(self.stub)
		// const newEdgesByTarget = await this.getNewVerifiedTransferKeysEdges(self)
		//    if (!newEdgesByTarget.length) return
		//    const selfId = self.stub.id!
		//    const fpToPublicKey = fingerprintToPublicKeysMapOf(self.stub, ShaVersion.Sha1)
		//    const fpToPublicKeyWithSha256 = fingerprintToPublicKeysMapOf(self.stub, ShaVersion.Sha256)
		//    const signatureKeyPair = await this.userSignatureKeysManager.getOrCreateSignatureKeyPair()
		//    const verifiedFps = new Set(this.encryptionKeysManager.getSelfVerifiedKeys().map((x) => x.fingerprint))
		//    const allVerifiedSourcesAndTarget = Array.from(
		//      new Set(
		//        newEdgesByTarget.flatMap((x) =>
		//          // Sources are guaranteed to be verified, but target may not be
		//          verifiedFps.has(x.targetFp) ? [x.targetFp, ...x.sources] : x.sources
		//        )
		//      )
		//    )
		//    const newExchangeKeyPublicKeys = allVerifiedSourcesAndTarget.map((fp) => fpToPublicKey[fp]).filter((key) => !!key)
		//    const newExchangeKeyPublicKeysWithSha256 = allVerifiedSourcesAndTarget.map((fp) => fpToPublicKeyWithSha256[fp]).filter((key) => !!key)
		//    const createdExchangeData = await this.baseExchangeDataManager.createExchangeData(
		//      selfId,
		//      { [signatureKeyPair.fingerprint]: signatureKeyPair.keyPair.privateKey },
		//      {
		//        ...(await loadPublicKeys(this.primitives.RSA, newExchangeKeyPublicKeys, ShaVersion.Sha1)),
		//        ...(await loadPublicKeys(this.primitives.RSA, newExchangeKeyPublicKeysWithSha256, ShaVersion.Sha256)),
		//      }
		//    )
		//    let updatedTransferKeys = self.stub.transferKeys ?? {}
		//    for (const newEdges of newEdgesByTarget) {
		//      const encryptedTransferKey = await this.encryptTransferKey(newEdges.target, createdExchangeData.exchangeKey)
		//      updatedTransferKeys = newEdges.sources.reduce((acc, candidateFp) => {
		//        const existingKeys = { ...(acc[candidateFp] ?? {}) }
		//        existingKeys[newEdges.targetFp] = encryptedTransferKey
		//        acc[candidateFp] = existingKeys
		//        return acc
		//      }, updatedTransferKeys)
		//    }
		//    await this.dataOwnerApi.modifyCryptoActorStub({
		//      stub: {
		//        ...self.stub,
		//        transferKeys: updatedTransferKeys,
		//      },
		//      type: self.type,
		//    })

	}

	/**
	 * Get the suggested transfer keys for a data owner, based on the currently available key, their verification status
	 * and the verified transfer keys.
	 * @param self the current data owner.
	 * @return the new verified transfer keys edges.
	 */
	suspend fun getSuggestedTransferKeys(
		self: CryptoActor,
	): List<CandidateTransferKey> {
		val currentTransferKeysGraph = transferKeysFpGraphOf(self)
		val verifiedKeysFpSet = (
			icureStorage.loadSelfVerifiedKeys(self.id).filter { it.value }.keys
				+ encryptionKeysManager.getSelfVerifiedKeys().map { it.pubSpkiHexString.fingerprintV1() }
		).toSet()
		if (verifiedKeysFpSet.isEmpty()) return emptyList()
		val fpToSpki = self.publicKeysSpki.associateBy { it.fingerprintV1() }
		// 1. Choose keys available in this device which should be reachable from all other verified keys
		val targetKeys = currentTransferKeysGraph.transferTargetKeys()
		return targetKeys.flatMap { targetKey ->
			// 2. Find groups which can't reach the existing target keys
			val candidatesFp = currentTransferKeysGraph.transferKeysCandidatesFp(targetKey.pubSpkiHexString.fingerprintV1())
			// 3. Keep only groups which contain at least a verified candidate
			val verifiedGroupCandidates = candidatesFp.filter { candidate ->
				currentTransferKeysGraph.acyclicLabelToGroup[candidate]!!.any { verifiedKeysFpSet.contains(it) }
			}
			val verifiedCandidatesSet = verifiedGroupCandidates.toSet()
			if (verifiedCandidatesSet.isEmpty()) return@flatMap emptyList()
			// 4. Drop all candidates which can already reach another candidate group: it is sufficient to create a transfer key from that group.
			val optimizedCandidates = verifiedGroupCandidates.filter { candidate ->
				ensureNonNull(currentTransferKeysGraph.reachSets[candidate]) {
					"Reach set not found for candidate $candidate in transfer keys graph"
				}.all { reachableNode -> !verifiedCandidatesSet.contains(reachableNode) }
			}
			ensure(optimizedCandidates.isNotEmpty()) { "Check failed: at least one candidate should survive optimization" }
			// 5. Transfer keys could also be faked: to make sure we are not giving access to unauthorised people we remap the candidates to a verified public
			// keys
			val verifiedOptimizedCandidates = optimizedCandidates.map { candidate ->
				ensureNonNull(
					currentTransferKeysGraph.acyclicLabelToGroup[candidate]?.find { verifiedKeysFpSet.contains(it) }
				) {
					"Check failed: optimized candidates groups should have at least a verified member"
				}
			}
			listOf(CandidateTransferKey(verifiedOptimizedCandidates.map { fpToSpki.getValue(it) }, targetKey))
		}
	}

	fun transferKeysFpGraphOf(dataOwner: CryptoActor): StronglyConnectedGraph<KeypairFingerprintV1String> {
		val publicKeys = dataOwner.publicKeysSpki.map { it.fingerprintV1() }
		val edges = dataOwner.transferKeys.entries.flatMap { (source, targetKeys) ->
			val sourceFp = source.toFingerprintV1OrNull()
			if (sourceFp == null) {
				emptyList()
			} else {
				targetKeys.keys.mapNotNull { target -> target.toFingerprintV1OrNull()?.let { sourceFp to it } }
			}
		}
		return DirectedGraph.fromEdges(*edges.toTypedArray(), additionalNodes = publicKeys).acyclic()
	}

	private fun StronglyConnectedGraph<KeypairFingerprintV1String>.transferTargetKeys(): List<IcureKeyInfo<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>> {
		// The groups of all keys available on this device -> we have the ability to create transfer keys to them
		val availableGroups = encryptionKeysManager.getDecryptionKeys().allKeys.map { key ->
			key.pubSpkiHexString.fingerprintV1().let { fp -> originalLabelToAcyclicLabel[fp] ?: fp }
		}.toSet()
		// Drop candidates that are already reachable from another transfer keys group
		val groupsReachableFromAvailable = acyclicGraph.nodesToEdges.entries.flatMap { (source, reachables) ->
			if (availableGroups.contains(source)) reachables else emptyList()
		}.toSet()
		val targetCandidates = availableGroups.filter { it !in groupsReachableFromAvailable }
		// Remap candidate groups to prefer verified keys if available on that group
		val verifiedFps = encryptionKeysManager.getSelfVerifiedKeys().map { it.pubSpkiHexString.fingerprintV1() }
		return targetCandidates.map { candidateFp ->
			val candidateGroup = acyclicLabelToGroup[candidateFp] ?: setOf(candidateFp) // May not be part of transfer keys graph yet
			val bestCandidateOfGroup = candidateGroup.find { verifiedFps.contains(it) } ?: candidateFp
			ensureNonNull(encryptionKeysManager.getKeyPairForFingerprint(bestCandidateOfGroup.toV2())) {
				"Key pair not found for fingerprint $bestCandidateOfGroup"
			}.keyPair
		}
	}

	// all public keys would go to the stored keys -> no need for specifying the key.
	// Result only includes the acyclic label, not the full group
	private fun StronglyConnectedGraph<KeypairFingerprintV1String>.transferKeysCandidatesFp(
		keyToFp: KeypairFingerprintV1String
	): Set<KeypairFingerprintV1String> =
		reachSets.mapNotNull { (from, reachable) ->
			val currGroup = acyclicLabelToGroup.getValue(from)
			val reachableOriginal = reachable.flatMap { acyclicLabelToGroup.getValue(it) }
			if (keyToFp in currGroup || keyToFp in reachableOriginal) null else from
		}.toSet()
}
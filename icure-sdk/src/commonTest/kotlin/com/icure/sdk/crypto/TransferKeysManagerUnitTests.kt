package com.icure.sdk.crypto

import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.sdk.crypto.entities.CandidateTransferKey
import com.icure.sdk.crypto.entities.IcureKeyInfo
import com.icure.sdk.crypto.fake.FakeUserEncryptionKeysManager
import com.icure.sdk.crypto.impl.TransferKeysManagerImpl
import com.icure.sdk.crypto.impl.exportSpkiHex
import com.icure.sdk.model.HealthcareParty
import com.icure.sdk.model.specializations.AesExchangeKeyEncryptionKeypairIdentifier
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.model.specializations.KeypairFingerprintV1String
import com.icure.sdk.model.specializations.SpkiHexString
import com.icure.sdk.storage.IcureStorageFacade
import com.icure.sdk.storage.impl.DefaultStorageEntryKeysFactory
import com.icure.sdk.storage.impl.JsonAndBase64KeyStorage
import com.icure.sdk.storage.impl.VolatileStorageFacade
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.collections.DirectedGraph
import com.icure.sdk.utils.collections.StronglyConnectedGraph
import io.kotest.assertions.fail
import io.kotest.common.runBlocking
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldContainAnyOf
import io.kotest.matchers.maps.shouldHaveSize
import io.kotest.matchers.shouldBe

@OptIn(InternalIcureApi::class)
class TransferKeysManagerUnitTests : StringSpec({
	fun createKeyInfo(): Pair<IcureKeyInfo<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>, SpkiHexString> =
		runBlocking {
			defaultCryptoService.rsa.generateKeyPair(
				RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256
			).let { keyPair ->
				val keyInfo = IcureKeyInfo(
					defaultCryptoService.rsa.exportSpkiHex(keyPair.public),
					keyPair
				)
				Pair(keyInfo, keyInfo.pubSpkiHexString)
			}
		}

	lateinit var storage: IcureStorageFacade
	lateinit var encryptionKeysManage: FakeUserEncryptionKeysManager
	lateinit var transferKeysManager: TransferKeysManagerImpl
	lateinit var self: HealthcareParty
	val (aKey, a) = createKeyInfo()
	val (bKey, b) = createKeyInfo()
	val (cKey, c) = createKeyInfo()
	val (dKey, d) = createKeyInfo()
	val (eKey, e) = createKeyInfo()
	val (fKey, f) = createKeyInfo()

	beforeEach {
		val memStorage = VolatileStorageFacade()
		storage = IcureStorageFacade(
			JsonAndBase64KeyStorage(memStorage),
			memStorage,
			DefaultStorageEntryKeysFactory,
			defaultCryptoService,
			false
		)
		encryptionKeysManage = FakeUserEncryptionKeysManager()
		transferKeysManager = TransferKeysManagerImpl(encryptionKeysManage, storage)
		self = HealthcareParty(defaultCryptoService.strongRandom.randomUUID())
	}

	suspend fun addKey(key: IcureKeyInfo<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>, available: Boolean, verified: Boolean) {
		if (available) {
			encryptionKeysManage.addSelfKey(key, verified)
		}
		if (verified) {
			storage.updateAndSaveSelfVerifiedKeys(self.id, mapOf(key.pubSpkiHexString.fingerprintV1() to verified))
		}
		self = self.copy(publicKeysForOaepWithSha256 = self.publicKeysForOaepWithSha256 + key.pubSpkiHexString)
	}

	fun copyWithTransferKey(
		dataOwner: HealthcareParty,
		from: SpkiHexString,
		to: IcureKeyInfo<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>
	): HealthcareParty {
		val genericFrom = AesExchangeKeyEncryptionKeypairIdentifier(from.fingerprintV1().s)
		val genericTo = AesExchangeKeyEncryptionKeypairIdentifier(to.pubSpkiHexString.fingerprintV1().s)
		val newTransferKeys = dataOwner.transferKeys.toMutableMap()
		val fromTransferKeys = newTransferKeys[genericFrom]?.toMutableMap() ?: mutableMapOf()
		fromTransferKeys[genericTo] = HexString("0000")
		newTransferKeys[genericFrom] = fromTransferKeys
		return dataOwner.copy(transferKeys = newTransferKeys)
	}

	fun addTransferKey(from: SpkiHexString, to: IcureKeyInfo<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>) {
		self = copyWithTransferKey(self, from, to)
	}



	fun <T> StronglyConnectedGraph<T>.shuffled(): StronglyConnectedGraph<T> {
		val originalToNew = acyclicLabelToGroup.entries.associate { (originalLabel, newLabelCandidates) ->
			originalLabel to newLabelCandidates.random()
		}
		val newNodesToEdges = acyclicGraph.nodesToEdges.entries.map { (node, edges) ->
			originalToNew.getValue(node) to edges.map { originalToNew.getValue(it) }.shuffled().toSet()
		}.shuffled().toMap()
		val newOriginalLabelToAcyclicLabel = originalLabelToAcyclicLabel.mapValues { originalToNew.getValue(it.value) }
		val newAcyclicLabelToGroup = acyclicLabelToGroup.mapKeys { originalToNew.getValue(it.key) }.mapValues { it.value.shuffled().toSet() }
		return StronglyConnectedGraph(
			DirectedGraph(newNodesToEdges),
			newOriginalLabelToAcyclicLabel,
			newAcyclicLabelToGroup
		)
	}

	// Shuffle transfer keys and keys of the healthcare party, forcing randomization of the transfer keys graph
	fun HealthcareParty.shuffled(): HealthcareParty {
		return copy(
			publicKeysForOaepWithSha256 = publicKeysForOaepWithSha256.shuffled().toSet(),
			transferKeys = transferKeys.toList().map { (k, v) ->
				k to v.toList().shuffled().toMap()
			}.shuffled().toMap()
		)
	}

	// Support debugging
	fun KeypairFingerprintV1String.humanize() = when (s) {
		a.fingerprintV1().s -> "A"
		b.fingerprintV1().s -> "B"
		c.fingerprintV1().s -> "C"
		d.fingerprintV1().s -> "D"
		e.fingerprintV1().s -> "E"
		f.fingerprintV1().s -> "F"
		else -> "Unknown"
	}
	fun SpkiHexString.humanize() = fingerprintV1().humanize()
	fun CandidateTransferKey.humanize() = "${target.pubSpkiHexString.humanize()} <- (${sources.joinToString(", ") { it.humanize() }})"
	fun StronglyConnectedGraph<KeypairFingerprintV1String>.printHumanized() = acyclicGraph.nodesToEdges.forEach { (k, edges) ->
		println("${k.humanize()} -> ${edges.map { it.humanize() }}")
	}

	suspend fun getSuggestedTransferKeysAndPrint(dataOwner: HealthcareParty = self): List<CandidateTransferKey> {
		val suggestedTransferKeys = transferKeysManager.getSuggestedTransferKeys(dataOwner)
		println("Suggested transfer keys:")
		suggestedTransferKeys.forEach { println(it.humanize()) }
		return suggestedTransferKeys
	}

	fun applySuggestions(suggestedTransferKeys: List<CandidateTransferKey>, dataOwner: HealthcareParty = self): HealthcareParty =
		suggestedTransferKeys.fold(dataOwner) { updated, candidate ->
			candidate.sources.fold(updated) { innerUpdated, s ->
				copyWithTransferKey(innerUpdated, s, candidate.target)
			}
		}

	suspend fun verifyFullyConnected(dataOwner: HealthcareParty = self) {
		val usedKeys = dataOwner.publicKeysForOaepWithSha256
		val graph = transferKeysManager.transferKeysFpGraphOf(dataOwner)
		graph.acyclicGraph.nodesToEdges.shouldHaveSize(1)
		graph.acyclicLabelToGroup.shouldHaveSize(1)
		graph.acyclicLabelToGroup.values.single() shouldBe usedKeys.map { it.fingerprintV1() }.toSet()
		getSuggestedTransferKeysAndPrint(dataOwner).shouldBeEmpty()
	}

	suspend fun applySuggestionsAndVerifyFullyConnected(suggestedTransferKeys: List<CandidateTransferKey>, dataOwner: HealthcareParty = self) {
		verifyFullyConnected(applySuggestions(suggestedTransferKeys, dataOwner))
	}

	"Suggested transfer keys with all keys available and verified should match expected - case 1" {
		// A -> B -> C
		addKey(aKey, true, true)
		addKey(bKey, true, true)
		addKey(cKey, true, true)
		addTransferKey(a, bKey)
		addTransferKey(b, cKey)

		val suggestedTransferKeys = getSuggestedTransferKeysAndPrint()
		suggestedTransferKeys.size shouldBe 1
		suggestedTransferKeys.first().target.pubSpkiHexString shouldBe a
		suggestedTransferKeys.first().sources shouldBe listOf(c)
		applySuggestionsAndVerifyFullyConnected(suggestedTransferKeys)
	}

	"Suggested transfer keys with all keys available and verified should match expected - case 2" {
		// A -> B <-> C -> D <-> E
		addKey(aKey, true, true)
		addKey(bKey, true, true)
		addKey(cKey, true, true)
		addKey(dKey, true, true)
		addKey(eKey, true, true)
		addTransferKey(a, bKey)
		addTransferKey(b, cKey)
		addTransferKey(c, bKey)
		addTransferKey(c, dKey)
		addTransferKey(d, eKey)
		addTransferKey(e, dKey)

		val suggestedTransferKeys = getSuggestedTransferKeysAndPrint()
		suggestedTransferKeys.size shouldBe 1
		suggestedTransferKeys.first().target.pubSpkiHexString shouldBe a
		suggestedTransferKeys.first().sources.let {
			it.size shouldBe 1
			it shouldContainAnyOf listOf(d, e)
		}
		applySuggestionsAndVerifyFullyConnected(suggestedTransferKeys)
	}

	"Suggested transfer keys with all keys available and verified should match expected - case 3" {
		// A -> B -> C
		// D
		addKey(aKey, true, true)
		addKey(bKey, true, true)
		addKey(cKey, true, true)
		addKey(dKey, true, true)
		addTransferKey(a, bKey)
		addTransferKey(b, cKey)
		addTransferKey(c, bKey)

		/*
		 * A <- (C) -- note: this is redundant if for the following ones `A` is picked, but we complicate too much the algorithm otherwise
		 * D <- (one of {A, B, C})
		 * one of {A, B, C} <- (D) -- note: if A then we only have 2 candidates
		 */
		val suggestedTransferKeys = getSuggestedTransferKeysAndPrint()
		if (suggestedTransferKeys.size != 2 && suggestedTransferKeys.size != 3) fail("Unexpected number of suggested transfer keys - ${suggestedTransferKeys.size}")
		suggestedTransferKeys.find {
			it.target.pubSpkiHexString == a && it.sources.contains(c)
		} ?: fail("No suggestion for A <- C")
		suggestedTransferKeys.find { candidate ->
			candidate.target.pubSpkiHexString == d && candidate.sources.any { it == a || it == b || it == c }
		} ?: fail("No suggestion for D <- one of {A, B, C}")
		suggestedTransferKeys.find { candidate ->
			candidate.target.pubSpkiHexString.let { it == a || it == b || it == c } && candidate.sources.any { it == d }
		} ?: fail("No suggestion for one of {A, B, C} <- D")
		applySuggestionsAndVerifyFullyConnected(suggestedTransferKeys)
	}

	"Should not suggest transfer keys to non-available keys" {
		// A (non available) -> B (available)
		addKey(bKey, true, true)
		addKey(aKey, false, true)
		addTransferKey(a, bKey)
		getSuggestedTransferKeysAndPrint().shouldBeEmpty()
	}

	"Should suggest transfer keys even if the from is not-available" {
		// A (available), B (non available), should suggest B -> A
		addKey(aKey, true, true)
		addKey(bKey, false, true)
		val suggestions = getSuggestedTransferKeysAndPrint()
		suggestions.size shouldBe 1
		suggestions.first().target.pubSpkiHexString shouldBe a
		suggestions.first().sources shouldBe listOf(b)
		getSuggestedTransferKeysAndPrint(applySuggestions(suggestions)).shouldBeEmpty()
	}

	"Should not suggest transfer keys from unverified keys" {
		// A (verified) -> B (unverified)
		addKey(aKey, true, true)
		addKey(bKey, true, false)
		addTransferKey(a, bKey)
		getSuggestedTransferKeysAndPrint().shouldBeEmpty()
	}

	"Should still suggest transfer keys to unverified keys" {
		// A (unverified) -> B (verified)
		addKey(aKey, true, false)
		addKey(bKey, true, true)
		addTransferKey(a, bKey)
		val suggestions = getSuggestedTransferKeysAndPrint()
		suggestions.size shouldBe 1
		suggestions.first().target.pubSpkiHexString shouldBe a
		suggestions.first().sources shouldBe listOf(b)
		getSuggestedTransferKeysAndPrint(applySuggestions(suggestions)).shouldBeEmpty()
	}

	"When there are groups of mixed verified and unverified keys it should prefer to create links between verified keys" {
		// A (v) -> B -> C -> A
		//          |
		//          v
		// D (v) -> E -> F -> D

		// Must create D -> A
		addKey(aKey, true, true)
		addKey(bKey, true, false)
		addKey(cKey, true, false)
		addKey(dKey, true, true)
		addKey(eKey, true, false)
		addKey(fKey, true, false)
		addTransferKey(a, bKey)
		addTransferKey(b, cKey)
		addTransferKey(c, aKey)
		addTransferKey(d, eKey)
		addTransferKey(e, fKey)
		addTransferKey(f, dKey)
		addTransferKey(b, eKey)

		repeat(1000) {
			val shuffledSelf = self.shuffled()
			val suggestions = transferKeysManager.getSuggestedTransferKeys(shuffledSelf)
			suggestions.size shouldBe 1
			suggestions.first().target.pubSpkiHexString shouldBe a
			suggestions.first().sources shouldBe listOf(d)
			applySuggestionsAndVerifyFullyConnected(suggestions, shuffledSelf)
		}
	}

	"Should not suggest transfer keys if there is already an equivalent transfer key involving different members of the same group" {
		// A (v) -> B -> C -> A
		//          |
		//          v
		// D (v) -> E -> F -> D

		// Verification and availability was manipulated in order to enforce an attempt to create a key from A -> D.
		// The algorithm should realize that there is already a different transfer key from another member of group A to
		// another member of group D and should not suggest a new transfer key.
		addKey(aKey, false, true)
		addKey(bKey, false, false)
		addKey(cKey, false, false)
		addKey(dKey, true, true)
		addKey(eKey, true, false)
		addKey(fKey, true, false)
		addTransferKey(a, bKey)
		addTransferKey(b, cKey)
		addTransferKey(c, aKey)
		addTransferKey(d, eKey)
		addTransferKey(e, fKey)
		addTransferKey(f, dKey)
		addTransferKey(b, eKey)

		// Randomize the graph used to make sure that at least one time B and E are NOT the canonical labels for the 2 groups
		repeat(1000) {
			transferKeysManager.getSuggestedTransferKeys(
				self.shuffled()
			).shouldBeEmpty()
		}
	}
})
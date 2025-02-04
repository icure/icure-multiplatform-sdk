// auto-generated file
package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.mapToObject
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.objectToMap
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import com.icure.cardinal.sdk.js.model.base.codeStub_fromJs
import com.icure.cardinal.sdk.js.model.base.codeStub_toJs
import com.icure.cardinal.sdk.js.model.specializations.aesExchangeKeyEncryptionKeypairIdentifier_fromJs
import com.icure.cardinal.sdk.js.model.specializations.aesExchangeKeyEncryptionKeypairIdentifier_toJs
import com.icure.cardinal.sdk.js.model.specializations.aesExchangeKeyEntryKeyString_fromJs
import com.icure.cardinal.sdk.js.model.specializations.aesExchangeKeyEntryKeyString_toJs
import com.icure.cardinal.sdk.js.model.specializations.hexString_fromJs
import com.icure.cardinal.sdk.js.model.specializations.hexString_toJs
import com.icure.cardinal.sdk.js.model.specializations.spkiHexString_fromJs
import com.icure.cardinal.sdk.js.model.specializations.spkiHexString_toJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.model.CryptoActorStub
import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.specializations.AesExchangeKeyEncryptionKeypairIdentifier
import com.icure.cardinal.sdk.model.specializations.AesExchangeKeyEntryKeyString
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import kotlin.Array
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.Map

@Suppress("UNUSED_VARIABLE")
public fun cryptoActorStub_toJs(obj: CryptoActorStub): CryptoActorStubJs {
	val id = obj.id
	val rev = obj.rev
	val hcPartyKeys = mapToObject(
		obj.hcPartyKeys,
		{ x1: String ->
			x1
		},
		{ x1: List<HexString> ->
			listToArray(
				x1,
				{ x2: HexString ->
					hexString_toJs(x2)
				},
			)
		},
	)
	val aesExchangeKeys = mapToObject(
		obj.aesExchangeKeys,
		{ x1: AesExchangeKeyEntryKeyString ->
			aesExchangeKeyEntryKeyString_toJs(x1)
		},
		{ x1: Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>> ->
			mapToObject(
				x1,
				{ x2: String ->
					x2
				},
				{ x2: Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString> ->
					mapToObject(
						x2,
						{ x3: AesExchangeKeyEncryptionKeypairIdentifier ->
							aesExchangeKeyEncryptionKeypairIdentifier_toJs(x3)
						},
						{ x3: HexString ->
							hexString_toJs(x3)
						},
					)
				},
			)
		},
	)
	val transferKeys = mapToObject(
		obj.transferKeys,
		{ x1: AesExchangeKeyEncryptionKeypairIdentifier ->
			aesExchangeKeyEncryptionKeypairIdentifier_toJs(x1)
		},
		{ x1: Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString> ->
			mapToObject(
				x1,
				{ x2: AesExchangeKeyEncryptionKeypairIdentifier ->
					aesExchangeKeyEncryptionKeypairIdentifier_toJs(x2)
				},
				{ x2: HexString ->
					hexString_toJs(x2)
				},
			)
		},
	)
	val privateKeyShamirPartitions = mapToObject(
		obj.privateKeyShamirPartitions,
		{ x1: String ->
			x1
		},
		{ x1: HexString ->
			hexString_toJs(x1)
		},
	)
	val publicKey = nullToUndefined(
		obj.publicKey?.let { nonNull1 ->
			spkiHexString_toJs(nonNull1)
		}
	)
	val publicKeysForOaepWithSha256 = setToArray(
		obj.publicKeysForOaepWithSha256,
		{ x1: SpkiHexString ->
			spkiHexString_toJs(x1)
		},
	)
	val tags = setToArray(
		obj.tags,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val parentId = nullToUndefined(
		obj.parentId
	)
	return CryptoActorStubJs(js("{" +
		"id:id," +
		"rev:rev," +
		"hcPartyKeys:hcPartyKeys," +
		"aesExchangeKeys:aesExchangeKeys," +
		"transferKeys:transferKeys," +
		"privateKeyShamirPartitions:privateKeyShamirPartitions," +
		"publicKey:publicKey," +
		"publicKeysForOaepWithSha256:publicKeysForOaepWithSha256," +
		"tags:tags," +
		"parentId:parentId" +
	"}"))
}

public fun cryptoActorStub_fromJs(obj: CryptoActorStubJs): CryptoActorStub {
	val id = obj.id
	val rev = obj.rev
	val hcPartyKeys = objectToMap(
		obj.hcPartyKeys,
		"obj.hcPartyKeys",
		{ x1: String ->
			x1
		},
		{ x1: Array<String> ->
			arrayToList(
				x1,
				"x1",
				{ x2: String ->
					hexString_fromJs(x2)
				},
			)
		},
	)
	val aesExchangeKeys = objectToMap(
		obj.aesExchangeKeys,
		"obj.aesExchangeKeys",
		{ x1: String ->
			aesExchangeKeyEntryKeyString_fromJs(x1)
		},
		{ x1: Record<String, Record<String, String>> ->
			objectToMap(
				x1,
				"x1",
				{ x2: String ->
					x2
				},
				{ x2: Record<String, String> ->
					objectToMap(
						x2,
						"x2",
						{ x3: String ->
							aesExchangeKeyEncryptionKeypairIdentifier_fromJs(x3)
						},
						{ x3: String ->
							hexString_fromJs(x3)
						},
					)
				},
			)
		},
	)
	val transferKeys = objectToMap(
		obj.transferKeys,
		"obj.transferKeys",
		{ x1: String ->
			aesExchangeKeyEncryptionKeypairIdentifier_fromJs(x1)
		},
		{ x1: Record<String, String> ->
			objectToMap(
				x1,
				"x1",
				{ x2: String ->
					aesExchangeKeyEncryptionKeypairIdentifier_fromJs(x2)
				},
				{ x2: String ->
					hexString_fromJs(x2)
				},
			)
		},
	)
	val privateKeyShamirPartitions = objectToMap(
		obj.privateKeyShamirPartitions,
		"obj.privateKeyShamirPartitions",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			hexString_fromJs(x1)
		},
	)
	val publicKey = obj.publicKey?.let { nonNull1 ->
		spkiHexString_fromJs(nonNull1)
	}
	val publicKeysForOaepWithSha256 = arrayToSet(
		obj.publicKeysForOaepWithSha256,
		"obj.publicKeysForOaepWithSha256",
		{ x1: String ->
			spkiHexString_fromJs(x1)
		},
	)
	val tags = arrayToSet(
		obj.tags,
		"obj.tags",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val parentId = undefinedToNull(obj.parentId)
	return CryptoActorStub(
		id = id,
		rev = rev,
		hcPartyKeys = hcPartyKeys,
		aesExchangeKeys = aesExchangeKeys,
		transferKeys = transferKeys,
		privateKeyShamirPartitions = privateKeyShamirPartitions,
		publicKey = publicKey,
		publicKeysForOaepWithSha256 = publicKeysForOaepWithSha256,
		tags = tags,
		parentId = parentId,
	)
}

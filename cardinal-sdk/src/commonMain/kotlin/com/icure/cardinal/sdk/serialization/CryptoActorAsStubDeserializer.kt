package com.icure.cardinal.sdk.serialization

import com.icure.cardinal.sdk.model.CryptoActorStub
import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.CryptoActor
import com.icure.cardinal.sdk.model.specializations.AesExchangeKeyEncryptionKeypairIdentifier
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.jsonObject

/**
 * A deserializer that always deserializes an EntityWithTypeInfo<*> always using stubs for the entity.
 */
@InternalIcureApi
object CryptoActorAsStubDeserializer : KSerializer<CryptoActor> {
	override val descriptor: SerialDescriptor = buildClassSerialDescriptor("CryptoActorStub") {
		element<String>("id")
		element<String>("rev")
		element<Map<String, List<HexString>>>("hcPartyKeys")
		element<Map<SpkiHexString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>>("aesExchangeKeys")
		element<Map<AesExchangeKeyEncryptionKeypairIdentifier, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>("transferKeys")
		element<Map<String, HexString>>("privateKeyShamirPartitions")
		element<SpkiHexString>("publicKey")
		element<Set<SpkiHexString>>("publicKeysForOaepWithSha256")
		element<Set<CodeStub>>("tags")
	}

	override fun deserialize(decoder: Decoder): CryptoActor {
		if (decoder !is JsonDecoder) throw SerializationException("This serializer only supports json deserialization")
		val jsonObject = decoder.decodeJsonElement().jsonObject
		return CryptoActorStub(
			id = jsonObject["id"]?.let {
				decoder.json.decodeFromJsonElement(it)
			} ?: throw SerializationException("Missing value for id"),
			rev = jsonObject["rev"]?.let {
				decoder.json.decodeFromJsonElement(it)
			} ?: throw SerializationException("Missing value for rev"),
			hcPartyKeys = jsonObject["hcPartyKeys"]?.let {
				decoder.json.decodeFromJsonElement(it)
			} ?: emptyMap(),
			aesExchangeKeys = jsonObject["aesExchangeKeys"]?.let {
				decoder.json.decodeFromJsonElement(it)
			} ?: emptyMap(),
			transferKeys = jsonObject["transferKeys"]?.let {
				decoder.json.decodeFromJsonElement(it)
			} ?: emptyMap(),
			privateKeyShamirPartitions = jsonObject["privateKeyShamirPartitions"]?.let {
				decoder.json.decodeFromJsonElement(it)
			} ?: emptyMap(),
			publicKey = jsonObject["publicKey"]?.let {
				decoder.json.decodeFromJsonElement(it)
			},
			publicKeysForOaepWithSha256 = jsonObject["publicKeysForOaepWithSha256"]?.let {
				decoder.json.decodeFromJsonElement(it)
			} ?: throw SerializationException("Missing value for publicKeysForOaepWithSha256"),
			tags = jsonObject["tags"]?.let {
				decoder.json.decodeFromJsonElement(it)
			} ?: emptySet(),
			cryptoActorProperties = jsonObject["cryptoActorProperties"]?.let {
				decoder.json.decodeFromJsonElement(it)
			},
		)
	}

	override fun serialize(encoder: Encoder, value: CryptoActor) {
		throw UnsupportedOperationException("CryptoActor can only be deserialized")
	}
}

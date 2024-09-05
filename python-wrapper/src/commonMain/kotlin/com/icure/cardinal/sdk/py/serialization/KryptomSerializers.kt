package com.icure.cardinal.sdk.py.serialization

import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

// These serializers can safely use the defaultCryptoService since on python we never need to override it
// The keys will be encoded to the base64 of their canonical representation

class RsaKeypairSerializer<A : RsaAlgorithm>(val algorithmSerializer: KSerializer<A>) : KSerializer<RsaKeypair<A>> {
	override fun deserialize(decoder: Decoder): RsaKeypair<A> {
		TODO("Will be implemented in future")
	}

	override val descriptor: SerialDescriptor
		get() = TODO("Will be implemented in future")

	override fun serialize(encoder: Encoder, value: RsaKeypair<A>) {
		TODO("Will be implemented in future")
	}
}

object RsaEncryptionAlgorithmSerializer : KSerializer<RsaAlgorithm.RsaEncryptionAlgorithm> {
	override fun deserialize(decoder: Decoder): RsaAlgorithm.RsaEncryptionAlgorithm {
		TODO("Will be implemented in future")
	}

	override val descriptor: SerialDescriptor
		get() = TODO("Will be implemented in future")

	override fun serialize(encoder: Encoder, value: RsaAlgorithm.RsaEncryptionAlgorithm) {
		TODO("Will be implemented in future")
	}
}
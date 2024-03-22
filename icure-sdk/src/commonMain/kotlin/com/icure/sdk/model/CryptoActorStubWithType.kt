package com.icure.sdk.model

import kotlinx.serialization.Serializable

@Serializable
data class CryptoActorStubWithType(
	val type: DataOwnerType,
	val stub: CryptoActorStub
)

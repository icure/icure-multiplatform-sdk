package com.icure.sdk.model

sealed interface DataOwnerWithType {
	val type: DataOwnerType
	// TODO val dataOwner: CryptoActor (or something like that)
	// TODO implementations
}
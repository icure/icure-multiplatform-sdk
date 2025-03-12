package com.icure.cardinal.sdk.crypto.entities

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract
import kotlin.jvm.JvmInline

@JvmInline
value class SdkBoundGroup(
	val groupId: String
)

@OptIn(ExperimentalContracts::class)
fun SdkBoundGroup?.resolve(groupId: String?): String? {
	contract {
		returnsNotNull() implies (this@resolve != null)
	}
	return when {
		this == null -> {
			require(groupId == null) {
				"Can't use in-group methods on kraken-lite"
			}
			null
		}

		this.groupId == groupId ->
			null

		else ->
			groupId
	}
}

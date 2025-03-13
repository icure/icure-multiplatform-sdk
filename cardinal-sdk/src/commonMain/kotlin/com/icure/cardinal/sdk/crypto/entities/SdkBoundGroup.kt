package com.icure.cardinal.sdk.crypto.entities

import com.icure.utils.InternalIcureApi
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract
import kotlin.jvm.JvmInline

@JvmInline
@InternalIcureApi
value class SdkBoundGroup(
	val groupId: String
)

@InternalIcureApi
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

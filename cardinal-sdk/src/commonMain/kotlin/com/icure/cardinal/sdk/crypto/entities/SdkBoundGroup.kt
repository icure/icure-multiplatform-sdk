package com.icure.cardinal.sdk.crypto.entities

import kotlin.jvm.JvmInline

@JvmInline
value class SdkBoundGroup(
	val groupId: String
)

fun SdkBoundGroup?.resolve(groupId: String?): String? = when {
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

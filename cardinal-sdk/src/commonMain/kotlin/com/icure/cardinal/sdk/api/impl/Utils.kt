package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.crypto.entities.DataOwnerReferenceInGroup

fun <T> Map<String, T>.keyAsLocalDataOwnerReferences() =
	mapKeys { DataOwnerReferenceInGroup(it.key, null) }

fun Set<String>.asLocalDataOwnerReferences(): Set<DataOwnerReferenceInGroup> =
	mapTo(mutableSetOf()) { DataOwnerReferenceInGroup(it, null) }
package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.model.EntityReferenceInGroup

fun <T> Map<String, T>.keyAsLocalDataOwnerReferences() =
	mapKeys { EntityReferenceInGroup(it.key, null) }

fun Set<String>.asLocalDataOwnerReferences(): Set<EntityReferenceInGroup> =
	mapTo(mutableSetOf()) { EntityReferenceInGroup(it, null) }
package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.utils.ensure
import com.icure.utils.InternalIcureApi

internal fun <T> Map<String, T>.keyAsLocalDataOwnerReferences() =
	mapKeys { EntityReferenceInGroup(it.key, null) }

internal fun Set<String>.asLocalDataOwnerReferences(): Set<EntityReferenceInGroup> =
	mapTo(mutableSetOf()) { EntityReferenceInGroup(it, null) }

@InternalIcureApi
internal inline fun <E, T> List<GroupScoped<E>>.mapChunkedByGroup(mapChunk: (groupId: String, entities: List<E>) -> List<T>): List<GroupScoped<T>> {
	val chunksByGroupWithSourceIndex = this.withIndex().groupBy { it.value.groupId }
	val res = ArrayList<GroupScoped<T>>(this.size)
	chunksByGroupWithSourceIndex.map { (groupId, chunk) ->
		val mappedChunk = mapChunk(groupId, chunk.map { it.value.entity })
		ensure(mappedChunk.size == chunk.size) {
			"Group scoped entities mapped chunk size doesn't match source"
		}
		mappedChunk.forEachIndexed { chunkIndex, mappedItem ->
			res[chunk[chunkIndex].index] = GroupScoped(mappedItem, groupId)
		}
	}
	return res
}
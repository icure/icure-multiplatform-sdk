// auto-generated file
package com.icure.sdk.js.api.`impl`

import com.icure.sdk.api.ICureApi
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.sdk.js.api.ICureApiJs
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.IdWithRevJs
import com.icure.sdk.js.model.IndexingInfoJs
import com.icure.sdk.js.model.ReplicationInfoJs
import com.icure.sdk.js.model.couchdb.ReplicatorDocumentJs
import com.icure.sdk.js.model.couchdb.replicatorDocument_toJs
import com.icure.sdk.js.model.idWithRev_toJs
import com.icure.sdk.js.model.indexingInfo_toJs
import com.icure.sdk.js.model.replicationInfo_toJs
import com.icure.sdk.model.IdWithRev
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class ICureApiImplJs(
	private val iCureApi: ICureApi,
) : ICureApiJs {
	override fun getVersion(): Promise<String> = GlobalScope.promise {
		val result = iCureApi.getVersion(
		)
		result
	}

	override fun isReady(): Promise<String> = GlobalScope.promise {
		val result = iCureApi.isReady(
		)
		result
	}

	override fun getProcessInfo(): Promise<String> = GlobalScope.promise {
		val result = iCureApi.getProcessInfo(
		)
		result
	}

	override fun getIndexingInfo(): Promise<IndexingInfoJs> = GlobalScope.promise {
		val result = iCureApi.getIndexingInfo(
		)
		indexingInfo_toJs(result)
	}

	override fun getReplicationInfo(): Promise<ReplicationInfoJs> = GlobalScope.promise {
		val result = iCureApi.getReplicationInfo(
		)
		replicationInfo_toJs(result)
	}

	override fun updateDesignDoc(entityName: String, options: dynamic): Promise<Boolean> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val entityNameConverted: String = entityName
			val warmupConverted: Boolean? = convertingOptionOrDefaultNullable(
				_options,
				"warmup",
				null
			) { warmup: Boolean? ->
				warmup
			}
			val result = iCureApi.updateDesignDoc(
				entityNameConverted,
				warmupConverted,
			)
			result
		}
	}

	override fun resolvePatientsConflicts(options: dynamic): Promise<Array<IdWithRevJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
				numberToInt(limit, "limit")
			}
			val result = iCureApi.resolvePatientsConflicts(
				limitConverted,
			)
			listToArray(
				result,
				{ x1: IdWithRev ->
					idWithRev_toJs(x1)
				},
			)
		}
	}

	override fun resolveContactsConflicts(options: dynamic): Promise<Array<IdWithRevJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
				numberToInt(limit, "limit")
			}
			val result = iCureApi.resolveContactsConflicts(
				limitConverted,
			)
			listToArray(
				result,
				{ x1: IdWithRev ->
					idWithRev_toJs(x1)
				},
			)
		}
	}

	override fun resolveFormsConflicts(options: dynamic): Promise<Array<IdWithRevJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
				numberToInt(limit, "limit")
			}
			val result = iCureApi.resolveFormsConflicts(
				limitConverted,
			)
			listToArray(
				result,
				{ x1: IdWithRev ->
					idWithRev_toJs(x1)
				},
			)
		}
	}

	override fun resolveHealthElementsConflicts(options: dynamic): Promise<Array<IdWithRevJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
				numberToInt(limit, "limit")
			}
			val result = iCureApi.resolveHealthElementsConflicts(
				limitConverted,
			)
			listToArray(
				result,
				{ x1: IdWithRev ->
					idWithRev_toJs(x1)
				},
			)
		}
	}

	override fun resolveInvoicesConflicts(options: dynamic): Promise<Array<IdWithRevJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
				numberToInt(limit, "limit")
			}
			val result = iCureApi.resolveInvoicesConflicts(
				limitConverted,
			)
			listToArray(
				result,
				{ x1: IdWithRev ->
					idWithRev_toJs(x1)
				},
			)
		}
	}

	override fun resolveMessagesConflicts(options: dynamic): Promise<Array<IdWithRevJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
				numberToInt(limit, "limit")
			}
			val result = iCureApi.resolveMessagesConflicts(
				limitConverted,
			)
			listToArray(
				result,
				{ x1: IdWithRev ->
					idWithRev_toJs(x1)
				},
			)
		}
	}

	override fun resolveDocumentsConflicts(options: dynamic): Promise<Array<IdWithRevJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val idsConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"ids",
				null
			) { ids: String? ->
				ids
			}
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
				numberToInt(limit, "limit")
			}
			val result = iCureApi.resolveDocumentsConflicts(
				idsConverted,
				limitConverted,
			)
			listToArray(
				result,
				{ x1: IdWithRev ->
					idWithRev_toJs(x1)
				},
			)
		}
	}

	override fun getIndexingInfoByGroup(groupId: String): Promise<IndexingInfoJs> =
			GlobalScope.promise {
		val groupIdConverted: String = groupId
		val result = iCureApi.getIndexingInfoByGroup(
			groupIdConverted,
		)
		indexingInfo_toJs(result)
	}

	override fun getReplicatorInfo(id: String): Promise<ReplicatorDocumentJs> = GlobalScope.promise {
		val idConverted: String = id
		val result = iCureApi.getReplicatorInfo(
			idConverted,
		)
		replicatorDocument_toJs(result)
	}

	override fun evictAllFromMap(mapName: String): Promise<String> = GlobalScope.promise {
		val mapNameConverted: String = mapName
		val result = iCureApi.evictAllFromMap(
			mapNameConverted,
		)
		result
	}
}

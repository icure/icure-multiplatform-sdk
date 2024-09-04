// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.HealthcarePartyApi
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.api.HealthcarePartyApiJs
import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.baseFilterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.baseSortableFilterOptions_fromJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.DataOwnerRegistrationSuccessJs
import com.icure.cardinal.sdk.js.model.HealthcarePartyJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.PublicKeyJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.cardinal.sdk.js.model.dataOwnerRegistrationSuccess_toJs
import com.icure.cardinal.sdk.js.model.healthcareParty_fromJs
import com.icure.cardinal.sdk.js.model.healthcareParty_toJs
import com.icure.cardinal.sdk.js.model.paginatedList_toJs
import com.icure.cardinal.sdk.js.model.publicKey_toJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.HealthcareParty
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.collections.List
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class HealthcarePartyApiImplJs(
	private val healthcarePartyApi: HealthcarePartyApi,
) : HealthcarePartyApiJs {
	override fun getHealthcareParty(deviceId: String): Promise<HealthcarePartyJs> =
			GlobalScope.promise {
		val deviceIdConverted: String = deviceId
		val result = healthcarePartyApi.getHealthcareParty(
			deviceIdConverted,
		)
		healthcareParty_toJs(result)
	}

	override fun createHealthcareParty(p: HealthcarePartyJs): Promise<HealthcarePartyJs> =
			GlobalScope.promise {
		val pConverted: HealthcareParty = healthcareParty_fromJs(p)
		val result = healthcarePartyApi.createHealthcareParty(
			pConverted,
		)
		healthcareParty_toJs(result)
	}

	override fun deleteHealthcareParty(deviceId: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		val deviceIdConverted: String = deviceId
		val result = healthcarePartyApi.deleteHealthcareParty(
			deviceIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun modifyHealthcarePartyInGroup(groupId: String, device: HealthcarePartyJs):
			Promise<HealthcarePartyJs> = GlobalScope.promise {
		val groupIdConverted: String = groupId
		val deviceConverted: HealthcareParty = healthcareParty_fromJs(device)
		val result = healthcarePartyApi.modifyHealthcarePartyInGroup(
			groupIdConverted,
			deviceConverted,
		)
		healthcareParty_toJs(result)
	}

	override fun createHealthcarePartyInGroup(groupId: String, device: HealthcarePartyJs):
			Promise<HealthcarePartyJs> = GlobalScope.promise {
		val groupIdConverted: String = groupId
		val deviceConverted: HealthcareParty = healthcareParty_fromJs(device)
		val result = healthcarePartyApi.createHealthcarePartyInGroup(
			groupIdConverted,
			deviceConverted,
		)
		healthcareParty_toJs(result)
	}

	override fun getCurrentHealthcareParty(): Promise<HealthcarePartyJs> = GlobalScope.promise {
		val result = healthcarePartyApi.getCurrentHealthcareParty(
		)
		healthcareParty_toJs(result)
	}

	override fun findHealthcarePartiesBy(options: dynamic):
			Promise<PaginatedListJs<HealthcarePartyJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val startKeyConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startKey",
				null
			) { startKey: String? ->
				undefinedToNull(startKey)
			}
			val startDocumentIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startDocumentId",
				null
			) { startDocumentId: String? ->
				undefinedToNull(startDocumentId)
			}
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
				numberToInt(limit, "limit")
			}
			val descConverted: Boolean? = convertingOptionOrDefaultNullable(
				_options,
				"desc",
				null
			) { desc: Boolean? ->
				undefinedToNull(desc)
			}
			val result = healthcarePartyApi.findHealthcarePartiesBy(
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
				descConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: HealthcareParty ->
					healthcareParty_toJs(x1)
				},
			)
		}
	}

	override fun findHealthcarePartiesByName(options: dynamic):
			Promise<PaginatedListJs<HealthcarePartyJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val nameConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"name",
				null
			) { name: String? ->
				undefinedToNull(name)
			}
			val startKeyConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startKey",
				null
			) { startKey: String? ->
				undefinedToNull(startKey)
			}
			val startDocumentIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startDocumentId",
				null
			) { startDocumentId: String? ->
				undefinedToNull(startDocumentId)
			}
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
				numberToInt(limit, "limit")
			}
			val descConverted: Boolean? = convertingOptionOrDefaultNullable(
				_options,
				"desc",
				null
			) { desc: Boolean? ->
				undefinedToNull(desc)
			}
			val result = healthcarePartyApi.findHealthcarePartiesByName(
				nameConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
				descConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: HealthcareParty ->
					healthcareParty_toJs(x1)
				},
			)
		}
	}

	override fun findHealthcarePartiesBySsinOrNihii(searchValue: String, options: dynamic):
			Promise<PaginatedListJs<HealthcarePartyJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val searchValueConverted: String = searchValue
			val startKeyConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startKey",
				null
			) { startKey: String? ->
				undefinedToNull(startKey)
			}
			val startDocumentIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startDocumentId",
				null
			) { startDocumentId: String? ->
				undefinedToNull(startDocumentId)
			}
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
				numberToInt(limit, "limit")
			}
			val descConverted: Boolean = convertingOptionOrDefaultNonNull(
				_options,
				"desc",
				false
			) { desc: Boolean ->
				desc
			}
			val result = healthcarePartyApi.findHealthcarePartiesBySsinOrNihii(
				searchValueConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
				descConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: HealthcareParty ->
					healthcareParty_toJs(x1)
				},
			)
		}
	}

	override fun listHealthcarePartiesByName(name: String): Promise<Array<HealthcarePartyJs>> =
			GlobalScope.promise {
		val nameConverted: String = name
		val result = healthcarePartyApi.listHealthcarePartiesByName(
			nameConverted,
		)
		listToArray(
			result,
			{ x1: HealthcareParty ->
				healthcareParty_toJs(x1)
			},
		)
	}

	override fun findHealthcarePartiesBySpecialityAndPostCode(
		type: String,
		spec: String,
		firstCode: String,
		lastCode: String,
		options: dynamic,
	): Promise<PaginatedListJs<HealthcarePartyJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val typeConverted: String = type
			val specConverted: String = spec
			val firstCodeConverted: String = firstCode
			val lastCodeConverted: String = lastCode
			val startKeyConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startKey",
				null
			) { startKey: String? ->
				undefinedToNull(startKey)
			}
			val startDocumentIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startDocumentId",
				null
			) { startDocumentId: String? ->
				undefinedToNull(startDocumentId)
			}
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
				numberToInt(limit, "limit")
			}
			val result = healthcarePartyApi.findHealthcarePartiesBySpecialityAndPostCode(
				typeConverted,
				specConverted,
				firstCodeConverted,
				lastCodeConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: HealthcareParty ->
					healthcareParty_toJs(x1)
				},
			)
		}
	}

	override fun getHealthcareParties(healthcarePartyIds: Array<String>):
			Promise<Array<HealthcarePartyJs>> = GlobalScope.promise {
		val healthcarePartyIdsConverted: List<String> = arrayToList(
			healthcarePartyIds,
			"healthcarePartyIds",
			{ x1: String ->
				x1
			},
		)
		val result = healthcarePartyApi.getHealthcareParties(
			healthcarePartyIdsConverted,
		)
		listToArray(
			result,
			{ x1: HealthcareParty ->
				healthcareParty_toJs(x1)
			},
		)
	}

	override fun listHealthcarePartiesByParentId(parentId: String): Promise<Array<HealthcarePartyJs>> =
			GlobalScope.promise {
		val parentIdConverted: String = parentId
		val result = healthcarePartyApi.listHealthcarePartiesByParentId(
			parentIdConverted,
		)
		listToArray(
			result,
			{ x1: HealthcareParty ->
				healthcareParty_toJs(x1)
			},
		)
	}

	override fun getPublicKey(healthcarePartyId: String): Promise<PublicKeyJs> = GlobalScope.promise {
		val healthcarePartyIdConverted: String = healthcarePartyId
		val result = healthcarePartyApi.getPublicKey(
			healthcarePartyIdConverted,
		)
		publicKey_toJs(result)
	}

	override fun deleteHealthcareParties(healthcarePartyIds: Array<String>):
			Promise<Array<DocIdentifierJs>> = GlobalScope.promise {
		val healthcarePartyIdsConverted: List<String> = arrayToList(
			healthcarePartyIds,
			"healthcarePartyIds",
			{ x1: String ->
				x1
			},
		)
		val result = healthcarePartyApi.deleteHealthcareParties(
			healthcarePartyIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun modifyHealthcareParty(healthcarePartyDto: HealthcarePartyJs):
			Promise<HealthcarePartyJs> = GlobalScope.promise {
		val healthcarePartyDtoConverted: HealthcareParty = healthcareParty_fromJs(healthcarePartyDto)
		val result = healthcarePartyApi.modifyHealthcareParty(
			healthcarePartyDtoConverted,
		)
		healthcareParty_toJs(result)
	}

	override fun matchHealthcarePartiesBy(filter: BaseFilterOptionsJs<HealthcarePartyJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<HealthcareParty> = baseFilterOptions_fromJs(filter)
		val result = healthcarePartyApi.matchHealthcarePartiesBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun filterHealthPartiesBy(filter: BaseFilterOptionsJs<HealthcarePartyJs>):
			Promise<PaginatedListIteratorJs<HealthcarePartyJs>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<HealthcareParty> = baseFilterOptions_fromJs(filter)
		val result = healthcarePartyApi.filterHealthPartiesBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: HealthcareParty ->
				healthcareParty_toJs(x1)
			},
		)
	}

	override
			fun matchHealthcarePartiesBySorted(filter: BaseSortableFilterOptionsJs<HealthcarePartyJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<HealthcareParty> =
				baseSortableFilterOptions_fromJs(filter)
		val result = healthcarePartyApi.matchHealthcarePartiesBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun filterHealthPartiesBySorted(filter: BaseSortableFilterOptionsJs<HealthcarePartyJs>):
			Promise<PaginatedListIteratorJs<HealthcarePartyJs>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<HealthcareParty> =
				baseSortableFilterOptions_fromJs(filter)
		val result = healthcarePartyApi.filterHealthPartiesBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: HealthcareParty ->
				healthcareParty_toJs(x1)
			},
		)
	}

	override fun getHealthcarePartiesInGroup(groupId: String, options: dynamic):
			Promise<Array<HealthcarePartyJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val groupIdConverted: String = groupId
			val healthcarePartyIdsConverted: List<String>? = convertingOptionOrDefaultNullable(
				_options,
				"healthcarePartyIds",
				null
			) { healthcarePartyIds: Array<String>? ->
				arrayToList(
					healthcarePartyIds,
					"healthcarePartyIds",
					{ x1: String ->
						x1
					},
				)
			}
			val result = healthcarePartyApi.getHealthcarePartiesInGroup(
				groupIdConverted,
				healthcarePartyIdsConverted,
			)
			listToArray(
				result,
				{ x1: HealthcareParty ->
					healthcareParty_toJs(x1)
				},
			)
		}
	}

	override fun deleteHealthcarePartiesInGroup(groupId: String, healthcarePartyIds: Array<String>):
			Promise<Array<DocIdentifierJs>> = GlobalScope.promise {
		val groupIdConverted: String = groupId
		val healthcarePartyIdsConverted: List<String> = arrayToList(
			healthcarePartyIds,
			"healthcarePartyIds",
			{ x1: String ->
				x1
			},
		)
		val result = healthcarePartyApi.deleteHealthcarePartiesInGroup(
			groupIdConverted,
			healthcarePartyIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun deleteHealthcarePartyInGroup(healthcarePartyId: String, groupId: String):
			Promise<DocIdentifierJs> = GlobalScope.promise {
		val healthcarePartyIdConverted: String = healthcarePartyId
		val groupIdConverted: String = groupId
		val result = healthcarePartyApi.deleteHealthcarePartyInGroup(
			healthcarePartyIdConverted,
			groupIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun registerPatient(
		groupId: String,
		hcp: HealthcarePartyJs,
		options: dynamic,
	): Promise<DataOwnerRegistrationSuccessJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val groupIdConverted: String = groupId
			val parentHcPartyIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"parentHcPartyId",
				null
			) { parentHcPartyId: String? ->
				undefinedToNull(parentHcPartyId)
			}
			val tokenConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"token",
				null
			) { token: String? ->
				undefinedToNull(token)
			}
			val useShortTokenConverted: Boolean? = convertingOptionOrDefaultNullable(
				_options,
				"useShortToken",
				null
			) { useShortToken: Boolean? ->
				undefinedToNull(useShortToken)
			}
			val hcpConverted: HealthcareParty = healthcareParty_fromJs(hcp)
			val result = healthcarePartyApi.registerPatient(
				groupIdConverted,
				parentHcPartyIdConverted,
				tokenConverted,
				useShortTokenConverted,
				hcpConverted,
			)
			dataOwnerRegistrationSuccess_toJs(result)
		}
	}
}

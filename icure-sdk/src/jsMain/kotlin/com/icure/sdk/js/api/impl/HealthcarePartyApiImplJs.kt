// auto-generated file
package com.icure.sdk.js.api.`impl`

import com.icure.sdk.api.HealthcarePartyApi
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefault
import com.icure.sdk.js.api.HealthcarePartyApiJs
import com.icure.sdk.js.api.HealthcarePartyApi_filterHealthPartiesBy_Options
import com.icure.sdk.js.api.HealthcarePartyApi_findHealthcarePartiesByName_Options
import com.icure.sdk.js.api.HealthcarePartyApi_findHealthcarePartiesBySpecialityAndPostCode_Options
import com.icure.sdk.js.api.HealthcarePartyApi_findHealthcarePartiesBySsinOrNihii_Options
import com.icure.sdk.js.api.HealthcarePartyApi_findHealthcarePartiesBy_Options
import com.icure.sdk.js.api.HealthcarePartyApi_getHealthcarePartiesInGroup_Options
import com.icure.sdk.js.api.HealthcarePartyApi_registerPatient_Options
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.DataOwnerRegistrationSuccessJs
import com.icure.sdk.js.model.HealthcarePartyJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.PublicKeyJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.dataOwnerRegistrationSuccess_toJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.abstractFilter_fromJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.model.filter.chain.filterChain_fromJs
import com.icure.sdk.js.model.healthcareParty_fromJs
import com.icure.sdk.js.model.healthcareParty_toJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.js.model.publicKey_toJs
import com.icure.sdk.model.HealthcareParty
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import kotlin.Array
import kotlin.Boolean
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

	override fun findHealthcarePartiesBy(options: HealthcarePartyApi_findHealthcarePartiesBy_Options?):
			Promise<PaginatedListJs<HealthcarePartyJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val startKeyConverted: String? = convertingOptionOrDefault(
				_options.startKey,
				null
			) { startKey ->
				startKey
			}
			val startDocumentIdConverted: String? = convertingOptionOrDefault(
				_options.startDocumentId,
				null
			) { startDocumentId ->
				startDocumentId
			}
			val limitConverted: Int? = convertingOptionOrDefault(
				_options.limit,
				null
			) { limit ->
				numberToInt(limit, "limit")
			}
			val descConverted: Boolean? = convertingOptionOrDefault(
				_options.desc,
				null
			) { desc ->
				desc
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

	override
			fun findHealthcarePartiesByName(options: HealthcarePartyApi_findHealthcarePartiesByName_Options?):
			Promise<PaginatedListJs<HealthcarePartyJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val nameConverted: String? = convertingOptionOrDefault(
				_options.name,
				null
			) { name ->
				name
			}
			val startKeyConverted: String? = convertingOptionOrDefault(
				_options.startKey,
				null
			) { startKey ->
				startKey
			}
			val startDocumentIdConverted: String? = convertingOptionOrDefault(
				_options.startDocumentId,
				null
			) { startDocumentId ->
				startDocumentId
			}
			val limitConverted: Int? = convertingOptionOrDefault(
				_options.limit,
				null
			) { limit ->
				numberToInt(limit, "limit")
			}
			val descConverted: Boolean? = convertingOptionOrDefault(
				_options.desc,
				null
			) { desc ->
				desc
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

	override fun findHealthcarePartiesBySsinOrNihii(searchValue: String,
			options: HealthcarePartyApi_findHealthcarePartiesBySsinOrNihii_Options?):
			Promise<PaginatedListJs<HealthcarePartyJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val searchValueConverted: String = searchValue
			val startKeyConverted: String? = convertingOptionOrDefault(
				_options.startKey,
				null
			) { startKey ->
				startKey
			}
			val startDocumentIdConverted: String? = convertingOptionOrDefault(
				_options.startDocumentId,
				null
			) { startDocumentId ->
				startDocumentId
			}
			val limitConverted: Int? = convertingOptionOrDefault(
				_options.limit,
				null
			) { limit ->
				numberToInt(limit, "limit")
			}
			val descConverted: Boolean = convertingOptionOrDefault(
				_options.desc,
				false
			) { desc ->
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
		options: HealthcarePartyApi_findHealthcarePartiesBySpecialityAndPostCode_Options?,
	): Promise<PaginatedListJs<HealthcarePartyJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val typeConverted: String = type
			val specConverted: String = spec
			val firstCodeConverted: String = firstCode
			val lastCodeConverted: String = lastCode
			val startKeyConverted: String? = convertingOptionOrDefault(
				_options.startKey,
				null
			) { startKey ->
				startKey
			}
			val startDocumentIdConverted: String? = convertingOptionOrDefault(
				_options.startDocumentId,
				null
			) { startDocumentId ->
				startDocumentId
			}
			val limitConverted: Int? = convertingOptionOrDefault(
				_options.limit,
				null
			) { limit ->
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

	override fun matchHealthcarePartiesBy(filter: AbstractFilterJs<HealthcarePartyJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: AbstractFilter<HealthcareParty> = abstractFilter_fromJs(
			filter,
			{ x1: HealthcarePartyJs ->
				healthcareParty_fromJs(x1)
			},
		)
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

	override fun filterHealthPartiesBy(filterChain: FilterChainJs<HealthcarePartyJs>,
			options: HealthcarePartyApi_filterHealthPartiesBy_Options?):
			Promise<PaginatedListJs<HealthcarePartyJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val startDocumentIdConverted: String? = convertingOptionOrDefault(
				_options.startDocumentId,
				null
			) { startDocumentId ->
				startDocumentId
			}
			val limitConverted: Int? = convertingOptionOrDefault(
				_options.limit,
				null
			) { limit ->
				numberToInt(limit, "limit")
			}
			val filterChainConverted: FilterChain<HealthcareParty> = filterChain_fromJs(
				filterChain,
				{ x1: HealthcarePartyJs ->
					healthcareParty_fromJs(x1)
				},
			)
			val result = healthcarePartyApi.filterHealthPartiesBy(
				startDocumentIdConverted,
				limitConverted,
				filterChainConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: HealthcareParty ->
					healthcareParty_toJs(x1)
				},
			)
		}
	}

	override fun getHealthcarePartiesInGroup(groupId: String,
			options: HealthcarePartyApi_getHealthcarePartiesInGroup_Options?):
			Promise<Array<HealthcarePartyJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val groupIdConverted: String = groupId
			val healthcarePartyIdsConverted: List<String>? = convertingOptionOrDefault(
				_options.healthcarePartyIds,
				null
			) { healthcarePartyIds ->
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
		options: HealthcarePartyApi_registerPatient_Options?,
	): Promise<DataOwnerRegistrationSuccessJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val groupIdConverted: String = groupId
			val parentHcPartyIdConverted: String? = convertingOptionOrDefault(
				_options.parentHcPartyId,
				null
			) { parentHcPartyId ->
				parentHcPartyId
			}
			val tokenConverted: String? = convertingOptionOrDefault(
				_options.token,
				null
			) { token ->
				token
			}
			val useShortTokenConverted: Boolean? = convertingOptionOrDefault(
				_options.useShortToken,
				null
			) { useShortToken ->
				useShortToken
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

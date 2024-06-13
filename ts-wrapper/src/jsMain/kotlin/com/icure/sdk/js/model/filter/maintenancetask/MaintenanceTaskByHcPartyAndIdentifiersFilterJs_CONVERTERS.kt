package com.icure.sdk.js.model.filter.maintenancetask

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.js.model.base.IdentifierJs
import com.icure.sdk.js.model.base.identifier_fromJs
import com.icure.sdk.js.model.base.identifier_toJs
import com.icure.sdk.model.base.Identifier
import com.icure.sdk.model.filter.maintenancetask.MaintenanceTaskByHcPartyAndIdentifiersFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public
		fun maintenanceTaskByHcPartyAndIdentifiersFilter_toJs(obj: MaintenanceTaskByHcPartyAndIdentifiersFilter):
		MaintenanceTaskByHcPartyAndIdentifiersFilterJs {
	val healthcarePartyId = nullToUndefined(
		obj.healthcarePartyId
	)
	val identifiers = listToArray(
		obj.identifiers,
		{ x1: Identifier ->
			identifier_toJs(x1)
		},
	)
	val desc = nullToUndefined(
		obj.desc
	)
	return MaintenanceTaskByHcPartyAndIdentifiersFilterJs(js("{" +
		"healthcarePartyId:healthcarePartyId," +
		"identifiers:identifiers," +
		"desc:desc" +
	"}"))
}

public
		fun maintenanceTaskByHcPartyAndIdentifiersFilter_fromJs(obj: MaintenanceTaskByHcPartyAndIdentifiersFilterJs):
		MaintenanceTaskByHcPartyAndIdentifiersFilter {
	val healthcarePartyId = undefinedToNull(obj.healthcarePartyId)
	val identifiers = arrayToList(
		obj.identifiers,
		"obj.identifiers",
		{ x1: IdentifierJs ->
			identifier_fromJs(x1)
		},
	)
	val desc = undefinedToNull(obj.desc)
	return MaintenanceTaskByHcPartyAndIdentifiersFilter(
		healthcarePartyId = healthcarePartyId,
		identifiers = identifiers,
		desc = desc,
	)
}

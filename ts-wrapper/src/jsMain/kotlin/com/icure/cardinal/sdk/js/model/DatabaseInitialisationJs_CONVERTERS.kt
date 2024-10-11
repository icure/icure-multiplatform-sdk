// auto-generated file
package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.model.DatabaseInitialisation
import com.icure.cardinal.sdk.model.HealthcareParty
import com.icure.cardinal.sdk.model.User
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun databaseInitialisation_toJs(obj: DatabaseInitialisation): DatabaseInitialisationJs {
	val users = nullToUndefined(
		listToArray(
			obj.users,
			{ x1: User ->
				user_toJs(x1)
			},
		)
	)
	val healthcareParties = nullToUndefined(
		listToArray(
			obj.healthcareParties,
			{ x1: HealthcareParty ->
				healthcareParty_toJs(x1)
			},
		)
	)
	val replication = nullToUndefined(
		obj.replication?.let { nonNull1 ->
			replication_toJs(nonNull1)
		}
	)
	val minimumKrakenVersion = nullToUndefined(
		obj.minimumKrakenVersion
	)
	return DatabaseInitialisationJs(js("{" +
		"users:users," +
		"healthcareParties:healthcareParties," +
		"replication:replication," +
		"minimumKrakenVersion:minimumKrakenVersion" +
	"}"))
}

public fun databaseInitialisation_fromJs(obj: DatabaseInitialisationJs): DatabaseInitialisation {
	val users = arrayToList(
		obj.users,
		"obj.users",
		{ x1: UserJs ->
			user_fromJs(x1)
		},
	)
	val healthcareParties = arrayToList(
		obj.healthcareParties,
		"obj.healthcareParties",
		{ x1: HealthcarePartyJs ->
			healthcareParty_fromJs(x1)
		},
	)
	val replication = obj.replication?.let { nonNull1 ->
		replication_fromJs(nonNull1)
	}
	val minimumKrakenVersion = undefinedToNull(obj.minimumKrakenVersion)
	return DatabaseInitialisation(
		users = users,
		healthcareParties = healthcareParties,
		replication = replication,
		minimumKrakenVersion = minimumKrakenVersion,
	)
}

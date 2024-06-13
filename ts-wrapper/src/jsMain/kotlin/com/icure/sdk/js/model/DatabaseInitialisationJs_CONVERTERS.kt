package com.icure.sdk.js.model

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.model.DatabaseInitialisation
import com.icure.sdk.model.HealthcareParty
import com.icure.sdk.model.User
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun databaseInitialisation_toJs(obj: DatabaseInitialisation): DatabaseInitialisationJs {
	val users = listToArray(
		obj.users,
		{ x1: User ->
			user_toJs(x1)
		},
	) ?: undefined
	val healthcareParties = listToArray(
		obj.healthcareParties,
		{ x1: HealthcareParty ->
			healthcareParty_toJs(x1)
		},
	) ?: undefined
	val replication = obj.replication?.let { nonNull1 ->
		replication_toJs(nonNull1)
	} ?: undefined
	val minimumKrakenVersion = obj.minimumKrakenVersion ?: undefined
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
	val minimumKrakenVersion = obj.minimumKrakenVersion
	return DatabaseInitialisation(
		users = users,
		healthcareParties = healthcareParties,
		replication = replication,
		minimumKrakenVersion = minimumKrakenVersion,
	)
}

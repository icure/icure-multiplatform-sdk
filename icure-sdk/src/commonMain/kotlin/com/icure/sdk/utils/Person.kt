package com.icure.sdk.utils

import com.icure.sdk.model.DecryptedPatient
import com.icure.sdk.model.EncryptedPatient
import com.icure.sdk.model.HealthcareParty
import com.icure.sdk.model.Patient
import com.icure.sdk.model.base.Person
import com.icure.sdk.model.embed.PersonName
import com.icure.sdk.model.embed.PersonNameUse

fun Person.hasName(nameUse: PersonNameUse) = names.any { it.use == nameUse }

fun Person.findName(nameUse: PersonNameUse) = names.firstOrNull { it.use == nameUse }

@Suppress("UNCHECKED_CAST")
fun <T : Person> T.garnishWithName(
	nameUse: PersonNameUse,
	lastName: String? = null,
	firstName: String? = null,
	fullName: String? = null,
): T {
	val personName = PersonName(
		lastName = lastName,
		firstNames = listOfNotNull(firstName),
		text = fullName ?: "$lastName $firstName",
		use = nameUse
	)
	return when(this) {
		is DecryptedPatient -> this.copy(names = names + personName) as T
		is HealthcareParty -> this.copy(names = names + personName) as T
		is EncryptedPatient -> this.copy(names = names + personName) as T
		else -> throw IllegalStateException("Unsupported Person implementation")
	}
}

@Suppress("UNCHECKED_CAST")
fun <T : Patient> T.withNames(firstName: String? = null, lastName: String? = null, maidenName: String? = null, alias: String? = null): T = when(this) {
	is DecryptedPatient -> copy(firstName = firstName ?: this.firstName, lastName = lastName ?: this.lastName, maidenName = maidenName ?: this.maidenName, alias = alias ?: this.alias)
	is EncryptedPatient -> copy(firstName = firstName ?: this.firstName, lastName = lastName ?: this.lastName, maidenName = maidenName ?: this.maidenName, alias = alias ?: this.alias)
	else -> throw IllegalStateException("Unsupported Person implementation")
} as T

fun HealthcareParty.completeNames(): HealthcareParty = let {
	if((!it.lastName.isNullOrBlank() || !it.name.isNullOrBlank()) && !it.hasName(PersonNameUse.Official)) {
		it.garnishWithName(PersonNameUse.Official, it.lastName, it.firstName, it.name)
	} else it
}.let {
	val officialName = it.findName(PersonNameUse.Official)
	if((!it.lastName.isNullOrBlank() || !it.name.isNullOrBlank()) && officialName != null) {
		it.copy(
			lastName = officialName.lastName,
			firstName = officialName.firstNames.firstOrNull(),
			name = officialName.text
		)
	} else it
}

fun <T : Patient> T.completeNames(): T = let {
	if(!it.lastName.isNullOrBlank() && !it.hasName(PersonNameUse.Official)) {
		it.garnishWithName(PersonNameUse.Official, it.lastName, it.firstName)
	} else it
}.let {
	if(!it.maidenName.isNullOrBlank() && !it.hasName(PersonNameUse.Maiden)) {
		it.garnishWithName(PersonNameUse.Maiden, it.maidenName, it.firstName)
	} else it
}.let {
	if(!it.alias.isNullOrBlank() && !it.hasName(PersonNameUse.Nickname)) {
		it.garnishWithName(PersonNameUse.Nickname, it.alias, it.firstName)
	} else it
}.let {
	val officialName = it.findName(PersonNameUse.Official)
	if(it.lastName.isNullOrBlank() && officialName != null) {
		it.withNames(lastName = officialName.lastName, firstName = officialName.firstNames.firstOrNull())
	} else it
}.let {
	val officialName = it.findName(PersonNameUse.Maiden)
	if(it.maidenName.isNullOrBlank() && officialName != null) {
		it.withNames(maidenName = officialName.lastName)
	} else it
}.let {
	val officialName = it.findName(PersonNameUse.Nickname)
	if(it.alias.isNullOrBlank() && officialName != null) {
		it.withNames(alias = officialName.lastName)
	} else it
}


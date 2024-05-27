package com.icure.sdk.utils

import com.icure.sdk.model.DecryptedPatient
import com.icure.sdk.model.EncryptedPatient
import com.icure.sdk.model.HealthcareParty
import com.icure.sdk.model.base.Person
import com.icure.sdk.model.embed.PersonName
import com.icure.sdk.model.embed.PersonNameUse

fun Person.hasName(nameUse: PersonNameUse) = names.any { it.use == nameUse }

fun Person.findName(nameUse: PersonNameUse) = names.firstOrNull { it.use == nameUse }

fun Person.garnishWithName(
	nameUse: PersonNameUse,
	lastName: String? = null,
	firstName: String? = null,
	fullName: String = "$lastName $firstName",
): Person {
	val personName = PersonName(
		lastName = lastName,
		firstNames = listOfNotNull(firstName),
		text = fullName,
		use = nameUse
	)
	return when(this) {
		is DecryptedPatient -> this.copy(names = names + personName)
		is HealthcareParty -> this.copy(names = names + personName)
		is EncryptedPatient -> this.copy(names = names + personName)
		else -> throw IllegalStateException("Unsupported Person class: ${this::class.qualifiedName}")
	}
}

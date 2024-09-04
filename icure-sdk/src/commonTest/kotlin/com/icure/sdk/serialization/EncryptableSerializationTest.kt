package com.icure.sdk.serialization

import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.filters.FilterOptions
import com.icure.sdk.filters.PatientFilters
import com.icure.sdk.model.DecryptedPatient
import com.icure.sdk.model.DecryptedProperty
import com.icure.sdk.model.Patient
import com.icure.sdk.model.Property
import com.icure.sdk.model.PropertyType
import com.icure.sdk.test.uuid
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.serializer

@OptIn(InternalIcureApi::class)
class EncryptableSerializationTest : StringSpec({

	"Can serialize and deserialize an Encryptable with the proper serializer" {
		val patient = DecryptedPatient(
			id = uuid(),
			note = "test"
		) as Patient
		val serialized = Serialization.fullLanguageInteropJson.encodeToString(patient)
		val deserialized = Serialization.fullLanguageInteropJson.decodeFromString<Patient>(serialized)
		deserialized shouldBe patient
	}

	"Can serialize and deserialize an Encryptable with a `type` property" {
		val property = DecryptedProperty(
			id = uuid(),
			type = PropertyType(
				id = uuid(),
				identifier = uuid()
			)
		) as Property
		val serialized = Serialization.fullLanguageInteropJson.encodeToString(property)
		val deserialized = Serialization.fullLanguageInteropJson.decodeFromString<Property>(serialized)
		deserialized shouldBe property
	}

	"Can serialize using a Polymorphic serializer" {
		val entity = PatientFilters.byNameForSelf("somestring")
		val serialized = Serialization.fullLanguageInteropJson.encodeToJsonElement(
			FilterOptions.serializer(PolymorphicSerializer(Patient::class)),
			entity
		)
		println(serialized)
	}

	"Other test" {
		@Serializable
		data class Wrapper(
			val patient: Patient
		)

		val wrapper = Wrapper(DecryptedPatient(id = uuid(), note = uuid()))
		val serialized = Serialization.fullLanguageInteropJson.encodeToString(wrapper)
		val deserialized = Serialization.fullLanguageInteropJson.decodeFromString<Wrapper>(serialized)
		println(deserialized)
	}

})

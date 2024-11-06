package com.icure.cardinal.sdk.crypto.entities

import com.icure.cardinal.sdk.api.PatientApi
import com.icure.cardinal.sdk.model.EncryptedPatient
import kotlinx.serialization.Serializable

object ShareAllPatientDataOptions {

	/**
	 * Specifies which entities related to a Patient will be shared by [PatientApi.shareAllDataOfPatient].
	 */
	@Serializable
	enum class Tag {
		All, MedicalInformation, FinancialInformation
	}

	@Serializable
	enum class ShareableEntity(val type: Tag) {
		CalendarItem(Tag.MedicalInformation),
		Contact(Tag.MedicalInformation),
		Classification(Tag.MedicalInformation),
		Document(Tag.MedicalInformation),
		Form(Tag.MedicalInformation),
		HealthElement(Tag.MedicalInformation),
		Invoice(Tag.FinancialInformation),
		Patient(Tag.All)
	}

	@Serializable
	data class EntityResult(
		val success: Boolean? = null,
		val error: SharePatientDataError? = null,
		val modified: Int = 0
	)

	@Serializable
	data class Result(
		val patient: EncryptedPatient,
		val statuses: Map<ShareableEntity, EntityResult>
	)

	@Serializable
	sealed interface SharePatientDataError

	@Serializable
	class BulkShareFailure(val errors: List<FailedRequestDetails>, val message: String) : SharePatientDataError

	@Serializable
	class FailedRequest(
		val description: String
	) : SharePatientDataError
}

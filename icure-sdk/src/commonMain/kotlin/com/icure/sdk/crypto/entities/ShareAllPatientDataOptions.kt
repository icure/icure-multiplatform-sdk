package com.icure.sdk.crypto.entities

import com.icure.sdk.api.flavoured.PatientApi
import com.icure.sdk.model.Patient

object ShareAllPatientDataOptions {

	/**
	 * Specifies which entities related to a Patient will be shared by [PatientApi.shareAllDataOfPatient].
	 */
	enum class Tag {
		All, MedicalInformation, FinancialInformation
	}

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

	data class EntityResult(
		val success: Boolean? = null,
		val error: SharePatientDataError? = null,
		val modified: Int = 0
	)

	data class Result(
		val patient: Patient,
		val statuses: Map<ShareableEntity, EntityResult>
	)

	sealed interface SharePatientDataError

	class BulkShareFailure(val errors: List<FailedRequestDetails>, val message: String) : SharePatientDataError

	class FailedRequest(val description: String) : SharePatientDataError
}

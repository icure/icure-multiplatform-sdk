package com.icure.sdk.crypto.entities

import com.icure.sdk.api.flavoured.PatientApi
import com.icure.sdk.model.DecryptedContact
import com.icure.sdk.model.DecryptedDocument
import com.icure.sdk.model.EncryptedPatient
import com.icure.sdk.model.IcureStub
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
		val error: Exception? = null,
		val modified: Int = 0
	)

	data class Result(
		val patient: Patient,
		val statuses: Map<ShareableEntity, EntityResult>
	)

	class BulkShareErrorsException(val errors: List<FailedRequestDetails>, message: String) : Exception(message)

}

object ExportDataOptions {
	data class Result(
		val id: String,
		val patient: EncryptedPatient,
		val contacts: List<DecryptedContact> = emptyList(),
		val forms: List<IcureStub> = emptyList(),
		val healthElements: List<IcureStub> = emptyList(),
		val invoices: List<IcureStub> = emptyList(),
		val classifications: List<IcureStub> = emptyList(),
		val calItems: List<IcureStub> = emptyList(),
		val documents: List<DecryptedDocument> = emptyList(),
	)
}

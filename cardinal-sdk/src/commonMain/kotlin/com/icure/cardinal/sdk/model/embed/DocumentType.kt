package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class DocumentType() {
	@SerialName("admission")
	Admission,

	@SerialName("alert")
	Alert,

	@SerialName("bvt_sample")
	BvtSample,

	@SerialName("clinicalpath")
	Clinicalpath,

	@SerialName("clinicalsummary")
	Clinicalsummary,

	@SerialName("contactreport")
	Contactreport,

	@SerialName("quote")
	Quote,

	@SerialName("invoice")
	Invoice,

	@SerialName("death")
	Death,

	@SerialName("discharge")
	Discharge,

	@SerialName("dischargereport")
	Dischargereport,

	@SerialName("ebirth_baby_medicalform")
	EbirthBabyMedicalform,

	@SerialName("ebirth_baby_notification")
	EbirthBabyNotification,

	@SerialName("ebirth_mother_medicalform")
	EbirthMotherMedicalform,

	@SerialName("ebirth_mother_notification")
	EbirthMotherNotification,

	@SerialName("ecare_safe_consultation")
	EcareSafeConsultation,

	@SerialName("epidemiology")
	Epidemiology,

	@SerialName("intervention")
	Intervention,

	@SerialName("labrequest")
	Labrequest,

	@SerialName("labresult")
	Labresult,

	@SerialName("medicaladvisoragreement")
	Medicaladvisoragreement,

	@SerialName("medicationschemeelement")
	Medicationschemeelement,

	@SerialName("note")
	Note,

	@SerialName("notification")
	Notification,

	@SerialName("pharmaceuticalprescription")
	Pharmaceuticalprescription,

	@SerialName("prescription")
	Prescription,

	@SerialName("productdelivery")
	Productdelivery,

	@SerialName("quickdischargereport")
	Quickdischargereport,

	@SerialName("radiationexposuremonitoring")
	Radiationexposuremonitoring,

	@SerialName("referral")
	Referral,

	@SerialName("report")
	Report,

	@SerialName("request")
	Request,

	@SerialName("result")
	Result,

	@SerialName("sumehr")
	Sumehr,

	@SerialName("telemonitoring")
	Telemonitoring,

	@SerialName("template")
	Template,

	@SerialName("template_admin")
	TemplateAdmin,

	@SerialName("treatmentsuspension")
	Treatmentsuspension,

	@SerialName("vaccination")
	Vaccination,
}

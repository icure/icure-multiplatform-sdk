package com.icure.sdk.js.model.embed

import com.icure.sdk.model.embed.DocumentType
import kotlin.String

public fun documentType_toJs(obj: DocumentType): String = obj.name

public fun documentType_fromJs(obj: String): DocumentType = when (obj) {
	"Admission" -> DocumentType.Admission
	"Alert" -> DocumentType.Alert
	"BvtSample" -> DocumentType.BvtSample
	"Clinicalpath" -> DocumentType.Clinicalpath
	"Clinicalsummary" -> DocumentType.Clinicalsummary
	"Contactreport" -> DocumentType.Contactreport
	"Quote" -> DocumentType.Quote
	"Invoice" -> DocumentType.Invoice
	"Death" -> DocumentType.Death
	"Discharge" -> DocumentType.Discharge
	"Dischargereport" -> DocumentType.Dischargereport
	"EbirthBabyMedicalform" -> DocumentType.EbirthBabyMedicalform
	"EbirthBabyNotification" -> DocumentType.EbirthBabyNotification
	"EbirthMotherMedicalform" -> DocumentType.EbirthMotherMedicalform
	"EbirthMotherNotification" -> DocumentType.EbirthMotherNotification
	"EcareSafeConsultation" -> DocumentType.EcareSafeConsultation
	"Epidemiology" -> DocumentType.Epidemiology
	"Intervention" -> DocumentType.Intervention
	"Labrequest" -> DocumentType.Labrequest
	"Labresult" -> DocumentType.Labresult
	"Medicaladvisoragreement" -> DocumentType.Medicaladvisoragreement
	"Medicationschemeelement" -> DocumentType.Medicationschemeelement
	"Note" -> DocumentType.Note
	"Notification" -> DocumentType.Notification
	"Pharmaceuticalprescription" -> DocumentType.Pharmaceuticalprescription
	"Prescription" -> DocumentType.Prescription
	"Productdelivery" -> DocumentType.Productdelivery
	"Quickdischargereport" -> DocumentType.Quickdischargereport
	"Radiationexposuremonitoring" -> DocumentType.Radiationexposuremonitoring
	"Referral" -> DocumentType.Referral
	"Report" -> DocumentType.Report
	"Request" -> DocumentType.Request
	"Result" -> DocumentType.Result
	"Sumehr" -> DocumentType.Sumehr
	"Telemonitoring" -> DocumentType.Telemonitoring
	"Template" -> DocumentType.Template
	"TemplateAdmin" -> DocumentType.TemplateAdmin
	"Treatmentsuspension" -> DocumentType.Treatmentsuspension
	"Vaccination" -> DocumentType.Vaccination
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.embed.DocumentType: $obj""")
}

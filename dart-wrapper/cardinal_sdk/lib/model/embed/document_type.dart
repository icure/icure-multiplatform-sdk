// This file is auto-generated


enum DocumentType {
	admission,
	alert,
	bvtSample,
	clinicalpath,
	clinicalsummary,
	contactreport,
	quote,
	invoice,
	death,
	discharge,
	dischargereport,
	ebirthBabyMedicalform,
	ebirthBabyNotification,
	ebirthMotherMedicalform,
	ebirthMotherNotification,
	ecareSafeConsultation,
	epidemiology,
	intervention,
	labrequest,
	labresult,
	medicaladvisoragreement,
	medicationschemeelement,
	note,
	notification,
	pharmaceuticalprescription,
	prescription,
	productdelivery,
	quickdischargereport,
	radiationexposuremonitoring,
	referral,
	report,
	request,
	result,
	sumehr,
	telemonitoring,
	template,
	templateAdmin,
	treatmentsuspension,
	vaccination;

	static String encode(DocumentType value) {
		switch (value) {
			case DocumentType.admission:
				return '"Admission"';
			case DocumentType.alert:
				return '"Alert"';
			case DocumentType.bvtSample:
				return '"BvtSample"';
			case DocumentType.clinicalpath:
				return '"Clinicalpath"';
			case DocumentType.clinicalsummary:
				return '"Clinicalsummary"';
			case DocumentType.contactreport:
				return '"Contactreport"';
			case DocumentType.quote:
				return '"Quote"';
			case DocumentType.invoice:
				return '"Invoice"';
			case DocumentType.death:
				return '"Death"';
			case DocumentType.discharge:
				return '"Discharge"';
			case DocumentType.dischargereport:
				return '"Dischargereport"';
			case DocumentType.ebirthBabyMedicalform:
				return '"EbirthBabyMedicalform"';
			case DocumentType.ebirthBabyNotification:
				return '"EbirthBabyNotification"';
			case DocumentType.ebirthMotherMedicalform:
				return '"EbirthMotherMedicalform"';
			case DocumentType.ebirthMotherNotification:
				return '"EbirthMotherNotification"';
			case DocumentType.ecareSafeConsultation:
				return '"EcareSafeConsultation"';
			case DocumentType.epidemiology:
				return '"Epidemiology"';
			case DocumentType.intervention:
				return '"Intervention"';
			case DocumentType.labrequest:
				return '"Labrequest"';
			case DocumentType.labresult:
				return '"Labresult"';
			case DocumentType.medicaladvisoragreement:
				return '"Medicaladvisoragreement"';
			case DocumentType.medicationschemeelement:
				return '"Medicationschemeelement"';
			case DocumentType.note:
				return '"Note"';
			case DocumentType.notification:
				return '"Notification"';
			case DocumentType.pharmaceuticalprescription:
				return '"Pharmaceuticalprescription"';
			case DocumentType.prescription:
				return '"Prescription"';
			case DocumentType.productdelivery:
				return '"Productdelivery"';
			case DocumentType.quickdischargereport:
				return '"Quickdischargereport"';
			case DocumentType.radiationexposuremonitoring:
				return '"Radiationexposuremonitoring"';
			case DocumentType.referral:
				return '"Referral"';
			case DocumentType.report:
				return '"Report"';
			case DocumentType.request:
				return '"Request"';
			case DocumentType.result:
				return '"Result"';
			case DocumentType.sumehr:
				return '"Sumehr"';
			case DocumentType.telemonitoring:
				return '"Telemonitoring"';
			case DocumentType.template:
				return '"Template"';
			case DocumentType.templateAdmin:
				return '"TemplateAdmin"';
			case DocumentType.treatmentsuspension:
				return '"Treatmentsuspension"';
			case DocumentType.vaccination:
				return '"Vaccination"';
			}
	}

}
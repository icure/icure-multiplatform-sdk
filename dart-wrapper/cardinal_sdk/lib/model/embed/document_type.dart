// auto-generated file


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
				return '"admission"';
			case DocumentType.alert:
				return '"alert"';
			case DocumentType.bvtSample:
				return '"bvt_sample"';
			case DocumentType.clinicalpath:
				return '"clinicalpath"';
			case DocumentType.clinicalsummary:
				return '"clinicalsummary"';
			case DocumentType.contactreport:
				return '"contactreport"';
			case DocumentType.quote:
				return '"quote"';
			case DocumentType.invoice:
				return '"invoice"';
			case DocumentType.death:
				return '"death"';
			case DocumentType.discharge:
				return '"discharge"';
			case DocumentType.dischargereport:
				return '"dischargereport"';
			case DocumentType.ebirthBabyMedicalform:
				return '"ebirth_baby_medicalform"';
			case DocumentType.ebirthBabyNotification:
				return '"ebirth_baby_notification"';
			case DocumentType.ebirthMotherMedicalform:
				return '"ebirth_mother_medicalform"';
			case DocumentType.ebirthMotherNotification:
				return '"ebirth_mother_notification"';
			case DocumentType.ecareSafeConsultation:
				return '"ecare_safe_consultation"';
			case DocumentType.epidemiology:
				return '"epidemiology"';
			case DocumentType.intervention:
				return '"intervention"';
			case DocumentType.labrequest:
				return '"labrequest"';
			case DocumentType.labresult:
				return '"labresult"';
			case DocumentType.medicaladvisoragreement:
				return '"medicaladvisoragreement"';
			case DocumentType.medicationschemeelement:
				return '"medicationschemeelement"';
			case DocumentType.note:
				return '"note"';
			case DocumentType.notification:
				return '"notification"';
			case DocumentType.pharmaceuticalprescription:
				return '"pharmaceuticalprescription"';
			case DocumentType.prescription:
				return '"prescription"';
			case DocumentType.productdelivery:
				return '"productdelivery"';
			case DocumentType.quickdischargereport:
				return '"quickdischargereport"';
			case DocumentType.radiationexposuremonitoring:
				return '"radiationexposuremonitoring"';
			case DocumentType.referral:
				return '"referral"';
			case DocumentType.report:
				return '"report"';
			case DocumentType.request:
				return '"request"';
			case DocumentType.result:
				return '"result"';
			case DocumentType.sumehr:
				return '"sumehr"';
			case DocumentType.telemonitoring:
				return '"telemonitoring"';
			case DocumentType.template:
				return '"template"';
			case DocumentType.templateAdmin:
				return '"template_admin"';
			case DocumentType.treatmentsuspension:
				return '"treatmentsuspension"';
			case DocumentType.vaccination:
				return '"vaccination"';
			}
	}


	static DocumentType fromJSON(String data) {
		switch (data) {
			case "admission":
				return DocumentType.admission;
			case "alert":
				return DocumentType.alert;
			case "bvt_sample":
				return DocumentType.bvtSample;
			case "clinicalpath":
				return DocumentType.clinicalpath;
			case "clinicalsummary":
				return DocumentType.clinicalsummary;
			case "contactreport":
				return DocumentType.contactreport;
			case "quote":
				return DocumentType.quote;
			case "invoice":
				return DocumentType.invoice;
			case "death":
				return DocumentType.death;
			case "discharge":
				return DocumentType.discharge;
			case "dischargereport":
				return DocumentType.dischargereport;
			case "ebirth_baby_medicalform":
				return DocumentType.ebirthBabyMedicalform;
			case "ebirth_baby_notification":
				return DocumentType.ebirthBabyNotification;
			case "ebirth_mother_medicalform":
				return DocumentType.ebirthMotherMedicalform;
			case "ebirth_mother_notification":
				return DocumentType.ebirthMotherNotification;
			case "ecare_safe_consultation":
				return DocumentType.ecareSafeConsultation;
			case "epidemiology":
				return DocumentType.epidemiology;
			case "intervention":
				return DocumentType.intervention;
			case "labrequest":
				return DocumentType.labrequest;
			case "labresult":
				return DocumentType.labresult;
			case "medicaladvisoragreement":
				return DocumentType.medicaladvisoragreement;
			case "medicationschemeelement":
				return DocumentType.medicationschemeelement;
			case "note":
				return DocumentType.note;
			case "notification":
				return DocumentType.notification;
			case "pharmaceuticalprescription":
				return DocumentType.pharmaceuticalprescription;
			case "prescription":
				return DocumentType.prescription;
			case "productdelivery":
				return DocumentType.productdelivery;
			case "quickdischargereport":
				return DocumentType.quickdischargereport;
			case "radiationexposuremonitoring":
				return DocumentType.radiationexposuremonitoring;
			case "referral":
				return DocumentType.referral;
			case "report":
				return DocumentType.report;
			case "request":
				return DocumentType.request;
			case "result":
				return DocumentType.result;
			case "sumehr":
				return DocumentType.sumehr;
			case "telemonitoring":
				return DocumentType.telemonitoring;
			case "template":
				return DocumentType.template;
			case "template_admin":
				return DocumentType.templateAdmin;
			case "treatmentsuspension":
				return DocumentType.treatmentsuspension;
			case "vaccination":
				return DocumentType.vaccination;
			default:
				throw ArgumentError('Invalid DocumentType entry value $data');
			}
	}

}
from typing import Union, Dict
from enum import Enum

class DocumentType(Enum):
	Admission = "admission"
	Alert = "alert"
	BvtSample = "bvt_sample"
	Clinicalpath = "clinicalpath"
	Clinicalsummary = "clinicalsummary"
	Contactreport = "contactreport"
	Quote = "quote"
	Invoice = "invoice"
	Death = "death"
	Discharge = "discharge"
	Dischargereport = "dischargereport"
	EbirthBabyMedicalform = "ebirth_baby_medicalform"
	EbirthBabyNotification = "ebirth_baby_notification"
	EbirthMotherMedicalform = "ebirth_mother_medicalform"
	EbirthMotherNotification = "ebirth_mother_notification"
	EcareSafeConsultation = "ecare_safe_consultation"
	Epidemiology = "epidemiology"
	Intervention = "intervention"
	Labrequest = "labrequest"
	Labresult = "labresult"
	Medicaladvisoragreement = "medicaladvisoragreement"
	Medicationschemeelement = "medicationschemeelement"
	Note = "note"
	Notification = "notification"
	Pharmaceuticalprescription = "pharmaceuticalprescription"
	Prescription = "prescription"
	Productdelivery = "productdelivery"
	Quickdischargereport = "quickdischargereport"
	Radiationexposuremonitoring = "radiationexposuremonitoring"
	Referral = "referral"
	Report = "report"
	Request = "request"
	Result = "result"
	Sumehr = "sumehr"
	Telemonitoring = "telemonitoring"
	Template = "template"
	TemplateAdmin = "template_admin"
	Treatmentsuspension = "treatmentsuspension"
	Vaccination = "vaccination"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DocumentType':
		if data == "admission":
			return DocumentType.Admission
		elif data == "alert":
			return DocumentType.Alert
		elif data == "bvt_sample":
			return DocumentType.BvtSample
		elif data == "clinicalpath":
			return DocumentType.Clinicalpath
		elif data == "clinicalsummary":
			return DocumentType.Clinicalsummary
		elif data == "contactreport":
			return DocumentType.Contactreport
		elif data == "quote":
			return DocumentType.Quote
		elif data == "invoice":
			return DocumentType.Invoice
		elif data == "death":
			return DocumentType.Death
		elif data == "discharge":
			return DocumentType.Discharge
		elif data == "dischargereport":
			return DocumentType.Dischargereport
		elif data == "ebirth_baby_medicalform":
			return DocumentType.EbirthBabyMedicalform
		elif data == "ebirth_baby_notification":
			return DocumentType.EbirthBabyNotification
		elif data == "ebirth_mother_medicalform":
			return DocumentType.EbirthMotherMedicalform
		elif data == "ebirth_mother_notification":
			return DocumentType.EbirthMotherNotification
		elif data == "ecare_safe_consultation":
			return DocumentType.EcareSafeConsultation
		elif data == "epidemiology":
			return DocumentType.Epidemiology
		elif data == "intervention":
			return DocumentType.Intervention
		elif data == "labrequest":
			return DocumentType.Labrequest
		elif data == "labresult":
			return DocumentType.Labresult
		elif data == "medicaladvisoragreement":
			return DocumentType.Medicaladvisoragreement
		elif data == "medicationschemeelement":
			return DocumentType.Medicationschemeelement
		elif data == "note":
			return DocumentType.Note
		elif data == "notification":
			return DocumentType.Notification
		elif data == "pharmaceuticalprescription":
			return DocumentType.Pharmaceuticalprescription
		elif data == "prescription":
			return DocumentType.Prescription
		elif data == "productdelivery":
			return DocumentType.Productdelivery
		elif data == "quickdischargereport":
			return DocumentType.Quickdischargereport
		elif data == "radiationexposuremonitoring":
			return DocumentType.Radiationexposuremonitoring
		elif data == "referral":
			return DocumentType.Referral
		elif data == "report":
			return DocumentType.Report
		elif data == "request":
			return DocumentType.Request
		elif data == "result":
			return DocumentType.Result
		elif data == "sumehr":
			return DocumentType.Sumehr
		elif data == "telemonitoring":
			return DocumentType.Telemonitoring
		elif data == "template":
			return DocumentType.Template
		elif data == "template_admin":
			return DocumentType.TemplateAdmin
		elif data == "treatmentsuspension":
			return DocumentType.Treatmentsuspension
		elif data == "vaccination":
			return DocumentType.Vaccination
		else:
			raise Exception(f"{data} is not a valid value for DocumentType enum.")

__all__ = ['DocumentType']
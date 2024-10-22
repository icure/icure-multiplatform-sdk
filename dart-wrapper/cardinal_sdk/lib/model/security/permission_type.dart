// This file is auto-generated


enum PermissionType {
	authenticate,
	hcp,
	physician,
	admin,
	patientView,
	patientCreate,
	patientChangeDelete,
	medicalDataView,
	medicalDataCreate,
	medicalChangeDelete,
	financialDataView,
	financialDataCreate,
	financialChangeDelete,
	legacyDataView;

	static String encode(PermissionType value) {
		switch (value) {
			case PermissionType.authenticate:
				return '"AUTHENTICATE"';
			case PermissionType.hcp:
				return '"HCP"';
			case PermissionType.physician:
				return '"PHYSICIAN"';
			case PermissionType.admin:
				return '"ADMIN"';
			case PermissionType.patientView:
				return '"PATIENT_VIEW"';
			case PermissionType.patientCreate:
				return '"PATIENT_CREATE"';
			case PermissionType.patientChangeDelete:
				return '"PATIENT_CHANGE_DELETE"';
			case PermissionType.medicalDataView:
				return '"MEDICAL_DATA_VIEW"';
			case PermissionType.medicalDataCreate:
				return '"MEDICAL_DATA_CREATE"';
			case PermissionType.medicalChangeDelete:
				return '"MEDICAL_CHANGE_DELETE"';
			case PermissionType.financialDataView:
				return '"FINANCIAL_DATA_VIEW"';
			case PermissionType.financialDataCreate:
				return '"FINANCIAL_DATA_CREATE"';
			case PermissionType.financialChangeDelete:
				return '"FINANCIAL_CHANGE_DELETE"';
			case PermissionType.legacyDataView:
				return '"LEGACY_DATA_VIEW"';
			}
	}


	static PermissionType fromJSON(String data) {
		switch (data) {
			case "AUTHENTICATE":
				return PermissionType.authenticate;
			case "HCP":
				return PermissionType.hcp;
			case "PHYSICIAN":
				return PermissionType.physician;
			case "ADMIN":
				return PermissionType.admin;
			case "PATIENT_VIEW":
				return PermissionType.patientView;
			case "PATIENT_CREATE":
				return PermissionType.patientCreate;
			case "PATIENT_CHANGE_DELETE":
				return PermissionType.patientChangeDelete;
			case "MEDICAL_DATA_VIEW":
				return PermissionType.medicalDataView;
			case "MEDICAL_DATA_CREATE":
				return PermissionType.medicalDataCreate;
			case "MEDICAL_CHANGE_DELETE":
				return PermissionType.medicalChangeDelete;
			case "FINANCIAL_DATA_VIEW":
				return PermissionType.financialDataView;
			case "FINANCIAL_DATA_CREATE":
				return PermissionType.financialDataCreate;
			case "FINANCIAL_CHANGE_DELETE":
				return PermissionType.financialChangeDelete;
			case "LEGACY_DATA_VIEW":
				return PermissionType.legacyDataView;
			default:
				throw ArgumentError('Invalid PermissionType entry value $data');
			}
	}

}
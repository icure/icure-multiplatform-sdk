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
				return '"Authenticate"';
			case PermissionType.hcp:
				return '"Hcp"';
			case PermissionType.physician:
				return '"Physician"';
			case PermissionType.admin:
				return '"Admin"';
			case PermissionType.patientView:
				return '"PatientView"';
			case PermissionType.patientCreate:
				return '"PatientCreate"';
			case PermissionType.patientChangeDelete:
				return '"PatientChangeDelete"';
			case PermissionType.medicalDataView:
				return '"MedicalDataView"';
			case PermissionType.medicalDataCreate:
				return '"MedicalDataCreate"';
			case PermissionType.medicalChangeDelete:
				return '"MedicalChangeDelete"';
			case PermissionType.financialDataView:
				return '"FinancialDataView"';
			case PermissionType.financialDataCreate:
				return '"FinancialDataCreate"';
			case PermissionType.financialChangeDelete:
				return '"FinancialChangeDelete"';
			case PermissionType.legacyDataView:
				return '"LegacyDataView"';
			}
	}

}
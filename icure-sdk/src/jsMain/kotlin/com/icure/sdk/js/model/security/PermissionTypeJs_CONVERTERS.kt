package com.icure.sdk.js.model.security

import com.icure.sdk.model.security.PermissionType
import kotlin.String

public fun permissionType_toJs(obj: PermissionType): String = obj.name

public fun permissionType_fromJs(obj: String): PermissionType = when (obj) {
	"Authenticate" -> PermissionType.Authenticate
	"Hcp" -> PermissionType.Hcp
	"Physician" -> PermissionType.Physician
	"Admin" -> PermissionType.Admin
	"PatientView" -> PermissionType.PatientView
	"PatientCreate" -> PermissionType.PatientCreate
	"PatientChangeDelete" -> PermissionType.PatientChangeDelete
	"MedicalDataView" -> PermissionType.MedicalDataView
	"MedicalDataCreate" -> PermissionType.MedicalDataCreate
	"MedicalChangeDelete" -> PermissionType.MedicalChangeDelete
	"FinancialDataView" -> PermissionType.FinancialDataView
	"FinancialDataCreate" -> PermissionType.FinancialDataCreate
	"FinancialChangeDelete" -> PermissionType.FinancialChangeDelete
	"LegacyDataView" -> PermissionType.LegacyDataView
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.security.PermissionType: $obj""")
}

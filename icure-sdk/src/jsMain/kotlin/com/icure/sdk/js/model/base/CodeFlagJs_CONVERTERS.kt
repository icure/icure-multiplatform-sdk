package com.icure.sdk.js.model.base

import com.icure.sdk.model.base.CodeFlag
import kotlin.String

public fun codeFlag_toJs(obj: CodeFlag): String = obj.name

public fun codeFlag_fromJs(obj: String): CodeFlag = when (obj) {
	"MaleOnly" -> CodeFlag.MaleOnly
	"FemaleOnly" -> CodeFlag.FemaleOnly
	"Deptkinesitherapy" -> CodeFlag.Deptkinesitherapy
	"Deptnursing" -> CodeFlag.Deptnursing
	"Deptgeneralpractice" -> CodeFlag.Deptgeneralpractice
	"Deptsocialworker" -> CodeFlag.Deptsocialworker
	"Deptpsychology" -> CodeFlag.Deptpsychology
	"Deptadministrative" -> CodeFlag.Deptadministrative
	"Deptdietetics" -> CodeFlag.Deptdietetics
	"Deptspeechtherapy" -> CodeFlag.Deptspeechtherapy
	"Deptdentistry" -> CodeFlag.Deptdentistry
	"Deptoccupationaltherapy" -> CodeFlag.Deptoccupationaltherapy
	"Depthealthcare" -> CodeFlag.Depthealthcare
	"Deptgynecology" -> CodeFlag.Deptgynecology
	"Deptpediatry" -> CodeFlag.Deptpediatry
	"Deptalgology" -> CodeFlag.Deptalgology
	"Deptanatomopathology" -> CodeFlag.Deptanatomopathology
	"Deptanesthesiology" -> CodeFlag.Deptanesthesiology
	"Deptbacteriology" -> CodeFlag.Deptbacteriology
	"Deptcardiacsurgery" -> CodeFlag.Deptcardiacsurgery
	"Deptcardiology" -> CodeFlag.Deptcardiology
	"Deptchildandadolescentpsychiatry" -> CodeFlag.Deptchildandadolescentpsychiatry
	"Deptdermatology" -> CodeFlag.Deptdermatology
	"Deptdiabetology" -> CodeFlag.Deptdiabetology
	"Deptemergency" -> CodeFlag.Deptemergency
	"Deptendocrinology" -> CodeFlag.Deptendocrinology
	"Deptgastroenterology" -> CodeFlag.Deptgastroenterology
	"Deptgenetics" -> CodeFlag.Deptgenetics
	"Deptgeriatry" -> CodeFlag.Deptgeriatry
	"Depthandsurgery" -> CodeFlag.Depthandsurgery
	"Depthematology" -> CodeFlag.Depthematology
	"Deptinfectiousdisease" -> CodeFlag.Deptinfectiousdisease
	"Deptintensivecare" -> CodeFlag.Deptintensivecare
	"Deptlaboratory" -> CodeFlag.Deptlaboratory
	"Deptmajorburns" -> CodeFlag.Deptmajorburns
	"Deptmaxillofacialsurgery" -> CodeFlag.Deptmaxillofacialsurgery
	"Deptmedicine" -> CodeFlag.Deptmedicine
	"Deptmolecularbiology" -> CodeFlag.Deptmolecularbiology
	"Deptneonatalogy" -> CodeFlag.Deptneonatalogy
	"Deptnephrology" -> CodeFlag.Deptnephrology
	"Deptneurology" -> CodeFlag.Deptneurology
	"Deptneurosurgery" -> CodeFlag.Deptneurosurgery
	"Deptnte" -> CodeFlag.Deptnte
	"Deptnuclear" -> CodeFlag.Deptnuclear
	"Deptnutritiondietetics" -> CodeFlag.Deptnutritiondietetics
	"Deptobstetrics" -> CodeFlag.Deptobstetrics
	"Deptoncology" -> CodeFlag.Deptoncology
	"Deptophtalmology" -> CodeFlag.Deptophtalmology
	"Deptorthopedy" -> CodeFlag.Deptorthopedy
	"Deptpalliativecare" -> CodeFlag.Deptpalliativecare
	"Deptpediatricintensivecare" -> CodeFlag.Deptpediatricintensivecare
	"Deptpediatricsurgery" -> CodeFlag.Deptpediatricsurgery
	"Deptpharmacy" -> CodeFlag.Deptpharmacy
	"Deptphysicalmedecine" -> CodeFlag.Deptphysicalmedecine
	"Deptphysiotherapy" -> CodeFlag.Deptphysiotherapy
	"Deptplasticandreparatorysurgery" -> CodeFlag.Deptplasticandreparatorysurgery
	"Deptpneumology" -> CodeFlag.Deptpneumology
	"Deptpodiatry" -> CodeFlag.Deptpodiatry
	"Deptpsychiatry" -> CodeFlag.Deptpsychiatry
	"Deptradiology" -> CodeFlag.Deptradiology
	"Deptradiotherapy" -> CodeFlag.Deptradiotherapy
	"Deptrevalidation" -> CodeFlag.Deptrevalidation
	"Deptrheumatology" -> CodeFlag.Deptrheumatology
	"Deptrhumatology" -> CodeFlag.Deptrhumatology
	"Deptsenology" -> CodeFlag.Deptsenology
	"Deptsocialservice" -> CodeFlag.Deptsocialservice
	"Deptsportsmedecine" -> CodeFlag.Deptsportsmedecine
	"Deptstomatology" -> CodeFlag.Deptstomatology
	"Deptsurgery" -> CodeFlag.Deptsurgery
	"Deptthoracicsurgery" -> CodeFlag.Deptthoracicsurgery
	"Depttoxicology" -> CodeFlag.Depttoxicology
	"Depttropicalmedecine" -> CodeFlag.Depttropicalmedecine
	"Depturology" -> CodeFlag.Depturology
	"Deptvascularsurgery" -> CodeFlag.Deptvascularsurgery
	"Deptvisceraldigestiveabdominalsurgery" -> CodeFlag.Deptvisceraldigestiveabdominalsurgery
	"Depttransplantsurgery" -> CodeFlag.Depttransplantsurgery
	"Deptpercutaneous" -> CodeFlag.Deptpercutaneous
	"Deptchildbirth" -> CodeFlag.Deptchildbirth
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.base.CodeFlag: $obj""")
}

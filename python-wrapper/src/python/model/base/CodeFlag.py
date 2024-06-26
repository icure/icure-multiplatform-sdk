from typing import Union, Dict
from enum import Enum

class CodeFlag(Enum):
	MaleOnly = "male_only"
	FemaleOnly = "female_only"
	Deptkinesitherapy = "deptkinesitherapy"
	Deptnursing = "deptnursing"
	Deptgeneralpractice = "deptgeneralpractice"
	Deptsocialworker = "deptsocialworker"
	Deptpsychology = "deptpsychology"
	Deptadministrative = "deptadministrative"
	Deptdietetics = "deptdietetics"
	Deptspeechtherapy = "deptspeechtherapy"
	Deptdentistry = "deptdentistry"
	Deptoccupationaltherapy = "deptoccupationaltherapy"
	Depthealthcare = "depthealthcare"
	Deptgynecology = "deptgynecology"
	Deptpediatry = "deptpediatry"
	Deptalgology = "deptalgology"
	Deptanatomopathology = "deptanatomopathology"
	Deptanesthesiology = "deptanesthesiology"
	Deptbacteriology = "deptbacteriology"
	Deptcardiacsurgery = "deptcardiacsurgery"
	Deptcardiology = "deptcardiology"
	Deptchildandadolescentpsychiatry = "deptchildandadolescentpsychiatry"
	Deptdermatology = "deptdermatology"
	Deptdiabetology = "deptdiabetology"
	Deptemergency = "deptemergency"
	Deptendocrinology = "deptendocrinology"
	Deptgastroenterology = "deptgastroenterology"
	Deptgenetics = "deptgenetics"
	Deptgeriatry = "deptgeriatry"
	Depthandsurgery = "depthandsurgery"
	Depthematology = "depthematology"
	Deptinfectiousdisease = "deptinfectiousdisease"
	Deptintensivecare = "deptintensivecare"
	Deptlaboratory = "deptlaboratory"
	Deptmajorburns = "deptmajorburns"
	Deptmaxillofacialsurgery = "deptmaxillofacialsurgery"
	Deptmedicine = "deptmedicine"
	Deptmolecularbiology = "deptmolecularbiology"
	Deptneonatalogy = "deptneonatalogy"
	Deptnephrology = "deptnephrology"
	Deptneurology = "deptneurology"
	Deptneurosurgery = "deptneurosurgery"
	Deptnte = "deptnte"
	Deptnuclear = "deptnuclear"
	Deptnutritiondietetics = "deptnutritiondietetics"
	Deptobstetrics = "deptobstetrics"
	Deptoncology = "deptoncology"
	Deptophtalmology = "deptophtalmology"
	Deptorthopedy = "deptorthopedy"
	Deptpalliativecare = "deptpalliativecare"
	Deptpediatricintensivecare = "deptpediatricintensivecare"
	Deptpediatricsurgery = "deptpediatricsurgery"
	Deptpharmacy = "deptpharmacy"
	Deptphysicalmedecine = "deptphysicalmedecine"
	Deptphysiotherapy = "deptphysiotherapy"
	Deptplasticandreparatorysurgery = "deptplasticandreparatorysurgery"
	Deptpneumology = "deptpneumology"
	Deptpodiatry = "deptpodiatry"
	Deptpsychiatry = "deptpsychiatry"
	Deptradiology = "deptradiology"
	Deptradiotherapy = "deptradiotherapy"
	Deptrevalidation = "deptrevalidation"
	Deptrheumatology = "deptrheumatology"
	Deptrhumatology = "deptrhumatology"
	Deptsenology = "deptsenology"
	Deptsocialservice = "deptsocialservice"
	Deptsportsmedecine = "deptsportsmedecine"
	Deptstomatology = "deptstomatology"
	Deptsurgery = "deptsurgery"
	Deptthoracicsurgery = "deptthoracicsurgery"
	Depttoxicology = "depttoxicology"
	Depttropicalmedecine = "depttropicalmedecine"
	Depturology = "depturology"
	Deptvascularsurgery = "deptvascularsurgery"
	Deptvisceraldigestiveabdominalsurgery = "deptvisceraldigestiveabdominalsurgery"
	Depttransplantsurgery = "depttransplantsurgery"
	Deptpercutaneous = "deptpercutaneous"
	Deptchildbirth = "deptchildbirth"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'CodeFlag':
		if data == "male_only":
			return CodeFlag.MaleOnly
		elif data == "female_only":
			return CodeFlag.FemaleOnly
		elif data == "deptkinesitherapy":
			return CodeFlag.Deptkinesitherapy
		elif data == "deptnursing":
			return CodeFlag.Deptnursing
		elif data == "deptgeneralpractice":
			return CodeFlag.Deptgeneralpractice
		elif data == "deptsocialworker":
			return CodeFlag.Deptsocialworker
		elif data == "deptpsychology":
			return CodeFlag.Deptpsychology
		elif data == "deptadministrative":
			return CodeFlag.Deptadministrative
		elif data == "deptdietetics":
			return CodeFlag.Deptdietetics
		elif data == "deptspeechtherapy":
			return CodeFlag.Deptspeechtherapy
		elif data == "deptdentistry":
			return CodeFlag.Deptdentistry
		elif data == "deptoccupationaltherapy":
			return CodeFlag.Deptoccupationaltherapy
		elif data == "depthealthcare":
			return CodeFlag.Depthealthcare
		elif data == "deptgynecology":
			return CodeFlag.Deptgynecology
		elif data == "deptpediatry":
			return CodeFlag.Deptpediatry
		elif data == "deptalgology":
			return CodeFlag.Deptalgology
		elif data == "deptanatomopathology":
			return CodeFlag.Deptanatomopathology
		elif data == "deptanesthesiology":
			return CodeFlag.Deptanesthesiology
		elif data == "deptbacteriology":
			return CodeFlag.Deptbacteriology
		elif data == "deptcardiacsurgery":
			return CodeFlag.Deptcardiacsurgery
		elif data == "deptcardiology":
			return CodeFlag.Deptcardiology
		elif data == "deptchildandadolescentpsychiatry":
			return CodeFlag.Deptchildandadolescentpsychiatry
		elif data == "deptdermatology":
			return CodeFlag.Deptdermatology
		elif data == "deptdiabetology":
			return CodeFlag.Deptdiabetology
		elif data == "deptemergency":
			return CodeFlag.Deptemergency
		elif data == "deptendocrinology":
			return CodeFlag.Deptendocrinology
		elif data == "deptgastroenterology":
			return CodeFlag.Deptgastroenterology
		elif data == "deptgenetics":
			return CodeFlag.Deptgenetics
		elif data == "deptgeriatry":
			return CodeFlag.Deptgeriatry
		elif data == "depthandsurgery":
			return CodeFlag.Depthandsurgery
		elif data == "depthematology":
			return CodeFlag.Depthematology
		elif data == "deptinfectiousdisease":
			return CodeFlag.Deptinfectiousdisease
		elif data == "deptintensivecare":
			return CodeFlag.Deptintensivecare
		elif data == "deptlaboratory":
			return CodeFlag.Deptlaboratory
		elif data == "deptmajorburns":
			return CodeFlag.Deptmajorburns
		elif data == "deptmaxillofacialsurgery":
			return CodeFlag.Deptmaxillofacialsurgery
		elif data == "deptmedicine":
			return CodeFlag.Deptmedicine
		elif data == "deptmolecularbiology":
			return CodeFlag.Deptmolecularbiology
		elif data == "deptneonatalogy":
			return CodeFlag.Deptneonatalogy
		elif data == "deptnephrology":
			return CodeFlag.Deptnephrology
		elif data == "deptneurology":
			return CodeFlag.Deptneurology
		elif data == "deptneurosurgery":
			return CodeFlag.Deptneurosurgery
		elif data == "deptnte":
			return CodeFlag.Deptnte
		elif data == "deptnuclear":
			return CodeFlag.Deptnuclear
		elif data == "deptnutritiondietetics":
			return CodeFlag.Deptnutritiondietetics
		elif data == "deptobstetrics":
			return CodeFlag.Deptobstetrics
		elif data == "deptoncology":
			return CodeFlag.Deptoncology
		elif data == "deptophtalmology":
			return CodeFlag.Deptophtalmology
		elif data == "deptorthopedy":
			return CodeFlag.Deptorthopedy
		elif data == "deptpalliativecare":
			return CodeFlag.Deptpalliativecare
		elif data == "deptpediatricintensivecare":
			return CodeFlag.Deptpediatricintensivecare
		elif data == "deptpediatricsurgery":
			return CodeFlag.Deptpediatricsurgery
		elif data == "deptpharmacy":
			return CodeFlag.Deptpharmacy
		elif data == "deptphysicalmedecine":
			return CodeFlag.Deptphysicalmedecine
		elif data == "deptphysiotherapy":
			return CodeFlag.Deptphysiotherapy
		elif data == "deptplasticandreparatorysurgery":
			return CodeFlag.Deptplasticandreparatorysurgery
		elif data == "deptpneumology":
			return CodeFlag.Deptpneumology
		elif data == "deptpodiatry":
			return CodeFlag.Deptpodiatry
		elif data == "deptpsychiatry":
			return CodeFlag.Deptpsychiatry
		elif data == "deptradiology":
			return CodeFlag.Deptradiology
		elif data == "deptradiotherapy":
			return CodeFlag.Deptradiotherapy
		elif data == "deptrevalidation":
			return CodeFlag.Deptrevalidation
		elif data == "deptrheumatology":
			return CodeFlag.Deptrheumatology
		elif data == "deptrhumatology":
			return CodeFlag.Deptrhumatology
		elif data == "deptsenology":
			return CodeFlag.Deptsenology
		elif data == "deptsocialservice":
			return CodeFlag.Deptsocialservice
		elif data == "deptsportsmedecine":
			return CodeFlag.Deptsportsmedecine
		elif data == "deptstomatology":
			return CodeFlag.Deptstomatology
		elif data == "deptsurgery":
			return CodeFlag.Deptsurgery
		elif data == "deptthoracicsurgery":
			return CodeFlag.Deptthoracicsurgery
		elif data == "depttoxicology":
			return CodeFlag.Depttoxicology
		elif data == "depttropicalmedecine":
			return CodeFlag.Depttropicalmedecine
		elif data == "depturology":
			return CodeFlag.Depturology
		elif data == "deptvascularsurgery":
			return CodeFlag.Deptvascularsurgery
		elif data == "deptvisceraldigestiveabdominalsurgery":
			return CodeFlag.Deptvisceraldigestiveabdominalsurgery
		elif data == "depttransplantsurgery":
			return CodeFlag.Depttransplantsurgery
		elif data == "deptpercutaneous":
			return CodeFlag.Deptpercutaneous
		elif data == "deptchildbirth":
			return CodeFlag.Deptchildbirth
		else:
			raise Exception(f"{data} is not a valid value for CodeFlag enum.")

__all__ = ['CodeFlag']
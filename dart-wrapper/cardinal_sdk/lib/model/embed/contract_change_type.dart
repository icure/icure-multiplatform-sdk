// This file is auto-generated


enum ContractChangeType {
	inscriptionStart,
	inscriptionEnd,
	suspension,
	coverageChange;

	static String encode(ContractChangeType value) {
		switch (value) {
			case ContractChangeType.inscriptionStart:
				return '"InscriptionStart"';
			case ContractChangeType.inscriptionEnd:
				return '"InscriptionEnd"';
			case ContractChangeType.suspension:
				return '"Suspension"';
			case ContractChangeType.coverageChange:
				return '"CoverageChange"';
			}
	}

}
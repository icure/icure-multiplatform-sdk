// auto-generated file


enum ContractChangeType {
	inscriptionStart,
	inscriptionEnd,
	suspension,
	coverageChange;

	static String encode(ContractChangeType value) {
		switch (value) {
			case ContractChangeType.inscriptionStart:
				return '"inscriptionStart"';
			case ContractChangeType.inscriptionEnd:
				return '"inscriptionEnd"';
			case ContractChangeType.suspension:
				return '"suspension"';
			case ContractChangeType.coverageChange:
				return '"coverageChange"';
			}
	}


	static ContractChangeType fromJSON(String data) {
		switch (data) {
			case "inscriptionStart":
				return ContractChangeType.inscriptionStart;
			case "inscriptionEnd":
				return ContractChangeType.inscriptionEnd;
			case "suspension":
				return ContractChangeType.suspension;
			case "coverageChange":
				return ContractChangeType.coverageChange;
			default:
				throw ArgumentError('Invalid ContractChangeType entry value $data');
			}
	}

}
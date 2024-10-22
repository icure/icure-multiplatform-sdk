// This file is auto-generated


enum FlatRateType {
	physician,
	physiotherapist,
	nurse,
	ptd;

	static String encode(FlatRateType value) {
		switch (value) {
			case FlatRateType.physician:
				return '"physician"';
			case FlatRateType.physiotherapist:
				return '"physiotherapist"';
			case FlatRateType.nurse:
				return '"nurse"';
			case FlatRateType.ptd:
				return '"ptd"';
			}
	}


	static FlatRateType fromJSON(String data) {
		switch (data) {
			case "physician":
				return FlatRateType.physician;
			case "physiotherapist":
				return FlatRateType.physiotherapist;
			case "nurse":
				return FlatRateType.nurse;
			case "ptd":
				return FlatRateType.ptd;
			default:
				throw ArgumentError('Invalid FlatRateType entry value $data');
			}
	}

}
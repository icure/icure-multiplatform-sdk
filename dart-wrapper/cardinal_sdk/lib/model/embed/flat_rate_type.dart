// This file is auto-generated


enum FlatRateType {
	physician,
	physiotherapist,
	nurse,
	ptd;

	static String encode(FlatRateType value) {
		switch (value) {
			case FlatRateType.physician:
				return '"Physician"';
			case FlatRateType.physiotherapist:
				return '"Physiotherapist"';
			case FlatRateType.nurse:
				return '"Nurse"';
			case FlatRateType.ptd:
				return '"Ptd"';
			}
	}

}
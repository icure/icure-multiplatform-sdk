// This file is auto-generated


enum MediumType {
	cdrom,
	eattest,
	efact,
	email,
	mediprima,
	paper,
	stat;

	static String encode(MediumType value) {
		switch (value) {
			case MediumType.cdrom:
				return '"Cdrom"';
			case MediumType.eattest:
				return '"Eattest"';
			case MediumType.efact:
				return '"Efact"';
			case MediumType.email:
				return '"Email"';
			case MediumType.mediprima:
				return '"Mediprima"';
			case MediumType.paper:
				return '"Paper"';
			case MediumType.stat:
				return '"Stat"';
			}
	}

}
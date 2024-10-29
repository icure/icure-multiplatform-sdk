// auto-generated file


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
				return 'cdrom';
			case MediumType.eattest:
				return 'eattest';
			case MediumType.efact:
				return 'efact';
			case MediumType.email:
				return 'email';
			case MediumType.mediprima:
				return 'mediprima';
			case MediumType.paper:
				return 'paper';
			case MediumType.stat:
				return 'stat';
			}
	}


	static MediumType fromJSON(String data) {
		switch (data) {
			case "cdrom":
				return MediumType.cdrom;
			case "eattest":
				return MediumType.eattest;
			case "efact":
				return MediumType.efact;
			case "email":
				return MediumType.email;
			case "mediprima":
				return MediumType.mediprima;
			case "paper":
				return MediumType.paper;
			case "stat":
				return MediumType.stat;
			default:
				throw ArgumentError('Invalid MediumType entry value $data');
			}
	}

}
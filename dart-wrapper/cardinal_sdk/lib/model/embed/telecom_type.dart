// auto-generated file


enum TelecomType {
	mobile,
	phone,
	email,
	fax,
	skype,
	im,
	medibridge,
	ehealthbox,
	apicrypt,
	web,
	print,
	disk,
	other,
	pager;

	static String encode(TelecomType value) {
		switch (value) {
			case TelecomType.mobile:
				return 'mobile';
			case TelecomType.phone:
				return 'phone';
			case TelecomType.email:
				return 'email';
			case TelecomType.fax:
				return 'fax';
			case TelecomType.skype:
				return 'skype';
			case TelecomType.im:
				return 'im';
			case TelecomType.medibridge:
				return 'medibridge';
			case TelecomType.ehealthbox:
				return 'ehealthbox';
			case TelecomType.apicrypt:
				return 'apicrypt';
			case TelecomType.web:
				return 'web';
			case TelecomType.print:
				return 'print';
			case TelecomType.disk:
				return 'disk';
			case TelecomType.other:
				return 'other';
			case TelecomType.pager:
				return 'pager';
			}
	}


	static TelecomType fromJSON(String data) {
		switch (data) {
			case "mobile":
				return TelecomType.mobile;
			case "phone":
				return TelecomType.phone;
			case "email":
				return TelecomType.email;
			case "fax":
				return TelecomType.fax;
			case "skype":
				return TelecomType.skype;
			case "im":
				return TelecomType.im;
			case "medibridge":
				return TelecomType.medibridge;
			case "ehealthbox":
				return TelecomType.ehealthbox;
			case "apicrypt":
				return TelecomType.apicrypt;
			case "web":
				return TelecomType.web;
			case "print":
				return TelecomType.print;
			case "disk":
				return TelecomType.disk;
			case "other":
				return TelecomType.other;
			case "pager":
				return TelecomType.pager;
			default:
				throw ArgumentError('Invalid TelecomType entry value $data');
			}
	}

}
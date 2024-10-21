// This file is auto-generated


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
				return '"Mobile"';
			case TelecomType.phone:
				return '"Phone"';
			case TelecomType.email:
				return '"Email"';
			case TelecomType.fax:
				return '"Fax"';
			case TelecomType.skype:
				return '"Skype"';
			case TelecomType.im:
				return '"Im"';
			case TelecomType.medibridge:
				return '"Medibridge"';
			case TelecomType.ehealthbox:
				return '"Ehealthbox"';
			case TelecomType.apicrypt:
				return '"Apicrypt"';
			case TelecomType.web:
				return '"Web"';
			case TelecomType.print:
				return '"Print"';
			case TelecomType.disk:
				return '"Disk"';
			case TelecomType.other:
				return '"Other"';
			case TelecomType.pager:
				return '"Pager"';
			}
	}

}
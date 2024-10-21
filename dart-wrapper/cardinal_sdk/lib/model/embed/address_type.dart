// This file is auto-generated


enum AddressType {
	home,
	work,
	vacation,
	hospital,
	clinic,
	hq,
	other,
	temporary,
	postal,
	diplomatic,
	reference,
	careaddress;

	static String encode(AddressType value) {
		switch (value) {
			case AddressType.home:
				return '"Home"';
			case AddressType.work:
				return '"Work"';
			case AddressType.vacation:
				return '"Vacation"';
			case AddressType.hospital:
				return '"Hospital"';
			case AddressType.clinic:
				return '"Clinic"';
			case AddressType.hq:
				return '"Hq"';
			case AddressType.other:
				return '"Other"';
			case AddressType.temporary:
				return '"Temporary"';
			case AddressType.postal:
				return '"Postal"';
			case AddressType.diplomatic:
				return '"Diplomatic"';
			case AddressType.reference:
				return '"Reference"';
			case AddressType.careaddress:
				return '"Careaddress"';
			}
	}

}
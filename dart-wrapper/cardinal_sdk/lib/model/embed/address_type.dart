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
				return '"home"';
			case AddressType.work:
				return '"work"';
			case AddressType.vacation:
				return '"vacation"';
			case AddressType.hospital:
				return '"hospital"';
			case AddressType.clinic:
				return '"clinic"';
			case AddressType.hq:
				return '"hq"';
			case AddressType.other:
				return '"other"';
			case AddressType.temporary:
				return '"temporary"';
			case AddressType.postal:
				return '"postal"';
			case AddressType.diplomatic:
				return '"diplomatic"';
			case AddressType.reference:
				return '"reference"';
			case AddressType.careaddress:
				return '"careaddress"';
			}
	}


	static AddressType fromJSON(String data) {
		switch (data) {
			case "home":
				return AddressType.home;
			case "work":
				return AddressType.work;
			case "vacation":
				return AddressType.vacation;
			case "hospital":
				return AddressType.hospital;
			case "clinic":
				return AddressType.clinic;
			case "hq":
				return AddressType.hq;
			case "other":
				return AddressType.other;
			case "temporary":
				return AddressType.temporary;
			case "postal":
				return AddressType.postal;
			case "diplomatic":
				return AddressType.diplomatic;
			case "reference":
				return AddressType.reference;
			case "careaddress":
				return AddressType.careaddress;
			default:
				throw ArgumentError('Invalid AddressType entry value $data');
			}
	}

}
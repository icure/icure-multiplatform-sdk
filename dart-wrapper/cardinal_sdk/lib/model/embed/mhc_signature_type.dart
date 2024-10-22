// This file is auto-generated


enum MhcSignatureType {
	holderEid,
	holderPaper,
	legalrepresentativeEid,
	legalrepresentativePaper;

	static String encode(MhcSignatureType value) {
		switch (value) {
			case MhcSignatureType.holderEid:
				return '"holderEid"';
			case MhcSignatureType.holderPaper:
				return '"holderPaper"';
			case MhcSignatureType.legalrepresentativeEid:
				return '"legalrepresentativeEid"';
			case MhcSignatureType.legalrepresentativePaper:
				return '"legalrepresentativePaper"';
			}
	}


	static MhcSignatureType fromJSON(String data) {
		switch (data) {
			case "holderEid":
				return MhcSignatureType.holderEid;
			case "holderPaper":
				return MhcSignatureType.holderPaper;
			case "legalrepresentativeEid":
				return MhcSignatureType.legalrepresentativeEid;
			case "legalrepresentativePaper":
				return MhcSignatureType.legalrepresentativePaper;
			default:
				throw ArgumentError('Invalid MhcSignatureType entry value $data');
			}
	}

}
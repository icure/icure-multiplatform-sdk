// This file is auto-generated


enum MhcSignatureType {
	holderEid,
	holderPaper,
	legalrepresentativeEid,
	legalrepresentativePaper;

	static String encode(MhcSignatureType value) {
		switch (value) {
			case MhcSignatureType.holderEid:
				return '"HolderEid"';
			case MhcSignatureType.holderPaper:
				return '"HolderPaper"';
			case MhcSignatureType.legalrepresentativeEid:
				return '"LegalrepresentativeEid"';
			case MhcSignatureType.legalrepresentativePaper:
				return '"LegalrepresentativePaper"';
			}
	}

}
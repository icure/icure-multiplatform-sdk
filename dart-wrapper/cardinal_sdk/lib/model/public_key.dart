// This file is auto-generated


class PublicKey {
	String? hcPartyId;
	String? hexString;

	PublicKey({
		this.hcPartyId,
		this.hexString
	});

	static Map<String, dynamic> encode(PublicKey value) {
		Map<String, dynamic> entityAsMap = {
			"hcPartyId" : value.hcPartyId,
			"hexString" : value.hexString
		};
		return entityAsMap;
	}
}
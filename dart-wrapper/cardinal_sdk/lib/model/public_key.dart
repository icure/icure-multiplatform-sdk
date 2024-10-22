// This file is auto-generated


class PublicKey {
	String? hcPartyId;
	String? hexString;
	PublicKey({
			this.hcPartyId,
			this.hexString
		});

	factory PublicKey.fromJSON(Map<String, dynamic> data) {
		return PublicKey(
			hcPartyId: data["hcPartyId"],
			hexString: data["hexString"]
		);
	}

	static Map<String, dynamic> encode(PublicKey value) {
		Map<String, dynamic> entityAsMap = {
			"hcPartyId" : value.hcPartyId,
			"hexString" : value.hexString
		};
		return entityAsMap;
	}
}
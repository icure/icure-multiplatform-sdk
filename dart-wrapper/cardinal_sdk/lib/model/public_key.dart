// auto-generated file


class PublicKey {
	String? hcPartyId;
	String? hexString;
	PublicKey({
			this.hcPartyId,
			this.hexString
		});

	factory PublicKey.fromJSON(Map<String, dynamic> data) {
		return PublicKey(
			hcPartyId: (data["hcPartyId"] as String?),
			hexString: (data["hexString"] as String?)
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
// This file is auto-generated


class ServiceLink {
	String? serviceId;

	ServiceLink({
		this.serviceId
	});

	static Map<String, dynamic> encode(ServiceLink value) {
		Map<String, dynamic> entityAsMap = {
			"serviceId" : value.serviceId
		};
		return entityAsMap;
	}
}
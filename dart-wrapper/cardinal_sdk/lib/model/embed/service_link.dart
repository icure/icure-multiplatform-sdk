// auto-generated file


class ServiceLink {
	String? serviceId;
	ServiceLink({
			this.serviceId});

	factory ServiceLink.fromJSON(Map<String, dynamic> data) {
		return ServiceLink(
			serviceId: data["serviceId"]
		);
	}

	static Map<String, dynamic> encode(ServiceLink value) {
		Map<String, dynamic> entityAsMap = {
			"serviceId" : value.serviceId
		};
		return entityAsMap;
	}
}
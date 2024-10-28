// auto-generated file


class ServiceLink {
	String? serviceId = null;
	ServiceLink({
			String? serviceId}) : serviceId = serviceId ?? null;

	factory ServiceLink.fromJSON(Map<String, dynamic> data) {
		return ServiceLink(
			serviceId: (data["serviceId"] as String?)
		);
	}

	static Map<String, dynamic> encode(ServiceLink value) {
		Map<String, dynamic> entityAsMap = {
			"serviceId" : value.serviceId
		};
		return entityAsMap;
	}
}
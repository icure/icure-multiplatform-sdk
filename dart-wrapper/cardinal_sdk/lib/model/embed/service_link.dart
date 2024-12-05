// auto-generated file


class ServiceLink {
	String? serviceId = null;
	ServiceLink({
			String? serviceId}) : serviceId = serviceId ?? null;

	static Map<String, dynamic> encode(ServiceLink value) {
		Map<String, dynamic> entityAsMap = {
			"serviceId" : value.serviceId
		};
		return entityAsMap;
	}

	static ServiceLink fromJSON(Map<String, dynamic> data) {
		return ServiceLink(
			serviceId: (data["serviceId"] as String?)
		);
	}
}
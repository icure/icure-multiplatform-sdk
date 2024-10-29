// auto-generated file


class RoleConfiguration {
	RoleConfigurationSource source;
	Set<String> roles = {};
	RoleConfiguration(
		this.source,
		{
			Set<String>? roles
		}) : roles = roles ?? {};

	factory RoleConfiguration.fromJSON(Map<String, dynamic> data) {
		return RoleConfiguration(
			RoleConfigurationSource.fromJSON(data["source"]),
			roles: (data["roles"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
		);
	}

	static Map<String, dynamic> encode(RoleConfiguration value) {
		Map<String, dynamic> entityAsMap = {
			"source" : RoleConfigurationSource.encode(value.source),
			"roles" : value.roles.map((x0) => x0).toList()
		};
		return entityAsMap;
	}
}

enum RoleConfigurationSource {
	configuration,
	inherited,
	predefined;

	static String encode(RoleConfigurationSource value) {
		switch (value) {
			case RoleConfigurationSource.configuration:
				return 'CONFIGURATION';
			case RoleConfigurationSource.inherited:
				return 'INHERITED';
			case RoleConfigurationSource.predefined:
				return 'DEFAULT';
			}
	}


	static RoleConfigurationSource fromJSON(String data) {
		switch (data) {
			case "CONFIGURATION":
				return RoleConfigurationSource.configuration;
			case "INHERITED":
				return RoleConfigurationSource.inherited;
			case "DEFAULT":
				return RoleConfigurationSource.predefined;
			default:
				throw ArgumentError('Invalid RoleConfigurationSource entry value $data');
			}
	}

}
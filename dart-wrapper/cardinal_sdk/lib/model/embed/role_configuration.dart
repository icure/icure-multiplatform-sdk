// This file is auto-generated


class RoleConfiguration {
	RoleConfigurationSource source;
	Set<String> roles = {};

	RoleConfiguration({
		required this.source,
		Set<String>? roles
	}) : roles = roles ?? {};

	static Map<String, dynamic> encode(RoleConfiguration value) {
		Map<String, dynamic> entityAsMap = {
			"source" : RoleConfigurationSource.encode(value.source),
			"roles" : value.roles.map((x0) => x0)
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
				return '"Configuration"';
			case RoleConfigurationSource.inherited:
				return '"Inherited"';
			case RoleConfigurationSource.predefined:
				return '"Default"';
			}
	}

}
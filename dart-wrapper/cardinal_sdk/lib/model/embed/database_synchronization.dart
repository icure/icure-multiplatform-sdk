// auto-generated file


class DatabaseSynchronization {
	String? source;
	String? target;
	String? filter;
	DatabaseSynchronizationTarget? localTarget;
	DatabaseSynchronization({
			this.source,
			this.target,
			this.filter,
			this.localTarget
		});

	factory DatabaseSynchronization.fromJSON(Map<String, dynamic> data) {
		return DatabaseSynchronization(
			source: (data["source"] as String?),
			target: (data["target"] as String?),
			filter: (data["filter"] as String?),
			localTarget: data["localTarget"] == null ? null : DatabaseSynchronizationTarget.fromJSON(data["localTarget"])
		);
	}

	static Map<String, dynamic> encode(DatabaseSynchronization value) {
		Map<String, dynamic> entityAsMap = {
			"source" : value.source,
			"target" : value.target,
			"filter" : value.filter,
			"localTarget" : value.localTarget == null ? null : DatabaseSynchronizationTarget.encode(value.localTarget!)
		};
		return entityAsMap;
	}
}

enum DatabaseSynchronizationTarget {
	base,
	healthdata,
	patient;

	static String encode(DatabaseSynchronizationTarget value) {
		switch (value) {
			case DatabaseSynchronizationTarget.base:
				return 'base';
			case DatabaseSynchronizationTarget.healthdata:
				return 'healthdata';
			case DatabaseSynchronizationTarget.patient:
				return 'patient';
			}
	}


	static DatabaseSynchronizationTarget fromJSON(String data) {
		switch (data) {
			case "base":
				return DatabaseSynchronizationTarget.base;
			case "healthdata":
				return DatabaseSynchronizationTarget.healthdata;
			case "patient":
				return DatabaseSynchronizationTarget.patient;
			default:
				throw ArgumentError('Invalid DatabaseSynchronizationTarget entry value $data');
			}
	}

}
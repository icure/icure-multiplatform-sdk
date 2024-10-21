// This file is auto-generated


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
				return '"Base"';
			case DatabaseSynchronizationTarget.healthdata:
				return '"Healthdata"';
			case DatabaseSynchronizationTarget.patient:
				return '"Patient"';
			}
	}

}
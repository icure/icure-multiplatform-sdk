// This file is auto-generated


enum FrontEndMigrationStatus {
	started,
	paused,
	error,
	success;

	static String encode(FrontEndMigrationStatus value) {
		switch (value) {
			case FrontEndMigrationStatus.started:
				return '"STARTED"';
			case FrontEndMigrationStatus.paused:
				return '"PAUSED"';
			case FrontEndMigrationStatus.error:
				return '"ERROR"';
			case FrontEndMigrationStatus.success:
				return '"SUCCESS"';
			}
	}


	static FrontEndMigrationStatus fromJSON(String data) {
		switch (data) {
			case "STARTED":
				return FrontEndMigrationStatus.started;
			case "PAUSED":
				return FrontEndMigrationStatus.paused;
			case "ERROR":
				return FrontEndMigrationStatus.error;
			case "SUCCESS":
				return FrontEndMigrationStatus.success;
			default:
				throw ArgumentError('Invalid FrontEndMigrationStatus entry value $data');
			}
	}

}
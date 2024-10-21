// This file is auto-generated


enum FrontEndMigrationStatus {
	started,
	paused,
	error,
	success;

	static String encode(FrontEndMigrationStatus value) {
		switch (value) {
			case FrontEndMigrationStatus.started:
				return '"Started"';
			case FrontEndMigrationStatus.paused:
				return '"Paused"';
			case FrontEndMigrationStatus.error:
				return '"Error"';
			case FrontEndMigrationStatus.success:
				return '"Success"';
			}
	}

}
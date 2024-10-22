// This file is auto-generated


enum ReportVersion {
	v1_0_0;

	static String encode(ReportVersion value) {
		switch (value) {
			case ReportVersion.v1_0_0:
				return '"V1_0_0"';
			}
	}


	static ReportVersion fromJSON(String data) {
		switch (data) {
			case "V1_0_0":
				return ReportVersion.v1_0_0;
			default:
				throw ArgumentError('Invalid ReportVersion entry value $data');
			}
	}

}
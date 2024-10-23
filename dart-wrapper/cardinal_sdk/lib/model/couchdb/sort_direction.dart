// auto-generated file


enum SortDirection {
	asc,
	desc;

	static String encode(SortDirection value) {
		switch (value) {
			case SortDirection.asc:
				return '"asc"';
			case SortDirection.desc:
				return '"desc"';
			}
	}


	static SortDirection fromJSON(String data) {
		switch (data) {
			case "asc":
				return SortDirection.asc;
			case "desc":
				return SortDirection.desc;
			default:
				throw ArgumentError('Invalid SortDirection entry value $data');
			}
	}

}
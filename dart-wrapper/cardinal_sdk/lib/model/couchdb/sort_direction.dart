// This file is auto-generated


enum SortDirection {
	asc,
	desc;

	static String encode(SortDirection value) {
		switch (value) {
			case SortDirection.asc:
				return '"Asc"';
			case SortDirection.desc:
				return '"Desc"';
			}
	}

}
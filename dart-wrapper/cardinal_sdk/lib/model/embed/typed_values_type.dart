// This file is auto-generated


enum TypedValuesType {
	boolean,
	integer,
	double,
	string,
	date,
	clob,
	json;

	static String encode(TypedValuesType value) {
		switch (value) {
			case TypedValuesType.boolean:
				return '"Boolean"';
			case TypedValuesType.integer:
				return '"Integer"';
			case TypedValuesType.double:
				return '"Double"';
			case TypedValuesType.string:
				return '"String"';
			case TypedValuesType.date:
				return '"Date"';
			case TypedValuesType.clob:
				return '"Clob"';
			case TypedValuesType.json:
				return '"Json"';
			}
	}

}
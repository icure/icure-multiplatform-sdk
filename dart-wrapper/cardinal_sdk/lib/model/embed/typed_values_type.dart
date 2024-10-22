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
				return '"BOOLEAN"';
			case TypedValuesType.integer:
				return '"INTEGER"';
			case TypedValuesType.double:
				return '"DOUBLE"';
			case TypedValuesType.string:
				return '"STRING"';
			case TypedValuesType.date:
				return '"DATE"';
			case TypedValuesType.clob:
				return '"CLOB"';
			case TypedValuesType.json:
				return '"JSON"';
			}
	}


	static TypedValuesType fromJSON(String data) {
		switch (data) {
			case "BOOLEAN":
				return TypedValuesType.boolean;
			case "INTEGER":
				return TypedValuesType.integer;
			case "DOUBLE":
				return TypedValuesType.double;
			case "STRING":
				return TypedValuesType.string;
			case "DATE":
				return TypedValuesType.date;
			case "CLOB":
				return TypedValuesType.clob;
			case "JSON":
				return TypedValuesType.json;
			default:
				throw ArgumentError('Invalid TypedValuesType entry value $data');
			}
	}

}
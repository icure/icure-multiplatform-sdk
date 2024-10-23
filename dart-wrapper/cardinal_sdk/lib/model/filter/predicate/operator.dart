// auto-generated file


enum Operator {
	equal,
	notequal,
	greaterthan,
	smallerthan,
	greaterthanorequal,
	smallerthanorequal,
	like,
	ilike;

	static String encode(Operator value) {
		switch (value) {
			case Operator.equal:
				return '"EQUAL"';
			case Operator.notequal:
				return '"NOTEQUAL"';
			case Operator.greaterthan:
				return '"GREATERTHAN"';
			case Operator.smallerthan:
				return '"SMALLERTHAN"';
			case Operator.greaterthanorequal:
				return '"GREATERTHANOREQUAL"';
			case Operator.smallerthanorequal:
				return '"SMALLERTHANOREQUAL"';
			case Operator.like:
				return '"LIKE"';
			case Operator.ilike:
				return '"ILIKE"';
			}
	}


	static Operator fromJSON(String data) {
		switch (data) {
			case "EQUAL":
				return Operator.equal;
			case "NOTEQUAL":
				return Operator.notequal;
			case "GREATERTHAN":
				return Operator.greaterthan;
			case "SMALLERTHAN":
				return Operator.smallerthan;
			case "GREATERTHANOREQUAL":
				return Operator.greaterthanorequal;
			case "SMALLERTHANOREQUAL":
				return Operator.smallerthanorequal;
			case "LIKE":
				return Operator.like;
			case "ILIKE":
				return Operator.ilike;
			default:
				throw ArgumentError('Invalid Operator entry value $data');
			}
	}

}
// This file is auto-generated


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
				return '"Equal"';
			case Operator.notequal:
				return '"Notequal"';
			case Operator.greaterthan:
				return '"Greaterthan"';
			case Operator.smallerthan:
				return '"Smallerthan"';
			case Operator.greaterthanorequal:
				return '"Greaterthanorequal"';
			case Operator.smallerthanorequal:
				return '"Smallerthanorequal"';
			case Operator.like:
				return '"Like"';
			case Operator.ilike:
				return '"Ilike"';
			}
	}

}
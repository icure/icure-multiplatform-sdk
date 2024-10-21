// This file is auto-generated


enum PropertyTypeScope {
	system,
	node,
	role,
	user,
	event;

	static String encode(PropertyTypeScope value) {
		switch (value) {
			case PropertyTypeScope.system:
				return '"System"';
			case PropertyTypeScope.node:
				return '"Node"';
			case PropertyTypeScope.role:
				return '"Role"';
			case PropertyTypeScope.user:
				return '"User"';
			case PropertyTypeScope.event:
				return '"Event"';
			}
	}

}
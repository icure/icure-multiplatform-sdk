// This file is auto-generated


enum RequestedPermission {
	maxRead,
	fullRead,
	maxWrite,
	fullWrite,
	root;

	static String encode(RequestedPermission value) {
		switch (value) {
			case RequestedPermission.maxRead:
				return '"MaxRead"';
			case RequestedPermission.fullRead:
				return '"FullRead"';
			case RequestedPermission.maxWrite:
				return '"MaxWrite"';
			case RequestedPermission.fullWrite:
				return '"FullWrite"';
			case RequestedPermission.root:
				return '"Root"';
			}
	}

}
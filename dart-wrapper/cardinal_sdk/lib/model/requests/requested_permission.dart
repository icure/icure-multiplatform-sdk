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
				return '"MAX_READ"';
			case RequestedPermission.fullRead:
				return '"FULL_READ"';
			case RequestedPermission.maxWrite:
				return '"MAX_WRITE"';
			case RequestedPermission.fullWrite:
				return '"FULL_WRITE"';
			case RequestedPermission.root:
				return '"ROOT"';
			}
	}


	static RequestedPermission fromJSON(String data) {
		switch (data) {
			case "MAX_READ":
				return RequestedPermission.maxRead;
			case "FULL_READ":
				return RequestedPermission.fullRead;
			case "MAX_WRITE":
				return RequestedPermission.maxWrite;
			case "FULL_WRITE":
				return RequestedPermission.fullWrite;
			case "ROOT":
				return RequestedPermission.root;
			default:
				throw ArgumentError('Invalid RequestedPermission entry value $data');
			}
	}

}
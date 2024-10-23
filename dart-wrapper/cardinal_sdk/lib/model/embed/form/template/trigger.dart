// auto-generated file


enum Trigger {
	init,
	change,
	click,
	visible,
	error,
	valid,
	event;

	static String encode(Trigger value) {
		switch (value) {
			case Trigger.init:
				return '"INIT"';
			case Trigger.change:
				return '"CHANGE"';
			case Trigger.click:
				return '"CLICK"';
			case Trigger.visible:
				return '"VISIBLE"';
			case Trigger.error:
				return '"ERROR"';
			case Trigger.valid:
				return '"VALID"';
			case Trigger.event:
				return '"EVENT"';
			}
	}


	static Trigger fromJSON(String data) {
		switch (data) {
			case "INIT":
				return Trigger.init;
			case "CHANGE":
				return Trigger.change;
			case "CLICK":
				return Trigger.click;
			case "VISIBLE":
				return Trigger.visible;
			case "ERROR":
				return Trigger.error;
			case "VALID":
				return Trigger.valid;
			case "EVENT":
				return Trigger.event;
			default:
				throw ArgumentError('Invalid Trigger entry value $data');
			}
	}

}
// This file is auto-generated


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
				return '"Init"';
			case Trigger.change:
				return '"Change"';
			case Trigger.click:
				return '"Click"';
			case Trigger.visible:
				return '"Visible"';
			case Trigger.error:
				return '"Error"';
			case Trigger.valid:
				return '"Valid"';
			case Trigger.event:
				return '"Event"';
			}
	}

}
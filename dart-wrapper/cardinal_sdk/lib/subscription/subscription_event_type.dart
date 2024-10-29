// auto-generated file


enum SubscriptionEventType {
	create,
	update;

	static String encode(SubscriptionEventType value) {
		switch (value) {
			case SubscriptionEventType.create:
				return 'Create';
			case SubscriptionEventType.update:
				return 'Update';
			}
	}


	static SubscriptionEventType fromJSON(String data) {
		switch (data) {
			case "Create":
				return SubscriptionEventType.create;
			case "Update":
				return SubscriptionEventType.update;
			default:
				throw ArgumentError('Invalid SubscriptionEventType entry value $data');
			}
	}

}
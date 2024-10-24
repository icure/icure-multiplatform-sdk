// auto-generated file


enum EntitySubscriptionCloseReason {
	channelFull,
	connectionLost,
	intentionallyClosed;

	static String encode(EntitySubscriptionCloseReason value) {
		switch (value) {
			case EntitySubscriptionCloseReason.channelFull:
				return 'ChannelFull';
			case EntitySubscriptionCloseReason.connectionLost:
				return 'ConnectionLost';
			case EntitySubscriptionCloseReason.intentionallyClosed:
				return 'IntentionallyClosed';
			}
	}


	static EntitySubscriptionCloseReason fromJSON(String data) {
		switch (data) {
			case "ChannelFull":
				return EntitySubscriptionCloseReason.channelFull;
			case "ConnectionLost":
				return EntitySubscriptionCloseReason.connectionLost;
			case "IntentionallyClosed":
				return EntitySubscriptionCloseReason.intentionallyClosed;
			default:
				throw ArgumentError('Invalid EntitySubscriptionCloseReason entry value $data');
			}
	}

}
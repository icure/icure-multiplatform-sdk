// auto-generated file
import 'package:cardinal_sdk/model/base/identifiable.dart';


class EntitySubscriptionEvent<E extends Identifiable<String>> {
	final Map<String, dynamic> _json;
	static const EntitySubscriptionEvent Connected = EntitySubscriptionEvent._internal({"kotlinType": "com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent.Connected"});
	static const EntitySubscriptionEvent Reconnected = EntitySubscriptionEvent._internal({"kotlinType": "com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent.Reconnected"});
	const EntitySubscriptionEvent._internal(this._json);

	factory EntitySubscriptionEvent.UnexpectedError(String message) {
		return EntitySubscriptionEvent._internal({"message": message, "kotlinType": "com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent.UnexpectedError"});
	}

	factory EntitySubscriptionEvent.ConnectionError() {
		return EntitySubscriptionEvent._internal({"kotlinType": "com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent.ConnectionError"});
	}

	factory EntitySubscriptionEvent.EntityNotification(E entity) {
		throw UnimplementedError("TODO");
		// return EntitySubscriptionEvent._internal({"entity": Identifiable<String>.encode(entity), "kotlinType": "com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent.EntityNotification"});
	}

	factory EntitySubscriptionEvent.EntityError() {
		return EntitySubscriptionEvent._internal({"kotlinType": "com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent.EntityError"});
	}

	factory EntitySubscriptionEvent.fromJSON(Map<String, dynamic> data) {
		return EntitySubscriptionEvent._internal(data);
	}

	static Map<String, dynamic> encode(EntitySubscriptionEvent value) {
		return Map.unmodifiable(value._json);
	}
}
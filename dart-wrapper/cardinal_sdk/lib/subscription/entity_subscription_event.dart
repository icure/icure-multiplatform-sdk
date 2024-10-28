import 'package:cardinal_sdk/model/base/identifiable.dart';

sealed class EntitySubscriptionEvent<E extends Identifiable<String>> {

	static EntitySubscriptionEvent<E> fromJSON<E extends Identifiable<String>>(Map<String, dynamic> data, E Function(Map<String, dynamic> data) entityFromJson) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent.Connected":
				return Connected.fromJSON(data);
			case "com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent.Reconnected":
				return Reconnected.fromJSON(data);
			case "com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent.UnexpectedError":
				return UnexpectedError.fromJSON(data);
			case "com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent.ConnectionError.MissedPing":
				return MissedPing.fromJSON(data);
			case "com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent.ConnectionError.ClosedByServer":
				return ClosedByServer.fromJSON(data);
			case "com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent.EntityNotification":
				return EntityNotification.fromJSON(data, entityFromJson);
			case "com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent.EntityError.DeserializationError":
				return DeserializationError.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

class Connected implements EntitySubscriptionEvent<Never> {
	static final Connected _singleton = Connected._internal();
	factory Connected.fromJSON(Map<String, dynamic> data) {
		return Connected(
		);
	}

	Connected._internal();

	factory Connected() {
		return _singleton;
	}
}

class Reconnected implements EntitySubscriptionEvent<Never> {
	static final Reconnected _singleton = Reconnected._internal();
	factory Reconnected.fromJSON(Map<String, dynamic> data) {
		return Reconnected(
		);
	}

	Reconnected._internal();

	factory Reconnected() {
		return _singleton;
	}
}

class UnexpectedError implements EntitySubscriptionEvent<Never> {
	String message;
	UnexpectedError(this.message);

	factory UnexpectedError.fromJSON(Map<String, dynamic> data) {
		return UnexpectedError(
				data["message"]
		);
	}
}

sealed class ConnectionError implements EntitySubscriptionEvent<Never> {

	static ConnectionError fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent.ConnectionError.MissedPing":
				return MissedPing.fromJSON(data);
			case "com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent.ConnectionError.ClosedByServer":
				return ClosedByServer.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

class MissedPing implements ConnectionError {
	static final MissedPing _singleton = MissedPing._internal();
	factory MissedPing.fromJSON(Map<String, dynamic> data) {
		return MissedPing(
		);
	}

	MissedPing._internal();

	factory MissedPing() {
		return _singleton;
	}
}

class ClosedByServer implements ConnectionError {
	static final ClosedByServer _singleton = ClosedByServer._internal();
	factory ClosedByServer.fromJSON(Map<String, dynamic> data) {
		return ClosedByServer(
		);
	}

	ClosedByServer._internal();

	factory ClosedByServer() {
		return _singleton;
	}
}

class EntityNotification<E extends Identifiable<String>> implements EntitySubscriptionEvent<E> {
	E entity;
	EntityNotification(this.entity);

	factory EntityNotification.fromJSON(Map<String, dynamic> data, E Function(Map<String, dynamic> data) entityFromJson) {
		return EntityNotification(
				entityFromJson(data["entity"])
		);
	}
}

sealed class EntityError implements EntitySubscriptionEvent<Never> {

	static EntityError fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.subscription.EntitySubscriptionEvent.EntityError.DeserializationError":
				return DeserializationError.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

class DeserializationError implements EntityError {
	static final DeserializationError _singleton = DeserializationError._internal();
	factory DeserializationError.fromJSON(Map<String, dynamic> data) {
		return DeserializationError(
		);
	}

	DeserializationError._internal();

	factory DeserializationError() {
		return _singleton;
	}
}
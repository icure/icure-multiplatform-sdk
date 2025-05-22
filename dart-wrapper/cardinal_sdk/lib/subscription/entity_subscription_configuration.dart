// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "entity_subscription_configuration.freezed.dart";


@freezed
abstract class EntitySubscriptionConfiguration with _$EntitySubscriptionConfiguration {
	const factory EntitySubscriptionConfiguration({
		@Default(100) int channelBufferCapacity,
		@Default(EntitySubscriptionConfigurationFullBufferBehaviour.close) EntitySubscriptionConfigurationFullBufferBehaviour onBufferFull,
		@Default(Duration(seconds: 2)) Duration reconnectionDelay,
		@Default(2.0) double retryDelayExponentFactor,
		@Default(5) int connectionMaxRetries,
	}) = _EntitySubscriptionConfiguration;


	static Map<String, dynamic> encode(EntitySubscriptionConfiguration value) {
		Map<String, dynamic> entityAsMap = {
			"channelBufferCapacity" : value.channelBufferCapacity,
			"onBufferFull" : EntitySubscriptionConfigurationFullBufferBehaviour.encode(value.onBufferFull),
			"reconnectionDelay" : value.reconnectionDelay.inMilliseconds,
			"retryDelayExponentFactor" : value.retryDelayExponentFactor,
			"connectionMaxRetries" : value.connectionMaxRetries
		};
		return entityAsMap;
	}

	static EntitySubscriptionConfiguration fromJSON(Map<String, dynamic> data) {
		return EntitySubscriptionConfiguration(
			channelBufferCapacity: (data["channelBufferCapacity"] as int),
			connectionMaxRetries: (data["connectionMaxRetries"] as int),
			onBufferFull: EntitySubscriptionConfigurationFullBufferBehaviour.fromJSON(data["onBufferFull"]),
			reconnectionDelay: Duration(milliseconds: data["reconnectionDelay"]),
			retryDelayExponentFactor: (data["retryDelayExponentFactor"] as num).toDouble()
		);
	}
}

enum EntitySubscriptionConfigurationFullBufferBehaviour {
	close,
	dropOldest,
	ignore;

	static String encode(EntitySubscriptionConfigurationFullBufferBehaviour value) {
		switch (value) {
			case EntitySubscriptionConfigurationFullBufferBehaviour.close:
				return 'Close';
			case EntitySubscriptionConfigurationFullBufferBehaviour.dropOldest:
				return 'DropOldest';
			case EntitySubscriptionConfigurationFullBufferBehaviour.ignore:
				return 'Ignore';
			}
	}


	static EntitySubscriptionConfigurationFullBufferBehaviour fromJSON(String data) {
		switch (data) {
			case "Close":
				return EntitySubscriptionConfigurationFullBufferBehaviour.close;
			case "DropOldest":
				return EntitySubscriptionConfigurationFullBufferBehaviour.dropOldest;
			case "Ignore":
				return EntitySubscriptionConfigurationFullBufferBehaviour.ignore;
			default:
				throw ArgumentError('Invalid EntitySubscriptionConfigurationFullBufferBehaviour entry value $data');
			}
	}

}
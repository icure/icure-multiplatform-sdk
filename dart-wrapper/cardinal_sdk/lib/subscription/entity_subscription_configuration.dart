// auto-generated file
import 'package:cardinal_sdk/annotations/actual_int32.dart';


class EntitySubscriptionConfiguration {
	int _channelBufferCapacity = 100;
	@ActualInt32() int get channelBufferCapacity => _channelBufferCapacity;
	@ActualInt32() set channelBufferCapacity(int value) {
		if (value > 2147483647) {
			throw ArgumentError('channelBufferCapacity value cannot exceed 2147483647');
		}
		_channelBufferCapacity = value;
	}
	EntitySubscriptionConfigurationFullBufferBehaviour onBufferFull = EntitySubscriptionConfigurationFullBufferBehaviour.close;
	Duration reconnectionDelay = Duration(seconds: 2);
	double retryDelayExponentFactor = 2.0;
	int _connectionMaxRetries = 5;
	@ActualInt32() int get connectionMaxRetries => _connectionMaxRetries;
	@ActualInt32() set connectionMaxRetries(int value) {
		if (value > 2147483647) {
			throw ArgumentError('connectionMaxRetries value cannot exceed 2147483647');
		}
		_connectionMaxRetries = value;
	}
	EntitySubscriptionConfiguration({
			int? channelBufferCapacity,
			int? connectionMaxRetries,
			EntitySubscriptionConfigurationFullBufferBehaviour? onBufferFull,
			Duration? reconnectionDelay,
			double? retryDelayExponentFactor
		}) : onBufferFull = onBufferFull ?? EntitySubscriptionConfigurationFullBufferBehaviour.close,
		reconnectionDelay = reconnectionDelay ?? Duration(seconds: 2),
		retryDelayExponentFactor = retryDelayExponentFactor ?? 2.0,
		_channelBufferCapacity = channelBufferCapacity ?? 100,
		_connectionMaxRetries = connectionMaxRetries ?? 5;

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
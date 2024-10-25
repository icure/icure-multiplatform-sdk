import 'package:cardinal_sdk/model/base/identifiable.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_close_reason.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_event.dart';

class EntitySubscription<T extends Identifiable<String>> {
  final String _instanceId;
  final T Function(Map<String, dynamic>) _decodeT;

  EntitySubscription(this._instanceId, this._decodeT);

  Future<void> close(String sdkId) async {
    CardinalSdkPlatformInterface.instance.subscription.close(_instanceId);
  }

  Future<EntitySubscriptionCloseReason?> getCloseReason(String sdkId) async {
    return CardinalSdkPlatformInterface.instance.subscription.getCloseReason(_instanceId);
  }

  Future<EntitySubscriptionEvent<T>> getEvent(String sdkId) async {
    final eventJson = await CardinalSdkPlatformInterface.instance
        .subscription
        .getEvent(_instanceId);
    return EntitySubscriptionEvent.fromJSON(eventJson, _decodeT);
  }

  Future<EntitySubscriptionEvent<T>> waitForEvent(String sdkId, Duration timeout) async {
    final eventJson = await CardinalSdkPlatformInterface.instance
        .subscription
        .waitForEvent(_instanceId, timeout);
    return EntitySubscriptionEvent.fromJSON(eventJson, _decodeT);
  }
}
import 'package:cardinal_sdk/model/base/identifiable.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_close_reason.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_event.dart';
import 'package:cardinal_sdk/utils/cancellable_future.dart';
import 'package:cardinal_sdk/utils/internal/cancellation_token_provider.dart';

class EntitySubscription<T extends Identifiable<String>> {
  final String _instanceId;
  final T Function(Map<String, dynamic>) _decodeT;
  static final Finalizer<String> _finalizer = Finalizer((resourceId) =>
      CardinalSdkPlatformInterface.instance.utils.releasePlatformResource(resourceId)
  );

  EntitySubscription._(this._instanceId, this._decodeT);

  factory EntitySubscription(String instanceId, T Function(Map<String, dynamic>) decodeT) {
    final subscription = EntitySubscription._(instanceId, decodeT);
    _finalizer.attach(subscription, instanceId, detach: subscription);
    return subscription;
  }

  Future<void> close() async {
    CardinalSdkPlatformInterface.instance.subscription.close(_instanceId);
  }

  Future<EntitySubscriptionCloseReason?> getCloseReason() async {
    return CardinalSdkPlatformInterface.instance.subscription.getCloseReason(_instanceId);
  }

  Future<EntitySubscriptionEvent<T>?> getEvent() async {
    final eventJson = await CardinalSdkPlatformInterface.instance
        .subscription
        .getEvent(_instanceId);
    if (eventJson != null) {
      return EntitySubscriptionEvent.fromJSON(eventJson, _decodeT);
    } else {
      return null;
    }
  }

  CancellableFuture<EntitySubscriptionEvent<T>?> waitForEvent(Duration timeout) {
    final cancellationToken = CancellationTokenProvider.getNextToken();
    final resPromise = CardinalSdkPlatformInterface.instance
        .subscription
        .waitForEvent(_instanceId, timeout, cancellationToken)
        .then((eventJson) {
          if (eventJson != null) {
            return EntitySubscriptionEvent.fromJSON(eventJson, _decodeT);
          } else {
            return null;
          }
        });
    return CancellableFuture.internalConstructor(resPromise, cancellationToken);
  }
}

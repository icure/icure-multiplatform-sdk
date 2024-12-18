import 'package:cardinal_sdk/crypto/entities/cardinal_keys.dart';
import 'package:cardinal_sdk/crypto/entities/recovery_data_key.dart';
import 'package:cardinal_sdk/crypto/entities/recovery_result.dart';
import 'package:cardinal_sdk/utils/cancellable_future.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/utils/internal/cancellation_token_provider.dart';

/// Allows to recover user keypairs using builtin recovery mechanisms.
/// This interface includes recovery methods that require some input from your application (e.g. a recovery key created from a different device).
/// Other recovery methods (such as transfer keys) are used automatically by the sdk when available and don't require any input from your application.
class KeyPairRecoverer {
  /// Recover a keypair using a recovery key created in the past using the {@link IccRecoveryXApi.createRecoveryInfoForAvailableKeyPairs} method.
  /// @param recoveryKey the result of a past call to {@link IccRecoveryXApi.createRecoveryInfoForAvailableKeyPairs}.
  /// @param autoDelete if true, the recovery data will be deleted from the server after it could be used successfully.
  /// This will prevent the recovery key from being used again.
  /// @return a recovery result, which, if successful, contains a map dataOwnerId -> publicKeySpki -> keyPair, where:
  /// - The `dataOwnerId` keys are the ids of the data owner which created the recovery data and his parents, if the recovery data contains also the
  ///   parents keys
  /// - The `publicKeySpki` keys are all recovered public key pairs for the data owner, in hex-encoded spki format (full, no fingerprint). Usually
  ///   these are all the keys if the recovery data was created after the latest key for the user.
  /// - The `keyPair` is the imported privateKey + publicKey.
  Future<RecoveryResult<Map<String, Map<CardinalRsaPublicKey, CardinalRsaPrivateKey>>>> recoverWithRecoveryKey(
    RecoveryDataKey recoveryKey,
    bool autoDelete
  ) async {
    return await CardinalSdkPlatformInterface.instance.crypto.recoverWithRecoveryKey(
      _nativeInstanceId,
      recoveryKey,
      autoDelete,
    );
  }

  /// Equivalent to [recoverWithRecoveryKey] except that if there is no recovery data for the provided key it waits for
  /// up to [waitSeconds] seconds for it to be created.
  /// If the data wasn't created within the provided time frame this method will return a [RecoveryResult.Failure]
  /// result with [RecoveryDataUseFailureReason.Missing] at the end of the waiting period.
  CancellableFuture<RecoveryResult<Map<String, Map<CardinalRsaPublicKey, CardinalRsaPrivateKey>>>> waitForRecoveryKey(
    RecoveryDataKey recoveryKey,
    bool autoDelete,
    int waitSeconds
  ) {
    final cancellationToken = CancellationTokenProvider.getNextToken();
    return CancellableFuture.internalConstructor(
        CardinalSdkPlatformInterface.instance.crypto.waitForRecoveryKey(
          _nativeInstanceId,
          recoveryKey,
          autoDelete,
          waitSeconds,
          cancellationToken,
        ),
        cancellationToken
    );
  }

  final String _nativeInstanceId;

  KeyPairRecoverer._(this._nativeInstanceId);

  factory KeyPairRecoverer.internal(String _nativeId) {
    final recoverer = KeyPairRecoverer._(_nativeId);
    _finalizer.attach(recoverer, _nativeId, detach: recoverer);
    return recoverer;
  }

  static final Finalizer<String> _finalizer = Finalizer((resourceId) =>
      CardinalSdkPlatformInterface.instance.utils.releasePlatformResource(resourceId)
  );
}

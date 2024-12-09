import 'package:cardinal_sdk/cardinal_sdk.dart';
import 'package:cardinal_sdk/crypto/entities/cardinal_keys.dart';
import 'package:cardinal_sdk/model/crypto_actor_stub_with_type.dart';
import 'package:cardinal_sdk/model/data_owner_type.dart';
import 'package:cardinal_sdk/model/data_owner_with_type.dart';

import 'key_pair_recovery.dart';

/// A request to recover key data that was not found for a user.
class KeyDataRecoveryRequest {
  /// The data owner for which the key data should be recovered.
  final DataOwnerWithType dataOwnerDetails;
  /// All public keys in hex-encoded spki format of `dataOwner` for which the authenticity status (verified or unverified) is
  /// unknown (no result was cached from a previous api instantiation and the key was not generated on the current device).
  /// This could include keys that were recovered automatically by the sdk and may have overlap with `unavailableKeys`.
  final List<CardinalRsaPublicKey> unknownKeys;

  /// All public keys (in hex-encoded spki format) of `dataOwner` for which the sdk could not recover a private key. May overlap
  /// (partially or completely) with `unknownKeys`.
  final List<UnavailableKeyInfo> unavailableKeys;

  const KeyDataRecoveryRequest({required this.dataOwnerDetails, required this.unknownKeys, required this.unavailableKeys});
}

class UnavailableKeyInfo {
  /// The public key
  final CardinalRsaPublicKey publicKey;
  /// The algorithm of the keypair
  final CardinalRsaEncryptionAlgorithm keyAlgorithm;

  const UnavailableKeyInfo({required this.publicKey, required this.keyAlgorithm});
}

/// Data recovered for a data owner.
class RecoveredKeyData {
  /// All private keys recovered for the data owner (will be automatically considered as verified), by fingerprint.
  final Map<CardinalRsaPublicKeyFingerprint, CardinalRsaPrivateKey> recoveredKeys;

  /// associates each public key fingerprint its authenticity. Note that if any of the keys from `unknownKeys` is
  /// completely missing from this object the key will be considered as unverified in this api instance (same as
  /// if associated to false), but this value won't be cached (will be again part of `unknownKeys` in future
  /// instances.
  final Map<CardinalRsaPublicKeyFingerprint, bool> keyAuthenticity;

  const RecoveredKeyData({required this.recoveredKeys, required this.keyAuthenticity});
}

class KeyGenerationRequestResult {
  final String _ktType;
  final String? _key;

  const KeyGenerationRequestResult._({required String ktType, required String? key}) : _ktType = ktType, _key = key;

  /// Allows the SDK to generate a new key pair for the current data owner.
  factory KeyGenerationRequestResult.allow() {
    return const KeyGenerationRequestResult._(ktType: "TODO", key: null);
  }

  /// The SDK must not generate a new key for the data owner. The SDK initialisation should fail with a predefined error.
  factory KeyGenerationRequestResult.deny() {
    return const KeyGenerationRequestResult._(ktType: "TODO", key: null);
  }

  /// The SDK should use the provided key pair as a new key for the data owner.
  factory KeyGenerationRequestResult.use(CardinalRsaPrivateKey key) {
    return KeyGenerationRequestResult._(ktType: "TODO", key: key.pkcs8Hex);
  }
}

class CryptoStrategies {

  /// Method called during initialisation of the crypto API to validate keys recovered through iCure's recovery methods and/or to allow recovery of
  /// missing keys using means external to iCure.
  /// On startup the iCure sdk will try to load all keys for the current data owner and its parent hierarchy: if the sdk can't find some of the keys
  /// for any of the data owners (according to the public keys for the data owner in the iCure server) and/or the sdk could recover some private keys
  /// but can't verify the authenticity of the key pairs this method will be called.
  /// The recovered and verified keys will automatically be cached using the current api {@link KeyStorageFacade} and {@link StorageFacade}
  ///
  /// The input is a list containing an object for each data owner part of the current data owner hierarchy. The objects are ordered from the data
  /// for the topmost parent of the current data owner hierarchy (first element) to the data for the current data owner (last element).
  ///
  /// The returned value must be an object associating to each data owner id an object with:
  /// - `recoveredKeys`:
  /// - `keyAuthenticity`: an object
  /// @param keysData all information on unknown and unavailable keys for each data owner part of the current data owner hierarchy.
  /// @param cryptoPrimitives cryptographic primitives you can use to support the process.
  /// @param keyPairRecoverer a key pair recoverer you can use to support the process
  /// @return a map that associates to each given data owner id the recovered data.
  Future<Map<String, RecoveredKeyData>> recoverAndVerifySelfHierarchyKeys(
    List<KeyDataRecoveryRequest> keysData,
    KeyPairRecoverer keyPairRecoverer
  ) {
    final res = <String, RecoveredKeyData>{};
    for (final it in keysData) {
      res[it.dataOwnerDetails.dataOwner.id] = const RecoveredKeyData(recoveredKeys: {}, keyAuthenticity: {});
    }
    return Future.value(res);
  }

  /// The correct initialisation of the crypto API requires that at least 1 verified (or device) key pair is available for each data owner part of the
  /// current data owner hierarchy. If no verified key is available for any of the data owner parents the api initialisation will automatically fail,
  /// however if there is no verified key for the current data owner you can instead create a new crypto key.
  /// @param self the current data owner.
  /// @param cryptoPrimitives cryptographic primitives you can use to support the process.
  /// @return an instance of [KeyGenerationRequestResult] specifying how the SDK should behave.
  /// @throws Exception you can throw any exception, and it will simply propagate to the api initialisation method.
  Future<KeyGenerationRequestResult> generateNewKeyForDataOwner(
    DataOwnerWithType self,
  ) {
    return Future.value(KeyGenerationRequestResult.allow());
  }

  /// Verifies if the public keys of a data owner which will be the delegate of a new exchange key do actually belong to the person the data owner
  /// represents. This method is not called when the delegate would be the current data owner for the api.
  ///
  /// The user will have to obtain the verified public keys of the delegate from outside iCure, for example by email with another hcp, by checking the
  /// personal website of the other user, or by scanning verification qr codes at the doctor office...
  ///
  /// As long as one of the public keys is verified the creation of a new exchange key will succeed. If no public key is verified the operation will
  /// fail.
  /// @param delegate the potential data owner delegate.
  /// @param publicKeys public keys requiring verification, in spki hex-encoded format.
  /// @param cryptoPrimitives cryptographic primitives you can use to support the process.
  /// @return all verified public keys, in spki hex-encoded format.
  Future<List<CardinalRsaPublicKey>> verifyDelegatePublicKeys(
    CryptoActorStubWithType delegate,
    List<CardinalRsaPublicKey> publicKeys,
  ) {
    return Future.value(publicKeys);
  }

  /// Specifies if a data owner requires anonymous delegations, i.e. his id should not appear unencrypted in new secure delegations. This should always
  /// be the case for patient data owners.
  /// @param dataOwner a data owner.
  /// @return true if the delegations for the provided data owner should be anonymous.
  Future<bool> dataOwnerRequiresAnonymousDelegation(CryptoActorStubWithType dataOwner) {
    return Future.value(dataOwner.type != DataOwnerType.hcp);
  }

  /// Notifies that a new key for the current data owner was created.
  /// This method is called after the initialization of the other SDK apis.
  /// @param apis the initialized cardinal apis.
  /// @param key the newly created key.
  /// @param cryptoPrimitives cryptographic primitives you can use to support the process.
  Future<void> notifyNewKeyCreated(
    CardinalApis apis,
    CardinalRsaPrivateKey key,
  ) {
    return Future.value();
  }
}
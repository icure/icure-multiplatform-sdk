import 'dart:convert';

import 'package:cardinal_sdk/crypto/crypto_strategies.dart';
import 'package:cardinal_sdk/model/data_owner_with_type.dart';
import 'package:cardinal_sdk/crypto/entities/cardinal_keys.dart';
import 'package:cardinal_sdk/crypto/key_pair_recoverer.dart';
import 'package:cardinal_sdk/model/crypto_actor_stub_with_type.dart';
import 'package:cardinal_sdk/cardinal_sdk.dart';


Future<String> Function(Map<String, dynamic>) recoverAndVerifySelfHierarchyKeysCallback(
  CryptoStrategies strategies
) {
  return (Map<String, dynamic> json) async {
    final result = await strategies.recoverAndVerifySelfHierarchyKeys(
        (json["keysData"]! as List<dynamic>).map((x) => KeyDataRecoveryRequest.decode(x as Map<String, dynamic>)).toList(),
        KeyPairRecoverer.internal(json["keyPairRecoverer"]! as String)
    );
    return jsonEncode(result.map((k, v) => MapEntry(k, v.encode())));
  };
}

Future<String> Function(Map<String, dynamic>) generateNewKeyForDataOwnerCallback(
  CryptoStrategies strategies
) {
  return (Map<String, dynamic> json) async {
    final result = await strategies.generateNewKeyForDataOwner(
        DataOwnerWithType.fromJSON(json["self"]! as Map<String, dynamic>)
    );
    return jsonEncode(result.encode());
  };
}

Future<String> Function(Map<String, dynamic>) verifyDelegatePublicKeysCallback(
  CryptoStrategies strategies
) {
  return (Map<String, dynamic> json) async {
    final result = await strategies.verifyDelegatePublicKeys(
      CryptoActorStubWithType.fromJSON(json["delegate"]! as Map<String, dynamic>),
      (json["publicKeys"]! as List<dynamic>).map((x) => CardinalRsaPublicKey.fromSpkiHex(x as String)).toList(),
    );
    return jsonEncode(result.map((x) => x.spkiHex).toList());
  };
}

Future<String> Function(Map<String, dynamic>) dataOwnerRequiresAnonymousDelegationCallback(
  CryptoStrategies strategies
) {
  return (Map<String, dynamic> json) async {
    final result = await strategies.dataOwnerRequiresAnonymousDelegation(
        CryptoActorStubWithType.fromJSON(json["dataOwner"] as Map<String, dynamic>)
    );
    return jsonEncode(result);
  };
}

Future<String> Function(Map<String, dynamic>) notifyNewKeyCreatedCallback(
  CryptoStrategies strategies
) {
  return (Map<String, dynamic> json) async {
    await strategies.notifyNewKeyCreated(
      CardinalSdk.internal(json["apis"]! as String),
      CardinalRsaPrivateKey.fromPkcs8Base64(json["key"]! as String)
    );
    return "";
  };
}
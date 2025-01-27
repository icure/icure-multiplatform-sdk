import 'dart:convert';
import 'dart:typed_data';

import 'package:convert/convert.dart';

/// Represents an Rsa public key
class CardinalRsaPublicKey {
  /// Representation of the public key in spki format, hex-encoded.
  final String spkiHex;

  /// Representation of the public key in raw spki format.
  Uint8List get spkiBytes {
    return Uint8List.fromList(hex.decode(spkiHex));
  }

  /// Representation of the public key in spki format, base64-encoded.
  String get spkiBase64 {
    return base64Encode(hex.decode(spkiHex));
  }

  /// Create the key from its spki representation, hex-encoded.
  const CardinalRsaPublicKey.fromSpkiHex(this.spkiHex);

  /// Create the key from its spki representation, base64-encoded.
  CardinalRsaPublicKey.fromSpkiBase64(String spkiBase64) : spkiHex = hex.encode(base64Decode(spkiBase64));

  /// Create the key from its raw spki representation.
  CardinalRsaPublicKey.fromSpkiBytes(Uint8List spkiBytes) : spkiHex = hex.encode(spkiBytes);

  @override
  String toString() {
    return "CardinalRsaPublicKey($spkiHex)";
  }

  /// The fingerprint for this public key
  CardinalRsaPublicKeyFingerprint fingerprint() {
    return CardinalRsaPublicKeyFingerprint(spkiHex.substring(spkiHex.length - 32));
  }
}

/// A short representation of an RSA public key as a string
class CardinalRsaPublicKeyFingerprint {
  final String value;

  const CardinalRsaPublicKeyFingerprint(this.value);

  @override
  String toString() {
    return value;
  }
}

/// Represents an Rsa private key
class CardinalRsaPrivateKey {
  /// Representation of the private key in pkcs8 format, hex-encoded.
  final String pkcs8Hex;

  /// Representation of the private key in raw pkcs8 format.
  Uint8List get pkcs8Bytes {
    return Uint8List.fromList(hex.decode(pkcs8Hex));
  }

  /// Representation of the private key in pkcs8 format, base64-encoded.
  String get pkcs8Base64 {
    return base64Encode(hex.decode(pkcs8Hex));
  }

  /// Create the key from its pkcs8 representation, hex-encoded.
  const CardinalRsaPrivateKey.fromPkcs8Hex(this.pkcs8Hex);

  /// Create the key from its pkcs8 representation, base64-encoded.
  CardinalRsaPrivateKey.fromPkcs8Base64(String pkcs8Base64) : pkcs8Hex = hex.encode(base64Decode(pkcs8Base64));

  /// Create the key from its raw pkcs8 representation.
  CardinalRsaPrivateKey.fromPkcs8Bytes(Uint8List pkcs8Bytes) : pkcs8Hex = hex.encode(pkcs8Bytes);
}

/// The Rsa encryption algorithms used by cardinal
enum CardinalRsaEncryptionAlgorithm {
  oaepWithSha1,
  oaepWithSha256;

  static decode(String data) {
    switch (data) {
      case "OaepWithSha1":
        return CardinalRsaEncryptionAlgorithm.oaepWithSha1;
      case "OaepWithSha256":
        return CardinalRsaEncryptionAlgorithm.oaepWithSha256;
      default:
        throw ArgumentError('Invalid CardinalRsaEncryptionAlgorithm entry value $data');
    }
  }
}

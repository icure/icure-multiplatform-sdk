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

  /// Create the key from its spki representation, hex-encoded.
  const CardinalRsaPublicKey.fromHex(this.spkiHex);

  /// Create the key from its raw spki representation.
  CardinalRsaPublicKey.fromBytes(Uint8List spkiBytes) : spkiHex = hex.encode(spkiBytes);

  @override
  String toString() {
    return "CardinalRsaPublicKey($spkiHex)";
  }

  /// The fingerprint for this public key
  CardinalRsaPublicKeyFingerprint fingerprint() {
    return CardinalRsaPublicKeyFingerprint._(spkiHex.substring(spkiHex.length - 32));
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

  /// Create the key from its pkcs8 representation, hex-encoded.
  const CardinalRsaPrivateKey.fromHex(this.pkcs8Hex);

  /// Create the key from its raw pkcs8 representation.
  CardinalRsaPrivateKey.fromBytes(Uint8List pkcs8Bytes) : pkcs8Hex = hex.encode(pkcs8Bytes);
}

/// The Rsa encryption algorithms used by cardinal
enum CardinalRsaEncryptionAlgorithm {
  oaepWithSha1,
  oaepWithSha256;
}

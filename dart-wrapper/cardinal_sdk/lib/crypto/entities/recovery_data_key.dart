import 'dart:typed_data';

import 'package:base32/base32.dart';
import 'package:convert/convert.dart';

class RecoveryDataKey {
  final Uint8List _bytes;

  static const Set<int> byteLengthOptions = {16, 32};

  RecoveryDataKey._(this._bytes);

  /// Load the recovery data key from its hexadecimal representation
  factory RecoveryDataKey.fromHexString(String hexString) {
    final decodedBytes = hex.decode(hexString);
    if (!byteLengthOptions.contains(decodedBytes.length)) {
      throw ArgumentError(
          "Invalid recovery data key: decoded size should be in $byteLengthOptions bytes");
    }
    return RecoveryDataKey._(Uint8List.fromList(decodedBytes));
  }

  /// Load the recovery data key from its raw bytes representation
  factory RecoveryDataKey.fromRawBytes(Uint8List bytes) {
    if (!byteLengthOptions.contains(bytes.length)) {
      throw ArgumentError("Invalid recovery data key: decoded size should be in $byteLengthOptions bytes");
    }
    return RecoveryDataKey._(bytes);
  }

  /// Load the recovery data key from its base32 representation
  factory RecoveryDataKey.fromBase32(String base32Key) {
    return RecoveryDataKey.fromRawBytes(base32.decode(base32Key));
  }

  /// Give a representation of this recovery data key as a hexadecimal string
  String asHexString() => hex.encode(_bytes);

  /// Give a representation of this recovery data key as raw bytes
  List<Uint8List> asRawBytes() => List.unmodifiable(_bytes);

  /// Give a representation of this recovery data key as a base32 string, excluding padding
  String asBase32() {
    final base32Encoded = base32.encode(_bytes);
    return base32Encoded.replaceAll('=', '');
  }

  static Map<String, dynamic> encode(RecoveryDataKey value) {
    return {
      "_hex": value.asHexString()
    };
  }

  static RecoveryDataKey fromJSON(Map<String, dynamic> data) {
    return RecoveryDataKey.fromHexString(data["_hex"] as String);
  }
}

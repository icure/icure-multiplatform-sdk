import 'dart:math';

final _random = Random();
final _hexAlphabet = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'];
String _generateHex(int length) {
  return List<String>.generate(length, (_) => _hexAlphabet[_random.nextInt(16)]).join();
}

/// For internal use only. Generates an id, but does not use cryptographically safe random generators and does not
/// fully respect UUIDv4 specifications
String generateUnsafeId() {
  return '${_generateHex(8)}-${_generateHex(4)}-${_generateHex(4)}-${_generateHex(4)}-${_generateHex(12)}';
}
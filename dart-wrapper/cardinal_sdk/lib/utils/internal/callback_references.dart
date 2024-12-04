import 'dart:math';

class CallbackReferences {
  CallbackReferences._();

  static final _references = <String, String Function(String)>{};
  static final _random = Random();
  static final _hexAlphabet = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'];

  static String create(String Function(String) callback) {
    String id;
    do {
      id = _generateId();
    } while (_references.containsKey(id));
    _references[id] = callback;
    return id;
  }

  // Duplicates the entry for a certain reference id: this ensures that both the old and new entry need to be removed
  // before the callback can actually be garbage collected
  static String duplicate(String referenceId) {
    return create(get(referenceId));
  }

  static void delete(String referenceId) {
    if (!_references.containsKey(referenceId)) {
      throw ArgumentError('Callback for reference id $referenceId not found');
    }
    _references.remove(referenceId);
  }

  static String Function(String) get(String referenceId) {
    if (!_references.containsKey(referenceId)) {
      throw ArgumentError('Callback for reference id $referenceId not found');
    }
    return _references[referenceId]!;
  }

  static String _generateId() {
    return '${_generateHex(8)}-${_generateHex(4)}-${_generateHex(4)}-${_generateHex(4)}-${_generateHex(12)}';
  }

  static String _generateHex(int length) {
    return List<String>.generate(length, (_) => _hexAlphabet[_random.nextInt(16)]).join();
  }
}
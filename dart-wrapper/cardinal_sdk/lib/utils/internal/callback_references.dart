import 'dart:math';

import 'package:cardinal_sdk/utils/internal/unsafe_uuid.dart';

class CallbackReferences {
  CallbackReferences._();

  static final _references = <String, Future<String> Function(Map<String, dynamic>)>{};

  static String create(Future<String> Function(Map<String, dynamic>) callback) {
    String id;
    do {
      id = generateUnsafeId();
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

  static Future<String> Function(Map<String, dynamic>) get(String referenceId) {
    if (!_references.containsKey(referenceId)) {
      throw ArgumentError('Callback for reference id $referenceId not found');
    }
    return _references[referenceId]!;
  }
}
import 'dart:math';

import 'package:cardinal_sdk/utils/internal/error_references.dart';
import 'package:cardinal_sdk/utils/internal/unsafe_uuid.dart';



class _Entry {
  final Future<String> Function(Map<String, dynamic>) callback;
  int rc = 1;
  List<String> linkedErrorReferences = [];

  _Entry(this.callback);
}

class CallbackReferences {
  CallbackReferences._();

  static final _references = <String, _Entry>{};

  static String create(Future<String> Function(Map<String, dynamic>) callback) {
    String id;
    do {
      id = generateUnsafeId();
    } while (_references.containsKey(id));
    _references[id] = _Entry(callback);
    return id;
  }

  // Marks that the entry for a certain reference id should be deleted an additional time before being fully removed.
  // For reference counting
  static void markUsed(String referenceId) {
    final ref = _get(referenceId);
    ref.rc += 1;
  }

  static void delete(String referenceId) {
    final ref = _get(referenceId);
    if (ref.rc <= 1) {
      _references.remove(referenceId);
      for (final e in ref.linkedErrorReferences) {
        ErrorReferences.remove(e);
      }
    } else {
      ref.rc -= 1;
    }
  }

  static Future<String> Function(Map<String, dynamic>) get(String referenceId) {
    return _get(referenceId).callback;
  }

  static _Entry _get(String referenceId) {
    if (!_references.containsKey(referenceId)) {
      throw ArgumentError('Callback for reference id $referenceId not found');
    }
    return _references[referenceId]!;
  }

  static void linkErrorReference({required String callbackReferenceId, required String errorReferenceId }) {
    _get(callbackReferenceId).linkedErrorReferences.add(errorReferenceId);
  }
}
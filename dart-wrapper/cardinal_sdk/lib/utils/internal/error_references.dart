import 'package:cardinal_sdk/utils/internal/unsafe_uuid.dart';

class ErrorReference {
  final Object e;
  final StackTrace trace;
  ErrorReference(this.e, this.trace);
}

class ErrorReferences {
  ErrorReferences._();

  static final _references = <String, ErrorReference>{};

  static String create(ErrorReference error) {
    String id;
    do {
      id = generateUnsafeId();
    } while (_references.containsKey(id));
    _references[id] = error;
    return id;
  }

  static ErrorReference? pop(String referenceId) {
    ErrorReference? res = _references[referenceId];
    _references.remove(referenceId);
    return res;
  }

  static void remove(String referenceId) {
    _references.remove(referenceId);
  }
}
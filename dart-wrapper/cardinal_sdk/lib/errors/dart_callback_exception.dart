/// Exception used to represent an exception thrown by the native plugin when a dart callback fails.
class DartCallbackException implements Exception {
  /// The dart exception thrown by the callback
  final Object dartException;
  /// The callback stack trace
  final StackTrace dartStackTrace;
  /// The native stack trace, up to the dart callback invocation
  final String? platformStackTrace;

  DartCallbackException({required this.dartException, required this.dartStackTrace, required this.platformStackTrace});

  @override
  String toString() {
    return "DartCallbackException caused by: ${dartException.toString()}\n${dartStackTrace.toString()}";
  }
}
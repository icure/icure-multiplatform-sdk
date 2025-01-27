/// A state error produced by the cardinal sdk with optionally the added native stack trace.
class CardinalStateError extends StateError {
  final String? platformStackTrace;

  CardinalStateError(String super.message, this.platformStackTrace);
}
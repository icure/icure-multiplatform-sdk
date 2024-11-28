/// An argument error produced by the cardinal sdk with optionally the added native stack trace.
class CardinalArgumentError extends ArgumentError {
  final String? platformStackTrace;

  CardinalArgumentError(String super.message, this.platformStackTrace);
}
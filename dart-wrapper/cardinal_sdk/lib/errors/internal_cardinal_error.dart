/// An internal error of the Cardinal SDK, should not be caught.
class InternalCardinalError {
  final String message;
  final String? platformStackTrace;

  InternalCardinalError(this.message, this.platformStackTrace);

  @override
  String toString() {
    return platformStackTrace ?? message;
  }
}
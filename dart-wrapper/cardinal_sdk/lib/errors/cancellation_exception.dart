/// Exception used to complete cancellable futures when they are cancelled before normal/failure termination.
class CancellationException implements Exception {
  final String? platformStackTrace;

  CancellationException(this.platformStackTrace);
}
class PaginatedListIterator<T> {
  final String _instanceId;
  final T Function(Map<String, dynamic>) _decodeT;

  PaginatedListIterator(this._instanceId, this._decodeT);
}
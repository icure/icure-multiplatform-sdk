class PaginatedListIterator<T> {
  final String _instanceId;
  final T Function(Map<String, dynamic>) _decodeT;

  PaginatedListIterator(this._instanceId, this._decodeT);

  Future<bool> hasNext() async {
    return CardinalSdkPlatformInterface.instance.pagination.hasNext(_instanceId);
  }

  Future<List<T>> next(@ActualInt32() int limit) async {
    return CardinalSdkPlatformInterface.instance
        .pagination
        .next(_instanceId, limit)
        .map((x) => _decodeT(x));
  }
}
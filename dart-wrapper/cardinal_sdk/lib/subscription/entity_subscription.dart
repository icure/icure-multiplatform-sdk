class EntitySubscription<T> {
  final String _instanceId;
  final T Function(Map<String, dynamic>) _decodeT;

  EntitySubscription(this._instanceId, this._decodeT);
}
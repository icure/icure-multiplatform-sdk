import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';

import '../../annotations/actual_int32.dart';

class PaginatedListIterator<T> {
  static final Finalizer<String> _finalizer = Finalizer((resourceId) => CardinalSdkPlatformInterface.instance.utils.releasePlatformResource(resourceId));

  final String _instanceId;
  final T Function(Map<String, dynamic>) _decodeT;

  PaginatedListIterator._(this._instanceId, this._decodeT);

  factory PaginatedListIterator(String instanceId, T Function(Map<String, dynamic>) decodeT) {
    final iterator = PaginatedListIterator._(instanceId, decodeT);
    _finalizer.attach(iterator, instanceId, detach: iterator);
    return iterator;
  }

  Future<bool> hasNext() async {
    return CardinalSdkPlatformInterface.instance.pagination.hasNext(_instanceId);
  }

  Future<List<T>> next(@ActualInt32() int limit) async {
    final nextJson = await CardinalSdkPlatformInterface.instance
        .pagination
        .next(_instanceId, limit);
    return nextJson.map((x) => _decodeT(x)).toList();
  }
}
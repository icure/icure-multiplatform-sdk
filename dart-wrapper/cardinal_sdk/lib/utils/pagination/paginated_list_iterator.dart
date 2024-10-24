import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';

import '../../annotations/actual_int32.dart';

class PaginatedListIterator<T> {
  final String _instanceId;
  final T Function(Map<String, dynamic>) _decodeT;

  PaginatedListIterator(this._instanceId, this._decodeT);

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
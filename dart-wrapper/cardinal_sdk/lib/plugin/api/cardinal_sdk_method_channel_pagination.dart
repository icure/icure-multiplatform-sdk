import 'dart:convert';
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/annotations/actual_int32.dart';

class CardinalSdkMethodChannelPagination extends CardinalSdkPlatformPaginationPlugin {

  final MethodChannel _methodChannel = const MethodChannel("com.icure.cardinal.sdk/pagination");

  CardinalSdkMethodChannelPagination();

  @override
  Future<bool> hasNext(String sdkId) async {
    final res = await _methodChannel.invokeMethod<String>(
        'PaginatedListIterator.hasNext',
        {
          "sdkId": sdkId
        }
    );
    if (res == null) throw AssertionError("received null result from platform method hasNext");
    return jsonDecode(res);
  }

  @override
  Future<List<dynamic>> next(String sdkId, @ActualInt32() int limit) async {
    final res = await _methodChannel.invokeMethod<String>(
        'PaginatedListIterator.next',
        {
          "sdkId": sdkId,
          "limit": limit
        }
    );
    if (res == null) throw AssertionError("received null result from platform method hasNext");
    return jsonDecode(res);
  }

}
import 'dart:convert';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/annotations/actual_int32.dart';

abstract class CardinalSdkPlatformPaginationPlugin {
  Future<bool> hasNext(String sdkId);
  Future<List<dynamic>> next(String sdkId, @ActualInt32() int limit);
}

class CardinalSdkMethodChannelPagination extends CardinalSdkPlatformPaginationPlugin {

  final MethodChannel _methodChannel = const MethodChannel("com.icure.cardinal.sdk/pagination");

  CardinalSdkMethodChannelPagination();

  @override
  Future<bool> hasNext(String paginatedListIteratorId) async {
    final res = await _methodChannel.invokeMethod<String>(
        'hasNext',
        {
          "paginatedListIteratorId": paginatedListIteratorId,
        }
    ).catchError(convertPlatformException);
    if (res == null) throw AssertionError("received null result from platform method hasNext");
    return jsonDecode(res);
  }

  @override
  Future<List<dynamic>> next(String paginatedListIteratorId, @ActualInt32() int limit) async {
    final res = await _methodChannel.invokeMethod<String>(
        'next',
        {
          "paginatedListIteratorId": paginatedListIteratorId,
          "limit": jsonEncode(limit)
        }
    ).catchError(convertPlatformException);
    if (res == null) throw AssertionError("received null result from platform method hasNext");
    return jsonDecode(res);
  }

}
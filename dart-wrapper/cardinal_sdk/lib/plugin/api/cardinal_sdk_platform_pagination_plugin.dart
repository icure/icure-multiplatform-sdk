import 'package:cardinal_sdk/annotations/actual_int32.dart';

abstract class CardinalSdkPlatformPaginationPlugin {
  Future<bool> hasNext(String sdkId);
  Future<List<dynamic>> next(String sdkId, @ActualInt32() int limit);
}
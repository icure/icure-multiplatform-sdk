// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/security/permission.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';


class PermissionPlatformApi {
	MethodChannel _methodChannel;
	PermissionPlatformApi(this._methodChannel);

	Future<List<Permission>> modifyUserPermissions(String sdkId, String userId, Permission permissions) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PermissionApi.modifyUserPermissions',
			{
				"sdkId": sdkId,
				"userId": jsonEncode(userId),
				"permissions": jsonEncode(Permission.encode(permissions)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyUserPermissions");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Permission.fromJSON(x1) ).toList();
	}
}
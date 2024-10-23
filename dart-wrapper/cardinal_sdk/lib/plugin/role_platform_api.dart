// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/role.dart';
import 'dart:convert';


class RolePlatformApi {
	MethodChannel _methodChannel;
	RolePlatformApi(this._methodChannel);

	Future<List<Role>> getAllRoles(String sdkId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'RoleApi.getAllRoles',
			{
				"sdkId": sdkId,
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getAllRoles");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => Role.fromJSON(x1) );
	}
}
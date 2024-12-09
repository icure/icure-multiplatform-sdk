// auto-generated file
import 'package:cardinal_sdk/cardinal_sdk.dart';
import 'package:cardinal_sdk/model/security/permission.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';


class PermissionApi {
	final String _sdkId;
	final CardinalSdk _dartSdk;
	PermissionApi(
		this._sdkId,
		this._dartSdk
		);

	Future<List<Permission>> modifyUserPermissions(String userId, Permission permissions) async {
		return await CardinalSdkPlatformInterface.instance.apis.permission.modifyUserPermissions(
			_sdkId,
			userId,
			permissions,
		);
	}
}
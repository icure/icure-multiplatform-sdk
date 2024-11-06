// auto-generated file
import 'package:cardinal_sdk/model/security/permission.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';


class PermissionApi {
	final String _sdkId;
	PermissionApi(this._sdkId);

	Future<List<Permission>> modifyUserPermissions(String userId, Permission permissions) async {
		return await CardinalSdkPlatformInterface.instance.apis.permission.modifyUserPermissions(
			_sdkId,
			userId,
			permissions,
		);
	}
}
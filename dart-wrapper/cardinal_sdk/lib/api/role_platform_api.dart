// auto-generated file
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/role.dart';


class RolePlatformApi {
	String _sdkId;
	RolePlatformApi(this._sdkId);

	Future<List<Role>> getAllRoles() async {
		return await CardinalSdkPlatformInterface.instance.apis.role.getAllRoles(
			_sdkId,
		);
	}
}
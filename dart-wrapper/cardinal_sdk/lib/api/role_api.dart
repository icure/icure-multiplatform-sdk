// auto-generated file
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/role.dart';


class RoleApi {
	final String _sdkId;
	final Object _dartSdk;
	RoleApi(
		this._sdkId,
		this._dartSdk
		);

	Future<List<Role>> getAllRoles() async {
		return await CardinalSdkPlatformInterface.instance.apis.role.getAllRoles(
			_sdkId,
		);
	}
}
// auto-generated file
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';


class AuthApi {
	final String _sdkId;
	final Object _dartSdk;
	AuthApi(
		this._sdkId,
		this._dartSdk
		);

	Future<String> getBearerToken() async {
		return await CardinalSdkPlatformInterface.instance.apis.auth.getBearerToken(
			_sdkId,
		);
	}
}
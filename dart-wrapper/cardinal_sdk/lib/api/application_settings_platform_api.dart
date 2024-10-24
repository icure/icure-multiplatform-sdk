// auto-generated file
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/application_settings.dart';


class ApplicationSettingsPlatformApi {
	String _sdkId;
	ApplicationSettingsPlatformApi(this._sdkId);

	Future<List<ApplicationSettings>> getApplicationSettings() async {
		return await CardinalSdkPlatformInterface.instance.apis.applicationSettings.getApplicationSettings(
			_sdkId,
		);
	}

	Future<ApplicationSettings> createApplicationSettings(ApplicationSettings applicationSettings) async {
		return await CardinalSdkPlatformInterface.instance.apis.applicationSettings.createApplicationSettings(
			_sdkId,
			applicationSettings,
		);
	}

	Future<ApplicationSettings> updateApplicationSettings(ApplicationSettings applicationSettings) async {
		return await CardinalSdkPlatformInterface.instance.apis.applicationSettings.updateApplicationSettings(
			_sdkId,
			applicationSettings,
		);
	}
}
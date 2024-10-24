// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/application_settings.dart';
import 'dart:convert';


class ApplicationSettingsPlatformApi {
	MethodChannel _methodChannel;
	ApplicationSettingsPlatformApi(this._methodChannel);

	Future<List<ApplicationSettings>> getApplicationSettings(String sdkId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ApplicationSettingsApi.getApplicationSettings',
			{
				"sdkId": sdkId,
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getApplicationSettings");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => ApplicationSettings.fromJSON(x1) );
	}

	Future<ApplicationSettings> createApplicationSettings(String sdkId, ApplicationSettings applicationSettings) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ApplicationSettingsApi.createApplicationSettings',
			{
				"sdkId": sdkId,
				"applicationSettings": jsonEncode(ApplicationSettings.encode(applicationSettings)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method createApplicationSettings");
		final parsedResJson = jsonDecode(res);
		return ApplicationSettings.fromJSON(parsedResJson);
	}

	Future<ApplicationSettings> updateApplicationSettings(String sdkId, ApplicationSettings applicationSettings) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ApplicationSettingsApi.updateApplicationSettings',
			{
				"sdkId": sdkId,
				"applicationSettings": jsonEncode(ApplicationSettings.encode(applicationSettings)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method updateApplicationSettings");
		final parsedResJson = jsonDecode(res);
		return ApplicationSettings.fromJSON(parsedResJson);
	}
}
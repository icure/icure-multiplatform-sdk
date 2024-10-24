// auto-generated file
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/tarification.dart';


class TarificationPlatformApi {
	String _sdkId;
	TarificationPlatformApi(this._sdkId);

	Future<Tarification> getTarification(String tarificationId) async {
		return await CardinalSdkPlatformInterface.instance.apis.tarification.getTarification(
			_sdkId,
			tarificationId,
		);
	}

	Future<Tarification> createTarification(Tarification tarification) async {
		return await CardinalSdkPlatformInterface.instance.apis.tarification.createTarification(
			_sdkId,
			tarification,
		);
	}

	Future<List<Tarification>> getTarifications(List<String> tarificationIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.tarification.getTarifications(
			_sdkId,
			tarificationIds,
		);
	}

	Future<Tarification> modifyTarification(Tarification tarification) async {
		return await CardinalSdkPlatformInterface.instance.apis.tarification.modifyTarification(
			_sdkId,
			tarification,
		);
	}

	Future<Tarification> getTarificationWithParts(String type, String tarification, String version) async {
		return await CardinalSdkPlatformInterface.instance.apis.tarification.getTarificationWithParts(
			_sdkId,
			type,
			tarification,
			version,
		);
	}
}
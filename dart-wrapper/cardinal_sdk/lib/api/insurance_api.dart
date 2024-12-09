// auto-generated file
import 'package:cardinal_sdk/cardinal_sdk.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/insurance.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';


class InsuranceApi {
	final String _sdkId;
	final CardinalSdk _dartSdk;
	InsuranceApi(
		this._sdkId,
		this._dartSdk
		);

	Future<Insurance> getInsurance(String insuranceId) async {
		return await CardinalSdkPlatformInterface.instance.apis.insurance.getInsurance(
			_sdkId,
			insuranceId,
		);
	}

	Future<List<Insurance>> getInsurances(List<String> insuranceIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.insurance.getInsurances(
			_sdkId,
			insuranceIds,
		);
	}

	Future<Insurance> createInsurance(Insurance insurance) async {
		return await CardinalSdkPlatformInterface.instance.apis.insurance.createInsurance(
			_sdkId,
			insurance,
		);
	}

	Future<DocIdentifier> deleteInsurance(String insuranceId) async {
		return await CardinalSdkPlatformInterface.instance.apis.insurance.deleteInsurance(
			_sdkId,
			insuranceId,
		);
	}

	Future<List<Insurance>> listInsurancesByCode(String insuranceCode) async {
		return await CardinalSdkPlatformInterface.instance.apis.insurance.listInsurancesByCode(
			_sdkId,
			insuranceCode,
		);
	}

	Future<List<Insurance>> listInsurancesByName(String insuranceName) async {
		return await CardinalSdkPlatformInterface.instance.apis.insurance.listInsurancesByName(
			_sdkId,
			insuranceName,
		);
	}

	Future<Insurance> modifyInsurance(Insurance insurance) async {
		return await CardinalSdkPlatformInterface.instance.apis.insurance.modifyInsurance(
			_sdkId,
			insurance,
		);
	}
}
// auto-generated file
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/insurance.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';


class InsurancePlatformApi {
	String _sdkId;
	InsurancePlatformApi(this._sdkId);

	Future<Insurance> getInsurance(String insuranceId) async {
		return await CardinalSdkPlatformInterface.instance.insurance.getInsurance(
			_sdkId,
			insuranceId,
		);
	}

	Future<List<Insurance>> getInsurances(List<String> insuranceIds) async {
		return await CardinalSdkPlatformInterface.instance.insurance.getInsurances(
			_sdkId,
			insuranceIds,
		);
	}

	Future<Insurance> createInsurance(Insurance insurance) async {
		return await CardinalSdkPlatformInterface.instance.insurance.createInsurance(
			_sdkId,
			insurance,
		);
	}

	Future<DocIdentifier> deleteInsurance(String insuranceId) async {
		return await CardinalSdkPlatformInterface.instance.insurance.deleteInsurance(
			_sdkId,
			insuranceId,
		);
	}

	Future<List<Insurance>> listInsurancesByCode(String insuranceCode) async {
		return await CardinalSdkPlatformInterface.instance.insurance.listInsurancesByCode(
			_sdkId,
			insuranceCode,
		);
	}

	Future<List<Insurance>> listInsurancesByName(String insuranceName) async {
		return await CardinalSdkPlatformInterface.instance.insurance.listInsurancesByName(
			_sdkId,
			insuranceName,
		);
	}

	Future<Insurance> modifyInsurance(Insurance insurance) async {
		return await CardinalSdkPlatformInterface.instance.insurance.modifyInsurance(
			_sdkId,
			insurance,
		);
	}
}
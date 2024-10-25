import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/medical_location.dart';


abstract class MedicalLocationFilters {
	MedicalLocationFilters();

	static Future<BaseFilterOptions<MedicalLocation>> all() async {
		return CardinalSdkPlatformInterface.instance.filters.medicalLocation.all(
		);
	}

	static Future<BaseFilterOptions<MedicalLocation>> byPostCode(String postCode) async {
		return CardinalSdkPlatformInterface.instance.filters.medicalLocation.byPostCode(
			postCode,
		);
	}
}
// auto-generated file
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/user.dart';


abstract class UserFilters {
	UserFilters();

	static Future<BaseFilterOptions<User>> all() async {
		return CardinalSdkPlatformInterface.instance.filters.user.all(
		);
	}

	static Future<BaseSortableFilterOptions<User>> byIds(List<String> ids) async {
		return CardinalSdkPlatformInterface.instance.filters.user.byIds(
			ids,
		);
	}

	static Future<BaseFilterOptions<User>> byPatientId(String patientId) async {
		return CardinalSdkPlatformInterface.instance.filters.user.byPatientId(
			patientId,
		);
	}

	static Future<BaseFilterOptions<User>> byHealthcarePartyId(String healthcarePartyId) async {
		return CardinalSdkPlatformInterface.instance.filters.user.byHealthcarePartyId(
			healthcarePartyId,
		);
	}

	static Future<BaseFilterOptions<User>> byNameEmailOrPhone(String searchString) async {
		return CardinalSdkPlatformInterface.instance.filters.user.byNameEmailOrPhone(
			searchString,
		);
	}
}
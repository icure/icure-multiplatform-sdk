import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/healthcare_party.dart';
import 'package:cardinal_sdk/model/base/identifier.dart';


abstract class HealthcarePartyFilters {
	HealthcarePartyFilters();

	static Future<BaseFilterOptions<HealthcareParty>> all() async {
		return CardinalSdkPlatformInterface.instance.filters.healthcareParty.all(
		);
	}

	static Future<BaseFilterOptions<HealthcareParty>> byIdentifiers(List<Identifier> identifiers) async {
		return CardinalSdkPlatformInterface.instance.filters.healthcareParty.byIdentifiers(
			identifiers,
		);
	}

	static Future<BaseSortableFilterOptions<HealthcareParty>> byCode(String codeType, String? codeCode) async {
		return CardinalSdkPlatformInterface.instance.filters.healthcareParty.byCode(
			codeType,
			codeCode,
		);
	}

	static Future<BaseSortableFilterOptions<HealthcareParty>> byTag(String tagType, String? tagCode) async {
		return CardinalSdkPlatformInterface.instance.filters.healthcareParty.byTag(
			tagType,
			tagCode,
		);
	}

	static Future<SortableFilterOptions<HealthcareParty>> byIds(List<String> ids) async {
		return CardinalSdkPlatformInterface.instance.filters.healthcareParty.byIds(
			ids,
		);
	}

	static Future<BaseSortableFilterOptions<HealthcareParty>> byName(String searchString, { bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.healthcareParty.byName(
			searchString,
			descending: descending,
		);
	}

	static Future<BaseSortableFilterOptions<HealthcareParty>> byNationalIdentifier(String searchString, { bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.healthcareParty.byNationalIdentifier(
			searchString,
			descending: descending,
		);
	}

	static Future<BaseFilterOptions<HealthcareParty>> byParentId(String parentId) async {
		return CardinalSdkPlatformInterface.instance.filters.healthcareParty.byParentId(
			parentId,
		);
	}

	static Future<BaseFilterOptions<HealthcareParty>> byTypeSpecialtyPostCode(String specialty, String specCode, String startPostCode, String endPostCode) async {
		return CardinalSdkPlatformInterface.instance.filters.healthcareParty.byTypeSpecialtyPostCode(
			specialty,
			specCode,
			startPostCode,
			endPostCode,
		);
	}
}
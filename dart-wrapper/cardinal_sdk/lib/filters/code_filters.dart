import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/code.dart';


abstract class CodeFilters {
	CodeFilters();

	static Future<BaseFilterOptions<Code>> all() async {
		return CardinalSdkPlatformInterface.instance.filters.code.all(
		);
	}

	static Future<BaseSortableFilterOptions<Code>> byIds(List<String> ids) async {
		return CardinalSdkPlatformInterface.instance.filters.code.byIds(
			ids,
		);
	}

	static Future<BaseFilterOptions<Code>> byQualifiedLink(String linkType, String? linkedId) async {
		return CardinalSdkPlatformInterface.instance.filters.code.byQualifiedLink(
			linkType,
			linkedId,
		);
	}

	static Future<BaseFilterOptions<Code>> byRegionTypeCodeVersion(String region, String? type, String? code, String? version) async {
		return CardinalSdkPlatformInterface.instance.filters.code.byRegionTypeCodeVersion(
			region,
			type,
			code,
			version,
		);
	}

	static Future<BaseFilterOptions<Code>> byLanguageTypeLabelRegion(String language, String type, String? label, String? region) async {
		return CardinalSdkPlatformInterface.instance.filters.code.byLanguageTypeLabelRegion(
			language,
			type,
			label,
			region,
		);
	}

	static Future<BaseFilterOptions<Code>> byLanguageTypesLabelRegionVersion(String language, List<String> types, String label, String? region, String? version) async {
		return CardinalSdkPlatformInterface.instance.filters.code.byLanguageTypesLabelRegionVersion(
			language,
			types,
			label,
			region,
			version,
		);
	}
}
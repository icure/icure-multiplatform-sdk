// auto-generated file
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/group.dart';


abstract class GroupFilters {
	GroupFilters();

	static Future<BaseFilterOptions<Group>> all() async {
		return CardinalSdkPlatformInterface.instance.filters.group.all(
		);
	}

	static Future<BaseFilterOptions<Group>> bySuperGroup(String superGroupId) async {
		return CardinalSdkPlatformInterface.instance.filters.group.bySuperGroup(
			superGroupId,
		);
	}

	static Future<BaseSortableFilterOptions<Group>> withContent(String superGroupId, String searchString) async {
		return CardinalSdkPlatformInterface.instance.filters.group.withContent(
			superGroupId,
			searchString,
		);
	}
}
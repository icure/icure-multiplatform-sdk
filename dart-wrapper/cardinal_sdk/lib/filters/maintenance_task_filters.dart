import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/maintenance_task.dart';
import 'package:cardinal_sdk/model/base/identifier.dart';


abstract class MaintenanceTaskFilters {
	MaintenanceTaskFilters();

	static Future<BaseSortableFilterOptions<MaintenanceTask>> byIds(List<String> ids) async {
		return CardinalSdkPlatformInterface.instance.filters.maintenanceTask.byIds(
			ids,
		);
	}

	static Future<BaseSortableFilterOptions<MaintenanceTask>> byIdentifiersForDataOwner(String dataOwnerId, List<Identifier> identifiers) async {
		return CardinalSdkPlatformInterface.instance.filters.maintenanceTask.byIdentifiersForDataOwner(
			dataOwnerId,
			identifiers,
		);
	}

	static Future<SortableFilterOptions<MaintenanceTask>> byIdentifiersForSelf(List<Identifier> identifiers) async {
		return CardinalSdkPlatformInterface.instance.filters.maintenanceTask.byIdentifiersForSelf(
			identifiers,
		);
	}

	static Future<BaseFilterOptions<MaintenanceTask>> byTypeForDataOwner(String dataOwnerId, String type) async {
		return CardinalSdkPlatformInterface.instance.filters.maintenanceTask.byTypeForDataOwner(
			dataOwnerId,
			type,
		);
	}

	static Future<FilterOptions<MaintenanceTask>> byTypeForSelf(String type) async {
		return CardinalSdkPlatformInterface.instance.filters.maintenanceTask.byTypeForSelf(
			type,
		);
	}

	static Future<BaseSortableFilterOptions<MaintenanceTask>> afterDateForDataOwner(String dataOwnerId, int date) async {
		return CardinalSdkPlatformInterface.instance.filters.maintenanceTask.afterDateForDataOwner(
			dataOwnerId,
			date,
		);
	}

	static Future<SortableFilterOptions<MaintenanceTask>> afterDateForSelf(int date) async {
		return CardinalSdkPlatformInterface.instance.filters.maintenanceTask.afterDateForSelf(
			date,
		);
	}
}
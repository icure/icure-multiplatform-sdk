import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/device.dart';


abstract class DeviceFilters {
	DeviceFilters();

	static Future<BaseFilterOptions<Device>> all() async {
		return CardinalSdkPlatformInterface.instance.filters.device.all(
		);
	}

	static Future<BaseFilterOptions<Device>> byResponsible(String responsibleId) async {
		return CardinalSdkPlatformInterface.instance.filters.device.byResponsible(
			responsibleId,
		);
	}

	static Future<BaseSortableFilterOptions<Device>> byIds(List<String> ids) async {
		return CardinalSdkPlatformInterface.instance.filters.device.byIds(
			ids,
		);
	}
}
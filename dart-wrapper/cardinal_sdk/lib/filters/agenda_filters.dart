// auto-generated file
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/agenda.dart';


abstract class AgendaFilters {
	AgendaFilters();

	static Future<BaseFilterOptions<Agenda>> all() async {
		return CardinalSdkPlatformInterface.instance.filters.agenda.all(
		);
	}

	static Future<BaseFilterOptions<Agenda>> byUser(String userId) async {
		return CardinalSdkPlatformInterface.instance.filters.agenda.byUser(
			userId,
		);
	}

	static Future<BaseFilterOptions<Agenda>> readableByUser(String userId) async {
		return CardinalSdkPlatformInterface.instance.filters.agenda.readableByUser(
			userId,
		);
	}
}
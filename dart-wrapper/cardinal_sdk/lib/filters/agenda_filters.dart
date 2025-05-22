// auto-generated file
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/agenda.dart';
import 'package:cardinal_sdk/model/entity_reference_in_group.dart';


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

	static Future<BaseFilterOptions<Agenda>> byUserInGroup(EntityReferenceInGroup userReference) async {
		return CardinalSdkPlatformInterface.instance.filters.agenda.byUserInGroup(
			userReference,
		);
	}

	static Future<BaseFilterOptions<Agenda>> readableByUser(String userId) async {
		return CardinalSdkPlatformInterface.instance.filters.agenda.readableByUser(
			userId,
		);
	}

	static Future<BaseFilterOptions<Agenda>> readableByUserInGroup(EntityReferenceInGroup userReference) async {
		return CardinalSdkPlatformInterface.instance.filters.agenda.readableByUserInGroup(
			userReference,
		);
	}

	static Future<BaseFilterOptions<Agenda>> readableByUserRights(String userId) async {
		return CardinalSdkPlatformInterface.instance.filters.agenda.readableByUserRights(
			userId,
		);
	}

	static Future<BaseFilterOptions<Agenda>> readableByUserRightsInGroup(EntityReferenceInGroup userReference) async {
		return CardinalSdkPlatformInterface.instance.filters.agenda.readableByUserRightsInGroup(
			userReference,
		);
	}

	static Future<BaseFilterOptions<Agenda>> byStringProperty(String propertyId, String propertyValue) async {
		return CardinalSdkPlatformInterface.instance.filters.agenda.byStringProperty(
			propertyId,
			propertyValue,
		);
	}

	static Future<BaseFilterOptions<Agenda>> byBooleanProperty(String propertyId, bool propertyValue) async {
		return CardinalSdkPlatformInterface.instance.filters.agenda.byBooleanProperty(
			propertyId,
			propertyValue,
		);
	}

	static Future<BaseFilterOptions<Agenda>> byLongProperty(String propertyId, int propertyValue) async {
		return CardinalSdkPlatformInterface.instance.filters.agenda.byLongProperty(
			propertyId,
			propertyValue,
		);
	}

	static Future<BaseFilterOptions<Agenda>> byDoubleProperty(String propertyId, double propertyValue) async {
		return CardinalSdkPlatformInterface.instance.filters.agenda.byDoubleProperty(
			propertyId,
			propertyValue,
		);
	}

	static Future<BaseFilterOptions<Agenda>> withProperty(String propertyId) async {
		return CardinalSdkPlatformInterface.instance.filters.agenda.withProperty(
			propertyId,
		);
	}
}
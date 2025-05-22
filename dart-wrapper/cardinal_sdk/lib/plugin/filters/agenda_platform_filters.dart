// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/agenda.dart';
import 'package:cardinal_sdk/model/entity_reference_in_group.dart';


class AgendaPlatformFilters {
	MethodChannel _methodChannel;
	AgendaPlatformFilters(this._methodChannel);

	Future<BaseFilterOptions<Agenda>> all() async {
		final res = await _methodChannel.invokeMethod<String>(
			'AgendaFilters.all',
			{
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method all");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseFilterOptions<Agenda>> byUser(String userId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AgendaFilters.byUser',
			{
				"userId": jsonEncode(userId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byUser");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseFilterOptions<Agenda>> byUserInGroup(EntityReferenceInGroup userReference) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AgendaFilters.byUserInGroup',
			{
				"userReference": jsonEncode(EntityReferenceInGroup.encode(userReference)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byUserInGroup");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseFilterOptions<Agenda>> readableByUser(String userId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AgendaFilters.readableByUser',
			{
				"userId": jsonEncode(userId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method readableByUser");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseFilterOptions<Agenda>> readableByUserInGroup(EntityReferenceInGroup userReference) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AgendaFilters.readableByUserInGroup',
			{
				"userReference": jsonEncode(EntityReferenceInGroup.encode(userReference)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method readableByUserInGroup");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseFilterOptions<Agenda>> readableByUserRights(String userId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AgendaFilters.readableByUserRights',
			{
				"userId": jsonEncode(userId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method readableByUserRights");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseFilterOptions<Agenda>> readableByUserRightsInGroup(EntityReferenceInGroup userReference) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AgendaFilters.readableByUserRightsInGroup',
			{
				"userReference": jsonEncode(EntityReferenceInGroup.encode(userReference)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method readableByUserRightsInGroup");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseFilterOptions<Agenda>> byStringProperty(String propertyId, String propertyValue) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AgendaFilters.byStringProperty',
			{
				"propertyId": jsonEncode(propertyId),
				"propertyValue": jsonEncode(propertyValue),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byStringProperty");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseFilterOptions<Agenda>> byBooleanProperty(String propertyId, bool propertyValue) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AgendaFilters.byBooleanProperty',
			{
				"propertyId": jsonEncode(propertyId),
				"propertyValue": jsonEncode(propertyValue),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byBooleanProperty");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseFilterOptions<Agenda>> byLongProperty(String propertyId, int propertyValue) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AgendaFilters.byLongProperty',
			{
				"propertyId": jsonEncode(propertyId),
				"propertyValue": jsonEncode(propertyValue),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byLongProperty");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseFilterOptions<Agenda>> byDoubleProperty(String propertyId, double propertyValue) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AgendaFilters.byDoubleProperty',
			{
				"propertyId": jsonEncode(propertyId),
				"propertyValue": jsonEncode(propertyValue),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byDoubleProperty");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseFilterOptions<Agenda>> withProperty(String propertyId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AgendaFilters.withProperty',
			{
				"propertyId": jsonEncode(propertyId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method withProperty");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}
}
// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'package:cardinal_sdk/model/maintenance_task.dart';
import 'package:cardinal_sdk/model/base/identifier.dart';


class MaintenanceTaskPlatformFilters {
	MethodChannel _methodChannel;
	MaintenanceTaskPlatformFilters(this._methodChannel);

	Future<BaseSortableFilterOptions<MaintenanceTask>> byIds(List<String> ids) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskFilters.byIds',
			{
				"ids": jsonEncode(ids.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byIds");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<MaintenanceTask>> byIdentifiersForDataOwner(String dataOwnerId, List<Identifier> identifiers) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskFilters.byIdentifiersForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"identifiers": jsonEncode(identifiers.map((x0) => Identifier.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byIdentifiersForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<MaintenanceTask>> byIdentifiersForSelf(List<Identifier> identifiers) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskFilters.byIdentifiersForSelf',
			{
				"identifiers": jsonEncode(identifiers.map((x0) => Identifier.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byIdentifiersForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseFilterOptions<MaintenanceTask>> byTypeForDataOwner(String dataOwnerId, String type) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskFilters.byTypeForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"type": jsonEncode(type),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byTypeForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<FilterOptions<MaintenanceTask>> byTypeForSelf(String type) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskFilters.byTypeForSelf',
			{
				"type": jsonEncode(type),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byTypeForSelf");
		final parsedResJson = jsonDecode(res);
		return FilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<MaintenanceTask>> afterDateForDataOwner(String dataOwnerId, int date) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskFilters.afterDateForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"date": jsonEncode(date),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method afterDateForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<MaintenanceTask>> afterDateForSelf(int date) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskFilters.afterDateForSelf',
			{
				"date": jsonEncode(date),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method afterDateForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}
}
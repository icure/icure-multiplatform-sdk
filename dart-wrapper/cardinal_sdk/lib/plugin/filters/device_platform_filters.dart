// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/device.dart';


class DevicePlatformFilters {
	MethodChannel _methodChannel;
	DevicePlatformFilters(this._methodChannel);

	Future<BaseFilterOptions<Device>> all() async {
		final res = await _methodChannel.invokeMethod<String>(
			'DeviceFilters.all',
			{
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method all");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseFilterOptions<Device>> byResponsible(String responsibleId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DeviceFilters.byResponsible',
			{
				"responsibleId": jsonEncode(responsibleId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byResponsible");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<Device>> byIds(List<String> ids) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DeviceFilters.byIds',
			{
				"ids": jsonEncode(ids.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byIds");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}
}
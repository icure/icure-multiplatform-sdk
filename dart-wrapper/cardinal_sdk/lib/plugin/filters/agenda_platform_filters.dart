// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/agenda.dart';


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
}
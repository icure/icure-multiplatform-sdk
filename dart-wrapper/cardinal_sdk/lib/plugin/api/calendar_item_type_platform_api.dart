// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/calendar_item_type.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'package:cardinal_sdk/model/list_of_ids.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';


class CalendarItemTypePlatformApi {
	MethodChannel _methodChannel;
	CalendarItemTypePlatformApi(this._methodChannel);

	Future<CalendarItemType> createCalendarItemType(String sdkId, CalendarItemType calendarItemTypeDto) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemTypeApi.createCalendarItemType',
			{
				"sdkId": sdkId,
				"calendarItemTypeDto": jsonEncode(CalendarItemType.encode(calendarItemTypeDto)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createCalendarItemType");
		final parsedResJson = jsonDecode(res);
		return CalendarItemType.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteCalendarItemTypes(String sdkId, ListOfIds calendarItemTypeIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemTypeApi.deleteCalendarItemTypes',
			{
				"sdkId": sdkId,
				"calendarItemTypeIds": jsonEncode(ListOfIds.encode(calendarItemTypeIds)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteCalendarItemTypes");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}

	Future<CalendarItemType?> getCalendarItemType(String sdkId, String calendarItemTypeId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemTypeApi.getCalendarItemType',
			{
				"sdkId": sdkId,
				"calendarItemTypeId": jsonEncode(calendarItemTypeId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getCalendarItemType");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : CalendarItemType.fromJSON(parsedResJson);
	}

	Future<CalendarItemType> modifyCalendarItemType(String sdkId, CalendarItemType calendarItemTypeDto) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemTypeApi.modifyCalendarItemType',
			{
				"sdkId": sdkId,
				"calendarItemTypeDto": jsonEncode(CalendarItemType.encode(calendarItemTypeDto)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyCalendarItemType");
		final parsedResJson = jsonDecode(res);
		return CalendarItemType.fromJSON(parsedResJson);
	}

	Future<List<CalendarItemType>> listCalendarItemTypesByAgendaId(String sdkId, String agendaId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemTypeApi.listCalendarItemTypesByAgendaId',
			{
				"sdkId": sdkId,
				"agendaId": jsonEncode(agendaId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method listCalendarItemTypesByAgendaId");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => CalendarItemType.fromJSON(x1) ).toList();
	}
}
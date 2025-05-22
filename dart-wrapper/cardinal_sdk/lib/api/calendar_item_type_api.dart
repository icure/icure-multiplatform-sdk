// auto-generated file
import 'package:cardinal_sdk/model/calendar_item_type.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/list_of_ids.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';


class CalendarItemTypeApi {
	final String _sdkId;
	final Object _dartSdk;
	CalendarItemTypeApi(
		this._sdkId,
		this._dartSdk
		);

	Future<CalendarItemType> createCalendarItemType(CalendarItemType calendarItemTypeDto) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemType.createCalendarItemType(
			_sdkId,
			calendarItemTypeDto,
		);
	}

	Future<List<DocIdentifier>> deleteCalendarItemTypes(ListOfIds calendarItemTypeIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemType.deleteCalendarItemTypes(
			_sdkId,
			calendarItemTypeIds,
		);
	}

	Future<CalendarItemType?> getCalendarItemType(String calendarItemTypeId) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemType.getCalendarItemType(
			_sdkId,
			calendarItemTypeId,
		);
	}

	Future<CalendarItemType> modifyCalendarItemType(CalendarItemType calendarItemTypeDto) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemType.modifyCalendarItemType(
			_sdkId,
			calendarItemTypeDto,
		);
	}

	Future<List<CalendarItemType>> listCalendarItemTypesByAgendaId(String agendaId) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemType.listCalendarItemTypesByAgendaId(
			_sdkId,
			agendaId,
		);
	}
}
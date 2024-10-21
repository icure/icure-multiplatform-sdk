// This file is auto-generated
import 'package:cardinal_sdk/annotations/actual_int32.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';


class CalendarItemType implements StoredDocument {
	@override  String id;
	@override  String? rev;
	@override  int? deletionDate;
	String? name;
	String? color;
	int _duration = 0;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") int get duration => _duration;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") set duration(int value) {
		if (value > 2147483647) {
			throw ArgumentError('duration value cannot exceed 2147483647');
		}
		_duration = value;
	}
	String? externalRef;
	String? mikronoId;
	Set<String> docIds = {};
	Map<String, String> otherInfos = {};
	Map<String, String> subjectByLanguage = {};

	CalendarItemType({
		required this.id,
		int? duration,
		this.rev,
		this.deletionDate,
		this.name,
		this.color,
		this.externalRef,
		this.mikronoId,
		Set<String>? docIds,
		Map<String, String>? otherInfos,
		Map<String, String>? subjectByLanguage
	}) : docIds = docIds ?? {},
		otherInfos = otherInfos ?? {},
		subjectByLanguage = subjectByLanguage ?? {},
		_duration = duration ?? 0;

	static Map<String, dynamic> encode(CalendarItemType value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"deletionDate" : value.deletionDate,
			"name" : value.name,
			"color" : value.color,
			"duration" : value.duration,
			"externalRef" : value.externalRef,
			"mikronoId" : value.mikronoId,
			"docIds" : value.docIds.map((x0) => x0),
			"otherInfos" : value.otherInfos.map((k0, v0) => MapEntry(k0, v0)),
			"subjectByLanguage" : value.subjectByLanguage.map((k0, v0) => MapEntry(k0, v0))
		};
		return entityAsMap;
	}
}
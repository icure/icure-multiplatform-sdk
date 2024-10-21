// This file is auto-generated
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/embed/address.dart';
import 'package:cardinal_sdk/model/embed/calendar_item_tag.dart';
import 'package:cardinal_sdk/model/embed/flow_item.dart';
import 'package:cardinal_sdk/model/embed/delegation.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/security_metadata.dart';
import 'package:cardinal_sdk/model/calendar_item.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/icure_document.dart';
import 'package:cardinal_sdk/model/base/has_encryption_metadata.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';


sealed class CalendarItem implements StoredDocument, ICureDocument<String>, HasEncryptionMetadata, Encryptable {
	@override abstract String id;
	@override abstract String? rev;
	@override abstract int? created;
	@override abstract int? modified;
	@override abstract String? author;
	@override abstract String? responsible;
	@override abstract String? medicalLocationId;
	@override abstract Set<CodeStub> tags;
	@override abstract Set<CodeStub> codes;
	@override abstract int? endOfLife;
	@override abstract int? deletionDate;
	abstract String? title;
	abstract String? calendarItemTypeId;
	abstract String? masterCalendarItemId;
	abstract String? patientId;
	abstract bool? important;
	abstract bool? homeVisit;
	abstract String? phoneNumber;
	abstract String? placeId;
	Address? get address;
	abstract String? addressText;
	abstract int? startTime;
	abstract int? endTime;
	abstract int? confirmationTime;
	abstract int? cancellationTimestamp;
	abstract String? confirmationId;
	abstract int? duration;
	abstract bool? allDay;
	abstract String? details;
	abstract bool? wasMigrated;
	abstract String? agendaId;
	abstract String? hcpId;
	abstract String? recurrenceId;
	abstract Set<CalendarItemTag> meetingTags;
	abstract FlowItem? flowItem;
	@override abstract Set<String> secretForeignKeys;
	@override abstract Map<String, Set<Delegation>> cryptedForeignKeys;
	@override abstract Map<String, Set<Delegation>> delegations;
	@override abstract Map<String, Set<Delegation>> encryptionKeys;
	@override abstract Base64String? encryptedSelf;
	@override abstract SecurityMetadata? securityMetadata;


	static Map<String, dynamic> encode(CalendarItem value) {
		switch (value) {
			case DecryptedCalendarItem entity:
				Map<String, dynamic> entityJson = DecryptedCalendarItem.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.DecryptedCalendarItem";
				return entityJson;
			case EncryptedCalendarItem entity:
				Map<String, dynamic> entityJson = EncryptedCalendarItem.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.EncryptedCalendarItem";
				return entityJson;
		}
	}
}

class DecryptedCalendarItem implements CalendarItem {
	@override  String id;
	@override  String? rev;
	@override  int? created;
	@override  int? modified;
	@override  String? author;
	@override  String? responsible;
	@override  String? medicalLocationId;
	@override  Set<CodeStub> tags = {};
	@override  Set<CodeStub> codes = {};
	@override  int? endOfLife;
	@override  int? deletionDate;
	@override  String? title;
	@override  String? calendarItemTypeId;
	@override  String? masterCalendarItemId;
	@override  String? patientId;
	@override  bool? important;
	@override  bool? homeVisit;
	@override  String? phoneNumber;
	@override  String? placeId;
	@override  DecryptedAddress? address;
	@override  String? addressText;
	@override  int? startTime;
	@override  int? endTime;
	@override  int? confirmationTime;
	@override  int? cancellationTimestamp;
	@override  String? confirmationId;
	@override  int? duration;
	@override  bool? allDay;
	@override  String? details;
	@override  bool? wasMigrated;
	@override  String? agendaId;
	@override  String? hcpId;
	@override  String? recurrenceId;
	@override  Set<CalendarItemTag> meetingTags = {};
	@override  FlowItem? flowItem;
	@override  Set<String> secretForeignKeys = {};
	@override  Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override  Map<String, Set<Delegation>> delegations = {};
	@override  Map<String, Set<Delegation>> encryptionKeys = {};
	@override  Base64String? encryptedSelf;
	@override  SecurityMetadata? securityMetadata;

	DecryptedCalendarItem({
		required this.id,
		this.rev,
		this.created,
		this.modified,
		this.author,
		this.responsible,
		this.medicalLocationId,
		this.endOfLife,
		this.deletionDate,
		this.title,
		this.calendarItemTypeId,
		this.masterCalendarItemId,
		this.patientId,
		this.important,
		this.homeVisit,
		this.phoneNumber,
		this.placeId,
		this.address,
		this.addressText,
		this.startTime,
		this.endTime,
		this.confirmationTime,
		this.cancellationTimestamp,
		this.confirmationId,
		this.duration,
		this.allDay,
		this.details,
		this.wasMigrated,
		this.agendaId,
		this.hcpId,
		this.recurrenceId,
		this.flowItem,
		this.encryptedSelf,
		this.securityMetadata,
		Set<CodeStub>? tags,
		Set<CodeStub>? codes,
		Set<CalendarItemTag>? meetingTags,
		Set<String>? secretForeignKeys,
		Map<String, Set<Delegation>>? cryptedForeignKeys,
		Map<String, Set<Delegation>>? delegations,
		Map<String, Set<Delegation>>? encryptionKeys
	}) : tags = tags ?? {},
		codes = codes ?? {},
		meetingTags = meetingTags ?? {},
		secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {};

	static Map<String, dynamic> encode(DecryptedCalendarItem value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"created" : value.created,
			"modified" : value.modified,
			"author" : value.author,
			"responsible" : value.responsible,
			"medicalLocationId" : value.medicalLocationId,
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)),
			"endOfLife" : value.endOfLife,
			"deletionDate" : value.deletionDate,
			"title" : value.title,
			"calendarItemTypeId" : value.calendarItemTypeId,
			"masterCalendarItemId" : value.masterCalendarItemId,
			"patientId" : value.patientId,
			"important" : value.important,
			"homeVisit" : value.homeVisit,
			"phoneNumber" : value.phoneNumber,
			"placeId" : value.placeId,
			"address" : value.address == null ? null : DecryptedAddress.encode(value.address!),
			"addressText" : value.addressText,
			"startTime" : value.startTime,
			"endTime" : value.endTime,
			"confirmationTime" : value.confirmationTime,
			"cancellationTimestamp" : value.cancellationTimestamp,
			"confirmationId" : value.confirmationId,
			"duration" : value.duration,
			"allDay" : value.allDay,
			"details" : value.details,
			"wasMigrated" : value.wasMigrated,
			"agendaId" : value.agendaId,
			"hcpId" : value.hcpId,
			"recurrenceId" : value.recurrenceId,
			"meetingTags" : value.meetingTags.map((x0) => CalendarItemTag.encode(x0)),
			"flowItem" : value.flowItem == null ? null : FlowItem.encode(value.flowItem!),
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"encryptedSelf" : value.encryptedSelf,
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!)
		};
		return entityAsMap;
	}
}

class EncryptedCalendarItem implements CalendarItem {
	@override  String id;
	@override  String? rev;
	@override  int? created;
	@override  int? modified;
	@override  String? author;
	@override  String? responsible;
	@override  String? medicalLocationId;
	@override  Set<CodeStub> tags = {};
	@override  Set<CodeStub> codes = {};
	@override  int? endOfLife;
	@override  int? deletionDate;
	@override  String? title;
	@override  String? calendarItemTypeId;
	@override  String? masterCalendarItemId;
	@override  String? patientId;
	@override  bool? important;
	@override  bool? homeVisit;
	@override  String? phoneNumber;
	@override  String? placeId;
	@override  EncryptedAddress? address;
	@override  String? addressText;
	@override  int? startTime;
	@override  int? endTime;
	@override  int? confirmationTime;
	@override  int? cancellationTimestamp;
	@override  String? confirmationId;
	@override  int? duration;
	@override  bool? allDay;
	@override  String? details;
	@override  bool? wasMigrated;
	@override  String? agendaId;
	@override  String? hcpId;
	@override  String? recurrenceId;
	@override  Set<CalendarItemTag> meetingTags = {};
	@override  FlowItem? flowItem;
	@override  Set<String> secretForeignKeys = {};
	@override  Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override  Map<String, Set<Delegation>> delegations = {};
	@override  Map<String, Set<Delegation>> encryptionKeys = {};
	@override  Base64String? encryptedSelf;
	@override  SecurityMetadata? securityMetadata;

	EncryptedCalendarItem({
		required this.id,
		this.rev,
		this.created,
		this.modified,
		this.author,
		this.responsible,
		this.medicalLocationId,
		this.endOfLife,
		this.deletionDate,
		this.title,
		this.calendarItemTypeId,
		this.masterCalendarItemId,
		this.patientId,
		this.important,
		this.homeVisit,
		this.phoneNumber,
		this.placeId,
		this.address,
		this.addressText,
		this.startTime,
		this.endTime,
		this.confirmationTime,
		this.cancellationTimestamp,
		this.confirmationId,
		this.duration,
		this.allDay,
		this.details,
		this.wasMigrated,
		this.agendaId,
		this.hcpId,
		this.recurrenceId,
		this.flowItem,
		this.encryptedSelf,
		this.securityMetadata,
		Set<CodeStub>? tags,
		Set<CodeStub>? codes,
		Set<CalendarItemTag>? meetingTags,
		Set<String>? secretForeignKeys,
		Map<String, Set<Delegation>>? cryptedForeignKeys,
		Map<String, Set<Delegation>>? delegations,
		Map<String, Set<Delegation>>? encryptionKeys
	}) : tags = tags ?? {},
		codes = codes ?? {},
		meetingTags = meetingTags ?? {},
		secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {};

	static Map<String, dynamic> encode(EncryptedCalendarItem value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"created" : value.created,
			"modified" : value.modified,
			"author" : value.author,
			"responsible" : value.responsible,
			"medicalLocationId" : value.medicalLocationId,
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)),
			"endOfLife" : value.endOfLife,
			"deletionDate" : value.deletionDate,
			"title" : value.title,
			"calendarItemTypeId" : value.calendarItemTypeId,
			"masterCalendarItemId" : value.masterCalendarItemId,
			"patientId" : value.patientId,
			"important" : value.important,
			"homeVisit" : value.homeVisit,
			"phoneNumber" : value.phoneNumber,
			"placeId" : value.placeId,
			"address" : value.address == null ? null : EncryptedAddress.encode(value.address!),
			"addressText" : value.addressText,
			"startTime" : value.startTime,
			"endTime" : value.endTime,
			"confirmationTime" : value.confirmationTime,
			"cancellationTimestamp" : value.cancellationTimestamp,
			"confirmationId" : value.confirmationId,
			"duration" : value.duration,
			"allDay" : value.allDay,
			"details" : value.details,
			"wasMigrated" : value.wasMigrated,
			"agendaId" : value.agendaId,
			"hcpId" : value.hcpId,
			"recurrenceId" : value.recurrenceId,
			"meetingTags" : value.meetingTags.map((x0) => CalendarItemTag.encode(x0)),
			"flowItem" : value.flowItem == null ? null : FlowItem.encode(value.flowItem!),
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"encryptedSelf" : value.encryptedSelf,
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!)
		};
		return entityAsMap;
	}
}
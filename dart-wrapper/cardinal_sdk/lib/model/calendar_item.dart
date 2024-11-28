// auto-generated file
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
	Set<CalendarItemTag> get meetingTags;
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

	static CalendarItem fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.model.DecryptedCalendarItem":
				return DecryptedCalendarItem.fromJSON(data);
			case "com.icure.cardinal.sdk.model.EncryptedCalendarItem":
				return EncryptedCalendarItem.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

class DecryptedCalendarItem implements CalendarItem {
	@override String id;
	@override String? rev = null;
	@override int? created = null;
	@override int? modified = null;
	@override String? author = null;
	@override String? responsible = null;
	@override String? medicalLocationId = null;
	@override Set<CodeStub> tags = {};
	@override Set<CodeStub> codes = {};
	@override int? endOfLife = null;
	@override int? deletionDate = null;
	@override String? title = null;
	@override String? calendarItemTypeId = null;
	@override String? masterCalendarItemId = null;
	@override String? patientId = null;
	@override bool? important = null;
	@override bool? homeVisit = null;
	@override String? phoneNumber = null;
	@override String? placeId = null;
	@override DecryptedAddress? address = null;
	@override String? addressText = null;
	@override int? startTime = null;
	@override int? endTime = null;
	@override int? confirmationTime = null;
	@override int? cancellationTimestamp = null;
	@override String? confirmationId = null;
	@override int? duration = null;
	@override bool? allDay = null;
	@override String? details = null;
	@override bool? wasMigrated = null;
	@override String? agendaId = null;
	@override String? hcpId = null;
	@override String? recurrenceId = null;
	@override Set<DecryptedCalendarItemTag> meetingTags = {};
	@override FlowItem? flowItem = null;
	@override Set<String> secretForeignKeys = {};
	@override Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override Map<String, Set<Delegation>> delegations = {};
	@override Map<String, Set<Delegation>> encryptionKeys = {};
	@override Base64String? encryptedSelf = null;
	@override SecurityMetadata? securityMetadata = null;
	DecryptedCalendarItem(
		this.id,
		{
			String? rev,
			int? created,
			int? modified,
			String? author,
			String? responsible,
			String? medicalLocationId,
			Set<CodeStub>? tags,
			Set<CodeStub>? codes,
			int? endOfLife,
			int? deletionDate,
			String? title,
			String? calendarItemTypeId,
			String? masterCalendarItemId,
			String? patientId,
			bool? important,
			bool? homeVisit,
			String? phoneNumber,
			String? placeId,
			DecryptedAddress? address,
			String? addressText,
			int? startTime,
			int? endTime,
			int? confirmationTime,
			int? cancellationTimestamp,
			String? confirmationId,
			int? duration,
			bool? allDay,
			String? details,
			bool? wasMigrated,
			String? agendaId,
			String? hcpId,
			String? recurrenceId,
			Set<DecryptedCalendarItemTag>? meetingTags,
			FlowItem? flowItem,
			Set<String>? secretForeignKeys,
			Map<String, Set<Delegation>>? cryptedForeignKeys,
			Map<String, Set<Delegation>>? delegations,
			Map<String, Set<Delegation>>? encryptionKeys,
			Base64String? encryptedSelf,
			SecurityMetadata? securityMetadata
		}) : rev = rev ?? null,
		created = created ?? null,
		modified = modified ?? null,
		author = author ?? null,
		responsible = responsible ?? null,
		medicalLocationId = medicalLocationId ?? null,
		tags = tags ?? {},
		codes = codes ?? {},
		endOfLife = endOfLife ?? null,
		deletionDate = deletionDate ?? null,
		title = title ?? null,
		calendarItemTypeId = calendarItemTypeId ?? null,
		masterCalendarItemId = masterCalendarItemId ?? null,
		patientId = patientId ?? null,
		important = important ?? null,
		homeVisit = homeVisit ?? null,
		phoneNumber = phoneNumber ?? null,
		placeId = placeId ?? null,
		address = address ?? null,
		addressText = addressText ?? null,
		startTime = startTime ?? null,
		endTime = endTime ?? null,
		confirmationTime = confirmationTime ?? null,
		cancellationTimestamp = cancellationTimestamp ?? null,
		confirmationId = confirmationId ?? null,
		duration = duration ?? null,
		allDay = allDay ?? null,
		details = details ?? null,
		wasMigrated = wasMigrated ?? null,
		agendaId = agendaId ?? null,
		hcpId = hcpId ?? null,
		recurrenceId = recurrenceId ?? null,
		meetingTags = meetingTags ?? {},
		flowItem = flowItem ?? null,
		secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {},
		encryptedSelf = encryptedSelf ?? null,
		securityMetadata = securityMetadata ?? null;

	factory DecryptedCalendarItem.fromJSON(Map<String, dynamic> data) {
		return DecryptedCalendarItem(
			(data["id"] as String),
			rev: (data["rev"] as String?),
			created: (data["created"] as int?),
			modified: (data["modified"] as int?),
			author: (data["author"] as String?),
			responsible: (data["responsible"] as String?),
			medicalLocationId: (data["medicalLocationId"] as String?),
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			codes: (data["codes"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			endOfLife: (data["endOfLife"] as int?),
			deletionDate: (data["deletionDate"] as int?),
			title: (data["title"] as String?),
			calendarItemTypeId: (data["calendarItemTypeId"] as String?),
			masterCalendarItemId: (data["masterCalendarItemId"] as String?),
			patientId: (data["patientId"] as String?),
			important: (data["important"] as bool?),
			homeVisit: (data["homeVisit"] as bool?),
			phoneNumber: (data["phoneNumber"] as String?),
			placeId: (data["placeId"] as String?),
			address: data["address"] == null ? null : DecryptedAddress.fromJSON(data["address"]),
			addressText: (data["addressText"] as String?),
			startTime: (data["startTime"] as int?),
			endTime: (data["endTime"] as int?),
			confirmationTime: (data["confirmationTime"] as int?),
			cancellationTimestamp: (data["cancellationTimestamp"] as int?),
			confirmationId: (data["confirmationId"] as String?),
			duration: (data["duration"] as int?),
			allDay: (data["allDay"] as bool?),
			details: (data["details"] as String?),
			wasMigrated: (data["wasMigrated"] as bool?),
			agendaId: (data["agendaId"] as String?),
			hcpId: (data["hcpId"] as String?),
			recurrenceId: (data["recurrenceId"] as String?),
			meetingTags: (data["meetingTags"] as List<dynamic>).map((x0) => DecryptedCalendarItemTag.fromJSON(x0) ).toSet(),
			flowItem: data["flowItem"] == null ? null : FlowItem.fromJSON(data["flowItem"]),
			secretForeignKeys: (data["secretForeignKeys"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			cryptedForeignKeys: (data["cryptedForeignKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			delegations: (data["delegations"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptionKeys: (data["encryptionKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptedSelf: (data["encryptedSelf"] as Base64String?),
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
		);
	}

	static Map<String, dynamic> encode(DecryptedCalendarItem value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"created" : value.created,
			"modified" : value.modified,
			"author" : value.author,
			"responsible" : value.responsible,
			"medicalLocationId" : value.medicalLocationId,
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)).toList(),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)).toList(),
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
			"meetingTags" : value.meetingTags.map((x0) => DecryptedCalendarItemTag.encode(x0)).toList(),
			"flowItem" : value.flowItem == null ? null : FlowItem.encode(value.flowItem!),
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0).toList(),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptedSelf" : value.encryptedSelf,
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!)
		};
		return entityAsMap;
	}
}

class EncryptedCalendarItem implements CalendarItem {
	@override String id;
	@override String? rev = null;
	@override int? created = null;
	@override int? modified = null;
	@override String? author = null;
	@override String? responsible = null;
	@override String? medicalLocationId = null;
	@override Set<CodeStub> tags = {};
	@override Set<CodeStub> codes = {};
	@override int? endOfLife = null;
	@override int? deletionDate = null;
	@override String? title = null;
	@override String? calendarItemTypeId = null;
	@override String? masterCalendarItemId = null;
	@override String? patientId = null;
	@override bool? important = null;
	@override bool? homeVisit = null;
	@override String? phoneNumber = null;
	@override String? placeId = null;
	@override EncryptedAddress? address = null;
	@override String? addressText = null;
	@override int? startTime = null;
	@override int? endTime = null;
	@override int? confirmationTime = null;
	@override int? cancellationTimestamp = null;
	@override String? confirmationId = null;
	@override int? duration = null;
	@override bool? allDay = null;
	@override String? details = null;
	@override bool? wasMigrated = null;
	@override String? agendaId = null;
	@override String? hcpId = null;
	@override String? recurrenceId = null;
	@override Set<EncryptedCalendarItemTag> meetingTags = {};
	@override FlowItem? flowItem = null;
	@override Set<String> secretForeignKeys = {};
	@override Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override Map<String, Set<Delegation>> delegations = {};
	@override Map<String, Set<Delegation>> encryptionKeys = {};
	@override Base64String? encryptedSelf = null;
	@override SecurityMetadata? securityMetadata = null;
	EncryptedCalendarItem(
		this.id,
		{
			String? rev,
			int? created,
			int? modified,
			String? author,
			String? responsible,
			String? medicalLocationId,
			Set<CodeStub>? tags,
			Set<CodeStub>? codes,
			int? endOfLife,
			int? deletionDate,
			String? title,
			String? calendarItemTypeId,
			String? masterCalendarItemId,
			String? patientId,
			bool? important,
			bool? homeVisit,
			String? phoneNumber,
			String? placeId,
			EncryptedAddress? address,
			String? addressText,
			int? startTime,
			int? endTime,
			int? confirmationTime,
			int? cancellationTimestamp,
			String? confirmationId,
			int? duration,
			bool? allDay,
			String? details,
			bool? wasMigrated,
			String? agendaId,
			String? hcpId,
			String? recurrenceId,
			Set<EncryptedCalendarItemTag>? meetingTags,
			FlowItem? flowItem,
			Set<String>? secretForeignKeys,
			Map<String, Set<Delegation>>? cryptedForeignKeys,
			Map<String, Set<Delegation>>? delegations,
			Map<String, Set<Delegation>>? encryptionKeys,
			Base64String? encryptedSelf,
			SecurityMetadata? securityMetadata
		}) : rev = rev ?? null,
		created = created ?? null,
		modified = modified ?? null,
		author = author ?? null,
		responsible = responsible ?? null,
		medicalLocationId = medicalLocationId ?? null,
		tags = tags ?? {},
		codes = codes ?? {},
		endOfLife = endOfLife ?? null,
		deletionDate = deletionDate ?? null,
		title = title ?? null,
		calendarItemTypeId = calendarItemTypeId ?? null,
		masterCalendarItemId = masterCalendarItemId ?? null,
		patientId = patientId ?? null,
		important = important ?? null,
		homeVisit = homeVisit ?? null,
		phoneNumber = phoneNumber ?? null,
		placeId = placeId ?? null,
		address = address ?? null,
		addressText = addressText ?? null,
		startTime = startTime ?? null,
		endTime = endTime ?? null,
		confirmationTime = confirmationTime ?? null,
		cancellationTimestamp = cancellationTimestamp ?? null,
		confirmationId = confirmationId ?? null,
		duration = duration ?? null,
		allDay = allDay ?? null,
		details = details ?? null,
		wasMigrated = wasMigrated ?? null,
		agendaId = agendaId ?? null,
		hcpId = hcpId ?? null,
		recurrenceId = recurrenceId ?? null,
		meetingTags = meetingTags ?? {},
		flowItem = flowItem ?? null,
		secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {},
		encryptedSelf = encryptedSelf ?? null,
		securityMetadata = securityMetadata ?? null;

	factory EncryptedCalendarItem.fromJSON(Map<String, dynamic> data) {
		return EncryptedCalendarItem(
			(data["id"] as String),
			rev: (data["rev"] as String?),
			created: (data["created"] as int?),
			modified: (data["modified"] as int?),
			author: (data["author"] as String?),
			responsible: (data["responsible"] as String?),
			medicalLocationId: (data["medicalLocationId"] as String?),
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			codes: (data["codes"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			endOfLife: (data["endOfLife"] as int?),
			deletionDate: (data["deletionDate"] as int?),
			title: (data["title"] as String?),
			calendarItemTypeId: (data["calendarItemTypeId"] as String?),
			masterCalendarItemId: (data["masterCalendarItemId"] as String?),
			patientId: (data["patientId"] as String?),
			important: (data["important"] as bool?),
			homeVisit: (data["homeVisit"] as bool?),
			phoneNumber: (data["phoneNumber"] as String?),
			placeId: (data["placeId"] as String?),
			address: data["address"] == null ? null : EncryptedAddress.fromJSON(data["address"]),
			addressText: (data["addressText"] as String?),
			startTime: (data["startTime"] as int?),
			endTime: (data["endTime"] as int?),
			confirmationTime: (data["confirmationTime"] as int?),
			cancellationTimestamp: (data["cancellationTimestamp"] as int?),
			confirmationId: (data["confirmationId"] as String?),
			duration: (data["duration"] as int?),
			allDay: (data["allDay"] as bool?),
			details: (data["details"] as String?),
			wasMigrated: (data["wasMigrated"] as bool?),
			agendaId: (data["agendaId"] as String?),
			hcpId: (data["hcpId"] as String?),
			recurrenceId: (data["recurrenceId"] as String?),
			meetingTags: (data["meetingTags"] as List<dynamic>).map((x0) => EncryptedCalendarItemTag.fromJSON(x0) ).toSet(),
			flowItem: data["flowItem"] == null ? null : FlowItem.fromJSON(data["flowItem"]),
			secretForeignKeys: (data["secretForeignKeys"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			cryptedForeignKeys: (data["cryptedForeignKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			delegations: (data["delegations"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptionKeys: (data["encryptionKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptedSelf: (data["encryptedSelf"] as Base64String?),
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
		);
	}

	static Map<String, dynamic> encode(EncryptedCalendarItem value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"created" : value.created,
			"modified" : value.modified,
			"author" : value.author,
			"responsible" : value.responsible,
			"medicalLocationId" : value.medicalLocationId,
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)).toList(),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)).toList(),
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
			"meetingTags" : value.meetingTags.map((x0) => EncryptedCalendarItemTag.encode(x0)).toList(),
			"flowItem" : value.flowItem == null ? null : FlowItem.encode(value.flowItem!),
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0).toList(),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptedSelf" : value.encryptedSelf,
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!)
		};
		return entityAsMap;
	}
}
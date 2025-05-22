// auto-generated file
import 'package:cardinal_sdk/model/base/identifier.dart';
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/embed/annotation.dart';
import 'package:cardinal_sdk/annotations/actual_int32.dart';
import 'package:cardinal_sdk/model/embed/laterality.dart';
import 'package:cardinal_sdk/model/embed/plan_of_action.dart';
import 'package:cardinal_sdk/model/embed/episode.dart';
import 'package:cardinal_sdk/model/embed/care_team_member.dart';
import 'package:cardinal_sdk/model/embed/delegation.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/security_metadata.dart';
import 'package:cardinal_sdk/model/health_element.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/icure_document.dart';
import 'package:cardinal_sdk/model/base/has_encryption_metadata.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "health_element.freezed.dart";


sealed class HealthElement implements StoredDocument, ICureDocument<String>, HasEncryptionMetadata, Encryptable {
	@override abstract final String id;
	abstract final List<Identifier> identifiers;
	@override abstract final String? rev;
	@override abstract final int? created;
	@override abstract final int? modified;
	@override abstract final String? author;
	@override abstract final String? responsible;
	@override abstract final String? medicalLocationId;
	@override abstract final Set<CodeStub> tags;
	@override abstract final Set<CodeStub> codes;
	@override abstract final int? endOfLife;
	@override abstract final int? deletionDate;
	abstract final String? healthElementId;
	abstract final int? valueDate;
	abstract final int? openingDate;
	abstract final int? closingDate;
	abstract final String? descr;
	abstract final String? note;
	abstract final List<Annotation> notes;
	abstract final bool relevant;
	abstract final String? idOpeningContact;
	abstract final String? idClosingContact;
	abstract final String? idService;
	@actualInt32 abstract final int status;
	abstract final Laterality? laterality;
	List<PlanOfAction> get plansOfAction;
	List<Episode> get episodes;
	List<CareTeamMember> get careTeam;
	@override abstract final Set<String> secretForeignKeys;
	@override abstract final Map<String, Set<Delegation>> cryptedForeignKeys;
	@override abstract final Map<String, Set<Delegation>> delegations;
	@override abstract final Map<String, Set<Delegation>> encryptionKeys;
	@override abstract final Base64String? encryptedSelf;
	@override abstract final SecurityMetadata? securityMetadata;

	static Map<String, dynamic> encode(HealthElement value) {
		switch (value) {
			case EncryptedHealthElement entity:
				Map<String, dynamic> entityJson = EncryptedHealthElement.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.EncryptedHealthElement";
				return entityJson;
			case DecryptedHealthElement entity:
				Map<String, dynamic> entityJson = DecryptedHealthElement.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.DecryptedHealthElement";
				return entityJson;
		}
	}

	static HealthElement fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.model.EncryptedHealthElement":
				return EncryptedHealthElement.fromJSON(data);
			case "com.icure.cardinal.sdk.model.DecryptedHealthElement":
				return DecryptedHealthElement.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

@freezed
abstract class EncryptedHealthElement with _$EncryptedHealthElement implements HealthElement {
	const factory EncryptedHealthElement({
		required String id,
		@Default([]) List<Identifier> identifiers,
		@Default(null) String? rev,
		@Default(null) int? created,
		@Default(null) int? modified,
		@Default(null) String? author,
		@Default(null) String? responsible,
		@Default(null) String? medicalLocationId,
		@Default({}) Set<CodeStub> tags,
		@Default({}) Set<CodeStub> codes,
		@Default(null) int? endOfLife,
		@Default(null) int? deletionDate,
		@Default(null) String? healthElementId,
		@Default(null) int? valueDate,
		@Default(null) int? openingDate,
		@Default(null) int? closingDate,
		@Default(null) String? descr,
		@Default(null) String? note,
		@Default([]) List<Annotation> notes,
		@Default(true) bool relevant,
		@Default(null) String? idOpeningContact,
		@Default(null) String? idClosingContact,
		@Default(null) String? idService,
		@Default(0) int status,
		@Default(null) Laterality? laterality,
		@Default([]) List<EncryptedPlanOfAction> plansOfAction,
		@Default([]) List<EncryptedEpisode> episodes,
		@Default([]) List<EncryptedCareTeamMember> careTeam,
		@Default({}) Set<String> secretForeignKeys,
		@Default({}) Map<String, Set<Delegation>> cryptedForeignKeys,
		@Default({}) Map<String, Set<Delegation>> delegations,
		@Default({}) Map<String, Set<Delegation>> encryptionKeys,
		@Default(null) Base64String? encryptedSelf,
		@Default(null) SecurityMetadata? securityMetadata,
	}) = _EncryptedHealthElement;


	static Map<String, dynamic> encode(EncryptedHealthElement value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"identifiers" : value.identifiers.map((x0) => Identifier.encode(x0)).toList(),
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
			"healthElementId" : value.healthElementId,
			"valueDate" : value.valueDate,
			"openingDate" : value.openingDate,
			"closingDate" : value.closingDate,
			"descr" : value.descr,
			"note" : value.note,
			"notes" : value.notes.map((x0) => Annotation.encode(x0)).toList(),
			"relevant" : value.relevant,
			"idOpeningContact" : value.idOpeningContact,
			"idClosingContact" : value.idClosingContact,
			"idService" : value.idService,
			"status" : value.status,
			"laterality" : value.laterality == null ? null : Laterality.encode(value.laterality!),
			"plansOfAction" : value.plansOfAction.map((x0) => EncryptedPlanOfAction.encode(x0)).toList(),
			"episodes" : value.episodes.map((x0) => EncryptedEpisode.encode(x0)).toList(),
			"careTeam" : value.careTeam.map((x0) => EncryptedCareTeamMember.encode(x0)).toList(),
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0).toList(),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptedSelf" : value.encryptedSelf,
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!)
		};
		return entityAsMap;
	}

	static EncryptedHealthElement fromJSON(Map<String, dynamic> data) {
		return EncryptedHealthElement(
			id: (data["id"] as String),
			status: (data["status"] as int),
			identifiers: (data["identifiers"] as List<dynamic>).map((x0) => Identifier.fromJSON(x0) ).toList(),
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
			healthElementId: (data["healthElementId"] as String?),
			valueDate: (data["valueDate"] as int?),
			openingDate: (data["openingDate"] as int?),
			closingDate: (data["closingDate"] as int?),
			descr: (data["descr"] as String?),
			note: (data["note"] as String?),
			notes: (data["notes"] as List<dynamic>).map((x0) => Annotation.fromJSON(x0) ).toList(),
			relevant: (data["relevant"] as bool),
			idOpeningContact: (data["idOpeningContact"] as String?),
			idClosingContact: (data["idClosingContact"] as String?),
			idService: (data["idService"] as String?),
			laterality: data["laterality"] == null ? null : Laterality.fromJSON(data["laterality"]),
			plansOfAction: (data["plansOfAction"] as List<dynamic>).map((x0) => EncryptedPlanOfAction.fromJSON(x0) ).toList(),
			episodes: (data["episodes"] as List<dynamic>).map((x0) => EncryptedEpisode.fromJSON(x0) ).toList(),
			careTeam: (data["careTeam"] as List<dynamic>).map((x0) => EncryptedCareTeamMember.fromJSON(x0) ).toList(),
			secretForeignKeys: (data["secretForeignKeys"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			cryptedForeignKeys: (data["cryptedForeignKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			delegations: (data["delegations"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptionKeys: (data["encryptionKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptedSelf: (data["encryptedSelf"] as Base64String?),
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
		);
	}
}

@freezed
abstract class DecryptedHealthElement with _$DecryptedHealthElement implements HealthElement {
	const factory DecryptedHealthElement({
		required String id,
		@Default([]) List<Identifier> identifiers,
		@Default(null) String? rev,
		@Default(null) int? created,
		@Default(null) int? modified,
		@Default(null) String? author,
		@Default(null) String? responsible,
		@Default(null) String? medicalLocationId,
		@Default({}) Set<CodeStub> tags,
		@Default({}) Set<CodeStub> codes,
		@Default(null) int? endOfLife,
		@Default(null) int? deletionDate,
		@Default(null) String? healthElementId,
		@Default(null) int? valueDate,
		@Default(null) int? openingDate,
		@Default(null) int? closingDate,
		@Default(null) String? descr,
		@Default(null) String? note,
		@Default([]) List<Annotation> notes,
		@Default(true) bool relevant,
		@Default(null) String? idOpeningContact,
		@Default(null) String? idClosingContact,
		@Default(null) String? idService,
		@Default(0) int status,
		@Default(null) Laterality? laterality,
		@Default([]) List<DecryptedPlanOfAction> plansOfAction,
		@Default([]) List<DecryptedEpisode> episodes,
		@Default([]) List<DecryptedCareTeamMember> careTeam,
		@Default({}) Set<String> secretForeignKeys,
		@Default({}) Map<String, Set<Delegation>> cryptedForeignKeys,
		@Default({}) Map<String, Set<Delegation>> delegations,
		@Default({}) Map<String, Set<Delegation>> encryptionKeys,
		@Default(null) Base64String? encryptedSelf,
		@Default(null) SecurityMetadata? securityMetadata,
	}) = _DecryptedHealthElement;


	static Map<String, dynamic> encode(DecryptedHealthElement value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"identifiers" : value.identifiers.map((x0) => Identifier.encode(x0)).toList(),
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
			"healthElementId" : value.healthElementId,
			"valueDate" : value.valueDate,
			"openingDate" : value.openingDate,
			"closingDate" : value.closingDate,
			"descr" : value.descr,
			"note" : value.note,
			"notes" : value.notes.map((x0) => Annotation.encode(x0)).toList(),
			"relevant" : value.relevant,
			"idOpeningContact" : value.idOpeningContact,
			"idClosingContact" : value.idClosingContact,
			"idService" : value.idService,
			"status" : value.status,
			"laterality" : value.laterality == null ? null : Laterality.encode(value.laterality!),
			"plansOfAction" : value.plansOfAction.map((x0) => DecryptedPlanOfAction.encode(x0)).toList(),
			"episodes" : value.episodes.map((x0) => DecryptedEpisode.encode(x0)).toList(),
			"careTeam" : value.careTeam.map((x0) => DecryptedCareTeamMember.encode(x0)).toList(),
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0).toList(),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptedSelf" : value.encryptedSelf,
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!)
		};
		return entityAsMap;
	}

	static DecryptedHealthElement fromJSON(Map<String, dynamic> data) {
		return DecryptedHealthElement(
			id: (data["id"] as String),
			status: (data["status"] as int),
			identifiers: (data["identifiers"] as List<dynamic>).map((x0) => Identifier.fromJSON(x0) ).toList(),
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
			healthElementId: (data["healthElementId"] as String?),
			valueDate: (data["valueDate"] as int?),
			openingDate: (data["openingDate"] as int?),
			closingDate: (data["closingDate"] as int?),
			descr: (data["descr"] as String?),
			note: (data["note"] as String?),
			notes: (data["notes"] as List<dynamic>).map((x0) => Annotation.fromJSON(x0) ).toList(),
			relevant: (data["relevant"] as bool),
			idOpeningContact: (data["idOpeningContact"] as String?),
			idClosingContact: (data["idClosingContact"] as String?),
			idService: (data["idService"] as String?),
			laterality: data["laterality"] == null ? null : Laterality.fromJSON(data["laterality"]),
			plansOfAction: (data["plansOfAction"] as List<dynamic>).map((x0) => DecryptedPlanOfAction.fromJSON(x0) ).toList(),
			episodes: (data["episodes"] as List<dynamic>).map((x0) => DecryptedEpisode.fromJSON(x0) ).toList(),
			careTeam: (data["careTeam"] as List<dynamic>).map((x0) => DecryptedCareTeamMember.fromJSON(x0) ).toList(),
			secretForeignKeys: (data["secretForeignKeys"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			cryptedForeignKeys: (data["cryptedForeignKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			delegations: (data["delegations"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptionKeys: (data["encryptionKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptedSelf: (data["encryptedSelf"] as Base64String?),
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
		);
	}
}
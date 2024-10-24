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


sealed class HealthElement implements StoredDocument, ICureDocument<String>, HasEncryptionMetadata, Encryptable {
	@override abstract String id;
	abstract List<Identifier> identifiers;
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
	abstract String? healthElementId;
	abstract int? valueDate;
	abstract int? openingDate;
	abstract int? closingDate;
	abstract String? descr;
	abstract String? note;
	abstract List<Annotation> notes;
	abstract bool relevant;
	abstract String? idOpeningContact;
	abstract String? idClosingContact;
	abstract String? idService;
	@ActualInt32() abstract int status;
	abstract Laterality? laterality;
	List<PlanOfAction> get plansOfAction;
	List<Episode> get episodes;
	List<CareTeamMember> get careTeam;
	@override abstract Set<String> secretForeignKeys;
	@override abstract Map<String, Set<Delegation>> cryptedForeignKeys;
	@override abstract Map<String, Set<Delegation>> delegations;
	@override abstract Map<String, Set<Delegation>> encryptionKeys;
	@override abstract Base64String? encryptedSelf;
	@override abstract SecurityMetadata? securityMetadata;

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

class EncryptedHealthElement implements HealthElement {
	@override String id;
	@override List<Identifier> identifiers = [];
	@override String? rev;
	@override int? created;
	@override int? modified;
	@override String? author;
	@override String? responsible;
	@override String? medicalLocationId;
	@override Set<CodeStub> tags = {};
	@override Set<CodeStub> codes = {};
	@override int? endOfLife;
	@override int? deletionDate;
	@override String? healthElementId;
	@override int? valueDate;
	@override int? openingDate;
	@override int? closingDate;
	@override String? descr;
	@override String? note;
	@override List<Annotation> notes = [];
	@override bool relevant = true;
	@override String? idOpeningContact;
	@override String? idClosingContact;
	@override String? idService;
	int _status = 0;
	@ActualInt32() @override int get status => _status;
	@ActualInt32() @override set status(int value) {
		if (value > 2147483647) {
			throw ArgumentError('status value cannot exceed 2147483647');
		}
		_status = value;
	}
	@override Laterality? laterality;
	@override List<EncryptedPlanOfAction> plansOfAction = [];
	@override List<EncryptedEpisode> episodes = [];
	@override List<EncryptedCareTeamMember> careTeam = [];
	@override Set<String> secretForeignKeys = {};
	@override Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override Map<String, Set<Delegation>> delegations = {};
	@override Map<String, Set<Delegation>> encryptionKeys = {};
	@override Base64String? encryptedSelf;
	@override SecurityMetadata? securityMetadata;
	EncryptedHealthElement(
		this.id,
		{
			int? status,
			this.rev,
			this.created,
			this.modified,
			this.author,
			this.responsible,
			this.medicalLocationId,
			this.endOfLife,
			this.deletionDate,
			this.healthElementId,
			this.valueDate,
			this.openingDate,
			this.closingDate,
			this.descr,
			this.note,
			this.idOpeningContact,
			this.idClosingContact,
			this.idService,
			this.laterality,
			this.encryptedSelf,
			this.securityMetadata,
			List<Identifier>? identifiers,
			Set<CodeStub>? tags,
			Set<CodeStub>? codes,
			List<Annotation>? notes,
			bool? relevant,
			List<EncryptedPlanOfAction>? plansOfAction,
			List<EncryptedEpisode>? episodes,
			List<EncryptedCareTeamMember>? careTeam,
			Set<String>? secretForeignKeys,
			Map<String, Set<Delegation>>? cryptedForeignKeys,
			Map<String, Set<Delegation>>? delegations,
			Map<String, Set<Delegation>>? encryptionKeys
		}) : identifiers = identifiers ?? [],
		tags = tags ?? {},
		codes = codes ?? {},
		notes = notes ?? [],
		relevant = relevant ?? true,
		plansOfAction = plansOfAction ?? [],
		episodes = episodes ?? [],
		careTeam = careTeam ?? [],
		secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {},
		_status = status ?? 0;

	factory EncryptedHealthElement.fromJSON(Map<String, dynamic> data) {
		return EncryptedHealthElement(
			data["id"],
			status: data["status"],
			identifiers: data["identifiers"].map((x0) => Identifier.fromJSON(x0) ).toList(),
			rev: data["rev"],
			created: data["created"],
			modified: data["modified"],
			author: data["author"],
			responsible: data["responsible"],
			medicalLocationId: data["medicalLocationId"],
			tags: data["tags"].map((x0) => CodeStub.fromJSON(x0) ).toList(),
			codes: data["codes"].map((x0) => CodeStub.fromJSON(x0) ).toList(),
			endOfLife: data["endOfLife"],
			deletionDate: data["deletionDate"],
			healthElementId: data["healthElementId"],
			valueDate: data["valueDate"],
			openingDate: data["openingDate"],
			closingDate: data["closingDate"],
			descr: data["descr"],
			note: data["note"],
			notes: data["notes"].map((x0) => Annotation.fromJSON(x0) ).toList(),
			relevant: data["relevant"],
			idOpeningContact: data["idOpeningContact"],
			idClosingContact: data["idClosingContact"],
			idService: data["idService"],
			laterality: data["laterality"] == null ? null : Laterality.fromJSON(data["laterality"]),
			plansOfAction: data["plansOfAction"].map((x0) => EncryptedPlanOfAction.fromJSON(x0) ).toList(),
			episodes: data["episodes"].map((x0) => EncryptedEpisode.fromJSON(x0) ).toList(),
			careTeam: data["careTeam"].map((x0) => EncryptedCareTeamMember.fromJSON(x0) ).toList(),
			secretForeignKeys: data["secretForeignKeys"].map((x0) => x0 ).toList(),
			cryptedForeignKeys: data["cryptedForeignKeys"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ).toList())),
			delegations: data["delegations"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ).toList())),
			encryptionKeys: data["encryptionKeys"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ).toList())),
			encryptedSelf: data["encryptedSelf"],
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
		);
	}

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
}

class DecryptedHealthElement implements HealthElement {
	@override String id;
	@override List<Identifier> identifiers = [];
	@override String? rev;
	@override int? created;
	@override int? modified;
	@override String? author;
	@override String? responsible;
	@override String? medicalLocationId;
	@override Set<CodeStub> tags = {};
	@override Set<CodeStub> codes = {};
	@override int? endOfLife;
	@override int? deletionDate;
	@override String? healthElementId;
	@override int? valueDate;
	@override int? openingDate;
	@override int? closingDate;
	@override String? descr;
	@override String? note;
	@override List<Annotation> notes = [];
	@override bool relevant = true;
	@override String? idOpeningContact;
	@override String? idClosingContact;
	@override String? idService;
	int _status = 0;
	@ActualInt32() @override int get status => _status;
	@ActualInt32() @override set status(int value) {
		if (value > 2147483647) {
			throw ArgumentError('status value cannot exceed 2147483647');
		}
		_status = value;
	}
	@override Laterality? laterality;
	@override List<DecryptedPlanOfAction> plansOfAction = [];
	@override List<DecryptedEpisode> episodes = [];
	@override List<DecryptedCareTeamMember> careTeam = [];
	@override Set<String> secretForeignKeys = {};
	@override Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override Map<String, Set<Delegation>> delegations = {};
	@override Map<String, Set<Delegation>> encryptionKeys = {};
	@override Base64String? encryptedSelf;
	@override SecurityMetadata? securityMetadata;
	DecryptedHealthElement(
		this.id,
		{
			int? status,
			this.rev,
			this.created,
			this.modified,
			this.author,
			this.responsible,
			this.medicalLocationId,
			this.endOfLife,
			this.deletionDate,
			this.healthElementId,
			this.valueDate,
			this.openingDate,
			this.closingDate,
			this.descr,
			this.note,
			this.idOpeningContact,
			this.idClosingContact,
			this.idService,
			this.laterality,
			this.encryptedSelf,
			this.securityMetadata,
			List<Identifier>? identifiers,
			Set<CodeStub>? tags,
			Set<CodeStub>? codes,
			List<Annotation>? notes,
			bool? relevant,
			List<DecryptedPlanOfAction>? plansOfAction,
			List<DecryptedEpisode>? episodes,
			List<DecryptedCareTeamMember>? careTeam,
			Set<String>? secretForeignKeys,
			Map<String, Set<Delegation>>? cryptedForeignKeys,
			Map<String, Set<Delegation>>? delegations,
			Map<String, Set<Delegation>>? encryptionKeys
		}) : identifiers = identifiers ?? [],
		tags = tags ?? {},
		codes = codes ?? {},
		notes = notes ?? [],
		relevant = relevant ?? true,
		plansOfAction = plansOfAction ?? [],
		episodes = episodes ?? [],
		careTeam = careTeam ?? [],
		secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {},
		_status = status ?? 0;

	factory DecryptedHealthElement.fromJSON(Map<String, dynamic> data) {
		return DecryptedHealthElement(
			data["id"],
			status: data["status"],
			identifiers: data["identifiers"].map((x0) => Identifier.fromJSON(x0) ).toList(),
			rev: data["rev"],
			created: data["created"],
			modified: data["modified"],
			author: data["author"],
			responsible: data["responsible"],
			medicalLocationId: data["medicalLocationId"],
			tags: data["tags"].map((x0) => CodeStub.fromJSON(x0) ).toList(),
			codes: data["codes"].map((x0) => CodeStub.fromJSON(x0) ).toList(),
			endOfLife: data["endOfLife"],
			deletionDate: data["deletionDate"],
			healthElementId: data["healthElementId"],
			valueDate: data["valueDate"],
			openingDate: data["openingDate"],
			closingDate: data["closingDate"],
			descr: data["descr"],
			note: data["note"],
			notes: data["notes"].map((x0) => Annotation.fromJSON(x0) ).toList(),
			relevant: data["relevant"],
			idOpeningContact: data["idOpeningContact"],
			idClosingContact: data["idClosingContact"],
			idService: data["idService"],
			laterality: data["laterality"] == null ? null : Laterality.fromJSON(data["laterality"]),
			plansOfAction: data["plansOfAction"].map((x0) => DecryptedPlanOfAction.fromJSON(x0) ).toList(),
			episodes: data["episodes"].map((x0) => DecryptedEpisode.fromJSON(x0) ).toList(),
			careTeam: data["careTeam"].map((x0) => DecryptedCareTeamMember.fromJSON(x0) ).toList(),
			secretForeignKeys: data["secretForeignKeys"].map((x0) => x0 ).toList(),
			cryptedForeignKeys: data["cryptedForeignKeys"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ).toList())),
			delegations: data["delegations"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ).toList())),
			encryptionKeys: data["encryptionKeys"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ).toList())),
			encryptedSelf: data["encryptedSelf"],
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
		);
	}

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
}
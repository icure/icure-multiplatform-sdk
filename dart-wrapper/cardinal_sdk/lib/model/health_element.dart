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
	@override String? healthElementId = null;
	@override int? valueDate = null;
	@override int? openingDate = null;
	@override int? closingDate = null;
	@override String? descr = null;
	@override String? note = null;
	@override List<Annotation> notes = [];
	@override bool relevant = true;
	@override String? idOpeningContact = null;
	@override String? idClosingContact = null;
	@override String? idService = null;
	int _status = 0;
	@ActualInt32() @override int get status => _status;
	@ActualInt32() @override set status(int value) {
		if (value > 2147483647) {
			throw ArgumentError('status value cannot exceed 2147483647');
		}
		_status = value;
	}
	@override Laterality? laterality = null;
	@override List<EncryptedPlanOfAction> plansOfAction = [];
	@override List<EncryptedEpisode> episodes = [];
	@override List<EncryptedCareTeamMember> careTeam = [];
	@override Set<String> secretForeignKeys = {};
	@override Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override Map<String, Set<Delegation>> delegations = {};
	@override Map<String, Set<Delegation>> encryptionKeys = {};
	@override Base64String? encryptedSelf = null;
	@override SecurityMetadata? securityMetadata = null;
	EncryptedHealthElement(
		this.id,
		{
			int? status,
			List<Identifier>? identifiers,
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
			String? healthElementId,
			int? valueDate,
			int? openingDate,
			int? closingDate,
			String? descr,
			String? note,
			List<Annotation>? notes,
			bool? relevant,
			String? idOpeningContact,
			String? idClosingContact,
			String? idService,
			Laterality? laterality,
			List<EncryptedPlanOfAction>? plansOfAction,
			List<EncryptedEpisode>? episodes,
			List<EncryptedCareTeamMember>? careTeam,
			Set<String>? secretForeignKeys,
			Map<String, Set<Delegation>>? cryptedForeignKeys,
			Map<String, Set<Delegation>>? delegations,
			Map<String, Set<Delegation>>? encryptionKeys,
			Base64String? encryptedSelf,
			SecurityMetadata? securityMetadata
		}) : identifiers = identifiers ?? [],
		rev = rev ?? null,
		created = created ?? null,
		modified = modified ?? null,
		author = author ?? null,
		responsible = responsible ?? null,
		medicalLocationId = medicalLocationId ?? null,
		tags = tags ?? {},
		codes = codes ?? {},
		endOfLife = endOfLife ?? null,
		deletionDate = deletionDate ?? null,
		healthElementId = healthElementId ?? null,
		valueDate = valueDate ?? null,
		openingDate = openingDate ?? null,
		closingDate = closingDate ?? null,
		descr = descr ?? null,
		note = note ?? null,
		notes = notes ?? [],
		relevant = relevant ?? true,
		idOpeningContact = idOpeningContact ?? null,
		idClosingContact = idClosingContact ?? null,
		idService = idService ?? null,
		laterality = laterality ?? null,
		plansOfAction = plansOfAction ?? [],
		episodes = episodes ?? [],
		careTeam = careTeam ?? [],
		secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {},
		encryptedSelf = encryptedSelf ?? null,
		securityMetadata = securityMetadata ?? null,
		_status = status ?? 0;

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
			(data["id"] as String),
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

class DecryptedHealthElement implements HealthElement {
	@override String id;
	@override List<Identifier> identifiers = [];
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
	@override String? healthElementId = null;
	@override int? valueDate = null;
	@override int? openingDate = null;
	@override int? closingDate = null;
	@override String? descr = null;
	@override String? note = null;
	@override List<Annotation> notes = [];
	@override bool relevant = true;
	@override String? idOpeningContact = null;
	@override String? idClosingContact = null;
	@override String? idService = null;
	int _status = 0;
	@ActualInt32() @override int get status => _status;
	@ActualInt32() @override set status(int value) {
		if (value > 2147483647) {
			throw ArgumentError('status value cannot exceed 2147483647');
		}
		_status = value;
	}
	@override Laterality? laterality = null;
	@override List<DecryptedPlanOfAction> plansOfAction = [];
	@override List<DecryptedEpisode> episodes = [];
	@override List<DecryptedCareTeamMember> careTeam = [];
	@override Set<String> secretForeignKeys = {};
	@override Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override Map<String, Set<Delegation>> delegations = {};
	@override Map<String, Set<Delegation>> encryptionKeys = {};
	@override Base64String? encryptedSelf = null;
	@override SecurityMetadata? securityMetadata = null;
	DecryptedHealthElement(
		this.id,
		{
			int? status,
			List<Identifier>? identifiers,
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
			String? healthElementId,
			int? valueDate,
			int? openingDate,
			int? closingDate,
			String? descr,
			String? note,
			List<Annotation>? notes,
			bool? relevant,
			String? idOpeningContact,
			String? idClosingContact,
			String? idService,
			Laterality? laterality,
			List<DecryptedPlanOfAction>? plansOfAction,
			List<DecryptedEpisode>? episodes,
			List<DecryptedCareTeamMember>? careTeam,
			Set<String>? secretForeignKeys,
			Map<String, Set<Delegation>>? cryptedForeignKeys,
			Map<String, Set<Delegation>>? delegations,
			Map<String, Set<Delegation>>? encryptionKeys,
			Base64String? encryptedSelf,
			SecurityMetadata? securityMetadata
		}) : identifiers = identifiers ?? [],
		rev = rev ?? null,
		created = created ?? null,
		modified = modified ?? null,
		author = author ?? null,
		responsible = responsible ?? null,
		medicalLocationId = medicalLocationId ?? null,
		tags = tags ?? {},
		codes = codes ?? {},
		endOfLife = endOfLife ?? null,
		deletionDate = deletionDate ?? null,
		healthElementId = healthElementId ?? null,
		valueDate = valueDate ?? null,
		openingDate = openingDate ?? null,
		closingDate = closingDate ?? null,
		descr = descr ?? null,
		note = note ?? null,
		notes = notes ?? [],
		relevant = relevant ?? true,
		idOpeningContact = idOpeningContact ?? null,
		idClosingContact = idClosingContact ?? null,
		idService = idService ?? null,
		laterality = laterality ?? null,
		plansOfAction = plansOfAction ?? [],
		episodes = episodes ?? [],
		careTeam = careTeam ?? [],
		secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {},
		encryptedSelf = encryptedSelf ?? null,
		securityMetadata = securityMetadata ?? null,
		_status = status ?? 0;

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
			(data["id"] as String),
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
// auto-generated file
import 'package:cardinal_sdk/model/embed/contract_change_type.dart';
import 'package:cardinal_sdk/annotations/actual_int32.dart';
import 'package:cardinal_sdk/model/embed/suspension_reason.dart';
import 'package:cardinal_sdk/model/embed/mhc_signature_type.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/medical_house_contract.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "medical_house_contract.freezed.dart";


sealed class MedicalHouseContract implements Encryptable {
	abstract final String? contractId;
	abstract final int? validFrom;
	abstract final int? validTo;
	abstract final String? mmNihii;
	abstract final String? hcpId;
	abstract final ContractChangeType? changeType;
	abstract final String? parentContractId;
	abstract final String? changedBy;
	abstract final int? startOfContract;
	abstract final int? startOfCoverage;
	abstract final int? endOfContract;
	abstract final int? endOfCoverage;
	abstract final bool kine;
	abstract final bool gp;
	abstract final bool ptd;
	abstract final bool nurse;
	abstract final bool noKine;
	abstract final bool noGp;
	abstract final bool noNurse;
	@actualInt32 abstract final int? unsubscriptionReasonId;
	abstract final int? ptdStart;
	abstract final int? ptdEnd;
	abstract final int? ptdLastInvoiced;
	abstract final int? startOfSuspension;
	abstract final int? endOfSuspension;
	abstract final SuspensionReason? suspensionReason;
	abstract final String? suspensionSource;
	abstract final bool forcedSuspension;
	abstract final MhcSignatureType? signatureType;
	@actualInt32 abstract final int? status;
	abstract final Map<String, String> options;
	abstract final Map<String, String> receipts;
	@override abstract final Base64String? encryptedSelf;

	static Map<String, dynamic> encode(MedicalHouseContract value) {
		switch (value) {
			case DecryptedMedicalHouseContract entity:
				Map<String, dynamic> entityJson = DecryptedMedicalHouseContract.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.DecryptedMedicalHouseContract";
				return entityJson;
			case EncryptedMedicalHouseContract entity:
				Map<String, dynamic> entityJson = EncryptedMedicalHouseContract.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.EncryptedMedicalHouseContract";
				return entityJson;
		}
	}

	static MedicalHouseContract fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.model.embed.DecryptedMedicalHouseContract":
				return DecryptedMedicalHouseContract.fromJSON(data);
			case "com.icure.cardinal.sdk.model.embed.EncryptedMedicalHouseContract":
				return EncryptedMedicalHouseContract.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

@freezed
abstract class DecryptedMedicalHouseContract with _$DecryptedMedicalHouseContract implements MedicalHouseContract {
	const factory DecryptedMedicalHouseContract({
		@Default(null) String? contractId,
		@Default(null) int? validFrom,
		@Default(null) int? validTo,
		@Default(null) String? mmNihii,
		@Default(null) String? hcpId,
		@Default(null) ContractChangeType? changeType,
		@Default(null) String? parentContractId,
		@Default(null) String? changedBy,
		@Default(null) int? startOfContract,
		@Default(null) int? startOfCoverage,
		@Default(null) int? endOfContract,
		@Default(null) int? endOfCoverage,
		@Default(false) bool kine,
		@Default(false) bool gp,
		@Default(false) bool ptd,
		@Default(false) bool nurse,
		@Default(false) bool noKine,
		@Default(false) bool noGp,
		@Default(false) bool noNurse,
		@Default(null) int? unsubscriptionReasonId,
		@Default(null) int? ptdStart,
		@Default(null) int? ptdEnd,
		@Default(null) int? ptdLastInvoiced,
		@Default(null) int? startOfSuspension,
		@Default(null) int? endOfSuspension,
		@Default(null) SuspensionReason? suspensionReason,
		@Default(null) String? suspensionSource,
		@Default(false) bool forcedSuspension,
		@Default(null) MhcSignatureType? signatureType,
		@Default(null) int? status,
		@Default({}) Map<String, String> options,
		@Default({}) Map<String, String> receipts,
		@Default(null) Base64String? encryptedSelf,
	}) = _DecryptedMedicalHouseContract;


	static Map<String, dynamic> encode(DecryptedMedicalHouseContract value) {
		Map<String, dynamic> entityAsMap = {
			"contractId" : value.contractId,
			"validFrom" : value.validFrom,
			"validTo" : value.validTo,
			"mmNihii" : value.mmNihii,
			"hcpId" : value.hcpId,
			"changeType" : value.changeType == null ? null : ContractChangeType.encode(value.changeType!),
			"parentContractId" : value.parentContractId,
			"changedBy" : value.changedBy,
			"startOfContract" : value.startOfContract,
			"startOfCoverage" : value.startOfCoverage,
			"endOfContract" : value.endOfContract,
			"endOfCoverage" : value.endOfCoverage,
			"kine" : value.kine,
			"gp" : value.gp,
			"ptd" : value.ptd,
			"nurse" : value.nurse,
			"noKine" : value.noKine,
			"noGp" : value.noGp,
			"noNurse" : value.noNurse,
			"unsubscriptionReasonId" : value.unsubscriptionReasonId,
			"ptdStart" : value.ptdStart,
			"ptdEnd" : value.ptdEnd,
			"ptdLastInvoiced" : value.ptdLastInvoiced,
			"startOfSuspension" : value.startOfSuspension,
			"endOfSuspension" : value.endOfSuspension,
			"suspensionReason" : value.suspensionReason == null ? null : SuspensionReason.encode(value.suspensionReason!),
			"suspensionSource" : value.suspensionSource,
			"forcedSuspension" : value.forcedSuspension,
			"signatureType" : value.signatureType == null ? null : MhcSignatureType.encode(value.signatureType!),
			"status" : value.status,
			"options" : value.options.map((k0, v0) => MapEntry(k0, v0)),
			"receipts" : value.receipts.map((k0, v0) => MapEntry(k0, v0)),
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}

	static DecryptedMedicalHouseContract fromJSON(Map<String, dynamic> data) {
		return DecryptedMedicalHouseContract(
			unsubscriptionReasonId: (data["unsubscriptionReasonId"] as int?),
			status: (data["status"] as int?),
			contractId: (data["contractId"] as String?),
			validFrom: (data["validFrom"] as int?),
			validTo: (data["validTo"] as int?),
			mmNihii: (data["mmNihii"] as String?),
			hcpId: (data["hcpId"] as String?),
			changeType: data["changeType"] == null ? null : ContractChangeType.fromJSON(data["changeType"]),
			parentContractId: (data["parentContractId"] as String?),
			changedBy: (data["changedBy"] as String?),
			startOfContract: (data["startOfContract"] as int?),
			startOfCoverage: (data["startOfCoverage"] as int?),
			endOfContract: (data["endOfContract"] as int?),
			endOfCoverage: (data["endOfCoverage"] as int?),
			kine: (data["kine"] as bool),
			gp: (data["gp"] as bool),
			ptd: (data["ptd"] as bool),
			nurse: (data["nurse"] as bool),
			noKine: (data["noKine"] as bool),
			noGp: (data["noGp"] as bool),
			noNurse: (data["noNurse"] as bool),
			ptdStart: (data["ptdStart"] as int?),
			ptdEnd: (data["ptdEnd"] as int?),
			ptdLastInvoiced: (data["ptdLastInvoiced"] as int?),
			startOfSuspension: (data["startOfSuspension"] as int?),
			endOfSuspension: (data["endOfSuspension"] as int?),
			suspensionReason: data["suspensionReason"] == null ? null : SuspensionReason.fromJSON(data["suspensionReason"]),
			suspensionSource: (data["suspensionSource"] as String?),
			forcedSuspension: (data["forcedSuspension"] as bool),
			signatureType: data["signatureType"] == null ? null : MhcSignatureType.fromJSON(data["signatureType"]),
			options: (data["options"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			receipts: (data["receipts"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			encryptedSelf: (data["encryptedSelf"] as Base64String?)
		);
	}
}

@freezed
abstract class EncryptedMedicalHouseContract with _$EncryptedMedicalHouseContract implements MedicalHouseContract {
	const factory EncryptedMedicalHouseContract({
		@Default(null) String? contractId,
		@Default(null) int? validFrom,
		@Default(null) int? validTo,
		@Default(null) String? mmNihii,
		@Default(null) String? hcpId,
		@Default(null) ContractChangeType? changeType,
		@Default(null) String? parentContractId,
		@Default(null) String? changedBy,
		@Default(null) int? startOfContract,
		@Default(null) int? startOfCoverage,
		@Default(null) int? endOfContract,
		@Default(null) int? endOfCoverage,
		@Default(false) bool kine,
		@Default(false) bool gp,
		@Default(false) bool ptd,
		@Default(false) bool nurse,
		@Default(false) bool noKine,
		@Default(false) bool noGp,
		@Default(false) bool noNurse,
		@Default(null) int? unsubscriptionReasonId,
		@Default(null) int? ptdStart,
		@Default(null) int? ptdEnd,
		@Default(null) int? ptdLastInvoiced,
		@Default(null) int? startOfSuspension,
		@Default(null) int? endOfSuspension,
		@Default(null) SuspensionReason? suspensionReason,
		@Default(null) String? suspensionSource,
		@Default(false) bool forcedSuspension,
		@Default(null) MhcSignatureType? signatureType,
		@Default(null) int? status,
		@Default({}) Map<String, String> options,
		@Default({}) Map<String, String> receipts,
		@Default(null) Base64String? encryptedSelf,
	}) = _EncryptedMedicalHouseContract;


	static Map<String, dynamic> encode(EncryptedMedicalHouseContract value) {
		Map<String, dynamic> entityAsMap = {
			"contractId" : value.contractId,
			"validFrom" : value.validFrom,
			"validTo" : value.validTo,
			"mmNihii" : value.mmNihii,
			"hcpId" : value.hcpId,
			"changeType" : value.changeType == null ? null : ContractChangeType.encode(value.changeType!),
			"parentContractId" : value.parentContractId,
			"changedBy" : value.changedBy,
			"startOfContract" : value.startOfContract,
			"startOfCoverage" : value.startOfCoverage,
			"endOfContract" : value.endOfContract,
			"endOfCoverage" : value.endOfCoverage,
			"kine" : value.kine,
			"gp" : value.gp,
			"ptd" : value.ptd,
			"nurse" : value.nurse,
			"noKine" : value.noKine,
			"noGp" : value.noGp,
			"noNurse" : value.noNurse,
			"unsubscriptionReasonId" : value.unsubscriptionReasonId,
			"ptdStart" : value.ptdStart,
			"ptdEnd" : value.ptdEnd,
			"ptdLastInvoiced" : value.ptdLastInvoiced,
			"startOfSuspension" : value.startOfSuspension,
			"endOfSuspension" : value.endOfSuspension,
			"suspensionReason" : value.suspensionReason == null ? null : SuspensionReason.encode(value.suspensionReason!),
			"suspensionSource" : value.suspensionSource,
			"forcedSuspension" : value.forcedSuspension,
			"signatureType" : value.signatureType == null ? null : MhcSignatureType.encode(value.signatureType!),
			"status" : value.status,
			"options" : value.options.map((k0, v0) => MapEntry(k0, v0)),
			"receipts" : value.receipts.map((k0, v0) => MapEntry(k0, v0)),
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}

	static EncryptedMedicalHouseContract fromJSON(Map<String, dynamic> data) {
		return EncryptedMedicalHouseContract(
			unsubscriptionReasonId: (data["unsubscriptionReasonId"] as int?),
			status: (data["status"] as int?),
			contractId: (data["contractId"] as String?),
			validFrom: (data["validFrom"] as int?),
			validTo: (data["validTo"] as int?),
			mmNihii: (data["mmNihii"] as String?),
			hcpId: (data["hcpId"] as String?),
			changeType: data["changeType"] == null ? null : ContractChangeType.fromJSON(data["changeType"]),
			parentContractId: (data["parentContractId"] as String?),
			changedBy: (data["changedBy"] as String?),
			startOfContract: (data["startOfContract"] as int?),
			startOfCoverage: (data["startOfCoverage"] as int?),
			endOfContract: (data["endOfContract"] as int?),
			endOfCoverage: (data["endOfCoverage"] as int?),
			kine: (data["kine"] as bool),
			gp: (data["gp"] as bool),
			ptd: (data["ptd"] as bool),
			nurse: (data["nurse"] as bool),
			noKine: (data["noKine"] as bool),
			noGp: (data["noGp"] as bool),
			noNurse: (data["noNurse"] as bool),
			ptdStart: (data["ptdStart"] as int?),
			ptdEnd: (data["ptdEnd"] as int?),
			ptdLastInvoiced: (data["ptdLastInvoiced"] as int?),
			startOfSuspension: (data["startOfSuspension"] as int?),
			endOfSuspension: (data["endOfSuspension"] as int?),
			suspensionReason: data["suspensionReason"] == null ? null : SuspensionReason.fromJSON(data["suspensionReason"]),
			suspensionSource: (data["suspensionSource"] as String?),
			forcedSuspension: (data["forcedSuspension"] as bool),
			signatureType: data["signatureType"] == null ? null : MhcSignatureType.fromJSON(data["signatureType"]),
			options: (data["options"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			receipts: (data["receipts"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			encryptedSelf: (data["encryptedSelf"] as Base64String?)
		);
	}
}
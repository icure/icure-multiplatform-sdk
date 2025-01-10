// auto-generated file
import 'package:cardinal_sdk/model/embed/contract_change_type.dart';
import 'package:cardinal_sdk/annotations/actual_int32.dart';
import 'package:cardinal_sdk/model/embed/suspension_reason.dart';
import 'package:cardinal_sdk/model/embed/mhc_signature_type.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/medical_house_contract.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';


sealed class MedicalHouseContract implements Encryptable {
	abstract String? contractId;
	abstract int? validFrom;
	abstract int? validTo;
	abstract String? mmNihii;
	abstract String? hcpId;
	abstract ContractChangeType? changeType;
	abstract String? parentContractId;
	abstract String? changedBy;
	abstract int? startOfContract;
	abstract int? startOfCoverage;
	abstract int? endOfContract;
	abstract int? endOfCoverage;
	abstract bool kine;
	abstract bool gp;
	abstract bool ptd;
	abstract bool nurse;
	abstract bool noKine;
	abstract bool noGp;
	abstract bool noNurse;
	@ActualInt32() abstract int? unsubscriptionReasonId;
	abstract int? ptdStart;
	abstract int? ptdEnd;
	abstract int? ptdLastInvoiced;
	abstract int? startOfSuspension;
	abstract int? endOfSuspension;
	abstract SuspensionReason? suspensionReason;
	abstract String? suspensionSource;
	abstract bool forcedSuspension;
	abstract MhcSignatureType? signatureType;
	@ActualInt32() abstract int? status;
	abstract Map<String, String> options;
	abstract Map<String, String> receipts;
	@override abstract Base64String? encryptedSelf;

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

class DecryptedMedicalHouseContract implements MedicalHouseContract {
	@override String? contractId = null;
	@override int? validFrom = null;
	@override int? validTo = null;
	@override String? mmNihii = null;
	@override String? hcpId = null;
	@override ContractChangeType? changeType = null;
	@override String? parentContractId = null;
	@override String? changedBy = null;
	@override int? startOfContract = null;
	@override int? startOfCoverage = null;
	@override int? endOfContract = null;
	@override int? endOfCoverage = null;
	@override bool kine = false;
	@override bool gp = false;
	@override bool ptd = false;
	@override bool nurse = false;
	@override bool noKine = false;
	@override bool noGp = false;
	@override bool noNurse = false;
	int? _unsubscriptionReasonId = null;
	@ActualInt32() @override int? get unsubscriptionReasonId => _unsubscriptionReasonId;
	@ActualInt32() @override set unsubscriptionReasonId(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('unsubscriptionReasonId value cannot exceed 2147483647');
		}
		_unsubscriptionReasonId = value;
	}
	@override int? ptdStart = null;
	@override int? ptdEnd = null;
	@override int? ptdLastInvoiced = null;
	@override int? startOfSuspension = null;
	@override int? endOfSuspension = null;
	@override SuspensionReason? suspensionReason = null;
	@override String? suspensionSource = null;
	@override bool forcedSuspension = false;
	@override MhcSignatureType? signatureType = null;
	int? _status = null;
	@ActualInt32() @override int? get status => _status;
	@ActualInt32() @override set status(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('status value cannot exceed 2147483647');
		}
		_status = value;
	}
	@override Map<String, String> options = {};
	@override Map<String, String> receipts = {};
	@override Base64String? encryptedSelf = null;
	DecryptedMedicalHouseContract({
			int? unsubscriptionReasonId,
			int? status,
			String? contractId,
			int? validFrom,
			int? validTo,
			String? mmNihii,
			String? hcpId,
			ContractChangeType? changeType,
			String? parentContractId,
			String? changedBy,
			int? startOfContract,
			int? startOfCoverage,
			int? endOfContract,
			int? endOfCoverage,
			bool? kine,
			bool? gp,
			bool? ptd,
			bool? nurse,
			bool? noKine,
			bool? noGp,
			bool? noNurse,
			int? ptdStart,
			int? ptdEnd,
			int? ptdLastInvoiced,
			int? startOfSuspension,
			int? endOfSuspension,
			SuspensionReason? suspensionReason,
			String? suspensionSource,
			bool? forcedSuspension,
			MhcSignatureType? signatureType,
			Map<String, String>? options,
			Map<String, String>? receipts,
			Base64String? encryptedSelf
		}) : contractId = contractId ?? null,
		validFrom = validFrom ?? null,
		validTo = validTo ?? null,
		mmNihii = mmNihii ?? null,
		hcpId = hcpId ?? null,
		changeType = changeType ?? null,
		parentContractId = parentContractId ?? null,
		changedBy = changedBy ?? null,
		startOfContract = startOfContract ?? null,
		startOfCoverage = startOfCoverage ?? null,
		endOfContract = endOfContract ?? null,
		endOfCoverage = endOfCoverage ?? null,
		kine = kine ?? false,
		gp = gp ?? false,
		ptd = ptd ?? false,
		nurse = nurse ?? false,
		noKine = noKine ?? false,
		noGp = noGp ?? false,
		noNurse = noNurse ?? false,
		ptdStart = ptdStart ?? null,
		ptdEnd = ptdEnd ?? null,
		ptdLastInvoiced = ptdLastInvoiced ?? null,
		startOfSuspension = startOfSuspension ?? null,
		endOfSuspension = endOfSuspension ?? null,
		suspensionReason = suspensionReason ?? null,
		suspensionSource = suspensionSource ?? null,
		forcedSuspension = forcedSuspension ?? false,
		signatureType = signatureType ?? null,
		options = options ?? {},
		receipts = receipts ?? {},
		encryptedSelf = encryptedSelf ?? null,
		_unsubscriptionReasonId = unsubscriptionReasonId ?? null,
		_status = status ?? null;

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

class EncryptedMedicalHouseContract implements MedicalHouseContract {
	@override String? contractId = null;
	@override int? validFrom = null;
	@override int? validTo = null;
	@override String? mmNihii = null;
	@override String? hcpId = null;
	@override ContractChangeType? changeType = null;
	@override String? parentContractId = null;
	@override String? changedBy = null;
	@override int? startOfContract = null;
	@override int? startOfCoverage = null;
	@override int? endOfContract = null;
	@override int? endOfCoverage = null;
	@override bool kine = false;
	@override bool gp = false;
	@override bool ptd = false;
	@override bool nurse = false;
	@override bool noKine = false;
	@override bool noGp = false;
	@override bool noNurse = false;
	int? _unsubscriptionReasonId = null;
	@ActualInt32() @override int? get unsubscriptionReasonId => _unsubscriptionReasonId;
	@ActualInt32() @override set unsubscriptionReasonId(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('unsubscriptionReasonId value cannot exceed 2147483647');
		}
		_unsubscriptionReasonId = value;
	}
	@override int? ptdStart = null;
	@override int? ptdEnd = null;
	@override int? ptdLastInvoiced = null;
	@override int? startOfSuspension = null;
	@override int? endOfSuspension = null;
	@override SuspensionReason? suspensionReason = null;
	@override String? suspensionSource = null;
	@override bool forcedSuspension = false;
	@override MhcSignatureType? signatureType = null;
	int? _status = null;
	@ActualInt32() @override int? get status => _status;
	@ActualInt32() @override set status(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('status value cannot exceed 2147483647');
		}
		_status = value;
	}
	@override Map<String, String> options = {};
	@override Map<String, String> receipts = {};
	@override Base64String? encryptedSelf = null;
	EncryptedMedicalHouseContract({
			int? unsubscriptionReasonId,
			int? status,
			String? contractId,
			int? validFrom,
			int? validTo,
			String? mmNihii,
			String? hcpId,
			ContractChangeType? changeType,
			String? parentContractId,
			String? changedBy,
			int? startOfContract,
			int? startOfCoverage,
			int? endOfContract,
			int? endOfCoverage,
			bool? kine,
			bool? gp,
			bool? ptd,
			bool? nurse,
			bool? noKine,
			bool? noGp,
			bool? noNurse,
			int? ptdStart,
			int? ptdEnd,
			int? ptdLastInvoiced,
			int? startOfSuspension,
			int? endOfSuspension,
			SuspensionReason? suspensionReason,
			String? suspensionSource,
			bool? forcedSuspension,
			MhcSignatureType? signatureType,
			Map<String, String>? options,
			Map<String, String>? receipts,
			Base64String? encryptedSelf
		}) : contractId = contractId ?? null,
		validFrom = validFrom ?? null,
		validTo = validTo ?? null,
		mmNihii = mmNihii ?? null,
		hcpId = hcpId ?? null,
		changeType = changeType ?? null,
		parentContractId = parentContractId ?? null,
		changedBy = changedBy ?? null,
		startOfContract = startOfContract ?? null,
		startOfCoverage = startOfCoverage ?? null,
		endOfContract = endOfContract ?? null,
		endOfCoverage = endOfCoverage ?? null,
		kine = kine ?? false,
		gp = gp ?? false,
		ptd = ptd ?? false,
		nurse = nurse ?? false,
		noKine = noKine ?? false,
		noGp = noGp ?? false,
		noNurse = noNurse ?? false,
		ptdStart = ptdStart ?? null,
		ptdEnd = ptdEnd ?? null,
		ptdLastInvoiced = ptdLastInvoiced ?? null,
		startOfSuspension = startOfSuspension ?? null,
		endOfSuspension = endOfSuspension ?? null,
		suspensionReason = suspensionReason ?? null,
		suspensionSource = suspensionSource ?? null,
		forcedSuspension = forcedSuspension ?? false,
		signatureType = signatureType ?? null,
		options = options ?? {},
		receipts = receipts ?? {},
		encryptedSelf = encryptedSelf ?? null,
		_unsubscriptionReasonId = unsubscriptionReasonId ?? null,
		_status = status ?? null;

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
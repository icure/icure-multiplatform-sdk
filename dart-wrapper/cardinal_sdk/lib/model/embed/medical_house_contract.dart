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
	@override String? contractId;
	@override int? validFrom;
	@override int? validTo;
	@override String? mmNihii;
	@override String? hcpId;
	@override ContractChangeType? changeType;
	@override String? parentContractId;
	@override String? changedBy;
	@override int? startOfContract;
	@override int? startOfCoverage;
	@override int? endOfContract;
	@override int? endOfCoverage;
	@override bool kine = false;
	@override bool gp = false;
	@override bool ptd = false;
	@override bool nurse = false;
	@override bool noKine = false;
	@override bool noGp = false;
	@override bool noNurse = false;
	int? _unsubscriptionReasonId;
	@ActualInt32() @override int? get unsubscriptionReasonId => _unsubscriptionReasonId;
	@ActualInt32() @override set unsubscriptionReasonId(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('unsubscriptionReasonId value cannot exceed 2147483647');
		}
		_unsubscriptionReasonId = value;
	}
	@override int? ptdStart;
	@override int? ptdEnd;
	@override int? ptdLastInvoiced;
	@override int? startOfSuspension;
	@override int? endOfSuspension;
	@override SuspensionReason? suspensionReason;
	@override String? suspensionSource;
	@override bool forcedSuspension = false;
	@override MhcSignatureType? signatureType;
	int? _status;
	@ActualInt32() @override int? get status => _status;
	@ActualInt32() @override set status(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('status value cannot exceed 2147483647');
		}
		_status = value;
	}
	@override Map<String, String> options = {};
	@override Map<String, String> receipts = {};
	@override Base64String? encryptedSelf;
	DecryptedMedicalHouseContract({
			int? unsubscriptionReasonId,
			int? status,
			this.contractId,
			this.validFrom,
			this.validTo,
			this.mmNihii,
			this.hcpId,
			this.changeType,
			this.parentContractId,
			this.changedBy,
			this.startOfContract,
			this.startOfCoverage,
			this.endOfContract,
			this.endOfCoverage,
			this.ptdStart,
			this.ptdEnd,
			this.ptdLastInvoiced,
			this.startOfSuspension,
			this.endOfSuspension,
			this.suspensionReason,
			this.suspensionSource,
			this.signatureType,
			this.encryptedSelf,
			bool? kine,
			bool? gp,
			bool? ptd,
			bool? nurse,
			bool? noKine,
			bool? noGp,
			bool? noNurse,
			bool? forcedSuspension,
			Map<String, String>? options,
			Map<String, String>? receipts
		}) : kine = kine ?? false,
		gp = gp ?? false,
		ptd = ptd ?? false,
		nurse = nurse ?? false,
		noKine = noKine ?? false,
		noGp = noGp ?? false,
		noNurse = noNurse ?? false,
		forcedSuspension = forcedSuspension ?? false,
		options = options ?? {},
		receipts = receipts ?? {},
		_unsubscriptionReasonId = unsubscriptionReasonId,
		_status = status;

	factory DecryptedMedicalHouseContract.fromJSON(Map<String, dynamic> data) {
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
}

class EncryptedMedicalHouseContract implements MedicalHouseContract {
	@override String? contractId;
	@override int? validFrom;
	@override int? validTo;
	@override String? mmNihii;
	@override String? hcpId;
	@override ContractChangeType? changeType;
	@override String? parentContractId;
	@override String? changedBy;
	@override int? startOfContract;
	@override int? startOfCoverage;
	@override int? endOfContract;
	@override int? endOfCoverage;
	@override bool kine = false;
	@override bool gp = false;
	@override bool ptd = false;
	@override bool nurse = false;
	@override bool noKine = false;
	@override bool noGp = false;
	@override bool noNurse = false;
	int? _unsubscriptionReasonId;
	@ActualInt32() @override int? get unsubscriptionReasonId => _unsubscriptionReasonId;
	@ActualInt32() @override set unsubscriptionReasonId(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('unsubscriptionReasonId value cannot exceed 2147483647');
		}
		_unsubscriptionReasonId = value;
	}
	@override int? ptdStart;
	@override int? ptdEnd;
	@override int? ptdLastInvoiced;
	@override int? startOfSuspension;
	@override int? endOfSuspension;
	@override SuspensionReason? suspensionReason;
	@override String? suspensionSource;
	@override bool forcedSuspension = false;
	@override MhcSignatureType? signatureType;
	int? _status;
	@ActualInt32() @override int? get status => _status;
	@ActualInt32() @override set status(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('status value cannot exceed 2147483647');
		}
		_status = value;
	}
	@override Map<String, String> options = {};
	@override Map<String, String> receipts = {};
	@override Base64String? encryptedSelf;
	EncryptedMedicalHouseContract({
			int? unsubscriptionReasonId,
			int? status,
			this.contractId,
			this.validFrom,
			this.validTo,
			this.mmNihii,
			this.hcpId,
			this.changeType,
			this.parentContractId,
			this.changedBy,
			this.startOfContract,
			this.startOfCoverage,
			this.endOfContract,
			this.endOfCoverage,
			this.ptdStart,
			this.ptdEnd,
			this.ptdLastInvoiced,
			this.startOfSuspension,
			this.endOfSuspension,
			this.suspensionReason,
			this.suspensionSource,
			this.signatureType,
			this.encryptedSelf,
			bool? kine,
			bool? gp,
			bool? ptd,
			bool? nurse,
			bool? noKine,
			bool? noGp,
			bool? noNurse,
			bool? forcedSuspension,
			Map<String, String>? options,
			Map<String, String>? receipts
		}) : kine = kine ?? false,
		gp = gp ?? false,
		ptd = ptd ?? false,
		nurse = nurse ?? false,
		noKine = noKine ?? false,
		noGp = noGp ?? false,
		noNurse = noNurse ?? false,
		forcedSuspension = forcedSuspension ?? false,
		options = options ?? {},
		receipts = receipts ?? {},
		_unsubscriptionReasonId = unsubscriptionReasonId,
		_status = status;

	factory EncryptedMedicalHouseContract.fromJSON(Map<String, dynamic> data) {
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
}
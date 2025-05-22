// auto-generated file
import 'package:cardinal_sdk/model/base/crypto_actor.dart';
import 'package:cardinal_sdk/model/healthcare_party.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/model/device.dart';
part "data_owner_with_type.freezed.dart";


sealed class DataOwnerWithType {
	CryptoActor get dataOwner;

	static Map<String, dynamic> encode(DataOwnerWithType value) {
		switch (value) {
			case DataOwnerWithTypeHcpDataOwner entity:
				Map<String, dynamic> entityJson = DataOwnerWithTypeHcpDataOwner.encode(entity);
				entityJson["kotlinType"] = "hcp";
				return entityJson;
			case DataOwnerWithTypePatientDataOwner entity:
				Map<String, dynamic> entityJson = DataOwnerWithTypePatientDataOwner.encode(entity);
				entityJson["kotlinType"] = "patient";
				return entityJson;
			case DataOwnerWithTypeDeviceDataOwner entity:
				Map<String, dynamic> entityJson = DataOwnerWithTypeDeviceDataOwner.encode(entity);
				entityJson["kotlinType"] = "device";
				return entityJson;
		}
	}

	static DataOwnerWithType fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "hcp":
				return DataOwnerWithTypeHcpDataOwner.fromJSON(data);
			case "patient":
				return DataOwnerWithTypePatientDataOwner.fromJSON(data);
			case "device":
				return DataOwnerWithTypeDeviceDataOwner.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

@freezed
abstract class DataOwnerWithTypeHcpDataOwner with _$DataOwnerWithTypeHcpDataOwner implements DataOwnerWithType {
	const factory DataOwnerWithTypeHcpDataOwner({
		required HealthcareParty dataOwner,
	}) = _DataOwnerWithTypeHcpDataOwner;


	static Map<String, dynamic> encode(DataOwnerWithTypeHcpDataOwner value) {
		Map<String, dynamic> entityAsMap = {
			"dataOwner" : HealthcareParty.encode(value.dataOwner)
		};
		return entityAsMap;
	}

	static DataOwnerWithTypeHcpDataOwner fromJSON(Map<String, dynamic> data) {
		return DataOwnerWithTypeHcpDataOwner(
			dataOwner: HealthcareParty.fromJSON(data["dataOwner"])
		);
	}
}

@freezed
abstract class DataOwnerWithTypePatientDataOwner with _$DataOwnerWithTypePatientDataOwner implements DataOwnerWithType {
	const factory DataOwnerWithTypePatientDataOwner({
		required EncryptedPatient dataOwner,
	}) = _DataOwnerWithTypePatientDataOwner;


	static Map<String, dynamic> encode(DataOwnerWithTypePatientDataOwner value) {
		Map<String, dynamic> entityAsMap = {
			"dataOwner" : EncryptedPatient.encode(value.dataOwner)
		};
		return entityAsMap;
	}

	static DataOwnerWithTypePatientDataOwner fromJSON(Map<String, dynamic> data) {
		return DataOwnerWithTypePatientDataOwner(
			dataOwner: EncryptedPatient.fromJSON(data["dataOwner"])
		);
	}
}

@freezed
abstract class DataOwnerWithTypeDeviceDataOwner with _$DataOwnerWithTypeDeviceDataOwner implements DataOwnerWithType {
	const factory DataOwnerWithTypeDeviceDataOwner({
		required Device dataOwner,
	}) = _DataOwnerWithTypeDeviceDataOwner;


	static Map<String, dynamic> encode(DataOwnerWithTypeDeviceDataOwner value) {
		Map<String, dynamic> entityAsMap = {
			"dataOwner" : Device.encode(value.dataOwner)
		};
		return entityAsMap;
	}

	static DataOwnerWithTypeDeviceDataOwner fromJSON(Map<String, dynamic> data) {
		return DataOwnerWithTypeDeviceDataOwner(
			dataOwner: Device.fromJSON(data["dataOwner"])
		);
	}
}
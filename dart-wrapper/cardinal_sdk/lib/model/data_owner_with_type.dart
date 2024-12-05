// auto-generated file
import 'package:cardinal_sdk/model/base/crypto_actor.dart';
import 'package:cardinal_sdk/model/healthcare_party.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/model/device.dart';


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

class DataOwnerWithTypeHcpDataOwner implements DataOwnerWithType {
	@override HealthcareParty dataOwner;
	DataOwnerWithTypeHcpDataOwner(this.dataOwner);

	static Map<String, dynamic> encode(DataOwnerWithTypeHcpDataOwner value) {
		Map<String, dynamic> entityAsMap = {
			"dataOwner" : HealthcareParty.encode(value.dataOwner)
		};
		return entityAsMap;
	}

	static DataOwnerWithTypeHcpDataOwner fromJSON(Map<String, dynamic> data) {
		return DataOwnerWithTypeHcpDataOwner(
			HealthcareParty.fromJSON(data["dataOwner"])
		);
	}
}

class DataOwnerWithTypePatientDataOwner implements DataOwnerWithType {
	@override EncryptedPatient dataOwner;
	DataOwnerWithTypePatientDataOwner(this.dataOwner);

	static Map<String, dynamic> encode(DataOwnerWithTypePatientDataOwner value) {
		Map<String, dynamic> entityAsMap = {
			"dataOwner" : EncryptedPatient.encode(value.dataOwner)
		};
		return entityAsMap;
	}

	static DataOwnerWithTypePatientDataOwner fromJSON(Map<String, dynamic> data) {
		return DataOwnerWithTypePatientDataOwner(
			EncryptedPatient.fromJSON(data["dataOwner"])
		);
	}
}

class DataOwnerWithTypeDeviceDataOwner implements DataOwnerWithType {
	@override Device dataOwner;
	DataOwnerWithTypeDeviceDataOwner(this.dataOwner);

	static Map<String, dynamic> encode(DataOwnerWithTypeDeviceDataOwner value) {
		Map<String, dynamic> entityAsMap = {
			"dataOwner" : Device.encode(value.dataOwner)
		};
		return entityAsMap;
	}

	static DataOwnerWithTypeDeviceDataOwner fromJSON(Map<String, dynamic> data) {
		return DataOwnerWithTypeDeviceDataOwner(
			Device.fromJSON(data["dataOwner"])
		);
	}
}
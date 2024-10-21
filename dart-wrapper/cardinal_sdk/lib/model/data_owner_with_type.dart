// This file is auto-generated
import 'package:cardinal_sdk/model/base/crypto_actor.dart';
import 'package:cardinal_sdk/model/healthcare_party.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/model/device.dart';


sealed class DataOwnerWithType<T extends CryptoActor> {
	abstract T dataOwner;


	static Map<String, dynamic> encode(DataOwnerWithType value) {
		switch (value) {
			case DataOwnerWithTypeHcpDataOwner entity:
				Map<String, dynamic> entityJson = DataOwnerWithTypeHcpDataOwner.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.DataOwnerWithType.HcpDataOwner";
				return entityJson;
			case DataOwnerWithTypePatientDataOwner entity:
				Map<String, dynamic> entityJson = DataOwnerWithTypePatientDataOwner.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.DataOwnerWithType.PatientDataOwner";
				return entityJson;
			case DataOwnerWithTypeDeviceDataOwner entity:
				Map<String, dynamic> entityJson = DataOwnerWithTypeDeviceDataOwner.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.DataOwnerWithType.DeviceDataOwner";
				return entityJson;
		}
	}
}

class DataOwnerWithTypeHcpDataOwner implements DataOwnerWithType<HealthcareParty> {
	@override  HealthcareParty dataOwner;

	DataOwnerWithTypeHcpDataOwner({
		required this.dataOwner
	});

	static Map<String, dynamic> encode(DataOwnerWithTypeHcpDataOwner value) {
		Map<String, dynamic> entityAsMap = {
			"dataOwner" : HealthcareParty.encode(value.dataOwner)
		};
		return entityAsMap;
	}
}

class DataOwnerWithTypePatientDataOwner implements DataOwnerWithType<EncryptedPatient> {
	@override  EncryptedPatient dataOwner;

	DataOwnerWithTypePatientDataOwner({
		required this.dataOwner
	});

	static Map<String, dynamic> encode(DataOwnerWithTypePatientDataOwner value) {
		Map<String, dynamic> entityAsMap = {
			"dataOwner" : EncryptedPatient.encode(value.dataOwner)
		};
		return entityAsMap;
	}
}

class DataOwnerWithTypeDeviceDataOwner implements DataOwnerWithType<Device> {
	@override  Device dataOwner;

	DataOwnerWithTypeDeviceDataOwner({
		required this.dataOwner
	});

	static Map<String, dynamic> encode(DataOwnerWithTypeDeviceDataOwner value) {
		Map<String, dynamic> entityAsMap = {
			"dataOwner" : Device.encode(value.dataOwner)
		};
		return entityAsMap;
	}
}
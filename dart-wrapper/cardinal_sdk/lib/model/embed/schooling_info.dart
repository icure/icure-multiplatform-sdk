// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/schooling_info.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';


sealed class SchoolingInfo implements Encryptable {
	abstract int? startDate;
	abstract int? endDate;
	abstract String? school;
	abstract CodeStub? typeOfEducation;
	@override abstract Base64String? encryptedSelf;

	static Map<String, dynamic> encode(SchoolingInfo value) {
		switch (value) {
			case EncryptedSchoolingInfo entity:
				Map<String, dynamic> entityJson = EncryptedSchoolingInfo.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.EncryptedSchoolingInfo";
				return entityJson;
			case DecryptedSchoolingInfo entity:
				Map<String, dynamic> entityJson = DecryptedSchoolingInfo.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.DecryptedSchoolingInfo";
				return entityJson;
		}
	}

	static SchoolingInfo fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.model.embed.EncryptedSchoolingInfo":
				return EncryptedSchoolingInfo.fromJSON(data);
			case "com.icure.cardinal.sdk.model.embed.DecryptedSchoolingInfo":
				return DecryptedSchoolingInfo.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

class EncryptedSchoolingInfo implements SchoolingInfo {
	@override int? startDate = null;
	@override int? endDate = null;
	@override String? school = null;
	@override CodeStub? typeOfEducation = null;
	@override Base64String? encryptedSelf;
	EncryptedSchoolingInfo({
			this.encryptedSelf,
			int? startDate,
			int? endDate,
			String? school,
			CodeStub? typeOfEducation
		}) : startDate = startDate ?? null,
		endDate = endDate ?? null,
		school = school ?? null,
		typeOfEducation = typeOfEducation ?? null;

	static Map<String, dynamic> encode(EncryptedSchoolingInfo value) {
		Map<String, dynamic> entityAsMap = {
			"startDate" : value.startDate,
			"endDate" : value.endDate,
			"school" : value.school,
			"typeOfEducation" : value.typeOfEducation == null ? null : CodeStub.encode(value.typeOfEducation!),
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}

	static EncryptedSchoolingInfo fromJSON(Map<String, dynamic> data) {
		return EncryptedSchoolingInfo(
			startDate: (data["startDate"] as int?),
			endDate: (data["endDate"] as int?),
			school: (data["school"] as String?),
			typeOfEducation: data["typeOfEducation"] == null ? null : CodeStub.fromJSON(data["typeOfEducation"]),
			encryptedSelf: (data["encryptedSelf"] as Base64String?)
		);
	}
}

class DecryptedSchoolingInfo implements SchoolingInfo {
	@override int? startDate = null;
	@override int? endDate = null;
	@override String? school = null;
	@override CodeStub? typeOfEducation = null;
	@override Base64String? encryptedSelf;
	DecryptedSchoolingInfo({
			this.encryptedSelf,
			int? startDate,
			int? endDate,
			String? school,
			CodeStub? typeOfEducation
		}) : startDate = startDate ?? null,
		endDate = endDate ?? null,
		school = school ?? null,
		typeOfEducation = typeOfEducation ?? null;

	static Map<String, dynamic> encode(DecryptedSchoolingInfo value) {
		Map<String, dynamic> entityAsMap = {
			"startDate" : value.startDate,
			"endDate" : value.endDate,
			"school" : value.school,
			"typeOfEducation" : value.typeOfEducation == null ? null : CodeStub.encode(value.typeOfEducation!),
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}

	static DecryptedSchoolingInfo fromJSON(Map<String, dynamic> data) {
		return DecryptedSchoolingInfo(
			startDate: (data["startDate"] as int?),
			endDate: (data["endDate"] as int?),
			school: (data["school"] as String?),
			typeOfEducation: data["typeOfEducation"] == null ? null : CodeStub.fromJSON(data["typeOfEducation"]),
			encryptedSelf: (data["encryptedSelf"] as Base64String?)
		);
	}
}
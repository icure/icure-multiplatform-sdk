// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/embed/employer.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/employment_info.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';


sealed class EmploymentInfo implements Encryptable {
	abstract int? startDate;
	abstract int? endDate;
	abstract CodeStub? professionType;
	abstract Employer? employer;
	@override abstract Base64String? encryptedSelf;

	static Map<String, dynamic> encode(EmploymentInfo value) {
		switch (value) {
			case DecryptedEmploymentInfo entity:
				Map<String, dynamic> entityJson = DecryptedEmploymentInfo.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.DecryptedEmploymentInfo";
				return entityJson;
			case EncryptedEmploymentInfo entity:
				Map<String, dynamic> entityJson = EncryptedEmploymentInfo.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.EncryptedEmploymentInfo";
				return entityJson;
		}
	}

	static EmploymentInfo fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.model.embed.DecryptedEmploymentInfo":
				return DecryptedEmploymentInfo.fromJSON(data);
			case "com.icure.cardinal.sdk.model.embed.EncryptedEmploymentInfo":
				return EncryptedEmploymentInfo.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

class DecryptedEmploymentInfo implements EmploymentInfo {
	@override int? startDate = null;
	@override int? endDate = null;
	@override CodeStub? professionType = null;
	@override Employer? employer = null;
	@override Base64String? encryptedSelf;
	DecryptedEmploymentInfo({
			this.encryptedSelf,
			int? startDate,
			int? endDate,
			CodeStub? professionType,
			Employer? employer
		}) : startDate = startDate ?? null,
		endDate = endDate ?? null,
		professionType = professionType ?? null,
		employer = employer ?? null;

	factory DecryptedEmploymentInfo.fromJSON(Map<String, dynamic> data) {
		return DecryptedEmploymentInfo(
			startDate: (data["startDate"] as int?),
			endDate: (data["endDate"] as int?),
			professionType: data["professionType"] == null ? null : CodeStub.fromJSON(data["professionType"]),
			employer: data["employer"] == null ? null : Employer.fromJSON(data["employer"]),
			encryptedSelf: (data["encryptedSelf"] as Base64String?)
		);
	}

	static Map<String, dynamic> encode(DecryptedEmploymentInfo value) {
		Map<String, dynamic> entityAsMap = {
			"startDate" : value.startDate,
			"endDate" : value.endDate,
			"professionType" : value.professionType == null ? null : CodeStub.encode(value.professionType!),
			"employer" : value.employer == null ? null : Employer.encode(value.employer!),
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}
}

class EncryptedEmploymentInfo implements EmploymentInfo {
	@override int? startDate = null;
	@override int? endDate = null;
	@override CodeStub? professionType = null;
	@override Employer? employer = null;
	@override Base64String? encryptedSelf;
	EncryptedEmploymentInfo({
			this.encryptedSelf,
			int? startDate,
			int? endDate,
			CodeStub? professionType,
			Employer? employer
		}) : startDate = startDate ?? null,
		endDate = endDate ?? null,
		professionType = professionType ?? null,
		employer = employer ?? null;

	factory EncryptedEmploymentInfo.fromJSON(Map<String, dynamic> data) {
		return EncryptedEmploymentInfo(
			startDate: (data["startDate"] as int?),
			endDate: (data["endDate"] as int?),
			professionType: data["professionType"] == null ? null : CodeStub.fromJSON(data["professionType"]),
			employer: data["employer"] == null ? null : Employer.fromJSON(data["employer"]),
			encryptedSelf: (data["encryptedSelf"] as Base64String?)
		);
	}

	static Map<String, dynamic> encode(EncryptedEmploymentInfo value) {
		Map<String, dynamic> entityAsMap = {
			"startDate" : value.startDate,
			"endDate" : value.endDate,
			"professionType" : value.professionType == null ? null : CodeStub.encode(value.professionType!),
			"employer" : value.employer == null ? null : Employer.encode(value.employer!),
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}
}
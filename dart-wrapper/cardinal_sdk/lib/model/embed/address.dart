// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/base/identifier.dart';
import 'package:cardinal_sdk/model/embed/address_type.dart';
import 'package:cardinal_sdk/model/embed/annotation.dart';
import 'package:cardinal_sdk/model/embed/telecom.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/address.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';
import 'package:cardinal_sdk/model/base/has_tags.dart';
import 'package:cardinal_sdk/model/base/has_codes.dart';


sealed class Address implements Encryptable, HasTags, HasCodes {
	@override abstract Set<CodeStub> tags;
	@override abstract Set<CodeStub> codes;
	abstract List<Identifier> identifier;
	abstract AddressType? addressType;
	abstract String? descr;
	abstract String? street;
	abstract String? houseNumber;
	abstract String? postboxNumber;
	abstract String? postalCode;
	abstract String? city;
	abstract String? state;
	abstract String? country;
	abstract String? note;
	abstract List<Annotation> notes;
	List<Telecom> get telecoms;
	@override abstract Base64String? encryptedSelf;

	static Map<String, dynamic> encode(Address value) {
		switch (value) {
			case EncryptedAddress entity:
				Map<String, dynamic> entityJson = EncryptedAddress.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.EncryptedAddress";
				return entityJson;
			case DecryptedAddress entity:
				Map<String, dynamic> entityJson = DecryptedAddress.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.DecryptedAddress";
				return entityJson;
		}
	}

	static Address fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.model.embed.EncryptedAddress":
				return EncryptedAddress.fromJSON(data);
			case "com.icure.cardinal.sdk.model.embed.DecryptedAddress":
				return DecryptedAddress.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

class EncryptedAddress implements Address {
	@override Set<CodeStub> tags = {};
	@override Set<CodeStub> codes = {};
	@override List<Identifier> identifier = [];
	@override AddressType? addressType = null;
	@override String? descr = null;
	@override String? street = null;
	@override String? houseNumber = null;
	@override String? postboxNumber = null;
	@override String? postalCode = null;
	@override String? city = null;
	@override String? state = null;
	@override String? country = null;
	@override String? note = null;
	@override List<Annotation> notes = [];
	@override List<EncryptedTelecom> telecoms = [];
	@override Base64String? encryptedSelf = null;
	EncryptedAddress({
			Set<CodeStub>? tags,
			Set<CodeStub>? codes,
			List<Identifier>? identifier,
			AddressType? addressType,
			String? descr,
			String? street,
			String? houseNumber,
			String? postboxNumber,
			String? postalCode,
			String? city,
			String? state,
			String? country,
			String? note,
			List<Annotation>? notes,
			List<EncryptedTelecom>? telecoms,
			Base64String? encryptedSelf
		}) : tags = tags ?? {},
		codes = codes ?? {},
		identifier = identifier ?? [],
		addressType = addressType ?? null,
		descr = descr ?? null,
		street = street ?? null,
		houseNumber = houseNumber ?? null,
		postboxNumber = postboxNumber ?? null,
		postalCode = postalCode ?? null,
		city = city ?? null,
		state = state ?? null,
		country = country ?? null,
		note = note ?? null,
		notes = notes ?? [],
		telecoms = telecoms ?? [],
		encryptedSelf = encryptedSelf ?? null;

	static Map<String, dynamic> encode(EncryptedAddress value) {
		Map<String, dynamic> entityAsMap = {
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)).toList(),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)).toList(),
			"identifier" : value.identifier.map((x0) => Identifier.encode(x0)).toList(),
			"addressType" : value.addressType == null ? null : AddressType.encode(value.addressType!),
			"descr" : value.descr,
			"street" : value.street,
			"houseNumber" : value.houseNumber,
			"postboxNumber" : value.postboxNumber,
			"postalCode" : value.postalCode,
			"city" : value.city,
			"state" : value.state,
			"country" : value.country,
			"note" : value.note,
			"notes" : value.notes.map((x0) => Annotation.encode(x0)).toList(),
			"telecoms" : value.telecoms.map((x0) => EncryptedTelecom.encode(x0)).toList(),
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}

	static EncryptedAddress fromJSON(Map<String, dynamic> data) {
		return EncryptedAddress(
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			codes: (data["codes"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			identifier: (data["identifier"] as List<dynamic>).map((x0) => Identifier.fromJSON(x0) ).toList(),
			addressType: data["addressType"] == null ? null : AddressType.fromJSON(data["addressType"]),
			descr: (data["descr"] as String?),
			street: (data["street"] as String?),
			houseNumber: (data["houseNumber"] as String?),
			postboxNumber: (data["postboxNumber"] as String?),
			postalCode: (data["postalCode"] as String?),
			city: (data["city"] as String?),
			state: (data["state"] as String?),
			country: (data["country"] as String?),
			note: (data["note"] as String?),
			notes: (data["notes"] as List<dynamic>).map((x0) => Annotation.fromJSON(x0) ).toList(),
			telecoms: (data["telecoms"] as List<dynamic>).map((x0) => EncryptedTelecom.fromJSON(x0) ).toList(),
			encryptedSelf: (data["encryptedSelf"] as Base64String?)
		);
	}
}

class DecryptedAddress implements Address {
	@override Set<CodeStub> tags = {};
	@override Set<CodeStub> codes = {};
	@override List<Identifier> identifier = [];
	@override AddressType? addressType = null;
	@override String? descr = null;
	@override String? street = null;
	@override String? houseNumber = null;
	@override String? postboxNumber = null;
	@override String? postalCode = null;
	@override String? city = null;
	@override String? state = null;
	@override String? country = null;
	@override String? note = null;
	@override List<Annotation> notes = [];
	@override List<DecryptedTelecom> telecoms = [];
	@override Base64String? encryptedSelf = null;
	DecryptedAddress({
			Set<CodeStub>? tags,
			Set<CodeStub>? codes,
			List<Identifier>? identifier,
			AddressType? addressType,
			String? descr,
			String? street,
			String? houseNumber,
			String? postboxNumber,
			String? postalCode,
			String? city,
			String? state,
			String? country,
			String? note,
			List<Annotation>? notes,
			List<DecryptedTelecom>? telecoms,
			Base64String? encryptedSelf
		}) : tags = tags ?? {},
		codes = codes ?? {},
		identifier = identifier ?? [],
		addressType = addressType ?? null,
		descr = descr ?? null,
		street = street ?? null,
		houseNumber = houseNumber ?? null,
		postboxNumber = postboxNumber ?? null,
		postalCode = postalCode ?? null,
		city = city ?? null,
		state = state ?? null,
		country = country ?? null,
		note = note ?? null,
		notes = notes ?? [],
		telecoms = telecoms ?? [],
		encryptedSelf = encryptedSelf ?? null;

	static Map<String, dynamic> encode(DecryptedAddress value) {
		Map<String, dynamic> entityAsMap = {
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)).toList(),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)).toList(),
			"identifier" : value.identifier.map((x0) => Identifier.encode(x0)).toList(),
			"addressType" : value.addressType == null ? null : AddressType.encode(value.addressType!),
			"descr" : value.descr,
			"street" : value.street,
			"houseNumber" : value.houseNumber,
			"postboxNumber" : value.postboxNumber,
			"postalCode" : value.postalCode,
			"city" : value.city,
			"state" : value.state,
			"country" : value.country,
			"note" : value.note,
			"notes" : value.notes.map((x0) => Annotation.encode(x0)).toList(),
			"telecoms" : value.telecoms.map((x0) => DecryptedTelecom.encode(x0)).toList(),
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}

	static DecryptedAddress fromJSON(Map<String, dynamic> data) {
		return DecryptedAddress(
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			codes: (data["codes"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			identifier: (data["identifier"] as List<dynamic>).map((x0) => Identifier.fromJSON(x0) ).toList(),
			addressType: data["addressType"] == null ? null : AddressType.fromJSON(data["addressType"]),
			descr: (data["descr"] as String?),
			street: (data["street"] as String?),
			houseNumber: (data["houseNumber"] as String?),
			postboxNumber: (data["postboxNumber"] as String?),
			postalCode: (data["postalCode"] as String?),
			city: (data["city"] as String?),
			state: (data["state"] as String?),
			country: (data["country"] as String?),
			note: (data["note"] as String?),
			notes: (data["notes"] as List<dynamic>).map((x0) => Annotation.fromJSON(x0) ).toList(),
			telecoms: (data["telecoms"] as List<dynamic>).map((x0) => DecryptedTelecom.fromJSON(x0) ).toList(),
			encryptedSelf: (data["encryptedSelf"] as Base64String?)
		);
	}
}
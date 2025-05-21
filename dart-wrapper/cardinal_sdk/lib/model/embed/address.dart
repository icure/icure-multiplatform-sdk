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
import 'package:freezed_annotation/freezed_annotation.dart';
part "address.freezed.dart";


sealed class Address implements Encryptable, HasTags, HasCodes {
	@override abstract final Set<CodeStub> tags;
	@override abstract final Set<CodeStub> codes;
	abstract final List<Identifier> identifier;
	abstract final AddressType? addressType;
	abstract final String? descr;
	abstract final String? street;
	abstract final String? houseNumber;
	abstract final String? postboxNumber;
	abstract final String? postalCode;
	abstract final String? city;
	abstract final String? state;
	abstract final String? country;
	abstract final String? note;
	abstract final List<Annotation> notes;
	List<Telecom> get telecoms;
	@override abstract final Base64String? encryptedSelf;

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

@freezed
abstract class EncryptedAddress with _$EncryptedAddress implements Address {
	const factory EncryptedAddress({
		@Default({}) Set<CodeStub> tags,
		@Default({}) Set<CodeStub> codes,
		@Default([]) List<Identifier> identifier,
		@Default(null) AddressType? addressType,
		@Default(null) String? descr,
		@Default(null) String? street,
		@Default(null) String? houseNumber,
		@Default(null) String? postboxNumber,
		@Default(null) String? postalCode,
		@Default(null) String? city,
		@Default(null) String? state,
		@Default(null) String? country,
		@Default(null) String? note,
		@Default([]) List<Annotation> notes,
		@Default([]) List<EncryptedTelecom> telecoms,
		@Default(null) Base64String? encryptedSelf,
	}) = _EncryptedAddress;


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

@freezed
abstract class DecryptedAddress with _$DecryptedAddress implements Address {
	const factory DecryptedAddress({
		@Default({}) Set<CodeStub> tags,
		@Default({}) Set<CodeStub> codes,
		@Default([]) List<Identifier> identifier,
		@Default(null) AddressType? addressType,
		@Default(null) String? descr,
		@Default(null) String? street,
		@Default(null) String? houseNumber,
		@Default(null) String? postboxNumber,
		@Default(null) String? postalCode,
		@Default(null) String? city,
		@Default(null) String? state,
		@Default(null) String? country,
		@Default(null) String? note,
		@Default([]) List<Annotation> notes,
		@Default([]) List<DecryptedTelecom> telecoms,
		@Default(null) Base64String? encryptedSelf,
	}) = _DecryptedAddress;


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
// auto-generated file
import 'package:cardinal_sdk/model/embed/address_type.dart';
import 'package:cardinal_sdk/model/embed/annotation.dart';
import 'package:cardinal_sdk/model/embed/telecom.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/address.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';


sealed class Address implements Encryptable {
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
	@override AddressType? addressType;
	@override String? descr;
	@override String? street;
	@override String? houseNumber;
	@override String? postboxNumber;
	@override String? postalCode;
	@override String? city;
	@override String? state;
	@override String? country;
	@override String? note;
	@override List<Annotation> notes = [];
	@override List<EncryptedTelecom> telecoms = [];
	@override Base64String? encryptedSelf;
	EncryptedAddress({
			this.addressType,
			this.descr,
			this.street,
			this.houseNumber,
			this.postboxNumber,
			this.postalCode,
			this.city,
			this.state,
			this.country,
			this.note,
			this.encryptedSelf,
			List<Annotation>? notes,
			List<EncryptedTelecom>? telecoms
		}) : notes = notes ?? [],
		telecoms = telecoms ?? [];

	factory EncryptedAddress.fromJSON(Map<String, dynamic> data) {
		return EncryptedAddress(
			addressType: data["addressType"] == null ? null : AddressType.fromJSON(data["addressType"]),
			descr: data["descr"],
			street: data["street"],
			houseNumber: data["houseNumber"],
			postboxNumber: data["postboxNumber"],
			postalCode: data["postalCode"],
			city: data["city"],
			state: data["state"],
			country: data["country"],
			note: data["note"],
			notes: data["notes"].map((x0) => Annotation.fromJSON(x0) ).toList(),
			telecoms: data["telecoms"].map((x0) => EncryptedTelecom.fromJSON(x0) ).toList(),
			encryptedSelf: data["encryptedSelf"]
		);
	}

	static Map<String, dynamic> encode(EncryptedAddress value) {
		Map<String, dynamic> entityAsMap = {
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
}

class DecryptedAddress implements Address {
	@override AddressType? addressType;
	@override String? descr;
	@override String? street;
	@override String? houseNumber;
	@override String? postboxNumber;
	@override String? postalCode;
	@override String? city;
	@override String? state;
	@override String? country;
	@override String? note;
	@override List<Annotation> notes = [];
	@override List<DecryptedTelecom> telecoms = [];
	@override Base64String? encryptedSelf;
	DecryptedAddress({
			this.addressType,
			this.descr,
			this.street,
			this.houseNumber,
			this.postboxNumber,
			this.postalCode,
			this.city,
			this.state,
			this.country,
			this.note,
			this.encryptedSelf,
			List<Annotation>? notes,
			List<DecryptedTelecom>? telecoms
		}) : notes = notes ?? [],
		telecoms = telecoms ?? [];

	factory DecryptedAddress.fromJSON(Map<String, dynamic> data) {
		return DecryptedAddress(
			addressType: data["addressType"] == null ? null : AddressType.fromJSON(data["addressType"]),
			descr: data["descr"],
			street: data["street"],
			houseNumber: data["houseNumber"],
			postboxNumber: data["postboxNumber"],
			postalCode: data["postalCode"],
			city: data["city"],
			state: data["state"],
			country: data["country"],
			note: data["note"],
			notes: data["notes"].map((x0) => Annotation.fromJSON(x0) ).toList(),
			telecoms: data["telecoms"].map((x0) => DecryptedTelecom.fromJSON(x0) ).toList(),
			encryptedSelf: data["encryptedSelf"]
		);
	}

	static Map<String, dynamic> encode(DecryptedAddress value) {
		Map<String, dynamic> entityAsMap = {
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
}
// auto-generated file
import 'package:cardinal_sdk/model/embed/address.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/named.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "place.freezed.dart";


@freezed
abstract class Place with _$Place implements StoredDocument, Named {
	const factory Place({
		required String id,
		@Default(null) String? rev,
		@Default(null) int? deletionDate,
		@Default(null) String? name,
		@Default(null) DecryptedAddress? address,
	}) = _Place;


	static Map<String, dynamic> encode(Place value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"deletionDate" : value.deletionDate,
			"name" : value.name,
			"address" : value.address == null ? null : DecryptedAddress.encode(value.address!)
		};
		return entityAsMap;
	}

	static Place fromJSON(Map<String, dynamic> data) {
		return Place(
			id: (data["id"] as String),
			rev: (data["rev"] as String?),
			deletionDate: (data["deletionDate"] as int?),
			name: (data["name"] as String?),
			address: data["address"] == null ? null : DecryptedAddress.fromJSON(data["address"]),
		);
	}
}
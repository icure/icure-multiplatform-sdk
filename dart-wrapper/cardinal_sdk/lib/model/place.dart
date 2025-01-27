// auto-generated file
import 'package:cardinal_sdk/model/embed/address.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/named.dart';


class Place implements StoredDocument, Named {
	@override String id;
	@override String? rev = null;
	@override int? deletionDate = null;
	@override String? name = null;
	DecryptedAddress? address = null;
	Place(
		this.id,
		{
			String? rev,
			int? deletionDate,
			String? name,
			DecryptedAddress? address
		}) : rev = rev ?? null,
		deletionDate = deletionDate ?? null,
		name = name ?? null,
		address = address ?? null;

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
			(data["id"] as String),
			rev: (data["rev"] as String?),
			deletionDate: (data["deletionDate"] as int?),
			name: (data["name"] as String?),
			address: data["address"] == null ? null : DecryptedAddress.fromJSON(data["address"]),
		);
	}
}
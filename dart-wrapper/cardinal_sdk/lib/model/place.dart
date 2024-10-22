// This file is auto-generated
import 'package:cardinal_sdk/model/embed/address.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/named.dart';


class Place implements StoredDocument, Named {
	@override String id;
	@override String? rev;
	@override int? deletionDate;
	@override String? name;
	DecryptedAddress? address;
	Place(
		this.id,
		{
			this.rev,
			this.deletionDate,
			this.name,
			this.address
		});

	factory Place.fromJSON(Map<String, dynamic> data) {
		return Place(
			data["id"],
			rev: data["rev"],
			deletionDate: data["deletionDate"],
			name: data["name"],
			address: data["address"] == null ? null : DecryptedAddress.fromJSON(data["address"]),
		);
	}

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
}
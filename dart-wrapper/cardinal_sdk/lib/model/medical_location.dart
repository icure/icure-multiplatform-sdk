// auto-generated file
import 'package:cardinal_sdk/model/embed/address.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/named.dart';


class MedicalLocation implements StoredDocument, Named {
	@override String id;
	@override String? rev = null;
	@override int? deletionDate = null;
	@override String? name = null;
	String? description = null;
	String? responsible = null;
	bool? guardPost = null;
	String? cbe = null;
	String? bic = null;
	String? bankAccount = null;
	String? nihii = null;
	String? ssin = null;
	DecryptedAddress? address = null;
	Set<String> agendaIds = {};
	Map<String, String> options = {};
	Map<String, String> publicInformations = {};
	MedicalLocation(
		this.id,
		{
			String? rev,
			int? deletionDate,
			String? name,
			String? description,
			String? responsible,
			bool? guardPost,
			String? cbe,
			String? bic,
			String? bankAccount,
			String? nihii,
			String? ssin,
			DecryptedAddress? address,
			Set<String>? agendaIds,
			Map<String, String>? options,
			Map<String, String>? publicInformations
		}) : rev = rev ?? null,
		deletionDate = deletionDate ?? null,
		name = name ?? null,
		description = description ?? null,
		responsible = responsible ?? null,
		guardPost = guardPost ?? null,
		cbe = cbe ?? null,
		bic = bic ?? null,
		bankAccount = bankAccount ?? null,
		nihii = nihii ?? null,
		ssin = ssin ?? null,
		address = address ?? null,
		agendaIds = agendaIds ?? {},
		options = options ?? {},
		publicInformations = publicInformations ?? {};

	factory MedicalLocation.fromJSON(Map<String, dynamic> data) {
		return MedicalLocation(
			(data["id"] as String),
			rev: (data["rev"] as String?),
			deletionDate: (data["deletionDate"] as int?),
			name: (data["name"] as String?),
			description: (data["description"] as String?),
			responsible: (data["responsible"] as String?),
			guardPost: (data["guardPost"] as bool?),
			cbe: (data["cbe"] as String?),
			bic: (data["bic"] as String?),
			bankAccount: (data["bankAccount"] as String?),
			nihii: (data["nihii"] as String?),
			ssin: (data["ssin"] as String?),
			address: data["address"] == null ? null : DecryptedAddress.fromJSON(data["address"]),
			agendaIds: (data["agendaIds"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			options: (data["options"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			publicInformations: (data["publicInformations"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
		);
	}

	static Map<String, dynamic> encode(MedicalLocation value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"deletionDate" : value.deletionDate,
			"name" : value.name,
			"description" : value.description,
			"responsible" : value.responsible,
			"guardPost" : value.guardPost,
			"cbe" : value.cbe,
			"bic" : value.bic,
			"bankAccount" : value.bankAccount,
			"nihii" : value.nihii,
			"ssin" : value.ssin,
			"address" : value.address == null ? null : DecryptedAddress.encode(value.address!),
			"agendaIds" : value.agendaIds.map((x0) => x0).toList(),
			"options" : value.options.map((k0, v0) => MapEntry(k0, v0)),
			"publicInformations" : value.publicInformations.map((k0, v0) => MapEntry(k0, v0))
		};
		return entityAsMap;
	}
}
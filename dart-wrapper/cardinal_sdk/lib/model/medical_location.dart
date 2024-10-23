// auto-generated file
import 'package:cardinal_sdk/model/embed/address.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/named.dart';


class MedicalLocation implements StoredDocument, Named {
	@override String id;
	@override String? rev;
	@override int? deletionDate;
	@override String? name;
	String? description;
	String? responsible;
	bool? guardPost;
	String? cbe;
	String? bic;
	String? bankAccount;
	String? nihii;
	String? ssin;
	DecryptedAddress? address;
	Set<String> agendaIds = {};
	Map<String, String> options = {};
	Map<String, String> publicInformations = {};
	MedicalLocation(
		this.id,
		{
			this.rev,
			this.deletionDate,
			this.name,
			this.description,
			this.responsible,
			this.guardPost,
			this.cbe,
			this.bic,
			this.bankAccount,
			this.nihii,
			this.ssin,
			this.address,
			Set<String>? agendaIds,
			Map<String, String>? options,
			Map<String, String>? publicInformations
		}) : agendaIds = agendaIds ?? {},
		options = options ?? {},
		publicInformations = publicInformations ?? {};

	factory MedicalLocation.fromJSON(Map<String, dynamic> data) {
		return MedicalLocation(
			data["id"],
			rev: data["rev"],
			deletionDate: data["deletionDate"],
			name: data["name"],
			description: data["description"],
			responsible: data["responsible"],
			guardPost: data["guardPost"],
			cbe: data["cbe"],
			bic: data["bic"],
			bankAccount: data["bankAccount"],
			nihii: data["nihii"],
			ssin: data["ssin"],
			address: data["address"] == null ? null : DecryptedAddress.fromJSON(data["address"]),
			agendaIds: data["agendaIds"].map((x0) => x0 ),
			options: data["options"].map((k0, v0) => MapEntry(k0, v0)),
			publicInformations: data["publicInformations"].map((k0, v0) => MapEntry(k0, v0)),
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
			"agendaIds" : value.agendaIds.map((x0) => x0),
			"options" : value.options.map((k0, v0) => MapEntry(k0, v0)),
			"publicInformations" : value.publicInformations.map((k0, v0) => MapEntry(k0, v0))
		};
		return entityAsMap;
	}
}
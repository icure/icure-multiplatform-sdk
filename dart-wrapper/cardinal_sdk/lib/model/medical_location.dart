// auto-generated file
import 'package:cardinal_sdk/model/embed/address.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/named.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "medical_location.freezed.dart";


@freezed
abstract class MedicalLocation with _$MedicalLocation implements StoredDocument, Named {
	const factory MedicalLocation({
		required String id,
		@Default(null) String? rev,
		@Default(null) int? deletionDate,
		@Default(null) String? name,
		@Default(null) String? description,
		@Default(null) String? responsible,
		@Default(null) bool? guardPost,
		@Default(null) String? cbe,
		@Default(null) String? bic,
		@Default(null) String? bankAccount,
		@Default(null) String? nihii,
		@Default(null) String? ssin,
		@Default(null) DecryptedAddress? address,
		@Default({}) Set<String> agendaIds,
		@Default({}) Map<String, String> options,
		@Default({}) Map<String, String> publicInformations,
	}) = _MedicalLocation;


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

	static MedicalLocation fromJSON(Map<String, dynamic> data) {
		return MedicalLocation(
			id: (data["id"] as String),
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
}
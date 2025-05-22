// auto-generated file
import 'package:cardinal_sdk/model/user.dart';
import 'package:cardinal_sdk/model/healthcare_party.dart';
import 'package:cardinal_sdk/model/replication.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "database_initialisation.freezed.dart";


@freezed
abstract class DatabaseInitialisation with _$DatabaseInitialisation {
	const factory DatabaseInitialisation({
		@Default([]) List<User>? users,
		@Default([]) List<HealthcareParty>? healthcareParties,
		@Default(null) Replication? replication,
		@Default(null) String? minimumKrakenVersion,
	}) = _DatabaseInitialisation;


	static Map<String, dynamic> encode(DatabaseInitialisation value) {
		Map<String, dynamic> entityAsMap = {
			"users" : value.users?.map((x0) => User.encode(x0)).toList(),
			"healthcareParties" : value.healthcareParties?.map((x0) => HealthcareParty.encode(x0)).toList(),
			"replication" : value.replication == null ? null : Replication.encode(value.replication!),
			"minimumKrakenVersion" : value.minimumKrakenVersion
		};
		return entityAsMap;
	}

	static DatabaseInitialisation fromJSON(Map<String, dynamic> data) {
		return DatabaseInitialisation(
			users: (data["users"] as List<dynamic>?)?.map((x0) => User.fromJSON(x0) ).toList(),
			healthcareParties: (data["healthcareParties"] as List<dynamic>?)?.map((x0) => HealthcareParty.fromJSON(x0) ).toList(),
			replication: data["replication"] == null ? null : Replication.fromJSON(data["replication"]),
			minimumKrakenVersion: (data["minimumKrakenVersion"] as String?)
		);
	}
}
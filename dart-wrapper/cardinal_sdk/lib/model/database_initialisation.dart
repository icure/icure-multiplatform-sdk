// auto-generated file
import 'package:cardinal_sdk/model/user.dart';
import 'package:cardinal_sdk/model/healthcare_party.dart';
import 'package:cardinal_sdk/model/replication.dart';


class DatabaseInitialisation {
	List<User>? users = [];
	List<HealthcareParty>? healthcareParties = [];
	Replication? replication = null;
	String? minimumKrakenVersion = null;
	DatabaseInitialisation({
			List<User>? users,
			List<HealthcareParty>? healthcareParties,
			Replication? replication,
			String? minimumKrakenVersion
		}) : users = users ?? [],
		healthcareParties = healthcareParties ?? [],
		replication = replication ?? null,
		minimumKrakenVersion = minimumKrakenVersion ?? null;

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
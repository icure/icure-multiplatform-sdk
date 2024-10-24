// auto-generated file
import 'package:cardinal_sdk/model/user.dart';
import 'package:cardinal_sdk/model/healthcare_party.dart';
import 'package:cardinal_sdk/model/replication.dart';


class DatabaseInitialisation {
	List<User>? users = [];
	List<HealthcareParty>? healthcareParties = [];
	Replication? replication;
	String? minimumKrakenVersion;
	DatabaseInitialisation({
			this.replication,
			this.minimumKrakenVersion,
			List<User>? users,
			List<HealthcareParty>? healthcareParties
		}) : users = users ?? [],
		healthcareParties = healthcareParties ?? [];

	factory DatabaseInitialisation.fromJSON(Map<String, dynamic> data) {
		return DatabaseInitialisation(
			users: data["users"]?.map((x0) => User.fromJSON(x0) ).toList(),
			healthcareParties: data["healthcareParties"]?.map((x0) => HealthcareParty.fromJSON(x0) ).toList(),
			replication: data["replication"] == null ? null : Replication.fromJSON(data["replication"]),
			minimumKrakenVersion: data["minimumKrakenVersion"]
		);
	}

	static Map<String, dynamic> encode(DatabaseInitialisation value) {
		Map<String, dynamic> entityAsMap = {
			"users" : value.users?.map((x0) => User.encode(x0)).toList(),
			"healthcareParties" : value.healthcareParties?.map((x0) => HealthcareParty.encode(x0)).toList(),
			"replication" : value.replication == null ? null : Replication.encode(value.replication!),
			"minimumKrakenVersion" : value.minimumKrakenVersion
		};
		return entityAsMap;
	}
}
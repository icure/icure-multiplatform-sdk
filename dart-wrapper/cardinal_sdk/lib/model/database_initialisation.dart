// This file is auto-generated
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

	static Map<String, dynamic> encode(DatabaseInitialisation value) {
		Map<String, dynamic> entityAsMap = {
			"users" : value.users?.map((x0) => User.encode(x0)),
			"healthcareParties" : value.healthcareParties?.map((x0) => HealthcareParty.encode(x0)),
			"replication" : value.replication == null ? null : Replication.encode(value.replication!),
			"minimumKrakenVersion" : value.minimumKrakenVersion
		};
		return entityAsMap;
	}
}
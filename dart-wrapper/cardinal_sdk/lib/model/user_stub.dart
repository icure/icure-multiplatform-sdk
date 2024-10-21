// This file is auto-generated
import 'package:cardinal_sdk/model/enums/users_type.dart';
import 'package:cardinal_sdk/model/enums/users_status.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';


class UserStub implements StoredDocument {
	@override  String id;
	@override  String? rev;
	@override  int? deletionDate;
	String? name;
	UsersType? type;
	UsersStatus? status;
	String? login;
	String? groupId;
	String? healthcarePartyId;
	String? patientId;
	String? email;

	UserStub({
		required this.id,
		this.rev,
		this.deletionDate,
		this.name,
		this.type,
		this.status,
		this.login,
		this.groupId,
		this.healthcarePartyId,
		this.patientId,
		this.email
	});

	static Map<String, dynamic> encode(UserStub value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"deletionDate" : value.deletionDate,
			"name" : value.name,
			"type" : value.type == null ? null : UsersType.encode(value.type!),
			"status" : value.status == null ? null : UsersStatus.encode(value.status!),
			"login" : value.login,
			"groupId" : value.groupId,
			"healthcarePartyId" : value.healthcarePartyId,
			"patientId" : value.patientId,
			"email" : value.email
		};
		return entityAsMap;
	}
}
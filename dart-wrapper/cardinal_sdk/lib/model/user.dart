// auto-generated file
import 'package:cardinal_sdk/model/base/identifier.dart';
import 'package:cardinal_sdk/model/property_stub.dart';
import 'package:cardinal_sdk/model/security/permission.dart';
import 'package:cardinal_sdk/model/enums/users_type.dart';
import 'package:cardinal_sdk/model/enums/users_status.dart';
import 'package:cardinal_sdk/model/embed/delegation_tag.dart';
import 'package:cardinal_sdk/model/security/authentication_token.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';


class User implements StoredDocument {
	@override String id;
	@override String? rev = null;
	@override int? deletionDate = null;
	int? created = null;
	List<Identifier> identifier = [];
	String? name = null;
	Set<DecryptedPropertyStub> properties = {};
	Set<Permission> permissions = {};
	Set<String> roles = {};
	UsersType? type = null;
	UsersStatus? status = null;
	String? login = null;
	String? passwordHash = null;
	String? groupId = null;
	String? healthcarePartyId = null;
	String? patientId = null;
	String? deviceId = null;
	Map<DelegationTag, Set<String>> autoDelegations = {};
	DateTime? createdDate = null;
	DateTime? termsOfUseDate = null;
	String? email = null;
	String? mobilePhone = null;
	Map<String, String> applicationTokens = {};
	Map<String, AuthenticationToken> authenticationTokens = {};
	UserSystemMetadata? systemMetadata = null;
	User(
		this.id,
		{
			String? rev,
			int? deletionDate,
			int? created,
			List<Identifier>? identifier,
			String? name,
			Set<DecryptedPropertyStub>? properties,
			Set<Permission>? permissions,
			Set<String>? roles,
			UsersType? type,
			UsersStatus? status,
			String? login,
			String? passwordHash,
			String? groupId,
			String? healthcarePartyId,
			String? patientId,
			String? deviceId,
			Map<DelegationTag, Set<String>>? autoDelegations,
			DateTime? createdDate,
			DateTime? termsOfUseDate,
			String? email,
			String? mobilePhone,
			Map<String, String>? applicationTokens,
			Map<String, AuthenticationToken>? authenticationTokens,
			UserSystemMetadata? systemMetadata
		}) : rev = rev ?? null,
		deletionDate = deletionDate ?? null,
		created = created ?? null,
		identifier = identifier ?? [],
		name = name ?? null,
		properties = properties ?? {},
		permissions = permissions ?? {},
		roles = roles ?? {},
		type = type ?? null,
		status = status ?? null,
		login = login ?? null,
		passwordHash = passwordHash ?? null,
		groupId = groupId ?? null,
		healthcarePartyId = healthcarePartyId ?? null,
		patientId = patientId ?? null,
		deviceId = deviceId ?? null,
		autoDelegations = autoDelegations ?? {},
		createdDate = createdDate ?? null,
		termsOfUseDate = termsOfUseDate ?? null,
		email = email ?? null,
		mobilePhone = mobilePhone ?? null,
		applicationTokens = applicationTokens ?? {},
		authenticationTokens = authenticationTokens ?? {},
		systemMetadata = systemMetadata ?? null;

	static Map<String, dynamic> encode(User value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"deletionDate" : value.deletionDate,
			"created" : value.created,
			"identifier" : value.identifier.map((x0) => Identifier.encode(x0)).toList(),
			"name" : value.name,
			"properties" : value.properties.map((x0) => DecryptedPropertyStub.encode(x0)).toList(),
			"permissions" : value.permissions.map((x0) => Permission.encode(x0)).toList(),
			"roles" : value.roles.map((x0) => x0).toList(),
			"type" : value.type == null ? null : UsersType.encode(value.type!),
			"status" : value.status == null ? null : UsersStatus.encode(value.status!),
			"login" : value.login,
			"passwordHash" : value.passwordHash,
			"groupId" : value.groupId,
			"healthcarePartyId" : value.healthcarePartyId,
			"patientId" : value.patientId,
			"deviceId" : value.deviceId,
			"autoDelegations" : value.autoDelegations.map((k0, v0) => MapEntry(DelegationTag.encode(k0), v0.map((x1) => x1).toList())),
			"createdDate" : value.createdDate?.millisecondsSinceEpoch,
			"termsOfUseDate" : value.termsOfUseDate?.millisecondsSinceEpoch,
			"email" : value.email,
			"mobilePhone" : value.mobilePhone,
			"applicationTokens" : value.applicationTokens.map((k0, v0) => MapEntry(k0, v0)),
			"authenticationTokens" : value.authenticationTokens.map((k0, v0) => MapEntry(k0, AuthenticationToken.encode(v0))),
			"systemMetadata" : value.systemMetadata == null ? null : UserSystemMetadata.encode(value.systemMetadata!)
		};
		return entityAsMap;
	}

	static User fromJSON(Map<String, dynamic> data) {
		return User(
			(data["id"] as String),
			rev: (data["rev"] as String?),
			deletionDate: (data["deletionDate"] as int?),
			created: (data["created"] as int?),
			identifier: (data["identifier"] as List<dynamic>).map((x0) => Identifier.fromJSON(x0) ).toList(),
			name: (data["name"] as String?),
			properties: (data["properties"] as List<dynamic>).map((x0) => DecryptedPropertyStub.fromJSON(x0) ).toSet(),
			permissions: (data["permissions"] as List<dynamic>).map((x0) => Permission.fromJSON(x0) ).toSet(),
			roles: (data["roles"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			type: data["type"] == null ? null : UsersType.fromJSON(data["type"]),
			status: data["status"] == null ? null : UsersStatus.fromJSON(data["status"]),
			login: (data["login"] as String?),
			passwordHash: (data["passwordHash"] as String?),
			groupId: (data["groupId"] as String?),
			healthcarePartyId: (data["healthcarePartyId"] as String?),
			patientId: (data["patientId"] as String?),
			deviceId: (data["deviceId"] as String?),
			autoDelegations: (data["autoDelegations"] as Map<String, dynamic>).map((k0, v0) => MapEntry(DelegationTag.fromJSON(k0), (v0 as List<dynamic>).map((x1) => (x1 as String) ).toSet())),
			createdDate: data["createdDate"] == null ? null : DateTime.fromMillisecondsSinceEpoch(data["createdDate"] as int),
			termsOfUseDate: data["termsOfUseDate"] == null ? null : DateTime.fromMillisecondsSinceEpoch(data["termsOfUseDate"] as int),
			email: (data["email"] as String?),
			mobilePhone: (data["mobilePhone"] as String?),
			applicationTokens: (data["applicationTokens"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			authenticationTokens: (data["authenticationTokens"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), AuthenticationToken.fromJSON(v0))),
			systemMetadata: data["systemMetadata"] == null ? null : UserSystemMetadata.fromJSON(data["systemMetadata"]),
		);
	}
}

class UserSystemMetadata {
	Set<String> roles;
	bool isAdmin;
	bool inheritsRoles;
	UserSystemMetadata(
		this.roles,
		this.isAdmin,
		this.inheritsRoles
		);

	static Map<String, dynamic> encode(UserSystemMetadata value) {
		Map<String, dynamic> entityAsMap = {
			"roles" : value.roles.map((x0) => x0).toList(),
			"isAdmin" : value.isAdmin,
			"inheritsRoles" : value.inheritsRoles
		};
		return entityAsMap;
	}

	static UserSystemMetadata fromJSON(Map<String, dynamic> data) {
		return UserSystemMetadata(
			(data["roles"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			(data["isAdmin"] as bool),
			(data["inheritsRoles"] as bool)
		);
	}
}
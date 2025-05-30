// auto-generated file
import 'package:cardinal_sdk/model/base/identifier.dart';
import 'package:cardinal_sdk/model/property_stub.dart';
import 'package:cardinal_sdk/model/security/permission.dart';
import 'package:cardinal_sdk/model/enums/users_type.dart';
import 'package:cardinal_sdk/model/enums/users_status.dart';
import 'package:cardinal_sdk/model/embed/delegation_tag.dart';
import 'package:cardinal_sdk/model/security/authentication_token.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
import 'package:cardinal_sdk/model/security/login_identifier.dart';
part "user.freezed.dart";


@freezed
abstract class User with _$User implements StoredDocument {
	const factory User({
		required String id,
		@Default(null) String? rev,
		@Default(null) int? deletionDate,
		@Default(null) int? created,
		@Default([]) List<Identifier> identifier,
		@Default(null) String? name,
		@Default({}) Set<DecryptedPropertyStub> properties,
		@Default({}) Set<Permission> permissions,
		@Default({}) Set<String> roles,
		@Default(null) UsersType? type,
		@Default(null) UsersStatus? status,
		@Default(null) String? login,
		@Default(null) String? passwordHash,
		@Default(null) String? groupId,
		@Default(null) String? healthcarePartyId,
		@Default(null) String? patientId,
		@Default(null) String? deviceId,
		@Default({}) Map<DelegationTag, Set<String>> autoDelegations,
		@Default(null) DateTime? createdDate,
		@Default(null) DateTime? termsOfUseDate,
		@Default(null) String? email,
		@Default(null) String? mobilePhone,
		@Default({}) Map<String, String> applicationTokens,
		@Default({}) Map<String, AuthenticationToken> authenticationTokens,
		@Default(null) UserSystemMetadata? systemMetadata,
	}) = _User;


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
			id: (data["id"] as String),
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

@freezed
abstract class UserSystemMetadata with _$UserSystemMetadata {
	const factory UserSystemMetadata({
		required Set<String> roles,
		required bool isAdmin,
		required bool inheritsRoles,
		@Default([]) List<LoginIdentifier> loginIdentifiers,
	}) = _UserSystemMetadata;


	static Map<String, dynamic> encode(UserSystemMetadata value) {
		Map<String, dynamic> entityAsMap = {
			"roles" : value.roles.map((x0) => x0).toList(),
			"isAdmin" : value.isAdmin,
			"inheritsRoles" : value.inheritsRoles,
			"loginIdentifiers" : value.loginIdentifiers.map((x0) => LoginIdentifier.encode(x0)).toList()
		};
		return entityAsMap;
	}

	static UserSystemMetadata fromJSON(Map<String, dynamic> data) {
		return UserSystemMetadata(
			roles: (data["roles"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			isAdmin: (data["isAdmin"] as bool),
			inheritsRoles: (data["inheritsRoles"] as bool),
			loginIdentifiers: (data["loginIdentifiers"] as List<dynamic>).map((x0) => LoginIdentifier.fromJSON(x0) ).toList(),
		);
	}
}
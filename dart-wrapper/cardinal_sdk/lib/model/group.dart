// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/property_stub.dart';
import 'package:cardinal_sdk/model/embed/user_type.dart';
import 'package:cardinal_sdk/model/security/operation_token.dart';
import 'package:cardinal_sdk/model/embed/authentication_class.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/has_tags.dart';


class Group implements StoredDocument, HasTags {
	@override String id;
	@override String? rev = null;
	@override int? deletionDate = null;
	@override Set<CodeStub> tags = {};
	String? name = null;
	String? password = null;
	List<String>? servers = null;
	bool superAdmin = false;
	Set<DecryptedPropertyStub> properties = {};
	Map<UserType, Set<String>> defaultUserRoles = {};
	Map<String, OperationToken> operationTokens = {};
	Map<String, String> sharedEntities = {};
	String? minimumKrakenVersion = null;
	AuthenticationClass minimumAuthenticationClassForElevatedPrivileges;
	String? superGroup = null;
	String? applicationId = null;
	Group(
		this.id,
		this.minimumAuthenticationClassForElevatedPrivileges,
		{
			String? rev,
			int? deletionDate,
			Set<CodeStub>? tags,
			String? name,
			String? password,
			List<String>? servers,
			bool? superAdmin,
			Set<DecryptedPropertyStub>? properties,
			Map<UserType, Set<String>>? defaultUserRoles,
			Map<String, OperationToken>? operationTokens,
			Map<String, String>? sharedEntities,
			String? minimumKrakenVersion,
			String? superGroup,
			String? applicationId
		}) : rev = rev ?? null,
		deletionDate = deletionDate ?? null,
		tags = tags ?? {},
		name = name ?? null,
		password = password ?? null,
		servers = servers ?? null,
		superAdmin = superAdmin ?? false,
		properties = properties ?? {},
		defaultUserRoles = defaultUserRoles ?? {},
		operationTokens = operationTokens ?? {},
		sharedEntities = sharedEntities ?? {},
		minimumKrakenVersion = minimumKrakenVersion ?? null,
		superGroup = superGroup ?? null,
		applicationId = applicationId ?? null;

	static Map<String, dynamic> encode(Group value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"deletionDate" : value.deletionDate,
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)).toList(),
			"name" : value.name,
			"password" : value.password,
			"servers" : value.servers?.map((x0) => x0).toList(),
			"superAdmin" : value.superAdmin,
			"properties" : value.properties.map((x0) => DecryptedPropertyStub.encode(x0)).toList(),
			"defaultUserRoles" : value.defaultUserRoles.map((k0, v0) => MapEntry(UserType.encode(k0), v0.map((x1) => x1).toList())),
			"operationTokens" : value.operationTokens.map((k0, v0) => MapEntry(k0, OperationToken.encode(v0))),
			"sharedEntities" : value.sharedEntities.map((k0, v0) => MapEntry(k0, v0)),
			"minimumKrakenVersion" : value.minimumKrakenVersion,
			"minimumAuthenticationClassForElevatedPrivileges" : AuthenticationClass.encode(value.minimumAuthenticationClassForElevatedPrivileges),
			"superGroup" : value.superGroup,
			"applicationId" : value.applicationId
		};
		return entityAsMap;
	}

	static Group fromJSON(Map<String, dynamic> data) {
		return Group(
			(data["id"] as String),
			AuthenticationClass.fromJSON(data["minimumAuthenticationClassForElevatedPrivileges"]),
			rev: (data["rev"] as String?),
			deletionDate: (data["deletionDate"] as int?),
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			name: (data["name"] as String?),
			password: (data["password"] as String?),
			servers: (data["servers"] as List<dynamic>?)?.map((x0) => (x0 as String) ).toList(),
			superAdmin: (data["superAdmin"] as bool),
			properties: (data["properties"] as List<dynamic>).map((x0) => DecryptedPropertyStub.fromJSON(x0) ).toSet(),
			defaultUserRoles: (data["defaultUserRoles"] as Map<String, dynamic>).map((k0, v0) => MapEntry(UserType.fromJSON(k0), (v0 as List<dynamic>).map((x1) => (x1 as String) ).toSet())),
			operationTokens: (data["operationTokens"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), OperationToken.fromJSON(v0))),
			sharedEntities: (data["sharedEntities"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			minimumKrakenVersion: (data["minimumKrakenVersion"] as String?),
			superGroup: (data["superGroup"] as String?),
			applicationId: (data["applicationId"] as String?),
		);
	}
}
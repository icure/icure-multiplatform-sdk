// This file is auto-generated
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/property_stub.dart';
import 'package:cardinal_sdk/model/embed/user_type.dart';
import 'package:cardinal_sdk/model/security/operation_token.dart';
import 'package:cardinal_sdk/model/embed/authentication_class.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/has_tags.dart';


class Group implements StoredDocument, HasTags {
	@override  String id;
	@override  String? rev;
	@override  int? deletionDate;
	@override  Set<CodeStub> tags = {};
	String? name;
	String? password;
	List<String>? servers;
	bool superAdmin = false;
	Set<DecryptedPropertyStub> properties = {};
	Map<UserType, Set<String>> defaultUserRoles = {};
	Map<String, OperationToken> operationTokens = {};
	Map<String, String> sharedEntities = {};
	String? minimumKrakenVersion;
	AuthenticationClass minimumAuthenticationClassForElevatedPrivileges;
	String? superGroup;
	String? applicationId;

	Group({
		required this.id,
		required this.minimumAuthenticationClassForElevatedPrivileges,
		this.rev,
		this.deletionDate,
		this.name,
		this.password,
		this.servers,
		this.minimumKrakenVersion,
		this.superGroup,
		this.applicationId,
		Set<CodeStub>? tags,
		bool? superAdmin,
		Set<DecryptedPropertyStub>? properties,
		Map<UserType, Set<String>>? defaultUserRoles,
		Map<String, OperationToken>? operationTokens,
		Map<String, String>? sharedEntities
	}) : tags = tags ?? {},
		superAdmin = superAdmin ?? false,
		properties = properties ?? {},
		defaultUserRoles = defaultUserRoles ?? {},
		operationTokens = operationTokens ?? {},
		sharedEntities = sharedEntities ?? {};

	static Map<String, dynamic> encode(Group value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"deletionDate" : value.deletionDate,
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)),
			"name" : value.name,
			"password" : value.password,
			"servers" : value.servers?.map((x0) => x0),
			"superAdmin" : value.superAdmin,
			"properties" : value.properties.map((x0) => DecryptedPropertyStub.encode(x0)),
			"defaultUserRoles" : value.defaultUserRoles.map((k0, v0) => MapEntry(UserType.encode(k0), v0.map((x1) => x1))),
			"operationTokens" : value.operationTokens.map((k0, v0) => MapEntry(k0, OperationToken.encode(v0))),
			"sharedEntities" : value.sharedEntities.map((k0, v0) => MapEntry(k0, v0)),
			"minimumKrakenVersion" : value.minimumKrakenVersion,
			"minimumAuthenticationClassForElevatedPrivileges" : AuthenticationClass.encode(value.minimumAuthenticationClassForElevatedPrivileges),
			"superGroup" : value.superGroup,
			"applicationId" : value.applicationId
		};
		return entityAsMap;
	}
}
// auto-generated file
import 'package:cardinal_sdk/model/group.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "user_group.freezed.dart";


@freezed
abstract class UserGroup with _$UserGroup {
	const factory UserGroup({
		@Default(null) String? groupId,
		@Default(null) String? groupName,
		@Default([]) List<Group> groupsHierarchy,
		@Default(null) String? userId,
		@Default(null) String? login,
		@Default(null) String? name,
		@Default(null) String? email,
		@Default(null) String? phone,
		@Default(null) String? patientId,
		@Default(null) String? healthcarePartyId,
		@Default(null) String? deviceId,
		@Default(null) String? nameOfParentOfTopmostGroupInHierarchy,
	}) = _UserGroup;


	static Map<String, dynamic> encode(UserGroup value) {
		Map<String, dynamic> entityAsMap = {
			"groupId" : value.groupId,
			"groupName" : value.groupName,
			"groupsHierarchy" : value.groupsHierarchy.map((x0) => Group.encode(x0)).toList(),
			"userId" : value.userId,
			"login" : value.login,
			"name" : value.name,
			"email" : value.email,
			"phone" : value.phone,
			"patientId" : value.patientId,
			"healthcarePartyId" : value.healthcarePartyId,
			"deviceId" : value.deviceId,
			"nameOfParentOfTopmostGroupInHierarchy" : value.nameOfParentOfTopmostGroupInHierarchy
		};
		return entityAsMap;
	}

	static UserGroup fromJSON(Map<String, dynamic> data) {
		return UserGroup(
			groupId: (data["groupId"] as String?),
			groupName: (data["groupName"] as String?),
			groupsHierarchy: (data["groupsHierarchy"] as List<dynamic>).map((x0) => Group.fromJSON(x0) ).toList(),
			userId: (data["userId"] as String?),
			login: (data["login"] as String?),
			name: (data["name"] as String?),
			email: (data["email"] as String?),
			phone: (data["phone"] as String?),
			patientId: (data["patientId"] as String?),
			healthcarePartyId: (data["healthcarePartyId"] as String?),
			deviceId: (data["deviceId"] as String?),
			nameOfParentOfTopmostGroupInHierarchy: (data["nameOfParentOfTopmostGroupInHierarchy"] as String?)
		);
	}
}
// auto-generated file
import 'package:cardinal_sdk/model/group.dart';


class UserGroup {
	String? groupId = null;
	String? groupName = null;
	List<Group> groupsHierarchy = [];
	String? userId = null;
	String? login = null;
	String? name = null;
	String? email = null;
	String? phone = null;
	String? patientId = null;
	String? healthcarePartyId = null;
	String? deviceId = null;
	String? nameOfParentOfTopmostGroupInHierarchy = null;
	UserGroup({
			String? groupId,
			String? groupName,
			List<Group>? groupsHierarchy,
			String? userId,
			String? login,
			String? name,
			String? email,
			String? phone,
			String? patientId,
			String? healthcarePartyId,
			String? deviceId,
			String? nameOfParentOfTopmostGroupInHierarchy
		}) : groupId = groupId ?? null,
		groupName = groupName ?? null,
		groupsHierarchy = groupsHierarchy ?? [],
		userId = userId ?? null,
		login = login ?? null,
		name = name ?? null,
		email = email ?? null,
		phone = phone ?? null,
		patientId = patientId ?? null,
		healthcarePartyId = healthcarePartyId ?? null,
		deviceId = deviceId ?? null,
		nameOfParentOfTopmostGroupInHierarchy = nameOfParentOfTopmostGroupInHierarchy ?? null;

	factory UserGroup.fromJSON(Map<String, dynamic> data) {
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
}
// This file is auto-generated
import 'package:cardinal_sdk/model/group.dart';


class UserGroup {
	String? groupId;
	String? groupName;
	List<Group> groupsHierarchy = [];
	String? userId;
	String? login;
	String? name;
	String? email;
	String? phone;
	String? patientId;
	String? healthcarePartyId;
	String? deviceId;
	String? nameOfParentOfTopmostGroupInHierarchy;

	UserGroup({
		this.groupId,
		this.groupName,
		this.userId,
		this.login,
		this.name,
		this.email,
		this.phone,
		this.patientId,
		this.healthcarePartyId,
		this.deviceId,
		this.nameOfParentOfTopmostGroupInHierarchy,
		List<Group>? groupsHierarchy
	}) : groupsHierarchy = groupsHierarchy ?? [];

	static Map<String, dynamic> encode(UserGroup value) {
		Map<String, dynamic> entityAsMap = {
			"groupId" : value.groupId,
			"groupName" : value.groupName,
			"groupsHierarchy" : value.groupsHierarchy.map((x0) => Group.encode(x0)),
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
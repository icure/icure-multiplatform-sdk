// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/user.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/property_stub.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/user_group.dart';
import 'package:cardinal_sdk/model/list_of_ids.dart';
import 'package:cardinal_sdk/model/security/token_with_group.dart';
import 'package:cardinal_sdk/model/security/enable2fa_request.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';


class UserPlatformApi {
	MethodChannel _methodChannel;
	UserPlatformApi(this._methodChannel);

	Future<User> getCurrentUser(String sdkId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.getCurrentUser',
			{
				"sdkId": sdkId,
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getCurrentUser");
		final parsedResJson = jsonDecode(res);
		return User.fromJSON(parsedResJson);
	}

	Future<User> createUser(String sdkId, User user) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.createUser',
			{
				"sdkId": sdkId,
				"user": jsonEncode(User.encode(user)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method createUser");
		final parsedResJson = jsonDecode(res);
		return User.fromJSON(parsedResJson);
	}

	Future<User> getUser(String sdkId, String userId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.getUser',
			{
				"sdkId": sdkId,
				"userId": jsonEncode(userId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getUser");
		final parsedResJson = jsonDecode(res);
		return User.fromJSON(parsedResJson);
	}

	Future<List<User>> getUsers(String sdkId, List<String> userIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.getUsers',
			{
				"sdkId": sdkId,
				"userIds": jsonEncode(userIds.map((x0) => x0).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getUsers");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => User.fromJSON(x1) ).toList();
	}

	Future<User> getUserByEmail(String sdkId, String email) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.getUserByEmail',
			{
				"sdkId": sdkId,
				"email": jsonEncode(email),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getUserByEmail");
		final parsedResJson = jsonDecode(res);
		return User.fromJSON(parsedResJson);
	}

	Future<User> getUserByPhoneNumber(String sdkId, String phoneNumber) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.getUserByPhoneNumber',
			{
				"sdkId": sdkId,
				"phoneNumber": jsonEncode(phoneNumber),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getUserByPhoneNumber");
		final parsedResJson = jsonDecode(res);
		return User.fromJSON(parsedResJson);
	}

	Future<List<String>> findByHcpartyId(String sdkId, String id) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.findByHcpartyId',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method findByHcpartyId");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<List<String>> findByPatientId(String sdkId, String id) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.findByPatientId',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method findByPatientId");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<User> modifyUser(String sdkId, User user) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.modifyUser',
			{
				"sdkId": sdkId,
				"user": jsonEncode(User.encode(user)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyUser");
		final parsedResJson = jsonDecode(res);
		return User.fromJSON(parsedResJson);
	}

	Future<User> assignHealthcareParty(String sdkId, String healthcarePartyId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.assignHealthcareParty',
			{
				"sdkId": sdkId,
				"healthcarePartyId": jsonEncode(healthcarePartyId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method assignHealthcareParty");
		final parsedResJson = jsonDecode(res);
		return User.fromJSON(parsedResJson);
	}

	Future<User> modifyProperties(String sdkId, String userId, List<EncryptedPropertyStub>? properties) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.modifyProperties',
			{
				"sdkId": sdkId,
				"userId": jsonEncode(userId),
				"properties": jsonEncode(properties?.map((x0) => EncryptedPropertyStub.encode(x0)).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyProperties");
		final parsedResJson = jsonDecode(res);
		return User.fromJSON(parsedResJson);
	}

	Future<String> getToken(String sdkId, String userId, String key, int? tokenValidity, String? token) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.getToken',
			{
				"sdkId": sdkId,
				"userId": jsonEncode(userId),
				"key": jsonEncode(key),
				"tokenValidity": jsonEncode(tokenValidity),
				"token": jsonEncode(token),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getToken");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as String);
	}

	Future<PaginatedListIterator<User>> filterUsersBy(String sdkId, BaseFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.filterUsersBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseFilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterUsersBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => User.fromJSON(x0));
	}

	Future<List<String>> matchUsersBy(String sdkId, BaseFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.matchUsersBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseFilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method matchUsersBy");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<PaginatedListIterator<User>> filterUsersBySorted(String sdkId, BaseSortableFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.filterUsersBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseSortableFilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterUsersBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => User.fromJSON(x0));
	}

	Future<List<String>> matchUsersBySorted(String sdkId, BaseSortableFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.matchUsersBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseSortableFilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method matchUsersBySorted");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<List<UserGroup>> getMatchingUsers(String sdkId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.getMatchingUsers',
			{
				"sdkId": sdkId,
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getMatchingUsers");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => UserGroup.fromJSON(x1) ).toList();
	}

	Future<List<User>> getUsersInGroup(String sdkId, String groupId, List<String> userIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.getUsersInGroup',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"userIds": jsonEncode(userIds.map((x0) => x0).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getUsersInGroup");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => User.fromJSON(x1) ).toList();
	}

	Future<User> createUserInGroup(String sdkId, String groupId, User user) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.createUserInGroup',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"user": jsonEncode(User.encode(user)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method createUserInGroup");
		final parsedResJson = jsonDecode(res);
		return User.fromJSON(parsedResJson);
	}

	Future<User> modifyUserInGroup(String sdkId, String groupId, User user) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.modifyUserInGroup',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"user": jsonEncode(User.encode(user)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyUserInGroup");
		final parsedResJson = jsonDecode(res);
		return User.fromJSON(parsedResJson);
	}

	Future<User> setUserRoles(String sdkId, String userId, ListOfIds rolesId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.setUserRoles',
			{
				"sdkId": sdkId,
				"userId": jsonEncode(userId),
				"rolesId": jsonEncode(ListOfIds.encode(rolesId)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method setUserRoles");
		final parsedResJson = jsonDecode(res);
		return User.fromJSON(parsedResJson);
	}

	Future<User> setUserRolesInGroup(String sdkId, String userId, String groupId, ListOfIds rolesId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.setUserRolesInGroup',
			{
				"sdkId": sdkId,
				"userId": jsonEncode(userId),
				"groupId": jsonEncode(groupId),
				"rolesId": jsonEncode(ListOfIds.encode(rolesId)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method setUserRolesInGroup");
		final parsedResJson = jsonDecode(res);
		return User.fromJSON(parsedResJson);
	}

	Future<User> resetUserRoles(String sdkId, String userId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.resetUserRoles',
			{
				"sdkId": sdkId,
				"userId": jsonEncode(userId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method resetUserRoles");
		final parsedResJson = jsonDecode(res);
		return User.fromJSON(parsedResJson);
	}

	Future<User> resetUserRolesInGroup(String sdkId, String userId, String groupId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.resetUserRolesInGroup',
			{
				"sdkId": sdkId,
				"userId": jsonEncode(userId),
				"groupId": jsonEncode(groupId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method resetUserRolesInGroup");
		final parsedResJson = jsonDecode(res);
		return User.fromJSON(parsedResJson);
	}

	Future<String> getTokenInGroup(String sdkId, String groupId, String userId, String key, String? token, int? tokenValidity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.getTokenInGroup',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"userId": jsonEncode(userId),
				"key": jsonEncode(key),
				"token": jsonEncode(token),
				"tokenValidity": jsonEncode(tokenValidity),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getTokenInGroup");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as String);
	}

	Future<List<TokenWithGroup>> getTokenInAllGroups(String sdkId, String userIdentifier, String key, String? token, int? tokenValidity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.getTokenInAllGroups',
			{
				"sdkId": sdkId,
				"userIdentifier": jsonEncode(userIdentifier),
				"key": jsonEncode(key),
				"token": jsonEncode(token),
				"tokenValidity": jsonEncode(tokenValidity),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getTokenInAllGroups");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => TokenWithGroup.fromJSON(x1) ).toList();
	}

	Future<PaginatedListIterator<User>> filterUsersInGroupBy(String sdkId, String groupId, BaseFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.filterUsersInGroupBy',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"filter": jsonEncode(BaseFilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterUsersInGroupBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => User.fromJSON(x0));
	}

	Future<List<String>> matchUsersInGroupBy(String sdkId, String groupId, BaseFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.matchUsersInGroupBy',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"filter": jsonEncode(BaseFilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method matchUsersInGroupBy");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<PaginatedListIterator<User>> filterUsersInGroupBySorted(String sdkId, String groupId, BaseSortableFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.filterUsersInGroupBySorted',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"filter": jsonEncode(BaseSortableFilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterUsersInGroupBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => User.fromJSON(x0));
	}

	Future<List<String>> matchUsersInGroupBySorted(String sdkId, String groupId, BaseSortableFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.matchUsersInGroupBySorted',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"filter": jsonEncode(BaseSortableFilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method matchUsersInGroupBySorted");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<void> enable2faForUserWithGroup(String sdkId, String userId, String groupId, Enable2faRequest request) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.enable2faForUserWithGroup',
			{
				"sdkId": sdkId,
				"userId": jsonEncode(userId),
				"groupId": jsonEncode(groupId),
				"request": jsonEncode(Enable2faRequest.encode(request)),
			}
		);
	}

	Future<void> enable2faForUser(String sdkId, String userId, Enable2faRequest request) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.enable2faForUser',
			{
				"sdkId": sdkId,
				"userId": jsonEncode(userId),
				"request": jsonEncode(Enable2faRequest.encode(request)),
			}
		);
	}

	Future<void> disable2faForUserWithGroup(String sdkId, String userId, String groupId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.disable2faForUserWithGroup',
			{
				"sdkId": sdkId,
				"userId": jsonEncode(userId),
				"groupId": jsonEncode(groupId),
			}
		);
	}

	Future<void> disable2faForUser(String sdkId, String userId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.disable2faForUser',
			{
				"sdkId": sdkId,
				"userId": jsonEncode(userId),
			}
		);
	}

	Future<User> createAdminUser(String sdkId, User user) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.createAdminUser',
			{
				"sdkId": sdkId,
				"user": jsonEncode(User.encode(user)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method createAdminUser");
		final parsedResJson = jsonDecode(res);
		return User.fromJSON(parsedResJson);
	}

	Future<User> createAdminUserInGroup(String sdkId, String groupId, User user) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.createAdminUserInGroup',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"user": jsonEncode(User.encode(user)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method createAdminUserInGroup");
		final parsedResJson = jsonDecode(res);
		return User.fromJSON(parsedResJson);
	}

	Future<DocIdentifier> deleteUserById(String sdkId, String entityId, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.deleteUserById',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
				"rev": jsonEncode(rev),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteUserById");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<DocIdentifier> deleteUserInGroupById(String sdkId, String groupId, String entityId, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.deleteUserInGroupById',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"entityId": jsonEncode(entityId),
				"rev": jsonEncode(rev),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteUserInGroupById");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<void> purgeUserById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.purgeUserById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		);
	}

	Future<User> undeleteUserById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.undeleteUserById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteUserById");
		final parsedResJson = jsonDecode(res);
		return User.fromJSON(parsedResJson);
	}

	Future<DocIdentifier> deleteUser(String sdkId, User user) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.deleteUser',
			{
				"sdkId": sdkId,
				"user": jsonEncode(User.encode(user)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteUser");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<DocIdentifier> deleteUserInGroup(String sdkId, String groupId, User user) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.deleteUserInGroup',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"user": jsonEncode(User.encode(user)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteUserInGroup");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<void> purgeUser(String sdkId, User user) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.purgeUser',
			{
				"sdkId": sdkId,
				"user": jsonEncode(User.encode(user)),
			}
		);
	}

	Future<User> undeleteUser(String sdkId, User user) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.undeleteUser',
			{
				"sdkId": sdkId,
				"user": jsonEncode(User.encode(user)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteUser");
		final parsedResJson = jsonDecode(res);
		return User.fromJSON(parsedResJson);
	}

	Future<EntitySubscription<User>> subscribeToEvents(String sdkId, Set<SubscriptionEventType> events, FilterOptions filter, EntitySubscriptionConfiguration? subscriptionConfig) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserApi.subscribeToEvents',
			{
				"sdkId": sdkId,
				"events": jsonEncode(events.map((x0) => SubscriptionEventType.encode(x0)).toList()),
				"filter": jsonEncode(FilterOptions.encode(filter)),
				"subscriptionConfig": jsonEncode(subscriptionConfig == null ? null : EntitySubscriptionConfiguration.encode(subscriptionConfig!)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method subscribeToEvents");
		final parsedResJson = jsonDecode(res);
		return EntitySubscription(parsedResJson, (x0) => User.fromJSON(x0));
	}
}
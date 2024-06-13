// auto-generated file
import {ListOfIds} from '../model/ListOfIds.mjs';
import {PaginatedList} from '../model/PaginatedList.mjs';
import {EncryptedPropertyStub} from '../model/PropertyStub.mjs';
import {User} from '../model/User.mjs';
import {UserGroup} from '../model/UserGroup.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';
import {AbstractFilter} from '../model/filter/AbstractFilter.mjs';
import {FilterChain} from '../model/filter/chain/FilterChain.mjs';
import {Enable2faRequest} from '../model/security/Enable2faRequest.mjs';
import {TokenWithGroup} from '../model/security/TokenWithGroup.mjs';


export interface UserApi {

	getCurrentUser(): Promise<User>;

	listUsersBy(options?: { startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined, skipPatients?: boolean | undefined }): Promise<PaginatedList<User>>;

	createUser(user: User): Promise<User>;

	getUser(userId: string): Promise<User>;

	getUserByEmail(email: string): Promise<User>;

	getUserByPhoneNumber(phoneNumber: string): Promise<User>;

	findByHcpartyId(id: string): Promise<Array<string>>;

	findByPatientId(id: string): Promise<Array<string>>;

	deleteUser(userId: string): Promise<DocIdentifier>;

	modifyUser(user: User): Promise<User>;

	assignHealthcareParty(healthcarePartyId: string): Promise<User>;

	modifyProperties(userId: string,
			properties: Array<EncryptedPropertyStub> | undefined): Promise<User>;

	getToken(userId: string, key: string,
			options?: { tokenValidity?: number | undefined, token?: string | undefined }): Promise<string>;

	filterUsersBy(filterChain: FilterChain<User>,
			options?: { startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<User>>;

	matchUsersBy(filter: AbstractFilter<User>): Promise<Array<string>>;

	getMatchingUsers(): Promise<Array<UserGroup>>;

	listUsersInGroup(groupId: string,
			options?: { startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<User>>;

	createUserInGroup(groupId: string, user: User): Promise<User>;

	modifyUserInGroup(groupId: string, user: User): Promise<User>;

	deleteUserInGroup(groupId: string, userId: string): Promise<DocIdentifier>;

	addRolesToUser(userId: string, rolesId: ListOfIds): Promise<User>;

	addRolesToUserInGroup(userId: string, groupId: string, rolesId: ListOfIds): Promise<User>;

	removeRolesFromUser(userId: string): Promise<User>;

	removeRolesFromUserInGroup(userId: string, groupId: string): Promise<User>;

	getTokenInGroup(groupId: string, userId: string, key: string,
			options?: { token?: string | undefined, tokenValidity?: number | undefined }): Promise<string>;

	getTokenInAllGroups(userIdentifier: string, key: string,
			options?: { token?: string | undefined, tokenValidity?: number | undefined }): Promise<Array<TokenWithGroup>>;

	filterUsersInGroupBy(groupId: string, filterChain: FilterChain<User>,
			options?: { startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<User>>;

	enable2faForUser(userId: string, groupId: string, request: Enable2faRequest): Promise<void>;

	enable2faForUser(userId: string, request: Enable2faRequest): Promise<void>;

	disable2faForUser(userId: string, groupId: string): Promise<void>;

	disable2faForUser(userId: string): Promise<void>;

	createAdminUser(user: User): Promise<User>;

	createAdminUserInGroup(groupId: string, user: User): Promise<User>;

}

// auto-generated file
import {DatabaseInitialisation} from '../model/DatabaseInitialisation.mjs';
import {Group} from '../model/Group.mjs';
import {GroupDeletionReport} from '../model/GroupDeletionReport.mjs';
import {IdWithRev} from '../model/IdWithRev.mjs';
import {ListOfProperties} from '../model/ListOfProperties.mjs';
import {PaginatedList} from '../model/PaginatedList.mjs';
import {RegistrationInformation} from '../model/RegistrationInformation.mjs';
import {RegistrationSuccess} from '../model/RegistrationSuccess.mjs';
import {ReplicationInfo} from '../model/ReplicationInfo.mjs';
import {DesignDocument} from '../model/couchdb/DesignDocument.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';
import {GroupDatabasesInfo} from '../model/couchdb/GroupDatabasesInfo.mjs';
import {GroupType} from '../model/embed/GroupType.mjs';
import {RoleConfiguration} from '../model/embed/RoleConfiguration.mjs';
import {UserType} from '../model/embed/UserType.mjs';
import {Operation} from '../model/security/Operation.mjs';
import {PermissionType} from '../model/security/PermissionType.mjs';


export interface GroupApi {

	listGroups(): Promise<Array<Group>>;

	getGroup(id: string): Promise<Group>;

	createGroup(
			id: string,
			name: string,
			password: string,
			initialisationData: DatabaseInitialisation,
			options?: { id?: string, name?: string, type?: GroupType | undefined, password?: string, server?: string | undefined, q?: number | undefined, n?: number | undefined, superGroup?: string | undefined, initialisationData?: DatabaseInitialisation }
	): Promise<Group>;

	registerNewGroupAdministrator(registrationInformation: RegistrationInformation,
			options?: { type?: GroupType | undefined, role?: PermissionType | undefined, registrationInformation?: RegistrationInformation }): Promise<RegistrationSuccess>;

	listApps(): Promise<Array<Group>>;

	findGroups(id: string,
			options?: { id?: string, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<Group>>;

	findGroupsWithContent(id: string, searchString: string,
			options?: { id?: string, searchString?: string, startKey?: any | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<Group>>;

	getNameOfGroupParent(id: string): Promise<string>;

	modifyGroupName(id: string, name: string): Promise<Group>;

	getOperationToken(operation: Operation, duration: number | undefined,
			options?: { operation?: Operation, duration?: number | undefined, description?: string | undefined }): Promise<string>;

	deleteOperationToken(tokenId: string): Promise<void>;

	setDefaultRoles(groupId: string, userType: string, roleIds: Array<string>): Promise<Group>;

	getDefaultRoles(groupId: string): Promise<{ [ key in UserType ]?: Array<RoleConfiguration> }>;

	deleteGroup(id: string): Promise<Group>;

	changeSuperGroup(childGroupId: string, operationToken: string): Promise<Group>;

	hardDeleteGroup(id: string): Promise<Array<GroupDeletionReport>>;

	modifyGroupProperties(id: string, properties: ListOfProperties): Promise<Group>;

	setGroupPassword(id: string, password: string): Promise<Group>;

	initDesignDocs(id: string, warmup: boolean | undefined, dryRun: boolean | undefined,
			options?: { id?: string, clazz?: string | undefined, warmup?: boolean | undefined, dryRun?: boolean | undefined }): Promise<Array<DesignDocument>>;

	solveConflicts(id: string, limit: number | undefined,
			warmup: boolean | undefined): Promise<Array<IdWithRev>>;

	resetStorage(id: string, databases: Array<string>,
			options?: { id?: string, q?: number | undefined, n?: number | undefined, databases?: Array<string> }): Promise<void>;

	getGroupsStorageInfos(groups: Array<string>): Promise<Array<GroupDatabasesInfo>>;

	getReplicationInfo(id: string): Promise<ReplicationInfo>;

	getHierarchy(id: string): Promise<Array<string>>;

	listAllGroupsIds(): Promise<Array<DocIdentifier>>;

}

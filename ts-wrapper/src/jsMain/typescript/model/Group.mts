// auto-generated file
import {randomUuid} from '../utils/Id.mjs';
import {DecryptedPropertyStub} from './PropertyStub.mjs';
import {CodeStub} from './base/CodeStub.mjs';
import {HasTags} from './base/HasTags.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {AuthenticationClass} from './embed/AuthenticationClass.mjs';
import {UserType} from './embed/UserType.mjs';
import {ExternalJwtConfig} from './security/ExternalJwtConfig.mjs';
import {OperationToken} from './security/OperationToken.mjs';


export class Group implements StoredDocument, HasTags {

	id: string;

	rev: string | undefined = undefined;

	deletionDate: number | undefined = undefined;

	tags: Array<CodeStub> = [];

	publicTags: Array<CodeStub> = [];

	name: string | undefined = undefined;

	password: string | undefined = undefined;

	servers: Array<string> | undefined = undefined;

	superAdmin: boolean = false;

	properties: Array<DecryptedPropertyStub> = [];

	defaultUserRoles: { [ key in UserType ]?: Array<string> } = {};

	operationTokens: { [ key: string ]: OperationToken } = {};

	sharedEntities: { [ key: string ]: string } = {};

	minimumKrakenVersion: string | undefined = undefined;

	externalJwtConfig: { [ key: string ]: ExternalJwtConfig } = {};

	minimumAuthenticationClassForElevatedPrivileges: AuthenticationClass;

	superGroup: string | undefined = undefined;

	applicationId: string | undefined = undefined;

	constructor(partial: Partial<Group> & Pick<Group, "minimumAuthenticationClassForElevatedPrivileges">) {
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('publicTags' in partial && partial.publicTags !== undefined) this.publicTags = partial.publicTags;
		if ('name' in partial) this.name = partial.name;
		if ('password' in partial) this.password = partial.password;
		if ('servers' in partial) this.servers = partial.servers;
		if ('superAdmin' in partial && partial.superAdmin !== undefined) this.superAdmin = partial.superAdmin;
		if ('properties' in partial && partial.properties !== undefined) this.properties = partial.properties;
		if ('defaultUserRoles' in partial && partial.defaultUserRoles !== undefined) this.defaultUserRoles = partial.defaultUserRoles;
		if ('operationTokens' in partial && partial.operationTokens !== undefined) this.operationTokens = partial.operationTokens;
		if ('sharedEntities' in partial && partial.sharedEntities !== undefined) this.sharedEntities = partial.sharedEntities;
		if ('minimumKrakenVersion' in partial) this.minimumKrakenVersion = partial.minimumKrakenVersion;
		if ('externalJwtConfig' in partial && partial.externalJwtConfig !== undefined) this.externalJwtConfig = partial.externalJwtConfig;
		this.minimumAuthenticationClassForElevatedPrivileges = partial.minimumAuthenticationClassForElevatedPrivileges;
		if ('superGroup' in partial) this.superGroup = partial.superGroup;
		if ('applicationId' in partial) this.applicationId = partial.applicationId;
	}

}

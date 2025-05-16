// auto-generated file
import {randomUuid} from '../utils/Id.mjs';
import {DecryptedPropertyStub} from './PropertyStub.mjs';
import {Identifier} from './base/Identifier.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {DelegationTag} from './embed/DelegationTag.mjs';
import {UsersStatus} from './enums/UsersStatus.mjs';
import {UsersType} from './enums/UsersType.mjs';
import {AuthenticationToken} from './security/AuthenticationToken.mjs';
import {Permission} from './security/Permission.mjs';


export class User implements StoredDocument {

	id: string;

	rev: string | undefined = undefined;

	deletionDate: number | undefined = undefined;

	created: number | undefined = undefined;

	identifier: Array<Identifier> = [];

	name: string | undefined = undefined;

	properties: Array<DecryptedPropertyStub> = [];

	permissions: Array<Permission> = [];

	roles: Array<string> = [];

	type: UsersType | undefined = undefined;

	status: UsersStatus | undefined = undefined;

	login: string | undefined = undefined;

	passwordHash: string | undefined = undefined;

	groupId: string | undefined = undefined;

	healthcarePartyId: string | undefined = undefined;

	patientId: string | undefined = undefined;

	deviceId: string | undefined = undefined;

	autoDelegations: { [ key in DelegationTag ]?: Array<string> } = {};

	createdDate: number | undefined = undefined;

	termsOfUseDate: number | undefined = undefined;

	email: string | undefined = undefined;

	mobilePhone: string | undefined = undefined;

	applicationTokens: { [ key: string ]: string } = {};

	authenticationTokens: { [ key: string ]: AuthenticationToken } = {};

	systemMetadata: User.SystemMetadata | undefined = undefined;

	constructor(partial: Partial<User>) {
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('created' in partial) this.created = partial.created;
		if ('identifier' in partial && partial.identifier !== undefined) this.identifier = partial.identifier;
		if ('name' in partial) this.name = partial.name;
		if ('properties' in partial && partial.properties !== undefined) this.properties = partial.properties;
		if ('permissions' in partial && partial.permissions !== undefined) this.permissions = partial.permissions;
		if ('roles' in partial && partial.roles !== undefined) this.roles = partial.roles;
		if ('type' in partial) this.type = partial.type;
		if ('status' in partial) this.status = partial.status;
		if ('login' in partial) this.login = partial.login;
		if ('passwordHash' in partial) this.passwordHash = partial.passwordHash;
		if ('groupId' in partial) this.groupId = partial.groupId;
		if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
		if ('patientId' in partial) this.patientId = partial.patientId;
		if ('deviceId' in partial) this.deviceId = partial.deviceId;
		if ('autoDelegations' in partial && partial.autoDelegations !== undefined) this.autoDelegations = partial.autoDelegations;
		if ('createdDate' in partial) this.createdDate = partial.createdDate;
		if ('termsOfUseDate' in partial) this.termsOfUseDate = partial.termsOfUseDate;
		if ('email' in partial) this.email = partial.email;
		if ('mobilePhone' in partial) this.mobilePhone = partial.mobilePhone;
		if ('applicationTokens' in partial && partial.applicationTokens !== undefined) this.applicationTokens = partial.applicationTokens;
		if ('authenticationTokens' in partial && partial.authenticationTokens !== undefined) this.authenticationTokens = partial.authenticationTokens;
		if ('systemMetadata' in partial) this.systemMetadata = partial.systemMetadata;
	}

}

export namespace User {

	export class SystemMetadata {

		roles: Array<string>;

		isAdmin: boolean;

		inheritsRoles: boolean;

		loginIdentifiers: Array<Identifier> = [];

		constructor(partial: Partial<SystemMetadata> & Pick<SystemMetadata, "roles" | "isAdmin" | "inheritsRoles">) {
			this.roles = partial.roles;
			this.isAdmin = partial.isAdmin;
			this.inheritsRoles = partial.inheritsRoles;
			if ('loginIdentifiers' in partial && partial.loginIdentifiers !== undefined) this.loginIdentifiers = partial.loginIdentifiers;
		}

	}

}

// auto-generated file
import {Group} from './Group.mjs';


export class UserGroup {

	groupId: string | undefined = undefined;

	groupName: string | undefined = undefined;

	groupsHierarchy: Array<Group> = [];

	userId: string | undefined = undefined;

	login: string | undefined = undefined;

	name: string | undefined = undefined;

	email: string | undefined = undefined;

	phone: string | undefined = undefined;

	patientId: string | undefined = undefined;

	healthcarePartyId: string | undefined = undefined;

	deviceId: string | undefined = undefined;

	nameOfParentOfTopmostGroupInHierarchy: string | undefined = undefined;

	constructor(partial: Partial<UserGroup>) {
		if ('groupId' in partial) this.groupId = partial.groupId;
		if ('groupName' in partial) this.groupName = partial.groupName;
		if ('groupsHierarchy' in partial && partial.groupsHierarchy !== undefined) this.groupsHierarchy = partial.groupsHierarchy;
		if ('userId' in partial) this.userId = partial.userId;
		if ('login' in partial) this.login = partial.login;
		if ('name' in partial) this.name = partial.name;
		if ('email' in partial) this.email = partial.email;
		if ('phone' in partial) this.phone = partial.phone;
		if ('patientId' in partial) this.patientId = partial.patientId;
		if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
		if ('deviceId' in partial) this.deviceId = partial.deviceId;
		if ('nameOfParentOfTopmostGroupInHierarchy' in partial) this.nameOfParentOfTopmostGroupInHierarchy = partial.nameOfParentOfTopmostGroupInHierarchy;
	}

}

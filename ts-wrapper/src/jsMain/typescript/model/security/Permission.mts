// auto-generated file
import {PermissionItem} from './PermissionItem.mjs';


export class Permission {

	grants: Array<PermissionItem> = [];

	revokes: Array<PermissionItem> = [];

	constructor(partial: Partial<Permission>) {
		if ('grants' in partial && partial.grants !== undefined) this.grants = partial.grants;
		if ('revokes' in partial && partial.revokes !== undefined) this.revokes = partial.revokes;
	}

}

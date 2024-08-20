// auto-generated file
import {AccessLevel} from '../../model/embed/AccessLevel.mjs';


export class EntityAccessInformation {

	permissionsByDataOwnerId: { [ key: string ]: AccessLevel };

	hasUnknownAnonymousDataOwners: boolean;

	constructor(partial: Partial<EntityAccessInformation> & Pick<EntityAccessInformation, "permissionsByDataOwnerId" | "hasUnknownAnonymousDataOwners">) {
		this.permissionsByDataOwnerId = partial.permissionsByDataOwnerId;
		this.hasUnknownAnonymousDataOwners = partial.hasUnknownAnonymousDataOwners;
	}

}

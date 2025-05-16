// auto-generated file
import {EntityReferenceInGroup} from '../../model/EntityReferenceInGroup.mjs';
import {AccessLevel} from '../../model/embed/AccessLevel.mjs';
import {ArrayWithUniqueKeys} from '../../utils/ArrayWithUniqueKeys.mjs';


export class EntityAccessInformation {

	permissionsByDataOwnerId: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, accessLevel: AccessLevel }, 'delegate'>;

	hasUnknownAnonymousDataOwners: boolean;

	constructor(partial: Partial<EntityAccessInformation> & Pick<EntityAccessInformation, "permissionsByDataOwnerId" | "hasUnknownAnonymousDataOwners">) {
		this.permissionsByDataOwnerId = partial.permissionsByDataOwnerId;
		this.hasUnknownAnonymousDataOwners = partial.hasUnknownAnonymousDataOwners;
	}

}

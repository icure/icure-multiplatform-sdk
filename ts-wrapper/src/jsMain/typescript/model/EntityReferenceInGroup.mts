// auto-generated file

export class EntityReferenceInGroup {

	entityId: string;

	groupId: string | undefined = undefined;

	constructor(partial: Partial<EntityReferenceInGroup> & Pick<EntityReferenceInGroup, "entityId">) {
		this.entityId = partial.entityId;
		if ('groupId' in partial) this.groupId = partial.groupId;
	}

}

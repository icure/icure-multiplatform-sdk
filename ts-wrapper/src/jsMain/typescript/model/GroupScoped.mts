// auto-generated file

export class GroupScoped<E> {

	entity: E;

	groupId: string;

	constructor(partial: Partial<GroupScoped<E>> & Pick<GroupScoped<E>, "entity" | "groupId">) {
		this.entity = partial.entity;
		this.groupId = partial.groupId;
	}

}

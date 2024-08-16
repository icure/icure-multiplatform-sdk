// auto-generated file

export class TokenWithGroup {

	token: string;

	groupId: string;

	groupName: string | undefined = undefined;

	constructor(partial: Partial<TokenWithGroup> & Pick<TokenWithGroup, "token" | "groupId">) {
		this.token = partial.token;
		this.groupId = partial.groupId;
		if ('groupName' in partial) this.groupName = partial.groupName;
	}

}

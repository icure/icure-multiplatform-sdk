// auto-generated file

export class Basic {

	username: string;

	password: string;

	constructor(partial: Partial<Basic> & Pick<Basic, "username" | "password">) {
		this.username = partial.username;
		this.password = partial.password;
	}

}

// auto-generated file

export class RoleConfiguration {

	source: RoleConfiguration.Source;

	roles: Array<string> = [];

	constructor(partial: Partial<RoleConfiguration> & Pick<RoleConfiguration, "source">) {
		this.source = partial.source;
		if ('roles' in partial && partial.roles !== undefined) this.roles = partial.roles;
	}

}

export namespace RoleConfiguration {

	export enum Source {
		Configuration = "Configuration",
		Inherited = "Inherited",
		Default = "Default"
	}

}

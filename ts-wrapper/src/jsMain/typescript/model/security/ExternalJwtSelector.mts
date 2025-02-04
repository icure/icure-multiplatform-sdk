// auto-generated file

export class ExternalJwtSelector {

	id: string | undefined = undefined;

	emailField: string | undefined = undefined;

	loginField: string | undefined = undefined;

	mobilePhoneField: string | undefined = undefined;

	constructor(partial: Partial<ExternalJwtSelector>) {
		if ('id' in partial) this.id = partial.id;
		if ('emailField' in partial) this.emailField = partial.emailField;
		if ('loginField' in partial) this.loginField = partial.loginField;
		if ('mobilePhoneField' in partial) this.mobilePhoneField = partial.mobilePhoneField;
	}

}

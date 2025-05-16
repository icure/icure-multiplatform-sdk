// auto-generated file
import {Base64String} from '../specializations/Base64String.mjs';
import {IdentifierSelector} from './IdentifierSelector.mjs';


export class ExternalJwtConfig {

	publicKey: Base64String;

	id: string | undefined = undefined;

	emailField: string | undefined = undefined;

	loginField: string | undefined = undefined;

	mobilePhoneField: string | undefined = undefined;

	identifierField: IdentifierSelector | undefined = undefined;

	constructor(partial: Partial<ExternalJwtConfig> & Pick<ExternalJwtConfig, "publicKey">) {
		this.publicKey = partial.publicKey;
		if ('id' in partial) this.id = partial.id;
		if ('emailField' in partial) this.emailField = partial.emailField;
		if ('loginField' in partial) this.loginField = partial.loginField;
		if ('mobilePhoneField' in partial) this.mobilePhoneField = partial.mobilePhoneField;
		if ('identifierField' in partial) this.identifierField = partial.identifierField;
	}

}

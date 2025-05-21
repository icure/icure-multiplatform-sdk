// auto-generated file
import {AuthenticationClass} from '../embed/AuthenticationClass.mjs';


export class ExternalJwtConfig {

	validationMethod: ExternalJwtConfig.ValidationMethod;

	fieldSelector: ExternalJwtConfig.FieldSelector;

	authenticationClass: AuthenticationClass = AuthenticationClass.ExternalAuthentication;

	constructor(partial: Partial<ExternalJwtConfig> & Pick<ExternalJwtConfig, "validationMethod" | "fieldSelector">) {
		this.validationMethod = partial.validationMethod;
		this.fieldSelector = partial.fieldSelector;
		if ('authenticationClass' in partial && partial.authenticationClass !== undefined) this.authenticationClass = partial.authenticationClass;
	}

}

export namespace ExternalJwtConfig {

	export namespace ValidationMethod {

		export class PublicKey {

			key: string;

			readonly $ktClass: 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.ValidationMethod.PublicKey' = 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.ValidationMethod.PublicKey';

			constructor(partial: Partial<PublicKey> & Pick<PublicKey, "key">) {
				this.key = partial.key;
			}

		}

		export class Oidc {

			issureLocation: string;

			readonly $ktClass: 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.ValidationMethod.Oidc' = 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.ValidationMethod.Oidc';

			constructor(partial: Partial<Oidc> & Pick<Oidc, "issureLocation">) {
				this.issureLocation = partial.issureLocation;
			}

		}

	}

	export type ValidationMethod = ValidationMethod.PublicKey | ValidationMethod.Oidc;

	export namespace FieldSelector {

		export class LocalId {

			fieldName: string;

			readonly $ktClass: 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.LocalId' = 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.LocalId';

			constructor(partial: Partial<LocalId> & Pick<LocalId, "fieldName">) {
				this.fieldName = partial.fieldName;
			}

		}

		export class Email {

			fieldName: string;

			readonly $ktClass: 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.Email' = 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.Email';

			constructor(partial: Partial<Email> & Pick<Email, "fieldName">) {
				this.fieldName = partial.fieldName;
			}

		}

		export class MobilePhone {

			fieldName: string;

			readonly $ktClass: 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.MobilePhone' = 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.MobilePhone';

			constructor(partial: Partial<MobilePhone> & Pick<MobilePhone, "fieldName">) {
				this.fieldName = partial.fieldName;
			}

		}

		export class Username {

			fieldName: string;

			readonly $ktClass: 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.Username' = 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.Username';

			constructor(partial: Partial<Username> & Pick<Username, "fieldName">) {
				this.fieldName = partial.fieldName;
			}

		}

		export class Identifier {

			identifierAssigner: string;

			fieldName: string;

			readonly $ktClass: 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.Identifier' = 'com.icure.cardinal.sdk.model.security.ExternalJwtConfig.FieldSelector.Identifier';

			constructor(partial: Partial<Identifier> & Pick<Identifier, "identifierAssigner" | "fieldName">) {
				this.identifierAssigner = partial.identifierAssigner;
				this.fieldName = partial.fieldName;
			}

		}

	}

	export type FieldSelector = FieldSelector.LocalId | FieldSelector.Email | FieldSelector.MobilePhone | FieldSelector.Username | FieldSelector.Identifier;

}

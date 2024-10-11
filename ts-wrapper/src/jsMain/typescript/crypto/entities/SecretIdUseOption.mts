// auto-generated file

export type SecretIdUseOption = typeof SecretIdUseOption.UseAnyConfidential | typeof SecretIdUseOption.UseAnySharedWithParent | SecretIdUseOption.Use;

export namespace SecretIdUseOption {

	export const UseAnyConfidential: {
		readonly $ktClass: 'com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnyConfidential'
	} = {
		$ktClass: 'com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnyConfidential'
	}

	export const UseAnySharedWithParent: {
		readonly $ktClass: 'com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent'
	} = {
		$ktClass: 'com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent'
	}

	export class Use {

		secretIds: Array<string>;

		readonly $ktClass: 'com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.Use' = 'com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.Use';

		constructor(partial: Partial<Use> & Pick<Use, "secretIds">) {
			this.secretIds = partial.secretIds;
		}

	}

}

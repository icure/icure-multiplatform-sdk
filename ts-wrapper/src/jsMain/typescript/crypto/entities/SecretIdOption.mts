// auto-generated file

export type SecretIdOption = typeof SecretIdOption.UseAnyConfidential | typeof SecretIdOption.UseAnySharedWithParent | SecretIdOption.Use;

export namespace SecretIdOption {

	export const UseAnyConfidential: {
		readonly $ktClass: 'com.icure.sdk.crypto.entities.SecretIdOption.UseAnyConfidential'
	} = {
		$ktClass: 'com.icure.sdk.crypto.entities.SecretIdOption.UseAnyConfidential'
	}

	export const UseAnySharedWithParent: {
		readonly $ktClass: 'com.icure.sdk.crypto.entities.SecretIdOption.UseAnySharedWithParent'
	} = {
		$ktClass: 'com.icure.sdk.crypto.entities.SecretIdOption.UseAnySharedWithParent'
	}

	export class Use {

		secretIds: Array<string>;

		readonly $ktClass: 'com.icure.sdk.crypto.entities.SecretIdOption.Use' = 'com.icure.sdk.crypto.entities.SecretIdOption.Use';

		constructor(partial: Partial<Use> & Pick<Use, "secretIds">) {
			this.secretIds = partial.secretIds;
		}

	}

}

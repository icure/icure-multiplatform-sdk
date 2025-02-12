// auto-generated file

export type SecretIdUseOption = typeof SecretIdUseOption.UseAnyConfidential | typeof SecretIdUseOption.UseAllConfidential | typeof SecretIdUseOption.UseAnySharedWithParent | typeof SecretIdUseOption.UseAllSharedWithParent | SecretIdUseOption.Use | typeof SecretIdUseOption.UseNone;

export namespace SecretIdUseOption {

	export const UseAnyConfidential: {
		readonly $ktClass: 'com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnyConfidential'
	} = {
		$ktClass: 'com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnyConfidential'
	}

	export const UseAllConfidential: {
		readonly $ktClass: 'com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAllConfidential'
	} = {
		$ktClass: 'com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAllConfidential'
	}

	export const UseAnySharedWithParent: {
		readonly $ktClass: 'com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent'
	} = {
		$ktClass: 'com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent'
	}

	export const UseAllSharedWithParent: {
		readonly $ktClass: 'com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAllSharedWithParent'
	} = {
		$ktClass: 'com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAllSharedWithParent'
	}

	export class Use {

		secretIds: Array<string>;

		readonly $ktClass: 'com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.Use' = 'com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.Use';

		constructor(partial: Partial<Use> & Pick<Use, "secretIds">) {
			this.secretIds = partial.secretIds;
		}

	}

	export const UseNone: {
		readonly $ktClass: 'com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseNone'
	} = {
		$ktClass: 'com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseNone'
	}

}

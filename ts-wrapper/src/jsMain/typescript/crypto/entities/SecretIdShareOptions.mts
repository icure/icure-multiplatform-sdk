// auto-generated file

export type SecretIdShareOptions = SecretIdShareOptions.AllAvailable | SecretIdShareOptions.UseExactly;

export namespace SecretIdShareOptions {

	export class AllAvailable {

		requireAtLeastOne: boolean;

		readonly $ktClass: 'com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions.AllAvailable' = 'com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions.AllAvailable';

		constructor(partial: Partial<AllAvailable> & Pick<AllAvailable, "requireAtLeastOne">) {
			this.requireAtLeastOne = partial.requireAtLeastOne;
		}

	}

	export class UseExactly {

		secretIds: Array<string>;

		createUnknownSecretIds: boolean;

		readonly $ktClass: 'com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions.UseExactly' = 'com.icure.cardinal.sdk.crypto.entities.SecretIdShareOptions.UseExactly';

		constructor(partial: Partial<UseExactly> & Pick<UseExactly, "secretIds" | "createUnknownSecretIds">) {
			this.secretIds = partial.secretIds;
			this.createUnknownSecretIds = partial.createUnknownSecretIds;
		}

	}

}

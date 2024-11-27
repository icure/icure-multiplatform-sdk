// auto-generated file
import {RecoveryDataKey} from './RecoveryDataKey.mjs';
import {RecoveryKeySize} from './RecoveryKeySize.mjs';


export type RecoveryKeyOptions = RecoveryKeyOptions.Generate | RecoveryKeyOptions.Use;

export namespace RecoveryKeyOptions {

	export class Generate {

		recoveryKeySize: RecoveryKeySize;

		readonly $ktClass: 'com.icure.cardinal.sdk.crypto.entities.RecoveryKeyOptions.Generate' = 'com.icure.cardinal.sdk.crypto.entities.RecoveryKeyOptions.Generate';

		constructor(partial: Partial<Generate> & Pick<Generate, "recoveryKeySize">) {
			this.recoveryKeySize = partial.recoveryKeySize;
		}

	}

	export class Use {

		key: RecoveryDataKey;

		readonly $ktClass: 'com.icure.cardinal.sdk.crypto.entities.RecoveryKeyOptions.Use' = 'com.icure.cardinal.sdk.crypto.entities.RecoveryKeyOptions.Use';

		constructor(partial: Partial<Use> & Pick<Use, "key">) {
			this.key = partial.key;
		}

	}

}

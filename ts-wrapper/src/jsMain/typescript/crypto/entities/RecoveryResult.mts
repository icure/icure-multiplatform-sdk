// auto-generated file
import {RecoveryDataUseFailureReason} from './RecoveryDataUseFailureReason.mjs';


export type RecoveryResult<T> = RecoveryResult.Success<T> | RecoveryResult.Failure;

export namespace RecoveryResult {

  export class Success<T> {

    data: T;

    readonly $ktClass: 'com.icure.sdk.crypto.entities.RecoveryResult.Success' = 'com.icure.sdk.crypto.entities.RecoveryResult.Success';

    constructor(partial: Partial<Success<T>> & Pick<Success<T>, "data">) {
      this.data = partial.data;
    }

  }

  export class Failure {

    reason: RecoveryDataUseFailureReason;

    readonly $ktClass: 'com.icure.sdk.crypto.entities.RecoveryResult.Failure' = 'com.icure.sdk.crypto.entities.RecoveryResult.Failure';

    constructor(partial: Partial<Failure> & Pick<Failure, "reason">) {
      this.reason = partial.reason;
    }

  }

}

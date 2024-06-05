// auto-generated file
import {RecoveryDataUseFailureReason} from './RecoveryDataUseFailureReason.mjs';


export type RecoveryResult<T> = RecoveryResult.Success<T> | RecoveryResult.Failure;

export namespace RecoveryResult {

  export class Success<T> {

    data: T;

    isSuccess: boolean;

    value: T;

    readonly $ktClass: 'com.icure.sdk.crypto.entities.RecoveryResult.Success' = 'com.icure.sdk.crypto.entities.RecoveryResult.Success';

    constructor(partial: Partial<Success<T>> & Pick<Success<T>, "data" | "isSuccess" | "value">) {
      this.data = partial.data;
      this.isSuccess = partial.isSuccess;
      this.value = partial.value;
    }

  }

  export class Failure {

    reason: RecoveryDataUseFailureReason;

    isSuccess: boolean;

    value: never;

    readonly $ktClass: 'com.icure.sdk.crypto.entities.RecoveryResult.Failure' = 'com.icure.sdk.crypto.entities.RecoveryResult.Failure';

    constructor(partial: Partial<Failure> & Pick<Failure, "reason" | "isSuccess" | "value">) {
      this.reason = partial.reason;
      this.isSuccess = partial.isSuccess;
      this.value = partial.value;
    }

  }

}

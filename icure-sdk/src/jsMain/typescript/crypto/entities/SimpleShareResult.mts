// auto-generated file
import {HasEncryptionMetadata} from '../../model/base/HasEncryptionMetadata.mjs';
import {FailedRequestDetails} from './FailedRequestDetails.mjs';


export type SimpleShareResult<T extends HasEncryptionMetadata> = SimpleShareResult.Success<T> | SimpleShareResult.Failure;

export namespace SimpleShareResult {

  export class Success<T extends HasEncryptionMetadata> {

    updatedEntity: T;

    isSuccess: boolean;

    readonly $ktClass: 'com.icure.sdk.crypto.entities.SimpleShareResult.Success' = 'com.icure.sdk.crypto.entities.SimpleShareResult.Success';

    constructor(partial: Partial<Success<T>> & Pick<Success<T>, "updatedEntity" | "isSuccess">) {
      this.updatedEntity = partial.updatedEntity;
      this.isSuccess = partial.isSuccess;
    }

  }

  export class Failure {

    errorsDetails: Array<FailedRequestDetails>;

    isSuccess: boolean;

    readonly $ktClass: 'com.icure.sdk.crypto.entities.SimpleShareResult.Failure' = 'com.icure.sdk.crypto.entities.SimpleShareResult.Failure';

    constructor(partial: Partial<Failure> & Pick<Failure, "errorsDetails" | "isSuccess">) {
      this.errorsDetails = partial.errorsDetails;
      this.isSuccess = partial.isSuccess;
    }

  }

}

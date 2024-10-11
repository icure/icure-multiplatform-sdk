// auto-generated file
import {DelegateShareOptions} from './DelegateShareOptions.mjs';


export class FailedRequestDetails {

	entityId: string;

	delegateId: string;

	updatedForMigration: boolean;

	code: number | undefined;

	reason: string | undefined;

	request: DelegateShareOptions | undefined;

	shouldRetry: boolean;

	constructor(partial: Partial<FailedRequestDetails> & Pick<FailedRequestDetails, "entityId" | "delegateId" | "updatedForMigration" | "code" | "reason" | "request" | "shouldRetry">) {
		this.entityId = partial.entityId;
		this.delegateId = partial.delegateId;
		this.updatedForMigration = partial.updatedForMigration;
		this.code = partial.code;
		this.reason = partial.reason;
		this.request = partial.request;
		this.shouldRetry = partial.shouldRetry;
	}

}

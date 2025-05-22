// auto-generated file
import {EntityReferenceInGroup} from '../../model/EntityReferenceInGroup.mjs';
import {DelegateShareOptions} from './DelegateShareOptions.mjs';


export class FailedRequestDetails {

	entityId: string;

	delegateReference: EntityReferenceInGroup;

	updatedForMigration: boolean;

	code: number | undefined;

	reason: string | undefined;

	request: DelegateShareOptions | undefined;

	shouldRetry: boolean;

	constructor(partial: Partial<FailedRequestDetails> & Pick<FailedRequestDetails, "entityId" | "delegateReference" | "updatedForMigration" | "code" | "reason" | "request" | "shouldRetry">) {
		this.entityId = partial.entityId;
		this.delegateReference = partial.delegateReference;
		this.updatedForMigration = partial.updatedForMigration;
		this.code = partial.code;
		this.reason = partial.reason;
		this.request = partial.request;
		this.shouldRetry = partial.shouldRetry;
	}

}

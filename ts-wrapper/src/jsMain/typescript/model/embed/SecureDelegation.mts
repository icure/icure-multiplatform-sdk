// auto-generated file
import {Base64String} from '../specializations/Base64String.mjs';
import {SecureDelegationKeyString} from '../specializations/SecureDelegationKeyString.mjs';
import {AccessLevel} from './AccessLevel.mjs';


export class SecureDelegation {

	delegator: string | undefined = undefined;

	delegate: string | undefined = undefined;

	secretIds: Array<Base64String> = [];

	encryptionKeys: Array<Base64String> = [];

	owningEntityIds: Array<Base64String> = [];

	parentDelegations: Array<SecureDelegationKeyString> = [];

	exchangeDataId: string | undefined = undefined;

	permissions: AccessLevel;

	constructor(partial: Partial<SecureDelegation> & Pick<SecureDelegation, "permissions">) {
		if ('delegator' in partial) this.delegator = partial.delegator;
		if ('delegate' in partial) this.delegate = partial.delegate;
		if ('secretIds' in partial && partial.secretIds !== undefined) this.secretIds = partial.secretIds;
		if ('encryptionKeys' in partial && partial.encryptionKeys !== undefined) this.encryptionKeys = partial.encryptionKeys;
		if ('owningEntityIds' in partial && partial.owningEntityIds !== undefined) this.owningEntityIds = partial.owningEntityIds;
		if ('parentDelegations' in partial && partial.parentDelegations !== undefined) this.parentDelegations = partial.parentDelegations;
		if ('exchangeDataId' in partial) this.exchangeDataId = partial.exchangeDataId;
		this.permissions = partial.permissions;
	}

}

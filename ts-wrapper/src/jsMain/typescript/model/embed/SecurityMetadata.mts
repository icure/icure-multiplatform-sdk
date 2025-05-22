// auto-generated file
import {SecureDelegation} from './SecureDelegation.mjs';


export class SecurityMetadata {

	secureDelegations: { [ key: string ]: SecureDelegation };

	constructor(partial: Partial<SecurityMetadata> & Pick<SecurityMetadata, "secureDelegations">) {
		this.secureDelegations = partial.secureDelegations;
	}

}

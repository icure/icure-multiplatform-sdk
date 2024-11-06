// auto-generated file
import {Sha256HexString} from '../specializations/Sha256HexString.mjs';
import {SecureDelegation} from './SecureDelegation.mjs';


export class SecurityMetadata {

	secureDelegations: { [ key: string ]: SecureDelegation };

	keysEquivalences: { [ key: string ]: Sha256HexString } = {};

	constructor(partial: Partial<SecurityMetadata> & Pick<SecurityMetadata, "secureDelegations">) {
		this.secureDelegations = partial.secureDelegations;
		if ('keysEquivalences' in partial && partial.keysEquivalences !== undefined) this.keysEquivalences = partial.keysEquivalences;
	}

}

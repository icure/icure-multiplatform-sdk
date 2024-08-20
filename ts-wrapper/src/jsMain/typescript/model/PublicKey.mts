// auto-generated file

export class PublicKey {

	hcPartyId: string | undefined = undefined;

	hexString: string | undefined = undefined;

	constructor(partial: Partial<PublicKey>) {
		if ('hcPartyId' in partial) this.hcPartyId = partial.hcPartyId;
		if ('hexString' in partial) this.hexString = partial.hexString;
	}

}

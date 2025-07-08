// auto-generated file

export class RawDecryptedExchangeData {

	exchangeDataId: string;

	exchangeKey: Int8Array;

	accessControlSecret: Int8Array;

	sharedSignatureKey: Int8Array;

	constructor(partial: Partial<RawDecryptedExchangeData> & Pick<RawDecryptedExchangeData, "exchangeDataId" | "exchangeKey" | "accessControlSecret" | "sharedSignatureKey">) {
		this.exchangeDataId = partial.exchangeDataId;
		this.exchangeKey = partial.exchangeKey;
		this.accessControlSecret = partial.accessControlSecret;
		this.sharedSignatureKey = partial.sharedSignatureKey;
	}

}

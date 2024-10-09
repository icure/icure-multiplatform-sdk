import {
	hexEncode,
	hexDecode,
	base32Encode,
	base32Decode,
} from "../../cardinal-sdk-ts.mjs"

export class RecoveryDataKey {
	private constructor(private readonly _hex: string) {}

	asHexString(): string {
		return this._hex
	}

	asRawBytes(): Int8Array {
		return hexDecode(this._hex)
	}

	asBase32(): string {
		return base32Encode(hexDecode(this._hex)).replace(/=+$/, '')
	}

	static fromBase32(base32String: string): RecoveryDataKey {
		return new RecoveryDataKey(hexEncode(base32Decode(base32String)))
	}

	static fromRawBytes(rawBytes: Int8Array): RecoveryDataKey {
		return new RecoveryDataKey(hexEncode(rawBytes))
	}

	static fromHexString(hexString: string): RecoveryDataKey {
		return new RecoveryDataKey(hexString)
	}
}

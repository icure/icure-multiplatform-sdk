// auto-generated file
import {Base64String} from '../specializations/Base64String.mjs';
import {AddressType} from './AddressType.mjs';
import {Annotation} from './Annotation.mjs';
import {Encryptable} from './Encryptable.mjs';
import {DecryptedTelecom, EncryptedTelecom, Telecom} from './Telecom.mjs';


export interface Address extends Encryptable {

	addressType: AddressType | undefined;

	descr: string | undefined;

	street: string | undefined;

	houseNumber: string | undefined;

	postboxNumber: string | undefined;

	postalCode: string | undefined;

	city: string | undefined;

	state: string | undefined;

	country: string | undefined;

	note: string | undefined;

	notes: Array<Annotation>;

	telecoms: Array<Telecom>;

	readonly isEncrypted: boolean;

}

export class DecryptedAddress {

	addressType: AddressType | undefined = undefined;

	descr: string | undefined = undefined;

	street: string | undefined = undefined;

	houseNumber: string | undefined = undefined;

	postboxNumber: string | undefined = undefined;

	postalCode: string | undefined = undefined;

	city: string | undefined = undefined;

	state: string | undefined = undefined;

	country: string | undefined = undefined;

	note: string | undefined = undefined;

	notes: Array<Annotation> = [];

	telecoms: Array<DecryptedTelecom> = [];

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: false = false;

	constructor(partial: Partial<DecryptedAddress>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
		if ('addressType' in partial) this.addressType = partial.addressType;
		if ('descr' in partial) this.descr = partial.descr;
		if ('street' in partial) this.street = partial.street;
		if ('houseNumber' in partial) this.houseNumber = partial.houseNumber;
		if ('postboxNumber' in partial) this.postboxNumber = partial.postboxNumber;
		if ('postalCode' in partial) this.postalCode = partial.postalCode;
		if ('city' in partial) this.city = partial.city;
		if ('state' in partial) this.state = partial.state;
		if ('country' in partial) this.country = partial.country;
		if ('note' in partial) this.note = partial.note;
		if ('notes' in partial && partial.notes !== undefined) this.notes = partial.notes;
		if ('telecoms' in partial && partial.telecoms !== undefined) this.telecoms = partial.telecoms;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

}

export class EncryptedAddress {

	addressType: AddressType | undefined = undefined;

	descr: string | undefined = undefined;

	street: string | undefined = undefined;

	houseNumber: string | undefined = undefined;

	postboxNumber: string | undefined = undefined;

	postalCode: string | undefined = undefined;

	city: string | undefined = undefined;

	state: string | undefined = undefined;

	country: string | undefined = undefined;

	note: string | undefined = undefined;

	notes: Array<Annotation> = [];

	telecoms: Array<EncryptedTelecom> = [];

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: true = true;

	constructor(partial: Partial<EncryptedAddress>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
		if ('addressType' in partial) this.addressType = partial.addressType;
		if ('descr' in partial) this.descr = partial.descr;
		if ('street' in partial) this.street = partial.street;
		if ('houseNumber' in partial) this.houseNumber = partial.houseNumber;
		if ('postboxNumber' in partial) this.postboxNumber = partial.postboxNumber;
		if ('postalCode' in partial) this.postalCode = partial.postalCode;
		if ('city' in partial) this.city = partial.city;
		if ('state' in partial) this.state = partial.state;
		if ('country' in partial) this.country = partial.country;
		if ('note' in partial) this.note = partial.note;
		if ('notes' in partial && partial.notes !== undefined) this.notes = partial.notes;
		if ('telecoms' in partial && partial.telecoms !== undefined) this.telecoms = partial.telecoms;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

}

// auto-generated file
import {randomUuid} from '../utils/Id.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {DecryptedAddress} from './embed/Address.mjs';


export class Insurance implements StoredDocument {

	id: string;

	rev: string | undefined = undefined;

	deletionDate: number | undefined = undefined;

	name: { [ key: string ]: string } = {};

	privateInsurance: boolean = false;

	hospitalisationInsurance: boolean = false;

	ambulatoryInsurance: boolean = false;

	code: string | undefined = undefined;

	agreementNumber: string | undefined = undefined;

	parent: string | undefined = undefined;

	address: DecryptedAddress;

	constructor(partial: Partial<Insurance> & Pick<Insurance, "address">) {
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('name' in partial && partial.name !== undefined) this.name = partial.name;
		if ('privateInsurance' in partial && partial.privateInsurance !== undefined) this.privateInsurance = partial.privateInsurance;
		if ('hospitalisationInsurance' in partial && partial.hospitalisationInsurance !== undefined) this.hospitalisationInsurance = partial.hospitalisationInsurance;
		if ('ambulatoryInsurance' in partial && partial.ambulatoryInsurance !== undefined) this.ambulatoryInsurance = partial.ambulatoryInsurance;
		if ('code' in partial) this.code = partial.code;
		if ('agreementNumber' in partial) this.agreementNumber = partial.agreementNumber;
		if ('parent' in partial) this.parent = partial.parent;
		this.address = partial.address;
	}

}

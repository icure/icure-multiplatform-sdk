// auto-generated file
import {Base64String} from '../specializations/Base64String.mjs';
import {Encryptable} from './Encryptable.mjs';


export interface Valorisation extends Encryptable {

	startOfValidity: number | undefined;

	endOfValidity: number | undefined;

	predicate: string | undefined;

	reference: Array<number> | undefined;

	totalAmount: number | undefined;

	reimbursement: number | undefined;

	patientIntervention: number | undefined;

	doctorSupplement: number | undefined;

	vat: number | undefined;

	label: { [ key: string ]: string } | undefined;

	readonly isEncrypted: boolean;

}

export class DecryptedValorisation {

	startOfValidity: number | undefined = undefined;

	endOfValidity: number | undefined = undefined;

	predicate: string | undefined = undefined;

	reference: Array<number> | undefined = undefined;

	totalAmount: number | undefined = undefined;

	reimbursement: number | undefined = undefined;

	patientIntervention: number | undefined = undefined;

	doctorSupplement: number | undefined = undefined;

	vat: number | undefined = undefined;

	label: { [ key: string ]: string } | undefined = {};

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: false = false;

	constructor(partial: Partial<DecryptedValorisation>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
		if ('startOfValidity' in partial) this.startOfValidity = partial.startOfValidity;
		if ('endOfValidity' in partial) this.endOfValidity = partial.endOfValidity;
		if ('predicate' in partial) this.predicate = partial.predicate;
		if ('reference' in partial) this.reference = partial.reference;
		if ('totalAmount' in partial) this.totalAmount = partial.totalAmount;
		if ('reimbursement' in partial) this.reimbursement = partial.reimbursement;
		if ('patientIntervention' in partial) this.patientIntervention = partial.patientIntervention;
		if ('doctorSupplement' in partial) this.doctorSupplement = partial.doctorSupplement;
		if ('vat' in partial) this.vat = partial.vat;
		if ('label' in partial) this.label = partial.label;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

}

export class EncryptedValorisation {

	startOfValidity: number | undefined = undefined;

	endOfValidity: number | undefined = undefined;

	predicate: string | undefined = undefined;

	reference: Array<number> | undefined = undefined;

	totalAmount: number | undefined = undefined;

	reimbursement: number | undefined = undefined;

	patientIntervention: number | undefined = undefined;

	doctorSupplement: number | undefined = undefined;

	vat: number | undefined = undefined;

	label: { [ key: string ]: string } | undefined = {};

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: true = true;

	constructor(partial: Partial<EncryptedValorisation>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
		if ('startOfValidity' in partial) this.startOfValidity = partial.startOfValidity;
		if ('endOfValidity' in partial) this.endOfValidity = partial.endOfValidity;
		if ('predicate' in partial) this.predicate = partial.predicate;
		if ('reference' in partial) this.reference = partial.reference;
		if ('totalAmount' in partial) this.totalAmount = partial.totalAmount;
		if ('reimbursement' in partial) this.reimbursement = partial.reimbursement;
		if ('patientIntervention' in partial) this.patientIntervention = partial.patientIntervention;
		if ('doctorSupplement' in partial) this.doctorSupplement = partial.doctorSupplement;
		if ('vat' in partial) this.vat = partial.vat;
		if ('label' in partial) this.label = partial.label;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

}

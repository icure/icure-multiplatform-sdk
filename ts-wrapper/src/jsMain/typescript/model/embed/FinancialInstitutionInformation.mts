// auto-generated file
import {Base64String} from '../specializations/Base64String.mjs';
import {Encryptable} from './Encryptable.mjs';


export interface FinancialInstitutionInformation extends Encryptable {

	name: string | undefined;

	key: string | undefined;

	bankAccount: string | undefined;

	bic: string | undefined;

	proxyBankAccount: string | undefined;

	proxyBic: string | undefined;

	preferredFiiForPartners: Array<string>;

	readonly isEncrypted: boolean;

}

export class DecryptedFinancialInstitutionInformation {

	name: string | undefined = undefined;

	key: string | undefined = undefined;

	bankAccount: string | undefined = undefined;

	bic: string | undefined = undefined;

	proxyBankAccount: string | undefined = undefined;

	proxyBic: string | undefined = undefined;

	preferredFiiForPartners: Array<string> = [];

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: false = false;

	constructor(partial: Partial<DecryptedFinancialInstitutionInformation>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
		if ('name' in partial) this.name = partial.name;
		if ('key' in partial) this.key = partial.key;
		if ('bankAccount' in partial) this.bankAccount = partial.bankAccount;
		if ('bic' in partial) this.bic = partial.bic;
		if ('proxyBankAccount' in partial) this.proxyBankAccount = partial.proxyBankAccount;
		if ('proxyBic' in partial) this.proxyBic = partial.proxyBic;
		if ('preferredFiiForPartners' in partial && partial.preferredFiiForPartners !== undefined) this.preferredFiiForPartners = partial.preferredFiiForPartners;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

}

export class EncryptedFinancialInstitutionInformation {

	name: string | undefined = undefined;

	key: string | undefined = undefined;

	bankAccount: string | undefined = undefined;

	bic: string | undefined = undefined;

	proxyBankAccount: string | undefined = undefined;

	proxyBic: string | undefined = undefined;

	preferredFiiForPartners: Array<string> = [];

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: true = true;

	constructor(partial: Partial<EncryptedFinancialInstitutionInformation>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
		if ('name' in partial) this.name = partial.name;
		if ('key' in partial) this.key = partial.key;
		if ('bankAccount' in partial) this.bankAccount = partial.bankAccount;
		if ('bic' in partial) this.bic = partial.bic;
		if ('proxyBankAccount' in partial) this.proxyBankAccount = partial.proxyBankAccount;
		if ('proxyBic' in partial) this.proxyBic = partial.proxyBic;
		if ('preferredFiiForPartners' in partial && partial.preferredFiiForPartners !== undefined) this.preferredFiiForPartners = partial.preferredFiiForPartners;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

}

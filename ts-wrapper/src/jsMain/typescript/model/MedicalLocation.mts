// auto-generated file
import {randomUuid} from '../utils/Id.mjs';
import {Named} from './base/Named.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {DecryptedAddress} from './embed/Address.mjs';


export class MedicalLocation implements StoredDocument, Named {

	id: string;

	rev: string | undefined = undefined;

	deletionDate: number | undefined = undefined;

	name: string | undefined = undefined;

	description: string | undefined = undefined;

	responsible: string | undefined = undefined;

	guardPost: boolean | undefined = undefined;

	cbe: string | undefined = undefined;

	bic: string | undefined = undefined;

	bankAccount: string | undefined = undefined;

	nihii: string | undefined = undefined;

	ssin: string | undefined = undefined;

	address: DecryptedAddress | undefined = undefined;

	agendaIds: Array<string> = [];

	options: { [ key: string ]: string } = {};

	publicInformations: { [ key: string ]: string } = {};

	constructor(partial: Partial<MedicalLocation>) {
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('name' in partial) this.name = partial.name;
		if ('description' in partial) this.description = partial.description;
		if ('responsible' in partial) this.responsible = partial.responsible;
		if ('guardPost' in partial) this.guardPost = partial.guardPost;
		if ('cbe' in partial) this.cbe = partial.cbe;
		if ('bic' in partial) this.bic = partial.bic;
		if ('bankAccount' in partial) this.bankAccount = partial.bankAccount;
		if ('nihii' in partial) this.nihii = partial.nihii;
		if ('ssin' in partial) this.ssin = partial.ssin;
		if ('address' in partial) this.address = partial.address;
		if ('agendaIds' in partial && partial.agendaIds !== undefined) this.agendaIds = partial.agendaIds;
		if ('options' in partial && partial.options !== undefined) this.options = partial.options;
		if ('publicInformations' in partial && partial.publicInformations !== undefined) this.publicInformations = partial.publicInformations;
	}

}

// auto-generated file
import {EncryptedHealthElement} from '../../model/HealthElement.mjs';
import {IcureStub} from '../../model/IcureStub.mjs';
import {PaginatedList} from '../../model/PaginatedList.mjs';
import {DocIdentifier} from '../../model/couchdb/DocIdentifier.mjs';
import {AbstractFilter} from '../../model/filter/AbstractFilter.mjs';
import {FilterChain} from '../../model/filter/chain/FilterChain.mjs';


export interface HealthcareElementBasicApi {

	matchHealthcareElementsBy(filter: AbstractFilter<EncryptedHealthElement>): Promise<Array<string>>;

	deleteHealthcareElement(entityId: string): Promise<DocIdentifier>;

	deleteHealthcareElements(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	findHealthcareElementsDelegationsStubsByHcPartyPatientForeignKeys(hcPartyId: string,
			secretPatientKeys: Array<string>): Promise<Array<IcureStub>>;

	modifyHealthcareElement(entity: EncryptedHealthElement): Promise<EncryptedHealthElement>;

	modifyHealthcareElements(entities: Array<EncryptedHealthElement>): Promise<Array<EncryptedHealthElement>>;

	getHealthcareElement(entityId: string): Promise<EncryptedHealthElement>;

	getHealthcareElements(entityIds: Array<string>): Promise<Array<EncryptedHealthElement>>;

	filterHealthcareElementsBy(filterChain: FilterChain<EncryptedHealthElement>,
			startDocumentId: string | undefined,
			limit: number | undefined): Promise<PaginatedList<EncryptedHealthElement>>;

	findHealthcareElementsByHcPartyPatientForeignKeys(hcPartyId: string,
			secretPatientKeys: Array<string>): Promise<Array<EncryptedHealthElement>>;

}

// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {DataOwnerRegistrationSuccess} from '../model/DataOwnerRegistrationSuccess.mjs';
import {HealthcareParty} from '../model/HealthcareParty.mjs';
import {PaginatedList} from '../model/PaginatedList.mjs';
import {PublicKey} from '../model/PublicKey.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';


export interface HealthcarePartyApi {

	getHealthcareParty(healthcarePartyId: string): Promise<HealthcareParty>;

	createHealthcareParty(p: HealthcareParty): Promise<HealthcareParty>;

	deleteHealthcareParty(healthcarePartyId: string): Promise<DocIdentifier>;

	modifyHealthcarePartyInGroup(groupId: string,
			healthcareParty: HealthcareParty): Promise<HealthcareParty>;

	createHealthcarePartyInGroup(groupId: string,
			healthcareParty: HealthcareParty): Promise<HealthcareParty>;

	getCurrentHealthcareParty(): Promise<HealthcareParty>;

	findHealthcarePartiesBy(options?: { startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined, desc?: boolean | undefined }): Promise<PaginatedList<HealthcareParty>>;

	findHealthcarePartiesByName(options?: { name?: string | undefined, startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined, desc?: boolean | undefined }): Promise<PaginatedList<HealthcareParty>>;

	findHealthcarePartiesBySsinOrNihii(searchValue: string,
			options?: { startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined, desc?: boolean }): Promise<PaginatedList<HealthcareParty>>;

	listHealthcarePartiesByName(name: string): Promise<Array<HealthcareParty>>;

	findHealthcarePartiesBySpecialityAndPostCode(
			type: string,
			spec: string,
			firstCode: string,
			lastCode: string,
			options?: { startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined }
	): Promise<PaginatedList<HealthcareParty>>;

	getHealthcareParties(healthcarePartyIds: Array<string>): Promise<Array<HealthcareParty>>;

	listHealthcarePartiesByParentId(parentId: string): Promise<Array<HealthcareParty>>;

	getPublicKey(healthcarePartyId: string): Promise<PublicKey>;

	deleteHealthcareParties(healthcarePartyIds: Array<string>): Promise<Array<DocIdentifier>>;

	modifyHealthcareParty(healthcareParty: HealthcareParty): Promise<HealthcareParty>;

	matchHealthcarePartiesBy(filter: BaseFilterOptions<HealthcareParty>): Promise<Array<string>>;

	filterHealthPartiesBy(filter: BaseFilterOptions<HealthcareParty>): Promise<PaginatedListIterator<HealthcareParty>>;

	matchHealthcarePartiesBySorted(filter: BaseSortableFilterOptions<HealthcareParty>): Promise<Array<string>>;

	filterHealthPartiesBySorted(filter: BaseSortableFilterOptions<HealthcareParty>): Promise<PaginatedListIterator<HealthcareParty>>;

	getHealthcarePartiesInGroup(groupId: string,
			options?: { healthcarePartyIds?: Array<string> | undefined }): Promise<Array<HealthcareParty>>;

	deleteHealthcarePartiesInGroup(groupId: string,
			healthcarePartyIds: Array<string>): Promise<Array<DocIdentifier>>;

	deleteHealthcarePartyInGroup(healthcarePartyId: string, groupId: string): Promise<DocIdentifier>;

	registerPatient(groupId: string, hcp: HealthcareParty,
			options?: { parentHcPartyId?: string | undefined, token?: string | undefined, useShortToken?: boolean | undefined }): Promise<DataOwnerRegistrationSuccess>;

}

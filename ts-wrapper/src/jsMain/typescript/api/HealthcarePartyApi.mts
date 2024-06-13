// auto-generated file
import {DataOwnerRegistrationSuccess} from '../model/DataOwnerRegistrationSuccess.mjs';
import {HealthcareParty} from '../model/HealthcareParty.mjs';
import {PaginatedList} from '../model/PaginatedList.mjs';
import {PublicKey} from '../model/PublicKey.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';
import {AbstractFilter} from '../model/filter/AbstractFilter.mjs';
import {FilterChain} from '../model/filter/chain/FilterChain.mjs';


export interface HealthcarePartyApi {

	getHealthcareParty(deviceId: string): Promise<HealthcareParty>;

	createHealthcareParty(p: HealthcareParty): Promise<HealthcareParty>;

	deleteHealthcareParty(deviceId: string): Promise<DocIdentifier>;

	modifyHealthcarePartyInGroup(groupId: string, device: HealthcareParty): Promise<HealthcareParty>;

	createHealthcarePartyInGroup(groupId: string, device: HealthcareParty): Promise<HealthcareParty>;

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

	modifyHealthcareParty(healthcarePartyDto: HealthcareParty): Promise<HealthcareParty>;

	matchHealthcarePartiesBy(filter: AbstractFilter<HealthcareParty>): Promise<Array<string>>;

	filterHealthPartiesBy(filterChain: FilterChain<HealthcareParty>,
			options?: { startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<HealthcareParty>>;

	getHealthcarePartiesInGroup(groupId: string,
			options?: { healthcarePartyIds?: Array<string> | undefined }): Promise<Array<HealthcareParty>>;

	deleteHealthcarePartiesInGroup(groupId: string,
			healthcarePartyIds: Array<string>): Promise<Array<DocIdentifier>>;

	deleteHealthcarePartyInGroup(healthcarePartyId: string, groupId: string): Promise<DocIdentifier>;

	registerPatient(groupId: string, hcp: HealthcareParty,
			options?: { parentHcPartyId?: string | undefined, token?: string | undefined, useShortToken?: boolean | undefined }): Promise<DataOwnerRegistrationSuccess>;

}

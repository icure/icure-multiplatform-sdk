// auto-generated file
import {SecretIdOption} from '../../crypto/entities/SecretIdOption.mjs';
import {ShareMetadataBehaviour} from '../../crypto/entities/ShareMetadataBehaviour.mjs';
import {SimpleShareResult} from '../../crypto/entities/SimpleShareResult.mjs';
import {PaginatedListIterator} from '../../icure-sdk.mjs';
import {DecryptedHealthElement, EncryptedHealthElement, HealthElement} from '../../model/HealthElement.mjs';
import {IcureStub} from '../../model/IcureStub.mjs';
import {PaginatedList} from '../../model/PaginatedList.mjs';
import {Patient} from '../../model/Patient.mjs';
import {User} from '../../model/User.mjs';
import {DocIdentifier} from '../../model/couchdb/DocIdentifier.mjs';
import {AccessLevel} from '../../model/embed/AccessLevel.mjs';
import {AbstractFilter} from '../../model/filter/AbstractFilter.mjs';
import {FilterChain} from '../../model/filter/chain/FilterChain.mjs';
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';
import {HealthcareElementFlavouredApi} from './HealthcareElementFlavouredApi.mjs';


export interface HealthcareElementApi {

	encrypted: HealthcareElementFlavouredApi<EncryptedHealthElement>;

	tryAndRecover: HealthcareElementFlavouredApi<HealthElement>;

	createHealthcareElement(entity: DecryptedHealthElement): Promise<DecryptedHealthElement>;

	createHealthcareElements(entities: Array<DecryptedHealthElement>): Promise<Array<DecryptedHealthElement>>;

	withEncryptionMetadata(
			base: DecryptedHealthElement | undefined,
			patient: Patient,
			user: User | undefined,
			delegates: { [ key: string ]: AccessLevel },
			secretId: SecretIdOption
	): Promise<DecryptedHealthElement>;

	matchHealthcareElementsBy(filter: AbstractFilter<EncryptedHealthElement>): Promise<Array<string>>;

	deleteHealthcareElement(entityId: string): Promise<DocIdentifier>;

	deleteHealthcareElements(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	findHealthcareElementsDelegationsStubsByHcPartyPatientForeignKeys(hcPartyId: string,
			secretPatientKeys: Array<string>): Promise<Array<IcureStub>>;

	shareWith(
			delegateId: string,
			healthcareElement: DecryptedHealthElement,
			shareEncryptionKeys: ShareMetadataBehaviour,
			shareOwningEntityIds: ShareMetadataBehaviour,
			requestedPermission: RequestedPermission
	): Promise<SimpleShareResult<DecryptedHealthElement>>;

	findHealthcareElementsByHcPartyPatient(
			hcPartyId: string,
			patient: Patient,
			startDate: number | undefined,
			endDate: number | undefined,
			descending: boolean | undefined
	): Promise<PaginatedListIterator<DecryptedHealthElement>>;

	modifyHealthcareElement(entity: DecryptedHealthElement): Promise<DecryptedHealthElement>;

	modifyHealthcareElements(entities: Array<DecryptedHealthElement>): Promise<Array<DecryptedHealthElement>>;

	getHealthcareElement(entityId: string): Promise<DecryptedHealthElement>;

	getHealthcareElements(entityIds: Array<string>): Promise<Array<DecryptedHealthElement>>;

	filterHealthcareElementsBy(filterChain: FilterChain<EncryptedHealthElement>,
			startDocumentId: string | undefined,
			limit: number | undefined): Promise<PaginatedList<DecryptedHealthElement>>;

	findHealthcareElementsByHcPartyPatientForeignKeys(hcPartyId: string,
			secretPatientKeys: Array<string>): Promise<Array<DecryptedHealthElement>>;

}

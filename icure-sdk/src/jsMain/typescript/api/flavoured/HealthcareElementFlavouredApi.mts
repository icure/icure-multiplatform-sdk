// auto-generated file
import {ShareMetadataBehaviour} from '../../crypto/entities/ShareMetadataBehaviour.mjs';
import {SimpleShareResult} from '../../crypto/entities/SimpleShareResult.mjs';
import {PaginatedListIterator} from '../../icure-sdk.mjs';
import {EncryptedHealthElement, HealthElement} from '../../model/HealthElement.mjs';
import {PaginatedList} from '../../model/PaginatedList.mjs';
import {Patient} from '../../model/Patient.mjs';
import {FilterChain} from '../../model/filter/chain/FilterChain.mjs';
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';


export interface HealthcareElementFlavouredApi<E extends HealthElement> {

	shareWith(
			delegateId: string,
			healthcareElement: E,
			shareEncryptionKeys: ShareMetadataBehaviour,
			shareOwningEntityIds: ShareMetadataBehaviour,
			requestedPermission: RequestedPermission
	): Promise<SimpleShareResult<E>>;

	findHealthcareElementsByHcPartyPatient(
			hcPartyId: string,
			patient: Patient,
			startDate: number | undefined,
			endDate: number | undefined,
			descending: boolean | undefined
	): Promise<PaginatedListIterator<E>>;

	modifyHealthcareElement(entity: E): Promise<E>;

	modifyHealthcareElements(entities: Array<E>): Promise<Array<E>>;

	getHealthcareElement(entityId: string): Promise<E>;

	getHealthcareElements(entityIds: Array<string>): Promise<Array<E>>;

	filterHealthcareElementsBy(filterChain: FilterChain<EncryptedHealthElement>,
			startDocumentId: string | undefined, limit: number | undefined): Promise<PaginatedList<E>>;

	findHealthcareElementsByHcPartyPatientForeignKeys(hcPartyId: string,
			secretPatientKeys: Array<string>): Promise<Array<E>>;

}

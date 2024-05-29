// auto-generated file
import {HealthElementShareOptions} from '../../crypto/entities/HealthElementShareOptions.mjs';
import {ShareMetadataBehaviour} from '../../crypto/entities/ShareMetadataBehaviour.mjs';
import {SimpleShareResult} from '../../crypto/entities/SimpleShareResult.mjs';
import {PaginatedListIterator} from '../../icure-sdk.mjs';
import {HealthElement} from '../../model/HealthElement.mjs';
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

	tryShareWithMany(healthElement: E,
			delegates: { [ key: string ]: HealthElementShareOptions }): Promise<SimpleShareResult<E>>;

	shareWithMany(healthElement: E,
			delegates: { [ key: string ]: HealthElementShareOptions }): Promise<E>;

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

	filterHealthcareElementsBy(filterChain: FilterChain<HealthElement>,
			startDocumentId: string | undefined, limit: number | undefined): Promise<PaginatedList<E>>;

	findHealthcareElementsByHcPartyPatientForeignKeys(hcPartyId: string,
			secretPatientKeys: Array<string>): Promise<Array<E>>;

}

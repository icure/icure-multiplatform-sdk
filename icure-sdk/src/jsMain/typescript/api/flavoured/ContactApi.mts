// auto-generated file
import {SecretIdOption} from '../../crypto/entities/SecretIdOption.mjs';
import {ShareMetadataBehaviour} from '../../crypto/entities/ShareMetadataBehaviour.mjs';
import {SimpleShareResult} from '../../crypto/entities/SimpleShareResult.mjs';
import {PaginatedListIterator} from '../../icure-sdk.mjs';
import {Contact, DecryptedContact, EncryptedContact} from '../../model/Contact.mjs';
import {IcureStub} from '../../model/IcureStub.mjs';
import {PaginatedList} from '../../model/PaginatedList.mjs';
import {Patient} from '../../model/Patient.mjs';
import {User} from '../../model/User.mjs';
import {DocIdentifier} from '../../model/couchdb/DocIdentifier.mjs';
import {LabelledOccurence} from '../../model/data/LabelledOccurence.mjs';
import {AccessLevel} from '../../model/embed/AccessLevel.mjs';
import {DecryptedService, EncryptedService, Service} from '../../model/embed/Service.mjs';
import {AbstractFilter} from '../../model/filter/AbstractFilter.mjs';
import {FilterChain} from '../../model/filter/chain/FilterChain.mjs';
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';
import {ContactFlavouredApi} from './ContactFlavouredApi.mjs';


export interface ContactApi {

	encrypted: ContactFlavouredApi<EncryptedContact, EncryptedService>;

	tryAndRecover: ContactFlavouredApi<Contact, Service>;

	createContact(entity: DecryptedContact): Promise<DecryptedContact>;

	createContacts(entities: Array<DecryptedContact>): Promise<Array<DecryptedContact>>;

	withEncryptionMetadata(
			base: DecryptedContact | undefined,
			patient: Patient,
			user: User | undefined,
			delegates: { [ key: string ]: AccessLevel },
			secretId: SecretIdOption
	): Promise<DecryptedContact>;

	matchContactsBy(filter: AbstractFilter<EncryptedContact>): Promise<Array<string>>;

	deleteContact(entityId: string): Promise<DocIdentifier>;

	deleteContacts(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	findContactsDelegationsStubsByHcPartyPatientForeignKeys(hcPartyId: string,
			secretPatientKeys: Array<string>): Promise<Array<IcureStub>>;

	getServiceCodesOccurrences(codeType: string,
			minOccurrences: number): Promise<Array<LabelledOccurence>>;

	shareWith(
			delegateId: string,
			contact: DecryptedContact,
			shareEncryptionKeys: ShareMetadataBehaviour,
			shareOwningEntityIds: ShareMetadataBehaviour,
			requestedPermission: RequestedPermission
	): Promise<SimpleShareResult<DecryptedContact>>;

	findContactsByHcPartyPatient(
			hcPartyId: string,
			patient: Patient,
			startDate: number | undefined,
			endDate: number | undefined,
			descending: boolean | undefined
	): Promise<PaginatedListIterator<DecryptedContact>>;

	modifyContact(entity: DecryptedContact): Promise<DecryptedContact>;

	modifyContacts(entities: Array<DecryptedContact>): Promise<Array<DecryptedContact>>;

	getContact(entityId: string): Promise<DecryptedContact>;

	getContacts(entityIds: Array<string>): Promise<Array<DecryptedContact>>;

	filterContactsBy(filterChain: FilterChain<EncryptedContact>, startDocumentId: string | undefined,
			limit: number | undefined): Promise<PaginatedList<DecryptedContact>>;

	listContactByHCPartyServiceId(hcPartyId: string,
			serviceId: string): Promise<Array<DecryptedContact>>;

	listContactsByExternalId(externalId: string): Promise<Array<DecryptedContact>>;

	listContactsByHCPartyAndFormId(hcPartyId: string,
			formId: string): Promise<Array<DecryptedContact>>;

	listContactsByHCPartyAndFormIds(hcPartyId: string,
			formIds: Array<string>): Promise<Array<DecryptedContact>>;

	listContactsByHCPartyAndPatientSecretFKeys(hcPartyId: string, secretPatientKeys: Array<string>,
			planOfActionsIds: string | undefined,
			skipClosedContacts: boolean | undefined): Promise<Array<DecryptedContact>>;

	closeForHCPartyPatientForeignKeys(hcPartyId: string,
			secretPatientKeys: Array<string>): Promise<Array<DecryptedContact>>;

	getService(serviceId: string): Promise<DecryptedService>;

	getServices(entityIds: Array<string>): Promise<Array<DecryptedService>>;

	getServicesLinkedTo(linkType: string, ids: Array<string>): Promise<Array<DecryptedService>>;

	listServicesByAssociationId(associationId: string): Promise<Array<DecryptedService>>;

	listServicesByHealthElementId(hcPartyId: string,
			healthElementId: string): Promise<Array<DecryptedService>>;

	findContactsByOpeningDate(
			startDate: number,
			endDate: number,
			hcPartyId: string,
			startKey: any | undefined,
			startDocumentId: string | undefined,
			limit: number | undefined
	): Promise<PaginatedList<DecryptedContact>>;

	filterServicesBy(filterChain: FilterChain<EncryptedService>, startDocumentId: string | undefined,
			limit: number | undefined): Promise<PaginatedList<DecryptedService>>;

}
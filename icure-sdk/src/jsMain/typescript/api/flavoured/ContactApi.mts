// auto-generated file
import {SecretIdOption} from '../../crypto/entities/SecretIdOption.mjs';
import {ShareMetadataBehaviour} from '../../crypto/entities/ShareMetadataBehaviour.mjs';
import {SimpleShareResult} from '../../crypto/entities/SimpleShareResult.mjs';
import {PaginatedListIterator} from '../../icure-sdk.mjs';
import {Contact, DecryptedContact, EncryptedContact} from '../../model/Contact.mjs';
import {IcureStub} from '../../model/IcureStub.mjs';
import {Patient} from '../../model/Patient.mjs';
import {User} from '../../model/User.mjs';
import {DocIdentifier} from '../../model/couchdb/DocIdentifier.mjs';
import {LabelledOccurence} from '../../model/data/LabelledOccurence.mjs';
import {AccessLevel} from '../../model/embed/AccessLevel.mjs';
import {EncryptedService, Service} from '../../model/embed/Service.mjs';
import {AbstractFilter} from '../../model/filter/AbstractFilter.mjs';
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

}

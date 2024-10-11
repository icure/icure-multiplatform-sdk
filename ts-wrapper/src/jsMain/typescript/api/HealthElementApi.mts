// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {HealthElementShareOptions} from '../crypto/entities/HealthElementShareOptions.mjs';
import {SecretIdUseOption} from '../crypto/entities/SecretIdUseOption.mjs';
import {DecryptedHealthElement, EncryptedHealthElement, HealthElement} from '../model/HealthElement.mjs';
import {IcureStub} from '../model/IcureStub.mjs';
import {IdWithMandatoryRev} from '../model/IdWithMandatoryRev.mjs';
import {Patient} from '../model/Patient.mjs';
import {User} from '../model/User.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';
import {AccessLevel} from '../model/embed/AccessLevel.mjs';
import {HexString} from '../model/specializations/HexString.mjs';
import {EntitySubscription} from '../subscription/EntitySubscription.mjs';
import {EntitySubscriptionConfiguration} from '../subscription/EntitySubscriptionConfiguration.mjs';
import {SubscriptionEventType} from '../subscription/SubscriptionEventType.mjs';
import {HealthElementFlavouredApi} from './HealthElementFlavouredApi.mjs';


export interface HealthElementApi {

	encrypted: HealthElementFlavouredApi<EncryptedHealthElement>;

	tryAndRecover: HealthElementFlavouredApi<HealthElement>;

	createHealthElement(entity: DecryptedHealthElement): Promise<DecryptedHealthElement>;

	createHealthElements(entities: Array<DecryptedHealthElement>): Promise<Array<DecryptedHealthElement>>;

	withEncryptionMetadata(base: DecryptedHealthElement | undefined, patient: Patient,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, secretId?: SecretIdUseOption }): Promise<DecryptedHealthElement>;

	getEncryptionKeysOf(healthElement: HealthElement): Promise<Array<HexString>>;

	hasWriteAccess(healthElement: HealthElement): Promise<boolean>;

	decryptPatientIdOf(healthElement: HealthElement): Promise<Array<string>>;

	createDelegationDeAnonymizationMetadata(entity: HealthElement,
			delegates: Array<string>): Promise<void>;

	decrypt(healthElement: EncryptedHealthElement): Promise<DecryptedHealthElement>;

	tryDecrypt(healthElement: EncryptedHealthElement): Promise<HealthElement>;

	matchHealthElementsBy(filter: FilterOptions<HealthElement>): Promise<Array<string>>;

	matchHealthElementsBySorted(filter: SortableFilterOptions<HealthElement>): Promise<Array<string>>;

	deleteHealthElementUnsafe(entityId: string): Promise<DocIdentifier>;

	deleteHealthElementsUnsafe(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	deleteHealthElementById(entityId: string, rev: string | undefined): Promise<DocIdentifier>;

	deleteHealthElementsByIds(entityIds: Array<IdWithMandatoryRev>): Promise<Array<DocIdentifier>>;

	purgeHealthElementById(id: string, rev: string): Promise<void>;

	deleteHealthElement(healthElement: HealthElement): Promise<DocIdentifier>;

	deleteHealthElements(healthElements: Array<HealthElement>): Promise<Array<DocIdentifier>>;

	purgeHealthElement(healthElement: HealthElement): Promise<void>;

	findHealthElementsDelegationsStubsByHcPartyPatientForeignKeys(hcPartyId: string,
			secretPatientKeys: Array<string>): Promise<Array<IcureStub>>;

	shareWith(delegateId: string, healthElement: DecryptedHealthElement,
			options?: { options?: HealthElementShareOptions | undefined }): Promise<DecryptedHealthElement>;

	shareWithMany(healthElement: DecryptedHealthElement,
			delegates: { [ key: string ]: HealthElementShareOptions }): Promise<DecryptedHealthElement>;

	findHealthElementsByHcPartyPatient(hcPartyId: string, patient: Patient,
			options?: { startDate?: number | undefined, endDate?: number | undefined, descending?: boolean | undefined }): Promise<PaginatedListIterator<DecryptedHealthElement>>;

	filterHealthElementsBy(filter: FilterOptions<HealthElement>): Promise<PaginatedListIterator<DecryptedHealthElement>>;

	filterHealthElementsBySorted(filter: SortableFilterOptions<HealthElement>): Promise<PaginatedListIterator<DecryptedHealthElement>>;

	undeleteHealthElementById(id: string, rev: string): Promise<DecryptedHealthElement>;

	undeleteHealthElement(healthElement: HealthElement): Promise<DecryptedHealthElement>;

	modifyHealthElement(entity: DecryptedHealthElement): Promise<DecryptedHealthElement>;

	modifyHealthElements(entities: Array<DecryptedHealthElement>): Promise<Array<DecryptedHealthElement>>;

	getHealthElement(entityId: string): Promise<DecryptedHealthElement>;

	getHealthElements(entityIds: Array<string>): Promise<Array<DecryptedHealthElement>>;

	findHealthElementsByHcPartyPatientForeignKeys(hcPartyId: string,
			secretPatientKeys: Array<string>): Promise<Array<DecryptedHealthElement>>;

	subscribeToEvents(events: Array<SubscriptionEventType>, filter: FilterOptions<HealthElement>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedHealthElement>>;

}

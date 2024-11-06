// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {EncryptedHealthElement, HealthElement} from '../model/HealthElement.mjs';
import {IcureStub} from '../model/IcureStub.mjs';
import {IdWithMandatoryRev} from '../model/IdWithMandatoryRev.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';
import {EntitySubscription} from '../subscription/EntitySubscription.mjs';
import {EntitySubscriptionConfiguration} from '../subscription/EntitySubscriptionConfiguration.mjs';
import {SubscriptionEventType} from '../subscription/SubscriptionEventType.mjs';


export interface HealthElementBasicApi {

	matchHealthElementsBy(filter: BaseFilterOptions<HealthElement>): Promise<Array<string>>;

	matchHealthElementsBySorted(filter: BaseSortableFilterOptions<HealthElement>): Promise<Array<string>>;

	filterHealthElementsBy(filter: BaseFilterOptions<HealthElement>): Promise<PaginatedListIterator<EncryptedHealthElement>>;

	filterHealthElementsBySorted(filter: BaseSortableFilterOptions<HealthElement>): Promise<PaginatedListIterator<EncryptedHealthElement>>;

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

	undeleteHealthElementById(id: string, rev: string): Promise<EncryptedHealthElement>;

	undeleteHealthElement(healthElement: HealthElement): Promise<EncryptedHealthElement>;

	modifyHealthElement(entity: EncryptedHealthElement): Promise<EncryptedHealthElement>;

	modifyHealthElements(entities: Array<EncryptedHealthElement>): Promise<Array<EncryptedHealthElement>>;

	getHealthElement(entityId: string): Promise<EncryptedHealthElement>;

	getHealthElements(entityIds: Array<string>): Promise<Array<EncryptedHealthElement>>;

	findHealthElementsByHcPartyPatientForeignKeys(hcPartyId: string,
			secretPatientKeys: Array<string>): Promise<Array<EncryptedHealthElement>>;

	subscribeToEvents(events: Array<SubscriptionEventType>, filter: BaseFilterOptions<HealthElement>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedHealthElement>>;

}

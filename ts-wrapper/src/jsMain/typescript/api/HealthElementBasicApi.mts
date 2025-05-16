// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {EncryptedHealthElement, HealthElement} from '../model/HealthElement.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {EntitySubscription} from '../subscription/EntitySubscription.mjs';
import {EntitySubscriptionConfiguration} from '../subscription/EntitySubscriptionConfiguration.mjs';
import {SubscriptionEventType} from '../subscription/SubscriptionEventType.mjs';
import {HealthElementBasicInGroupApi} from './HealthElementBasicInGroupApi.mjs';


export interface HealthElementBasicApi {

	inGroup: HealthElementBasicInGroupApi;

	matchHealthElementsBy(filter: BaseFilterOptions<HealthElement>): Promise<Array<string>>;

	matchHealthElementsBySorted(filter: BaseSortableFilterOptions<HealthElement>): Promise<Array<string>>;

	filterHealthElementsBy(filter: BaseFilterOptions<HealthElement>): Promise<PaginatedListIterator<EncryptedHealthElement>>;

	filterHealthElementsBySorted(filter: BaseSortableFilterOptions<HealthElement>): Promise<PaginatedListIterator<EncryptedHealthElement>>;

	deleteHealthElementUnsafe(entityId: string): Promise<StoredDocumentIdentifier>;

	deleteHealthElementsUnsafe(entityIds: Array<string>): Promise<Array<StoredDocumentIdentifier>>;

	deleteHealthElementById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	deleteHealthElementsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	purgeHealthElementById(id: string, rev: string): Promise<void>;

	deleteHealthElement(healthElement: HealthElement): Promise<StoredDocumentIdentifier>;

	deleteHealthElements(healthElements: Array<HealthElement>): Promise<Array<StoredDocumentIdentifier>>;

	purgeHealthElement(healthElement: HealthElement): Promise<void>;

	createHealthElement(entity: EncryptedHealthElement): Promise<EncryptedHealthElement>;

	createHealthElements(entities: Array<EncryptedHealthElement>): Promise<Array<EncryptedHealthElement>>;

	undeleteHealthElementById(id: string, rev: string): Promise<EncryptedHealthElement>;

	undeleteHealthElement(healthElement: HealthElement): Promise<EncryptedHealthElement>;

	modifyHealthElement(entity: EncryptedHealthElement): Promise<EncryptedHealthElement>;

	modifyHealthElements(entities: Array<EncryptedHealthElement>): Promise<Array<EncryptedHealthElement>>;

	getHealthElement(entityId: string): Promise<EncryptedHealthElement | undefined>;

	getHealthElements(entityIds: Array<string>): Promise<Array<EncryptedHealthElement>>;

	subscribeToEvents(events: Array<SubscriptionEventType>, filter: BaseFilterOptions<HealthElement>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedHealthElement>>;

}

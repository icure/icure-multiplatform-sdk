// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, FilterOptions, InternalMessageFiltersObj, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {Message} from '../model/Message.mjs';
import {Patient} from '../model/Patient.mjs';


interface MessageFiltersFactory {

	allMessagesForDataOwner(dataOwnerId: string): BaseFilterOptions<Message>;

	allMessagesForSelf(): FilterOptions<Message>;

	byTransportGuidForDataOwner(dataOwnerId: string,
			transportGuid: string): BaseSortableFilterOptions<Message>;

	byTransportGuidForSelf(transportGuid: string): SortableFilterOptions<Message>;

	fromAddressForDataOwner(dataOwnerId: string, address: string): BaseFilterOptions<Message>;

	fromAddressForSelf(address: string): FilterOptions<Message>;

	byPatientsSentDateForDataOwner(dataOwnerId: string, patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Message>;

	byPatientsSentDateForSelf(patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Message>;

	byPatientSecretIdsSentDateForDataOwner(dataOwnerId: string, secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): BaseSortableFilterOptions<Message>;

	byPatientSecretIdsSentDateForSelf(secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Message>;

	toAddressForDataOwner(dataOwnerId: string, address: string): BaseFilterOptions<Message>;

	toAddressForSelf(address: string): FilterOptions<Message>;

	byTransportGuidSentDateForDataOwner(
			dataOwnerId: string,
			transportGuid: string,
			from: number | undefined,
			to: number | undefined,
			options?: { descending?: boolean }
	): BaseSortableFilterOptions<Message>;

	byTransportGuidSentDateForSelf(transportGuid: string, from: number | undefined,
			to: number | undefined, options?: { descending?: boolean }): SortableFilterOptions<Message>;

	latestByTransportGuidForDataOwner(dataOwnerId: string,
			transportGuid: string): BaseFilterOptions<Message>;

	latestByTransportGuidForSelf(transportGuid: string): FilterOptions<Message>;

	byInvoiceIds(invoiceIds: Array<string>): BaseFilterOptions<Message>;

	byParentIds(parentIds: Array<string>): BaseFilterOptions<Message>;

	lifecycleBetweenForDataOwner(dataOwnerId: string, startTimestamp: number | undefined,
			endTimestamp: number | undefined, descending: boolean): BaseFilterOptions<Message>;

	lifecycleBetweenForDataOwnerInGroup(dataOwner: EntityReferenceInGroup,
			startTimestamp: number | undefined, endTimestamp: number | undefined,
			descending: boolean): BaseFilterOptions<Message>;

	lifecycleBetweenForSelf(startTimestamp: number | undefined, endTimestamp: number | undefined,
			descending: boolean): FilterOptions<Message>;

}

export const MessageFilters: MessageFiltersFactory = {
			allMessagesForDataOwner: (dataOwnerId) => InternalMessageFiltersObj.getInstance().allMessagesForDataOwner(dataOwnerId),
			allMessagesForSelf: () => InternalMessageFiltersObj.getInstance().allMessagesForSelf(),
			byTransportGuidForDataOwner: (dataOwnerId, transportGuid) => InternalMessageFiltersObj.getInstance().byTransportGuidForDataOwner(dataOwnerId, transportGuid),
			byTransportGuidForSelf: (transportGuid) => InternalMessageFiltersObj.getInstance().byTransportGuidForSelf(transportGuid),
			fromAddressForDataOwner: (dataOwnerId, address) => InternalMessageFiltersObj.getInstance().fromAddressForDataOwner(dataOwnerId, address),
			fromAddressForSelf: (address) => InternalMessageFiltersObj.getInstance().fromAddressForSelf(address),
			byPatientsSentDateForDataOwner: (dataOwnerId, patients, options) => InternalMessageFiltersObj.getInstance().byPatientsSentDateForDataOwner(dataOwnerId, patients, options),
			byPatientsSentDateForSelf: (patients, options) => InternalMessageFiltersObj.getInstance().byPatientsSentDateForSelf(patients, options),
			byPatientSecretIdsSentDateForDataOwner: (dataOwnerId, secretIds, options) => InternalMessageFiltersObj.getInstance().byPatientSecretIdsSentDateForDataOwner(dataOwnerId, secretIds, options),
			byPatientSecretIdsSentDateForSelf: (secretIds, options) => InternalMessageFiltersObj.getInstance().byPatientSecretIdsSentDateForSelf(secretIds, options),
			toAddressForDataOwner: (dataOwnerId, address) => InternalMessageFiltersObj.getInstance().toAddressForDataOwner(dataOwnerId, address),
			toAddressForSelf: (address) => InternalMessageFiltersObj.getInstance().toAddressForSelf(address),
			byTransportGuidSentDateForDataOwner: (dataOwnerId, transportGuid, from, to, options) => InternalMessageFiltersObj.getInstance().byTransportGuidSentDateForDataOwner(dataOwnerId, transportGuid, from, to, options),
			byTransportGuidSentDateForSelf: (transportGuid, from, to, options) => InternalMessageFiltersObj.getInstance().byTransportGuidSentDateForSelf(transportGuid, from, to, options),
			latestByTransportGuidForDataOwner: (dataOwnerId, transportGuid) => InternalMessageFiltersObj.getInstance().latestByTransportGuidForDataOwner(dataOwnerId, transportGuid),
			latestByTransportGuidForSelf: (transportGuid) => InternalMessageFiltersObj.getInstance().latestByTransportGuidForSelf(transportGuid),
			byInvoiceIds: (invoiceIds) => InternalMessageFiltersObj.getInstance().byInvoiceIds(invoiceIds),
			byParentIds: (parentIds) => InternalMessageFiltersObj.getInstance().byParentIds(parentIds),
			lifecycleBetweenForDataOwner: (dataOwnerId, startTimestamp, endTimestamp, descending) => InternalMessageFiltersObj.getInstance().lifecycleBetweenForDataOwner(dataOwnerId, startTimestamp, endTimestamp, descending),
			lifecycleBetweenForDataOwnerInGroup: (dataOwner, startTimestamp, endTimestamp, descending) => InternalMessageFiltersObj.getInstance().lifecycleBetweenForDataOwnerInGroup(dataOwner, startTimestamp, endTimestamp, descending),
			lifecycleBetweenForSelf: (startTimestamp, endTimestamp, descending) => InternalMessageFiltersObj.getInstance().lifecycleBetweenForSelf(startTimestamp, endTimestamp, descending)
		};

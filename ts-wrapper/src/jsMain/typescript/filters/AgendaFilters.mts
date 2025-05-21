// auto-generated file
import {BaseFilterOptions, InternalAgendaFiltersObj} from '../cardinal-sdk-ts.mjs';
import {Agenda} from '../model/Agenda.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';


interface AgendaFiltersFactory {

	all(): BaseFilterOptions<Agenda>;

	byUser(userId: string): BaseFilterOptions<Agenda>;

	byUserInGroup(userReference: EntityReferenceInGroup): BaseFilterOptions<Agenda>;

	readableByUser(userId: string): BaseFilterOptions<Agenda>;

	readableByUserInGroup(userReference: EntityReferenceInGroup): BaseFilterOptions<Agenda>;

	readableByUserRights(userId: string): BaseFilterOptions<Agenda>;

	readableByUserRightsInGroup(userReference: EntityReferenceInGroup): BaseFilterOptions<Agenda>;

	byStringProperty(propertyId: string, propertyValue: string): BaseFilterOptions<Agenda>;

	byBooleanProperty(propertyId: string, propertyValue: boolean): BaseFilterOptions<Agenda>;

	byLongProperty(propertyId: string, propertyValue: number): BaseFilterOptions<Agenda>;

	byDoubleProperty(propertyId: string, propertyValue: number): BaseFilterOptions<Agenda>;

	withProperty(propertyId: string): BaseFilterOptions<Agenda>;

}

export const AgendaFilters: AgendaFiltersFactory = {
			all: () => InternalAgendaFiltersObj.getInstance().all(),
			byUser: (userId) => InternalAgendaFiltersObj.getInstance().byUser(userId),
			byUserInGroup: (userReference) => InternalAgendaFiltersObj.getInstance().byUserInGroup(userReference),
			readableByUser: (userId) => InternalAgendaFiltersObj.getInstance().readableByUser(userId),
			readableByUserInGroup: (userReference) => InternalAgendaFiltersObj.getInstance().readableByUserInGroup(userReference),
			readableByUserRights: (userId) => InternalAgendaFiltersObj.getInstance().readableByUserRights(userId),
			readableByUserRightsInGroup: (userReference) => InternalAgendaFiltersObj.getInstance().readableByUserRightsInGroup(userReference),
			byStringProperty: (propertyId, propertyValue) => InternalAgendaFiltersObj.getInstance().byStringProperty(propertyId, propertyValue),
			byBooleanProperty: (propertyId, propertyValue) => InternalAgendaFiltersObj.getInstance().byBooleanProperty(propertyId, propertyValue),
			byLongProperty: (propertyId, propertyValue) => InternalAgendaFiltersObj.getInstance().byLongProperty(propertyId, propertyValue),
			byDoubleProperty: (propertyId, propertyValue) => InternalAgendaFiltersObj.getInstance().byDoubleProperty(propertyId, propertyValue),
			withProperty: (propertyId) => InternalAgendaFiltersObj.getInstance().withProperty(propertyId)
		};

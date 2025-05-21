// auto-generated file
import {BaseFilterOptions, InternalAgendaFiltersObj} from '../cardinal-sdk-ts.mjs';
import {Agenda} from '../model/Agenda.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';


interface AgendaFiltersFactory {

	all(): BaseFilterOptions<Agenda>;

	byUser(userId: string): BaseFilterOptions<Agenda>;

	byUser(userReference: EntityReferenceInGroup): BaseFilterOptions<Agenda>;

	readableByUser(userId: string): BaseFilterOptions<Agenda>;

	readableByUser(userReference: EntityReferenceInGroup): BaseFilterOptions<Agenda>;

	readableByUserRights(userId: string): BaseFilterOptions<Agenda>;

	readableByUserRights(userReference: EntityReferenceInGroup): BaseFilterOptions<Agenda>;

	byStringProperty(propertyId: string, propertyValue: string): BaseFilterOptions<Agenda>;

	byBooleanProperty(propertyId: string, propertyValue: boolean): BaseFilterOptions<Agenda>;

	byLongProperty(propertyId: string, propertyValue: number): BaseFilterOptions<Agenda>;

	byDoubleProperty(propertyId: string, propertyValue: number): BaseFilterOptions<Agenda>;

	withProperty(propertyId: string): BaseFilterOptions<Agenda>;

}

export const AgendaFilters: AgendaFiltersFactory = {
			all: () => InternalAgendaFiltersObj.getInstance().all(),
			byUser: (userId) => InternalAgendaFiltersObj.getInstance().byUser(userId),
			byUser: (userReference) => InternalAgendaFiltersObj.getInstance().byUser(userReference),
			readableByUser: (userId) => InternalAgendaFiltersObj.getInstance().readableByUser(userId),
			readableByUser: (userReference) => InternalAgendaFiltersObj.getInstance().readableByUser(userReference),
			readableByUserRights: (userId) => InternalAgendaFiltersObj.getInstance().readableByUserRights(userId),
			readableByUserRights: (userReference) => InternalAgendaFiltersObj.getInstance().readableByUserRights(userReference),
			byStringProperty: (propertyId, propertyValue) => InternalAgendaFiltersObj.getInstance().byStringProperty(propertyId, propertyValue),
			byBooleanProperty: (propertyId, propertyValue) => InternalAgendaFiltersObj.getInstance().byBooleanProperty(propertyId, propertyValue),
			byLongProperty: (propertyId, propertyValue) => InternalAgendaFiltersObj.getInstance().byLongProperty(propertyId, propertyValue),
			byDoubleProperty: (propertyId, propertyValue) => InternalAgendaFiltersObj.getInstance().byDoubleProperty(propertyId, propertyValue),
			withProperty: (propertyId) => InternalAgendaFiltersObj.getInstance().withProperty(propertyId)
		};

// auto-generated file
import {AnonymousMedicalLocation} from '../model/AnonymousMedicalLocation.mjs';
import {AppointmentTypeAndPlace} from '../model/AppointmentTypeAndPlace.mjs';
import {PaginatedList} from '../model/PaginatedList.mjs';
import {UserAndHealthcareParty} from '../model/UserAndHealthcareParty.mjs';


export interface AnonymousApi {

	listAppointmentTypesForUser(groupId: string, userId: string, startDate: number,
			endDate: number): Promise<Array<AppointmentTypeAndPlace>>;

	getAvailabilitiesByPeriodAndCalendarItemTypeId(
			groupId: string,
			userId: string,
			calendarItemTypeId: string,
			startDate: number,
			endDate: number,
			isNewPatient: boolean,
			placeId: string | undefined,
			limit: number | undefined
	): Promise<Array<number>>;

	listHealthcarePartiesInGroup(groupId: string): Promise<Array<UserAndHealthcareParty>>;

	getPublicMedicalLocationsByGroupId(groupId: string, startKey: string | undefined,
			startDocumentId: string | undefined,
			limit: number | undefined): Promise<PaginatedList<AnonymousMedicalLocation>>;

}

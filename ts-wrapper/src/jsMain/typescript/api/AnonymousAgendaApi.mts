// auto-generated file
import {PublicAgendasAndCalendarItemTypes} from '../model/PublicAgendasAndCalendarItemTypes.mjs';


export interface AnonymousAgendaApi {

	listAnonymousAgendaAndAppointmentTypes(groupId: string, propertyId: string,
			propertyValue: string): Promise<PublicAgendasAndCalendarItemTypes>;

	listAnonymousAvailabilities(
			groupId: string,
			agendaId: string,
			calendarItemTypeId: string,
			startDate: number,
			endDate: number,
			options?: { limit?: number | undefined }
	): Promise<Array<number>>;

}

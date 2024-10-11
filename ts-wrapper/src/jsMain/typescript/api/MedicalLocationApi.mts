// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {ListOfIds} from '../model/ListOfIds.mjs';
import {MedicalLocation} from '../model/MedicalLocation.mjs';
import {PaginatedList} from '../model/PaginatedList.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';


export interface MedicalLocationApi {

	createMedicalLocation(medicalLocationDto: MedicalLocation): Promise<MedicalLocation>;

	deleteMedicalLocations(locationIds: ListOfIds): Promise<Array<DocIdentifier>>;

	getMedicalLocation(locationId: string): Promise<MedicalLocation>;

	getAllMedicalLocations(startDocumentId: string | undefined,
			limit: number | undefined): Promise<PaginatedList<MedicalLocation>>;

	modifyMedicalLocation(medicalLocationDto: MedicalLocation): Promise<MedicalLocation>;

	getMedicalLocations(medicalLocationIds: Array<string>): Promise<Array<MedicalLocation>>;

	matchMedicalLocationsBy(filter: BaseFilterOptions<MedicalLocation>): Promise<Array<string>>;

	matchMedicalLocationsBySorted(filter: BaseSortableFilterOptions<MedicalLocation>): Promise<Array<string>>;

	filterMedicalLocationsBy(filter: BaseFilterOptions<MedicalLocation>): Promise<PaginatedListIterator<MedicalLocation>>;

	filterMedicalLocationsBySorted(filter: BaseSortableFilterOptions<MedicalLocation>): Promise<PaginatedListIterator<MedicalLocation>>;

}

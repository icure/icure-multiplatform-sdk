// auto-generated file
import {PaginatedList} from '../model/PaginatedList.mjs';
import {Place} from '../model/Place.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';


export interface PlaceApi {

	getPlace(placeId: string): Promise<Place>;

	createPlace(place: Place): Promise<Place>;

	modifyPlace(place: Place): Promise<Place>;

	deletePlaces(placeIds: Array<string>): Promise<Array<DocIdentifier>>;

	getPlaces(options?: { startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<Place>>;

}

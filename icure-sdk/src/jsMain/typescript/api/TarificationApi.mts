// auto-generated file
import {PaginatedList} from '../model/PaginatedList.mjs';
import {Tarification} from '../model/Tarification.mjs';


export interface TarificationApi {

	getTarification(tarificationId: string): Promise<Tarification>;

	createTarification(tarification: Tarification): Promise<Tarification>;

	getTarifications(tarificationIds: Array<string>): Promise<Array<Tarification>>;

	modifyTarification(tarification: Tarification): Promise<Tarification>;

	findTarificationsByLabel(options?: { region?: string | undefined, types?: string | undefined, language?: string | undefined, label?: string | undefined, startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<Tarification>>;

	findTarificationsBy(options?: { region?: string | undefined, type?: string | undefined, tarification?: string | undefined, version?: string | undefined, startDocumentId?: string | undefined, startKey?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<Tarification>>;

	getTarificationWithParts(type: string, tarification: string,
			version: string): Promise<Tarification>;

}

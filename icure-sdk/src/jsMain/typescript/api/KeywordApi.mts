// auto-generated file
import {Keyword} from '../model/Keyword.mjs';
import {PaginatedList} from '../model/PaginatedList.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';


export interface KeywordApi {

	getKeyword(frontEndMigrationId: string): Promise<Keyword>;

	createKeyword(frontEndMigration: Keyword): Promise<Keyword>;

	getKeywords(options?: { startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<Keyword>>;

	modifyKeyword(keyword: Keyword): Promise<Keyword>;

	getKeywordsByUser(userId: string): Promise<Array<Keyword>>;

	deleteKeywords(keywordIds: Array<string>): Promise<Array<DocIdentifier>>;

}

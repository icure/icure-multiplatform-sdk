// auto-generated file
import {BooleanResponse} from '../model/BooleanResponse.mjs';
import {Code} from '../model/Code.mjs';
import {PaginatedList} from '../model/PaginatedList.mjs';
import {AbstractFilter} from '../model/filter/AbstractFilter.mjs';
import {FilterChain} from '../model/filter/chain/FilterChain.mjs';


export interface CodeApi {

	findCodesByLabel(
			region: string | undefined,
			types: string,
			language: string,
			label: string,
			options?: { version?: string | undefined, startKey?: any | undefined, startDocumentId?: string | undefined, limit?: number | undefined }
	): Promise<PaginatedList<Code>>;

	findCodesByType(region: string,
			options?: { type?: string | undefined, code?: string | undefined, version?: string | undefined, startKey?: any | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<Code>>;

	findCodesByLink(linkType: string,
			options?: { linkedId?: string | undefined, startKey?: any | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<Code>>;

	listCodesByRegionTypeCodeVersion(region: string,
			options?: { type?: string | undefined, code?: string | undefined, version?: string | undefined }): Promise<Array<Code>>;

	listCodeTypesBy(options?: { region?: string | undefined, type?: string | undefined }): Promise<Array<string>>;

	listTagTypesBy(options?: { region?: string | undefined, type?: string | undefined }): Promise<Array<string>>;

	createCode(c: Code): Promise<Code>;

	createCodes(codeBatch: Array<Code>): Promise<Array<Code>>;

	isCodeValid(type: string, code: string, version: string | undefined): Promise<BooleanResponse>;

	getCodeByRegionLanguageTypeLabel(region: string, label: string, type: string,
			languages: string | undefined): Promise<Code>;

	getCodes(codeIds: Array<string>): Promise<Array<Code>>;

	getCode(codeId: string): Promise<Code>;

	getCodeWithParts(type: string, code: string, version: string): Promise<Code>;

	modifyCode(codeDto: Code): Promise<Code>;

	modifyCodes(codeBatch: Array<Code>): Promise<Array<Code>>;

	filterCodesBy(filterChain: FilterChain<Code>,
			options?: { startKey?: any | undefined, startDocumentId?: string | undefined, limit?: number | undefined, skip?: number | undefined, sort?: string | undefined, desc?: boolean | undefined }): Promise<PaginatedList<Code>>;

	matchCodesBy(filter: AbstractFilter<Code>): Promise<Array<string>>;

	importCodes(codeType: string): Promise<void>;

}

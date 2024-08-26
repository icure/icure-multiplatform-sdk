// auto-generated file
import {CryptoActorStubWithType} from '../model/CryptoActorStubWithType.mjs';
import {DataOwnerType} from '../model/DataOwnerType.mjs';
import {DataOwnerWithType} from '../model/DataOwnerWithType.mjs';


export interface DataOwnerApi {

	getCurrentDataOwner(): Promise<DataOwnerWithType>;

	getCurrentDataOwnerStub(): Promise<CryptoActorStubWithType>;

	getCurrentDataOwnerId(): Promise<string>;

	getCurrentDataOwnerHierarchyIds(): Promise<Array<string>>;

	getDataOwner(ownerId: string): Promise<DataOwnerWithType>;

	getCryptoActorStub(ownerId: string): Promise<CryptoActorStubWithType>;

	getCurrentDataOwnerHierarchyIdsFrom(parentId: string): Promise<Array<string>>;

	getCurrentDataOwnerHierarchy(): Promise<Array<DataOwnerWithType>>;

	modifyDataOwnerStub(cryptoActorStubWithTypeDto: CryptoActorStubWithType): Promise<CryptoActorStubWithType>;

	getCurrentDataOwnerType(): Promise<DataOwnerType>;

	clearCurrentDataOwnerIdsCache(): void;

}

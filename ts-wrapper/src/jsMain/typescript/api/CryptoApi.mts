// auto-generated file
import {ShamirKeysManagerApi} from './ShamirKeysManagerApi.mjs';


export interface CryptoApi {

	shamirKeysManager: ShamirKeysManagerApi;

	forceReload(): Promise<void>;

	currentDataOwnerKeys(filterTrustedKeys: boolean): Promise<{ [ key: string ]: { [ key: string ]: Int8Array } }>;

}

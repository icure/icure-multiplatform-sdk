// auto-generated file
import {Pkcs8Bytes} from '../model/specializations/Pkcs8Bytes.mjs';
import {ShamirKeysManagerApi} from './ShamirKeysManagerApi.mjs';


export interface CryptoApi {

	shamirKeysManager: ShamirKeysManagerApi;

	forceReload(): Promise<void>;

	currentDataOwnerKeys(options?: { filterTrustedKeys?: boolean }): Promise<{ [ key: string ]: { [ key: string ]: Pkcs8Bytes } }>;

}

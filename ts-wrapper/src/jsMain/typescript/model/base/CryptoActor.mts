// auto-generated file
import {DecryptedPropertyStub} from '../PropertyStub.mjs';
import {HexString} from '../specializations/HexString.mjs';
import {SpkiHexString} from '../specializations/SpkiHexString.mjs';
import {Versionable} from './Versionable.mjs';


export interface CryptoActor extends Versionable<string> {

	hcPartyKeys: { [ key: string ]: Array<HexString> };

	aesExchangeKeys: { [ key: string ]: { [ key: string ]: { [ key: string ]: HexString } } };

	transferKeys: { [ key: string ]: { [ key: string ]: HexString } };

	privateKeyShamirPartitions: { [ key: string ]: HexString };

	publicKey: SpkiHexString | undefined;

	publicKeysForOaepWithSha256: Array<SpkiHexString>;

	parentId: string | undefined;

	cryptoActorProperties: Array<DecryptedPropertyStub> | undefined;

	readonly $ktClass: string;

}

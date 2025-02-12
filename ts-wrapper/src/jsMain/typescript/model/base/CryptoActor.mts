// auto-generated file
import {HexString} from '../specializations/HexString.mjs';
import {SpkiHexString} from '../specializations/SpkiHexString.mjs';
import {HasTags} from './HasTags.mjs';
import {Versionable} from './Versionable.mjs';


export interface CryptoActor extends Versionable<string>, HasTags {

	hcPartyKeys: { [ key: string ]: Array<HexString> };

	aesExchangeKeys: { [ key: string ]: { [ key: string ]: { [ key: string ]: HexString } } };

	transferKeys: { [ key: string ]: { [ key: string ]: HexString } };

	privateKeyShamirPartitions: { [ key: string ]: HexString };

	publicKey: SpkiHexString | undefined;

	publicKeysForOaepWithSha256: Array<SpkiHexString>;

	parentId: string | undefined;

	readonly $ktClass: string;

}

// auto-generated file
import {randomUuid} from '../utils/Id.mjs';
import {DecryptedPropertyStub} from './PropertyStub.mjs';
import {CodeStub} from './base/CodeStub.mjs';
import {CryptoActor} from './base/CryptoActor.mjs';
import {HasTags} from './base/HasTags.mjs';
import {Versionable} from './base/Versionable.mjs';
import {HexString} from './specializations/HexString.mjs';
import {SpkiHexString} from './specializations/SpkiHexString.mjs';


export class CryptoActorStub implements Versionable<string>, CryptoActor, HasTags {

	id: string;

	rev: string;

	hcPartyKeys: { [ key: string ]: Array<HexString> } = {};

	aesExchangeKeys: { [ key: string ]: { [ key: string ]: { [ key: string ]: HexString } } } = {};

	transferKeys: { [ key: string ]: { [ key: string ]: HexString } } = {};

	privateKeyShamirPartitions: { [ key: string ]: HexString } = {};

	publicKey: SpkiHexString | undefined = undefined;

	publicKeysForOaepWithSha256: Array<SpkiHexString>;

	tags: Array<CodeStub> = [];

	parentId: string | undefined = undefined;

	cryptoActorProperties: Array<DecryptedPropertyStub> | undefined = undefined;

	readonly $ktClass: 'com.icure.cardinal.sdk.model.CryptoActorStub' = 'com.icure.cardinal.sdk.model.CryptoActorStub';

	constructor(partial: Partial<CryptoActorStub> & Pick<CryptoActorStub, "rev" | "publicKeysForOaepWithSha256">) {
		this.id = partial.id ?? randomUuid();
		this.rev = partial.rev;
		if ('hcPartyKeys' in partial && partial.hcPartyKeys !== undefined) this.hcPartyKeys = partial.hcPartyKeys;
		if ('aesExchangeKeys' in partial && partial.aesExchangeKeys !== undefined) this.aesExchangeKeys = partial.aesExchangeKeys;
		if ('transferKeys' in partial && partial.transferKeys !== undefined) this.transferKeys = partial.transferKeys;
		if ('privateKeyShamirPartitions' in partial && partial.privateKeyShamirPartitions !== undefined) this.privateKeyShamirPartitions = partial.privateKeyShamirPartitions;
		if ('publicKey' in partial) this.publicKey = partial.publicKey;
		this.publicKeysForOaepWithSha256 = partial.publicKeysForOaepWithSha256;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('parentId' in partial) this.parentId = partial.parentId;
		if ('cryptoActorProperties' in partial) this.cryptoActorProperties = partial.cryptoActorProperties;
	}

}

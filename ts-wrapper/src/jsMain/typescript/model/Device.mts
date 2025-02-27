// auto-generated file
import {randomUuid} from '../utils/Id.mjs';
import {DecryptedPropertyStub} from './PropertyStub.mjs';
import {CodeStub} from './base/CodeStub.mjs';
import {CryptoActor} from './base/CryptoActor.mjs';
import {DataOwner} from './base/DataOwner.mjs';
import {ICureDocument} from './base/ICureDocument.mjs';
import {Identifier} from './base/Identifier.mjs';
import {Named} from './base/Named.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {HexString} from './specializations/HexString.mjs';
import {SpkiHexString} from './specializations/SpkiHexString.mjs';


export class Device implements StoredDocument, ICureDocument<string>, Named, CryptoActor, DataOwner {

	id: string;

	rev: string | undefined = undefined;

	deletionDate: number | undefined = undefined;

	identifiers: Array<Identifier> = [];

	created: number | undefined = undefined;

	modified: number | undefined = undefined;

	author: string | undefined = undefined;

	responsible: string | undefined = undefined;

	tags: Array<CodeStub> = [];

	codes: Array<CodeStub> = [];

	endOfLife: number | undefined = undefined;

	medicalLocationId: string | undefined = undefined;

	externalId: string | undefined = undefined;

	name: string | undefined = undefined;

	type: string | undefined = undefined;

	brand: string | undefined = undefined;

	model: string | undefined = undefined;

	serialNumber: string | undefined = undefined;

	parentId: string | undefined = undefined;

	picture: Int8Array | undefined = undefined;

	properties: Array<DecryptedPropertyStub> = [];

	hcPartyKeys: { [ key: string ]: Array<HexString> } = {};

	aesExchangeKeys: { [ key: string ]: { [ key: string ]: { [ key: string ]: HexString } } } = {};

	transferKeys: { [ key: string ]: { [ key: string ]: HexString } } = {};

	privateKeyShamirPartitions: { [ key: string ]: HexString } = {};

	publicKey: SpkiHexString | undefined = undefined;

	publicKeysForOaepWithSha256: Array<SpkiHexString> = [];

	cryptoActorProperties: Array<DecryptedPropertyStub> | undefined = undefined;

	readonly $ktClass: 'com.icure.cardinal.sdk.model.Device' = 'com.icure.cardinal.sdk.model.Device';

	constructor(partial: Partial<Device>) {
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('identifiers' in partial && partial.identifiers !== undefined) this.identifiers = partial.identifiers;
		if ('created' in partial) this.created = partial.created;
		if ('modified' in partial) this.modified = partial.modified;
		if ('author' in partial) this.author = partial.author;
		if ('responsible' in partial) this.responsible = partial.responsible;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
		if ('medicalLocationId' in partial) this.medicalLocationId = partial.medicalLocationId;
		if ('externalId' in partial) this.externalId = partial.externalId;
		if ('name' in partial) this.name = partial.name;
		if ('type' in partial) this.type = partial.type;
		if ('brand' in partial) this.brand = partial.brand;
		if ('model' in partial) this.model = partial.model;
		if ('serialNumber' in partial) this.serialNumber = partial.serialNumber;
		if ('parentId' in partial) this.parentId = partial.parentId;
		if ('picture' in partial) this.picture = partial.picture;
		if ('properties' in partial && partial.properties !== undefined) this.properties = partial.properties;
		if ('hcPartyKeys' in partial && partial.hcPartyKeys !== undefined) this.hcPartyKeys = partial.hcPartyKeys;
		if ('aesExchangeKeys' in partial && partial.aesExchangeKeys !== undefined) this.aesExchangeKeys = partial.aesExchangeKeys;
		if ('transferKeys' in partial && partial.transferKeys !== undefined) this.transferKeys = partial.transferKeys;
		if ('privateKeyShamirPartitions' in partial && partial.privateKeyShamirPartitions !== undefined) this.privateKeyShamirPartitions = partial.privateKeyShamirPartitions;
		if ('publicKey' in partial) this.publicKey = partial.publicKey;
		if ('publicKeysForOaepWithSha256' in partial && partial.publicKeysForOaepWithSha256 !== undefined) this.publicKeysForOaepWithSha256 = partial.publicKeysForOaepWithSha256;
		if ('cryptoActorProperties' in partial) this.cryptoActorProperties = partial.cryptoActorProperties;
	}

}

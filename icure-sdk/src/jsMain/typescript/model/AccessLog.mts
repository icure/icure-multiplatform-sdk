// auto-generated file
import {randomUuid} from '../utils/Id.mjs';
import {CodeStub} from './base/CodeStub.mjs';
import {HasEncryptionMetadata} from './base/HasEncryptionMetadata.mjs';
import {ICureDocument} from './base/ICureDocument.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {Delegation} from './embed/Delegation.mjs';
import {Encryptable} from './embed/Encryptable.mjs';
import {SecurityMetadata} from './embed/SecurityMetadata.mjs';
import {Base64String} from './specializations/Base64String.mjs';


export interface AccessLog extends StoredDocument, ICureDocument<string>, HasEncryptionMetadata, Encryptable {

  objectId: string | undefined;

  accessType: string | undefined;

  user: string | undefined;

  detail: string | undefined;

  date: number | undefined;

  patientId: string | undefined;

  readonly isEncrypted: boolean;

}

export class DecryptedAccessLog {

  id: string;

  rev: string | undefined = undefined;

  created: number | undefined = undefined;

  modified: number | undefined = undefined;

  author: string | undefined = undefined;

  responsible: string | undefined = undefined;

  medicalLocationId: string | undefined = undefined;

  tags: Array<CodeStub> = [];

  codes: Array<CodeStub> = [];

  endOfLife: number | undefined = undefined;

  deletionDate: number | undefined = undefined;

  objectId: string | undefined = undefined;

  accessType: string | undefined = undefined;

  user: string | undefined = undefined;

  detail: string | undefined = undefined;

  date: number | undefined = undefined;

  patientId: string | undefined = undefined;

  secretForeignKeys: Array<string> = [];

  cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

  delegations: { [ key: string ]: Array<Delegation> } = {};

  encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

  encryptedSelf: Base64String | undefined = undefined;

  securityMetadata: SecurityMetadata | undefined = undefined;

  readonly isEncrypted: false = false;

  readonly $ktClass: 'com.icure.sdk.model.DecryptedAccessLog' = 'com.icure.sdk.model.DecryptedAccessLog';

  constructor(partial: Partial<DecryptedAccessLog>) {
    if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
    this.id = partial.id ?? randomUuid();
    if ('rev' in partial) this.rev = partial.rev;
    if ('created' in partial) this.created = partial.created;
    if ('modified' in partial) this.modified = partial.modified;
    if ('author' in partial) this.author = partial.author;
    if ('responsible' in partial) this.responsible = partial.responsible;
    if ('medicalLocationId' in partial) this.medicalLocationId = partial.medicalLocationId;
    if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
    if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
    if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
    if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
    if ('objectId' in partial) this.objectId = partial.objectId;
    if ('accessType' in partial) this.accessType = partial.accessType;
    if ('user' in partial) this.user = partial.user;
    if ('detail' in partial) this.detail = partial.detail;
    if ('date' in partial) this.date = partial.date;
    if ('patientId' in partial) this.patientId = partial.patientId;
    if ('secretForeignKeys' in partial && partial.secretForeignKeys !== undefined) this.secretForeignKeys = partial.secretForeignKeys;
    if ('cryptedForeignKeys' in partial && partial.cryptedForeignKeys !== undefined) this.cryptedForeignKeys = partial.cryptedForeignKeys;
    if ('delegations' in partial && partial.delegations !== undefined) this.delegations = partial.delegations;
    if ('encryptionKeys' in partial && partial.encryptionKeys !== undefined) this.encryptionKeys = partial.encryptionKeys;
    if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
    if ('securityMetadata' in partial) this.securityMetadata = partial.securityMetadata;
  }

}

export class EncryptedAccessLog {

  id: string;

  rev: string | undefined = undefined;

  created: number | undefined = undefined;

  modified: number | undefined = undefined;

  author: string | undefined = undefined;

  responsible: string | undefined = undefined;

  medicalLocationId: string | undefined = undefined;

  tags: Array<CodeStub> = [];

  codes: Array<CodeStub> = [];

  endOfLife: number | undefined = undefined;

  deletionDate: number | undefined = undefined;

  objectId: string | undefined = undefined;

  accessType: string | undefined = undefined;

  user: string | undefined = undefined;

  detail: string | undefined = undefined;

  date: number | undefined = undefined;

  patientId: string | undefined = undefined;

  secretForeignKeys: Array<string> = [];

  cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

  delegations: { [ key: string ]: Array<Delegation> } = {};

  encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

  encryptedSelf: Base64String | undefined = undefined;

  securityMetadata: SecurityMetadata | undefined = undefined;

  readonly isEncrypted: true = true;

  readonly $ktClass: 'com.icure.sdk.model.EncryptedAccessLog' = 'com.icure.sdk.model.EncryptedAccessLog';

  constructor(partial: Partial<EncryptedAccessLog>) {
    if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
    this.id = partial.id ?? randomUuid();
    if ('rev' in partial) this.rev = partial.rev;
    if ('created' in partial) this.created = partial.created;
    if ('modified' in partial) this.modified = partial.modified;
    if ('author' in partial) this.author = partial.author;
    if ('responsible' in partial) this.responsible = partial.responsible;
    if ('medicalLocationId' in partial) this.medicalLocationId = partial.medicalLocationId;
    if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
    if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
    if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
    if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
    if ('objectId' in partial) this.objectId = partial.objectId;
    if ('accessType' in partial) this.accessType = partial.accessType;
    if ('user' in partial) this.user = partial.user;
    if ('detail' in partial) this.detail = partial.detail;
    if ('date' in partial) this.date = partial.date;
    if ('patientId' in partial) this.patientId = partial.patientId;
    if ('secretForeignKeys' in partial && partial.secretForeignKeys !== undefined) this.secretForeignKeys = partial.secretForeignKeys;
    if ('cryptedForeignKeys' in partial && partial.cryptedForeignKeys !== undefined) this.cryptedForeignKeys = partial.cryptedForeignKeys;
    if ('delegations' in partial && partial.delegations !== undefined) this.delegations = partial.delegations;
    if ('encryptionKeys' in partial && partial.encryptionKeys !== undefined) this.encryptionKeys = partial.encryptionKeys;
    if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
    if ('securityMetadata' in partial) this.securityMetadata = partial.securityMetadata;
  }

}

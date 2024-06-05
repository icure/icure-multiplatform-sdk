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


export interface Form extends StoredDocument, ICureDocument<string>, HasEncryptionMetadata, Encryptable {

  openingDate: number | undefined;

  status: string | undefined;

  version: number | undefined;

  logicalUuid: string | undefined;

  descr: string | undefined;

  uniqueId: string | undefined;

  formTemplateId: string | undefined;

  contactId: string | undefined;

  healthElementId: string | undefined;

  planOfActionId: string | undefined;

  parent: string | undefined;

  readonly isEncrypted: boolean;

}

export class DecryptedForm {

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

  openingDate: number | undefined = undefined;

  status: string | undefined = undefined;

  version: number | undefined = undefined;

  logicalUuid: string | undefined = undefined;

  descr: string | undefined = undefined;

  uniqueId: string | undefined = undefined;

  formTemplateId: string | undefined = undefined;

  contactId: string | undefined = undefined;

  healthElementId: string | undefined = undefined;

  planOfActionId: string | undefined = undefined;

  parent: string | undefined = undefined;

  secretForeignKeys: Array<string> = [];

  cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

  delegations: { [ key: string ]: Array<Delegation> } = {};

  encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

  encryptedSelf: Base64String | undefined = undefined;

  securityMetadata: SecurityMetadata | undefined = undefined;

  readonly isEncrypted: false = false;

  readonly $ktClass: 'com.icure.sdk.model.DecryptedForm' = 'com.icure.sdk.model.DecryptedForm';

  constructor(partial: Partial<DecryptedForm>) {
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
    if ('openingDate' in partial) this.openingDate = partial.openingDate;
    if ('status' in partial) this.status = partial.status;
    if ('version' in partial) this.version = partial.version;
    if ('logicalUuid' in partial) this.logicalUuid = partial.logicalUuid;
    if ('descr' in partial) this.descr = partial.descr;
    if ('uniqueId' in partial) this.uniqueId = partial.uniqueId;
    if ('formTemplateId' in partial) this.formTemplateId = partial.formTemplateId;
    if ('contactId' in partial) this.contactId = partial.contactId;
    if ('healthElementId' in partial) this.healthElementId = partial.healthElementId;
    if ('planOfActionId' in partial) this.planOfActionId = partial.planOfActionId;
    if ('parent' in partial) this.parent = partial.parent;
    if ('secretForeignKeys' in partial && partial.secretForeignKeys !== undefined) this.secretForeignKeys = partial.secretForeignKeys;
    if ('cryptedForeignKeys' in partial && partial.cryptedForeignKeys !== undefined) this.cryptedForeignKeys = partial.cryptedForeignKeys;
    if ('delegations' in partial && partial.delegations !== undefined) this.delegations = partial.delegations;
    if ('encryptionKeys' in partial && partial.encryptionKeys !== undefined) this.encryptionKeys = partial.encryptionKeys;
    if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
    if ('securityMetadata' in partial) this.securityMetadata = partial.securityMetadata;
  }

}

export class EncryptedForm {

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

  openingDate: number | undefined = undefined;

  status: string | undefined = undefined;

  version: number | undefined = undefined;

  logicalUuid: string | undefined = undefined;

  descr: string | undefined = undefined;

  uniqueId: string | undefined = undefined;

  formTemplateId: string | undefined = undefined;

  contactId: string | undefined = undefined;

  healthElementId: string | undefined = undefined;

  planOfActionId: string | undefined = undefined;

  parent: string | undefined = undefined;

  secretForeignKeys: Array<string> = [];

  cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

  delegations: { [ key: string ]: Array<Delegation> } = {};

  encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

  encryptedSelf: Base64String | undefined = undefined;

  securityMetadata: SecurityMetadata | undefined = undefined;

  readonly isEncrypted: true = true;

  readonly $ktClass: 'com.icure.sdk.model.EncryptedForm' = 'com.icure.sdk.model.EncryptedForm';

  constructor(partial: Partial<EncryptedForm>) {
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
    if ('openingDate' in partial) this.openingDate = partial.openingDate;
    if ('status' in partial) this.status = partial.status;
    if ('version' in partial) this.version = partial.version;
    if ('logicalUuid' in partial) this.logicalUuid = partial.logicalUuid;
    if ('descr' in partial) this.descr = partial.descr;
    if ('uniqueId' in partial) this.uniqueId = partial.uniqueId;
    if ('formTemplateId' in partial) this.formTemplateId = partial.formTemplateId;
    if ('contactId' in partial) this.contactId = partial.contactId;
    if ('healthElementId' in partial) this.healthElementId = partial.healthElementId;
    if ('planOfActionId' in partial) this.planOfActionId = partial.planOfActionId;
    if ('parent' in partial) this.parent = partial.parent;
    if ('secretForeignKeys' in partial && partial.secretForeignKeys !== undefined) this.secretForeignKeys = partial.secretForeignKeys;
    if ('cryptedForeignKeys' in partial && partial.cryptedForeignKeys !== undefined) this.cryptedForeignKeys = partial.cryptedForeignKeys;
    if ('delegations' in partial && partial.delegations !== undefined) this.delegations = partial.delegations;
    if ('encryptionKeys' in partial && partial.encryptionKeys !== undefined) this.encryptionKeys = partial.encryptionKeys;
    if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
    if ('securityMetadata' in partial) this.securityMetadata = partial.securityMetadata;
  }

}

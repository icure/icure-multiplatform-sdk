// auto-generated file
import {randomUuid} from '../utils/Id.mjs';
import {TopicRole} from './TopicRole.mjs';
import {CodeStub} from './base/CodeStub.mjs';
import {HasEncryptionMetadata} from './base/HasEncryptionMetadata.mjs';
import {ICureDocument} from './base/ICureDocument.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {Delegation} from './embed/Delegation.mjs';
import {Encryptable} from './embed/Encryptable.mjs';
import {SecurityMetadata} from './embed/SecurityMetadata.mjs';
import {Base64String} from './specializations/Base64String.mjs';


export interface Topic extends StoredDocument, ICureDocument<string>, HasEncryptionMetadata, Encryptable {

  healthElementId: string | undefined;

  contactId: string | undefined;

  description: string | undefined;

  activeParticipants: { [ key: string ]: TopicRole };

  linkedHealthElements: Array<string>;

  linkedServices: Array<string>;

  readonly isEncrypted: boolean;

}

export class DecryptedTopic {

  id: string;

  rev: string | undefined = undefined;

  created: number | undefined = undefined;

  modified: number | undefined = undefined;

  healthElementId: string | undefined = undefined;

  contactId: string | undefined = undefined;

  description: string | undefined = undefined;

  codes: Array<CodeStub> = [];

  tags: Array<CodeStub> = [];

  author: string | undefined = undefined;

  responsible: string | undefined = undefined;

  medicalLocationId: string | undefined = undefined;

  endOfLife: number | undefined = undefined;

  deletionDate: number | undefined = undefined;

  activeParticipants: { [ key: string ]: TopicRole } = {};

  securityMetadata: SecurityMetadata | undefined = undefined;

  secretForeignKeys: Array<string> = [];

  cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

  delegations: { [ key: string ]: Array<Delegation> } = {};

  encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

  encryptedSelf: Base64String | undefined = undefined;

  linkedHealthElements: Array<string> = [];

  linkedServices: Array<string> = [];

  readonly isEncrypted: false = false;

  readonly $ktClass: 'com.icure.sdk.model.DecryptedTopic' = 'com.icure.sdk.model.DecryptedTopic';

  constructor(partial: Partial<DecryptedTopic>) {
    if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
    this.id = partial.id ?? randomUuid();
    if ('rev' in partial) this.rev = partial.rev;
    if ('created' in partial) this.created = partial.created;
    if ('modified' in partial) this.modified = partial.modified;
    if ('healthElementId' in partial) this.healthElementId = partial.healthElementId;
    if ('contactId' in partial) this.contactId = partial.contactId;
    if ('description' in partial) this.description = partial.description;
    if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
    if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
    if ('author' in partial) this.author = partial.author;
    if ('responsible' in partial) this.responsible = partial.responsible;
    if ('medicalLocationId' in partial) this.medicalLocationId = partial.medicalLocationId;
    if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
    if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
    if ('activeParticipants' in partial && partial.activeParticipants !== undefined) this.activeParticipants = partial.activeParticipants;
    if ('securityMetadata' in partial) this.securityMetadata = partial.securityMetadata;
    if ('secretForeignKeys' in partial && partial.secretForeignKeys !== undefined) this.secretForeignKeys = partial.secretForeignKeys;
    if ('cryptedForeignKeys' in partial && partial.cryptedForeignKeys !== undefined) this.cryptedForeignKeys = partial.cryptedForeignKeys;
    if ('delegations' in partial && partial.delegations !== undefined) this.delegations = partial.delegations;
    if ('encryptionKeys' in partial && partial.encryptionKeys !== undefined) this.encryptionKeys = partial.encryptionKeys;
    if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
    if ('linkedHealthElements' in partial && partial.linkedHealthElements !== undefined) this.linkedHealthElements = partial.linkedHealthElements;
    if ('linkedServices' in partial && partial.linkedServices !== undefined) this.linkedServices = partial.linkedServices;
  }

}

export class EncryptedTopic {

  id: string;

  rev: string | undefined = undefined;

  created: number | undefined = undefined;

  modified: number | undefined = undefined;

  healthElementId: string | undefined = undefined;

  contactId: string | undefined = undefined;

  description: string | undefined = undefined;

  codes: Array<CodeStub> = [];

  tags: Array<CodeStub> = [];

  author: string | undefined = undefined;

  responsible: string | undefined = undefined;

  medicalLocationId: string | undefined = undefined;

  endOfLife: number | undefined = undefined;

  deletionDate: number | undefined = undefined;

  activeParticipants: { [ key: string ]: TopicRole } = {};

  securityMetadata: SecurityMetadata | undefined = undefined;

  secretForeignKeys: Array<string> = [];

  cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

  delegations: { [ key: string ]: Array<Delegation> } = {};

  encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

  encryptedSelf: Base64String | undefined = undefined;

  linkedHealthElements: Array<string> = [];

  linkedServices: Array<string> = [];

  readonly isEncrypted: true = true;

  readonly $ktClass: 'com.icure.sdk.model.EncryptedTopic' = 'com.icure.sdk.model.EncryptedTopic';

  constructor(partial: Partial<EncryptedTopic>) {
    if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
    this.id = partial.id ?? randomUuid();
    if ('rev' in partial) this.rev = partial.rev;
    if ('created' in partial) this.created = partial.created;
    if ('modified' in partial) this.modified = partial.modified;
    if ('healthElementId' in partial) this.healthElementId = partial.healthElementId;
    if ('contactId' in partial) this.contactId = partial.contactId;
    if ('description' in partial) this.description = partial.description;
    if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
    if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
    if ('author' in partial) this.author = partial.author;
    if ('responsible' in partial) this.responsible = partial.responsible;
    if ('medicalLocationId' in partial) this.medicalLocationId = partial.medicalLocationId;
    if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
    if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
    if ('activeParticipants' in partial && partial.activeParticipants !== undefined) this.activeParticipants = partial.activeParticipants;
    if ('securityMetadata' in partial) this.securityMetadata = partial.securityMetadata;
    if ('secretForeignKeys' in partial && partial.secretForeignKeys !== undefined) this.secretForeignKeys = partial.secretForeignKeys;
    if ('cryptedForeignKeys' in partial && partial.cryptedForeignKeys !== undefined) this.cryptedForeignKeys = partial.cryptedForeignKeys;
    if ('delegations' in partial && partial.delegations !== undefined) this.delegations = partial.delegations;
    if ('encryptionKeys' in partial && partial.encryptionKeys !== undefined) this.encryptionKeys = partial.encryptionKeys;
    if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
    if ('linkedHealthElements' in partial && partial.linkedHealthElements !== undefined) this.linkedHealthElements = partial.linkedHealthElements;
    if ('linkedServices' in partial && partial.linkedServices !== undefined) this.linkedServices = partial.linkedServices;
  }

}

// auto-generated file
import {randomUuid} from '../utils/Id.mjs';
import {CodeStub} from './base/CodeStub.mjs';
import {HasEncryptionMetadata} from './base/HasEncryptionMetadata.mjs';
import {ICureDocument} from './base/ICureDocument.mjs';
import {Identifier} from './base/Identifier.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {Annotation} from './embed/Annotation.mjs';
import {Delegation} from './embed/Delegation.mjs';
import {Encryptable} from './embed/Encryptable.mjs';
import {SecurityMetadata} from './embed/SecurityMetadata.mjs';
import {DecryptedService, EncryptedService, Service} from './embed/Service.mjs';
import {DecryptedSubContact, EncryptedSubContact, SubContact} from './embed/SubContact.mjs';
import {Base64String} from './specializations/Base64String.mjs';


export interface Contact extends StoredDocument, ICureDocument<string>, HasEncryptionMetadata, Encryptable {

  identifier: Array<Identifier>;

  groupId: string | undefined;

  openingDate: number | undefined;

  closingDate: number | undefined;

  descr: string | undefined;

  location: string | undefined;

  externalId: string | undefined;

  encounterType: CodeStub | undefined;

  subContacts: Array<SubContact>;

  services: Array<Service>;

  healthcarePartyId: string | undefined;

  modifiedContactId: string | undefined;

  notes: Array<Annotation>;

  readonly isEncrypted: boolean;

}

export class DecryptedContact {

  id: string;

  rev: string | undefined = undefined;

  created: number | undefined = undefined;

  modified: number | undefined = undefined;

  author: string | undefined = undefined;

  responsible: string | undefined = undefined;

  medicalLocationId: string | undefined = undefined;

  tags: Array<CodeStub> = [];

  codes: Array<CodeStub> = [];

  identifier: Array<Identifier> = [];

  endOfLife: number | undefined = undefined;

  deletionDate: number | undefined = undefined;

  groupId: string | undefined = undefined;

  openingDate: number | undefined = undefined;

  closingDate: number | undefined = undefined;

  descr: string | undefined = undefined;

  location: string | undefined = undefined;

  externalId: string | undefined = undefined;

  encounterType: CodeStub | undefined = undefined;

  subContacts: Array<DecryptedSubContact> = [];

  services: Array<DecryptedService> = [];

  healthcarePartyId: string | undefined = undefined;

  modifiedContactId: string | undefined = undefined;

  secretForeignKeys: Array<string> = [];

  cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

  delegations: { [ key: string ]: Array<Delegation> } = {};

  encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

  encryptedSelf: Base64String | undefined = undefined;

  securityMetadata: SecurityMetadata | undefined = undefined;

  notes: Array<Annotation> = [];

  readonly isEncrypted: false = false;

  constructor(partial: Partial<DecryptedContact>) {
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
    if ('identifier' in partial && partial.identifier !== undefined) this.identifier = partial.identifier;
    if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
    if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
    if ('groupId' in partial) this.groupId = partial.groupId;
    if ('openingDate' in partial) this.openingDate = partial.openingDate;
    if ('closingDate' in partial) this.closingDate = partial.closingDate;
    if ('descr' in partial) this.descr = partial.descr;
    if ('location' in partial) this.location = partial.location;
    if ('externalId' in partial) this.externalId = partial.externalId;
    if ('encounterType' in partial) this.encounterType = partial.encounterType;
    if ('subContacts' in partial && partial.subContacts !== undefined) this.subContacts = partial.subContacts;
    if ('services' in partial && partial.services !== undefined) this.services = partial.services;
    if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
    if ('modifiedContactId' in partial) this.modifiedContactId = partial.modifiedContactId;
    if ('secretForeignKeys' in partial && partial.secretForeignKeys !== undefined) this.secretForeignKeys = partial.secretForeignKeys;
    if ('cryptedForeignKeys' in partial && partial.cryptedForeignKeys !== undefined) this.cryptedForeignKeys = partial.cryptedForeignKeys;
    if ('delegations' in partial && partial.delegations !== undefined) this.delegations = partial.delegations;
    if ('encryptionKeys' in partial && partial.encryptionKeys !== undefined) this.encryptionKeys = partial.encryptionKeys;
    if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
    if ('securityMetadata' in partial) this.securityMetadata = partial.securityMetadata;
    if ('notes' in partial && partial.notes !== undefined) this.notes = partial.notes;
  }

}

export class EncryptedContact {

  id: string;

  rev: string | undefined = undefined;

  created: number | undefined = undefined;

  modified: number | undefined = undefined;

  author: string | undefined = undefined;

  responsible: string | undefined = undefined;

  medicalLocationId: string | undefined = undefined;

  tags: Array<CodeStub> = [];

  codes: Array<CodeStub> = [];

  identifier: Array<Identifier> = [];

  endOfLife: number | undefined = undefined;

  deletionDate: number | undefined = undefined;

  groupId: string | undefined = undefined;

  openingDate: number | undefined = undefined;

  closingDate: number | undefined = undefined;

  descr: string | undefined = undefined;

  location: string | undefined = undefined;

  externalId: string | undefined = undefined;

  encounterType: CodeStub | undefined = undefined;

  subContacts: Array<EncryptedSubContact> = [];

  services: Array<EncryptedService> = [];

  healthcarePartyId: string | undefined = undefined;

  modifiedContactId: string | undefined = undefined;

  secretForeignKeys: Array<string> = [];

  cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

  delegations: { [ key: string ]: Array<Delegation> } = {};

  encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

  encryptedSelf: Base64String | undefined = undefined;

  securityMetadata: SecurityMetadata | undefined = undefined;

  notes: Array<Annotation> = [];

  readonly isEncrypted: true = true;

  constructor(partial: Partial<EncryptedContact>) {
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
    if ('identifier' in partial && partial.identifier !== undefined) this.identifier = partial.identifier;
    if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
    if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
    if ('groupId' in partial) this.groupId = partial.groupId;
    if ('openingDate' in partial) this.openingDate = partial.openingDate;
    if ('closingDate' in partial) this.closingDate = partial.closingDate;
    if ('descr' in partial) this.descr = partial.descr;
    if ('location' in partial) this.location = partial.location;
    if ('externalId' in partial) this.externalId = partial.externalId;
    if ('encounterType' in partial) this.encounterType = partial.encounterType;
    if ('subContacts' in partial && partial.subContacts !== undefined) this.subContacts = partial.subContacts;
    if ('services' in partial && partial.services !== undefined) this.services = partial.services;
    if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
    if ('modifiedContactId' in partial) this.modifiedContactId = partial.modifiedContactId;
    if ('secretForeignKeys' in partial && partial.secretForeignKeys !== undefined) this.secretForeignKeys = partial.secretForeignKeys;
    if ('cryptedForeignKeys' in partial && partial.cryptedForeignKeys !== undefined) this.cryptedForeignKeys = partial.cryptedForeignKeys;
    if ('delegations' in partial && partial.delegations !== undefined) this.delegations = partial.delegations;
    if ('encryptionKeys' in partial && partial.encryptionKeys !== undefined) this.encryptionKeys = partial.encryptionKeys;
    if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
    if ('securityMetadata' in partial) this.securityMetadata = partial.securityMetadata;
    if ('notes' in partial && partial.notes !== undefined) this.notes = partial.notes;
  }

}

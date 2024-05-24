// auto-generated file
import {randomUuid} from '../utils/Id.mjs';
import {CodeStub} from './base/CodeStub.mjs';
import {HasEncryptionMetadata} from './base/HasEncryptionMetadata.mjs';
import {ICureDocument} from './base/ICureDocument.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {DataAttachment} from './embed/DataAttachment.mjs';
import {Delegation} from './embed/Delegation.mjs';
import {DeletedAttachment} from './embed/DeletedAttachment.mjs';
import {DocumentLocation} from './embed/DocumentLocation.mjs';
import {DocumentStatus} from './embed/DocumentStatus.mjs';
import {DocumentType} from './embed/DocumentType.mjs';
import {Encryptable} from './embed/Encryptable.mjs';
import {SecurityMetadata} from './embed/SecurityMetadata.mjs';
import {Base64String} from './specializations/Base64String.mjs';


export interface Document extends StoredDocument, ICureDocument<string>, HasEncryptionMetadata, Encryptable {

  documentLocation: DocumentLocation | undefined;

  documentType: DocumentType | undefined;

  documentStatus: DocumentStatus | undefined;

  externalUri: string | undefined;

  name: string | undefined;

  version: string | undefined;

  storedICureDocumentId: string | undefined;

  externalUuid: string | undefined;

  size: number | undefined;

  hash: string | undefined;

  openingContactId: string | undefined;

  attachmentId: string | undefined;

  objectStoreReference: string | undefined;

  mainUti: string | undefined;

  otherUtis: Array<string>;

  secondaryAttachments: { [ key: string ]: DataAttachment };

  deletedAttachments: Array<DeletedAttachment>;

  encryptedAttachment: Int8Array | undefined;

  decryptedAttachment: Int8Array | undefined;

  readonly isEncrypted: boolean;

}

export class DecryptedDocument {

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

  documentLocation: DocumentLocation | undefined = undefined;

  documentType: DocumentType | undefined = undefined;

  documentStatus: DocumentStatus | undefined = undefined;

  externalUri: string | undefined = undefined;

  name: string | undefined = undefined;

  version: string | undefined = undefined;

  storedICureDocumentId: string | undefined = undefined;

  externalUuid: string | undefined = undefined;

  size: number | undefined = undefined;

  hash: string | undefined = undefined;

  openingContactId: string | undefined = undefined;

  attachmentId: string | undefined = undefined;

  objectStoreReference: string | undefined = undefined;

  mainUti: string | undefined = undefined;

  otherUtis: Array<string> = [];

  secondaryAttachments: { [ key: string ]: DataAttachment } = {};

  deletedAttachments: Array<DeletedAttachment> = [];

  encryptedAttachment: Int8Array | undefined = undefined;

  decryptedAttachment: Int8Array | undefined = undefined;

  secretForeignKeys: Array<string> = [];

  cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

  delegations: { [ key: string ]: Array<Delegation> } = {};

  encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

  encryptedSelf: Base64String | undefined = undefined;

  securityMetadata: SecurityMetadata | undefined = undefined;

  readonly isEncrypted: false = false;

  readonly $ktClass: 'com.icure.sdk.model.DecryptedDocument' = 'com.icure.sdk.model.DecryptedDocument';

  constructor(partial: Partial<DecryptedDocument>) {
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
    if ('documentLocation' in partial) this.documentLocation = partial.documentLocation;
    if ('documentType' in partial) this.documentType = partial.documentType;
    if ('documentStatus' in partial) this.documentStatus = partial.documentStatus;
    if ('externalUri' in partial) this.externalUri = partial.externalUri;
    if ('name' in partial) this.name = partial.name;
    if ('version' in partial) this.version = partial.version;
    if ('storedICureDocumentId' in partial) this.storedICureDocumentId = partial.storedICureDocumentId;
    if ('externalUuid' in partial) this.externalUuid = partial.externalUuid;
    if ('size' in partial) this.size = partial.size;
    if ('hash' in partial) this.hash = partial.hash;
    if ('openingContactId' in partial) this.openingContactId = partial.openingContactId;
    if ('attachmentId' in partial) this.attachmentId = partial.attachmentId;
    if ('objectStoreReference' in partial) this.objectStoreReference = partial.objectStoreReference;
    if ('mainUti' in partial) this.mainUti = partial.mainUti;
    if ('otherUtis' in partial && partial.otherUtis !== undefined) this.otherUtis = partial.otherUtis;
    if ('secondaryAttachments' in partial && partial.secondaryAttachments !== undefined) this.secondaryAttachments = partial.secondaryAttachments;
    if ('deletedAttachments' in partial && partial.deletedAttachments !== undefined) this.deletedAttachments = partial.deletedAttachments;
    if ('encryptedAttachment' in partial) this.encryptedAttachment = partial.encryptedAttachment;
    if ('decryptedAttachment' in partial) this.decryptedAttachment = partial.decryptedAttachment;
    if ('secretForeignKeys' in partial && partial.secretForeignKeys !== undefined) this.secretForeignKeys = partial.secretForeignKeys;
    if ('cryptedForeignKeys' in partial && partial.cryptedForeignKeys !== undefined) this.cryptedForeignKeys = partial.cryptedForeignKeys;
    if ('delegations' in partial && partial.delegations !== undefined) this.delegations = partial.delegations;
    if ('encryptionKeys' in partial && partial.encryptionKeys !== undefined) this.encryptionKeys = partial.encryptionKeys;
    if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
    if ('securityMetadata' in partial) this.securityMetadata = partial.securityMetadata;
  }

}

export class EncryptedDocument {

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

  documentLocation: DocumentLocation | undefined = undefined;

  documentType: DocumentType | undefined = undefined;

  documentStatus: DocumentStatus | undefined = undefined;

  externalUri: string | undefined = undefined;

  name: string | undefined = undefined;

  version: string | undefined = undefined;

  storedICureDocumentId: string | undefined = undefined;

  externalUuid: string | undefined = undefined;

  size: number | undefined = undefined;

  hash: string | undefined = undefined;

  openingContactId: string | undefined = undefined;

  attachmentId: string | undefined = undefined;

  objectStoreReference: string | undefined = undefined;

  mainUti: string | undefined = undefined;

  otherUtis: Array<string> = [];

  secondaryAttachments: { [ key: string ]: DataAttachment } = {};

  deletedAttachments: Array<DeletedAttachment> = [];

  encryptedAttachment: Int8Array | undefined = undefined;

  decryptedAttachment: Int8Array | undefined = undefined;

  secretForeignKeys: Array<string> = [];

  cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

  delegations: { [ key: string ]: Array<Delegation> } = {};

  encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

  encryptedSelf: Base64String | undefined = undefined;

  securityMetadata: SecurityMetadata | undefined = undefined;

  readonly isEncrypted: true = true;

  readonly $ktClass: 'com.icure.sdk.model.EncryptedDocument' = 'com.icure.sdk.model.EncryptedDocument';

  constructor(partial: Partial<EncryptedDocument>) {
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
    if ('documentLocation' in partial) this.documentLocation = partial.documentLocation;
    if ('documentType' in partial) this.documentType = partial.documentType;
    if ('documentStatus' in partial) this.documentStatus = partial.documentStatus;
    if ('externalUri' in partial) this.externalUri = partial.externalUri;
    if ('name' in partial) this.name = partial.name;
    if ('version' in partial) this.version = partial.version;
    if ('storedICureDocumentId' in partial) this.storedICureDocumentId = partial.storedICureDocumentId;
    if ('externalUuid' in partial) this.externalUuid = partial.externalUuid;
    if ('size' in partial) this.size = partial.size;
    if ('hash' in partial) this.hash = partial.hash;
    if ('openingContactId' in partial) this.openingContactId = partial.openingContactId;
    if ('attachmentId' in partial) this.attachmentId = partial.attachmentId;
    if ('objectStoreReference' in partial) this.objectStoreReference = partial.objectStoreReference;
    if ('mainUti' in partial) this.mainUti = partial.mainUti;
    if ('otherUtis' in partial && partial.otherUtis !== undefined) this.otherUtis = partial.otherUtis;
    if ('secondaryAttachments' in partial && partial.secondaryAttachments !== undefined) this.secondaryAttachments = partial.secondaryAttachments;
    if ('deletedAttachments' in partial && partial.deletedAttachments !== undefined) this.deletedAttachments = partial.deletedAttachments;
    if ('encryptedAttachment' in partial) this.encryptedAttachment = partial.encryptedAttachment;
    if ('decryptedAttachment' in partial) this.decryptedAttachment = partial.decryptedAttachment;
    if ('secretForeignKeys' in partial && partial.secretForeignKeys !== undefined) this.secretForeignKeys = partial.secretForeignKeys;
    if ('cryptedForeignKeys' in partial && partial.cryptedForeignKeys !== undefined) this.cryptedForeignKeys = partial.cryptedForeignKeys;
    if ('delegations' in partial && partial.delegations !== undefined) this.delegations = partial.delegations;
    if ('encryptionKeys' in partial && partial.encryptionKeys !== undefined) this.encryptionKeys = partial.encryptionKeys;
    if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
    if ('securityMetadata' in partial) this.securityMetadata = partial.securityMetadata;
  }

}

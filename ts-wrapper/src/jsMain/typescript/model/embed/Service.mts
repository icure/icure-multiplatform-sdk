// auto-generated file
import {randomUuid} from '../../utils/Id.mjs';
import {CodeStub} from '../base/CodeStub.mjs';
import {ICureDocument} from '../base/ICureDocument.mjs';
import {Identifier} from '../base/Identifier.mjs';
import {LinkQualification} from '../base/LinkQualification.mjs';
import {Base64String} from '../specializations/Base64String.mjs';
import {Annotation} from './Annotation.mjs';
import {Content, DecryptedContent, EncryptedContent} from './Content.mjs';
import {Delegation} from './Delegation.mjs';
import {Encryptable} from './Encryptable.mjs';
import {SecurityMetadata} from './SecurityMetadata.mjs';


export interface Service extends Encryptable, ICureDocument<string> {

  transactionId: string | undefined;

  identifier: Array<Identifier>;

  contactId: string | undefined;

  subContactIds: Array<string> | undefined;

  plansOfActionIds: Array<string> | undefined;

  healthElementsIds: Array<string> | undefined;

  formIds: Array<string> | undefined;

  secretForeignKeys: Array<string> | undefined;

  cryptedForeignKeys: { [ key: string ]: Array<Delegation> };

  delegations: { [ key: string ]: Array<Delegation> };

  encryptionKeys: { [ key: string ]: Array<Delegation> };

  label: string | undefined;

  index: number | undefined;

  content: { [ key: string ]: Content };

  encryptedContent: string | undefined;

  textIndexes: { [ key: string ]: string };

  valueDate: number | undefined;

  openingDate: number | undefined;

  closingDate: number | undefined;

  formId: string | undefined;

  comment: string | undefined;

  status: number | undefined;

  invoicingCodes: Array<string>;

  notes: Array<Annotation>;

  qualifiedLinks: { [ key in LinkQualification ]?: { [ key: string ]: string } };

  securityMetadata: SecurityMetadata | undefined;

  readonly isEncrypted: boolean;

}

export class DecryptedService {

  id: string;

  transactionId: string | undefined = undefined;

  identifier: Array<Identifier> = [];

  contactId: string | undefined = undefined;

  subContactIds: Array<string> | undefined = undefined;

  plansOfActionIds: Array<string> | undefined = undefined;

  healthElementsIds: Array<string> | undefined = undefined;

  formIds: Array<string> | undefined = undefined;

  secretForeignKeys: Array<string> | undefined = [];

  cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

  delegations: { [ key: string ]: Array<Delegation> } = {};

  encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

  label: string | undefined = undefined;

  index: number | undefined = undefined;

  content: { [ key: string ]: DecryptedContent } = {};

  encryptedContent: string | undefined = undefined;

  textIndexes: { [ key: string ]: string } = {};

  valueDate: number | undefined = undefined;

  openingDate: number | undefined = undefined;

  closingDate: number | undefined = undefined;

  formId: string | undefined = undefined;

  created: number | undefined = undefined;

  modified: number | undefined = undefined;

  endOfLife: number | undefined = undefined;

  author: string | undefined = undefined;

  responsible: string | undefined = undefined;

  medicalLocationId: string | undefined = undefined;

  comment: string | undefined = undefined;

  status: number | undefined = undefined;

  invoicingCodes: Array<string> = [];

  notes: Array<Annotation> = [];

  qualifiedLinks: { [ key in LinkQualification ]?: { [ key: string ]: string } } = {};

  codes: Array<CodeStub> = [];

  tags: Array<CodeStub> = [];

  encryptedSelf: Base64String | undefined = undefined;

  securityMetadata: SecurityMetadata | undefined = undefined;

  readonly isEncrypted: false = false;

  constructor(partial: Partial<DecryptedService>) {
    if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
    this.id = partial.id ?? randomUuid();
    if ('transactionId' in partial) this.transactionId = partial.transactionId;
    if ('identifier' in partial && partial.identifier !== undefined) this.identifier = partial.identifier;
    if ('contactId' in partial) this.contactId = partial.contactId;
    if ('subContactIds' in partial) this.subContactIds = partial.subContactIds;
    if ('plansOfActionIds' in partial) this.plansOfActionIds = partial.plansOfActionIds;
    if ('healthElementsIds' in partial) this.healthElementsIds = partial.healthElementsIds;
    if ('formIds' in partial) this.formIds = partial.formIds;
    if ('secretForeignKeys' in partial) this.secretForeignKeys = partial.secretForeignKeys;
    if ('cryptedForeignKeys' in partial && partial.cryptedForeignKeys !== undefined) this.cryptedForeignKeys = partial.cryptedForeignKeys;
    if ('delegations' in partial && partial.delegations !== undefined) this.delegations = partial.delegations;
    if ('encryptionKeys' in partial && partial.encryptionKeys !== undefined) this.encryptionKeys = partial.encryptionKeys;
    if ('label' in partial) this.label = partial.label;
    if ('index' in partial) this.index = partial.index;
    if ('content' in partial && partial.content !== undefined) this.content = partial.content;
    if ('encryptedContent' in partial) this.encryptedContent = partial.encryptedContent;
    if ('textIndexes' in partial && partial.textIndexes !== undefined) this.textIndexes = partial.textIndexes;
    if ('valueDate' in partial) this.valueDate = partial.valueDate;
    if ('openingDate' in partial) this.openingDate = partial.openingDate;
    if ('closingDate' in partial) this.closingDate = partial.closingDate;
    if ('formId' in partial) this.formId = partial.formId;
    if ('created' in partial) this.created = partial.created;
    if ('modified' in partial) this.modified = partial.modified;
    if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
    if ('author' in partial) this.author = partial.author;
    if ('responsible' in partial) this.responsible = partial.responsible;
    if ('medicalLocationId' in partial) this.medicalLocationId = partial.medicalLocationId;
    if ('comment' in partial) this.comment = partial.comment;
    if ('status' in partial) this.status = partial.status;
    if ('invoicingCodes' in partial && partial.invoicingCodes !== undefined) this.invoicingCodes = partial.invoicingCodes;
    if ('notes' in partial && partial.notes !== undefined) this.notes = partial.notes;
    if ('qualifiedLinks' in partial && partial.qualifiedLinks !== undefined) this.qualifiedLinks = partial.qualifiedLinks;
    if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
    if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
    if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
    if ('securityMetadata' in partial) this.securityMetadata = partial.securityMetadata;
  }

}

export class EncryptedService {

  id: string;

  transactionId: string | undefined = undefined;

  identifier: Array<Identifier> = [];

  contactId: string | undefined = undefined;

  subContactIds: Array<string> | undefined = undefined;

  plansOfActionIds: Array<string> | undefined = undefined;

  healthElementsIds: Array<string> | undefined = undefined;

  formIds: Array<string> | undefined = undefined;

  secretForeignKeys: Array<string> | undefined = [];

  cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

  delegations: { [ key: string ]: Array<Delegation> } = {};

  encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

  label: string | undefined = undefined;

  index: number | undefined = undefined;

  content: { [ key: string ]: EncryptedContent } = {};

  encryptedContent: string | undefined = undefined;

  textIndexes: { [ key: string ]: string } = {};

  valueDate: number | undefined = undefined;

  openingDate: number | undefined = undefined;

  closingDate: number | undefined = undefined;

  formId: string | undefined = undefined;

  created: number | undefined = undefined;

  modified: number | undefined = undefined;

  endOfLife: number | undefined = undefined;

  author: string | undefined = undefined;

  responsible: string | undefined = undefined;

  medicalLocationId: string | undefined = undefined;

  comment: string | undefined = undefined;

  status: number | undefined = undefined;

  invoicingCodes: Array<string> = [];

  notes: Array<Annotation> = [];

  qualifiedLinks: { [ key in LinkQualification ]?: { [ key: string ]: string } } = {};

  codes: Array<CodeStub> = [];

  tags: Array<CodeStub> = [];

  encryptedSelf: Base64String | undefined = undefined;

  securityMetadata: SecurityMetadata | undefined = undefined;

  readonly isEncrypted: true = true;

  constructor(partial: Partial<EncryptedService>) {
    if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
    this.id = partial.id ?? randomUuid();
    if ('transactionId' in partial) this.transactionId = partial.transactionId;
    if ('identifier' in partial && partial.identifier !== undefined) this.identifier = partial.identifier;
    if ('contactId' in partial) this.contactId = partial.contactId;
    if ('subContactIds' in partial) this.subContactIds = partial.subContactIds;
    if ('plansOfActionIds' in partial) this.plansOfActionIds = partial.plansOfActionIds;
    if ('healthElementsIds' in partial) this.healthElementsIds = partial.healthElementsIds;
    if ('formIds' in partial) this.formIds = partial.formIds;
    if ('secretForeignKeys' in partial) this.secretForeignKeys = partial.secretForeignKeys;
    if ('cryptedForeignKeys' in partial && partial.cryptedForeignKeys !== undefined) this.cryptedForeignKeys = partial.cryptedForeignKeys;
    if ('delegations' in partial && partial.delegations !== undefined) this.delegations = partial.delegations;
    if ('encryptionKeys' in partial && partial.encryptionKeys !== undefined) this.encryptionKeys = partial.encryptionKeys;
    if ('label' in partial) this.label = partial.label;
    if ('index' in partial) this.index = partial.index;
    if ('content' in partial && partial.content !== undefined) this.content = partial.content;
    if ('encryptedContent' in partial) this.encryptedContent = partial.encryptedContent;
    if ('textIndexes' in partial && partial.textIndexes !== undefined) this.textIndexes = partial.textIndexes;
    if ('valueDate' in partial) this.valueDate = partial.valueDate;
    if ('openingDate' in partial) this.openingDate = partial.openingDate;
    if ('closingDate' in partial) this.closingDate = partial.closingDate;
    if ('formId' in partial) this.formId = partial.formId;
    if ('created' in partial) this.created = partial.created;
    if ('modified' in partial) this.modified = partial.modified;
    if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
    if ('author' in partial) this.author = partial.author;
    if ('responsible' in partial) this.responsible = partial.responsible;
    if ('medicalLocationId' in partial) this.medicalLocationId = partial.medicalLocationId;
    if ('comment' in partial) this.comment = partial.comment;
    if ('status' in partial) this.status = partial.status;
    if ('invoicingCodes' in partial && partial.invoicingCodes !== undefined) this.invoicingCodes = partial.invoicingCodes;
    if ('notes' in partial && partial.notes !== undefined) this.notes = partial.notes;
    if ('qualifiedLinks' in partial && partial.qualifiedLinks !== undefined) this.qualifiedLinks = partial.qualifiedLinks;
    if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
    if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
    if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
    if ('securityMetadata' in partial) this.securityMetadata = partial.securityMetadata;
  }

}

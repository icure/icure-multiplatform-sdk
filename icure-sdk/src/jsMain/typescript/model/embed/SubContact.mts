// auto-generated file
import {CodeStub} from '../base/CodeStub.mjs';
import {ICureDocument} from '../base/ICureDocument.mjs';
import {Base64String} from '../specializations/Base64String.mjs';
import {Encryptable} from './Encryptable.mjs';
import {ServiceLink} from './ServiceLink.mjs';


export interface SubContact extends Encryptable, ICureDocument<string | undefined> {

  descr: string | undefined;

  protocol: string | undefined;

  status: number | undefined;

  formId: string | undefined;

  planOfActionId: string | undefined;

  healthElementId: string | undefined;

  classificationId: string | undefined;

  services: Array<ServiceLink>;

  readonly isEncrypted: boolean;

}

export class DecryptedSubContact {

  id: string | undefined = undefined;

  created: number | undefined = undefined;

  modified: number | undefined = undefined;

  author: string | undefined = undefined;

  responsible: string | undefined = undefined;

  medicalLocationId: string | undefined = undefined;

  tags: Array<CodeStub> = [];

  codes: Array<CodeStub> = [];

  endOfLife: number | undefined = undefined;

  descr: string | undefined = undefined;

  protocol: string | undefined = undefined;

  status: number | undefined = undefined;

  formId: string | undefined = undefined;

  planOfActionId: string | undefined = undefined;

  healthElementId: string | undefined = undefined;

  classificationId: string | undefined = undefined;

  services: Array<ServiceLink> = [];

  encryptedSelf: Base64String | undefined = undefined;

  readonly isEncrypted: false = false;

  readonly $ktClass: 'com.icure.sdk.model.embed.DecryptedSubContact' = 'com.icure.sdk.model.embed.DecryptedSubContact';

  constructor(partial: Partial<DecryptedSubContact>) {
    if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
    if ('id' in partial) this.id = partial.id;
    if ('created' in partial) this.created = partial.created;
    if ('modified' in partial) this.modified = partial.modified;
    if ('author' in partial) this.author = partial.author;
    if ('responsible' in partial) this.responsible = partial.responsible;
    if ('medicalLocationId' in partial) this.medicalLocationId = partial.medicalLocationId;
    if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
    if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
    if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
    if ('descr' in partial) this.descr = partial.descr;
    if ('protocol' in partial) this.protocol = partial.protocol;
    if ('status' in partial) this.status = partial.status;
    if ('formId' in partial) this.formId = partial.formId;
    if ('planOfActionId' in partial) this.planOfActionId = partial.planOfActionId;
    if ('healthElementId' in partial) this.healthElementId = partial.healthElementId;
    if ('classificationId' in partial) this.classificationId = partial.classificationId;
    if ('services' in partial && partial.services !== undefined) this.services = partial.services;
    if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
  }

}

export class EncryptedSubContact {

  id: string | undefined = undefined;

  created: number | undefined = undefined;

  modified: number | undefined = undefined;

  author: string | undefined = undefined;

  responsible: string | undefined = undefined;

  medicalLocationId: string | undefined = undefined;

  tags: Array<CodeStub> = [];

  codes: Array<CodeStub> = [];

  endOfLife: number | undefined = undefined;

  descr: string | undefined = undefined;

  protocol: string | undefined = undefined;

  status: number | undefined = undefined;

  formId: string | undefined = undefined;

  planOfActionId: string | undefined = undefined;

  healthElementId: string | undefined = undefined;

  classificationId: string | undefined = undefined;

  services: Array<ServiceLink> = [];

  encryptedSelf: Base64String | undefined = undefined;

  readonly isEncrypted: true = true;

  readonly $ktClass: 'com.icure.sdk.model.embed.EncryptedSubContact' = 'com.icure.sdk.model.embed.EncryptedSubContact';

  constructor(partial: Partial<EncryptedSubContact>) {
    if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
    if ('id' in partial) this.id = partial.id;
    if ('created' in partial) this.created = partial.created;
    if ('modified' in partial) this.modified = partial.modified;
    if ('author' in partial) this.author = partial.author;
    if ('responsible' in partial) this.responsible = partial.responsible;
    if ('medicalLocationId' in partial) this.medicalLocationId = partial.medicalLocationId;
    if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
    if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
    if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
    if ('descr' in partial) this.descr = partial.descr;
    if ('protocol' in partial) this.protocol = partial.protocol;
    if ('status' in partial) this.status = partial.status;
    if ('formId' in partial) this.formId = partial.formId;
    if ('planOfActionId' in partial) this.planOfActionId = partial.planOfActionId;
    if ('healthElementId' in partial) this.healthElementId = partial.healthElementId;
    if ('classificationId' in partial) this.classificationId = partial.classificationId;
    if ('services' in partial && partial.services !== undefined) this.services = partial.services;
    if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
  }

}

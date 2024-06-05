// auto-generated file
import {randomUuid} from '../utils/Id.mjs';
import {CodeStub} from './base/CodeStub.mjs';
import {ICureDocument} from './base/ICureDocument.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {KeywordSubword} from './embed/KeywordSubword.mjs';


export class Keyword implements StoredDocument, ICureDocument<string> {

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

  value: string | undefined = undefined;

  subWords: Array<KeywordSubword> = [];

  userId: string | undefined = undefined;

  constructor(partial: Partial<Keyword>) {
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
    if ('value' in partial) this.value = partial.value;
    if ('subWords' in partial && partial.subWords !== undefined) this.subWords = partial.subWords;
    if ('userId' in partial) this.userId = partial.userId;
  }

}

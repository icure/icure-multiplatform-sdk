// auto-generated file
import {randomUuid} from '../utils/Id.mjs';
import {AppendixType} from './base/AppendixType.mjs';
import {CodeFlag} from './base/CodeFlag.mjs';
import {CodeIdentification} from './base/CodeIdentification.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {Periodicity} from './embed/Periodicity.mjs';


export class Code implements StoredDocument, CodeIdentification<string> {

  id: string;

  rev: string | undefined = undefined;

  deletionDate: number | undefined = undefined;

  context: string | undefined = undefined;

  type: string | undefined = undefined;

  code: string | undefined = undefined;

  version: string | undefined = undefined;

  label: { [ key: string ]: string } | undefined = undefined;

  author: string | undefined = undefined;

  regions: Array<string> = [];

  periodicity: Array<Periodicity> = [];

  level: number | undefined = undefined;

  links: Array<string> = [];

  qualifiedLinks: { [ key: string ]: Array<string> } = {};

  flags: Array<CodeFlag> = [];

  searchTerms: { [ key: string ]: Array<string> } = {};

  data: string | undefined = undefined;

  appendices: { [ key in AppendixType ]?: string } = {};

  disabled: boolean = false;

  constructor(partial: Partial<Code>) {
    this.id = partial.id ?? randomUuid();
    if ('rev' in partial) this.rev = partial.rev;
    if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
    if ('context' in partial) this.context = partial.context;
    if ('type' in partial) this.type = partial.type;
    if ('code' in partial) this.code = partial.code;
    if ('version' in partial) this.version = partial.version;
    if ('label' in partial) this.label = partial.label;
    if ('author' in partial) this.author = partial.author;
    if ('regions' in partial && partial.regions !== undefined) this.regions = partial.regions;
    if ('periodicity' in partial && partial.periodicity !== undefined) this.periodicity = partial.periodicity;
    if ('level' in partial) this.level = partial.level;
    if ('links' in partial && partial.links !== undefined) this.links = partial.links;
    if ('qualifiedLinks' in partial && partial.qualifiedLinks !== undefined) this.qualifiedLinks = partial.qualifiedLinks;
    if ('flags' in partial && partial.flags !== undefined) this.flags = partial.flags;
    if ('searchTerms' in partial && partial.searchTerms !== undefined) this.searchTerms = partial.searchTerms;
    if ('data' in partial) this.data = partial.data;
    if ('appendices' in partial && partial.appendices !== undefined) this.appendices = partial.appendices;
    if ('disabled' in partial && partial.disabled !== undefined) this.disabled = partial.disabled;
  }

}

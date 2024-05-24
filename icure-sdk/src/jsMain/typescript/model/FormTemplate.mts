// auto-generated file
import {randomUuid} from '../utils/Id.mjs';
import {CodeStub} from './base/CodeStub.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {DocumentGroup} from './embed/DocumentGroup.mjs';
import {FormTemplateLayout} from './embed/form/template/FormTemplateLayout.mjs';


export class FormTemplate implements StoredDocument {

  id: string;

  rev: string | undefined = undefined;

  deletionDate: number | undefined = undefined;

  templateLayout: FormTemplateLayout | undefined = undefined;

  rawTemplateLayout: Int8Array | undefined = undefined;

  name: string | undefined = undefined;

  guid: string | undefined = undefined;

  group: DocumentGroup | undefined = undefined;

  descr: string | undefined = undefined;

  disabled: string | undefined = undefined;

  specialty: CodeStub | undefined = undefined;

  author: string | undefined = undefined;

  formInstancePreferredLocation: string | undefined = undefined;

  keyboardShortcut: string | undefined = undefined;

  shortReport: string | undefined = undefined;

  mediumReport: string | undefined = undefined;

  longReport: string | undefined = undefined;

  reports: Array<string> = [];

  tags: Array<CodeStub> = [];

  layoutAttachmentId: string | undefined = undefined;

  templateLayoutAttachmentId: string | undefined = undefined;

  constructor(partial: Partial<FormTemplate>) {
    this.id = partial.id ?? randomUuid();
    if ('rev' in partial) this.rev = partial.rev;
    if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
    if ('templateLayout' in partial) this.templateLayout = partial.templateLayout;
    if ('rawTemplateLayout' in partial) this.rawTemplateLayout = partial.rawTemplateLayout;
    if ('name' in partial) this.name = partial.name;
    if ('guid' in partial) this.guid = partial.guid;
    if ('group' in partial) this.group = partial.group;
    if ('descr' in partial) this.descr = partial.descr;
    if ('disabled' in partial) this.disabled = partial.disabled;
    if ('specialty' in partial) this.specialty = partial.specialty;
    if ('author' in partial) this.author = partial.author;
    if ('formInstancePreferredLocation' in partial) this.formInstancePreferredLocation = partial.formInstancePreferredLocation;
    if ('keyboardShortcut' in partial) this.keyboardShortcut = partial.keyboardShortcut;
    if ('shortReport' in partial) this.shortReport = partial.shortReport;
    if ('mediumReport' in partial) this.mediumReport = partial.mediumReport;
    if ('longReport' in partial) this.longReport = partial.longReport;
    if ('reports' in partial && partial.reports !== undefined) this.reports = partial.reports;
    if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
    if ('layoutAttachmentId' in partial) this.layoutAttachmentId = partial.layoutAttachmentId;
    if ('templateLayoutAttachmentId' in partial) this.templateLayoutAttachmentId = partial.templateLayoutAttachmentId;
  }

}

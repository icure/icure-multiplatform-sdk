// auto-generated file
import {randomUuid} from '../../utils/Id.mjs';
import {CodeStub} from '../base/CodeStub.mjs';
import {Identifiable} from '../base/Identifiable.mjs';


export class Annotation implements Identifiable<string> {

  id: string;

  author: string | undefined = undefined;

  created: number | undefined = undefined;

  modified: number | undefined = undefined;

  text: string | undefined = undefined;

  markdown: { [ key: string ]: string } = {};

  location: string | undefined = undefined;

  confidential: boolean | undefined = undefined;

  tags: Array<CodeStub> = [];

  encryptedSelf: string | undefined = undefined;

  constructor(partial: Partial<Annotation>) {
    this.id = partial.id ?? randomUuid();
    if ('author' in partial) this.author = partial.author;
    if ('created' in partial) this.created = partial.created;
    if ('modified' in partial) this.modified = partial.modified;
    if ('text' in partial) this.text = partial.text;
    if ('markdown' in partial && partial.markdown !== undefined) this.markdown = partial.markdown;
    if ('location' in partial) this.location = partial.location;
    if ('confidential' in partial) this.confidential = partial.confidential;
    if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
    if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
  }

}

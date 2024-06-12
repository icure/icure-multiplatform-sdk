// auto-generated file
import {randomUuid} from '../../utils/Id.mjs';


export class DatabaseInfo {

  id: string;

  updateSeq: string | undefined = undefined;

  fileSize: number | undefined = undefined;

  externalSize: number | undefined = undefined;

  activeSize: number | undefined = undefined;

  docs: number | undefined = undefined;

  q: number | undefined = undefined;

  n: number | undefined = undefined;

  w: number | undefined = undefined;

  r: number | undefined = undefined;

  constructor(partial: Partial<DatabaseInfo>) {
    this.id = partial.id ?? randomUuid();
    if ('updateSeq' in partial) this.updateSeq = partial.updateSeq;
    if ('fileSize' in partial) this.fileSize = partial.fileSize;
    if ('externalSize' in partial) this.externalSize = partial.externalSize;
    if ('activeSize' in partial) this.activeSize = partial.activeSize;
    if ('docs' in partial) this.docs = partial.docs;
    if ('q' in partial) this.q = partial.q;
    if ('n' in partial) this.n = partial.n;
    if ('w' in partial) this.w = partial.w;
    if ('r' in partial) this.r = partial.r;
  }

}

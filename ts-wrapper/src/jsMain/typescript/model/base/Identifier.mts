// auto-generated file
import {CodeStub} from './CodeStub.mjs';


export class Identifier {

  id: string | undefined = undefined;

  assigner: string | undefined = undefined;

  start: string | undefined = undefined;

  end: string | undefined = undefined;

  system: string | undefined = undefined;

  type: CodeStub | undefined = undefined;

  use: string | undefined = undefined;

  value: string | undefined = undefined;

  constructor(partial: Partial<Identifier>) {
    if ('id' in partial) this.id = partial.id;
    if ('assigner' in partial) this.assigner = partial.assigner;
    if ('start' in partial) this.start = partial.start;
    if ('end' in partial) this.end = partial.end;
    if ('system' in partial) this.system = partial.system;
    if ('type' in partial) this.type = partial.type;
    if ('use' in partial) this.use = partial.use;
    if ('value' in partial) this.value = partial.value;
  }

}

// auto-generated file
import {CodeStub} from '../base/CodeStub.mjs';


export class Duration {

  value: number | undefined = undefined;

  unit: CodeStub | undefined = undefined;

  constructor(partial: Partial<Duration>) {
    if ('value' in partial) this.value = partial.value;
    if ('unit' in partial) this.unit = partial.unit;
  }

}

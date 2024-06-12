// auto-generated file
import {PersonNameUse} from './PersonNameUse.mjs';


export class PersonName {

  lastName: string | undefined = undefined;

  firstNames: Array<string> = [];

  start: number | undefined = undefined;

  end: number | undefined = undefined;

  prefix: Array<string> = [];

  suffix: Array<string> = [];

  text: string | undefined = undefined;

  use: PersonNameUse | undefined = undefined;

  constructor(partial: Partial<PersonName>) {
    if ('lastName' in partial) this.lastName = partial.lastName;
    if ('firstNames' in partial && partial.firstNames !== undefined) this.firstNames = partial.firstNames;
    if ('start' in partial) this.start = partial.start;
    if ('end' in partial) this.end = partial.end;
    if ('prefix' in partial && partial.prefix !== undefined) this.prefix = partial.prefix;
    if ('suffix' in partial && partial.suffix !== undefined) this.suffix = partial.suffix;
    if ('text' in partial) this.text = partial.text;
    if ('use' in partial) this.use = partial.use;
  }

}

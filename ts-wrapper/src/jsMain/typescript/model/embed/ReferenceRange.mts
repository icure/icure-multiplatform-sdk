// auto-generated file
import {CodeStub} from '../base/CodeStub.mjs';
import {Annotation} from './Annotation.mjs';
import {Range} from './Range.mjs';


export class ReferenceRange {

  low: number | undefined = undefined;

  high: number | undefined = undefined;

  stringValue: string | undefined = undefined;

  tags: Array<CodeStub> = [];

  codes: Array<CodeStub> = [];

  notes: Array<Annotation> = [];

  age: Range | undefined = undefined;

  constructor(partial: Partial<ReferenceRange>) {
    if ('low' in partial) this.low = partial.low;
    if ('high' in partial) this.high = partial.high;
    if ('stringValue' in partial) this.stringValue = partial.stringValue;
    if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
    if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
    if ('notes' in partial && partial.notes !== undefined) this.notes = partial.notes;
    if ('age' in partial) this.age = partial.age;
  }

}

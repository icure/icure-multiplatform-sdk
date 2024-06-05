// auto-generated file
import {Identifiable} from '../base/Identifiable.mjs';
import {Filter} from './Filter.mjs';


export interface AbstractFilter<O extends Identifiable<string>> extends Filter<O> {

  desc: string | undefined;

  readonly $ktClass: string;

}

// auto-generated file
import {Identifiable} from '../base/Identifiable.mjs';
import {Filter as Filter_} from './Filter.mjs';


export interface Filter<O extends Identifiable<any>> {
}

export namespace Filter {

  export interface IdsFilter<T, O extends Identifiable<T>> extends Filter<O> {

    ids: Array<T>;

  }

  export interface UnionFilter<O extends Identifiable<any>> extends Filter<O> {

    filters: Array<Filter_<O>>;

  }

  export interface IntersectionFilter<O extends Identifiable<any>> extends Filter<O> {

    filters: Array<Filter_<O>>;

  }

  export interface ComplementFilter<O extends Identifiable<any>> extends Filter<O> {

    superSet: Filter_<O>;

    subSet: Filter_<O>;

  }

  export interface AllFilter<O extends Identifiable<any>> extends Filter<O> {
  }

  export interface ByHcpartyFilter<O extends Identifiable<any>> extends Filter<O> {

    hcpId: string;

  }

}

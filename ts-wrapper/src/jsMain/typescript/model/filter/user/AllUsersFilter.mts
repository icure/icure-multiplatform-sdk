// auto-generated file
import {User} from '../../User.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';
import {Filter} from '../Filter.mjs';


export class AllUsersFilter implements AbstractFilter<User>, Filter.AllFilter<User> {

  desc: string | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.user.AllUsersFilter' = 'com.icure.sdk.model.filter.user.AllUsersFilter';

  constructor(partial: Partial<AllUsersFilter>) {
    if ('desc' in partial) this.desc = partial.desc;
  }

}

// auto-generated file
import {User} from '../../User.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';


export class UserByNameEmailPhoneFilter implements AbstractFilter<User> {

  searchString: string;

  desc: string | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.user.UserByNameEmailPhoneFilter' = 'com.icure.sdk.model.filter.user.UserByNameEmailPhoneFilter';

  constructor(partial: Partial<UserByNameEmailPhoneFilter> & Pick<UserByNameEmailPhoneFilter, "searchString">) {
    this.searchString = partial.searchString;
    if ('desc' in partial) this.desc = partial.desc;
  }

}

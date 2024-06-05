// auto-generated file
import {User} from '../../User.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';
import {Filter} from '../Filter.mjs';


export class UserByIdsFilter implements AbstractFilter<User>, Filter.IdsFilter<string, User> {

  ids: Array<string>;

  desc: string | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.user.UserByIdsFilter' = 'com.icure.sdk.model.filter.user.UserByIdsFilter';

  constructor(partial: Partial<UserByIdsFilter> & Pick<UserByIdsFilter, "ids">) {
    this.ids = partial.ids;
    if ('desc' in partial) this.desc = partial.desc;
  }

}

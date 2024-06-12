// auto-generated file
import {User} from '../../User.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';


export class UsersByPatientIdFilter implements AbstractFilter<User> {

  patientId: string;

  desc: string | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.user.UsersByPatientIdFilter' = 'com.icure.sdk.model.filter.user.UsersByPatientIdFilter';

  constructor(partial: Partial<UsersByPatientIdFilter> & Pick<UsersByPatientIdFilter, "patientId">) {
    this.patientId = partial.patientId;
    if ('desc' in partial) this.desc = partial.desc;
  }

}

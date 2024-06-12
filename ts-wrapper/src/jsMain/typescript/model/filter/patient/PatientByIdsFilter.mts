// auto-generated file
import {Patient} from '../../Patient.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';
import {Filter} from '../Filter.mjs';


export class PatientByIdsFilter implements AbstractFilter<Patient>, Filter.IdsFilter<string, Patient> {

  ids: Array<string>;

  desc: string | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.patient.PatientByIdsFilter' = 'com.icure.sdk.model.filter.patient.PatientByIdsFilter';

  constructor(partial: Partial<PatientByIdsFilter> & Pick<PatientByIdsFilter, "ids">) {
    this.ids = partial.ids;
    if ('desc' in partial) this.desc = partial.desc;
  }

}

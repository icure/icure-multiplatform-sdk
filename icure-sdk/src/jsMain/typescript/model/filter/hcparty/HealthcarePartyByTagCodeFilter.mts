// auto-generated file
import {HealthcareParty} from '../../HealthcareParty.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';


export class HealthcarePartyByTagCodeFilter implements AbstractFilter<HealthcareParty> {

  tagType: string | undefined = undefined;

  tagCode: string | undefined = undefined;

  codeType: string | undefined = undefined;

  codeCode: string | undefined = undefined;

  desc: string | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.hcparty.HealthcarePartyByTagCodeFilter' = 'com.icure.sdk.model.filter.hcparty.HealthcarePartyByTagCodeFilter';

  constructor(partial: Partial<HealthcarePartyByTagCodeFilter>) {
    if ('tagType' in partial) this.tagType = partial.tagType;
    if ('tagCode' in partial) this.tagCode = partial.tagCode;
    if ('codeType' in partial) this.codeType = partial.codeType;
    if ('codeCode' in partial) this.codeCode = partial.codeCode;
    if ('desc' in partial) this.desc = partial.desc;
  }

}

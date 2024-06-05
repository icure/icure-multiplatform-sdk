// auto-generated file
import {HealthElement} from '../../HealthElement.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';


export class HealthElementByHcPartyTagCodeFilter implements AbstractFilter<HealthElement> {

  desc: string | undefined = undefined;

  healthcarePartyId: string | undefined = undefined;

  codeType: string | undefined = undefined;

  codeCode: string | undefined = undefined;

  tagType: string | undefined = undefined;

  tagCode: string | undefined = undefined;

  status: number | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.healthelement.HealthElementByHcPartyTagCodeFilter' = 'com.icure.sdk.model.filter.healthelement.HealthElementByHcPartyTagCodeFilter';

  constructor(partial: Partial<HealthElementByHcPartyTagCodeFilter>) {
    if ('desc' in partial) this.desc = partial.desc;
    if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
    if ('codeType' in partial) this.codeType = partial.codeType;
    if ('codeCode' in partial) this.codeCode = partial.codeCode;
    if ('tagType' in partial) this.tagType = partial.tagType;
    if ('tagCode' in partial) this.tagCode = partial.tagCode;
    if ('status' in partial) this.status = partial.status;
  }

}

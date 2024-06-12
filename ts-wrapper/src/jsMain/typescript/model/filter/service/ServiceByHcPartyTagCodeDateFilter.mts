// auto-generated file
import {Service} from '../../embed/Service.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';


export class ServiceByHcPartyTagCodeDateFilter implements AbstractFilter<Service> {

  desc: string | undefined = undefined;

  healthcarePartyId: string | undefined = undefined;

  patientSecretForeignKey: string | undefined = undefined;

  tagType: string | undefined = undefined;

  tagCode: string | undefined = undefined;

  codeType: string | undefined = undefined;

  codeCode: string | undefined = undefined;

  startValueDate: number | undefined = undefined;

  endValueDate: number | undefined = undefined;

  descending: boolean = false;

  readonly $ktClass: 'com.icure.sdk.model.filter.service.ServiceByHcPartyTagCodeDateFilter' = 'com.icure.sdk.model.filter.service.ServiceByHcPartyTagCodeDateFilter';

  constructor(partial: Partial<ServiceByHcPartyTagCodeDateFilter>) {
    if ('desc' in partial) this.desc = partial.desc;
    if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
    if ('patientSecretForeignKey' in partial) this.patientSecretForeignKey = partial.patientSecretForeignKey;
    if ('tagType' in partial) this.tagType = partial.tagType;
    if ('tagCode' in partial) this.tagCode = partial.tagCode;
    if ('codeType' in partial) this.codeType = partial.codeType;
    if ('codeCode' in partial) this.codeCode = partial.codeCode;
    if ('startValueDate' in partial) this.startValueDate = partial.startValueDate;
    if ('endValueDate' in partial) this.endValueDate = partial.endValueDate;
    if ('descending' in partial && partial.descending !== undefined) this.descending = partial.descending;
  }

}

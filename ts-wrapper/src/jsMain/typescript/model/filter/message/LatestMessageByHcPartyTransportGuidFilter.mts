// auto-generated file
import {Message} from '../../Message.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';


export class LatestMessageByHcPartyTransportGuidFilter implements AbstractFilter<Message> {

  healthcarePartyId: string;

  transportGuid: string;

  desc: string | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.message.LatestMessageByHcPartyTransportGuidFilter' = 'com.icure.sdk.model.filter.message.LatestMessageByHcPartyTransportGuidFilter';

  constructor(partial: Partial<LatestMessageByHcPartyTransportGuidFilter> & Pick<LatestMessageByHcPartyTransportGuidFilter, "healthcarePartyId" | "transportGuid">) {
    this.healthcarePartyId = partial.healthcarePartyId;
    this.transportGuid = partial.transportGuid;
    if ('desc' in partial) this.desc = partial.desc;
  }

}

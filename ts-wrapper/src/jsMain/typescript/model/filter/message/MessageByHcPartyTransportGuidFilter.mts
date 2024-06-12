// auto-generated file
import {Message} from '../../Message.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';


export class MessageByHcPartyTransportGuidFilter implements AbstractFilter<Message> {

  healthcarePartyId: string;

  transportGuid: string;

  desc: string | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.message.MessageByHcPartyTransportGuidFilter' = 'com.icure.sdk.model.filter.message.MessageByHcPartyTransportGuidFilter';

  constructor(partial: Partial<MessageByHcPartyTransportGuidFilter> & Pick<MessageByHcPartyTransportGuidFilter, "healthcarePartyId" | "transportGuid">) {
    this.healthcarePartyId = partial.healthcarePartyId;
    this.transportGuid = partial.transportGuid;
    if ('desc' in partial) this.desc = partial.desc;
  }

}

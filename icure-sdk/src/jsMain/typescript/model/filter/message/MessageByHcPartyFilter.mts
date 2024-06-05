// auto-generated file
import {Message} from '../../Message.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';
import {Filter} from '../Filter.mjs';


export class MessageByHcPartyFilter implements AbstractFilter<Message>, Filter.ByHcpartyFilter<Message> {

  hcpId: string;

  desc: string | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.message.MessageByHcPartyFilter' = 'com.icure.sdk.model.filter.message.MessageByHcPartyFilter';

  constructor(partial: Partial<MessageByHcPartyFilter> & Pick<MessageByHcPartyFilter, "hcpId">) {
    this.hcpId = partial.hcpId;
    if ('desc' in partial) this.desc = partial.desc;
  }

}

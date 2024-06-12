// auto-generated file
import {Topic} from '../../Topic.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';
import {Filter} from '../Filter.mjs';


export class TopicByHcPartyFilter implements AbstractFilter<Topic>, Filter.ByHcpartyFilter<Topic> {

  hcpId: string;

  desc: string | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.topic.TopicByHcPartyFilter' = 'com.icure.sdk.model.filter.topic.TopicByHcPartyFilter';

  constructor(partial: Partial<TopicByHcPartyFilter> & Pick<TopicByHcPartyFilter, "hcpId">) {
    this.hcpId = partial.hcpId;
    if ('desc' in partial) this.desc = partial.desc;
  }

}

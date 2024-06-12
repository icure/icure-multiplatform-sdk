// auto-generated file
import {Topic} from '../../Topic.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';


export class TopicByParticipantFilter implements AbstractFilter<Topic> {

  participantId: string;

  desc: string | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.topic.TopicByParticipantFilter' = 'com.icure.sdk.model.filter.topic.TopicByParticipantFilter';

  constructor(partial: Partial<TopicByParticipantFilter> & Pick<TopicByParticipantFilter, "participantId">) {
    this.participantId = partial.participantId;
    if ('desc' in partial) this.desc = partial.desc;
  }

}

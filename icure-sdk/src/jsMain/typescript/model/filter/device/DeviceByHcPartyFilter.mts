// auto-generated file
import {Device} from '../../Device.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';


export class DeviceByHcPartyFilter implements AbstractFilter<Device> {

  desc: string | undefined = undefined;

  responsibleId: string | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.device.DeviceByHcPartyFilter' = 'com.icure.sdk.model.filter.device.DeviceByHcPartyFilter';

  constructor(partial: Partial<DeviceByHcPartyFilter>) {
    if ('desc' in partial) this.desc = partial.desc;
    if ('responsibleId' in partial) this.responsibleId = partial.responsibleId;
  }

}

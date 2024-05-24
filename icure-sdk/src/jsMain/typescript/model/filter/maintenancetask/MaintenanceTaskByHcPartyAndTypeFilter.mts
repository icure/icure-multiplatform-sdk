// auto-generated file
import {MaintenanceTask} from '../../MaintenanceTask.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';


export class MaintenanceTaskByHcPartyAndTypeFilter implements AbstractFilter<MaintenanceTask> {

  desc: string | undefined = undefined;

  type: string;

  healthcarePartyId: string | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.maintenancetask.MaintenanceTaskByHcPartyAndTypeFilter' = 'com.icure.sdk.model.filter.maintenancetask.MaintenanceTaskByHcPartyAndTypeFilter';

  constructor(partial: Partial<MaintenanceTaskByHcPartyAndTypeFilter> & Pick<MaintenanceTaskByHcPartyAndTypeFilter, "type">) {
    if ('desc' in partial) this.desc = partial.desc;
    this.type = partial.type;
    if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
  }

}

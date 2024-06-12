// auto-generated file
import {MaintenanceTask} from '../../MaintenanceTask.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';


export class MaintenanceTaskAfterDateFilter implements AbstractFilter<MaintenanceTask> {

  desc: string | undefined = undefined;

  healthcarePartyId: string | undefined = undefined;

  date: number;

  readonly $ktClass: 'com.icure.sdk.model.filter.maintenancetask.MaintenanceTaskAfterDateFilter' = 'com.icure.sdk.model.filter.maintenancetask.MaintenanceTaskAfterDateFilter';

  constructor(partial: Partial<MaintenanceTaskAfterDateFilter> & Pick<MaintenanceTaskAfterDateFilter, "date">) {
    if ('desc' in partial) this.desc = partial.desc;
    if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
    this.date = partial.date;
  }

}

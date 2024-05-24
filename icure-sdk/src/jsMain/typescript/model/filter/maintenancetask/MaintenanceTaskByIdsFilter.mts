// auto-generated file
import {MaintenanceTask} from '../../MaintenanceTask.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';
import {Filter} from '../Filter.mjs';


export class MaintenanceTaskByIdsFilter implements AbstractFilter<MaintenanceTask>, Filter.IdsFilter<string, MaintenanceTask> {

  ids: Array<string>;

  desc: string | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.maintenancetask.MaintenanceTaskByIdsFilter' = 'com.icure.sdk.model.filter.maintenancetask.MaintenanceTaskByIdsFilter';

  constructor(partial: Partial<MaintenanceTaskByIdsFilter> & Pick<MaintenanceTaskByIdsFilter, "ids">) {
    this.ids = partial.ids;
    if ('desc' in partial) this.desc = partial.desc;
  }

}

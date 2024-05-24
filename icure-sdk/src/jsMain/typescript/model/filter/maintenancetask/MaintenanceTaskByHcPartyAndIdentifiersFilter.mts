// auto-generated file
import {MaintenanceTask} from '../../MaintenanceTask.mjs';
import {Identifier} from '../../base/Identifier.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';


export class MaintenanceTaskByHcPartyAndIdentifiersFilter implements AbstractFilter<MaintenanceTask> {

  healthcarePartyId: string | undefined = undefined;

  identifiers: Array<Identifier> = [];

  desc: string | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.maintenancetask.MaintenanceTaskByHcPartyAndIdentifiersFilter' = 'com.icure.sdk.model.filter.maintenancetask.MaintenanceTaskByHcPartyAndIdentifiersFilter';

  constructor(partial: Partial<MaintenanceTaskByHcPartyAndIdentifiersFilter>) {
    if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
    if ('identifiers' in partial && partial.identifiers !== undefined) this.identifiers = partial.identifiers;
    if ('desc' in partial) this.desc = partial.desc;
  }

}

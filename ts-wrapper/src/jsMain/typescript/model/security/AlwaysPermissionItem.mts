// auto-generated file
import {AlwaysPredicate} from '../filter/predicate/AlwaysPredicate.mjs';
import {PermissionType} from './PermissionType.mjs';


export class AlwaysPermissionItem {

  type: PermissionType;

  predicate: AlwaysPredicate = new AlwaysPredicate({});

  readonly $ktClass: 'com.icure.sdk.model.security.AlwaysPermissionItem' = 'com.icure.sdk.model.security.AlwaysPermissionItem';

  constructor(partial: Partial<AlwaysPermissionItem> & Pick<AlwaysPermissionItem, "type">) {
    this.type = partial.type;
    if ('predicate' in partial && partial.predicate !== undefined) this.predicate = partial.predicate;
  }

}

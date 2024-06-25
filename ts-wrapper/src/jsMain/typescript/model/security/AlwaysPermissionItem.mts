// auto-generated file
import {PermissionType} from './PermissionType.mjs';


export class AlwaysPermissionItem {

  type: PermissionType;

  readonly $ktClass: 'com.icure.sdk.model.security.AlwaysPermissionItem' = 'com.icure.sdk.model.security.AlwaysPermissionItem';

  constructor(partial: Partial<AlwaysPermissionItem> & Pick<AlwaysPermissionItem, "type">) {
    this.type = partial.type;
  }

}

// auto-generated file
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';
import {ShareMetadataBehaviour} from './ShareMetadataBehaviour.mjs';


export class MaintenanceTaskShareOptions {

  requestedPermissions: RequestedPermission;

  shareEncryptionKey: ShareMetadataBehaviour;

  constructor(partial: Partial<MaintenanceTaskShareOptions> & Pick<MaintenanceTaskShareOptions, "requestedPermissions" | "shareEncryptionKey">) {
    this.requestedPermissions = partial.requestedPermissions;
    this.shareEncryptionKey = partial.shareEncryptionKey;
  }

}

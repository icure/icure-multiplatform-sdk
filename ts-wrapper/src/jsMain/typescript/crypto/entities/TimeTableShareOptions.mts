// auto-generated file
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';
import {ShareMetadataBehaviour} from './ShareMetadataBehaviour.mjs';
import {SimpleDelegateShareOptions} from './SimpleDelegateShareOptions.mjs';


export class TimeTableShareOptions implements SimpleDelegateShareOptions {

  requestedPermissions: RequestedPermission;

  shareEncryptionKey: ShareMetadataBehaviour;

  shareOwningEntityIds: ShareMetadataBehaviour;

  shareSecretIds: never | undefined;

  constructor(partial: Partial<TimeTableShareOptions> & Pick<TimeTableShareOptions, "requestedPermissions" | "shareEncryptionKey" | "shareOwningEntityIds" | "shareSecretIds">) {
    this.requestedPermissions = partial.requestedPermissions;
    this.shareEncryptionKey = partial.shareEncryptionKey;
    this.shareOwningEntityIds = partial.shareOwningEntityIds;
    this.shareSecretIds = partial.shareSecretIds;
  }

}

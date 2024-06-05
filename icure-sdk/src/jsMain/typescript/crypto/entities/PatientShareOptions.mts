// auto-generated file
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';
import {ShareMetadataBehaviour} from './ShareMetadataBehaviour.mjs';
import {SimpleDelegateShareOptions} from './SimpleDelegateShareOptions.mjs';


export class PatientShareOptions implements SimpleDelegateShareOptions {

  requestedPermissions: RequestedPermission;

  shareEncryptionKey: ShareMetadataBehaviour;

  shareSecretIds: Array<string>;

  shareOwningEntityIds: ShareMetadataBehaviour;

  constructor(partial: Partial<PatientShareOptions> & Pick<PatientShareOptions, "requestedPermissions" | "shareEncryptionKey" | "shareSecretIds" | "shareOwningEntityIds">) {
    this.requestedPermissions = partial.requestedPermissions;
    this.shareEncryptionKey = partial.shareEncryptionKey;
    this.shareSecretIds = partial.shareSecretIds;
    this.shareOwningEntityIds = partial.shareOwningEntityIds;
  }

}

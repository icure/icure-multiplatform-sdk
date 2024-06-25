// auto-generated file
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';
import {ShareMetadataBehaviour} from './ShareMetadataBehaviour.mjs';


export class PatientShareOptions {

  requestedPermissions: RequestedPermission;

  shareEncryptionKey: ShareMetadataBehaviour;

  shareSecretIds: Array<string>;

  constructor(partial: Partial<PatientShareOptions> & Pick<PatientShareOptions, "requestedPermissions" | "shareEncryptionKey" | "shareSecretIds">) {
    this.requestedPermissions = partial.requestedPermissions;
    this.shareEncryptionKey = partial.shareEncryptionKey;
    this.shareSecretIds = partial.shareSecretIds;
  }

}

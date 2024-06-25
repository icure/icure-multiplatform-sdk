// auto-generated file
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';
import {ShareMetadataBehaviour} from './ShareMetadataBehaviour.mjs';


export class ContactShareOptions {

  requestedPermissions: RequestedPermission;

  shareEncryptionKey: ShareMetadataBehaviour;

  sharePatientId: ShareMetadataBehaviour;

  constructor(partial: Partial<ContactShareOptions> & Pick<ContactShareOptions, "requestedPermissions" | "shareEncryptionKey" | "sharePatientId">) {
    this.requestedPermissions = partial.requestedPermissions;
    this.shareEncryptionKey = partial.shareEncryptionKey;
    this.sharePatientId = partial.sharePatientId;
  }

}

// auto-generated file
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';
import {ShareMetadataBehaviour} from './ShareMetadataBehaviour.mjs';


export class DocumentShareOptions {

  requestedPermissions: RequestedPermission;

  shareEncryptionKey: ShareMetadataBehaviour;

  shareMessageId: ShareMetadataBehaviour;

  constructor(partial: Partial<DocumentShareOptions> & Pick<DocumentShareOptions, "requestedPermissions" | "shareEncryptionKey" | "shareMessageId">) {
    this.requestedPermissions = partial.requestedPermissions;
    this.shareEncryptionKey = partial.shareEncryptionKey;
    this.shareMessageId = partial.shareMessageId;
  }

}

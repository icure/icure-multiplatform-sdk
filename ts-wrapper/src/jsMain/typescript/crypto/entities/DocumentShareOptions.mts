// auto-generated file
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';
import {ShareMetadataBehaviour} from './ShareMetadataBehaviour.mjs';
import {SimpleDelegateShareOptions} from './SimpleDelegateShareOptions.mjs';


export class DocumentShareOptions implements SimpleDelegateShareOptions {

  requestedPermissions: RequestedPermission;

  shareEncryptionKey: ShareMetadataBehaviour;

  shareMessageId: ShareMetadataBehaviour;

  shareOwningEntityIds: ShareMetadataBehaviour;

  shareSecretIds: never | undefined;

  constructor(partial: Partial<DocumentShareOptions> & Pick<DocumentShareOptions, "requestedPermissions" | "shareEncryptionKey" | "shareMessageId" | "shareOwningEntityIds" | "shareSecretIds">) {
    this.requestedPermissions = partial.requestedPermissions;
    this.shareEncryptionKey = partial.shareEncryptionKey;
    this.shareMessageId = partial.shareMessageId;
    this.shareOwningEntityIds = partial.shareOwningEntityIds;
    this.shareSecretIds = partial.shareSecretIds;
  }

}

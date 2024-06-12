// auto-generated file
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';
import {ShareMetadataBehaviour} from './ShareMetadataBehaviour.mjs';
import {SimpleDelegateShareOptions} from './SimpleDelegateShareOptions.mjs';


export class TopicShareOptions implements SimpleDelegateShareOptions {

  requestedPermissions: RequestedPermission;

  shareEncryptionKey: ShareMetadataBehaviour;

  sharePatientId: ShareMetadataBehaviour;

  shareOwningEntityIds: ShareMetadataBehaviour;

  shareSecretIds: never | undefined;

  constructor(partial: Partial<TopicShareOptions> & Pick<TopicShareOptions, "requestedPermissions" | "shareEncryptionKey" | "sharePatientId" | "shareOwningEntityIds" | "shareSecretIds">) {
    this.requestedPermissions = partial.requestedPermissions;
    this.shareEncryptionKey = partial.shareEncryptionKey;
    this.sharePatientId = partial.sharePatientId;
    this.shareOwningEntityIds = partial.shareOwningEntityIds;
    this.shareSecretIds = partial.shareSecretIds;
  }

}

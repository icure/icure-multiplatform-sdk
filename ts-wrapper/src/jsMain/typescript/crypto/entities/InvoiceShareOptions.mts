// auto-generated file
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';
import {ShareMetadataBehaviour} from './ShareMetadataBehaviour.mjs';
import {SimpleDelegateShareOptions} from './SimpleDelegateShareOptions.mjs';


export class InvoiceShareOptions implements SimpleDelegateShareOptions {

  requestedPermissions: RequestedPermission;

  shareEncryptionKey: ShareMetadataBehaviour;

  sharePatientId: ShareMetadataBehaviour;

  shareOwningEntityIds: ShareMetadataBehaviour;

  shareSecretIds: never | undefined;

  constructor(partial: Partial<InvoiceShareOptions> & Pick<InvoiceShareOptions, "requestedPermissions" | "shareEncryptionKey" | "sharePatientId" | "shareOwningEntityIds" | "shareSecretIds">) {
    this.requestedPermissions = partial.requestedPermissions;
    this.shareEncryptionKey = partial.shareEncryptionKey;
    this.sharePatientId = partial.sharePatientId;
    this.shareOwningEntityIds = partial.shareOwningEntityIds;
    this.shareSecretIds = partial.shareSecretIds;
  }

}

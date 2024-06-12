// auto-generated file
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';
import {ShareMetadataBehaviour} from './ShareMetadataBehaviour.mjs';


export interface SimpleDelegateShareOptions {

  shareSecretIds: Array<string> | undefined;

  shareEncryptionKey: ShareMetadataBehaviour;

  shareOwningEntityIds: ShareMetadataBehaviour;

  requestedPermissions: RequestedPermission;

}

// auto-generated file
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';
import {SecretIdShareOptions} from './SecretIdShareOptions.mjs';
import {ShareMetadataBehaviour} from './ShareMetadataBehaviour.mjs';


export class MaintenanceTaskShareOptions {

	requestedPermissions: RequestedPermission = RequestedPermission.MaxWrite;

	shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable;

	shareSecretIds: SecretIdShareOptions = new SecretIdShareOptions.AllAvailable();

	constructor(partial: Partial<MaintenanceTaskShareOptions>) {
		if ('requestedPermissions' in partial && partial.requestedPermissions !== undefined) this.requestedPermissions = partial.requestedPermissions;
		if ('shareEncryptionKey' in partial && partial.shareEncryptionKey !== undefined) this.shareEncryptionKey = partial.shareEncryptionKey;
		if ('shareSecretIds' in partial && partial.shareSecretIds !== undefined) this.shareSecretIds = partial.shareSecretIds;
	}

}

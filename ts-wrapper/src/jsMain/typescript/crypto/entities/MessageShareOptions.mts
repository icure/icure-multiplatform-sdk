// auto-generated file
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';
import {SecretIdShareOptions} from './SecretIdShareOptions.mjs';
import {ShareMetadataBehaviour} from './ShareMetadataBehaviour.mjs';


export class MessageShareOptions {

	requestedPermissions: RequestedPermission = RequestedPermission.MaxWrite;

	shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable;

	sharePatientId: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable;

	shareSecretIds: SecretIdShareOptions = new SecretIdShareOptions.AllAvailable({});

	constructor(partial: Partial<MessageShareOptions>) {
		if ('requestedPermissions' in partial && partial.requestedPermissions !== undefined) this.requestedPermissions = partial.requestedPermissions;
		if ('shareEncryptionKey' in partial && partial.shareEncryptionKey !== undefined) this.shareEncryptionKey = partial.shareEncryptionKey;
		if ('sharePatientId' in partial && partial.sharePatientId !== undefined) this.sharePatientId = partial.sharePatientId;
		if ('shareSecretIds' in partial && partial.shareSecretIds !== undefined) this.shareSecretIds = partial.shareSecretIds;
	}

}

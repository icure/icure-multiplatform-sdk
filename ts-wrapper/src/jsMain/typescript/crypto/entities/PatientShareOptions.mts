// auto-generated file
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';
import {ShareMetadataBehaviour} from './ShareMetadataBehaviour.mjs';


export class PatientShareOptions {

	shareSecretIds: Array<string>;

	requestedPermissions: RequestedPermission = RequestedPermission.MaxWrite;

	shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable;

	constructor(partial: Partial<PatientShareOptions> & Pick<PatientShareOptions, "shareSecretIds">) {
		this.shareSecretIds = partial.shareSecretIds;
		if ('requestedPermissions' in partial && partial.requestedPermissions !== undefined) this.requestedPermissions = partial.requestedPermissions;
		if ('shareEncryptionKey' in partial && partial.shareEncryptionKey !== undefined) this.shareEncryptionKey = partial.shareEncryptionKey;
	}

}

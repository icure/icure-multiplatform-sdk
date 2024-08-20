// auto-generated file
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';
import {ShareMetadataBehaviour} from './ShareMetadataBehaviour.mjs';


export class FormShareOptions {

	requestedPermissions: RequestedPermission = RequestedPermission.MaxWrite;

	shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable;

	sharePatientId: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable;

	constructor(partial: Partial<FormShareOptions>) {
		if ('requestedPermissions' in partial && partial.requestedPermissions !== undefined) this.requestedPermissions = partial.requestedPermissions;
		if ('shareEncryptionKey' in partial && partial.shareEncryptionKey !== undefined) this.shareEncryptionKey = partial.shareEncryptionKey;
		if ('sharePatientId' in partial && partial.sharePatientId !== undefined) this.sharePatientId = partial.sharePatientId;
	}

}

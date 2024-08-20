// auto-generated file
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';
import {ShareMetadataBehaviour} from './ShareMetadataBehaviour.mjs';


export class TimeTableShareOptions {

	requestedPermissions: RequestedPermission = RequestedPermission.MaxWrite;

	shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable;

	constructor(partial: Partial<TimeTableShareOptions>) {
		if ('requestedPermissions' in partial && partial.requestedPermissions !== undefined) this.requestedPermissions = partial.requestedPermissions;
		if ('shareEncryptionKey' in partial && partial.shareEncryptionKey !== undefined) this.shareEncryptionKey = partial.shareEncryptionKey;
	}

}

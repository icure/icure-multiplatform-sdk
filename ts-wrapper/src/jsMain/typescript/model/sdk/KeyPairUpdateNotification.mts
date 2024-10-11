// TODO need to auto generate companion
import {SpkiHexString} from '../specializations/SpkiHexString.mjs';
import {DecryptedMaintenanceTask} from "../MaintenanceTask.mjs";
import {InternalKeyPairUpdateNotificationJs_COMPANION} from "../../cardinal-sdk-ts.mjs";

export class KeyPairUpdateNotification {

	newPublicKey: SpkiHexString;

	concernedDataOwnerId: string;

	constructor(partial: Partial<KeyPairUpdateNotification> & Pick<KeyPairUpdateNotification, "newPublicKey" | "concernedDataOwnerId">) {
		this.newPublicKey = partial.newPublicKey;
		this.concernedDataOwnerId = partial.concernedDataOwnerId;
	}

	static get TASK_TYPE(): string {
		return InternalKeyPairUpdateNotificationJs_COMPANION.getInstance().TASK_TYPE
	}

	static parseFromMaintenanceTask(task: DecryptedMaintenanceTask): KeyPairUpdateNotification {
		return InternalKeyPairUpdateNotificationJs_COMPANION.getInstance().parseFromMaintenanceTask(task)
	}
}

// auto-generated file
import {DataOwnerType} from '../../model/DataOwnerType.mjs';
import {KeyPairUpdateNotification} from '../../model/sdk/KeyPairUpdateNotification.mjs';
import {SpkiHexString} from '../../model/specializations/SpkiHexString.mjs';


export interface IcureMaintenanceTaskApi {

	applyKeyPairUpdate(updateRequest: KeyPairUpdateNotification): Promise<void>;

	createKeyPairUpdateNotificationsToAllDelegationCounterparts(key: SpkiHexString,
			options?: { requestToOwnerTypes?: Array<DataOwnerType> | undefined }): Promise<void>;

	createKeyPairUpdateNotificationTo(dataOwnerId: string, key: SpkiHexString): Promise<void>;

}

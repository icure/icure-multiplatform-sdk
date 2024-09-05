// auto-generated file
import {XRsaKeypair} from '../cardinal-sdk-ts.mjs';
import {RecoveryDataKey} from '../crypto/entities/RecoveryDataKey.mjs';
import {RecoveryDataUseFailureReason} from '../crypto/entities/RecoveryDataUseFailureReason.mjs';
import {RecoveryResult} from '../crypto/entities/RecoveryResult.mjs';


export interface RecoveryApi {

	createRecoveryInfoForAvailableKeyPairs(options?: { includeParentsKeys?: boolean, lifetimeSeconds?: number | undefined }): Promise<RecoveryDataKey>;

	recoverKeyPairs(recoveryKey: RecoveryDataKey,
			autoDelete: boolean): Promise<RecoveryResult<{ [ key: string ]: { [ key: string ]: XRsaKeypair } }>>;

	createExchangeDataRecoveryInfo(delegateId: string,
			options?: { lifetimeSeconds?: number | undefined }): Promise<RecoveryDataKey>;

	recoverExchangeData(recoveryKey: RecoveryDataKey): Promise<RecoveryDataUseFailureReason | undefined>;

	deleteRecoveryInfo(recoveryKey: RecoveryDataKey): Promise<void>;

	deleteAllRecoveryInfoFor(dataOwnerId: string): Promise<number>;

	deleteAllKeyPairRecoveryInfoFor(dataOwnerId: string): Promise<number>;

	deleteAllExchangeDataRecoveryInfoFor(dataOwnerId: string): Promise<number>;

}

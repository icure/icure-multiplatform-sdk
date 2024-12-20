// auto-generated file
import {XRsaKeypair} from '../cardinal-sdk-ts.mjs';
import {RecoveryDataKey} from '../crypto/entities/RecoveryDataKey.mjs';
import {RecoveryDataUseFailureReason} from '../crypto/entities/RecoveryDataUseFailureReason.mjs';
import {RecoveryKeySize} from '../crypto/entities/RecoveryKeySize.mjs';
import {RecoveryResult} from '../crypto/entities/RecoveryResult.mjs';


export interface RecoveryApi {

	createRecoveryInfoForAvailableKeyPairs(options?: { includeParentsKeys?: boolean, lifetimeSeconds?: number | undefined, recoveryKeySize?: RecoveryKeySize }): Promise<RecoveryDataKey>;

	recoverKeyPairs(recoveryKey: RecoveryDataKey,
			autoDelete: boolean): Promise<RecoveryResult<{ [ key: string ]: { [ key: string ]: XRsaKeypair } }>>;

	createExchangeDataRecoveryInfo(delegateId: string,
			options?: { lifetimeSeconds?: number | undefined, recoveryKeySize?: RecoveryKeySize }): Promise<RecoveryDataKey>;

	recoverExchangeData(recoveryKey: RecoveryDataKey): Promise<RecoveryDataUseFailureReason | undefined>;

	purgeRecoveryInfo(recoveryKey: RecoveryDataKey): Promise<void>;

	purgeAllRecoveryInfoFor(dataOwnerId: string): Promise<number>;

	purgeAllKeyPairRecoveryInfoFor(dataOwnerId: string): Promise<number>;

	purgeAllExchangeDataRecoveryInfoFor(dataOwnerId: string): Promise<number>;

}

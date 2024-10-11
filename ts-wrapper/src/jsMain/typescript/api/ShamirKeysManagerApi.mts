// auto-generated file
import {ShamirUpdateRequest} from '../crypto/entities/ShamirUpdateRequest.mjs';
import {CryptoActorStubWithType} from '../model/CryptoActorStubWithType.mjs';
import {CryptoActor} from '../model/base/CryptoActor.mjs';
import {KeypairFingerprintV1String} from '../model/specializations/KeypairFingerprintV1String.mjs';


export interface ShamirKeysManagerApi {

	getExistingSplitsInfo(dataOwner: CryptoActor): { [ key: string ]: Array<string> };

	updateSelfSplits(keySplitsToUpdate: { [ key: string ]: ShamirUpdateRequest },
			keySplitsToDelete: Array<KeypairFingerprintV1String>): Promise<CryptoActorStubWithType>;

}

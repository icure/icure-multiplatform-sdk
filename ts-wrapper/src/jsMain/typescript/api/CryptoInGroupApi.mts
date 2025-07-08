// auto-generated file
import {RawDecryptedExchangeData} from '../crypto/entities/RawDecryptedExchangeData.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';


export interface CryptoInGroupApi {

	keylessCreateExchangeDataTo(groupId: string | undefined,
			delegate: EntityReferenceInGroup): Promise<RawDecryptedExchangeData>;

}

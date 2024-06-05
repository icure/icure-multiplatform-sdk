// auto-generated file
import {SpkiHexString} from '../specializations/SpkiHexString.mjs';


export class KeyPairUpdateNotification {

  newPublicKey: SpkiHexString;

  concernedDataOwnerId: string;

  constructor(partial: Partial<KeyPairUpdateNotification> & Pick<KeyPairUpdateNotification, "newPublicKey" | "concernedDataOwnerId">) {
    this.newPublicKey = partial.newPublicKey;
    this.concernedDataOwnerId = partial.concernedDataOwnerId;
  }

}

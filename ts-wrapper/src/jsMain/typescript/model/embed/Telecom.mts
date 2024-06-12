// auto-generated file
import {Base64String} from '../specializations/Base64String.mjs';
import {Encryptable} from './Encryptable.mjs';
import {TelecomType} from './TelecomType.mjs';


export interface Telecom extends Encryptable {

  telecomType: TelecomType | undefined;

  telecomNumber: string | undefined;

  telecomDescription: string | undefined;

  readonly isEncrypted: boolean;

}

export class DecryptedTelecom {

  telecomType: TelecomType | undefined = undefined;

  telecomNumber: string | undefined = undefined;

  telecomDescription: string | undefined = undefined;

  encryptedSelf: Base64String | undefined = undefined;

  readonly isEncrypted: false = false;

  readonly $ktClass: 'com.icure.sdk.model.embed.DecryptedTelecom' = 'com.icure.sdk.model.embed.DecryptedTelecom';

  constructor(partial: Partial<DecryptedTelecom>) {
    if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
    if ('telecomType' in partial) this.telecomType = partial.telecomType;
    if ('telecomNumber' in partial) this.telecomNumber = partial.telecomNumber;
    if ('telecomDescription' in partial) this.telecomDescription = partial.telecomDescription;
    if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
  }

}

export class EncryptedTelecom {

  telecomType: TelecomType | undefined = undefined;

  telecomNumber: string | undefined = undefined;

  telecomDescription: string | undefined = undefined;

  encryptedSelf: Base64String | undefined = undefined;

  readonly isEncrypted: true = true;

  readonly $ktClass: 'com.icure.sdk.model.embed.EncryptedTelecom' = 'com.icure.sdk.model.embed.EncryptedTelecom';

  constructor(partial: Partial<EncryptedTelecom>) {
    if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
    if ('telecomType' in partial) this.telecomType = partial.telecomType;
    if ('telecomNumber' in partial) this.telecomNumber = partial.telecomNumber;
    if ('telecomDescription' in partial) this.telecomDescription = partial.telecomDescription;
    if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
  }

}

// auto-generated file
import {Base64String} from '../specializations/Base64String.mjs';
import {Encryptable} from './Encryptable.mjs';
import {TypedValuesType} from './TypedValuesType.mjs';


export interface TypedValue extends Encryptable {

  type: TypedValuesType | undefined;

  booleanValue: boolean | undefined;

  integerValue: number | undefined;

  doubleValue: number | undefined;

  stringValue: string | undefined;

  dateValue: number | undefined;

  readonly isEncrypted: boolean;

}

export class DecryptedTypedValue {

  type: TypedValuesType | undefined = undefined;

  booleanValue: boolean | undefined = undefined;

  integerValue: number | undefined = undefined;

  doubleValue: number | undefined = undefined;

  stringValue: string | undefined = undefined;

  dateValue: number | undefined = undefined;

  encryptedSelf: Base64String | undefined = undefined;

  readonly isEncrypted: false = false;

  readonly $ktClass: 'com.icure.sdk.model.embed.DecryptedTypedValue' = 'com.icure.sdk.model.embed.DecryptedTypedValue';

  constructor(partial: Partial<DecryptedTypedValue>) {
    if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
    if ('type' in partial) this.type = partial.type;
    if ('booleanValue' in partial) this.booleanValue = partial.booleanValue;
    if ('integerValue' in partial) this.integerValue = partial.integerValue;
    if ('doubleValue' in partial) this.doubleValue = partial.doubleValue;
    if ('stringValue' in partial) this.stringValue = partial.stringValue;
    if ('dateValue' in partial) this.dateValue = partial.dateValue;
    if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
  }

}

export class EncryptedTypedValue {

  type: TypedValuesType | undefined = undefined;

  booleanValue: boolean | undefined = undefined;

  integerValue: number | undefined = undefined;

  doubleValue: number | undefined = undefined;

  stringValue: string | undefined = undefined;

  dateValue: number | undefined = undefined;

  encryptedSelf: Base64String | undefined = undefined;

  readonly isEncrypted: true = true;

  readonly $ktClass: 'com.icure.sdk.model.embed.EncryptedTypedValue' = 'com.icure.sdk.model.embed.EncryptedTypedValue';

  constructor(partial: Partial<EncryptedTypedValue>) {
    if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
    if ('type' in partial) this.type = partial.type;
    if ('booleanValue' in partial) this.booleanValue = partial.booleanValue;
    if ('integerValue' in partial) this.integerValue = partial.integerValue;
    if ('doubleValue' in partial) this.doubleValue = partial.doubleValue;
    if ('stringValue' in partial) this.stringValue = partial.stringValue;
    if ('dateValue' in partial) this.dateValue = partial.dateValue;
    if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
  }

}

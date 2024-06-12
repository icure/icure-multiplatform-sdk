// auto-generated file
import {Base64String} from '../specializations/Base64String.mjs';
import {Encryptable} from './Encryptable.mjs';
import {FlatRateType} from './FlatRateType.mjs';
import {DecryptedValorisation, EncryptedValorisation, Valorisation} from './Valorisation.mjs';


export interface FlatRateTarification extends Encryptable {

  code: string | undefined;

  flatRateType: FlatRateType | undefined;

  label: { [ key: string ]: string } | undefined;

  valorisations: Array<Valorisation>;

  readonly isEncrypted: boolean;

}

export class DecryptedFlatRateTarification {

  code: string | undefined = undefined;

  flatRateType: FlatRateType | undefined = undefined;

  label: { [ key: string ]: string } | undefined = undefined;

  valorisations: Array<DecryptedValorisation> = [];

  encryptedSelf: Base64String | undefined = undefined;

  readonly isEncrypted: false = false;

  readonly $ktClass: 'com.icure.sdk.model.embed.DecryptedFlatRateTarification' = 'com.icure.sdk.model.embed.DecryptedFlatRateTarification';

  constructor(partial: Partial<DecryptedFlatRateTarification>) {
    if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
    if ('code' in partial) this.code = partial.code;
    if ('flatRateType' in partial) this.flatRateType = partial.flatRateType;
    if ('label' in partial) this.label = partial.label;
    if ('valorisations' in partial && partial.valorisations !== undefined) this.valorisations = partial.valorisations;
    if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
  }

}

export class EncryptedFlatRateTarification {

  code: string | undefined = undefined;

  flatRateType: FlatRateType | undefined = undefined;

  label: { [ key: string ]: string } | undefined = undefined;

  valorisations: Array<EncryptedValorisation> = [];

  encryptedSelf: Base64String | undefined = undefined;

  readonly isEncrypted: true = true;

  readonly $ktClass: 'com.icure.sdk.model.embed.EncryptedFlatRateTarification' = 'com.icure.sdk.model.embed.EncryptedFlatRateTarification';

  constructor(partial: Partial<EncryptedFlatRateTarification>) {
    if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
    if ('code' in partial) this.code = partial.code;
    if ('flatRateType' in partial) this.flatRateType = partial.flatRateType;
    if ('label' in partial) this.label = partial.label;
    if ('valorisations' in partial && partial.valorisations !== undefined) this.valorisations = partial.valorisations;
    if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
  }

}

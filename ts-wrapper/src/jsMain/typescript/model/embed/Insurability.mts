// auto-generated file
import {Base64String} from '../specializations/Base64String.mjs';
import {Encryptable} from './Encryptable.mjs';


export interface Insurability extends Encryptable {

  parameters: { [ key: string ]: string };

  hospitalisation: boolean | undefined;

  ambulatory: boolean | undefined;

  dental: boolean | undefined;

  identificationNumber: string | undefined;

  insuranceId: string | undefined;

  startDate: number | undefined;

  endDate: number | undefined;

  titularyId: string | undefined;

  readonly isEncrypted: boolean;

}

export class DecryptedInsurability {

  parameters: { [ key: string ]: string } = {};

  hospitalisation: boolean | undefined = undefined;

  ambulatory: boolean | undefined = undefined;

  dental: boolean | undefined = undefined;

  identificationNumber: string | undefined = undefined;

  insuranceId: string | undefined = undefined;

  startDate: number | undefined = undefined;

  endDate: number | undefined = undefined;

  titularyId: string | undefined = undefined;

  encryptedSelf: Base64String | undefined = undefined;

  readonly isEncrypted: false = false;

  constructor(partial: Partial<DecryptedInsurability>) {
    if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
    if ('parameters' in partial && partial.parameters !== undefined) this.parameters = partial.parameters;
    if ('hospitalisation' in partial) this.hospitalisation = partial.hospitalisation;
    if ('ambulatory' in partial) this.ambulatory = partial.ambulatory;
    if ('dental' in partial) this.dental = partial.dental;
    if ('identificationNumber' in partial) this.identificationNumber = partial.identificationNumber;
    if ('insuranceId' in partial) this.insuranceId = partial.insuranceId;
    if ('startDate' in partial) this.startDate = partial.startDate;
    if ('endDate' in partial) this.endDate = partial.endDate;
    if ('titularyId' in partial) this.titularyId = partial.titularyId;
    if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
  }

}

export class EncryptedInsurability {

  parameters: { [ key: string ]: string } = {};

  hospitalisation: boolean | undefined = undefined;

  ambulatory: boolean | undefined = undefined;

  dental: boolean | undefined = undefined;

  identificationNumber: string | undefined = undefined;

  insuranceId: string | undefined = undefined;

  startDate: number | undefined = undefined;

  endDate: number | undefined = undefined;

  titularyId: string | undefined = undefined;

  encryptedSelf: Base64String | undefined = undefined;

  readonly isEncrypted: true = true;

  constructor(partial: Partial<EncryptedInsurability>) {
    if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
    if ('parameters' in partial && partial.parameters !== undefined) this.parameters = partial.parameters;
    if ('hospitalisation' in partial) this.hospitalisation = partial.hospitalisation;
    if ('ambulatory' in partial) this.ambulatory = partial.ambulatory;
    if ('dental' in partial) this.dental = partial.dental;
    if ('identificationNumber' in partial) this.identificationNumber = partial.identificationNumber;
    if ('insuranceId' in partial) this.insuranceId = partial.insuranceId;
    if ('startDate' in partial) this.startDate = partial.startDate;
    if ('endDate' in partial) this.endDate = partial.endDate;
    if ('titularyId' in partial) this.titularyId = partial.titularyId;
    if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
  }

}

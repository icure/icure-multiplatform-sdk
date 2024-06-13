// auto-generated file
import {Base64String} from '../specializations/Base64String.mjs';
import {Encryptable} from './Encryptable.mjs';
import {PatientHealthCarePartyType} from './PatientHealthCarePartyType.mjs';
import {ReferralPeriod} from './ReferralPeriod.mjs';
import {TelecomType} from './TelecomType.mjs';


export interface PatientHealthCareParty extends Encryptable {

  type: PatientHealthCarePartyType | undefined;

  healthcarePartyId: string | undefined;

  sendFormats: { [ key in TelecomType ]?: string };

  referralPeriods: Array<ReferralPeriod>;

  referral: boolean;

  readonly isEncrypted: boolean;

}

export class DecryptedPatientHealthCareParty {

  type: PatientHealthCarePartyType | undefined = undefined;

  healthcarePartyId: string | undefined = undefined;

  sendFormats: { [ key in TelecomType ]?: string } = {};

  referralPeriods: Array<ReferralPeriod> = [];

  referral: boolean = false;

  encryptedSelf: Base64String | undefined = undefined;

  readonly isEncrypted: false = false;

  constructor(partial: Partial<DecryptedPatientHealthCareParty>) {
    if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
    if ('type' in partial) this.type = partial.type;
    if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
    if ('sendFormats' in partial && partial.sendFormats !== undefined) this.sendFormats = partial.sendFormats;
    if ('referralPeriods' in partial && partial.referralPeriods !== undefined) this.referralPeriods = partial.referralPeriods;
    if ('referral' in partial && partial.referral !== undefined) this.referral = partial.referral;
    if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
  }

}

export class EncryptedPatientHealthCareParty {

  type: PatientHealthCarePartyType | undefined = undefined;

  healthcarePartyId: string | undefined = undefined;

  sendFormats: { [ key in TelecomType ]?: string } = {};

  referralPeriods: Array<ReferralPeriod> = [];

  referral: boolean = false;

  encryptedSelf: Base64String | undefined = undefined;

  readonly isEncrypted: true = true;

  constructor(partial: Partial<EncryptedPatientHealthCareParty>) {
    if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
    if ('type' in partial) this.type = partial.type;
    if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
    if ('sendFormats' in partial && partial.sendFormats !== undefined) this.sendFormats = partial.sendFormats;
    if ('referralPeriods' in partial && partial.referralPeriods !== undefined) this.referralPeriods = partial.referralPeriods;
    if ('referral' in partial && partial.referral !== undefined) this.referral = partial.referral;
    if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
  }

}

// auto-generated file
import {Base64String} from '../specializations/Base64String.mjs';
import {Encryptable} from './Encryptable.mjs';
import {MembershipType} from './MembershipType.mjs';


export interface CareTeamMembership extends Encryptable {

  startDate: number | undefined;

  endDate: number | undefined;

  careTeamMemberId: string | undefined;

  membershipType: MembershipType | undefined;

  readonly isEncrypted: boolean;

}

export class DecryptedCareTeamMembership {

  startDate: number | undefined = undefined;

  endDate: number | undefined = undefined;

  careTeamMemberId: string | undefined = undefined;

  membershipType: MembershipType | undefined = undefined;

  encryptedSelf: Base64String | undefined = undefined;

  readonly isEncrypted: false = false;

  readonly $ktClass: 'com.icure.sdk.model.embed.DecryptedCareTeamMembership' = 'com.icure.sdk.model.embed.DecryptedCareTeamMembership';

  constructor(partial: Partial<DecryptedCareTeamMembership>) {
    if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
    if ('startDate' in partial) this.startDate = partial.startDate;
    if ('endDate' in partial) this.endDate = partial.endDate;
    if ('careTeamMemberId' in partial) this.careTeamMemberId = partial.careTeamMemberId;
    if ('membershipType' in partial) this.membershipType = partial.membershipType;
    if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
  }

}

export class EncryptedCareTeamMembership {

  startDate: number | undefined = undefined;

  endDate: number | undefined = undefined;

  careTeamMemberId: string | undefined = undefined;

  membershipType: MembershipType | undefined = undefined;

  encryptedSelf: Base64String | undefined = undefined;

  readonly isEncrypted: true = true;

  readonly $ktClass: 'com.icure.sdk.model.embed.EncryptedCareTeamMembership' = 'com.icure.sdk.model.embed.EncryptedCareTeamMembership';

  constructor(partial: Partial<EncryptedCareTeamMembership>) {
    if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
    if ('startDate' in partial) this.startDate = partial.startDate;
    if ('endDate' in partial) this.endDate = partial.endDate;
    if ('careTeamMemberId' in partial) this.careTeamMemberId = partial.careTeamMemberId;
    if ('membershipType' in partial) this.membershipType = partial.membershipType;
    if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
  }

}

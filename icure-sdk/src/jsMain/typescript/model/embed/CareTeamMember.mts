// auto-generated file
import {randomUuid} from '../../utils/Id.mjs';
import {CodeStub} from '../base/CodeStub.mjs';
import {Identifiable} from '../base/Identifiable.mjs';
import {Base64String} from '../specializations/Base64String.mjs';
import {CareTeamMemberType} from './CareTeamMemberType.mjs';
import {Encryptable} from './Encryptable.mjs';


export interface CareTeamMember extends Encryptable, Identifiable<string> {

  careTeamMemberType: CareTeamMemberType | undefined;

  healthcarePartyId: string | undefined;

  quality: CodeStub | undefined;

  readonly isEncrypted: boolean;

}

export class DecryptedCareTeamMember {

  id: string;

  careTeamMemberType: CareTeamMemberType | undefined = undefined;

  healthcarePartyId: string | undefined = undefined;

  quality: CodeStub | undefined = undefined;

  encryptedSelf: Base64String | undefined = undefined;

  readonly isEncrypted: false = false;

  readonly $ktClass: 'com.icure.sdk.model.embed.DecryptedCareTeamMember' = 'com.icure.sdk.model.embed.DecryptedCareTeamMember';

  constructor(partial: Partial<DecryptedCareTeamMember>) {
    if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
    this.id = partial.id ?? randomUuid();
    if ('careTeamMemberType' in partial) this.careTeamMemberType = partial.careTeamMemberType;
    if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
    if ('quality' in partial) this.quality = partial.quality;
    if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
  }

}

export class EncryptedCareTeamMember {

  id: string;

  careTeamMemberType: CareTeamMemberType | undefined = undefined;

  healthcarePartyId: string | undefined = undefined;

  quality: CodeStub | undefined = undefined;

  encryptedSelf: Base64String | undefined = undefined;

  readonly isEncrypted: true = true;

  readonly $ktClass: 'com.icure.sdk.model.embed.EncryptedCareTeamMember' = 'com.icure.sdk.model.embed.EncryptedCareTeamMember';

  constructor(partial: Partial<EncryptedCareTeamMember>) {
    if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
    this.id = partial.id ?? randomUuid();
    if ('careTeamMemberType' in partial) this.careTeamMemberType = partial.careTeamMemberType;
    if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
    if ('quality' in partial) this.quality = partial.quality;
    if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
  }

}

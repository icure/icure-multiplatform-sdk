// auto-generated file
import {PartnershipStatus} from './PartnershipStatus.mjs';
import {PartnershipType} from './PartnershipType.mjs';


export class Partnership {

  type: PartnershipType | undefined = undefined;

  status: PartnershipStatus | undefined = undefined;

  partnerId: string | undefined = undefined;

  meToOtherRelationshipDescription: string | undefined = undefined;

  otherToMeRelationshipDescription: string | undefined = undefined;

  constructor(partial: Partial<Partnership>) {
    if ('type' in partial) this.type = partial.type;
    if ('status' in partial) this.status = partial.status;
    if ('partnerId' in partial) this.partnerId = partial.partnerId;
    if ('meToOtherRelationshipDescription' in partial) this.meToOtherRelationshipDescription = partial.meToOtherRelationshipDescription;
    if ('otherToMeRelationshipDescription' in partial) this.otherToMeRelationshipDescription = partial.otherToMeRelationshipDescription;
  }

}

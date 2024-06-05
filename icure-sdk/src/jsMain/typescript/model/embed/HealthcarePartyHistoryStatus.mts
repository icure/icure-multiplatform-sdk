// auto-generated file
import {HealthcarePartyStatus} from './HealthcarePartyStatus.mjs';


export class HealthcarePartyHistoryStatus {

  status: HealthcarePartyStatus;

  specialisationCode: string;

  startDate: number;

  active: boolean;

  constructor(partial: Partial<HealthcarePartyHistoryStatus> & Pick<HealthcarePartyHistoryStatus, "status" | "specialisationCode" | "startDate" | "active">) {
    this.status = partial.status;
    this.specialisationCode = partial.specialisationCode;
    this.startDate = partial.startDate;
    this.active = partial.active;
  }

}

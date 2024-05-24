// auto-generated file

export class ReferralPeriod {

  startDate: number | undefined = undefined;

  endDate: number | undefined = undefined;

  comment: string | undefined = undefined;

  constructor(partial: Partial<ReferralPeriod>) {
    if ('startDate' in partial) this.startDate = partial.startDate;
    if ('endDate' in partial) this.endDate = partial.endDate;
    if ('comment' in partial) this.comment = partial.comment;
  }

}

// auto-generated file

export class AuthenticationToken {

  token: string | undefined = undefined;

  creationTime: number;

  validity: number;

  deletionDate: number | undefined = undefined;

  constructor(partial: Partial<AuthenticationToken> & Pick<AuthenticationToken, "creationTime" | "validity">) {
    if ('token' in partial) this.token = partial.token;
    this.creationTime = partial.creationTime;
    this.validity = partial.validity;
    if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
  }

}

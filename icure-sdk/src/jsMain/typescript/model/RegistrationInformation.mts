// auto-generated file

export class RegistrationInformation {

  firstName: string;

  lastName: string;

  emailAddress: string;

  userOptions: string | undefined = undefined;

  userRoles: Array<string> = [];

  minimumKrakenVersion: string | undefined = undefined;

  constructor(partial: Partial<RegistrationInformation> & Pick<RegistrationInformation, "firstName" | "lastName" | "emailAddress">) {
    this.firstName = partial.firstName;
    this.lastName = partial.lastName;
    this.emailAddress = partial.emailAddress;
    if ('userOptions' in partial) this.userOptions = partial.userOptions;
    if ('userRoles' in partial && partial.userRoles !== undefined) this.userRoles = partial.userRoles;
    if ('minimumKrakenVersion' in partial) this.minimumKrakenVersion = partial.minimumKrakenVersion;
  }

}

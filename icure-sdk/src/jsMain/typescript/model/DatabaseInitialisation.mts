// auto-generated file
import {HealthcareParty} from './HealthcareParty.mjs';
import {Replication} from './Replication.mjs';
import {User} from './User.mjs';


export class DatabaseInitialisation {

  users: Array<User> | undefined = [];

  healthcareParties: Array<HealthcareParty> | undefined = [];

  replication: Replication | undefined = undefined;

  minimumKrakenVersion: string | undefined = undefined;

  constructor(partial: Partial<DatabaseInitialisation>) {
    if ('users' in partial) this.users = partial.users;
    if ('healthcareParties' in partial) this.healthcareParties = partial.healthcareParties;
    if ('replication' in partial) this.replication = partial.replication;
    if ('minimumKrakenVersion' in partial) this.minimumKrakenVersion = partial.minimumKrakenVersion;
  }

}

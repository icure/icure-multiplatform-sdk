// auto-generated file
import {randomUuid} from '../utils/Id.mjs';
import {Identifiable} from './base/Identifiable.mjs';
import {Named} from './base/Named.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {DatabaseSynchronization} from './embed/DatabaseSynchronization.mjs';


export class Replication implements StoredDocument, Identifiable<string>, Named {

  id: string;

  rev: string | undefined = undefined;

  deletionDate: number | undefined = undefined;

  name: string | undefined = undefined;

  context: string | undefined = undefined;

  databaseSynchronizations: Array<DatabaseSynchronization> = [];

  constructor(partial: Partial<Replication>) {
    this.id = partial.id ?? randomUuid();
    if ('rev' in partial) this.rev = partial.rev;
    if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
    if ('name' in partial) this.name = partial.name;
    if ('context' in partial) this.context = partial.context;
    if ('databaseSynchronizations' in partial && partial.databaseSynchronizations !== undefined) this.databaseSynchronizations = partial.databaseSynchronizations;
  }

}

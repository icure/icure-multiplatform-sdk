// auto-generated file
import {randomUuid} from '../utils/Id.mjs';
import {DecryptedPropertyStub} from './PropertyStub.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {FrontEndMigrationStatus} from './embed/FrontEndMigrationStatus.mjs';


export class FrontEndMigration implements StoredDocument {

  id: string;

  rev: string | undefined = undefined;

  deletionDate: number | undefined = undefined;

  name: string | undefined = undefined;

  startDate: number | undefined = undefined;

  endDate: number | undefined = undefined;

  status: FrontEndMigrationStatus | undefined = undefined;

  logs: string | undefined = undefined;

  userId: string | undefined = undefined;

  startKey: string | undefined = undefined;

  startKeyDocId: string | undefined = undefined;

  processCount: number | undefined = undefined;

  properties: Array<DecryptedPropertyStub> = [];

  constructor(partial: Partial<FrontEndMigration>) {
    this.id = partial.id ?? randomUuid();
    if ('rev' in partial) this.rev = partial.rev;
    if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
    if ('name' in partial) this.name = partial.name;
    if ('startDate' in partial) this.startDate = partial.startDate;
    if ('endDate' in partial) this.endDate = partial.endDate;
    if ('status' in partial) this.status = partial.status;
    if ('logs' in partial) this.logs = partial.logs;
    if ('userId' in partial) this.userId = partial.userId;
    if ('startKey' in partial) this.startKey = partial.startKey;
    if ('startKeyDocId' in partial) this.startKeyDocId = partial.startKeyDocId;
    if ('processCount' in partial) this.processCount = partial.processCount;
    if ('properties' in partial && partial.properties !== undefined) this.properties = partial.properties;
  }

}

// auto-generated file
import {randomUuid} from '../../utils/Id.mjs';
import {Versionable} from '../base/Versionable.mjs';
import {Remote} from './Remote.mjs';
import {ReplicationStats} from './ReplicationStats.mjs';


export class ReplicatorDocument implements Versionable<string> {

  id: string;

  rev: string | undefined = undefined;

  source: Remote | undefined = undefined;

  target: Remote | undefined = undefined;

  owner: string | undefined = undefined;

  create_target: boolean | undefined = undefined;

  continuous: boolean | undefined = undefined;

  doc_ids: Array<string> | undefined = undefined;

  replicationState: string | undefined = undefined;

  replicationStateTime: string | undefined = undefined;

  replicationStats: ReplicationStats | undefined = undefined;

  errorCount: number | undefined = undefined;

  revsInfo: Array<{ [ key: string ]: string }> | undefined = undefined;

  revHistory: { [ key: string ]: string } | undefined = undefined;

  constructor(partial: Partial<ReplicatorDocument>) {
    this.id = partial.id ?? randomUuid();
    if ('rev' in partial) this.rev = partial.rev;
    if ('source' in partial) this.source = partial.source;
    if ('target' in partial) this.target = partial.target;
    if ('owner' in partial) this.owner = partial.owner;
    if ('create_target' in partial) this.create_target = partial.create_target;
    if ('continuous' in partial) this.continuous = partial.continuous;
    if ('doc_ids' in partial) this.doc_ids = partial.doc_ids;
    if ('replicationState' in partial) this.replicationState = partial.replicationState;
    if ('replicationStateTime' in partial) this.replicationStateTime = partial.replicationStateTime;
    if ('replicationStats' in partial) this.replicationStats = partial.replicationStats;
    if ('errorCount' in partial) this.errorCount = partial.errorCount;
    if ('revsInfo' in partial) this.revsInfo = partial.revsInfo;
    if ('revHistory' in partial) this.revHistory = partial.revHistory;
  }

}

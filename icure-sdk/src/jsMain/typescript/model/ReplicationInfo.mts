// auto-generated file

export class ReplicationInfo {

  active: boolean = false;

  running: boolean = false;

  pendingFrom: number | undefined = undefined;

  pendingTo: number | undefined = undefined;

  constructor(partial: Partial<ReplicationInfo>) {
    if ('active' in partial && partial.active !== undefined) this.active = partial.active;
    if ('running' in partial && partial.running !== undefined) this.running = partial.running;
    if ('pendingFrom' in partial) this.pendingFrom = partial.pendingFrom;
    if ('pendingTo' in partial) this.pendingTo = partial.pendingTo;
  }

}

// auto-generated file

export class DatabaseSynchronization {

  source: string | undefined = undefined;

  target: string | undefined = undefined;

  filter: string | undefined = undefined;

  localTarget: DatabaseSynchronization.Target | undefined = undefined;

  constructor(partial: Partial<DatabaseSynchronization>) {
    if ('source' in partial) this.source = partial.source;
    if ('target' in partial) this.target = partial.target;
    if ('filter' in partial) this.filter = partial.filter;
    if ('localTarget' in partial) this.localTarget = partial.localTarget;
  }

}

export namespace DatabaseSynchronization {

  export enum Target {
    Base = "Base",
    Healthdata = "Healthdata",
    Patient = "Patient"
  }

}

// auto-generated file

export class ReplicationStats {

  revisionsChecked: number | undefined = undefined;

  missingRevisionsFound: number | undefined = undefined;

  docsRead: number | undefined = undefined;

  docsWritten: number | undefined = undefined;

  changesPending: number | undefined = undefined;

  docWriteFailures: number | undefined = undefined;

  checkpointedSourceSeq: string | undefined = undefined;

  startTime: string | undefined = undefined;

  error: string | undefined = undefined;

  constructor(partial: Partial<ReplicationStats>) {
    if ('revisionsChecked' in partial) this.revisionsChecked = partial.revisionsChecked;
    if ('missingRevisionsFound' in partial) this.missingRevisionsFound = partial.missingRevisionsFound;
    if ('docsRead' in partial) this.docsRead = partial.docsRead;
    if ('docsWritten' in partial) this.docsWritten = partial.docsWritten;
    if ('changesPending' in partial) this.changesPending = partial.changesPending;
    if ('docWriteFailures' in partial) this.docWriteFailures = partial.docWriteFailures;
    if ('checkpointedSourceSeq' in partial) this.checkpointedSourceSeq = partial.checkpointedSourceSeq;
    if ('startTime' in partial) this.startTime = partial.startTime;
    if ('error' in partial) this.error = partial.error;
  }

}

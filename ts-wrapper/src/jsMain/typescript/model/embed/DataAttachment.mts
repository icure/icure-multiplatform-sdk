// auto-generated file

export class DataAttachment {

  couchDbAttachmentId: string | undefined = undefined;

  objectStoreAttachmentId: string | undefined = undefined;

  utis: Array<string> = [];

  constructor(partial: Partial<DataAttachment>) {
    if ('couchDbAttachmentId' in partial) this.couchDbAttachmentId = partial.couchDbAttachmentId;
    if ('objectStoreAttachmentId' in partial) this.objectStoreAttachmentId = partial.objectStoreAttachmentId;
    if ('utis' in partial && partial.utis !== undefined) this.utis = partial.utis;
  }

}

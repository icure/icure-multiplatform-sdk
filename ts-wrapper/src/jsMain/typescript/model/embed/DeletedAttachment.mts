// auto-generated file

export class DeletedAttachment {

  couchDbAttachmentId: string | undefined = undefined;

  objectStoreAttachmentId: string | undefined = undefined;

  key: string | undefined = undefined;

  deletionTime: number | undefined = undefined;

  constructor(partial: Partial<DeletedAttachment>) {
    if ('couchDbAttachmentId' in partial) this.couchDbAttachmentId = partial.couchDbAttachmentId;
    if ('objectStoreAttachmentId' in partial) this.objectStoreAttachmentId = partial.objectStoreAttachmentId;
    if ('key' in partial) this.key = partial.key;
    if ('deletionTime' in partial) this.deletionTime = partial.deletionTime;
  }

}

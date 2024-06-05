// auto-generated file

export class IdentityDocumentReader {

  justificatifDocumentNumber: string | undefined = undefined;

  supportSerialNumber: string | undefined = undefined;

  timeReadingEIdDocument: number | undefined = undefined;

  eidDocumentSupportType: number = 0;

  reasonManualEncoding: number = 0;

  reasonUsingVignette: number = 0;

  constructor(partial: Partial<IdentityDocumentReader>) {
    if ('justificatifDocumentNumber' in partial) this.justificatifDocumentNumber = partial.justificatifDocumentNumber;
    if ('supportSerialNumber' in partial) this.supportSerialNumber = partial.supportSerialNumber;
    if ('timeReadingEIdDocument' in partial) this.timeReadingEIdDocument = partial.timeReadingEIdDocument;
    if ('eidDocumentSupportType' in partial && partial.eidDocumentSupportType !== undefined) this.eidDocumentSupportType = partial.eidDocumentSupportType;
    if ('reasonManualEncoding' in partial && partial.reasonManualEncoding !== undefined) this.reasonManualEncoding = partial.reasonManualEncoding;
    if ('reasonUsingVignette' in partial && partial.reasonUsingVignette !== undefined) this.reasonUsingVignette = partial.reasonUsingVignette;
  }

}

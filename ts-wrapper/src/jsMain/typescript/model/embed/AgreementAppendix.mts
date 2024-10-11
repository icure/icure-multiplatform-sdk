// auto-generated file

export class AgreementAppendix {

	docSeq: number | undefined = undefined;

	verseSeq: number | undefined = undefined;

	documentId: string | undefined = undefined;

	path: string | undefined = undefined;

	constructor(partial: Partial<AgreementAppendix>) {
		if ('docSeq' in partial) this.docSeq = partial.docSeq;
		if ('verseSeq' in partial) this.verseSeq = partial.verseSeq;
		if ('documentId' in partial) this.documentId = partial.documentId;
		if ('path' in partial) this.path = partial.path;
	}

}

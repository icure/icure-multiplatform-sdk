// auto-generated file

export class DocIdentifier {

  id: string | undefined = undefined;

  rev: string | undefined = undefined;

  constructor(partial: Partial<DocIdentifier>) {
    if ('id' in partial) this.id = partial.id;
    if ('rev' in partial) this.rev = partial.rev;
  }

}

// auto-generated file
import {randomUuid} from '../utils/Id.mjs';
import {Named} from './base/Named.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {DecryptedAddress} from './embed/Address.mjs';


export class Place implements StoredDocument, Named {

  id: string;

  rev: string | undefined = undefined;

  deletionDate: number | undefined = undefined;

  name: string | undefined = undefined;

  address: DecryptedAddress | undefined = undefined;

  constructor(partial: Partial<Place>) {
    this.id = partial.id ?? randomUuid();
    if ('rev' in partial) this.rev = partial.rev;
    if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
    if ('name' in partial) this.name = partial.name;
    if ('address' in partial) this.address = partial.address;
  }

}

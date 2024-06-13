// auto-generated file
import {randomUuid} from '../../utils/Id.mjs';
import {Identifiable} from '../base/Identifiable.mjs';
import {Named} from '../base/Named.mjs';
import {Base64String} from '../specializations/Base64String.mjs';
import {Encryptable} from './Encryptable.mjs';


export interface Episode extends Encryptable, Identifiable<string>, Named {

  comment: string | undefined;

  startDate: number | undefined;

  endDate: number | undefined;

  readonly isEncrypted: boolean;

}

export class DecryptedEpisode {

  id: string;

  name: string | undefined = undefined;

  comment: string | undefined = undefined;

  startDate: number | undefined = undefined;

  endDate: number | undefined = undefined;

  encryptedSelf: Base64String | undefined = undefined;

  readonly isEncrypted: false = false;

  constructor(partial: Partial<DecryptedEpisode>) {
    if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
    this.id = partial.id ?? randomUuid();
    if ('name' in partial) this.name = partial.name;
    if ('comment' in partial) this.comment = partial.comment;
    if ('startDate' in partial) this.startDate = partial.startDate;
    if ('endDate' in partial) this.endDate = partial.endDate;
    if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
  }

}

export class EncryptedEpisode {

  id: string;

  name: string | undefined = undefined;

  comment: string | undefined = undefined;

  startDate: number | undefined = undefined;

  endDate: number | undefined = undefined;

  encryptedSelf: Base64String | undefined = undefined;

  readonly isEncrypted: true = true;

  constructor(partial: Partial<EncryptedEpisode>) {
    if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
    this.id = partial.id ?? randomUuid();
    if ('name' in partial) this.name = partial.name;
    if ('comment' in partial) this.comment = partial.comment;
    if ('startDate' in partial) this.startDate = partial.startDate;
    if ('endDate' in partial) this.endDate = partial.endDate;
    if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
  }

}

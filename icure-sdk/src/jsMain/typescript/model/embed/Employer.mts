// auto-generated file
import {Named} from '../base/Named.mjs';
import {DecryptedAddress} from './Address.mjs';


export class Employer implements Named {

  name: string | undefined = undefined;

  addresse: DecryptedAddress | undefined = undefined;

  constructor(partial: Partial<Employer>) {
    if ('name' in partial) this.name = partial.name;
    if ('addresse' in partial) this.addresse = partial.addresse;
  }

}

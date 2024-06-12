// auto-generated file
import {RemoteAuthentication} from './RemoteAuthentication.mjs';


export class Remote {

  url: string;

  auth: RemoteAuthentication | undefined = undefined;

  constructor(partial: Partial<Remote> & Pick<Remote, "url">) {
    this.url = partial.url;
    if ('auth' in partial) this.auth = partial.auth;
  }

}

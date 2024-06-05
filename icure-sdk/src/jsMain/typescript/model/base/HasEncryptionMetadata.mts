// auto-generated file
import {Delegation} from '../embed/Delegation.mjs';
import {SecurityMetadata} from '../embed/SecurityMetadata.mjs';
import {Versionable} from './Versionable.mjs';


export interface HasEncryptionMetadata extends Versionable<string> {

  secretForeignKeys: Array<string>;

  cryptedForeignKeys: { [ key: string ]: Array<Delegation> };

  delegations: { [ key: string ]: Array<Delegation> };

  encryptionKeys: { [ key: string ]: Array<Delegation> };

  securityMetadata: SecurityMetadata | undefined;

}

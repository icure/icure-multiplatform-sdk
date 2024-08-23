import {XCryptoService} from "../crypto/CryptoService.mjs";
import {UserGroup} from "../model/UserGroup.mjs";
import {KeyStorageFacade} from "../storage/StorageFacade.mjs";
import {CryptoStrategies} from "../crypto/CryptoStrategies.mjs";
import {IcureKeyStorageOptions} from "../icure-sdk-ts.mjs";

export interface ApiOptions {
  /**
   * Configure which fields of entities should be encrypted
   */
  readonly encryptedFields?: EncryptedFieldsConfiguration
  /**
   * Has only effect when logging in as an hcp user.
   *
   * If false the api will be initialized in a hierarchical mode, where each data owner is considered to have access
   * to all data of his parents (requires corresponding permission on the server side).
   * In this case the sdk will also expect to have access to at least a key for each parent data owner of the current
   * user.
   *
   * If true the api will ignore the data owner hierarchies.
   * Each data owner is considered to have access only to data shared explicitly with him, and has access only to his
   * own keys.
   */
  readonly disableParentKeysInitialisation?: boolean
  /**
   * If true (default) the sdk will automatically create the transfer keys for the current user if a new keypair is
   * created.
   */
  readonly createTransferKeys?: boolean
  /**
   * Service for encryption primitives.
   */
  readonly cryptoService?: XCryptoService
  /**
   * If true (default) the password of the user will be salted together with the application id before sending it to
   * the iCure backend for login or when changing the user password.
   * This is done in addition to the server-side salting of the password before storing them.
   *
   * By enabling this option iCure never gets access to the plain text password of users.
   * Note that changing this value in a second moment requires also modifying the password of the user on the iCure
   * databases to reflect the change.
   */
  readonly saltPasswordWithApplicationId?: boolean
  /**
   * An instance of iCure SDK is initialized for working as a specific user in a single group.
   * However, the user credentials may match multiple users in different groups (but at most one per group).
   * If that is the case, this function will be used to pick the actual user for which the sdk will be initialized.
   *
   * This is mandatory in multi-group applications, where a single user could exist in multiple groups.
   * If this parameter is null and the user credentials match multiple users the api initialisation will fail.
   * In single-group applications this parameter won't be used, so it can be left as null.
   */
  readonly groupSelector?: (availableGroups: Array<UserGroup>) => Promise<string>
  /**
   * Options to support the migration of data created using iCure versions from before 2018.
   * Leave it as false (default) unless explicitly instructed to set it to true by the iCure team.
   */
  readonly autoCreateEncryptionKeyForExistingLegacyData?: boolean
  /**
   * Implementation of key storage to use.
   * If not provided the sdk will store the keys in the StorageFacade provided to the api initialization method.
   */
  readonly keyStorage?: KeyStorageFacade | IcureKeyStorageOptions
  /**
   * Custom crypto strategies. If not provided the sdk will use crypto strategies that:
   * - Allow for the creation of a new key of the data owner
   * - Do not use any custom key recovery solutions
   * - Considers any keys recovered using iCure's recovery methods as unverified
   * - Considers all public keys of other data owners as verified
   * - Considers patients as anonymous data owners
   */
  readonly cryptoStrategies?: CryptoStrategies
}

export interface EncryptedFieldsConfiguration {
  readonly accessLog?: Array<string>
  readonly calendarItem?: Array<string>
  readonly contact?: Array<string>
  readonly service?: Array<string>
  readonly healthElement?: Array<string>
  readonly maintenanceTask?: Array<string>
  readonly patient?: Array<string>
  readonly message?: Array<string>
  readonly topic?: Array<string>
  readonly document?: Array<string>
  readonly form?: Array<string>
  readonly receipt?: Array<string>
  readonly classification?: Array<string>
  readonly timeTable?: Array<string>
  readonly invoice?: Array<string>
}
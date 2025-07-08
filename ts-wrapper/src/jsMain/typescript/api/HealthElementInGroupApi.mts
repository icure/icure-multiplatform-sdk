// auto-generated file
import {HealthElementShareOptions} from '../crypto/entities/HealthElementShareOptions.mjs';
import {SecretIdUseOption} from '../crypto/entities/SecretIdUseOption.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {DecryptedHealthElement, EncryptedHealthElement, HealthElement} from '../model/HealthElement.mjs';
import {Patient} from '../model/Patient.mjs';
import {User} from '../model/User.mjs';
import {AccessLevel} from '../model/embed/AccessLevel.mjs';
import {HexString} from '../model/specializations/HexString.mjs';
import {ArrayWithUniqueKeys} from '../utils/ArrayWithUniqueKeys.mjs';
import {HealthElementFlavouredInGroupApi} from './HealthElementFlavouredInGroupApi.mjs';


export interface HealthElementInGroupApi {

	encrypted: HealthElementFlavouredInGroupApi<EncryptedHealthElement>;

	tryAndRecover: HealthElementFlavouredInGroupApi<HealthElement>;

	withEncryptionMetadata(entityGroupId: string, base: DecryptedHealthElement | undefined,
			patient: GroupScoped<Patient>,
			options?: { user?: User | undefined, delegates?: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, accessLevel: AccessLevel }, 'delegate'>, secretId?: SecretIdUseOption, alternateRootDelegateReference?: EntityReferenceInGroup | undefined }): Promise<GroupScoped<DecryptedHealthElement>>;

	getEncryptionKeysOf(healthElement: GroupScoped<HealthElement>): Promise<Array<HexString>>;

	hasWriteAccess(healthElement: GroupScoped<HealthElement>): Promise<boolean>;

	decryptPatientIdOf(healthElement: GroupScoped<HealthElement>): Promise<Array<EntityReferenceInGroup>>;

	createDelegationDeAnonymizationMetadata(entity: GroupScoped<HealthElement>,
			delegates: Array<EntityReferenceInGroup>): Promise<void>;

	decrypt(healthElements: Array<GroupScoped<EncryptedHealthElement>>): Promise<Array<GroupScoped<DecryptedHealthElement>>>;

	tryDecrypt(healthElements: Array<GroupScoped<EncryptedHealthElement>>): Promise<Array<GroupScoped<HealthElement>>>;

	encryptOrValidate(healthElements: Array<GroupScoped<HealthElement>>): Promise<Array<GroupScoped<EncryptedHealthElement>>>;

	shareWith(delegate: EntityReferenceInGroup, healthElement: GroupScoped<DecryptedHealthElement>,
			options?: { options?: HealthElementShareOptions | undefined }): Promise<GroupScoped<DecryptedHealthElement>>;

	shareWithMany(healthElement: GroupScoped<DecryptedHealthElement>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: HealthElementShareOptions }, 'delegate'>): Promise<GroupScoped<DecryptedHealthElement>>;

	createHealthElement(entity: GroupScoped<DecryptedHealthElement>): Promise<GroupScoped<DecryptedHealthElement>>;

	modifyHealthElement(entity: GroupScoped<DecryptedHealthElement>): Promise<GroupScoped<DecryptedHealthElement>>;

	getHealthElement(groupId: string,
			entityId: string): Promise<GroupScoped<DecryptedHealthElement> | undefined>;

}

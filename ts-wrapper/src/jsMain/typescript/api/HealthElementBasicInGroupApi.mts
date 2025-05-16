// auto-generated file
import {GroupScoped} from '../model/GroupScoped.mjs';
import {EncryptedHealthElement} from '../model/HealthElement.mjs';


export interface HealthElementBasicInGroupApi {

	createHealthElement(entity: GroupScoped<EncryptedHealthElement>): Promise<GroupScoped<EncryptedHealthElement>>;

	modifyHealthElement(entity: GroupScoped<EncryptedHealthElement>): Promise<GroupScoped<EncryptedHealthElement>>;

	getHealthElement(groupId: string,
			entityId: string): Promise<GroupScoped<EncryptedHealthElement> | undefined>;

}

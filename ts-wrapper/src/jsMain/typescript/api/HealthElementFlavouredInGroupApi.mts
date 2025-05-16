// auto-generated file
import {HealthElementShareOptions} from '../crypto/entities/HealthElementShareOptions.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {HealthElement} from '../model/HealthElement.mjs';
import {ArrayWithUniqueKeys} from '../utils/ArrayWithUniqueKeys.mjs';


export interface HealthElementFlavouredInGroupApi<E extends HealthElement> {

	shareWith(delegate: EntityReferenceInGroup, healthElement: GroupScoped<E>,
			options?: { options?: HealthElementShareOptions | undefined }): Promise<GroupScoped<E>>;

	shareWithMany(healthElement: GroupScoped<E>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: HealthElementShareOptions }, 'delegate'>): Promise<GroupScoped<E>>;

	createHealthElement(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	modifyHealthElement(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	getHealthElement(groupId: string, entityId: string): Promise<GroupScoped<E> | undefined>;

}

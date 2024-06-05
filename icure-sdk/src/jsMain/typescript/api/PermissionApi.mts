// auto-generated file
import {Permission} from '../model/security/Permission.mjs';


export interface PermissionApi {

	modifyUserPermissions(userId: string, permissions: Permission): Promise<Array<Permission>>;

}

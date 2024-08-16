// auto-generated file
import {DatabaseInfo} from './DatabaseInfo.mjs';


export class GroupDatabasesInfo {

	groupId: string;

	databasesInfo: Array<DatabaseInfo>;

	gcpStorageSize: number;

	constructor(partial: Partial<GroupDatabasesInfo> & Pick<GroupDatabasesInfo, "groupId" | "databasesInfo" | "gcpStorageSize">) {
		this.groupId = partial.groupId;
		this.databasesInfo = partial.databasesInfo;
		this.gcpStorageSize = partial.gcpStorageSize;
	}

}

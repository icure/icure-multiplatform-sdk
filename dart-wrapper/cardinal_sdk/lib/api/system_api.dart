// auto-generated file
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/indexing_info.dart';
import 'package:cardinal_sdk/model/replication_info.dart';
import 'package:cardinal_sdk/model/id_with_rev.dart';
import 'package:cardinal_sdk/model/couchdb/replicator_document.dart';


class SystemApi {
	final String _sdkId;
	SystemApi(this._sdkId);

	Future<String> getVersion() async {
		return await CardinalSdkPlatformInterface.instance.apis.system.getVersion(
			_sdkId,
		);
	}

	Future<String> isReady() async {
		return await CardinalSdkPlatformInterface.instance.apis.system.isReady(
			_sdkId,
		);
	}

	Future<String> getProcessInfo() async {
		return await CardinalSdkPlatformInterface.instance.apis.system.getProcessInfo(
			_sdkId,
		);
	}

	Future<IndexingInfo> getIndexingInfo() async {
		return await CardinalSdkPlatformInterface.instance.apis.system.getIndexingInfo(
			_sdkId,
		);
	}

	Future<ReplicationInfo> getReplicationInfo() async {
		return await CardinalSdkPlatformInterface.instance.apis.system.getReplicationInfo(
			_sdkId,
		);
	}

	Future<bool> updateDesignDoc(String entityName, { bool? warmup }) async {
		return await CardinalSdkPlatformInterface.instance.apis.system.updateDesignDoc(
			_sdkId,
			entityName,
			warmup,
		);
	}

	Future<List<IdWithRev>> resolvePatientsConflicts({ int? limit }) async {
		return await CardinalSdkPlatformInterface.instance.apis.system.resolvePatientsConflicts(
			_sdkId,
			limit,
		);
	}

	Future<List<IdWithRev>> resolveContactsConflicts({ int? limit }) async {
		return await CardinalSdkPlatformInterface.instance.apis.system.resolveContactsConflicts(
			_sdkId,
			limit,
		);
	}

	Future<List<IdWithRev>> resolveFormsConflicts({ int? limit }) async {
		return await CardinalSdkPlatformInterface.instance.apis.system.resolveFormsConflicts(
			_sdkId,
			limit,
		);
	}

	Future<List<IdWithRev>> resolveHealthElementsConflicts({ int? limit }) async {
		return await CardinalSdkPlatformInterface.instance.apis.system.resolveHealthElementsConflicts(
			_sdkId,
			limit,
		);
	}

	Future<List<IdWithRev>> resolveInvoicesConflicts({ int? limit }) async {
		return await CardinalSdkPlatformInterface.instance.apis.system.resolveInvoicesConflicts(
			_sdkId,
			limit,
		);
	}

	Future<List<IdWithRev>> resolveMessagesConflicts({ int? limit }) async {
		return await CardinalSdkPlatformInterface.instance.apis.system.resolveMessagesConflicts(
			_sdkId,
			limit,
		);
	}

	Future<List<IdWithRev>> resolveDocumentsConflicts({ String? ids, int? limit }) async {
		return await CardinalSdkPlatformInterface.instance.apis.system.resolveDocumentsConflicts(
			_sdkId,
			ids,
			limit,
		);
	}

	Future<IndexingInfo> getIndexingInfoByGroup(String groupId) async {
		return await CardinalSdkPlatformInterface.instance.apis.system.getIndexingInfoByGroup(
			_sdkId,
			groupId,
		);
	}

	Future<ReplicatorDocument> getReplicatorInfo(String id) async {
		return await CardinalSdkPlatformInterface.instance.apis.system.getReplicatorInfo(
			_sdkId,
			id,
		);
	}

	Future<String> evictAllFromMap(String mapName) async {
		return await CardinalSdkPlatformInterface.instance.apis.system.evictAllFromMap(
			_sdkId,
			mapName,
		);
	}
}
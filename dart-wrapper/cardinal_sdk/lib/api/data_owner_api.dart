// auto-generated file
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/data_owner_with_type.dart';
import 'package:cardinal_sdk/model/crypto_actor_stub_with_type.dart';
import 'package:cardinal_sdk/model/entity_reference_in_group.dart';
import 'package:cardinal_sdk/model/data_owner_type.dart';


class DataOwnerApi {
	final String _sdkId;
	final Object _dartSdk;
	DataOwnerApi(
		this._sdkId,
		this._dartSdk
		);

	Future<DataOwnerWithType> getCurrentDataOwner() async {
		return await CardinalSdkPlatformInterface.instance.apis.dataOwner.getCurrentDataOwner(
			_sdkId,
		);
	}

	Future<CryptoActorStubWithType> getCurrentDataOwnerStub() async {
		return await CardinalSdkPlatformInterface.instance.apis.dataOwner.getCurrentDataOwnerStub(
			_sdkId,
		);
	}

	Future<String> getCurrentDataOwnerId() async {
		return await CardinalSdkPlatformInterface.instance.apis.dataOwner.getCurrentDataOwnerId(
			_sdkId,
		);
	}

	Future<EntityReferenceInGroup> getCurrentDataOwnerReference() async {
		return await CardinalSdkPlatformInterface.instance.apis.dataOwner.getCurrentDataOwnerReference(
			_sdkId,
		);
	}

	Future<List<String>> getCurrentDataOwnerHierarchyIds() async {
		return await CardinalSdkPlatformInterface.instance.apis.dataOwner.getCurrentDataOwnerHierarchyIds(
			_sdkId,
		);
	}

	Future<List<EntityReferenceInGroup>> getCurrentDataOwnerHierarchyIdsReference() async {
		return await CardinalSdkPlatformInterface.instance.apis.dataOwner.getCurrentDataOwnerHierarchyIdsReference(
			_sdkId,
		);
	}

	Future<DataOwnerWithType> getDataOwner(String ownerId) async {
		return await CardinalSdkPlatformInterface.instance.apis.dataOwner.getDataOwner(
			_sdkId,
			ownerId,
		);
	}

	Future<CryptoActorStubWithType> getCryptoActorStub(String ownerId) async {
		return await CardinalSdkPlatformInterface.instance.apis.dataOwner.getCryptoActorStub(
			_sdkId,
			ownerId,
		);
	}

	Future<CryptoActorStubWithType> getCryptoActorStubInGroup(EntityReferenceInGroup entityReferenceInGroup) async {
		return await CardinalSdkPlatformInterface.instance.apis.dataOwner.getCryptoActorStubInGroup(
			_sdkId,
			entityReferenceInGroup,
		);
	}

	Future<List<String>> getCurrentDataOwnerHierarchyIdsFrom(String parentId) async {
		return await CardinalSdkPlatformInterface.instance.apis.dataOwner.getCurrentDataOwnerHierarchyIdsFrom(
			_sdkId,
			parentId,
		);
	}

	Future<List<DataOwnerWithType>> getCurrentDataOwnerHierarchy() async {
		return await CardinalSdkPlatformInterface.instance.apis.dataOwner.getCurrentDataOwnerHierarchy(
			_sdkId,
		);
	}

	Future<CryptoActorStubWithType> modifyDataOwnerStub(CryptoActorStubWithType cryptoActorStubWithTypeDto) async {
		return await CardinalSdkPlatformInterface.instance.apis.dataOwner.modifyDataOwnerStub(
			_sdkId,
			cryptoActorStubWithTypeDto,
		);
	}

	Future<DataOwnerType> getCurrentDataOwnerType() async {
		return await CardinalSdkPlatformInterface.instance.apis.dataOwner.getCurrentDataOwnerType(
			_sdkId,
		);
	}

	Future<void> clearCurrentDataOwnerIdsCache() async {
		return await CardinalSdkPlatformInterface.instance.apis.dataOwner.clearCurrentDataOwnerIdsCache(
			_sdkId,
		);
	}
}
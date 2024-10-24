// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/data_owner_with_type.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/crypto_actor_stub_with_type.dart';
import 'package:cardinal_sdk/model/data_owner_type.dart';


class DataOwnerPlatformApi {
	MethodChannel _methodChannel;
	DataOwnerPlatformApi(this._methodChannel);

	Future<DataOwnerWithType> getCurrentDataOwner(String sdkId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DataOwnerApi.getCurrentDataOwner',
			{
				"sdkId": sdkId,
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getCurrentDataOwner");
		final parsedResJson = jsonDecode(res);
		return DataOwnerWithType.fromJSON(parsedResJson);
	}

	Future<CryptoActorStubWithType> getCurrentDataOwnerStub(String sdkId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DataOwnerApi.getCurrentDataOwnerStub',
			{
				"sdkId": sdkId,
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getCurrentDataOwnerStub");
		final parsedResJson = jsonDecode(res);
		return CryptoActorStubWithType.fromJSON(parsedResJson);
	}

	Future<String> getCurrentDataOwnerId(String sdkId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DataOwnerApi.getCurrentDataOwnerId',
			{
				"sdkId": sdkId,
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getCurrentDataOwnerId");
		final parsedResJson = jsonDecode(res);
		return parsedResJson;
	}

	Future<List<String>> getCurrentDataOwnerHierarchyIds(String sdkId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DataOwnerApi.getCurrentDataOwnerHierarchyIds',
			{
				"sdkId": sdkId,
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getCurrentDataOwnerHierarchyIds");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => x1 );
	}

	Future<DataOwnerWithType> getDataOwner(String sdkId, String ownerId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DataOwnerApi.getDataOwner',
			{
				"sdkId": sdkId,
				"ownerId": jsonEncode(ownerId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getDataOwner");
		final parsedResJson = jsonDecode(res);
		return DataOwnerWithType.fromJSON(parsedResJson);
	}

	Future<CryptoActorStubWithType> getCryptoActorStub(String sdkId, String ownerId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DataOwnerApi.getCryptoActorStub',
			{
				"sdkId": sdkId,
				"ownerId": jsonEncode(ownerId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getCryptoActorStub");
		final parsedResJson = jsonDecode(res);
		return CryptoActorStubWithType.fromJSON(parsedResJson);
	}

	Future<List<String>> getCurrentDataOwnerHierarchyIdsFrom(String sdkId, String parentId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DataOwnerApi.getCurrentDataOwnerHierarchyIdsFrom',
			{
				"sdkId": sdkId,
				"parentId": jsonEncode(parentId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getCurrentDataOwnerHierarchyIdsFrom");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => x1 );
	}

	Future<List<DataOwnerWithType>> getCurrentDataOwnerHierarchy(String sdkId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DataOwnerApi.getCurrentDataOwnerHierarchy',
			{
				"sdkId": sdkId,
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getCurrentDataOwnerHierarchy");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => DataOwnerWithType.fromJSON(x1) );
	}

	Future<CryptoActorStubWithType> modifyDataOwnerStub(String sdkId, CryptoActorStubWithType cryptoActorStubWithTypeDto) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DataOwnerApi.modifyDataOwnerStub',
			{
				"sdkId": sdkId,
				"cryptoActorStubWithTypeDto": jsonEncode(CryptoActorStubWithType.encode(cryptoActorStubWithTypeDto)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyDataOwnerStub");
		final parsedResJson = jsonDecode(res);
		return CryptoActorStubWithType.fromJSON(parsedResJson);
	}

	Future<DataOwnerType> getCurrentDataOwnerType(String sdkId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DataOwnerApi.getCurrentDataOwnerType',
			{
				"sdkId": sdkId,
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getCurrentDataOwnerType");
		final parsedResJson = jsonDecode(res);
		return DataOwnerType.fromJSON(parsedResJson);
	}

	Future<void> clearCurrentDataOwnerIdsCache(String sdkId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DataOwnerApi.clearCurrentDataOwnerIdsCache',
			{
				"sdkId": sdkId,
			}
		);
	}
}
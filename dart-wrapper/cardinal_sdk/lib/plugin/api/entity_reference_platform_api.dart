// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/entity_reference.dart';
import 'dart:convert';


class EntityReferencePlatformApi {
	MethodChannel _methodChannel;
	EntityReferencePlatformApi(this._methodChannel);

	Future<EntityReference> getLatest(String sdkId, String prefix) async {
		final res = await _methodChannel.invokeMethod<String>(
			'EntityReferenceApi.getLatest',
			{
				"sdkId": sdkId,
				"prefix": jsonEncode(prefix),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getLatest");
		final parsedResJson = jsonDecode(res);
		return EntityReference.fromJSON(parsedResJson);
	}

	Future<EntityReference> createEntityReference(String sdkId, EntityReference entityReference) async {
		final res = await _methodChannel.invokeMethod<String>(
			'EntityReferenceApi.createEntityReference',
			{
				"sdkId": sdkId,
				"entityReference": jsonEncode(EntityReference.encode(entityReference)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method createEntityReference");
		final parsedResJson = jsonDecode(res);
		return EntityReference.fromJSON(parsedResJson);
	}
}
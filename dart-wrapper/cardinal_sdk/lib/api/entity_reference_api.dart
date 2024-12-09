// auto-generated file
import 'package:cardinal_sdk/cardinal_sdk.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/entity_reference.dart';


class EntityReferenceApi {
	final String _sdkId;
	final CardinalSdk _dartSdk;
	EntityReferenceApi(
		this._sdkId,
		this._dartSdk
		);

	Future<EntityReference> getLatest(String prefix) async {
		return await CardinalSdkPlatformInterface.instance.apis.entityReference.getLatest(
			_sdkId,
			prefix,
		);
	}

	Future<EntityReference> createEntityReference(EntityReference entityReference) async {
		return await CardinalSdkPlatformInterface.instance.apis.entityReference.createEntityReference(
			_sdkId,
			entityReference,
		);
	}
}
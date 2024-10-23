// auto-generated file
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/entity_reference.dart';


class EntityReferencePlatformApi {
	String _sdkId;
	EntityReferencePlatformApi(this._sdkId);

	Future<EntityReference> getLatest(String prefix) async {
		return await CardinalSdkPlatformInterface.instance.entityReference.getLatest(
			_sdkId,
			prefix,
		);
	}

	Future<EntityReference> createEntityReference(EntityReference entityReference) async {
		return await CardinalSdkPlatformInterface.instance.entityReference.createEntityReference(
			_sdkId,
			entityReference,
		);
	}
}
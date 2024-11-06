// auto-generated file
import 'package:cardinal_sdk/model/base/crypto_actor.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/specializations/keypair_fingerprint_v1string.dart';
import 'package:cardinal_sdk/crypto/entities/shamir_update_request.dart';
import 'package:cardinal_sdk/model/crypto_actor_stub_with_type.dart';


class ShamirKeysManagerApi {
	final String _sdkId;
	ShamirKeysManagerApi(this._sdkId);

	Future<Map<KeypairFingerprintV1String, Set<String>>> getExistingSplitsInfo(CryptoActor dataOwner) async {
		return await CardinalSdkPlatformInterface.instance.apis.shamirKeysManager.getExistingSplitsInfo(
			_sdkId,
			dataOwner,
		);
	}

	Future<CryptoActorStubWithType> updateSelfSplits(Map<KeypairFingerprintV1String, ShamirUpdateRequest> keySplitsToUpdate, Set<KeypairFingerprintV1String> keySplitsToDelete) async {
		return await CardinalSdkPlatformInterface.instance.apis.shamirKeysManager.updateSelfSplits(
			_sdkId,
			keySplitsToUpdate,
			keySplitsToDelete,
		);
	}
}
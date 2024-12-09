// auto-generated file
import 'package:cardinal_sdk/api/shamir_keys_manager_api.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/crypto/entities/cardinal_keys.dart';


class CryptoApi {
	final String _sdkId;
	final ShamirKeysManagerApi shamirKeysManager;
	CryptoApi(
		this._sdkId
		) : shamirKeysManager = ShamirKeysManagerApi(_sdkId);

	Future<void> forceReload() async {
		return await CardinalSdkPlatformInterface.instance.apis.crypto.forceReload(
			_sdkId,
		);
	}

	Future<Map<String, Map<CardinalRsaPublicKeyFingerprint, CardinalRsaPrivateKey>>> currentDataOwnerKeys({ bool filterTrustedKeys = true }) async {
		return await CardinalSdkPlatformInterface.instance.apis.crypto.currentDataOwnerKeys(
			_sdkId,
			filterTrustedKeys,
		);
	}
}
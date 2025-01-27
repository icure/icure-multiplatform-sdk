// auto-generated file
import 'package:cardinal_sdk/api/shamir_keys_manager_api.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/crypto/entities/cardinal_keys.dart';


class CryptoApi {
	final String _sdkId;
	final Object _dartSdk;
	final ShamirKeysManagerApi shamirKeysManager;
	CryptoApi(
		this._sdkId,
		this._dartSdk
		) : shamirKeysManager = ShamirKeysManagerApi(_sdkId, _dartSdk);

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
// This file is auto-generated
import 'package:cardinal_sdk/crypto/entities/secret_id_share_options.dart';
import 'package:cardinal_sdk/crypto/entities/share_metadata_behaviour.dart';
import 'package:cardinal_sdk/model/requests/requested_permission.dart';


abstract interface class SimpleDelegateShareOptions {
	abstract SecretIdShareOptions shareSecretIds;
	abstract ShareMetadataBehaviour shareEncryptionKey;
	abstract ShareMetadataBehaviour shareOwningEntityIds;
	abstract RequestedPermission requestedPermissions;
}
// auto-generated file
import 'package:cardinal_sdk/model/embed/delegation.dart';
import 'package:cardinal_sdk/model/embed/security_metadata.dart';
import 'package:cardinal_sdk/model/base/versionable.dart';


abstract interface class HasEncryptionMetadata implements Versionable<String> {
	abstract final Set<String> secretForeignKeys;
	abstract final Map<String, Set<Delegation>> cryptedForeignKeys;
	abstract final Map<String, Set<Delegation>> delegations;
	abstract final Map<String, Set<Delegation>> encryptionKeys;
	abstract final SecurityMetadata? securityMetadata;
}
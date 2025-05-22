// auto-generated file
import 'package:cardinal_sdk/model/data_owner_type.dart';
import 'package:cardinal_sdk/model/crypto_actor_stub.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "crypto_actor_stub_with_type.freezed.dart";


@freezed
abstract class CryptoActorStubWithType with _$CryptoActorStubWithType {
	const factory CryptoActorStubWithType({
		required DataOwnerType type,
		required CryptoActorStub stub,
	}) = _CryptoActorStubWithType;


	static Map<String, dynamic> encode(CryptoActorStubWithType value) {
		Map<String, dynamic> entityAsMap = {
			"type" : DataOwnerType.encode(value.type),
			"stub" : CryptoActorStub.encode(value.stub)
		};
		return entityAsMap;
	}

	static CryptoActorStubWithType fromJSON(Map<String, dynamic> data) {
		return CryptoActorStubWithType(
			type: DataOwnerType.fromJSON(data["type"]),
			stub: CryptoActorStub.fromJSON(data["stub"])
		);
	}
}
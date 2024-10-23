// auto-generated file
import 'package:cardinal_sdk/model/data_owner_type.dart';
import 'package:cardinal_sdk/model/crypto_actor_stub.dart';


class CryptoActorStubWithType {
	DataOwnerType type;
	CryptoActorStub stub;
	CryptoActorStubWithType(
		this.type,
		this.stub
		);

	factory CryptoActorStubWithType.fromJSON(Map<String, dynamic> data) {
		return CryptoActorStubWithType(
			DataOwnerType.fromJSON(data["type"]),
			CryptoActorStub.fromJSON(data["stub"])
		);
	}

	static Map<String, dynamic> encode(CryptoActorStubWithType value) {
		Map<String, dynamic> entityAsMap = {
			"type" : DataOwnerType.encode(value.type),
			"stub" : CryptoActorStub.encode(value.stub)
		};
		return entityAsMap;
	}
}
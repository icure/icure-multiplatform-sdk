// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "login_identifier.freezed.dart";


@freezed
abstract class LoginIdentifier with _$LoginIdentifier {
	const factory LoginIdentifier({
		required String assigner,
		required String value,
	}) = _LoginIdentifier;


	static Map<String, dynamic> encode(LoginIdentifier value) {
		Map<String, dynamic> entityAsMap = {
			"assigner" : value.assigner,
			"value" : value.value
		};
		return entityAsMap;
	}

	static LoginIdentifier fromJSON(Map<String, dynamic> data) {
		return LoginIdentifier(
			assigner: (data["assigner"] as String),
			value: (data["value"] as String)
		);
	}
}
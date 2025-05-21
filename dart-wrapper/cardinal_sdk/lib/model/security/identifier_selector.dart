// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "identifier_selector.freezed.dart";


@freezed
abstract class IdentifierSelector with _$IdentifierSelector {
	const factory IdentifierSelector({
		required String assigner,
		required String valueField,
	}) = _IdentifierSelector;


	static Map<String, dynamic> encode(IdentifierSelector value) {
		Map<String, dynamic> entityAsMap = {
			"assigner" : value.assigner,
			"valueField" : value.valueField
		};
		return entityAsMap;
	}

	static IdentifierSelector fromJSON(Map<String, dynamic> data) {
		return IdentifierSelector(
			assigner: (data["assigner"] as String),
			valueField: (data["valueField"] as String)
		);
	}
}
// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "labelled_occurence.freezed.dart";


@freezed
abstract class LabelledOccurence with _$LabelledOccurence {
	const factory LabelledOccurence({
		required String label,
		required int occurence,
	}) = _LabelledOccurence;


	static Map<String, dynamic> encode(LabelledOccurence value) {
		Map<String, dynamic> entityAsMap = {
			"label" : value.label,
			"occurence" : value.occurence
		};
		return entityAsMap;
	}

	static LabelledOccurence fromJSON(Map<String, dynamic> data) {
		return LabelledOccurence(
			label: (data["label"] as String),
			occurence: (data["occurence"] as int)
		);
	}
}
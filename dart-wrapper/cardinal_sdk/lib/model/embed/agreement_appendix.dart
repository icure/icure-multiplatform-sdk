// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "agreement_appendix.freezed.dart";


@freezed
abstract class AgreementAppendix with _$AgreementAppendix {
	const factory AgreementAppendix({
		@Default(null) int? docSeq,
		@Default(null) int? verseSeq,
		@Default(null) String? documentId,
		@Default(null) String? path,
	}) = _AgreementAppendix;


	static Map<String, dynamic> encode(AgreementAppendix value) {
		Map<String, dynamic> entityAsMap = {
			"docSeq" : value.docSeq,
			"verseSeq" : value.verseSeq,
			"documentId" : value.documentId,
			"path" : value.path
		};
		return entityAsMap;
	}

	static AgreementAppendix fromJSON(Map<String, dynamic> data) {
		return AgreementAppendix(
			docSeq: (data["docSeq"] as int?),
			verseSeq: (data["verseSeq"] as int?),
			documentId: (data["documentId"] as String?),
			path: (data["path"] as String?)
		);
	}
}
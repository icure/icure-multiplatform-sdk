// auto-generated file
import 'package:cardinal_sdk/annotations/actual_int32.dart';


class AgreementAppendix {
	int? _docSeq;
	@ActualInt32() int? get docSeq => _docSeq;
	@ActualInt32() set docSeq(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('docSeq value cannot exceed 2147483647');
		}
		_docSeq = value;
	}
	int? _verseSeq;
	@ActualInt32() int? get verseSeq => _verseSeq;
	@ActualInt32() set verseSeq(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('verseSeq value cannot exceed 2147483647');
		}
		_verseSeq = value;
	}
	String? documentId;
	String? path;
	AgreementAppendix({
			int? docSeq,
			int? verseSeq,
			this.documentId,
			this.path
		}) : _docSeq = docSeq,
		_verseSeq = verseSeq;

	factory AgreementAppendix.fromJSON(Map<String, dynamic> data) {
		return AgreementAppendix(
			docSeq: (data["docSeq"] as int?),
			verseSeq: (data["verseSeq"] as int?),
			documentId: (data["documentId"] as String?),
			path: (data["path"] as String?)
		);
	}

	static Map<String, dynamic> encode(AgreementAppendix value) {
		Map<String, dynamic> entityAsMap = {
			"docSeq" : value.docSeq,
			"verseSeq" : value.verseSeq,
			"documentId" : value.documentId,
			"path" : value.path
		};
		return entityAsMap;
	}
}
// This file is auto-generated
import 'package:cardinal_sdk/annotations/actual_int32.dart';


class AgreementAppendix {
	int? _docSeq;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") int? get docSeq => _docSeq;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") set docSeq(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('docSeq value cannot exceed 2147483647');
		}
		_docSeq = value;
	}
	int? _verseSeq;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") int? get verseSeq => _verseSeq;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") set verseSeq(int? value) {
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
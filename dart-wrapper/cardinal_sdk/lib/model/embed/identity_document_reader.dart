// auto-generated file
import 'package:cardinal_sdk/annotations/actual_int32.dart';


class IdentityDocumentReader {
	String? justificatifDocumentNumber;
	String? supportSerialNumber;
	int? timeReadingEIdDocument;
	int _eidDocumentSupportType = 0;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") int get eidDocumentSupportType => _eidDocumentSupportType;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") set eidDocumentSupportType(int value) {
		if (value > 2147483647) {
			throw ArgumentError('eidDocumentSupportType value cannot exceed 2147483647');
		}
		_eidDocumentSupportType = value;
	}
	int _reasonManualEncoding = 0;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") int get reasonManualEncoding => _reasonManualEncoding;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") set reasonManualEncoding(int value) {
		if (value > 2147483647) {
			throw ArgumentError('reasonManualEncoding value cannot exceed 2147483647');
		}
		_reasonManualEncoding = value;
	}
	int _reasonUsingVignette = 0;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") int get reasonUsingVignette => _reasonUsingVignette;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") set reasonUsingVignette(int value) {
		if (value > 2147483647) {
			throw ArgumentError('reasonUsingVignette value cannot exceed 2147483647');
		}
		_reasonUsingVignette = value;
	}
	IdentityDocumentReader({
			int? eidDocumentSupportType,
			int? reasonManualEncoding,
			int? reasonUsingVignette,
			this.justificatifDocumentNumber,
			this.supportSerialNumber,
			this.timeReadingEIdDocument
		}) : _eidDocumentSupportType = eidDocumentSupportType ?? 0,
		_reasonManualEncoding = reasonManualEncoding ?? 0,
		_reasonUsingVignette = reasonUsingVignette ?? 0;

	factory IdentityDocumentReader.fromJSON(Map<String, dynamic> data) {
		return IdentityDocumentReader(
			eidDocumentSupportType: data["eidDocumentSupportType"],
			reasonManualEncoding: data["reasonManualEncoding"],
			reasonUsingVignette: data["reasonUsingVignette"],
			justificatifDocumentNumber: data["justificatifDocumentNumber"],
			supportSerialNumber: data["supportSerialNumber"],
			timeReadingEIdDocument: data["timeReadingEIdDocument"]
		);
	}

	static Map<String, dynamic> encode(IdentityDocumentReader value) {
		Map<String, dynamic> entityAsMap = {
			"justificatifDocumentNumber" : value.justificatifDocumentNumber,
			"supportSerialNumber" : value.supportSerialNumber,
			"timeReadingEIdDocument" : value.timeReadingEIdDocument,
			"eidDocumentSupportType" : value.eidDocumentSupportType,
			"reasonManualEncoding" : value.reasonManualEncoding,
			"reasonUsingVignette" : value.reasonUsingVignette
		};
		return entityAsMap;
	}
}
// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "identity_document_reader.freezed.dart";


@freezed
abstract class IdentityDocumentReader with _$IdentityDocumentReader {
	const factory IdentityDocumentReader({
		@Default(null) String? justificatifDocumentNumber,
		@Default(null) String? supportSerialNumber,
		@Default(null) int? timeReadingEIdDocument,
		@Default(0) int eidDocumentSupportType,
		@Default(0) int reasonManualEncoding,
		@Default(0) int reasonUsingVignette,
	}) = _IdentityDocumentReader;


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

	static IdentityDocumentReader fromJSON(Map<String, dynamic> data) {
		return IdentityDocumentReader(
			eidDocumentSupportType: (data["eidDocumentSupportType"] as int),
			reasonManualEncoding: (data["reasonManualEncoding"] as int),
			reasonUsingVignette: (data["reasonUsingVignette"] as int),
			justificatifDocumentNumber: (data["justificatifDocumentNumber"] as String?),
			supportSerialNumber: (data["supportSerialNumber"] as String?),
			timeReadingEIdDocument: (data["timeReadingEIdDocument"] as int?)
		);
	}
}
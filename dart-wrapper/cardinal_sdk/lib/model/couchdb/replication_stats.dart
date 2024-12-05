// auto-generated file
import 'package:cardinal_sdk/annotations/actual_int32.dart';


class ReplicationStats {
	int? _revisionsChecked = null;
	@ActualInt32() int? get revisionsChecked => _revisionsChecked;
	@ActualInt32() set revisionsChecked(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('revisionsChecked value cannot exceed 2147483647');
		}
		_revisionsChecked = value;
	}
	int? _missingRevisionsFound = null;
	@ActualInt32() int? get missingRevisionsFound => _missingRevisionsFound;
	@ActualInt32() set missingRevisionsFound(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('missingRevisionsFound value cannot exceed 2147483647');
		}
		_missingRevisionsFound = value;
	}
	int? _docsRead = null;
	@ActualInt32() int? get docsRead => _docsRead;
	@ActualInt32() set docsRead(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('docsRead value cannot exceed 2147483647');
		}
		_docsRead = value;
	}
	int? _docsWritten = null;
	@ActualInt32() int? get docsWritten => _docsWritten;
	@ActualInt32() set docsWritten(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('docsWritten value cannot exceed 2147483647');
		}
		_docsWritten = value;
	}
	int? _changesPending = null;
	@ActualInt32() int? get changesPending => _changesPending;
	@ActualInt32() set changesPending(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('changesPending value cannot exceed 2147483647');
		}
		_changesPending = value;
	}
	int? _docWriteFailures = null;
	@ActualInt32() int? get docWriteFailures => _docWriteFailures;
	@ActualInt32() set docWriteFailures(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('docWriteFailures value cannot exceed 2147483647');
		}
		_docWriteFailures = value;
	}
	String? checkpointedSourceSeq = null;
	String? startTime = null;
	String? error = null;
	ReplicationStats({
			int? revisionsChecked,
			int? missingRevisionsFound,
			int? docsRead,
			int? docsWritten,
			int? changesPending,
			int? docWriteFailures,
			String? checkpointedSourceSeq,
			String? startTime,
			String? error
		}) : checkpointedSourceSeq = checkpointedSourceSeq ?? null,
		startTime = startTime ?? null,
		error = error ?? null,
		_revisionsChecked = revisionsChecked ?? null,
		_missingRevisionsFound = missingRevisionsFound ?? null,
		_docsRead = docsRead ?? null,
		_docsWritten = docsWritten ?? null,
		_changesPending = changesPending ?? null,
		_docWriteFailures = docWriteFailures ?? null;

	static Map<String, dynamic> encode(ReplicationStats value) {
		Map<String, dynamic> entityAsMap = {
			"revisionsChecked" : value.revisionsChecked,
			"missingRevisionsFound" : value.missingRevisionsFound,
			"docsRead" : value.docsRead,
			"docsWritten" : value.docsWritten,
			"changesPending" : value.changesPending,
			"docWriteFailures" : value.docWriteFailures,
			"checkpointedSourceSeq" : value.checkpointedSourceSeq,
			"startTime" : value.startTime,
			"error" : value.error
		};
		return entityAsMap;
	}

	static ReplicationStats fromJSON(Map<String, dynamic> data) {
		return ReplicationStats(
			revisionsChecked: (data["revisionsChecked"] as int?),
			missingRevisionsFound: (data["missingRevisionsFound"] as int?),
			docsRead: (data["docsRead"] as int?),
			docsWritten: (data["docsWritten"] as int?),
			changesPending: (data["changesPending"] as int?),
			docWriteFailures: (data["docWriteFailures"] as int?),
			checkpointedSourceSeq: (data["checkpointedSourceSeq"] as String?),
			startTime: (data["startTime"] as String?),
			error: (data["error"] as String?)
		);
	}
}
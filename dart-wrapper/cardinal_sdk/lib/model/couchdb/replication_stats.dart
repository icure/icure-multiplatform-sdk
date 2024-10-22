// This file is auto-generated
import 'package:cardinal_sdk/annotations/actual_int32.dart';


class ReplicationStats {
	int? _revisionsChecked;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") int? get revisionsChecked => _revisionsChecked;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") set revisionsChecked(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('revisionsChecked value cannot exceed 2147483647');
		}
		_revisionsChecked = value;
	}
	int? _missingRevisionsFound;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") int? get missingRevisionsFound => _missingRevisionsFound;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") set missingRevisionsFound(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('missingRevisionsFound value cannot exceed 2147483647');
		}
		_missingRevisionsFound = value;
	}
	int? _docsRead;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") int? get docsRead => _docsRead;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") set docsRead(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('docsRead value cannot exceed 2147483647');
		}
		_docsRead = value;
	}
	int? _docsWritten;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") int? get docsWritten => _docsWritten;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") set docsWritten(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('docsWritten value cannot exceed 2147483647');
		}
		_docsWritten = value;
	}
	int? _changesPending;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") int? get changesPending => _changesPending;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") set changesPending(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('changesPending value cannot exceed 2147483647');
		}
		_changesPending = value;
	}
	int? _docWriteFailures;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") int? get docWriteFailures => _docWriteFailures;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") set docWriteFailures(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('docWriteFailures value cannot exceed 2147483647');
		}
		_docWriteFailures = value;
	}
	String? checkpointedSourceSeq;
	String? startTime;
	String? error;
	ReplicationStats({
			int? revisionsChecked,
			int? missingRevisionsFound,
			int? docsRead,
			int? docsWritten,
			int? changesPending,
			int? docWriteFailures,
			this.checkpointedSourceSeq,
			this.startTime,
			this.error
		}) : _revisionsChecked = revisionsChecked,
		_missingRevisionsFound = missingRevisionsFound,
		_docsRead = docsRead,
		_docsWritten = docsWritten,
		_changesPending = changesPending,
		_docWriteFailures = docWriteFailures;

	factory ReplicationStats.fromJSON(Map<String, dynamic> data) {
		return ReplicationStats(
			revisionsChecked: data["revisionsChecked"],
			missingRevisionsFound: data["missingRevisionsFound"],
			docsRead: data["docsRead"],
			docsWritten: data["docsWritten"],
			changesPending: data["changesPending"],
			docWriteFailures: data["docWriteFailures"],
			checkpointedSourceSeq: data["checkpointedSourceSeq"],
			startTime: data["startTime"],
			error: data["error"]
		);
	}

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
}
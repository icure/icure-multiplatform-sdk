// auto-generated file
import 'package:cardinal_sdk/annotations/actual_int32.dart';


class DatabaseInfo {
	String id;
	String? updateSeq = null;
	int? fileSize = null;
	int? externalSize = null;
	int? activeSize = null;
	int? docs = null;
	int? _q = null;
	@ActualInt32() int? get q => _q;
	@ActualInt32() set q(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('q value cannot exceed 2147483647');
		}
		_q = value;
	}
	int? _n = null;
	@ActualInt32() int? get n => _n;
	@ActualInt32() set n(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('n value cannot exceed 2147483647');
		}
		_n = value;
	}
	int? _w = null;
	@ActualInt32() int? get w => _w;
	@ActualInt32() set w(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('w value cannot exceed 2147483647');
		}
		_w = value;
	}
	int? _r = null;
	@ActualInt32() int? get r => _r;
	@ActualInt32() set r(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('r value cannot exceed 2147483647');
		}
		_r = value;
	}
	DatabaseInfo(
		this.id,
		{
			int? q,
			int? n,
			int? w,
			int? r,
			String? updateSeq,
			int? fileSize,
			int? externalSize,
			int? activeSize,
			int? docs
		}) : updateSeq = updateSeq ?? null,
		fileSize = fileSize ?? null,
		externalSize = externalSize ?? null,
		activeSize = activeSize ?? null,
		docs = docs ?? null,
		_q = q ?? null,
		_n = n ?? null,
		_w = w ?? null,
		_r = r ?? null;

	static Map<String, dynamic> encode(DatabaseInfo value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"updateSeq" : value.updateSeq,
			"fileSize" : value.fileSize,
			"externalSize" : value.externalSize,
			"activeSize" : value.activeSize,
			"docs" : value.docs,
			"q" : value.q,
			"n" : value.n,
			"w" : value.w,
			"r" : value.r
		};
		return entityAsMap;
	}

	static DatabaseInfo fromJSON(Map<String, dynamic> data) {
		return DatabaseInfo(
			(data["id"] as String),
			q: (data["q"] as int?),
			n: (data["n"] as int?),
			w: (data["w"] as int?),
			r: (data["r"] as int?),
			updateSeq: (data["updateSeq"] as String?),
			fileSize: (data["fileSize"] as int?),
			externalSize: (data["externalSize"] as int?),
			activeSize: (data["activeSize"] as int?),
			docs: (data["docs"] as int?),
		);
	}
}
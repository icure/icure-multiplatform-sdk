// auto-generated file
import 'package:cardinal_sdk/annotations/actual_int32.dart';


class DatabaseInfo {
	String id;
	String? updateSeq;
	int? fileSize;
	int? externalSize;
	int? activeSize;
	int? docs;
	int? _q;
	@ActualInt32() int? get q => _q;
	@ActualInt32() set q(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('q value cannot exceed 2147483647');
		}
		_q = value;
	}
	int? _n;
	@ActualInt32() int? get n => _n;
	@ActualInt32() set n(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('n value cannot exceed 2147483647');
		}
		_n = value;
	}
	int? _w;
	@ActualInt32() int? get w => _w;
	@ActualInt32() set w(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('w value cannot exceed 2147483647');
		}
		_w = value;
	}
	int? _r;
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
			this.updateSeq,
			this.fileSize,
			this.externalSize,
			this.activeSize,
			this.docs
		}) : _q = q,
		_n = n,
		_w = w,
		_r = r;

	factory DatabaseInfo.fromJSON(Map<String, dynamic> data) {
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
}
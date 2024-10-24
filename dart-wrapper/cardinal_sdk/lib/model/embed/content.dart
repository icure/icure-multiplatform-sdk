// auto-generated file
import 'dart:typed_data';
import 'package:cardinal_sdk/model/embed/measure.dart';
import 'package:cardinal_sdk/model/embed/medication.dart';
import 'package:cardinal_sdk/model/embed/time_series.dart';
import 'package:cardinal_sdk/model/embed/service.dart';
import 'package:cardinal_sdk/model/embed/content.dart';
import 'dart:convert';


sealed class Content {
	abstract String? stringValue;
	abstract double? numberValue;
	abstract bool? booleanValue;
	abstract DateTime? instantValue;
	abstract int? fuzzyDateValue;
	abstract Uint8List? binaryValue;
	abstract String? documentId;
	abstract Measure? measureValue;
	abstract Medication? medicationValue;
	abstract TimeSeries? timeSeries;
	List<Service>? get compoundValue;
	abstract List<Measure>? ratio;
	abstract List<Measure>? range;

	static Map<String, dynamic> encode(Content value) {
		switch (value) {
			case EncryptedContent entity:
				Map<String, dynamic> entityJson = EncryptedContent.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.EncryptedContent";
				return entityJson;
			case DecryptedContent entity:
				Map<String, dynamic> entityJson = DecryptedContent.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.DecryptedContent";
				return entityJson;
		}
	}

	static Content fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.model.embed.EncryptedContent":
				return EncryptedContent.fromJSON(data);
			case "com.icure.cardinal.sdk.model.embed.DecryptedContent":
				return DecryptedContent.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

class EncryptedContent implements Content {
	@override String? stringValue;
	@override double? numberValue;
	@override bool? booleanValue;
	@override DateTime? instantValue;
	@override int? fuzzyDateValue;
	@override Uint8List? binaryValue;
	@override String? documentId;
	@override Measure? measureValue;
	@override Medication? medicationValue;
	@override TimeSeries? timeSeries;
	@override List<EncryptedService>? compoundValue;
	@override List<Measure>? ratio;
	@override List<Measure>? range;
	EncryptedContent({
			this.stringValue,
			this.numberValue,
			this.booleanValue,
			this.instantValue,
			this.fuzzyDateValue,
			this.binaryValue,
			this.documentId,
			this.measureValue,
			this.medicationValue,
			this.timeSeries,
			this.compoundValue,
			this.ratio,
			this.range
		});

	factory EncryptedContent.fromJSON(Map<String, dynamic> data) {
		return EncryptedContent(
			stringValue: (data["stringValue"] as String?),
			numberValue: (data["numberValue"] as num?)?.toDouble(),
			booleanValue: (data["booleanValue"] as bool?),
			instantValue: data["instantValue"] == null ? null : DateTime.parse(data["instantValue"] as String),
			fuzzyDateValue: (data["fuzzyDateValue"] as int?),
			binaryValue: data["binaryValue"] == null ? null : base64Decode(data["binaryValue"] as String),
			documentId: (data["documentId"] as String?),
			measureValue: data["measureValue"] == null ? null : Measure.fromJSON(data["measureValue"]),
			medicationValue: data["medicationValue"] == null ? null : Medication.fromJSON(data["medicationValue"]),
			timeSeries: data["timeSeries"] == null ? null : TimeSeries.fromJSON(data["timeSeries"]),
			compoundValue: (data["compoundValue"] as List<dynamic>?)?.map((x0) => EncryptedService.fromJSON(x0) ).toList(),
			ratio: (data["ratio"] as List<dynamic>?)?.map((x0) => Measure.fromJSON(x0) ).toList(),
			range: (data["range"] as List<dynamic>?)?.map((x0) => Measure.fromJSON(x0) ).toList()
		);
	}

	static Map<String, dynamic> encode(EncryptedContent value) {
		Map<String, dynamic> entityAsMap = {
			"stringValue" : value.stringValue,
			"numberValue" : value.numberValue,
			"booleanValue" : value.booleanValue,
			"instantValue" : value.instantValue?.toIso8601String(),
			"fuzzyDateValue" : value.fuzzyDateValue,
			"binaryValue" : value.binaryValue == null ? null : base64Encode(value.binaryValue as List<int>),
			"documentId" : value.documentId,
			"measureValue" : value.measureValue == null ? null : Measure.encode(value.measureValue!),
			"medicationValue" : value.medicationValue == null ? null : Medication.encode(value.medicationValue!),
			"timeSeries" : value.timeSeries == null ? null : TimeSeries.encode(value.timeSeries!),
			"compoundValue" : value.compoundValue?.map((x0) => EncryptedService.encode(x0)).toList(),
			"ratio" : value.ratio?.map((x0) => Measure.encode(x0)).toList(),
			"range" : value.range?.map((x0) => Measure.encode(x0)).toList()
		};
		return entityAsMap;
	}
}

class DecryptedContent implements Content {
	@override String? stringValue;
	@override double? numberValue;
	@override bool? booleanValue;
	@override DateTime? instantValue;
	@override int? fuzzyDateValue;
	@override Uint8List? binaryValue;
	@override String? documentId;
	@override Measure? measureValue;
	@override Medication? medicationValue;
	@override TimeSeries? timeSeries;
	@override List<DecryptedService>? compoundValue;
	@override List<Measure>? ratio;
	@override List<Measure>? range;
	DecryptedContent({
			this.stringValue,
			this.numberValue,
			this.booleanValue,
			this.instantValue,
			this.fuzzyDateValue,
			this.binaryValue,
			this.documentId,
			this.measureValue,
			this.medicationValue,
			this.timeSeries,
			this.compoundValue,
			this.ratio,
			this.range
		});

	factory DecryptedContent.fromJSON(Map<String, dynamic> data) {
		return DecryptedContent(
			stringValue: (data["stringValue"] as String?),
			numberValue: (data["numberValue"] as num?)?.toDouble(),
			booleanValue: (data["booleanValue"] as bool?),
			instantValue: data["instantValue"] == null ? null : DateTime.parse(data["instantValue"] as String),
			fuzzyDateValue: (data["fuzzyDateValue"] as int?),
			binaryValue: data["binaryValue"] == null ? null : base64Decode(data["binaryValue"] as String),
			documentId: (data["documentId"] as String?),
			measureValue: data["measureValue"] == null ? null : Measure.fromJSON(data["measureValue"]),
			medicationValue: data["medicationValue"] == null ? null : Medication.fromJSON(data["medicationValue"]),
			timeSeries: data["timeSeries"] == null ? null : TimeSeries.fromJSON(data["timeSeries"]),
			compoundValue: (data["compoundValue"] as List<dynamic>?)?.map((x0) => DecryptedService.fromJSON(x0) ).toList(),
			ratio: (data["ratio"] as List<dynamic>?)?.map((x0) => Measure.fromJSON(x0) ).toList(),
			range: (data["range"] as List<dynamic>?)?.map((x0) => Measure.fromJSON(x0) ).toList()
		);
	}

	static Map<String, dynamic> encode(DecryptedContent value) {
		Map<String, dynamic> entityAsMap = {
			"stringValue" : value.stringValue,
			"numberValue" : value.numberValue,
			"booleanValue" : value.booleanValue,
			"instantValue" : value.instantValue?.toIso8601String(),
			"fuzzyDateValue" : value.fuzzyDateValue,
			"binaryValue" : value.binaryValue == null ? null : base64Encode(value.binaryValue as List<int>),
			"documentId" : value.documentId,
			"measureValue" : value.measureValue == null ? null : Measure.encode(value.measureValue!),
			"medicationValue" : value.medicationValue == null ? null : Medication.encode(value.medicationValue!),
			"timeSeries" : value.timeSeries == null ? null : TimeSeries.encode(value.timeSeries!),
			"compoundValue" : value.compoundValue?.map((x0) => DecryptedService.encode(x0)).toList(),
			"ratio" : value.ratio?.map((x0) => Measure.encode(x0)).toList(),
			"range" : value.range?.map((x0) => Measure.encode(x0)).toList()
		};
		return entityAsMap;
	}
}
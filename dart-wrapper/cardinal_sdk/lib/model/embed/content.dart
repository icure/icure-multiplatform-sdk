// auto-generated file
import 'dart:typed_data';
import 'package:cardinal_sdk/model/embed/measure.dart';
import 'package:cardinal_sdk/model/embed/medication.dart';
import 'package:cardinal_sdk/model/embed/time_series.dart';
import 'package:cardinal_sdk/model/embed/service.dart';
import 'package:cardinal_sdk/model/embed/content.dart';
import 'dart:convert';
import 'package:freezed_annotation/freezed_annotation.dart';
part "content.freezed.dart";


sealed class Content {
	abstract final String? stringValue;
	abstract final double? numberValue;
	abstract final bool? booleanValue;
	abstract final DateTime? instantValue;
	abstract final int? fuzzyDateValue;
	abstract final Uint8List? binaryValue;
	abstract final String? documentId;
	abstract final Measure? measureValue;
	abstract final Medication? medicationValue;
	abstract final TimeSeries? timeSeries;
	List<Service>? get compoundValue;
	abstract final List<Measure>? ratio;
	abstract final List<Measure>? range;

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

@freezed
abstract class EncryptedContent with _$EncryptedContent implements Content {
	const factory EncryptedContent({
		@Default(null) String? stringValue,
		@Default(null) double? numberValue,
		@Default(null) bool? booleanValue,
		@Default(null) DateTime? instantValue,
		@Default(null) int? fuzzyDateValue,
		@Default(null) Uint8List? binaryValue,
		@Default(null) String? documentId,
		@Default(null) Measure? measureValue,
		@Default(null) Medication? medicationValue,
		@Default(null) TimeSeries? timeSeries,
		@Default(null) List<EncryptedService>? compoundValue,
		@Default(null) List<Measure>? ratio,
		@Default(null) List<Measure>? range,
	}) = _EncryptedContent;


	static Map<String, dynamic> encode(EncryptedContent value) {
		Map<String, dynamic> entityAsMap = {
			"stringValue" : value.stringValue,
			"numberValue" : value.numberValue,
			"booleanValue" : value.booleanValue,
			"instantValue" : value.instantValue?.millisecondsSinceEpoch,
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

	static EncryptedContent fromJSON(Map<String, dynamic> data) {
		return EncryptedContent(
			stringValue: (data["stringValue"] as String?),
			numberValue: (data["numberValue"] as num?)?.toDouble(),
			booleanValue: (data["booleanValue"] as bool?),
			instantValue: data["instantValue"] == null ? null : DateTime.fromMillisecondsSinceEpoch(data["instantValue"] as int),
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
}

@freezed
abstract class DecryptedContent with _$DecryptedContent implements Content {
	const factory DecryptedContent({
		@Default(null) String? stringValue,
		@Default(null) double? numberValue,
		@Default(null) bool? booleanValue,
		@Default(null) DateTime? instantValue,
		@Default(null) int? fuzzyDateValue,
		@Default(null) Uint8List? binaryValue,
		@Default(null) String? documentId,
		@Default(null) Measure? measureValue,
		@Default(null) Medication? medicationValue,
		@Default(null) TimeSeries? timeSeries,
		@Default(null) List<DecryptedService>? compoundValue,
		@Default(null) List<Measure>? ratio,
		@Default(null) List<Measure>? range,
	}) = _DecryptedContent;


	static Map<String, dynamic> encode(DecryptedContent value) {
		Map<String, dynamic> entityAsMap = {
			"stringValue" : value.stringValue,
			"numberValue" : value.numberValue,
			"booleanValue" : value.booleanValue,
			"instantValue" : value.instantValue?.millisecondsSinceEpoch,
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

	static DecryptedContent fromJSON(Map<String, dynamic> data) {
		return DecryptedContent(
			stringValue: (data["stringValue"] as String?),
			numberValue: (data["numberValue"] as num?)?.toDouble(),
			booleanValue: (data["booleanValue"] as bool?),
			instantValue: data["instantValue"] == null ? null : DateTime.fromMillisecondsSinceEpoch(data["instantValue"] as int),
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
}
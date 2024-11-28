// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'package:cardinal_sdk/model/document.dart';
import 'package:cardinal_sdk/model/embed/document_type.dart';


class DocumentPlatformFilters {
	MethodChannel _methodChannel;
	DocumentPlatformFilters(this._methodChannel);

	Future<SortableFilterOptions<Document>> byPatientsCreatedForDataOwner(String dataOwnerId, List<Patient> patients, { DateTime? from, DateTime? to, bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentFilters.byPatientsCreatedForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"patients": jsonEncode(patients.map((x0) => Patient.encode(x0)).toList()),
				"from": jsonEncode(from?.millisecondsSinceEpoch),
				"to": jsonEncode(to?.millisecondsSinceEpoch),
				"descending": jsonEncode(descending),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byPatientsCreatedForDataOwner");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<Document>> byPatientsCreatedForSelf(List<Patient> patients, { DateTime? from, DateTime? to, bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentFilters.byPatientsCreatedForSelf',
			{
				"patients": jsonEncode(patients.map((x0) => Patient.encode(x0)).toList()),
				"from": jsonEncode(from?.millisecondsSinceEpoch),
				"to": jsonEncode(to?.millisecondsSinceEpoch),
				"descending": jsonEncode(descending),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byPatientsCreatedForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<Document>> byPatientSecretIdsCreatedForDataOwner(String dataOwnerId, List<String> secretIds, { DateTime? from, DateTime? to, bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentFilters.byPatientSecretIdsCreatedForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"secretIds": jsonEncode(secretIds.map((x0) => x0).toList()),
				"from": jsonEncode(from?.millisecondsSinceEpoch),
				"to": jsonEncode(to?.millisecondsSinceEpoch),
				"descending": jsonEncode(descending),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byPatientSecretIdsCreatedForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<Document>> byPatientSecretIdsCreatedForSelf(List<String> secretIds, { DateTime? from, DateTime? to, bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentFilters.byPatientSecretIdsCreatedForSelf',
			{
				"secretIds": jsonEncode(secretIds.map((x0) => x0).toList()),
				"from": jsonEncode(from?.millisecondsSinceEpoch),
				"to": jsonEncode(to?.millisecondsSinceEpoch),
				"descending": jsonEncode(descending),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byPatientSecretIdsCreatedForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<FilterOptions<Document>> byPatientsAndTypeForDataOwner(String dataOwnerId, DocumentType documentType, List<Patient> patients) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentFilters.byPatientsAndTypeForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"documentType": jsonEncode(DocumentType.encode(documentType)),
				"patients": jsonEncode(patients.map((x0) => Patient.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byPatientsAndTypeForDataOwner");
		final parsedResJson = jsonDecode(res);
		return FilterOptions.fromJSON(parsedResJson);
	}

	Future<FilterOptions<Document>> byPatientsAndTypeForSelf(DocumentType documentType, List<Patient> patients) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentFilters.byPatientsAndTypeForSelf',
			{
				"documentType": jsonEncode(DocumentType.encode(documentType)),
				"patients": jsonEncode(patients.map((x0) => Patient.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byPatientsAndTypeForSelf");
		final parsedResJson = jsonDecode(res);
		return FilterOptions.fromJSON(parsedResJson);
	}

	Future<FilterOptions<Document>> byPatientSecretIdsAndTypeForDataOwner(String dataOwnerId, DocumentType documentType, List<String> secretIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentFilters.byPatientSecretIdsAndTypeForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"documentType": jsonEncode(DocumentType.encode(documentType)),
				"secretIds": jsonEncode(secretIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byPatientSecretIdsAndTypeForDataOwner");
		final parsedResJson = jsonDecode(res);
		return FilterOptions.fromJSON(parsedResJson);
	}

	Future<FilterOptions<Document>> byPatientSecretIdsAndTypeForSelf(DocumentType documentType, List<String> secretIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentFilters.byPatientSecretIdsAndTypeForSelf',
			{
				"documentType": jsonEncode(DocumentType.encode(documentType)),
				"secretIds": jsonEncode(secretIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byPatientSecretIdsAndTypeForSelf");
		final parsedResJson = jsonDecode(res);
		return FilterOptions.fromJSON(parsedResJson);
	}
}
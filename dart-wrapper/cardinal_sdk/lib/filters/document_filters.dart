// auto-generated file
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/document.dart';
import 'package:cardinal_sdk/model/embed/document_type.dart';


abstract class DocumentFilters {
	DocumentFilters();

	static Future<SortableFilterOptions<Document>> byPatientsCreatedForDataOwner(String dataOwnerId, List<Patient> patients, { DateTime? from, DateTime? to, bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.document.byPatientsCreatedForDataOwner(
			dataOwnerId,
			patients,
			from: from,
			to: to,
			descending: descending,
		);
	}

	static Future<SortableFilterOptions<Document>> byPatientsCreatedForSelf(List<Patient> patients, { DateTime? from, DateTime? to, bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.document.byPatientsCreatedForSelf(
			patients,
			from: from,
			to: to,
			descending: descending,
		);
	}

	static Future<BaseSortableFilterOptions<Document>> byPatientSecretIdsCreatedForDataOwner(String dataOwnerId, List<String> secretIds, { DateTime? from, DateTime? to, bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.document.byPatientSecretIdsCreatedForDataOwner(
			dataOwnerId,
			secretIds,
			from: from,
			to: to,
			descending: descending,
		);
	}

	static Future<SortableFilterOptions<Document>> byPatientSecretIdsCreatedForSelf(List<String> secretIds, { DateTime? from, DateTime? to, bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.document.byPatientSecretIdsCreatedForSelf(
			secretIds,
			from: from,
			to: to,
			descending: descending,
		);
	}

	static Future<FilterOptions<Document>> byPatientsAndTypeForDataOwner(String dataOwnerId, DocumentType documentType, List<Patient> patients) async {
		return CardinalSdkPlatformInterface.instance.filters.document.byPatientsAndTypeForDataOwner(
			dataOwnerId,
			documentType,
			patients,
		);
	}

	static Future<FilterOptions<Document>> byPatientsAndTypeForSelf(DocumentType documentType, List<Patient> patients) async {
		return CardinalSdkPlatformInterface.instance.filters.document.byPatientsAndTypeForSelf(
			documentType,
			patients,
		);
	}

	static Future<FilterOptions<Document>> byPatientSecretIdsAndTypeForDataOwner(String dataOwnerId, DocumentType documentType, List<String> secretIds) async {
		return CardinalSdkPlatformInterface.instance.filters.document.byPatientSecretIdsAndTypeForDataOwner(
			dataOwnerId,
			documentType,
			secretIds,
		);
	}

	static Future<FilterOptions<Document>> byPatientSecretIdsAndTypeForSelf(DocumentType documentType, List<String> secretIds) async {
		return CardinalSdkPlatformInterface.instance.filters.document.byPatientSecretIdsAndTypeForSelf(
			documentType,
			secretIds,
		);
	}
}
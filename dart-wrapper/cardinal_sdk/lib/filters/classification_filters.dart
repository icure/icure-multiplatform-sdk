import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/classification.dart';


abstract class ClassificationFilters {
	ClassificationFilters();

	static Future<SortableFilterOptions<Classification>> byPatientsCreatedForDataOwner(String dataOwnerId, List<Patient> patients, int? from, int? to, { bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.classification.byPatientsCreatedForDataOwner(
			dataOwnerId,
			patients,
			from,
			to,
			descending: descending,
		);
	}

	static Future<SortableFilterOptions<Classification>> byPatientsCreatedForSelf(List<Patient> patients, int? from, int? to, { bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.classification.byPatientsCreatedForSelf(
			patients,
			from,
			to,
			descending: descending,
		);
	}

	static Future<BaseSortableFilterOptions<Classification>> byPatientSecretIdsCreatedForDataOwner(String dataOwnerId, List<String> secretIds, int? from, int? to, { bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.classification.byPatientSecretIdsCreatedForDataOwner(
			dataOwnerId,
			secretIds,
			from,
			to,
			descending: descending,
		);
	}

	static Future<SortableFilterOptions<Classification>> byPatientSecretIdsCreatedForSelf(List<String> secretIds, int? from, int? to, { bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.classification.byPatientSecretIdsCreatedForSelf(
			secretIds,
			from,
			to,
			descending: descending,
		);
	}
}
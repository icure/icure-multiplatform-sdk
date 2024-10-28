// auto-generated file
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/access_log.dart';


abstract class AccessLogFilters {
	AccessLogFilters();

	static Future<SortableFilterOptions<AccessLog>> byPatientsDateForDataOwner(String dataOwnerId, List<Patient> patients, DateTime? from, DateTime? to, { bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.accessLog.byPatientsDateForDataOwner(
			dataOwnerId,
			patients,
			from,
			to,
			descending: descending,
		);
	}

	static Future<SortableFilterOptions<AccessLog>> byPatientsDateForSelf(List<Patient> patients, DateTime? from, DateTime? to, { bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.accessLog.byPatientsDateForSelf(
			patients,
			from,
			to,
			descending: descending,
		);
	}

	static Future<BaseSortableFilterOptions<AccessLog>> byPatientSecretIdsDateForDataOwner(String dataOwnerId, List<String> secretIds, DateTime? from, DateTime? to, { bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.accessLog.byPatientSecretIdsDateForDataOwner(
			dataOwnerId,
			secretIds,
			from,
			to,
			descending: descending,
		);
	}

	static Future<SortableFilterOptions<AccessLog>> byPatientSecretIdsDateForSelf(List<String> secretIds, DateTime? from, DateTime? to, { bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.accessLog.byPatientSecretIdsDateForSelf(
			secretIds,
			from,
			to,
			descending: descending,
		);
	}

	static Future<BaseSortableFilterOptions<AccessLog>> byDate(DateTime? from, DateTime? to, { bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.accessLog.byDate(
			from,
			to,
			descending: descending,
		);
	}

	static Future<BaseSortableFilterOptions<AccessLog>> byUserTypeDate(String userId, String? accessType, DateTime? from, { bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.accessLog.byUserTypeDate(
			userId,
			accessType,
			from,
			descending: descending,
		);
	}
}
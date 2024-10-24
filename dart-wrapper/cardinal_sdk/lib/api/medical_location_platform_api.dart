// auto-generated file
import 'package:cardinal_sdk/model/medical_location.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/list_of_ids.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';


class MedicalLocationPlatformApi {
	String _sdkId;
	MedicalLocationPlatformApi(this._sdkId);

	Future<MedicalLocation> createMedicalLocation(MedicalLocation medicalLocationDto) async {
		return await CardinalSdkPlatformInterface.instance.apis.medicalLocation.createMedicalLocation(
			_sdkId,
			medicalLocationDto,
		);
	}

	Future<List<DocIdentifier>> deleteMedicalLocations(ListOfIds locationIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.medicalLocation.deleteMedicalLocations(
			_sdkId,
			locationIds,
		);
	}

	Future<MedicalLocation> getMedicalLocation(String locationId) async {
		return await CardinalSdkPlatformInterface.instance.apis.medicalLocation.getMedicalLocation(
			_sdkId,
			locationId,
		);
	}

	Future<MedicalLocation> modifyMedicalLocation(MedicalLocation medicalLocationDto) async {
		return await CardinalSdkPlatformInterface.instance.apis.medicalLocation.modifyMedicalLocation(
			_sdkId,
			medicalLocationDto,
		);
	}

	Future<List<MedicalLocation>> getMedicalLocations(List<String> medicalLocationIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.medicalLocation.getMedicalLocations(
			_sdkId,
			medicalLocationIds,
		);
	}

	Future<List<String>> matchMedicalLocationsBy(BaseFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.medicalLocation.matchMedicalLocationsBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchMedicalLocationsBySorted(BaseSortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.medicalLocation.matchMedicalLocationsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<MedicalLocation>> filterMedicalLocationsBy(BaseFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.medicalLocation.filterMedicalLocationsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<MedicalLocation>> filterMedicalLocationsBySorted(BaseSortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.medicalLocation.filterMedicalLocationsBySorted(
			_sdkId,
			filter,
		);
	}
}
// auto-generated file
import 'package:cardinal_sdk/model/agenda.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/id_with_mandatory_rev.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';


class AgendaPlatformApi {
	String _sdkId;
	AgendaPlatformApi(this._sdkId);

	Future<Agenda> createAgenda(Agenda agendaDto) async {
		return await CardinalSdkPlatformInterface.instance.apis.agenda.createAgenda(
			_sdkId,
			agendaDto,
		);
	}

	Future<DocIdentifier> deleteAgendaById(String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.agenda.deleteAgendaById(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<List<DocIdentifier>> deleteAgendasByIds(List<IdWithMandatoryRev> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.agenda.deleteAgendasByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<void> purgeAgendaById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.agenda.purgeAgendaById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<Agenda> undeleteAgendaById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.agenda.undeleteAgendaById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DocIdentifier> deleteAgenda(Agenda agenda) async {
		return await CardinalSdkPlatformInterface.instance.apis.agenda.deleteAgenda(
			_sdkId,
			agenda,
		);
	}

	Future<List<DocIdentifier>> deleteAgendas(List<Agenda> agendas) async {
		return await CardinalSdkPlatformInterface.instance.apis.agenda.deleteAgendas(
			_sdkId,
			agendas,
		);
	}

	Future<void> purgeAgenda(Agenda agenda) async {
		return await CardinalSdkPlatformInterface.instance.apis.agenda.purgeAgenda(
			_sdkId,
			agenda,
		);
	}

	Future<Agenda> undeleteAgenda(Agenda agenda) async {
		return await CardinalSdkPlatformInterface.instance.apis.agenda.undeleteAgenda(
			_sdkId,
			agenda,
		);
	}

	Future<Agenda> getAgenda(String agendaId) async {
		return await CardinalSdkPlatformInterface.instance.apis.agenda.getAgenda(
			_sdkId,
			agendaId,
		);
	}

	Future<List<Agenda>> getAgendas(List<String> agendaIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.agenda.getAgendas(
			_sdkId,
			agendaIds,
		);
	}

	Future<Agenda> modifyAgenda(Agenda agendaDto) async {
		return await CardinalSdkPlatformInterface.instance.apis.agenda.modifyAgenda(
			_sdkId,
			agendaDto,
		);
	}

	Future<List<String>> matchAgendasBy(BaseFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.agenda.matchAgendasBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchAgendasBySorted(BaseSortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.agenda.matchAgendasBySorted(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<Agenda>> filterAgendasBy(BaseFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.agenda.filterAgendasBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<Agenda>> filterAgendasBySorted(BaseSortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.agenda.filterAgendasBySorted(
			_sdkId,
			filter,
		);
	}
}
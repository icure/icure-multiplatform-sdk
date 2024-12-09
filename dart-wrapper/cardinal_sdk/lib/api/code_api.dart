// auto-generated file
import 'package:cardinal_sdk/cardinal_sdk.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/code.dart';
import 'package:cardinal_sdk/model/boolean_response.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';


class CodeApi {
	final String _sdkId;
	final CardinalSdk _dartSdk;
	CodeApi(
		this._sdkId,
		this._dartSdk
		);

	Future<List<Code>> listCodesByRegionTypeCodeVersion(String region, { String? type, String? code, String? version }) async {
		return await CardinalSdkPlatformInterface.instance.apis.code.listCodesByRegionTypeCodeVersion(
			_sdkId,
			region,
			type,
			code,
			version,
		);
	}

	Future<List<String>> listCodeTypesBy({ String? region, String? type }) async {
		return await CardinalSdkPlatformInterface.instance.apis.code.listCodeTypesBy(
			_sdkId,
			region,
			type,
		);
	}

	Future<List<String>> listTagTypesBy({ String? region, String? type }) async {
		return await CardinalSdkPlatformInterface.instance.apis.code.listTagTypesBy(
			_sdkId,
			region,
			type,
		);
	}

	Future<Code> createCode(Code c) async {
		return await CardinalSdkPlatformInterface.instance.apis.code.createCode(
			_sdkId,
			c,
		);
	}

	Future<List<Code>> createCodes(List<Code> codeBatch) async {
		return await CardinalSdkPlatformInterface.instance.apis.code.createCodes(
			_sdkId,
			codeBatch,
		);
	}

	Future<List<Code>> createCodesInGroup(String groupId, List<Code> codeBatch) async {
		return await CardinalSdkPlatformInterface.instance.apis.code.createCodesInGroup(
			_sdkId,
			groupId,
			codeBatch,
		);
	}

	Future<BooleanResponse> isCodeValid(String type, String code, String? version) async {
		return await CardinalSdkPlatformInterface.instance.apis.code.isCodeValid(
			_sdkId,
			type,
			code,
			version,
		);
	}

	Future<Code?> getCodeByRegionLanguageTypeLabel(String region, String label, String type, String? languages) async {
		return await CardinalSdkPlatformInterface.instance.apis.code.getCodeByRegionLanguageTypeLabel(
			_sdkId,
			region,
			label,
			type,
			languages,
		);
	}

	Future<List<Code>> getCodes(List<String> codeIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.code.getCodes(
			_sdkId,
			codeIds,
		);
	}

	Future<List<Code>> getCodesInGroup(String groupId, List<String> codeIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.code.getCodesInGroup(
			_sdkId,
			groupId,
			codeIds,
		);
	}

	Future<Code> getCode(String codeId) async {
		return await CardinalSdkPlatformInterface.instance.apis.code.getCode(
			_sdkId,
			codeId,
		);
	}

	Future<Code> getCodeWithParts(String type, String code, String version) async {
		return await CardinalSdkPlatformInterface.instance.apis.code.getCodeWithParts(
			_sdkId,
			type,
			code,
			version,
		);
	}

	Future<Code> modifyCode(Code codeDto) async {
		return await CardinalSdkPlatformInterface.instance.apis.code.modifyCode(
			_sdkId,
			codeDto,
		);
	}

	Future<List<Code>> modifyCodes(List<Code> codeBatch) async {
		return await CardinalSdkPlatformInterface.instance.apis.code.modifyCodes(
			_sdkId,
			codeBatch,
		);
	}

	Future<List<Code>> modifyCodesInGroup(String groupId, List<Code> codeBatch) async {
		return await CardinalSdkPlatformInterface.instance.apis.code.modifyCodesInGroup(
			_sdkId,
			groupId,
			codeBatch,
		);
	}

	Future<PaginatedListIterator<Code>> filterCodesBy(BaseFilterOptions<Code> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.code.filterCodesBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<Code>> filterCodesBySorted(BaseSortableFilterOptions<Code> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.code.filterCodesBySorted(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchCodesBy(BaseFilterOptions<Code> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.code.matchCodesBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchCodesBySorted(BaseSortableFilterOptions<Code> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.code.matchCodesBySorted(
			_sdkId,
			filter,
		);
	}

	Future<void> importCodes(String codeType) async {
		return await CardinalSdkPlatformInterface.instance.apis.code.importCodes(
			_sdkId,
			codeType,
		);
	}
}
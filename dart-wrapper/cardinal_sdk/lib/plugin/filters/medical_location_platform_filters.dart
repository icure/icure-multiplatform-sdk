// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/medical_location.dart';


class MedicalLocationPlatformFilters {
	MethodChannel _methodChannel;
	MedicalLocationPlatformFilters(this._methodChannel);

	Future<BaseFilterOptions<MedicalLocation>> all() async {
		final res = await _methodChannel.invokeMethod<String>(
			'MedicalLocationFilters.all',
			{
			}
		);
		if (res == null) throw AssertionError("received null result from platform method all");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseFilterOptions<MedicalLocation>> byPostCode(String postCode) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MedicalLocationFilters.byPostCode',
			{
				"postCode": jsonEncode(postCode),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byPostCode");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}
}
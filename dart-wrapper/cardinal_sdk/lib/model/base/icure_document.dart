// auto-generated file
import 'package:cardinal_sdk/model/base/identifiable.dart';
import 'package:cardinal_sdk/model/base/has_tags.dart';
import 'package:cardinal_sdk/model/base/has_codes.dart';


abstract interface class ICureDocument<T> implements Identifiable<T>, HasTags, HasCodes {
	abstract final int? created;
	abstract final int? modified;
	abstract final String? author;
	abstract final String? responsible;
	abstract final String? medicalLocationId;
	abstract final int? endOfLife;
}
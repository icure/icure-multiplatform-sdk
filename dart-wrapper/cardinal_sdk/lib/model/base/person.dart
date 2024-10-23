// auto-generated file
import 'package:cardinal_sdk/model/embed/gender.dart';
import 'package:cardinal_sdk/model/embed/person_name.dart';
import 'package:cardinal_sdk/model/embed/address.dart';
import 'package:cardinal_sdk/model/base/identifiable.dart';


abstract interface class Person implements Identifiable<String> {
	abstract String? civility;
	abstract Gender? gender;
	abstract String? firstName;
	abstract String? lastName;
	abstract String? companyName;
	abstract List<PersonName> names;
	List<Address> get addresses;
	abstract List<String> languages;
}
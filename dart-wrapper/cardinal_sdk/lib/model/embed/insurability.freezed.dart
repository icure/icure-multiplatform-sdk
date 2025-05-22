// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'insurability.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$DecryptedInsurability {
  Map<String, String> get parameters;
  bool? get hospitalisation;
  bool? get ambulatory;
  bool? get dental;
  String? get identificationNumber;
  String? get insuranceId;
  int? get startDate;
  int? get endDate;
  String? get titularyId;
  Base64String? get encryptedSelf;

  /// Create a copy of DecryptedInsurability
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DecryptedInsurabilityCopyWith<DecryptedInsurability> get copyWith =>
      _$DecryptedInsurabilityCopyWithImpl<DecryptedInsurability>(
          this as DecryptedInsurability, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is DecryptedInsurability &&
            const DeepCollectionEquality()
                .equals(other.parameters, parameters) &&
            (identical(other.hospitalisation, hospitalisation) ||
                other.hospitalisation == hospitalisation) &&
            (identical(other.ambulatory, ambulatory) ||
                other.ambulatory == ambulatory) &&
            (identical(other.dental, dental) || other.dental == dental) &&
            (identical(other.identificationNumber, identificationNumber) ||
                other.identificationNumber == identificationNumber) &&
            (identical(other.insuranceId, insuranceId) ||
                other.insuranceId == insuranceId) &&
            (identical(other.startDate, startDate) ||
                other.startDate == startDate) &&
            (identical(other.endDate, endDate) || other.endDate == endDate) &&
            (identical(other.titularyId, titularyId) ||
                other.titularyId == titularyId) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      const DeepCollectionEquality().hash(parameters),
      hospitalisation,
      ambulatory,
      dental,
      identificationNumber,
      insuranceId,
      startDate,
      endDate,
      titularyId,
      encryptedSelf);

  @override
  String toString() {
    return 'DecryptedInsurability(parameters: $parameters, hospitalisation: $hospitalisation, ambulatory: $ambulatory, dental: $dental, identificationNumber: $identificationNumber, insuranceId: $insuranceId, startDate: $startDate, endDate: $endDate, titularyId: $titularyId, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class $DecryptedInsurabilityCopyWith<$Res> {
  factory $DecryptedInsurabilityCopyWith(DecryptedInsurability value,
          $Res Function(DecryptedInsurability) _then) =
      _$DecryptedInsurabilityCopyWithImpl;
  @useResult
  $Res call(
      {Map<String, String> parameters,
      bool? hospitalisation,
      bool? ambulatory,
      bool? dental,
      String? identificationNumber,
      String? insuranceId,
      int? startDate,
      int? endDate,
      String? titularyId,
      Base64String? encryptedSelf});
}

/// @nodoc
class _$DecryptedInsurabilityCopyWithImpl<$Res>
    implements $DecryptedInsurabilityCopyWith<$Res> {
  _$DecryptedInsurabilityCopyWithImpl(this._self, this._then);

  final DecryptedInsurability _self;
  final $Res Function(DecryptedInsurability) _then;

  /// Create a copy of DecryptedInsurability
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? parameters = null,
    Object? hospitalisation = freezed,
    Object? ambulatory = freezed,
    Object? dental = freezed,
    Object? identificationNumber = freezed,
    Object? insuranceId = freezed,
    Object? startDate = freezed,
    Object? endDate = freezed,
    Object? titularyId = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_self.copyWith(
      parameters: null == parameters
          ? _self.parameters
          : parameters // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      hospitalisation: freezed == hospitalisation
          ? _self.hospitalisation
          : hospitalisation // ignore: cast_nullable_to_non_nullable
              as bool?,
      ambulatory: freezed == ambulatory
          ? _self.ambulatory
          : ambulatory // ignore: cast_nullable_to_non_nullable
              as bool?,
      dental: freezed == dental
          ? _self.dental
          : dental // ignore: cast_nullable_to_non_nullable
              as bool?,
      identificationNumber: freezed == identificationNumber
          ? _self.identificationNumber
          : identificationNumber // ignore: cast_nullable_to_non_nullable
              as String?,
      insuranceId: freezed == insuranceId
          ? _self.insuranceId
          : insuranceId // ignore: cast_nullable_to_non_nullable
              as String?,
      startDate: freezed == startDate
          ? _self.startDate
          : startDate // ignore: cast_nullable_to_non_nullable
              as int?,
      endDate: freezed == endDate
          ? _self.endDate
          : endDate // ignore: cast_nullable_to_non_nullable
              as int?,
      titularyId: freezed == titularyId
          ? _self.titularyId
          : titularyId // ignore: cast_nullable_to_non_nullable
              as String?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc

class _DecryptedInsurability implements DecryptedInsurability {
  const _DecryptedInsurability(
      {final Map<String, String> parameters = const {},
      this.hospitalisation = null,
      this.ambulatory = null,
      this.dental = null,
      this.identificationNumber = null,
      this.insuranceId = null,
      this.startDate = null,
      this.endDate = null,
      this.titularyId = null,
      this.encryptedSelf = null})
      : _parameters = parameters;

  final Map<String, String> _parameters;
  @override
  @JsonKey()
  Map<String, String> get parameters {
    if (_parameters is EqualUnmodifiableMapView) return _parameters;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_parameters);
  }

  @override
  @JsonKey()
  final bool? hospitalisation;
  @override
  @JsonKey()
  final bool? ambulatory;
  @override
  @JsonKey()
  final bool? dental;
  @override
  @JsonKey()
  final String? identificationNumber;
  @override
  @JsonKey()
  final String? insuranceId;
  @override
  @JsonKey()
  final int? startDate;
  @override
  @JsonKey()
  final int? endDate;
  @override
  @JsonKey()
  final String? titularyId;
  @override
  @JsonKey()
  final Base64String? encryptedSelf;

  /// Create a copy of DecryptedInsurability
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DecryptedInsurabilityCopyWith<_DecryptedInsurability> get copyWith =>
      __$DecryptedInsurabilityCopyWithImpl<_DecryptedInsurability>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _DecryptedInsurability &&
            const DeepCollectionEquality()
                .equals(other._parameters, _parameters) &&
            (identical(other.hospitalisation, hospitalisation) ||
                other.hospitalisation == hospitalisation) &&
            (identical(other.ambulatory, ambulatory) ||
                other.ambulatory == ambulatory) &&
            (identical(other.dental, dental) || other.dental == dental) &&
            (identical(other.identificationNumber, identificationNumber) ||
                other.identificationNumber == identificationNumber) &&
            (identical(other.insuranceId, insuranceId) ||
                other.insuranceId == insuranceId) &&
            (identical(other.startDate, startDate) ||
                other.startDate == startDate) &&
            (identical(other.endDate, endDate) || other.endDate == endDate) &&
            (identical(other.titularyId, titularyId) ||
                other.titularyId == titularyId) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      const DeepCollectionEquality().hash(_parameters),
      hospitalisation,
      ambulatory,
      dental,
      identificationNumber,
      insuranceId,
      startDate,
      endDate,
      titularyId,
      encryptedSelf);

  @override
  String toString() {
    return 'DecryptedInsurability(parameters: $parameters, hospitalisation: $hospitalisation, ambulatory: $ambulatory, dental: $dental, identificationNumber: $identificationNumber, insuranceId: $insuranceId, startDate: $startDate, endDate: $endDate, titularyId: $titularyId, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class _$DecryptedInsurabilityCopyWith<$Res>
    implements $DecryptedInsurabilityCopyWith<$Res> {
  factory _$DecryptedInsurabilityCopyWith(_DecryptedInsurability value,
          $Res Function(_DecryptedInsurability) _then) =
      __$DecryptedInsurabilityCopyWithImpl;
  @override
  @useResult
  $Res call(
      {Map<String, String> parameters,
      bool? hospitalisation,
      bool? ambulatory,
      bool? dental,
      String? identificationNumber,
      String? insuranceId,
      int? startDate,
      int? endDate,
      String? titularyId,
      Base64String? encryptedSelf});
}

/// @nodoc
class __$DecryptedInsurabilityCopyWithImpl<$Res>
    implements _$DecryptedInsurabilityCopyWith<$Res> {
  __$DecryptedInsurabilityCopyWithImpl(this._self, this._then);

  final _DecryptedInsurability _self;
  final $Res Function(_DecryptedInsurability) _then;

  /// Create a copy of DecryptedInsurability
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? parameters = null,
    Object? hospitalisation = freezed,
    Object? ambulatory = freezed,
    Object? dental = freezed,
    Object? identificationNumber = freezed,
    Object? insuranceId = freezed,
    Object? startDate = freezed,
    Object? endDate = freezed,
    Object? titularyId = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_DecryptedInsurability(
      parameters: null == parameters
          ? _self._parameters
          : parameters // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      hospitalisation: freezed == hospitalisation
          ? _self.hospitalisation
          : hospitalisation // ignore: cast_nullable_to_non_nullable
              as bool?,
      ambulatory: freezed == ambulatory
          ? _self.ambulatory
          : ambulatory // ignore: cast_nullable_to_non_nullable
              as bool?,
      dental: freezed == dental
          ? _self.dental
          : dental // ignore: cast_nullable_to_non_nullable
              as bool?,
      identificationNumber: freezed == identificationNumber
          ? _self.identificationNumber
          : identificationNumber // ignore: cast_nullable_to_non_nullable
              as String?,
      insuranceId: freezed == insuranceId
          ? _self.insuranceId
          : insuranceId // ignore: cast_nullable_to_non_nullable
              as String?,
      startDate: freezed == startDate
          ? _self.startDate
          : startDate // ignore: cast_nullable_to_non_nullable
              as int?,
      endDate: freezed == endDate
          ? _self.endDate
          : endDate // ignore: cast_nullable_to_non_nullable
              as int?,
      titularyId: freezed == titularyId
          ? _self.titularyId
          : titularyId // ignore: cast_nullable_to_non_nullable
              as String?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc
mixin _$EncryptedInsurability {
  Map<String, String> get parameters;
  bool? get hospitalisation;
  bool? get ambulatory;
  bool? get dental;
  String? get identificationNumber;
  String? get insuranceId;
  int? get startDate;
  int? get endDate;
  String? get titularyId;
  Base64String? get encryptedSelf;

  /// Create a copy of EncryptedInsurability
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $EncryptedInsurabilityCopyWith<EncryptedInsurability> get copyWith =>
      _$EncryptedInsurabilityCopyWithImpl<EncryptedInsurability>(
          this as EncryptedInsurability, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is EncryptedInsurability &&
            const DeepCollectionEquality()
                .equals(other.parameters, parameters) &&
            (identical(other.hospitalisation, hospitalisation) ||
                other.hospitalisation == hospitalisation) &&
            (identical(other.ambulatory, ambulatory) ||
                other.ambulatory == ambulatory) &&
            (identical(other.dental, dental) || other.dental == dental) &&
            (identical(other.identificationNumber, identificationNumber) ||
                other.identificationNumber == identificationNumber) &&
            (identical(other.insuranceId, insuranceId) ||
                other.insuranceId == insuranceId) &&
            (identical(other.startDate, startDate) ||
                other.startDate == startDate) &&
            (identical(other.endDate, endDate) || other.endDate == endDate) &&
            (identical(other.titularyId, titularyId) ||
                other.titularyId == titularyId) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      const DeepCollectionEquality().hash(parameters),
      hospitalisation,
      ambulatory,
      dental,
      identificationNumber,
      insuranceId,
      startDate,
      endDate,
      titularyId,
      encryptedSelf);

  @override
  String toString() {
    return 'EncryptedInsurability(parameters: $parameters, hospitalisation: $hospitalisation, ambulatory: $ambulatory, dental: $dental, identificationNumber: $identificationNumber, insuranceId: $insuranceId, startDate: $startDate, endDate: $endDate, titularyId: $titularyId, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class $EncryptedInsurabilityCopyWith<$Res> {
  factory $EncryptedInsurabilityCopyWith(EncryptedInsurability value,
          $Res Function(EncryptedInsurability) _then) =
      _$EncryptedInsurabilityCopyWithImpl;
  @useResult
  $Res call(
      {Map<String, String> parameters,
      bool? hospitalisation,
      bool? ambulatory,
      bool? dental,
      String? identificationNumber,
      String? insuranceId,
      int? startDate,
      int? endDate,
      String? titularyId,
      Base64String? encryptedSelf});
}

/// @nodoc
class _$EncryptedInsurabilityCopyWithImpl<$Res>
    implements $EncryptedInsurabilityCopyWith<$Res> {
  _$EncryptedInsurabilityCopyWithImpl(this._self, this._then);

  final EncryptedInsurability _self;
  final $Res Function(EncryptedInsurability) _then;

  /// Create a copy of EncryptedInsurability
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? parameters = null,
    Object? hospitalisation = freezed,
    Object? ambulatory = freezed,
    Object? dental = freezed,
    Object? identificationNumber = freezed,
    Object? insuranceId = freezed,
    Object? startDate = freezed,
    Object? endDate = freezed,
    Object? titularyId = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_self.copyWith(
      parameters: null == parameters
          ? _self.parameters
          : parameters // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      hospitalisation: freezed == hospitalisation
          ? _self.hospitalisation
          : hospitalisation // ignore: cast_nullable_to_non_nullable
              as bool?,
      ambulatory: freezed == ambulatory
          ? _self.ambulatory
          : ambulatory // ignore: cast_nullable_to_non_nullable
              as bool?,
      dental: freezed == dental
          ? _self.dental
          : dental // ignore: cast_nullable_to_non_nullable
              as bool?,
      identificationNumber: freezed == identificationNumber
          ? _self.identificationNumber
          : identificationNumber // ignore: cast_nullable_to_non_nullable
              as String?,
      insuranceId: freezed == insuranceId
          ? _self.insuranceId
          : insuranceId // ignore: cast_nullable_to_non_nullable
              as String?,
      startDate: freezed == startDate
          ? _self.startDate
          : startDate // ignore: cast_nullable_to_non_nullable
              as int?,
      endDate: freezed == endDate
          ? _self.endDate
          : endDate // ignore: cast_nullable_to_non_nullable
              as int?,
      titularyId: freezed == titularyId
          ? _self.titularyId
          : titularyId // ignore: cast_nullable_to_non_nullable
              as String?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc

class _EncryptedInsurability implements EncryptedInsurability {
  const _EncryptedInsurability(
      {final Map<String, String> parameters = const {},
      this.hospitalisation = null,
      this.ambulatory = null,
      this.dental = null,
      this.identificationNumber = null,
      this.insuranceId = null,
      this.startDate = null,
      this.endDate = null,
      this.titularyId = null,
      this.encryptedSelf = null})
      : _parameters = parameters;

  final Map<String, String> _parameters;
  @override
  @JsonKey()
  Map<String, String> get parameters {
    if (_parameters is EqualUnmodifiableMapView) return _parameters;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_parameters);
  }

  @override
  @JsonKey()
  final bool? hospitalisation;
  @override
  @JsonKey()
  final bool? ambulatory;
  @override
  @JsonKey()
  final bool? dental;
  @override
  @JsonKey()
  final String? identificationNumber;
  @override
  @JsonKey()
  final String? insuranceId;
  @override
  @JsonKey()
  final int? startDate;
  @override
  @JsonKey()
  final int? endDate;
  @override
  @JsonKey()
  final String? titularyId;
  @override
  @JsonKey()
  final Base64String? encryptedSelf;

  /// Create a copy of EncryptedInsurability
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$EncryptedInsurabilityCopyWith<_EncryptedInsurability> get copyWith =>
      __$EncryptedInsurabilityCopyWithImpl<_EncryptedInsurability>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _EncryptedInsurability &&
            const DeepCollectionEquality()
                .equals(other._parameters, _parameters) &&
            (identical(other.hospitalisation, hospitalisation) ||
                other.hospitalisation == hospitalisation) &&
            (identical(other.ambulatory, ambulatory) ||
                other.ambulatory == ambulatory) &&
            (identical(other.dental, dental) || other.dental == dental) &&
            (identical(other.identificationNumber, identificationNumber) ||
                other.identificationNumber == identificationNumber) &&
            (identical(other.insuranceId, insuranceId) ||
                other.insuranceId == insuranceId) &&
            (identical(other.startDate, startDate) ||
                other.startDate == startDate) &&
            (identical(other.endDate, endDate) || other.endDate == endDate) &&
            (identical(other.titularyId, titularyId) ||
                other.titularyId == titularyId) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      const DeepCollectionEquality().hash(_parameters),
      hospitalisation,
      ambulatory,
      dental,
      identificationNumber,
      insuranceId,
      startDate,
      endDate,
      titularyId,
      encryptedSelf);

  @override
  String toString() {
    return 'EncryptedInsurability(parameters: $parameters, hospitalisation: $hospitalisation, ambulatory: $ambulatory, dental: $dental, identificationNumber: $identificationNumber, insuranceId: $insuranceId, startDate: $startDate, endDate: $endDate, titularyId: $titularyId, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class _$EncryptedInsurabilityCopyWith<$Res>
    implements $EncryptedInsurabilityCopyWith<$Res> {
  factory _$EncryptedInsurabilityCopyWith(_EncryptedInsurability value,
          $Res Function(_EncryptedInsurability) _then) =
      __$EncryptedInsurabilityCopyWithImpl;
  @override
  @useResult
  $Res call(
      {Map<String, String> parameters,
      bool? hospitalisation,
      bool? ambulatory,
      bool? dental,
      String? identificationNumber,
      String? insuranceId,
      int? startDate,
      int? endDate,
      String? titularyId,
      Base64String? encryptedSelf});
}

/// @nodoc
class __$EncryptedInsurabilityCopyWithImpl<$Res>
    implements _$EncryptedInsurabilityCopyWith<$Res> {
  __$EncryptedInsurabilityCopyWithImpl(this._self, this._then);

  final _EncryptedInsurability _self;
  final $Res Function(_EncryptedInsurability) _then;

  /// Create a copy of EncryptedInsurability
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? parameters = null,
    Object? hospitalisation = freezed,
    Object? ambulatory = freezed,
    Object? dental = freezed,
    Object? identificationNumber = freezed,
    Object? insuranceId = freezed,
    Object? startDate = freezed,
    Object? endDate = freezed,
    Object? titularyId = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_EncryptedInsurability(
      parameters: null == parameters
          ? _self._parameters
          : parameters // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      hospitalisation: freezed == hospitalisation
          ? _self.hospitalisation
          : hospitalisation // ignore: cast_nullable_to_non_nullable
              as bool?,
      ambulatory: freezed == ambulatory
          ? _self.ambulatory
          : ambulatory // ignore: cast_nullable_to_non_nullable
              as bool?,
      dental: freezed == dental
          ? _self.dental
          : dental // ignore: cast_nullable_to_non_nullable
              as bool?,
      identificationNumber: freezed == identificationNumber
          ? _self.identificationNumber
          : identificationNumber // ignore: cast_nullable_to_non_nullable
              as String?,
      insuranceId: freezed == insuranceId
          ? _self.insuranceId
          : insuranceId // ignore: cast_nullable_to_non_nullable
              as String?,
      startDate: freezed == startDate
          ? _self.startDate
          : startDate // ignore: cast_nullable_to_non_nullable
              as int?,
      endDate: freezed == endDate
          ? _self.endDate
          : endDate // ignore: cast_nullable_to_non_nullable
              as int?,
      titularyId: freezed == titularyId
          ? _self.titularyId
          : titularyId // ignore: cast_nullable_to_non_nullable
              as String?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

// dart format on

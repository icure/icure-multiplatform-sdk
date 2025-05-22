// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'insurance.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$Insurance {
  String get id;
  String? get rev;
  int? get deletionDate;
  Map<String, String> get name;
  bool get privateInsurance;
  bool get hospitalisationInsurance;
  bool get ambulatoryInsurance;
  String? get code;
  String? get agreementNumber;
  String? get parent;
  DecryptedAddress get address;

  /// Create a copy of Insurance
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $InsuranceCopyWith<Insurance> get copyWith =>
      _$InsuranceCopyWithImpl<Insurance>(this as Insurance, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is Insurance &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            const DeepCollectionEquality().equals(other.name, name) &&
            (identical(other.privateInsurance, privateInsurance) ||
                other.privateInsurance == privateInsurance) &&
            (identical(
                    other.hospitalisationInsurance, hospitalisationInsurance) ||
                other.hospitalisationInsurance == hospitalisationInsurance) &&
            (identical(other.ambulatoryInsurance, ambulatoryInsurance) ||
                other.ambulatoryInsurance == ambulatoryInsurance) &&
            (identical(other.code, code) || other.code == code) &&
            (identical(other.agreementNumber, agreementNumber) ||
                other.agreementNumber == agreementNumber) &&
            (identical(other.parent, parent) || other.parent == parent) &&
            (identical(other.address, address) || other.address == address));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      id,
      rev,
      deletionDate,
      const DeepCollectionEquality().hash(name),
      privateInsurance,
      hospitalisationInsurance,
      ambulatoryInsurance,
      code,
      agreementNumber,
      parent,
      address);

  @override
  String toString() {
    return 'Insurance(id: $id, rev: $rev, deletionDate: $deletionDate, name: $name, privateInsurance: $privateInsurance, hospitalisationInsurance: $hospitalisationInsurance, ambulatoryInsurance: $ambulatoryInsurance, code: $code, agreementNumber: $agreementNumber, parent: $parent, address: $address)';
  }
}

/// @nodoc
abstract mixin class $InsuranceCopyWith<$Res> {
  factory $InsuranceCopyWith(Insurance value, $Res Function(Insurance) _then) =
      _$InsuranceCopyWithImpl;
  @useResult
  $Res call(
      {String id,
      String? rev,
      int? deletionDate,
      Map<String, String> name,
      bool privateInsurance,
      bool hospitalisationInsurance,
      bool ambulatoryInsurance,
      String? code,
      String? agreementNumber,
      String? parent,
      DecryptedAddress address});

  $DecryptedAddressCopyWith<$Res> get address;
}

/// @nodoc
class _$InsuranceCopyWithImpl<$Res> implements $InsuranceCopyWith<$Res> {
  _$InsuranceCopyWithImpl(this._self, this._then);

  final Insurance _self;
  final $Res Function(Insurance) _then;

  /// Create a copy of Insurance
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? deletionDate = freezed,
    Object? name = null,
    Object? privateInsurance = null,
    Object? hospitalisationInsurance = null,
    Object? ambulatoryInsurance = null,
    Object? code = freezed,
    Object? agreementNumber = freezed,
    Object? parent = freezed,
    Object? address = null,
  }) {
    return _then(_self.copyWith(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      rev: freezed == rev
          ? _self.rev
          : rev // ignore: cast_nullable_to_non_nullable
              as String?,
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      name: null == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      privateInsurance: null == privateInsurance
          ? _self.privateInsurance
          : privateInsurance // ignore: cast_nullable_to_non_nullable
              as bool,
      hospitalisationInsurance: null == hospitalisationInsurance
          ? _self.hospitalisationInsurance
          : hospitalisationInsurance // ignore: cast_nullable_to_non_nullable
              as bool,
      ambulatoryInsurance: null == ambulatoryInsurance
          ? _self.ambulatoryInsurance
          : ambulatoryInsurance // ignore: cast_nullable_to_non_nullable
              as bool,
      code: freezed == code
          ? _self.code
          : code // ignore: cast_nullable_to_non_nullable
              as String?,
      agreementNumber: freezed == agreementNumber
          ? _self.agreementNumber
          : agreementNumber // ignore: cast_nullable_to_non_nullable
              as String?,
      parent: freezed == parent
          ? _self.parent
          : parent // ignore: cast_nullable_to_non_nullable
              as String?,
      address: null == address
          ? _self.address
          : address // ignore: cast_nullable_to_non_nullable
              as DecryptedAddress,
    ));
  }

  /// Create a copy of Insurance
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $DecryptedAddressCopyWith<$Res> get address {
    return $DecryptedAddressCopyWith<$Res>(_self.address, (value) {
      return _then(_self.copyWith(address: value));
    });
  }
}

/// @nodoc

class _Insurance implements Insurance {
  const _Insurance(
      {required this.id,
      this.rev = null,
      this.deletionDate = null,
      final Map<String, String> name = const {},
      this.privateInsurance = false,
      this.hospitalisationInsurance = false,
      this.ambulatoryInsurance = false,
      this.code = null,
      this.agreementNumber = null,
      this.parent = null,
      required this.address})
      : _name = name;

  @override
  final String id;
  @override
  @JsonKey()
  final String? rev;
  @override
  @JsonKey()
  final int? deletionDate;
  final Map<String, String> _name;
  @override
  @JsonKey()
  Map<String, String> get name {
    if (_name is EqualUnmodifiableMapView) return _name;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_name);
  }

  @override
  @JsonKey()
  final bool privateInsurance;
  @override
  @JsonKey()
  final bool hospitalisationInsurance;
  @override
  @JsonKey()
  final bool ambulatoryInsurance;
  @override
  @JsonKey()
  final String? code;
  @override
  @JsonKey()
  final String? agreementNumber;
  @override
  @JsonKey()
  final String? parent;
  @override
  final DecryptedAddress address;

  /// Create a copy of Insurance
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$InsuranceCopyWith<_Insurance> get copyWith =>
      __$InsuranceCopyWithImpl<_Insurance>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _Insurance &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            const DeepCollectionEquality().equals(other._name, _name) &&
            (identical(other.privateInsurance, privateInsurance) ||
                other.privateInsurance == privateInsurance) &&
            (identical(
                    other.hospitalisationInsurance, hospitalisationInsurance) ||
                other.hospitalisationInsurance == hospitalisationInsurance) &&
            (identical(other.ambulatoryInsurance, ambulatoryInsurance) ||
                other.ambulatoryInsurance == ambulatoryInsurance) &&
            (identical(other.code, code) || other.code == code) &&
            (identical(other.agreementNumber, agreementNumber) ||
                other.agreementNumber == agreementNumber) &&
            (identical(other.parent, parent) || other.parent == parent) &&
            (identical(other.address, address) || other.address == address));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      id,
      rev,
      deletionDate,
      const DeepCollectionEquality().hash(_name),
      privateInsurance,
      hospitalisationInsurance,
      ambulatoryInsurance,
      code,
      agreementNumber,
      parent,
      address);

  @override
  String toString() {
    return 'Insurance(id: $id, rev: $rev, deletionDate: $deletionDate, name: $name, privateInsurance: $privateInsurance, hospitalisationInsurance: $hospitalisationInsurance, ambulatoryInsurance: $ambulatoryInsurance, code: $code, agreementNumber: $agreementNumber, parent: $parent, address: $address)';
  }
}

/// @nodoc
abstract mixin class _$InsuranceCopyWith<$Res>
    implements $InsuranceCopyWith<$Res> {
  factory _$InsuranceCopyWith(
          _Insurance value, $Res Function(_Insurance) _then) =
      __$InsuranceCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String id,
      String? rev,
      int? deletionDate,
      Map<String, String> name,
      bool privateInsurance,
      bool hospitalisationInsurance,
      bool ambulatoryInsurance,
      String? code,
      String? agreementNumber,
      String? parent,
      DecryptedAddress address});

  @override
  $DecryptedAddressCopyWith<$Res> get address;
}

/// @nodoc
class __$InsuranceCopyWithImpl<$Res> implements _$InsuranceCopyWith<$Res> {
  __$InsuranceCopyWithImpl(this._self, this._then);

  final _Insurance _self;
  final $Res Function(_Insurance) _then;

  /// Create a copy of Insurance
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? deletionDate = freezed,
    Object? name = null,
    Object? privateInsurance = null,
    Object? hospitalisationInsurance = null,
    Object? ambulatoryInsurance = null,
    Object? code = freezed,
    Object? agreementNumber = freezed,
    Object? parent = freezed,
    Object? address = null,
  }) {
    return _then(_Insurance(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      rev: freezed == rev
          ? _self.rev
          : rev // ignore: cast_nullable_to_non_nullable
              as String?,
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      name: null == name
          ? _self._name
          : name // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      privateInsurance: null == privateInsurance
          ? _self.privateInsurance
          : privateInsurance // ignore: cast_nullable_to_non_nullable
              as bool,
      hospitalisationInsurance: null == hospitalisationInsurance
          ? _self.hospitalisationInsurance
          : hospitalisationInsurance // ignore: cast_nullable_to_non_nullable
              as bool,
      ambulatoryInsurance: null == ambulatoryInsurance
          ? _self.ambulatoryInsurance
          : ambulatoryInsurance // ignore: cast_nullable_to_non_nullable
              as bool,
      code: freezed == code
          ? _self.code
          : code // ignore: cast_nullable_to_non_nullable
              as String?,
      agreementNumber: freezed == agreementNumber
          ? _self.agreementNumber
          : agreementNumber // ignore: cast_nullable_to_non_nullable
              as String?,
      parent: freezed == parent
          ? _self.parent
          : parent // ignore: cast_nullable_to_non_nullable
              as String?,
      address: null == address
          ? _self.address
          : address // ignore: cast_nullable_to_non_nullable
              as DecryptedAddress,
    ));
  }

  /// Create a copy of Insurance
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $DecryptedAddressCopyWith<$Res> get address {
    return $DecryptedAddressCopyWith<$Res>(_self.address, (value) {
      return _then(_self.copyWith(address: value));
    });
  }
}

// dart format on

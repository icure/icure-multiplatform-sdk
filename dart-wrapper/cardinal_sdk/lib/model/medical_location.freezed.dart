// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'medical_location.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$MedicalLocation {
  String get id;
  String? get rev;
  int? get deletionDate;
  String? get name;
  String? get description;
  String? get responsible;
  bool? get guardPost;
  String? get cbe;
  String? get bic;
  String? get bankAccount;
  String? get nihii;
  String? get ssin;
  DecryptedAddress? get address;
  Set<String> get agendaIds;
  Map<String, String> get options;
  Map<String, String> get publicInformations;

  /// Create a copy of MedicalLocation
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $MedicalLocationCopyWith<MedicalLocation> get copyWith =>
      _$MedicalLocationCopyWithImpl<MedicalLocation>(
          this as MedicalLocation, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is MedicalLocation &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.description, description) ||
                other.description == description) &&
            (identical(other.responsible, responsible) ||
                other.responsible == responsible) &&
            (identical(other.guardPost, guardPost) ||
                other.guardPost == guardPost) &&
            (identical(other.cbe, cbe) || other.cbe == cbe) &&
            (identical(other.bic, bic) || other.bic == bic) &&
            (identical(other.bankAccount, bankAccount) ||
                other.bankAccount == bankAccount) &&
            (identical(other.nihii, nihii) || other.nihii == nihii) &&
            (identical(other.ssin, ssin) || other.ssin == ssin) &&
            (identical(other.address, address) || other.address == address) &&
            const DeepCollectionEquality().equals(other.agendaIds, agendaIds) &&
            const DeepCollectionEquality().equals(other.options, options) &&
            const DeepCollectionEquality()
                .equals(other.publicInformations, publicInformations));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      id,
      rev,
      deletionDate,
      name,
      description,
      responsible,
      guardPost,
      cbe,
      bic,
      bankAccount,
      nihii,
      ssin,
      address,
      const DeepCollectionEquality().hash(agendaIds),
      const DeepCollectionEquality().hash(options),
      const DeepCollectionEquality().hash(publicInformations));

  @override
  String toString() {
    return 'MedicalLocation(id: $id, rev: $rev, deletionDate: $deletionDate, name: $name, description: $description, responsible: $responsible, guardPost: $guardPost, cbe: $cbe, bic: $bic, bankAccount: $bankAccount, nihii: $nihii, ssin: $ssin, address: $address, agendaIds: $agendaIds, options: $options, publicInformations: $publicInformations)';
  }
}

/// @nodoc
abstract mixin class $MedicalLocationCopyWith<$Res> {
  factory $MedicalLocationCopyWith(
          MedicalLocation value, $Res Function(MedicalLocation) _then) =
      _$MedicalLocationCopyWithImpl;
  @useResult
  $Res call(
      {String id,
      String? rev,
      int? deletionDate,
      String? name,
      String? description,
      String? responsible,
      bool? guardPost,
      String? cbe,
      String? bic,
      String? bankAccount,
      String? nihii,
      String? ssin,
      DecryptedAddress? address,
      Set<String> agendaIds,
      Map<String, String> options,
      Map<String, String> publicInformations});

  $DecryptedAddressCopyWith<$Res>? get address;
}

/// @nodoc
class _$MedicalLocationCopyWithImpl<$Res>
    implements $MedicalLocationCopyWith<$Res> {
  _$MedicalLocationCopyWithImpl(this._self, this._then);

  final MedicalLocation _self;
  final $Res Function(MedicalLocation) _then;

  /// Create a copy of MedicalLocation
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? deletionDate = freezed,
    Object? name = freezed,
    Object? description = freezed,
    Object? responsible = freezed,
    Object? guardPost = freezed,
    Object? cbe = freezed,
    Object? bic = freezed,
    Object? bankAccount = freezed,
    Object? nihii = freezed,
    Object? ssin = freezed,
    Object? address = freezed,
    Object? agendaIds = null,
    Object? options = null,
    Object? publicInformations = null,
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
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      description: freezed == description
          ? _self.description
          : description // ignore: cast_nullable_to_non_nullable
              as String?,
      responsible: freezed == responsible
          ? _self.responsible
          : responsible // ignore: cast_nullable_to_non_nullable
              as String?,
      guardPost: freezed == guardPost
          ? _self.guardPost
          : guardPost // ignore: cast_nullable_to_non_nullable
              as bool?,
      cbe: freezed == cbe
          ? _self.cbe
          : cbe // ignore: cast_nullable_to_non_nullable
              as String?,
      bic: freezed == bic
          ? _self.bic
          : bic // ignore: cast_nullable_to_non_nullable
              as String?,
      bankAccount: freezed == bankAccount
          ? _self.bankAccount
          : bankAccount // ignore: cast_nullable_to_non_nullable
              as String?,
      nihii: freezed == nihii
          ? _self.nihii
          : nihii // ignore: cast_nullable_to_non_nullable
              as String?,
      ssin: freezed == ssin
          ? _self.ssin
          : ssin // ignore: cast_nullable_to_non_nullable
              as String?,
      address: freezed == address
          ? _self.address
          : address // ignore: cast_nullable_to_non_nullable
              as DecryptedAddress?,
      agendaIds: null == agendaIds
          ? _self.agendaIds
          : agendaIds // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      options: null == options
          ? _self.options
          : options // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      publicInformations: null == publicInformations
          ? _self.publicInformations
          : publicInformations // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
    ));
  }

  /// Create a copy of MedicalLocation
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $DecryptedAddressCopyWith<$Res>? get address {
    if (_self.address == null) {
      return null;
    }

    return $DecryptedAddressCopyWith<$Res>(_self.address!, (value) {
      return _then(_self.copyWith(address: value));
    });
  }
}

/// @nodoc

class _MedicalLocation implements MedicalLocation {
  const _MedicalLocation(
      {required this.id,
      this.rev = null,
      this.deletionDate = null,
      this.name = null,
      this.description = null,
      this.responsible = null,
      this.guardPost = null,
      this.cbe = null,
      this.bic = null,
      this.bankAccount = null,
      this.nihii = null,
      this.ssin = null,
      this.address = null,
      final Set<String> agendaIds = const {},
      final Map<String, String> options = const {},
      final Map<String, String> publicInformations = const {}})
      : _agendaIds = agendaIds,
        _options = options,
        _publicInformations = publicInformations;

  @override
  final String id;
  @override
  @JsonKey()
  final String? rev;
  @override
  @JsonKey()
  final int? deletionDate;
  @override
  @JsonKey()
  final String? name;
  @override
  @JsonKey()
  final String? description;
  @override
  @JsonKey()
  final String? responsible;
  @override
  @JsonKey()
  final bool? guardPost;
  @override
  @JsonKey()
  final String? cbe;
  @override
  @JsonKey()
  final String? bic;
  @override
  @JsonKey()
  final String? bankAccount;
  @override
  @JsonKey()
  final String? nihii;
  @override
  @JsonKey()
  final String? ssin;
  @override
  @JsonKey()
  final DecryptedAddress? address;
  final Set<String> _agendaIds;
  @override
  @JsonKey()
  Set<String> get agendaIds {
    if (_agendaIds is EqualUnmodifiableSetView) return _agendaIds;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_agendaIds);
  }

  final Map<String, String> _options;
  @override
  @JsonKey()
  Map<String, String> get options {
    if (_options is EqualUnmodifiableMapView) return _options;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_options);
  }

  final Map<String, String> _publicInformations;
  @override
  @JsonKey()
  Map<String, String> get publicInformations {
    if (_publicInformations is EqualUnmodifiableMapView)
      return _publicInformations;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_publicInformations);
  }

  /// Create a copy of MedicalLocation
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$MedicalLocationCopyWith<_MedicalLocation> get copyWith =>
      __$MedicalLocationCopyWithImpl<_MedicalLocation>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _MedicalLocation &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.description, description) ||
                other.description == description) &&
            (identical(other.responsible, responsible) ||
                other.responsible == responsible) &&
            (identical(other.guardPost, guardPost) ||
                other.guardPost == guardPost) &&
            (identical(other.cbe, cbe) || other.cbe == cbe) &&
            (identical(other.bic, bic) || other.bic == bic) &&
            (identical(other.bankAccount, bankAccount) ||
                other.bankAccount == bankAccount) &&
            (identical(other.nihii, nihii) || other.nihii == nihii) &&
            (identical(other.ssin, ssin) || other.ssin == ssin) &&
            (identical(other.address, address) || other.address == address) &&
            const DeepCollectionEquality()
                .equals(other._agendaIds, _agendaIds) &&
            const DeepCollectionEquality().equals(other._options, _options) &&
            const DeepCollectionEquality()
                .equals(other._publicInformations, _publicInformations));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      id,
      rev,
      deletionDate,
      name,
      description,
      responsible,
      guardPost,
      cbe,
      bic,
      bankAccount,
      nihii,
      ssin,
      address,
      const DeepCollectionEquality().hash(_agendaIds),
      const DeepCollectionEquality().hash(_options),
      const DeepCollectionEquality().hash(_publicInformations));

  @override
  String toString() {
    return 'MedicalLocation(id: $id, rev: $rev, deletionDate: $deletionDate, name: $name, description: $description, responsible: $responsible, guardPost: $guardPost, cbe: $cbe, bic: $bic, bankAccount: $bankAccount, nihii: $nihii, ssin: $ssin, address: $address, agendaIds: $agendaIds, options: $options, publicInformations: $publicInformations)';
  }
}

/// @nodoc
abstract mixin class _$MedicalLocationCopyWith<$Res>
    implements $MedicalLocationCopyWith<$Res> {
  factory _$MedicalLocationCopyWith(
          _MedicalLocation value, $Res Function(_MedicalLocation) _then) =
      __$MedicalLocationCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String id,
      String? rev,
      int? deletionDate,
      String? name,
      String? description,
      String? responsible,
      bool? guardPost,
      String? cbe,
      String? bic,
      String? bankAccount,
      String? nihii,
      String? ssin,
      DecryptedAddress? address,
      Set<String> agendaIds,
      Map<String, String> options,
      Map<String, String> publicInformations});

  @override
  $DecryptedAddressCopyWith<$Res>? get address;
}

/// @nodoc
class __$MedicalLocationCopyWithImpl<$Res>
    implements _$MedicalLocationCopyWith<$Res> {
  __$MedicalLocationCopyWithImpl(this._self, this._then);

  final _MedicalLocation _self;
  final $Res Function(_MedicalLocation) _then;

  /// Create a copy of MedicalLocation
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? deletionDate = freezed,
    Object? name = freezed,
    Object? description = freezed,
    Object? responsible = freezed,
    Object? guardPost = freezed,
    Object? cbe = freezed,
    Object? bic = freezed,
    Object? bankAccount = freezed,
    Object? nihii = freezed,
    Object? ssin = freezed,
    Object? address = freezed,
    Object? agendaIds = null,
    Object? options = null,
    Object? publicInformations = null,
  }) {
    return _then(_MedicalLocation(
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
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      description: freezed == description
          ? _self.description
          : description // ignore: cast_nullable_to_non_nullable
              as String?,
      responsible: freezed == responsible
          ? _self.responsible
          : responsible // ignore: cast_nullable_to_non_nullable
              as String?,
      guardPost: freezed == guardPost
          ? _self.guardPost
          : guardPost // ignore: cast_nullable_to_non_nullable
              as bool?,
      cbe: freezed == cbe
          ? _self.cbe
          : cbe // ignore: cast_nullable_to_non_nullable
              as String?,
      bic: freezed == bic
          ? _self.bic
          : bic // ignore: cast_nullable_to_non_nullable
              as String?,
      bankAccount: freezed == bankAccount
          ? _self.bankAccount
          : bankAccount // ignore: cast_nullable_to_non_nullable
              as String?,
      nihii: freezed == nihii
          ? _self.nihii
          : nihii // ignore: cast_nullable_to_non_nullable
              as String?,
      ssin: freezed == ssin
          ? _self.ssin
          : ssin // ignore: cast_nullable_to_non_nullable
              as String?,
      address: freezed == address
          ? _self.address
          : address // ignore: cast_nullable_to_non_nullable
              as DecryptedAddress?,
      agendaIds: null == agendaIds
          ? _self._agendaIds
          : agendaIds // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      options: null == options
          ? _self._options
          : options // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      publicInformations: null == publicInformations
          ? _self._publicInformations
          : publicInformations // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
    ));
  }

  /// Create a copy of MedicalLocation
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $DecryptedAddressCopyWith<$Res>? get address {
    if (_self.address == null) {
      return null;
    }

    return $DecryptedAddressCopyWith<$Res>(_self.address!, (value) {
      return _then(_self.copyWith(address: value));
    });
  }
}

// dart format on

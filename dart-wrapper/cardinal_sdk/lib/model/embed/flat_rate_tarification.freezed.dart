// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'flat_rate_tarification.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$EncryptedFlatRateTarification {
  String? get code;
  FlatRateType? get flatRateType;
  Map<String, String>? get label;
  List<EncryptedValorisation> get valorisations;
  Base64String? get encryptedSelf;

  /// Create a copy of EncryptedFlatRateTarification
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $EncryptedFlatRateTarificationCopyWith<EncryptedFlatRateTarification>
      get copyWith => _$EncryptedFlatRateTarificationCopyWithImpl<
              EncryptedFlatRateTarification>(
          this as EncryptedFlatRateTarification, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is EncryptedFlatRateTarification &&
            (identical(other.code, code) || other.code == code) &&
            (identical(other.flatRateType, flatRateType) ||
                other.flatRateType == flatRateType) &&
            const DeepCollectionEquality().equals(other.label, label) &&
            const DeepCollectionEquality()
                .equals(other.valorisations, valorisations) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      code,
      flatRateType,
      const DeepCollectionEquality().hash(label),
      const DeepCollectionEquality().hash(valorisations),
      encryptedSelf);

  @override
  String toString() {
    return 'EncryptedFlatRateTarification(code: $code, flatRateType: $flatRateType, label: $label, valorisations: $valorisations, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class $EncryptedFlatRateTarificationCopyWith<$Res> {
  factory $EncryptedFlatRateTarificationCopyWith(
          EncryptedFlatRateTarification value,
          $Res Function(EncryptedFlatRateTarification) _then) =
      _$EncryptedFlatRateTarificationCopyWithImpl;
  @useResult
  $Res call(
      {String? code,
      FlatRateType? flatRateType,
      Map<String, String>? label,
      List<EncryptedValorisation> valorisations,
      Base64String? encryptedSelf});
}

/// @nodoc
class _$EncryptedFlatRateTarificationCopyWithImpl<$Res>
    implements $EncryptedFlatRateTarificationCopyWith<$Res> {
  _$EncryptedFlatRateTarificationCopyWithImpl(this._self, this._then);

  final EncryptedFlatRateTarification _self;
  final $Res Function(EncryptedFlatRateTarification) _then;

  /// Create a copy of EncryptedFlatRateTarification
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? code = freezed,
    Object? flatRateType = freezed,
    Object? label = freezed,
    Object? valorisations = null,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_self.copyWith(
      code: freezed == code
          ? _self.code
          : code // ignore: cast_nullable_to_non_nullable
              as String?,
      flatRateType: freezed == flatRateType
          ? _self.flatRateType
          : flatRateType // ignore: cast_nullable_to_non_nullable
              as FlatRateType?,
      label: freezed == label
          ? _self.label
          : label // ignore: cast_nullable_to_non_nullable
              as Map<String, String>?,
      valorisations: null == valorisations
          ? _self.valorisations
          : valorisations // ignore: cast_nullable_to_non_nullable
              as List<EncryptedValorisation>,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc

class _EncryptedFlatRateTarification implements EncryptedFlatRateTarification {
  const _EncryptedFlatRateTarification(
      {this.code = null,
      this.flatRateType = null,
      final Map<String, String>? label = null,
      final List<EncryptedValorisation> valorisations = const [],
      this.encryptedSelf = null})
      : _label = label,
        _valorisations = valorisations;

  @override
  @JsonKey()
  final String? code;
  @override
  @JsonKey()
  final FlatRateType? flatRateType;
  final Map<String, String>? _label;
  @override
  @JsonKey()
  Map<String, String>? get label {
    final value = _label;
    if (value == null) return null;
    if (_label is EqualUnmodifiableMapView) return _label;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(value);
  }

  final List<EncryptedValorisation> _valorisations;
  @override
  @JsonKey()
  List<EncryptedValorisation> get valorisations {
    if (_valorisations is EqualUnmodifiableListView) return _valorisations;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_valorisations);
  }

  @override
  @JsonKey()
  final Base64String? encryptedSelf;

  /// Create a copy of EncryptedFlatRateTarification
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$EncryptedFlatRateTarificationCopyWith<_EncryptedFlatRateTarification>
      get copyWith => __$EncryptedFlatRateTarificationCopyWithImpl<
          _EncryptedFlatRateTarification>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _EncryptedFlatRateTarification &&
            (identical(other.code, code) || other.code == code) &&
            (identical(other.flatRateType, flatRateType) ||
                other.flatRateType == flatRateType) &&
            const DeepCollectionEquality().equals(other._label, _label) &&
            const DeepCollectionEquality()
                .equals(other._valorisations, _valorisations) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      code,
      flatRateType,
      const DeepCollectionEquality().hash(_label),
      const DeepCollectionEquality().hash(_valorisations),
      encryptedSelf);

  @override
  String toString() {
    return 'EncryptedFlatRateTarification(code: $code, flatRateType: $flatRateType, label: $label, valorisations: $valorisations, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class _$EncryptedFlatRateTarificationCopyWith<$Res>
    implements $EncryptedFlatRateTarificationCopyWith<$Res> {
  factory _$EncryptedFlatRateTarificationCopyWith(
          _EncryptedFlatRateTarification value,
          $Res Function(_EncryptedFlatRateTarification) _then) =
      __$EncryptedFlatRateTarificationCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String? code,
      FlatRateType? flatRateType,
      Map<String, String>? label,
      List<EncryptedValorisation> valorisations,
      Base64String? encryptedSelf});
}

/// @nodoc
class __$EncryptedFlatRateTarificationCopyWithImpl<$Res>
    implements _$EncryptedFlatRateTarificationCopyWith<$Res> {
  __$EncryptedFlatRateTarificationCopyWithImpl(this._self, this._then);

  final _EncryptedFlatRateTarification _self;
  final $Res Function(_EncryptedFlatRateTarification) _then;

  /// Create a copy of EncryptedFlatRateTarification
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? code = freezed,
    Object? flatRateType = freezed,
    Object? label = freezed,
    Object? valorisations = null,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_EncryptedFlatRateTarification(
      code: freezed == code
          ? _self.code
          : code // ignore: cast_nullable_to_non_nullable
              as String?,
      flatRateType: freezed == flatRateType
          ? _self.flatRateType
          : flatRateType // ignore: cast_nullable_to_non_nullable
              as FlatRateType?,
      label: freezed == label
          ? _self._label
          : label // ignore: cast_nullable_to_non_nullable
              as Map<String, String>?,
      valorisations: null == valorisations
          ? _self._valorisations
          : valorisations // ignore: cast_nullable_to_non_nullable
              as List<EncryptedValorisation>,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc
mixin _$DecryptedFlatRateTarification {
  String? get code;
  FlatRateType? get flatRateType;
  Map<String, String>? get label;
  List<DecryptedValorisation> get valorisations;
  Base64String? get encryptedSelf;

  /// Create a copy of DecryptedFlatRateTarification
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DecryptedFlatRateTarificationCopyWith<DecryptedFlatRateTarification>
      get copyWith => _$DecryptedFlatRateTarificationCopyWithImpl<
              DecryptedFlatRateTarification>(
          this as DecryptedFlatRateTarification, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is DecryptedFlatRateTarification &&
            (identical(other.code, code) || other.code == code) &&
            (identical(other.flatRateType, flatRateType) ||
                other.flatRateType == flatRateType) &&
            const DeepCollectionEquality().equals(other.label, label) &&
            const DeepCollectionEquality()
                .equals(other.valorisations, valorisations) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      code,
      flatRateType,
      const DeepCollectionEquality().hash(label),
      const DeepCollectionEquality().hash(valorisations),
      encryptedSelf);

  @override
  String toString() {
    return 'DecryptedFlatRateTarification(code: $code, flatRateType: $flatRateType, label: $label, valorisations: $valorisations, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class $DecryptedFlatRateTarificationCopyWith<$Res> {
  factory $DecryptedFlatRateTarificationCopyWith(
          DecryptedFlatRateTarification value,
          $Res Function(DecryptedFlatRateTarification) _then) =
      _$DecryptedFlatRateTarificationCopyWithImpl;
  @useResult
  $Res call(
      {String? code,
      FlatRateType? flatRateType,
      Map<String, String>? label,
      List<DecryptedValorisation> valorisations,
      Base64String? encryptedSelf});
}

/// @nodoc
class _$DecryptedFlatRateTarificationCopyWithImpl<$Res>
    implements $DecryptedFlatRateTarificationCopyWith<$Res> {
  _$DecryptedFlatRateTarificationCopyWithImpl(this._self, this._then);

  final DecryptedFlatRateTarification _self;
  final $Res Function(DecryptedFlatRateTarification) _then;

  /// Create a copy of DecryptedFlatRateTarification
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? code = freezed,
    Object? flatRateType = freezed,
    Object? label = freezed,
    Object? valorisations = null,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_self.copyWith(
      code: freezed == code
          ? _self.code
          : code // ignore: cast_nullable_to_non_nullable
              as String?,
      flatRateType: freezed == flatRateType
          ? _self.flatRateType
          : flatRateType // ignore: cast_nullable_to_non_nullable
              as FlatRateType?,
      label: freezed == label
          ? _self.label
          : label // ignore: cast_nullable_to_non_nullable
              as Map<String, String>?,
      valorisations: null == valorisations
          ? _self.valorisations
          : valorisations // ignore: cast_nullable_to_non_nullable
              as List<DecryptedValorisation>,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc

class _DecryptedFlatRateTarification implements DecryptedFlatRateTarification {
  const _DecryptedFlatRateTarification(
      {this.code = null,
      this.flatRateType = null,
      final Map<String, String>? label = null,
      final List<DecryptedValorisation> valorisations = const [],
      this.encryptedSelf = null})
      : _label = label,
        _valorisations = valorisations;

  @override
  @JsonKey()
  final String? code;
  @override
  @JsonKey()
  final FlatRateType? flatRateType;
  final Map<String, String>? _label;
  @override
  @JsonKey()
  Map<String, String>? get label {
    final value = _label;
    if (value == null) return null;
    if (_label is EqualUnmodifiableMapView) return _label;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(value);
  }

  final List<DecryptedValorisation> _valorisations;
  @override
  @JsonKey()
  List<DecryptedValorisation> get valorisations {
    if (_valorisations is EqualUnmodifiableListView) return _valorisations;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_valorisations);
  }

  @override
  @JsonKey()
  final Base64String? encryptedSelf;

  /// Create a copy of DecryptedFlatRateTarification
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DecryptedFlatRateTarificationCopyWith<_DecryptedFlatRateTarification>
      get copyWith => __$DecryptedFlatRateTarificationCopyWithImpl<
          _DecryptedFlatRateTarification>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _DecryptedFlatRateTarification &&
            (identical(other.code, code) || other.code == code) &&
            (identical(other.flatRateType, flatRateType) ||
                other.flatRateType == flatRateType) &&
            const DeepCollectionEquality().equals(other._label, _label) &&
            const DeepCollectionEquality()
                .equals(other._valorisations, _valorisations) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      code,
      flatRateType,
      const DeepCollectionEquality().hash(_label),
      const DeepCollectionEquality().hash(_valorisations),
      encryptedSelf);

  @override
  String toString() {
    return 'DecryptedFlatRateTarification(code: $code, flatRateType: $flatRateType, label: $label, valorisations: $valorisations, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class _$DecryptedFlatRateTarificationCopyWith<$Res>
    implements $DecryptedFlatRateTarificationCopyWith<$Res> {
  factory _$DecryptedFlatRateTarificationCopyWith(
          _DecryptedFlatRateTarification value,
          $Res Function(_DecryptedFlatRateTarification) _then) =
      __$DecryptedFlatRateTarificationCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String? code,
      FlatRateType? flatRateType,
      Map<String, String>? label,
      List<DecryptedValorisation> valorisations,
      Base64String? encryptedSelf});
}

/// @nodoc
class __$DecryptedFlatRateTarificationCopyWithImpl<$Res>
    implements _$DecryptedFlatRateTarificationCopyWith<$Res> {
  __$DecryptedFlatRateTarificationCopyWithImpl(this._self, this._then);

  final _DecryptedFlatRateTarification _self;
  final $Res Function(_DecryptedFlatRateTarification) _then;

  /// Create a copy of DecryptedFlatRateTarification
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? code = freezed,
    Object? flatRateType = freezed,
    Object? label = freezed,
    Object? valorisations = null,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_DecryptedFlatRateTarification(
      code: freezed == code
          ? _self.code
          : code // ignore: cast_nullable_to_non_nullable
              as String?,
      flatRateType: freezed == flatRateType
          ? _self.flatRateType
          : flatRateType // ignore: cast_nullable_to_non_nullable
              as FlatRateType?,
      label: freezed == label
          ? _self._label
          : label // ignore: cast_nullable_to_non_nullable
              as Map<String, String>?,
      valorisations: null == valorisations
          ? _self._valorisations
          : valorisations // ignore: cast_nullable_to_non_nullable
              as List<DecryptedValorisation>,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

// dart format on

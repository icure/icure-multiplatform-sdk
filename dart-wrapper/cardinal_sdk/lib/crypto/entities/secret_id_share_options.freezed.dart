// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'secret_id_share_options.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$SecretIdShareOptionsAllAvailable {
  bool get requireAtLeastOne;

  /// Create a copy of SecretIdShareOptionsAllAvailable
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $SecretIdShareOptionsAllAvailableCopyWith<SecretIdShareOptionsAllAvailable>
      get copyWith => _$SecretIdShareOptionsAllAvailableCopyWithImpl<
              SecretIdShareOptionsAllAvailable>(
          this as SecretIdShareOptionsAllAvailable, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is SecretIdShareOptionsAllAvailable &&
            (identical(other.requireAtLeastOne, requireAtLeastOne) ||
                other.requireAtLeastOne == requireAtLeastOne));
  }

  @override
  int get hashCode => Object.hash(runtimeType, requireAtLeastOne);

  @override
  String toString() {
    return 'SecretIdShareOptionsAllAvailable(requireAtLeastOne: $requireAtLeastOne)';
  }
}

/// @nodoc
abstract mixin class $SecretIdShareOptionsAllAvailableCopyWith<$Res> {
  factory $SecretIdShareOptionsAllAvailableCopyWith(
          SecretIdShareOptionsAllAvailable value,
          $Res Function(SecretIdShareOptionsAllAvailable) _then) =
      _$SecretIdShareOptionsAllAvailableCopyWithImpl;
  @useResult
  $Res call({bool requireAtLeastOne});
}

/// @nodoc
class _$SecretIdShareOptionsAllAvailableCopyWithImpl<$Res>
    implements $SecretIdShareOptionsAllAvailableCopyWith<$Res> {
  _$SecretIdShareOptionsAllAvailableCopyWithImpl(this._self, this._then);

  final SecretIdShareOptionsAllAvailable _self;
  final $Res Function(SecretIdShareOptionsAllAvailable) _then;

  /// Create a copy of SecretIdShareOptionsAllAvailable
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? requireAtLeastOne = null,
  }) {
    return _then(_self.copyWith(
      requireAtLeastOne: null == requireAtLeastOne
          ? _self.requireAtLeastOne
          : requireAtLeastOne // ignore: cast_nullable_to_non_nullable
              as bool,
    ));
  }
}

/// @nodoc

class _SecretIdShareOptionsAllAvailable
    implements SecretIdShareOptionsAllAvailable {
  const _SecretIdShareOptionsAllAvailable({this.requireAtLeastOne = false});

  @override
  @JsonKey()
  final bool requireAtLeastOne;

  /// Create a copy of SecretIdShareOptionsAllAvailable
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$SecretIdShareOptionsAllAvailableCopyWith<_SecretIdShareOptionsAllAvailable>
      get copyWith => __$SecretIdShareOptionsAllAvailableCopyWithImpl<
          _SecretIdShareOptionsAllAvailable>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _SecretIdShareOptionsAllAvailable &&
            (identical(other.requireAtLeastOne, requireAtLeastOne) ||
                other.requireAtLeastOne == requireAtLeastOne));
  }

  @override
  int get hashCode => Object.hash(runtimeType, requireAtLeastOne);

  @override
  String toString() {
    return 'SecretIdShareOptionsAllAvailable(requireAtLeastOne: $requireAtLeastOne)';
  }
}

/// @nodoc
abstract mixin class _$SecretIdShareOptionsAllAvailableCopyWith<$Res>
    implements $SecretIdShareOptionsAllAvailableCopyWith<$Res> {
  factory _$SecretIdShareOptionsAllAvailableCopyWith(
          _SecretIdShareOptionsAllAvailable value,
          $Res Function(_SecretIdShareOptionsAllAvailable) _then) =
      __$SecretIdShareOptionsAllAvailableCopyWithImpl;
  @override
  @useResult
  $Res call({bool requireAtLeastOne});
}

/// @nodoc
class __$SecretIdShareOptionsAllAvailableCopyWithImpl<$Res>
    implements _$SecretIdShareOptionsAllAvailableCopyWith<$Res> {
  __$SecretIdShareOptionsAllAvailableCopyWithImpl(this._self, this._then);

  final _SecretIdShareOptionsAllAvailable _self;
  final $Res Function(_SecretIdShareOptionsAllAvailable) _then;

  /// Create a copy of SecretIdShareOptionsAllAvailable
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? requireAtLeastOne = null,
  }) {
    return _then(_SecretIdShareOptionsAllAvailable(
      requireAtLeastOne: null == requireAtLeastOne
          ? _self.requireAtLeastOne
          : requireAtLeastOne // ignore: cast_nullable_to_non_nullable
              as bool,
    ));
  }
}

/// @nodoc
mixin _$SecretIdShareOptionsUseExactly {
  Set<String> get secretIds;
  bool get createUnknownSecretIds;

  /// Create a copy of SecretIdShareOptionsUseExactly
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $SecretIdShareOptionsUseExactlyCopyWith<SecretIdShareOptionsUseExactly>
      get copyWith => _$SecretIdShareOptionsUseExactlyCopyWithImpl<
              SecretIdShareOptionsUseExactly>(
          this as SecretIdShareOptionsUseExactly, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is SecretIdShareOptionsUseExactly &&
            const DeepCollectionEquality().equals(other.secretIds, secretIds) &&
            (identical(other.createUnknownSecretIds, createUnknownSecretIds) ||
                other.createUnknownSecretIds == createUnknownSecretIds));
  }

  @override
  int get hashCode => Object.hash(runtimeType,
      const DeepCollectionEquality().hash(secretIds), createUnknownSecretIds);

  @override
  String toString() {
    return 'SecretIdShareOptionsUseExactly(secretIds: $secretIds, createUnknownSecretIds: $createUnknownSecretIds)';
  }
}

/// @nodoc
abstract mixin class $SecretIdShareOptionsUseExactlyCopyWith<$Res> {
  factory $SecretIdShareOptionsUseExactlyCopyWith(
          SecretIdShareOptionsUseExactly value,
          $Res Function(SecretIdShareOptionsUseExactly) _then) =
      _$SecretIdShareOptionsUseExactlyCopyWithImpl;
  @useResult
  $Res call({Set<String> secretIds, bool createUnknownSecretIds});
}

/// @nodoc
class _$SecretIdShareOptionsUseExactlyCopyWithImpl<$Res>
    implements $SecretIdShareOptionsUseExactlyCopyWith<$Res> {
  _$SecretIdShareOptionsUseExactlyCopyWithImpl(this._self, this._then);

  final SecretIdShareOptionsUseExactly _self;
  final $Res Function(SecretIdShareOptionsUseExactly) _then;

  /// Create a copy of SecretIdShareOptionsUseExactly
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? secretIds = null,
    Object? createUnknownSecretIds = null,
  }) {
    return _then(_self.copyWith(
      secretIds: null == secretIds
          ? _self.secretIds
          : secretIds // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      createUnknownSecretIds: null == createUnknownSecretIds
          ? _self.createUnknownSecretIds
          : createUnknownSecretIds // ignore: cast_nullable_to_non_nullable
              as bool,
    ));
  }
}

/// @nodoc

class _SecretIdShareOptionsUseExactly
    implements SecretIdShareOptionsUseExactly {
  const _SecretIdShareOptionsUseExactly(
      {required final Set<String> secretIds,
      required this.createUnknownSecretIds})
      : _secretIds = secretIds;

  final Set<String> _secretIds;
  @override
  Set<String> get secretIds {
    if (_secretIds is EqualUnmodifiableSetView) return _secretIds;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_secretIds);
  }

  @override
  final bool createUnknownSecretIds;

  /// Create a copy of SecretIdShareOptionsUseExactly
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$SecretIdShareOptionsUseExactlyCopyWith<_SecretIdShareOptionsUseExactly>
      get copyWith => __$SecretIdShareOptionsUseExactlyCopyWithImpl<
          _SecretIdShareOptionsUseExactly>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _SecretIdShareOptionsUseExactly &&
            const DeepCollectionEquality()
                .equals(other._secretIds, _secretIds) &&
            (identical(other.createUnknownSecretIds, createUnknownSecretIds) ||
                other.createUnknownSecretIds == createUnknownSecretIds));
  }

  @override
  int get hashCode => Object.hash(runtimeType,
      const DeepCollectionEquality().hash(_secretIds), createUnknownSecretIds);

  @override
  String toString() {
    return 'SecretIdShareOptionsUseExactly(secretIds: $secretIds, createUnknownSecretIds: $createUnknownSecretIds)';
  }
}

/// @nodoc
abstract mixin class _$SecretIdShareOptionsUseExactlyCopyWith<$Res>
    implements $SecretIdShareOptionsUseExactlyCopyWith<$Res> {
  factory _$SecretIdShareOptionsUseExactlyCopyWith(
          _SecretIdShareOptionsUseExactly value,
          $Res Function(_SecretIdShareOptionsUseExactly) _then) =
      __$SecretIdShareOptionsUseExactlyCopyWithImpl;
  @override
  @useResult
  $Res call({Set<String> secretIds, bool createUnknownSecretIds});
}

/// @nodoc
class __$SecretIdShareOptionsUseExactlyCopyWithImpl<$Res>
    implements _$SecretIdShareOptionsUseExactlyCopyWith<$Res> {
  __$SecretIdShareOptionsUseExactlyCopyWithImpl(this._self, this._then);

  final _SecretIdShareOptionsUseExactly _self;
  final $Res Function(_SecretIdShareOptionsUseExactly) _then;

  /// Create a copy of SecretIdShareOptionsUseExactly
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? secretIds = null,
    Object? createUnknownSecretIds = null,
  }) {
    return _then(_SecretIdShareOptionsUseExactly(
      secretIds: null == secretIds
          ? _self._secretIds
          : secretIds // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      createUnknownSecretIds: null == createUnknownSecretIds
          ? _self.createUnknownSecretIds
          : createUnknownSecretIds // ignore: cast_nullable_to_non_nullable
              as bool,
    ));
  }
}

// dart format on

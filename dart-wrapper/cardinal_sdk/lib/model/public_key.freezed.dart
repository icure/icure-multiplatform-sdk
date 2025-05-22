// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'public_key.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$PublicKey {
  String? get hcPartyId;
  String? get hexString;

  /// Create a copy of PublicKey
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $PublicKeyCopyWith<PublicKey> get copyWith =>
      _$PublicKeyCopyWithImpl<PublicKey>(this as PublicKey, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is PublicKey &&
            (identical(other.hcPartyId, hcPartyId) ||
                other.hcPartyId == hcPartyId) &&
            (identical(other.hexString, hexString) ||
                other.hexString == hexString));
  }

  @override
  int get hashCode => Object.hash(runtimeType, hcPartyId, hexString);

  @override
  String toString() {
    return 'PublicKey(hcPartyId: $hcPartyId, hexString: $hexString)';
  }
}

/// @nodoc
abstract mixin class $PublicKeyCopyWith<$Res> {
  factory $PublicKeyCopyWith(PublicKey value, $Res Function(PublicKey) _then) =
      _$PublicKeyCopyWithImpl;
  @useResult
  $Res call({String? hcPartyId, String? hexString});
}

/// @nodoc
class _$PublicKeyCopyWithImpl<$Res> implements $PublicKeyCopyWith<$Res> {
  _$PublicKeyCopyWithImpl(this._self, this._then);

  final PublicKey _self;
  final $Res Function(PublicKey) _then;

  /// Create a copy of PublicKey
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? hcPartyId = freezed,
    Object? hexString = freezed,
  }) {
    return _then(_self.copyWith(
      hcPartyId: freezed == hcPartyId
          ? _self.hcPartyId
          : hcPartyId // ignore: cast_nullable_to_non_nullable
              as String?,
      hexString: freezed == hexString
          ? _self.hexString
          : hexString // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

/// @nodoc

class _PublicKey implements PublicKey {
  const _PublicKey({this.hcPartyId = null, this.hexString = null});

  @override
  @JsonKey()
  final String? hcPartyId;
  @override
  @JsonKey()
  final String? hexString;

  /// Create a copy of PublicKey
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$PublicKeyCopyWith<_PublicKey> get copyWith =>
      __$PublicKeyCopyWithImpl<_PublicKey>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _PublicKey &&
            (identical(other.hcPartyId, hcPartyId) ||
                other.hcPartyId == hcPartyId) &&
            (identical(other.hexString, hexString) ||
                other.hexString == hexString));
  }

  @override
  int get hashCode => Object.hash(runtimeType, hcPartyId, hexString);

  @override
  String toString() {
    return 'PublicKey(hcPartyId: $hcPartyId, hexString: $hexString)';
  }
}

/// @nodoc
abstract mixin class _$PublicKeyCopyWith<$Res>
    implements $PublicKeyCopyWith<$Res> {
  factory _$PublicKeyCopyWith(
          _PublicKey value, $Res Function(_PublicKey) _then) =
      __$PublicKeyCopyWithImpl;
  @override
  @useResult
  $Res call({String? hcPartyId, String? hexString});
}

/// @nodoc
class __$PublicKeyCopyWithImpl<$Res> implements _$PublicKeyCopyWith<$Res> {
  __$PublicKeyCopyWithImpl(this._self, this._then);

  final _PublicKey _self;
  final $Res Function(_PublicKey) _then;

  /// Create a copy of PublicKey
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? hcPartyId = freezed,
    Object? hexString = freezed,
  }) {
    return _then(_PublicKey(
      hcPartyId: freezed == hcPartyId
          ? _self.hcPartyId
          : hcPartyId // ignore: cast_nullable_to_non_nullable
              as String?,
      hexString: freezed == hexString
          ? _self.hexString
          : hexString // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

// dart format on

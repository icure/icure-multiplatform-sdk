// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'crypto_actor_stub_with_type.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$CryptoActorStubWithType {
  DataOwnerType get type;
  CryptoActorStub get stub;

  /// Create a copy of CryptoActorStubWithType
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $CryptoActorStubWithTypeCopyWith<CryptoActorStubWithType> get copyWith =>
      _$CryptoActorStubWithTypeCopyWithImpl<CryptoActorStubWithType>(
          this as CryptoActorStubWithType, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is CryptoActorStubWithType &&
            (identical(other.type, type) || other.type == type) &&
            (identical(other.stub, stub) || other.stub == stub));
  }

  @override
  int get hashCode => Object.hash(runtimeType, type, stub);

  @override
  String toString() {
    return 'CryptoActorStubWithType(type: $type, stub: $stub)';
  }
}

/// @nodoc
abstract mixin class $CryptoActorStubWithTypeCopyWith<$Res> {
  factory $CryptoActorStubWithTypeCopyWith(CryptoActorStubWithType value,
          $Res Function(CryptoActorStubWithType) _then) =
      _$CryptoActorStubWithTypeCopyWithImpl;
  @useResult
  $Res call({DataOwnerType type, CryptoActorStub stub});

  $CryptoActorStubCopyWith<$Res> get stub;
}

/// @nodoc
class _$CryptoActorStubWithTypeCopyWithImpl<$Res>
    implements $CryptoActorStubWithTypeCopyWith<$Res> {
  _$CryptoActorStubWithTypeCopyWithImpl(this._self, this._then);

  final CryptoActorStubWithType _self;
  final $Res Function(CryptoActorStubWithType) _then;

  /// Create a copy of CryptoActorStubWithType
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? type = null,
    Object? stub = null,
  }) {
    return _then(_self.copyWith(
      type: null == type
          ? _self.type
          : type // ignore: cast_nullable_to_non_nullable
              as DataOwnerType,
      stub: null == stub
          ? _self.stub
          : stub // ignore: cast_nullable_to_non_nullable
              as CryptoActorStub,
    ));
  }

  /// Create a copy of CryptoActorStubWithType
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CryptoActorStubCopyWith<$Res> get stub {
    return $CryptoActorStubCopyWith<$Res>(_self.stub, (value) {
      return _then(_self.copyWith(stub: value));
    });
  }
}

/// @nodoc

class _CryptoActorStubWithType implements CryptoActorStubWithType {
  const _CryptoActorStubWithType({required this.type, required this.stub});

  @override
  final DataOwnerType type;
  @override
  final CryptoActorStub stub;

  /// Create a copy of CryptoActorStubWithType
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$CryptoActorStubWithTypeCopyWith<_CryptoActorStubWithType> get copyWith =>
      __$CryptoActorStubWithTypeCopyWithImpl<_CryptoActorStubWithType>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _CryptoActorStubWithType &&
            (identical(other.type, type) || other.type == type) &&
            (identical(other.stub, stub) || other.stub == stub));
  }

  @override
  int get hashCode => Object.hash(runtimeType, type, stub);

  @override
  String toString() {
    return 'CryptoActorStubWithType(type: $type, stub: $stub)';
  }
}

/// @nodoc
abstract mixin class _$CryptoActorStubWithTypeCopyWith<$Res>
    implements $CryptoActorStubWithTypeCopyWith<$Res> {
  factory _$CryptoActorStubWithTypeCopyWith(_CryptoActorStubWithType value,
          $Res Function(_CryptoActorStubWithType) _then) =
      __$CryptoActorStubWithTypeCopyWithImpl;
  @override
  @useResult
  $Res call({DataOwnerType type, CryptoActorStub stub});

  @override
  $CryptoActorStubCopyWith<$Res> get stub;
}

/// @nodoc
class __$CryptoActorStubWithTypeCopyWithImpl<$Res>
    implements _$CryptoActorStubWithTypeCopyWith<$Res> {
  __$CryptoActorStubWithTypeCopyWithImpl(this._self, this._then);

  final _CryptoActorStubWithType _self;
  final $Res Function(_CryptoActorStubWithType) _then;

  /// Create a copy of CryptoActorStubWithType
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? type = null,
    Object? stub = null,
  }) {
    return _then(_CryptoActorStubWithType(
      type: null == type
          ? _self.type
          : type // ignore: cast_nullable_to_non_nullable
              as DataOwnerType,
      stub: null == stub
          ? _self.stub
          : stub // ignore: cast_nullable_to_non_nullable
              as CryptoActorStub,
    ));
  }

  /// Create a copy of CryptoActorStubWithType
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CryptoActorStubCopyWith<$Res> get stub {
    return $CryptoActorStubCopyWith<$Res>(_self.stub, (value) {
      return _then(_self.copyWith(stub: value));
    });
  }
}

// dart format on

// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'operation_token.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$OperationToken {
  String get tokenHash;
  int get creationTime;
  int get validity;
  Operation get operation;
  String? get description;

  /// Create a copy of OperationToken
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $OperationTokenCopyWith<OperationToken> get copyWith =>
      _$OperationTokenCopyWithImpl<OperationToken>(
          this as OperationToken, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is OperationToken &&
            (identical(other.tokenHash, tokenHash) ||
                other.tokenHash == tokenHash) &&
            (identical(other.creationTime, creationTime) ||
                other.creationTime == creationTime) &&
            (identical(other.validity, validity) ||
                other.validity == validity) &&
            (identical(other.operation, operation) ||
                other.operation == operation) &&
            (identical(other.description, description) ||
                other.description == description));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, tokenHash, creationTime, validity, operation, description);

  @override
  String toString() {
    return 'OperationToken(tokenHash: $tokenHash, creationTime: $creationTime, validity: $validity, operation: $operation, description: $description)';
  }
}

/// @nodoc
abstract mixin class $OperationTokenCopyWith<$Res> {
  factory $OperationTokenCopyWith(
          OperationToken value, $Res Function(OperationToken) _then) =
      _$OperationTokenCopyWithImpl;
  @useResult
  $Res call(
      {String tokenHash,
      int creationTime,
      int validity,
      Operation operation,
      String? description});
}

/// @nodoc
class _$OperationTokenCopyWithImpl<$Res>
    implements $OperationTokenCopyWith<$Res> {
  _$OperationTokenCopyWithImpl(this._self, this._then);

  final OperationToken _self;
  final $Res Function(OperationToken) _then;

  /// Create a copy of OperationToken
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? tokenHash = null,
    Object? creationTime = null,
    Object? validity = null,
    Object? operation = null,
    Object? description = freezed,
  }) {
    return _then(_self.copyWith(
      tokenHash: null == tokenHash
          ? _self.tokenHash
          : tokenHash // ignore: cast_nullable_to_non_nullable
              as String,
      creationTime: null == creationTime
          ? _self.creationTime
          : creationTime // ignore: cast_nullable_to_non_nullable
              as int,
      validity: null == validity
          ? _self.validity
          : validity // ignore: cast_nullable_to_non_nullable
              as int,
      operation: null == operation
          ? _self.operation
          : operation // ignore: cast_nullable_to_non_nullable
              as Operation,
      description: freezed == description
          ? _self.description
          : description // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

/// @nodoc

class _OperationToken implements OperationToken {
  const _OperationToken(
      {required this.tokenHash,
      required this.creationTime,
      required this.validity,
      required this.operation,
      this.description = null});

  @override
  final String tokenHash;
  @override
  final int creationTime;
  @override
  final int validity;
  @override
  final Operation operation;
  @override
  @JsonKey()
  final String? description;

  /// Create a copy of OperationToken
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$OperationTokenCopyWith<_OperationToken> get copyWith =>
      __$OperationTokenCopyWithImpl<_OperationToken>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _OperationToken &&
            (identical(other.tokenHash, tokenHash) ||
                other.tokenHash == tokenHash) &&
            (identical(other.creationTime, creationTime) ||
                other.creationTime == creationTime) &&
            (identical(other.validity, validity) ||
                other.validity == validity) &&
            (identical(other.operation, operation) ||
                other.operation == operation) &&
            (identical(other.description, description) ||
                other.description == description));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, tokenHash, creationTime, validity, operation, description);

  @override
  String toString() {
    return 'OperationToken(tokenHash: $tokenHash, creationTime: $creationTime, validity: $validity, operation: $operation, description: $description)';
  }
}

/// @nodoc
abstract mixin class _$OperationTokenCopyWith<$Res>
    implements $OperationTokenCopyWith<$Res> {
  factory _$OperationTokenCopyWith(
          _OperationToken value, $Res Function(_OperationToken) _then) =
      __$OperationTokenCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String tokenHash,
      int creationTime,
      int validity,
      Operation operation,
      String? description});
}

/// @nodoc
class __$OperationTokenCopyWithImpl<$Res>
    implements _$OperationTokenCopyWith<$Res> {
  __$OperationTokenCopyWithImpl(this._self, this._then);

  final _OperationToken _self;
  final $Res Function(_OperationToken) _then;

  /// Create a copy of OperationToken
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? tokenHash = null,
    Object? creationTime = null,
    Object? validity = null,
    Object? operation = null,
    Object? description = freezed,
  }) {
    return _then(_OperationToken(
      tokenHash: null == tokenHash
          ? _self.tokenHash
          : tokenHash // ignore: cast_nullable_to_non_nullable
              as String,
      creationTime: null == creationTime
          ? _self.creationTime
          : creationTime // ignore: cast_nullable_to_non_nullable
              as int,
      validity: null == validity
          ? _self.validity
          : validity // ignore: cast_nullable_to_non_nullable
              as int,
      operation: null == operation
          ? _self.operation
          : operation // ignore: cast_nullable_to_non_nullable
              as Operation,
      description: freezed == description
          ? _self.description
          : description // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

// dart format on

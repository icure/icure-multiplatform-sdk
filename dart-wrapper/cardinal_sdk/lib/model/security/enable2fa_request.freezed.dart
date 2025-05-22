// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'enable2fa_request.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$Enable2faRequest {
  String get secret;
  int get otpLength;

  /// Create a copy of Enable2faRequest
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $Enable2faRequestCopyWith<Enable2faRequest> get copyWith =>
      _$Enable2faRequestCopyWithImpl<Enable2faRequest>(
          this as Enable2faRequest, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is Enable2faRequest &&
            (identical(other.secret, secret) || other.secret == secret) &&
            (identical(other.otpLength, otpLength) ||
                other.otpLength == otpLength));
  }

  @override
  int get hashCode => Object.hash(runtimeType, secret, otpLength);

  @override
  String toString() {
    return 'Enable2faRequest(secret: $secret, otpLength: $otpLength)';
  }
}

/// @nodoc
abstract mixin class $Enable2faRequestCopyWith<$Res> {
  factory $Enable2faRequestCopyWith(
          Enable2faRequest value, $Res Function(Enable2faRequest) _then) =
      _$Enable2faRequestCopyWithImpl;
  @useResult
  $Res call({String secret, int otpLength});
}

/// @nodoc
class _$Enable2faRequestCopyWithImpl<$Res>
    implements $Enable2faRequestCopyWith<$Res> {
  _$Enable2faRequestCopyWithImpl(this._self, this._then);

  final Enable2faRequest _self;
  final $Res Function(Enable2faRequest) _then;

  /// Create a copy of Enable2faRequest
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? secret = null,
    Object? otpLength = null,
  }) {
    return _then(_self.copyWith(
      secret: null == secret
          ? _self.secret
          : secret // ignore: cast_nullable_to_non_nullable
              as String,
      otpLength: null == otpLength
          ? _self.otpLength
          : otpLength // ignore: cast_nullable_to_non_nullable
              as int,
    ));
  }
}

/// @nodoc

class _Enable2faRequest implements Enable2faRequest {
  const _Enable2faRequest({required this.secret, required this.otpLength});

  @override
  final String secret;
  @override
  final int otpLength;

  /// Create a copy of Enable2faRequest
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$Enable2faRequestCopyWith<_Enable2faRequest> get copyWith =>
      __$Enable2faRequestCopyWithImpl<_Enable2faRequest>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _Enable2faRequest &&
            (identical(other.secret, secret) || other.secret == secret) &&
            (identical(other.otpLength, otpLength) ||
                other.otpLength == otpLength));
  }

  @override
  int get hashCode => Object.hash(runtimeType, secret, otpLength);

  @override
  String toString() {
    return 'Enable2faRequest(secret: $secret, otpLength: $otpLength)';
  }
}

/// @nodoc
abstract mixin class _$Enable2faRequestCopyWith<$Res>
    implements $Enable2faRequestCopyWith<$Res> {
  factory _$Enable2faRequestCopyWith(
          _Enable2faRequest value, $Res Function(_Enable2faRequest) _then) =
      __$Enable2faRequestCopyWithImpl;
  @override
  @useResult
  $Res call({String secret, int otpLength});
}

/// @nodoc
class __$Enable2faRequestCopyWithImpl<$Res>
    implements _$Enable2faRequestCopyWith<$Res> {
  __$Enable2faRequestCopyWithImpl(this._self, this._then);

  final _Enable2faRequest _self;
  final $Res Function(_Enable2faRequest) _then;

  /// Create a copy of Enable2faRequest
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? secret = null,
    Object? otpLength = null,
  }) {
    return _then(_Enable2faRequest(
      secret: null == secret
          ? _self.secret
          : secret // ignore: cast_nullable_to_non_nullable
              as String,
      otpLength: null == otpLength
          ? _self.otpLength
          : otpLength // ignore: cast_nullable_to_non_nullable
              as int,
    ));
  }
}

// dart format on

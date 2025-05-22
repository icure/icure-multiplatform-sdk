// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'boolean_response.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$BooleanResponse {
  bool get response;

  /// Create a copy of BooleanResponse
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $BooleanResponseCopyWith<BooleanResponse> get copyWith =>
      _$BooleanResponseCopyWithImpl<BooleanResponse>(
          this as BooleanResponse, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is BooleanResponse &&
            (identical(other.response, response) ||
                other.response == response));
  }

  @override
  int get hashCode => Object.hash(runtimeType, response);

  @override
  String toString() {
    return 'BooleanResponse(response: $response)';
  }
}

/// @nodoc
abstract mixin class $BooleanResponseCopyWith<$Res> {
  factory $BooleanResponseCopyWith(
          BooleanResponse value, $Res Function(BooleanResponse) _then) =
      _$BooleanResponseCopyWithImpl;
  @useResult
  $Res call({bool response});
}

/// @nodoc
class _$BooleanResponseCopyWithImpl<$Res>
    implements $BooleanResponseCopyWith<$Res> {
  _$BooleanResponseCopyWithImpl(this._self, this._then);

  final BooleanResponse _self;
  final $Res Function(BooleanResponse) _then;

  /// Create a copy of BooleanResponse
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? response = null,
  }) {
    return _then(_self.copyWith(
      response: null == response
          ? _self.response
          : response // ignore: cast_nullable_to_non_nullable
              as bool,
    ));
  }
}

/// @nodoc

class _BooleanResponse implements BooleanResponse {
  const _BooleanResponse({required this.response});

  @override
  final bool response;

  /// Create a copy of BooleanResponse
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$BooleanResponseCopyWith<_BooleanResponse> get copyWith =>
      __$BooleanResponseCopyWithImpl<_BooleanResponse>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _BooleanResponse &&
            (identical(other.response, response) ||
                other.response == response));
  }

  @override
  int get hashCode => Object.hash(runtimeType, response);

  @override
  String toString() {
    return 'BooleanResponse(response: $response)';
  }
}

/// @nodoc
abstract mixin class _$BooleanResponseCopyWith<$Res>
    implements $BooleanResponseCopyWith<$Res> {
  factory _$BooleanResponseCopyWith(
          _BooleanResponse value, $Res Function(_BooleanResponse) _then) =
      __$BooleanResponseCopyWithImpl;
  @override
  @useResult
  $Res call({bool response});
}

/// @nodoc
class __$BooleanResponseCopyWithImpl<$Res>
    implements _$BooleanResponseCopyWith<$Res> {
  __$BooleanResponseCopyWithImpl(this._self, this._then);

  final _BooleanResponse _self;
  final $Res Function(_BooleanResponse) _then;

  /// Create a copy of BooleanResponse
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? response = null,
  }) {
    return _then(_BooleanResponse(
      response: null == response
          ? _self.response
          : response // ignore: cast_nullable_to_non_nullable
              as bool,
    ));
  }
}

// dart format on

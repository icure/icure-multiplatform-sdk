// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'login_identifier.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$LoginIdentifier {
  String get assigner;
  String get value;

  /// Create a copy of LoginIdentifier
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $LoginIdentifierCopyWith<LoginIdentifier> get copyWith =>
      _$LoginIdentifierCopyWithImpl<LoginIdentifier>(
          this as LoginIdentifier, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is LoginIdentifier &&
            (identical(other.assigner, assigner) ||
                other.assigner == assigner) &&
            (identical(other.value, value) || other.value == value));
  }

  @override
  int get hashCode => Object.hash(runtimeType, assigner, value);

  @override
  String toString() {
    return 'LoginIdentifier(assigner: $assigner, value: $value)';
  }
}

/// @nodoc
abstract mixin class $LoginIdentifierCopyWith<$Res> {
  factory $LoginIdentifierCopyWith(
          LoginIdentifier value, $Res Function(LoginIdentifier) _then) =
      _$LoginIdentifierCopyWithImpl;
  @useResult
  $Res call({String assigner, String value});
}

/// @nodoc
class _$LoginIdentifierCopyWithImpl<$Res>
    implements $LoginIdentifierCopyWith<$Res> {
  _$LoginIdentifierCopyWithImpl(this._self, this._then);

  final LoginIdentifier _self;
  final $Res Function(LoginIdentifier) _then;

  /// Create a copy of LoginIdentifier
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? assigner = null,
    Object? value = null,
  }) {
    return _then(_self.copyWith(
      assigner: null == assigner
          ? _self.assigner
          : assigner // ignore: cast_nullable_to_non_nullable
              as String,
      value: null == value
          ? _self.value
          : value // ignore: cast_nullable_to_non_nullable
              as String,
    ));
  }
}

/// @nodoc

class _LoginIdentifier implements LoginIdentifier {
  const _LoginIdentifier({required this.assigner, required this.value});

  @override
  final String assigner;
  @override
  final String value;

  /// Create a copy of LoginIdentifier
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$LoginIdentifierCopyWith<_LoginIdentifier> get copyWith =>
      __$LoginIdentifierCopyWithImpl<_LoginIdentifier>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _LoginIdentifier &&
            (identical(other.assigner, assigner) ||
                other.assigner == assigner) &&
            (identical(other.value, value) || other.value == value));
  }

  @override
  int get hashCode => Object.hash(runtimeType, assigner, value);

  @override
  String toString() {
    return 'LoginIdentifier(assigner: $assigner, value: $value)';
  }
}

/// @nodoc
abstract mixin class _$LoginIdentifierCopyWith<$Res>
    implements $LoginIdentifierCopyWith<$Res> {
  factory _$LoginIdentifierCopyWith(
          _LoginIdentifier value, $Res Function(_LoginIdentifier) _then) =
      __$LoginIdentifierCopyWithImpl;
  @override
  @useResult
  $Res call({String assigner, String value});
}

/// @nodoc
class __$LoginIdentifierCopyWithImpl<$Res>
    implements _$LoginIdentifierCopyWith<$Res> {
  __$LoginIdentifierCopyWithImpl(this._self, this._then);

  final _LoginIdentifier _self;
  final $Res Function(_LoginIdentifier) _then;

  /// Create a copy of LoginIdentifier
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? assigner = null,
    Object? value = null,
  }) {
    return _then(_LoginIdentifier(
      assigner: null == assigner
          ? _self.assigner
          : assigner // ignore: cast_nullable_to_non_nullable
              as String,
      value: null == value
          ? _self.value
          : value // ignore: cast_nullable_to_non_nullable
              as String,
    ));
  }
}

// dart format on

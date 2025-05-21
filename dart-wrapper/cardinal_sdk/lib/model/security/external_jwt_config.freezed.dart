// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'external_jwt_config.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$ExternalJwtConfig {
  Base64String get publicKey;
  String? get id;
  String? get emailField;
  String? get loginField;
  String? get mobilePhoneField;
  IdentifierSelector? get identifierField;

  /// Create a copy of ExternalJwtConfig
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $ExternalJwtConfigCopyWith<ExternalJwtConfig> get copyWith =>
      _$ExternalJwtConfigCopyWithImpl<ExternalJwtConfig>(
          this as ExternalJwtConfig, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is ExternalJwtConfig &&
            (identical(other.publicKey, publicKey) ||
                other.publicKey == publicKey) &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.emailField, emailField) ||
                other.emailField == emailField) &&
            (identical(other.loginField, loginField) ||
                other.loginField == loginField) &&
            (identical(other.mobilePhoneField, mobilePhoneField) ||
                other.mobilePhoneField == mobilePhoneField) &&
            (identical(other.identifierField, identifierField) ||
                other.identifierField == identifierField));
  }

  @override
  int get hashCode => Object.hash(runtimeType, publicKey, id, emailField,
      loginField, mobilePhoneField, identifierField);

  @override
  String toString() {
    return 'ExternalJwtConfig(publicKey: $publicKey, id: $id, emailField: $emailField, loginField: $loginField, mobilePhoneField: $mobilePhoneField, identifierField: $identifierField)';
  }
}

/// @nodoc
abstract mixin class $ExternalJwtConfigCopyWith<$Res> {
  factory $ExternalJwtConfigCopyWith(
          ExternalJwtConfig value, $Res Function(ExternalJwtConfig) _then) =
      _$ExternalJwtConfigCopyWithImpl;
  @useResult
  $Res call(
      {Base64String publicKey,
      String? id,
      String? emailField,
      String? loginField,
      String? mobilePhoneField,
      IdentifierSelector? identifierField});

  $IdentifierSelectorCopyWith<$Res>? get identifierField;
}

/// @nodoc
class _$ExternalJwtConfigCopyWithImpl<$Res>
    implements $ExternalJwtConfigCopyWith<$Res> {
  _$ExternalJwtConfigCopyWithImpl(this._self, this._then);

  final ExternalJwtConfig _self;
  final $Res Function(ExternalJwtConfig) _then;

  /// Create a copy of ExternalJwtConfig
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? publicKey = null,
    Object? id = freezed,
    Object? emailField = freezed,
    Object? loginField = freezed,
    Object? mobilePhoneField = freezed,
    Object? identifierField = freezed,
  }) {
    return _then(_self.copyWith(
      publicKey: null == publicKey
          ? _self.publicKey
          : publicKey // ignore: cast_nullable_to_non_nullable
              as Base64String,
      id: freezed == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String?,
      emailField: freezed == emailField
          ? _self.emailField
          : emailField // ignore: cast_nullable_to_non_nullable
              as String?,
      loginField: freezed == loginField
          ? _self.loginField
          : loginField // ignore: cast_nullable_to_non_nullable
              as String?,
      mobilePhoneField: freezed == mobilePhoneField
          ? _self.mobilePhoneField
          : mobilePhoneField // ignore: cast_nullable_to_non_nullable
              as String?,
      identifierField: freezed == identifierField
          ? _self.identifierField
          : identifierField // ignore: cast_nullable_to_non_nullable
              as IdentifierSelector?,
    ));
  }

  /// Create a copy of ExternalJwtConfig
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $IdentifierSelectorCopyWith<$Res>? get identifierField {
    if (_self.identifierField == null) {
      return null;
    }

    return $IdentifierSelectorCopyWith<$Res>(_self.identifierField!, (value) {
      return _then(_self.copyWith(identifierField: value));
    });
  }
}

/// @nodoc

class _ExternalJwtConfig implements ExternalJwtConfig {
  const _ExternalJwtConfig(
      {required this.publicKey,
      this.id = null,
      this.emailField = null,
      this.loginField = null,
      this.mobilePhoneField = null,
      this.identifierField = null});

  @override
  final Base64String publicKey;
  @override
  @JsonKey()
  final String? id;
  @override
  @JsonKey()
  final String? emailField;
  @override
  @JsonKey()
  final String? loginField;
  @override
  @JsonKey()
  final String? mobilePhoneField;
  @override
  @JsonKey()
  final IdentifierSelector? identifierField;

  /// Create a copy of ExternalJwtConfig
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$ExternalJwtConfigCopyWith<_ExternalJwtConfig> get copyWith =>
      __$ExternalJwtConfigCopyWithImpl<_ExternalJwtConfig>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _ExternalJwtConfig &&
            (identical(other.publicKey, publicKey) ||
                other.publicKey == publicKey) &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.emailField, emailField) ||
                other.emailField == emailField) &&
            (identical(other.loginField, loginField) ||
                other.loginField == loginField) &&
            (identical(other.mobilePhoneField, mobilePhoneField) ||
                other.mobilePhoneField == mobilePhoneField) &&
            (identical(other.identifierField, identifierField) ||
                other.identifierField == identifierField));
  }

  @override
  int get hashCode => Object.hash(runtimeType, publicKey, id, emailField,
      loginField, mobilePhoneField, identifierField);

  @override
  String toString() {
    return 'ExternalJwtConfig(publicKey: $publicKey, id: $id, emailField: $emailField, loginField: $loginField, mobilePhoneField: $mobilePhoneField, identifierField: $identifierField)';
  }
}

/// @nodoc
abstract mixin class _$ExternalJwtConfigCopyWith<$Res>
    implements $ExternalJwtConfigCopyWith<$Res> {
  factory _$ExternalJwtConfigCopyWith(
          _ExternalJwtConfig value, $Res Function(_ExternalJwtConfig) _then) =
      __$ExternalJwtConfigCopyWithImpl;
  @override
  @useResult
  $Res call(
      {Base64String publicKey,
      String? id,
      String? emailField,
      String? loginField,
      String? mobilePhoneField,
      IdentifierSelector? identifierField});

  @override
  $IdentifierSelectorCopyWith<$Res>? get identifierField;
}

/// @nodoc
class __$ExternalJwtConfigCopyWithImpl<$Res>
    implements _$ExternalJwtConfigCopyWith<$Res> {
  __$ExternalJwtConfigCopyWithImpl(this._self, this._then);

  final _ExternalJwtConfig _self;
  final $Res Function(_ExternalJwtConfig) _then;

  /// Create a copy of ExternalJwtConfig
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? publicKey = null,
    Object? id = freezed,
    Object? emailField = freezed,
    Object? loginField = freezed,
    Object? mobilePhoneField = freezed,
    Object? identifierField = freezed,
  }) {
    return _then(_ExternalJwtConfig(
      publicKey: null == publicKey
          ? _self.publicKey
          : publicKey // ignore: cast_nullable_to_non_nullable
              as Base64String,
      id: freezed == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String?,
      emailField: freezed == emailField
          ? _self.emailField
          : emailField // ignore: cast_nullable_to_non_nullable
              as String?,
      loginField: freezed == loginField
          ? _self.loginField
          : loginField // ignore: cast_nullable_to_non_nullable
              as String?,
      mobilePhoneField: freezed == mobilePhoneField
          ? _self.mobilePhoneField
          : mobilePhoneField // ignore: cast_nullable_to_non_nullable
              as String?,
      identifierField: freezed == identifierField
          ? _self.identifierField
          : identifierField // ignore: cast_nullable_to_non_nullable
              as IdentifierSelector?,
    ));
  }

  /// Create a copy of ExternalJwtConfig
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $IdentifierSelectorCopyWith<$Res>? get identifierField {
    if (_self.identifierField == null) {
      return null;
    }

    return $IdentifierSelectorCopyWith<$Res>(_self.identifierField!, (value) {
      return _then(_self.copyWith(identifierField: value));
    });
  }
}

// dart format on

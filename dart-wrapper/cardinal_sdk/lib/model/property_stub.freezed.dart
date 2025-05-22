// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'property_stub.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$EncryptedPropertyStub {
  String? get id;
  PropertyTypeStub? get type;
  EncryptedTypedValue? get typedValue;
  int? get deletionDate;
  Base64String? get encryptedSelf;

  /// Create a copy of EncryptedPropertyStub
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $EncryptedPropertyStubCopyWith<EncryptedPropertyStub> get copyWith =>
      _$EncryptedPropertyStubCopyWithImpl<EncryptedPropertyStub>(
          this as EncryptedPropertyStub, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is EncryptedPropertyStub &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.type, type) || other.type == type) &&
            (identical(other.typedValue, typedValue) ||
                other.typedValue == typedValue) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, id, type, typedValue, deletionDate, encryptedSelf);

  @override
  String toString() {
    return 'EncryptedPropertyStub(id: $id, type: $type, typedValue: $typedValue, deletionDate: $deletionDate, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class $EncryptedPropertyStubCopyWith<$Res> {
  factory $EncryptedPropertyStubCopyWith(EncryptedPropertyStub value,
          $Res Function(EncryptedPropertyStub) _then) =
      _$EncryptedPropertyStubCopyWithImpl;
  @useResult
  $Res call(
      {String? id,
      PropertyTypeStub? type,
      EncryptedTypedValue? typedValue,
      int? deletionDate,
      Base64String? encryptedSelf});

  $PropertyTypeStubCopyWith<$Res>? get type;
  $EncryptedTypedValueCopyWith<$Res>? get typedValue;
}

/// @nodoc
class _$EncryptedPropertyStubCopyWithImpl<$Res>
    implements $EncryptedPropertyStubCopyWith<$Res> {
  _$EncryptedPropertyStubCopyWithImpl(this._self, this._then);

  final EncryptedPropertyStub _self;
  final $Res Function(EncryptedPropertyStub) _then;

  /// Create a copy of EncryptedPropertyStub
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = freezed,
    Object? type = freezed,
    Object? typedValue = freezed,
    Object? deletionDate = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_self.copyWith(
      id: freezed == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String?,
      type: freezed == type
          ? _self.type
          : type // ignore: cast_nullable_to_non_nullable
              as PropertyTypeStub?,
      typedValue: freezed == typedValue
          ? _self.typedValue
          : typedValue // ignore: cast_nullable_to_non_nullable
              as EncryptedTypedValue?,
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }

  /// Create a copy of EncryptedPropertyStub
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $PropertyTypeStubCopyWith<$Res>? get type {
    if (_self.type == null) {
      return null;
    }

    return $PropertyTypeStubCopyWith<$Res>(_self.type!, (value) {
      return _then(_self.copyWith(type: value));
    });
  }

  /// Create a copy of EncryptedPropertyStub
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $EncryptedTypedValueCopyWith<$Res>? get typedValue {
    if (_self.typedValue == null) {
      return null;
    }

    return $EncryptedTypedValueCopyWith<$Res>(_self.typedValue!, (value) {
      return _then(_self.copyWith(typedValue: value));
    });
  }
}

/// @nodoc

class _EncryptedPropertyStub implements EncryptedPropertyStub {
  const _EncryptedPropertyStub(
      {this.id = null,
      this.type = null,
      this.typedValue = null,
      this.deletionDate = null,
      this.encryptedSelf = null});

  @override
  @JsonKey()
  final String? id;
  @override
  @JsonKey()
  final PropertyTypeStub? type;
  @override
  @JsonKey()
  final EncryptedTypedValue? typedValue;
  @override
  @JsonKey()
  final int? deletionDate;
  @override
  @JsonKey()
  final Base64String? encryptedSelf;

  /// Create a copy of EncryptedPropertyStub
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$EncryptedPropertyStubCopyWith<_EncryptedPropertyStub> get copyWith =>
      __$EncryptedPropertyStubCopyWithImpl<_EncryptedPropertyStub>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _EncryptedPropertyStub &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.type, type) || other.type == type) &&
            (identical(other.typedValue, typedValue) ||
                other.typedValue == typedValue) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, id, type, typedValue, deletionDate, encryptedSelf);

  @override
  String toString() {
    return 'EncryptedPropertyStub(id: $id, type: $type, typedValue: $typedValue, deletionDate: $deletionDate, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class _$EncryptedPropertyStubCopyWith<$Res>
    implements $EncryptedPropertyStubCopyWith<$Res> {
  factory _$EncryptedPropertyStubCopyWith(_EncryptedPropertyStub value,
          $Res Function(_EncryptedPropertyStub) _then) =
      __$EncryptedPropertyStubCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String? id,
      PropertyTypeStub? type,
      EncryptedTypedValue? typedValue,
      int? deletionDate,
      Base64String? encryptedSelf});

  @override
  $PropertyTypeStubCopyWith<$Res>? get type;
  @override
  $EncryptedTypedValueCopyWith<$Res>? get typedValue;
}

/// @nodoc
class __$EncryptedPropertyStubCopyWithImpl<$Res>
    implements _$EncryptedPropertyStubCopyWith<$Res> {
  __$EncryptedPropertyStubCopyWithImpl(this._self, this._then);

  final _EncryptedPropertyStub _self;
  final $Res Function(_EncryptedPropertyStub) _then;

  /// Create a copy of EncryptedPropertyStub
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = freezed,
    Object? type = freezed,
    Object? typedValue = freezed,
    Object? deletionDate = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_EncryptedPropertyStub(
      id: freezed == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String?,
      type: freezed == type
          ? _self.type
          : type // ignore: cast_nullable_to_non_nullable
              as PropertyTypeStub?,
      typedValue: freezed == typedValue
          ? _self.typedValue
          : typedValue // ignore: cast_nullable_to_non_nullable
              as EncryptedTypedValue?,
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }

  /// Create a copy of EncryptedPropertyStub
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $PropertyTypeStubCopyWith<$Res>? get type {
    if (_self.type == null) {
      return null;
    }

    return $PropertyTypeStubCopyWith<$Res>(_self.type!, (value) {
      return _then(_self.copyWith(type: value));
    });
  }

  /// Create a copy of EncryptedPropertyStub
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $EncryptedTypedValueCopyWith<$Res>? get typedValue {
    if (_self.typedValue == null) {
      return null;
    }

    return $EncryptedTypedValueCopyWith<$Res>(_self.typedValue!, (value) {
      return _then(_self.copyWith(typedValue: value));
    });
  }
}

/// @nodoc
mixin _$DecryptedPropertyStub {
  String? get id;
  PropertyTypeStub? get type;
  DecryptedTypedValue? get typedValue;
  int? get deletionDate;
  Base64String? get encryptedSelf;

  /// Create a copy of DecryptedPropertyStub
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DecryptedPropertyStubCopyWith<DecryptedPropertyStub> get copyWith =>
      _$DecryptedPropertyStubCopyWithImpl<DecryptedPropertyStub>(
          this as DecryptedPropertyStub, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is DecryptedPropertyStub &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.type, type) || other.type == type) &&
            (identical(other.typedValue, typedValue) ||
                other.typedValue == typedValue) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, id, type, typedValue, deletionDate, encryptedSelf);

  @override
  String toString() {
    return 'DecryptedPropertyStub(id: $id, type: $type, typedValue: $typedValue, deletionDate: $deletionDate, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class $DecryptedPropertyStubCopyWith<$Res> {
  factory $DecryptedPropertyStubCopyWith(DecryptedPropertyStub value,
          $Res Function(DecryptedPropertyStub) _then) =
      _$DecryptedPropertyStubCopyWithImpl;
  @useResult
  $Res call(
      {String? id,
      PropertyTypeStub? type,
      DecryptedTypedValue? typedValue,
      int? deletionDate,
      Base64String? encryptedSelf});

  $PropertyTypeStubCopyWith<$Res>? get type;
  $DecryptedTypedValueCopyWith<$Res>? get typedValue;
}

/// @nodoc
class _$DecryptedPropertyStubCopyWithImpl<$Res>
    implements $DecryptedPropertyStubCopyWith<$Res> {
  _$DecryptedPropertyStubCopyWithImpl(this._self, this._then);

  final DecryptedPropertyStub _self;
  final $Res Function(DecryptedPropertyStub) _then;

  /// Create a copy of DecryptedPropertyStub
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = freezed,
    Object? type = freezed,
    Object? typedValue = freezed,
    Object? deletionDate = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_self.copyWith(
      id: freezed == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String?,
      type: freezed == type
          ? _self.type
          : type // ignore: cast_nullable_to_non_nullable
              as PropertyTypeStub?,
      typedValue: freezed == typedValue
          ? _self.typedValue
          : typedValue // ignore: cast_nullable_to_non_nullable
              as DecryptedTypedValue?,
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }

  /// Create a copy of DecryptedPropertyStub
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $PropertyTypeStubCopyWith<$Res>? get type {
    if (_self.type == null) {
      return null;
    }

    return $PropertyTypeStubCopyWith<$Res>(_self.type!, (value) {
      return _then(_self.copyWith(type: value));
    });
  }

  /// Create a copy of DecryptedPropertyStub
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $DecryptedTypedValueCopyWith<$Res>? get typedValue {
    if (_self.typedValue == null) {
      return null;
    }

    return $DecryptedTypedValueCopyWith<$Res>(_self.typedValue!, (value) {
      return _then(_self.copyWith(typedValue: value));
    });
  }
}

/// @nodoc

class _DecryptedPropertyStub implements DecryptedPropertyStub {
  const _DecryptedPropertyStub(
      {this.id = null,
      this.type = null,
      this.typedValue = null,
      this.deletionDate = null,
      this.encryptedSelf = null});

  @override
  @JsonKey()
  final String? id;
  @override
  @JsonKey()
  final PropertyTypeStub? type;
  @override
  @JsonKey()
  final DecryptedTypedValue? typedValue;
  @override
  @JsonKey()
  final int? deletionDate;
  @override
  @JsonKey()
  final Base64String? encryptedSelf;

  /// Create a copy of DecryptedPropertyStub
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DecryptedPropertyStubCopyWith<_DecryptedPropertyStub> get copyWith =>
      __$DecryptedPropertyStubCopyWithImpl<_DecryptedPropertyStub>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _DecryptedPropertyStub &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.type, type) || other.type == type) &&
            (identical(other.typedValue, typedValue) ||
                other.typedValue == typedValue) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, id, type, typedValue, deletionDate, encryptedSelf);

  @override
  String toString() {
    return 'DecryptedPropertyStub(id: $id, type: $type, typedValue: $typedValue, deletionDate: $deletionDate, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class _$DecryptedPropertyStubCopyWith<$Res>
    implements $DecryptedPropertyStubCopyWith<$Res> {
  factory _$DecryptedPropertyStubCopyWith(_DecryptedPropertyStub value,
          $Res Function(_DecryptedPropertyStub) _then) =
      __$DecryptedPropertyStubCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String? id,
      PropertyTypeStub? type,
      DecryptedTypedValue? typedValue,
      int? deletionDate,
      Base64String? encryptedSelf});

  @override
  $PropertyTypeStubCopyWith<$Res>? get type;
  @override
  $DecryptedTypedValueCopyWith<$Res>? get typedValue;
}

/// @nodoc
class __$DecryptedPropertyStubCopyWithImpl<$Res>
    implements _$DecryptedPropertyStubCopyWith<$Res> {
  __$DecryptedPropertyStubCopyWithImpl(this._self, this._then);

  final _DecryptedPropertyStub _self;
  final $Res Function(_DecryptedPropertyStub) _then;

  /// Create a copy of DecryptedPropertyStub
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = freezed,
    Object? type = freezed,
    Object? typedValue = freezed,
    Object? deletionDate = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_DecryptedPropertyStub(
      id: freezed == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String?,
      type: freezed == type
          ? _self.type
          : type // ignore: cast_nullable_to_non_nullable
              as PropertyTypeStub?,
      typedValue: freezed == typedValue
          ? _self.typedValue
          : typedValue // ignore: cast_nullable_to_non_nullable
              as DecryptedTypedValue?,
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }

  /// Create a copy of DecryptedPropertyStub
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $PropertyTypeStubCopyWith<$Res>? get type {
    if (_self.type == null) {
      return null;
    }

    return $PropertyTypeStubCopyWith<$Res>(_self.type!, (value) {
      return _then(_self.copyWith(type: value));
    });
  }

  /// Create a copy of DecryptedPropertyStub
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $DecryptedTypedValueCopyWith<$Res>? get typedValue {
    if (_self.typedValue == null) {
      return null;
    }

    return $DecryptedTypedValueCopyWith<$Res>(_self.typedValue!, (value) {
      return _then(_self.copyWith(typedValue: value));
    });
  }
}

// dart format on

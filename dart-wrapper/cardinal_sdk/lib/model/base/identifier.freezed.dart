// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'identifier.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$Identifier {
  String? get id;
  String? get assigner;
  String? get start;
  String? get end;
  String? get system;
  CodeStub? get type;
  String? get use;
  String? get value;

  /// Create a copy of Identifier
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $IdentifierCopyWith<Identifier> get copyWith =>
      _$IdentifierCopyWithImpl<Identifier>(this as Identifier, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is Identifier &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.assigner, assigner) ||
                other.assigner == assigner) &&
            (identical(other.start, start) || other.start == start) &&
            (identical(other.end, end) || other.end == end) &&
            (identical(other.system, system) || other.system == system) &&
            (identical(other.type, type) || other.type == type) &&
            (identical(other.use, use) || other.use == use) &&
            (identical(other.value, value) || other.value == value));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, id, assigner, start, end, system, type, use, value);

  @override
  String toString() {
    return 'Identifier(id: $id, assigner: $assigner, start: $start, end: $end, system: $system, type: $type, use: $use, value: $value)';
  }
}

/// @nodoc
abstract mixin class $IdentifierCopyWith<$Res> {
  factory $IdentifierCopyWith(
          Identifier value, $Res Function(Identifier) _then) =
      _$IdentifierCopyWithImpl;
  @useResult
  $Res call(
      {String? id,
      String? assigner,
      String? start,
      String? end,
      String? system,
      CodeStub? type,
      String? use,
      String? value});

  $CodeStubCopyWith<$Res>? get type;
}

/// @nodoc
class _$IdentifierCopyWithImpl<$Res> implements $IdentifierCopyWith<$Res> {
  _$IdentifierCopyWithImpl(this._self, this._then);

  final Identifier _self;
  final $Res Function(Identifier) _then;

  /// Create a copy of Identifier
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = freezed,
    Object? assigner = freezed,
    Object? start = freezed,
    Object? end = freezed,
    Object? system = freezed,
    Object? type = freezed,
    Object? use = freezed,
    Object? value = freezed,
  }) {
    return _then(_self.copyWith(
      id: freezed == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String?,
      assigner: freezed == assigner
          ? _self.assigner
          : assigner // ignore: cast_nullable_to_non_nullable
              as String?,
      start: freezed == start
          ? _self.start
          : start // ignore: cast_nullable_to_non_nullable
              as String?,
      end: freezed == end
          ? _self.end
          : end // ignore: cast_nullable_to_non_nullable
              as String?,
      system: freezed == system
          ? _self.system
          : system // ignore: cast_nullable_to_non_nullable
              as String?,
      type: freezed == type
          ? _self.type
          : type // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      use: freezed == use
          ? _self.use
          : use // ignore: cast_nullable_to_non_nullable
              as String?,
      value: freezed == value
          ? _self.value
          : value // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }

  /// Create a copy of Identifier
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get type {
    if (_self.type == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.type!, (value) {
      return _then(_self.copyWith(type: value));
    });
  }
}

/// @nodoc

class _Identifier implements Identifier {
  const _Identifier(
      {this.id = null,
      this.assigner = null,
      this.start = null,
      this.end = null,
      this.system = null,
      this.type = null,
      this.use = null,
      this.value = null});

  @override
  @JsonKey()
  final String? id;
  @override
  @JsonKey()
  final String? assigner;
  @override
  @JsonKey()
  final String? start;
  @override
  @JsonKey()
  final String? end;
  @override
  @JsonKey()
  final String? system;
  @override
  @JsonKey()
  final CodeStub? type;
  @override
  @JsonKey()
  final String? use;
  @override
  @JsonKey()
  final String? value;

  /// Create a copy of Identifier
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$IdentifierCopyWith<_Identifier> get copyWith =>
      __$IdentifierCopyWithImpl<_Identifier>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _Identifier &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.assigner, assigner) ||
                other.assigner == assigner) &&
            (identical(other.start, start) || other.start == start) &&
            (identical(other.end, end) || other.end == end) &&
            (identical(other.system, system) || other.system == system) &&
            (identical(other.type, type) || other.type == type) &&
            (identical(other.use, use) || other.use == use) &&
            (identical(other.value, value) || other.value == value));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, id, assigner, start, end, system, type, use, value);

  @override
  String toString() {
    return 'Identifier(id: $id, assigner: $assigner, start: $start, end: $end, system: $system, type: $type, use: $use, value: $value)';
  }
}

/// @nodoc
abstract mixin class _$IdentifierCopyWith<$Res>
    implements $IdentifierCopyWith<$Res> {
  factory _$IdentifierCopyWith(
          _Identifier value, $Res Function(_Identifier) _then) =
      __$IdentifierCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String? id,
      String? assigner,
      String? start,
      String? end,
      String? system,
      CodeStub? type,
      String? use,
      String? value});

  @override
  $CodeStubCopyWith<$Res>? get type;
}

/// @nodoc
class __$IdentifierCopyWithImpl<$Res> implements _$IdentifierCopyWith<$Res> {
  __$IdentifierCopyWithImpl(this._self, this._then);

  final _Identifier _self;
  final $Res Function(_Identifier) _then;

  /// Create a copy of Identifier
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = freezed,
    Object? assigner = freezed,
    Object? start = freezed,
    Object? end = freezed,
    Object? system = freezed,
    Object? type = freezed,
    Object? use = freezed,
    Object? value = freezed,
  }) {
    return _then(_Identifier(
      id: freezed == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String?,
      assigner: freezed == assigner
          ? _self.assigner
          : assigner // ignore: cast_nullable_to_non_nullable
              as String?,
      start: freezed == start
          ? _self.start
          : start // ignore: cast_nullable_to_non_nullable
              as String?,
      end: freezed == end
          ? _self.end
          : end // ignore: cast_nullable_to_non_nullable
              as String?,
      system: freezed == system
          ? _self.system
          : system // ignore: cast_nullable_to_non_nullable
              as String?,
      type: freezed == type
          ? _self.type
          : type // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      use: freezed == use
          ? _self.use
          : use // ignore: cast_nullable_to_non_nullable
              as String?,
      value: freezed == value
          ? _self.value
          : value // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }

  /// Create a copy of Identifier
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get type {
    if (_self.type == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.type!, (value) {
      return _then(_self.copyWith(type: value));
    });
  }
}

// dart format on

// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'code_stub.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$CodeStub {
  String? get id;
  String? get context;
  String? get type;
  String? get code;
  String? get version;
  String? get contextLabel;
  Map<String, String>? get label;

  /// Create a copy of CodeStub
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<CodeStub> get copyWith =>
      _$CodeStubCopyWithImpl<CodeStub>(this as CodeStub, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is CodeStub &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.context, context) || other.context == context) &&
            (identical(other.type, type) || other.type == type) &&
            (identical(other.code, code) || other.code == code) &&
            (identical(other.version, version) || other.version == version) &&
            (identical(other.contextLabel, contextLabel) ||
                other.contextLabel == contextLabel) &&
            const DeepCollectionEquality().equals(other.label, label));
  }

  @override
  int get hashCode => Object.hash(runtimeType, id, context, type, code, version,
      contextLabel, const DeepCollectionEquality().hash(label));

  @override
  String toString() {
    return 'CodeStub(id: $id, context: $context, type: $type, code: $code, version: $version, contextLabel: $contextLabel, label: $label)';
  }
}

/// @nodoc
abstract mixin class $CodeStubCopyWith<$Res> {
  factory $CodeStubCopyWith(CodeStub value, $Res Function(CodeStub) _then) =
      _$CodeStubCopyWithImpl;
  @useResult
  $Res call(
      {String? id,
      String? context,
      String? type,
      String? code,
      String? version,
      String? contextLabel,
      Map<String, String>? label});
}

/// @nodoc
class _$CodeStubCopyWithImpl<$Res> implements $CodeStubCopyWith<$Res> {
  _$CodeStubCopyWithImpl(this._self, this._then);

  final CodeStub _self;
  final $Res Function(CodeStub) _then;

  /// Create a copy of CodeStub
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = freezed,
    Object? context = freezed,
    Object? type = freezed,
    Object? code = freezed,
    Object? version = freezed,
    Object? contextLabel = freezed,
    Object? label = freezed,
  }) {
    return _then(_self.copyWith(
      id: freezed == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String?,
      context: freezed == context
          ? _self.context
          : context // ignore: cast_nullable_to_non_nullable
              as String?,
      type: freezed == type
          ? _self.type
          : type // ignore: cast_nullable_to_non_nullable
              as String?,
      code: freezed == code
          ? _self.code
          : code // ignore: cast_nullable_to_non_nullable
              as String?,
      version: freezed == version
          ? _self.version
          : version // ignore: cast_nullable_to_non_nullable
              as String?,
      contextLabel: freezed == contextLabel
          ? _self.contextLabel
          : contextLabel // ignore: cast_nullable_to_non_nullable
              as String?,
      label: freezed == label
          ? _self.label
          : label // ignore: cast_nullable_to_non_nullable
              as Map<String, String>?,
    ));
  }
}

/// @nodoc

class _CodeStub implements CodeStub {
  const _CodeStub(
      {this.id = null,
      this.context = null,
      this.type = null,
      this.code = null,
      this.version = null,
      this.contextLabel = null,
      final Map<String, String>? label = null})
      : _label = label;

  @override
  @JsonKey()
  final String? id;
  @override
  @JsonKey()
  final String? context;
  @override
  @JsonKey()
  final String? type;
  @override
  @JsonKey()
  final String? code;
  @override
  @JsonKey()
  final String? version;
  @override
  @JsonKey()
  final String? contextLabel;
  final Map<String, String>? _label;
  @override
  @JsonKey()
  Map<String, String>? get label {
    final value = _label;
    if (value == null) return null;
    if (_label is EqualUnmodifiableMapView) return _label;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(value);
  }

  /// Create a copy of CodeStub
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$CodeStubCopyWith<_CodeStub> get copyWith =>
      __$CodeStubCopyWithImpl<_CodeStub>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _CodeStub &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.context, context) || other.context == context) &&
            (identical(other.type, type) || other.type == type) &&
            (identical(other.code, code) || other.code == code) &&
            (identical(other.version, version) || other.version == version) &&
            (identical(other.contextLabel, contextLabel) ||
                other.contextLabel == contextLabel) &&
            const DeepCollectionEquality().equals(other._label, _label));
  }

  @override
  int get hashCode => Object.hash(runtimeType, id, context, type, code, version,
      contextLabel, const DeepCollectionEquality().hash(_label));

  @override
  String toString() {
    return 'CodeStub(id: $id, context: $context, type: $type, code: $code, version: $version, contextLabel: $contextLabel, label: $label)';
  }
}

/// @nodoc
abstract mixin class _$CodeStubCopyWith<$Res>
    implements $CodeStubCopyWith<$Res> {
  factory _$CodeStubCopyWith(_CodeStub value, $Res Function(_CodeStub) _then) =
      __$CodeStubCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String? id,
      String? context,
      String? type,
      String? code,
      String? version,
      String? contextLabel,
      Map<String, String>? label});
}

/// @nodoc
class __$CodeStubCopyWithImpl<$Res> implements _$CodeStubCopyWith<$Res> {
  __$CodeStubCopyWithImpl(this._self, this._then);

  final _CodeStub _self;
  final $Res Function(_CodeStub) _then;

  /// Create a copy of CodeStub
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = freezed,
    Object? context = freezed,
    Object? type = freezed,
    Object? code = freezed,
    Object? version = freezed,
    Object? contextLabel = freezed,
    Object? label = freezed,
  }) {
    return _then(_CodeStub(
      id: freezed == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String?,
      context: freezed == context
          ? _self.context
          : context // ignore: cast_nullable_to_non_nullable
              as String?,
      type: freezed == type
          ? _self.type
          : type // ignore: cast_nullable_to_non_nullable
              as String?,
      code: freezed == code
          ? _self.code
          : code // ignore: cast_nullable_to_non_nullable
              as String?,
      version: freezed == version
          ? _self.version
          : version // ignore: cast_nullable_to_non_nullable
              as String?,
      contextLabel: freezed == contextLabel
          ? _self.contextLabel
          : contextLabel // ignore: cast_nullable_to_non_nullable
              as String?,
      label: freezed == label
          ? _self._label
          : label // ignore: cast_nullable_to_non_nullable
              as Map<String, String>?,
    ));
  }
}

// dart format on

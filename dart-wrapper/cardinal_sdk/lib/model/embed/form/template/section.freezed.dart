// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'section.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$Section {
  String get section;
  List<StructureElement> get fields;
  String? get description;
  List<String>? get keywords;

  /// Create a copy of Section
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $SectionCopyWith<Section> get copyWith =>
      _$SectionCopyWithImpl<Section>(this as Section, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is Section &&
            (identical(other.section, section) || other.section == section) &&
            const DeepCollectionEquality().equals(other.fields, fields) &&
            (identical(other.description, description) ||
                other.description == description) &&
            const DeepCollectionEquality().equals(other.keywords, keywords));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      section,
      const DeepCollectionEquality().hash(fields),
      description,
      const DeepCollectionEquality().hash(keywords));

  @override
  String toString() {
    return 'Section(section: $section, fields: $fields, description: $description, keywords: $keywords)';
  }
}

/// @nodoc
abstract mixin class $SectionCopyWith<$Res> {
  factory $SectionCopyWith(Section value, $Res Function(Section) _then) =
      _$SectionCopyWithImpl;
  @useResult
  $Res call(
      {String section,
      List<StructureElement> fields,
      String? description,
      List<String>? keywords});
}

/// @nodoc
class _$SectionCopyWithImpl<$Res> implements $SectionCopyWith<$Res> {
  _$SectionCopyWithImpl(this._self, this._then);

  final Section _self;
  final $Res Function(Section) _then;

  /// Create a copy of Section
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? section = null,
    Object? fields = null,
    Object? description = freezed,
    Object? keywords = freezed,
  }) {
    return _then(_self.copyWith(
      section: null == section
          ? _self.section
          : section // ignore: cast_nullable_to_non_nullable
              as String,
      fields: null == fields
          ? _self.fields
          : fields // ignore: cast_nullable_to_non_nullable
              as List<StructureElement>,
      description: freezed == description
          ? _self.description
          : description // ignore: cast_nullable_to_non_nullable
              as String?,
      keywords: freezed == keywords
          ? _self.keywords
          : keywords // ignore: cast_nullable_to_non_nullable
              as List<String>?,
    ));
  }
}

/// @nodoc

class _Section implements Section {
  const _Section(
      {required this.section,
      required final List<StructureElement> fields,
      this.description = null,
      final List<String>? keywords = null})
      : _fields = fields,
        _keywords = keywords;

  @override
  final String section;
  final List<StructureElement> _fields;
  @override
  List<StructureElement> get fields {
    if (_fields is EqualUnmodifiableListView) return _fields;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_fields);
  }

  @override
  @JsonKey()
  final String? description;
  final List<String>? _keywords;
  @override
  @JsonKey()
  List<String>? get keywords {
    final value = _keywords;
    if (value == null) return null;
    if (_keywords is EqualUnmodifiableListView) return _keywords;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(value);
  }

  /// Create a copy of Section
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$SectionCopyWith<_Section> get copyWith =>
      __$SectionCopyWithImpl<_Section>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _Section &&
            (identical(other.section, section) || other.section == section) &&
            const DeepCollectionEquality().equals(other._fields, _fields) &&
            (identical(other.description, description) ||
                other.description == description) &&
            const DeepCollectionEquality().equals(other._keywords, _keywords));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      section,
      const DeepCollectionEquality().hash(_fields),
      description,
      const DeepCollectionEquality().hash(_keywords));

  @override
  String toString() {
    return 'Section(section: $section, fields: $fields, description: $description, keywords: $keywords)';
  }
}

/// @nodoc
abstract mixin class _$SectionCopyWith<$Res> implements $SectionCopyWith<$Res> {
  factory _$SectionCopyWith(_Section value, $Res Function(_Section) _then) =
      __$SectionCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String section,
      List<StructureElement> fields,
      String? description,
      List<String>? keywords});
}

/// @nodoc
class __$SectionCopyWithImpl<$Res> implements _$SectionCopyWith<$Res> {
  __$SectionCopyWithImpl(this._self, this._then);

  final _Section _self;
  final $Res Function(_Section) _then;

  /// Create a copy of Section
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? section = null,
    Object? fields = null,
    Object? description = freezed,
    Object? keywords = freezed,
  }) {
    return _then(_Section(
      section: null == section
          ? _self.section
          : section // ignore: cast_nullable_to_non_nullable
              as String,
      fields: null == fields
          ? _self._fields
          : fields // ignore: cast_nullable_to_non_nullable
              as List<StructureElement>,
      description: freezed == description
          ? _self.description
          : description // ignore: cast_nullable_to_non_nullable
              as String?,
      keywords: freezed == keywords
          ? _self._keywords
          : keywords // ignore: cast_nullable_to_non_nullable
              as List<String>?,
    ));
  }
}

// dart format on

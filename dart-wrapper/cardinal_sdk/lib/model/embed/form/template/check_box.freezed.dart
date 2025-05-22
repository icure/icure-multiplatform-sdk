// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'check_box.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$CheckBox {
  String get field;
  String? get shortLabel;
  int? get rows;
  int? get columns;
  bool? get grows;
  bool? get multiline;
  String? get schema;
  List<String>? get tags;
  List<String>? get codifications;
  Map<String, String>? get options;
  Map<String, String>? get labels;
  String? get value;
  String? get unit;
  bool? get required;
  String? get hideCondition;
  bool? get now;
  bool? get translate;

  /// Create a copy of CheckBox
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $CheckBoxCopyWith<CheckBox> get copyWith =>
      _$CheckBoxCopyWithImpl<CheckBox>(this as CheckBox, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is CheckBox &&
            (identical(other.field, field) || other.field == field) &&
            (identical(other.shortLabel, shortLabel) ||
                other.shortLabel == shortLabel) &&
            (identical(other.rows, rows) || other.rows == rows) &&
            (identical(other.columns, columns) || other.columns == columns) &&
            (identical(other.grows, grows) || other.grows == grows) &&
            (identical(other.multiline, multiline) ||
                other.multiline == multiline) &&
            (identical(other.schema, schema) || other.schema == schema) &&
            const DeepCollectionEquality().equals(other.tags, tags) &&
            const DeepCollectionEquality()
                .equals(other.codifications, codifications) &&
            const DeepCollectionEquality().equals(other.options, options) &&
            const DeepCollectionEquality().equals(other.labels, labels) &&
            (identical(other.value, value) || other.value == value) &&
            (identical(other.unit, unit) || other.unit == unit) &&
            (identical(other.required, required) ||
                other.required == required) &&
            (identical(other.hideCondition, hideCondition) ||
                other.hideCondition == hideCondition) &&
            (identical(other.now, now) || other.now == now) &&
            (identical(other.translate, translate) ||
                other.translate == translate));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      field,
      shortLabel,
      rows,
      columns,
      grows,
      multiline,
      schema,
      const DeepCollectionEquality().hash(tags),
      const DeepCollectionEquality().hash(codifications),
      const DeepCollectionEquality().hash(options),
      const DeepCollectionEquality().hash(labels),
      value,
      unit,
      required,
      hideCondition,
      now,
      translate);

  @override
  String toString() {
    return 'CheckBox(field: $field, shortLabel: $shortLabel, rows: $rows, columns: $columns, grows: $grows, multiline: $multiline, schema: $schema, tags: $tags, codifications: $codifications, options: $options, labels: $labels, value: $value, unit: $unit, required: $required, hideCondition: $hideCondition, now: $now, translate: $translate)';
  }
}

/// @nodoc
abstract mixin class $CheckBoxCopyWith<$Res> {
  factory $CheckBoxCopyWith(CheckBox value, $Res Function(CheckBox) _then) =
      _$CheckBoxCopyWithImpl;
  @useResult
  $Res call(
      {String field,
      String? shortLabel,
      int? rows,
      int? columns,
      bool? grows,
      bool? multiline,
      String? schema,
      List<String>? tags,
      List<String>? codifications,
      Map<String, String>? options,
      Map<String, String>? labels,
      String? value,
      String? unit,
      bool? required,
      String? hideCondition,
      bool? now,
      bool? translate});
}

/// @nodoc
class _$CheckBoxCopyWithImpl<$Res> implements $CheckBoxCopyWith<$Res> {
  _$CheckBoxCopyWithImpl(this._self, this._then);

  final CheckBox _self;
  final $Res Function(CheckBox) _then;

  /// Create a copy of CheckBox
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? field = null,
    Object? shortLabel = freezed,
    Object? rows = freezed,
    Object? columns = freezed,
    Object? grows = freezed,
    Object? multiline = freezed,
    Object? schema = freezed,
    Object? tags = freezed,
    Object? codifications = freezed,
    Object? options = freezed,
    Object? labels = freezed,
    Object? value = freezed,
    Object? unit = freezed,
    Object? required = freezed,
    Object? hideCondition = freezed,
    Object? now = freezed,
    Object? translate = freezed,
  }) {
    return _then(_self.copyWith(
      field: null == field
          ? _self.field
          : field // ignore: cast_nullable_to_non_nullable
              as String,
      shortLabel: freezed == shortLabel
          ? _self.shortLabel
          : shortLabel // ignore: cast_nullable_to_non_nullable
              as String?,
      rows: freezed == rows
          ? _self.rows
          : rows // ignore: cast_nullable_to_non_nullable
              as int?,
      columns: freezed == columns
          ? _self.columns
          : columns // ignore: cast_nullable_to_non_nullable
              as int?,
      grows: freezed == grows
          ? _self.grows
          : grows // ignore: cast_nullable_to_non_nullable
              as bool?,
      multiline: freezed == multiline
          ? _self.multiline
          : multiline // ignore: cast_nullable_to_non_nullable
              as bool?,
      schema: freezed == schema
          ? _self.schema
          : schema // ignore: cast_nullable_to_non_nullable
              as String?,
      tags: freezed == tags
          ? _self.tags
          : tags // ignore: cast_nullable_to_non_nullable
              as List<String>?,
      codifications: freezed == codifications
          ? _self.codifications
          : codifications // ignore: cast_nullable_to_non_nullable
              as List<String>?,
      options: freezed == options
          ? _self.options
          : options // ignore: cast_nullable_to_non_nullable
              as Map<String, String>?,
      labels: freezed == labels
          ? _self.labels
          : labels // ignore: cast_nullable_to_non_nullable
              as Map<String, String>?,
      value: freezed == value
          ? _self.value
          : value // ignore: cast_nullable_to_non_nullable
              as String?,
      unit: freezed == unit
          ? _self.unit
          : unit // ignore: cast_nullable_to_non_nullable
              as String?,
      required: freezed == required
          ? _self.required
          : required // ignore: cast_nullable_to_non_nullable
              as bool?,
      hideCondition: freezed == hideCondition
          ? _self.hideCondition
          : hideCondition // ignore: cast_nullable_to_non_nullable
              as String?,
      now: freezed == now
          ? _self.now
          : now // ignore: cast_nullable_to_non_nullable
              as bool?,
      translate: freezed == translate
          ? _self.translate
          : translate // ignore: cast_nullable_to_non_nullable
              as bool?,
    ));
  }
}

/// @nodoc

class _CheckBox implements CheckBox {
  const _CheckBox(
      {required this.field,
      this.shortLabel = null,
      this.rows = null,
      this.columns = null,
      this.grows = null,
      this.multiline = null,
      this.schema = null,
      final List<String>? tags = null,
      final List<String>? codifications = null,
      final Map<String, String>? options = null,
      final Map<String, String>? labels = null,
      this.value = null,
      this.unit = null,
      this.required = null,
      this.hideCondition = null,
      this.now = null,
      this.translate = null})
      : _tags = tags,
        _codifications = codifications,
        _options = options,
        _labels = labels;

  @override
  final String field;
  @override
  @JsonKey()
  final String? shortLabel;
  @override
  @JsonKey()
  final int? rows;
  @override
  @JsonKey()
  final int? columns;
  @override
  @JsonKey()
  final bool? grows;
  @override
  @JsonKey()
  final bool? multiline;
  @override
  @JsonKey()
  final String? schema;
  final List<String>? _tags;
  @override
  @JsonKey()
  List<String>? get tags {
    final value = _tags;
    if (value == null) return null;
    if (_tags is EqualUnmodifiableListView) return _tags;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(value);
  }

  final List<String>? _codifications;
  @override
  @JsonKey()
  List<String>? get codifications {
    final value = _codifications;
    if (value == null) return null;
    if (_codifications is EqualUnmodifiableListView) return _codifications;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(value);
  }

  final Map<String, String>? _options;
  @override
  @JsonKey()
  Map<String, String>? get options {
    final value = _options;
    if (value == null) return null;
    if (_options is EqualUnmodifiableMapView) return _options;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(value);
  }

  final Map<String, String>? _labels;
  @override
  @JsonKey()
  Map<String, String>? get labels {
    final value = _labels;
    if (value == null) return null;
    if (_labels is EqualUnmodifiableMapView) return _labels;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(value);
  }

  @override
  @JsonKey()
  final String? value;
  @override
  @JsonKey()
  final String? unit;
  @override
  @JsonKey()
  final bool? required;
  @override
  @JsonKey()
  final String? hideCondition;
  @override
  @JsonKey()
  final bool? now;
  @override
  @JsonKey()
  final bool? translate;

  /// Create a copy of CheckBox
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$CheckBoxCopyWith<_CheckBox> get copyWith =>
      __$CheckBoxCopyWithImpl<_CheckBox>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _CheckBox &&
            (identical(other.field, field) || other.field == field) &&
            (identical(other.shortLabel, shortLabel) ||
                other.shortLabel == shortLabel) &&
            (identical(other.rows, rows) || other.rows == rows) &&
            (identical(other.columns, columns) || other.columns == columns) &&
            (identical(other.grows, grows) || other.grows == grows) &&
            (identical(other.multiline, multiline) ||
                other.multiline == multiline) &&
            (identical(other.schema, schema) || other.schema == schema) &&
            const DeepCollectionEquality().equals(other._tags, _tags) &&
            const DeepCollectionEquality()
                .equals(other._codifications, _codifications) &&
            const DeepCollectionEquality().equals(other._options, _options) &&
            const DeepCollectionEquality().equals(other._labels, _labels) &&
            (identical(other.value, value) || other.value == value) &&
            (identical(other.unit, unit) || other.unit == unit) &&
            (identical(other.required, required) ||
                other.required == required) &&
            (identical(other.hideCondition, hideCondition) ||
                other.hideCondition == hideCondition) &&
            (identical(other.now, now) || other.now == now) &&
            (identical(other.translate, translate) ||
                other.translate == translate));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      field,
      shortLabel,
      rows,
      columns,
      grows,
      multiline,
      schema,
      const DeepCollectionEquality().hash(_tags),
      const DeepCollectionEquality().hash(_codifications),
      const DeepCollectionEquality().hash(_options),
      const DeepCollectionEquality().hash(_labels),
      value,
      unit,
      required,
      hideCondition,
      now,
      translate);

  @override
  String toString() {
    return 'CheckBox(field: $field, shortLabel: $shortLabel, rows: $rows, columns: $columns, grows: $grows, multiline: $multiline, schema: $schema, tags: $tags, codifications: $codifications, options: $options, labels: $labels, value: $value, unit: $unit, required: $required, hideCondition: $hideCondition, now: $now, translate: $translate)';
  }
}

/// @nodoc
abstract mixin class _$CheckBoxCopyWith<$Res>
    implements $CheckBoxCopyWith<$Res> {
  factory _$CheckBoxCopyWith(_CheckBox value, $Res Function(_CheckBox) _then) =
      __$CheckBoxCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String field,
      String? shortLabel,
      int? rows,
      int? columns,
      bool? grows,
      bool? multiline,
      String? schema,
      List<String>? tags,
      List<String>? codifications,
      Map<String, String>? options,
      Map<String, String>? labels,
      String? value,
      String? unit,
      bool? required,
      String? hideCondition,
      bool? now,
      bool? translate});
}

/// @nodoc
class __$CheckBoxCopyWithImpl<$Res> implements _$CheckBoxCopyWith<$Res> {
  __$CheckBoxCopyWithImpl(this._self, this._then);

  final _CheckBox _self;
  final $Res Function(_CheckBox) _then;

  /// Create a copy of CheckBox
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? field = null,
    Object? shortLabel = freezed,
    Object? rows = freezed,
    Object? columns = freezed,
    Object? grows = freezed,
    Object? multiline = freezed,
    Object? schema = freezed,
    Object? tags = freezed,
    Object? codifications = freezed,
    Object? options = freezed,
    Object? labels = freezed,
    Object? value = freezed,
    Object? unit = freezed,
    Object? required = freezed,
    Object? hideCondition = freezed,
    Object? now = freezed,
    Object? translate = freezed,
  }) {
    return _then(_CheckBox(
      field: null == field
          ? _self.field
          : field // ignore: cast_nullable_to_non_nullable
              as String,
      shortLabel: freezed == shortLabel
          ? _self.shortLabel
          : shortLabel // ignore: cast_nullable_to_non_nullable
              as String?,
      rows: freezed == rows
          ? _self.rows
          : rows // ignore: cast_nullable_to_non_nullable
              as int?,
      columns: freezed == columns
          ? _self.columns
          : columns // ignore: cast_nullable_to_non_nullable
              as int?,
      grows: freezed == grows
          ? _self.grows
          : grows // ignore: cast_nullable_to_non_nullable
              as bool?,
      multiline: freezed == multiline
          ? _self.multiline
          : multiline // ignore: cast_nullable_to_non_nullable
              as bool?,
      schema: freezed == schema
          ? _self.schema
          : schema // ignore: cast_nullable_to_non_nullable
              as String?,
      tags: freezed == tags
          ? _self._tags
          : tags // ignore: cast_nullable_to_non_nullable
              as List<String>?,
      codifications: freezed == codifications
          ? _self._codifications
          : codifications // ignore: cast_nullable_to_non_nullable
              as List<String>?,
      options: freezed == options
          ? _self._options
          : options // ignore: cast_nullable_to_non_nullable
              as Map<String, String>?,
      labels: freezed == labels
          ? _self._labels
          : labels // ignore: cast_nullable_to_non_nullable
              as Map<String, String>?,
      value: freezed == value
          ? _self.value
          : value // ignore: cast_nullable_to_non_nullable
              as String?,
      unit: freezed == unit
          ? _self.unit
          : unit // ignore: cast_nullable_to_non_nullable
              as String?,
      required: freezed == required
          ? _self.required
          : required // ignore: cast_nullable_to_non_nullable
              as bool?,
      hideCondition: freezed == hideCondition
          ? _self.hideCondition
          : hideCondition // ignore: cast_nullable_to_non_nullable
              as String?,
      now: freezed == now
          ? _self.now
          : now // ignore: cast_nullable_to_non_nullable
              as bool?,
      translate: freezed == translate
          ? _self.translate
          : translate // ignore: cast_nullable_to_non_nullable
              as bool?,
    ));
  }
}

// dart format on

// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'form_template_layout.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$FormTemplateLayout {
  String get form;
  List<Action> get actions;
  List<Section> get sections;
  String? get description;
  List<String>? get keywords;

  /// Create a copy of FormTemplateLayout
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $FormTemplateLayoutCopyWith<FormTemplateLayout> get copyWith =>
      _$FormTemplateLayoutCopyWithImpl<FormTemplateLayout>(
          this as FormTemplateLayout, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is FormTemplateLayout &&
            (identical(other.form, form) || other.form == form) &&
            const DeepCollectionEquality().equals(other.actions, actions) &&
            const DeepCollectionEquality().equals(other.sections, sections) &&
            (identical(other.description, description) ||
                other.description == description) &&
            const DeepCollectionEquality().equals(other.keywords, keywords));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      form,
      const DeepCollectionEquality().hash(actions),
      const DeepCollectionEquality().hash(sections),
      description,
      const DeepCollectionEquality().hash(keywords));

  @override
  String toString() {
    return 'FormTemplateLayout(form: $form, actions: $actions, sections: $sections, description: $description, keywords: $keywords)';
  }
}

/// @nodoc
abstract mixin class $FormTemplateLayoutCopyWith<$Res> {
  factory $FormTemplateLayoutCopyWith(
          FormTemplateLayout value, $Res Function(FormTemplateLayout) _then) =
      _$FormTemplateLayoutCopyWithImpl;
  @useResult
  $Res call(
      {String form,
      List<Action> actions,
      List<Section> sections,
      String? description,
      List<String>? keywords});
}

/// @nodoc
class _$FormTemplateLayoutCopyWithImpl<$Res>
    implements $FormTemplateLayoutCopyWith<$Res> {
  _$FormTemplateLayoutCopyWithImpl(this._self, this._then);

  final FormTemplateLayout _self;
  final $Res Function(FormTemplateLayout) _then;

  /// Create a copy of FormTemplateLayout
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? form = null,
    Object? actions = null,
    Object? sections = null,
    Object? description = freezed,
    Object? keywords = freezed,
  }) {
    return _then(_self.copyWith(
      form: null == form
          ? _self.form
          : form // ignore: cast_nullable_to_non_nullable
              as String,
      actions: null == actions
          ? _self.actions
          : actions // ignore: cast_nullable_to_non_nullable
              as List<Action>,
      sections: null == sections
          ? _self.sections
          : sections // ignore: cast_nullable_to_non_nullable
              as List<Section>,
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

class _FormTemplateLayout implements FormTemplateLayout {
  const _FormTemplateLayout(
      {required this.form,
      final List<Action> actions = const [],
      final List<Section> sections = const [],
      this.description = null,
      final List<String>? keywords = null})
      : _actions = actions,
        _sections = sections,
        _keywords = keywords;

  @override
  final String form;
  final List<Action> _actions;
  @override
  @JsonKey()
  List<Action> get actions {
    if (_actions is EqualUnmodifiableListView) return _actions;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_actions);
  }

  final List<Section> _sections;
  @override
  @JsonKey()
  List<Section> get sections {
    if (_sections is EqualUnmodifiableListView) return _sections;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_sections);
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

  /// Create a copy of FormTemplateLayout
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$FormTemplateLayoutCopyWith<_FormTemplateLayout> get copyWith =>
      __$FormTemplateLayoutCopyWithImpl<_FormTemplateLayout>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _FormTemplateLayout &&
            (identical(other.form, form) || other.form == form) &&
            const DeepCollectionEquality().equals(other._actions, _actions) &&
            const DeepCollectionEquality().equals(other._sections, _sections) &&
            (identical(other.description, description) ||
                other.description == description) &&
            const DeepCollectionEquality().equals(other._keywords, _keywords));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      form,
      const DeepCollectionEquality().hash(_actions),
      const DeepCollectionEquality().hash(_sections),
      description,
      const DeepCollectionEquality().hash(_keywords));

  @override
  String toString() {
    return 'FormTemplateLayout(form: $form, actions: $actions, sections: $sections, description: $description, keywords: $keywords)';
  }
}

/// @nodoc
abstract mixin class _$FormTemplateLayoutCopyWith<$Res>
    implements $FormTemplateLayoutCopyWith<$Res> {
  factory _$FormTemplateLayoutCopyWith(
          _FormTemplateLayout value, $Res Function(_FormTemplateLayout) _then) =
      __$FormTemplateLayoutCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String form,
      List<Action> actions,
      List<Section> sections,
      String? description,
      List<String>? keywords});
}

/// @nodoc
class __$FormTemplateLayoutCopyWithImpl<$Res>
    implements _$FormTemplateLayoutCopyWith<$Res> {
  __$FormTemplateLayoutCopyWithImpl(this._self, this._then);

  final _FormTemplateLayout _self;
  final $Res Function(_FormTemplateLayout) _then;

  /// Create a copy of FormTemplateLayout
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? form = null,
    Object? actions = null,
    Object? sections = null,
    Object? description = freezed,
    Object? keywords = freezed,
  }) {
    return _then(_FormTemplateLayout(
      form: null == form
          ? _self.form
          : form // ignore: cast_nullable_to_non_nullable
              as String,
      actions: null == actions
          ? _self._actions
          : actions // ignore: cast_nullable_to_non_nullable
              as List<Action>,
      sections: null == sections
          ? _self._sections
          : sections // ignore: cast_nullable_to_non_nullable
              as List<Section>,
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

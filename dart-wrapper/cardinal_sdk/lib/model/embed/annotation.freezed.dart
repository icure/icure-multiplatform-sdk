// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'annotation.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$Annotation {
  String get id;
  String? get author;
  int? get created;
  int? get modified;
  String? get text;
  Map<String, String> get markdown;
  String? get location;
  bool? get confidential;
  Set<CodeStub> get tags;
  String? get encryptedSelf;

  /// Create a copy of Annotation
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $AnnotationCopyWith<Annotation> get copyWith =>
      _$AnnotationCopyWithImpl<Annotation>(this as Annotation, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is Annotation &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.author, author) || other.author == author) &&
            (identical(other.created, created) || other.created == created) &&
            (identical(other.modified, modified) ||
                other.modified == modified) &&
            (identical(other.text, text) || other.text == text) &&
            const DeepCollectionEquality().equals(other.markdown, markdown) &&
            (identical(other.location, location) ||
                other.location == location) &&
            (identical(other.confidential, confidential) ||
                other.confidential == confidential) &&
            const DeepCollectionEquality().equals(other.tags, tags) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      id,
      author,
      created,
      modified,
      text,
      const DeepCollectionEquality().hash(markdown),
      location,
      confidential,
      const DeepCollectionEquality().hash(tags),
      encryptedSelf);

  @override
  String toString() {
    return 'Annotation(id: $id, author: $author, created: $created, modified: $modified, text: $text, markdown: $markdown, location: $location, confidential: $confidential, tags: $tags, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class $AnnotationCopyWith<$Res> {
  factory $AnnotationCopyWith(
          Annotation value, $Res Function(Annotation) _then) =
      _$AnnotationCopyWithImpl;
  @useResult
  $Res call(
      {String id,
      String? author,
      int? created,
      int? modified,
      String? text,
      Map<String, String> markdown,
      String? location,
      bool? confidential,
      Set<CodeStub> tags,
      String? encryptedSelf});
}

/// @nodoc
class _$AnnotationCopyWithImpl<$Res> implements $AnnotationCopyWith<$Res> {
  _$AnnotationCopyWithImpl(this._self, this._then);

  final Annotation _self;
  final $Res Function(Annotation) _then;

  /// Create a copy of Annotation
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? author = freezed,
    Object? created = freezed,
    Object? modified = freezed,
    Object? text = freezed,
    Object? markdown = null,
    Object? location = freezed,
    Object? confidential = freezed,
    Object? tags = null,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_self.copyWith(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      author: freezed == author
          ? _self.author
          : author // ignore: cast_nullable_to_non_nullable
              as String?,
      created: freezed == created
          ? _self.created
          : created // ignore: cast_nullable_to_non_nullable
              as int?,
      modified: freezed == modified
          ? _self.modified
          : modified // ignore: cast_nullable_to_non_nullable
              as int?,
      text: freezed == text
          ? _self.text
          : text // ignore: cast_nullable_to_non_nullable
              as String?,
      markdown: null == markdown
          ? _self.markdown
          : markdown // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      location: freezed == location
          ? _self.location
          : location // ignore: cast_nullable_to_non_nullable
              as String?,
      confidential: freezed == confidential
          ? _self.confidential
          : confidential // ignore: cast_nullable_to_non_nullable
              as bool?,
      tags: null == tags
          ? _self.tags
          : tags // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

/// @nodoc

class _Annotation implements Annotation {
  const _Annotation(
      {required this.id,
      this.author = null,
      this.created = null,
      this.modified = null,
      this.text = null,
      final Map<String, String> markdown = const {},
      this.location = null,
      this.confidential = null,
      final Set<CodeStub> tags = const {},
      this.encryptedSelf = null})
      : _markdown = markdown,
        _tags = tags;

  @override
  final String id;
  @override
  @JsonKey()
  final String? author;
  @override
  @JsonKey()
  final int? created;
  @override
  @JsonKey()
  final int? modified;
  @override
  @JsonKey()
  final String? text;
  final Map<String, String> _markdown;
  @override
  @JsonKey()
  Map<String, String> get markdown {
    if (_markdown is EqualUnmodifiableMapView) return _markdown;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_markdown);
  }

  @override
  @JsonKey()
  final String? location;
  @override
  @JsonKey()
  final bool? confidential;
  final Set<CodeStub> _tags;
  @override
  @JsonKey()
  Set<CodeStub> get tags {
    if (_tags is EqualUnmodifiableSetView) return _tags;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_tags);
  }

  @override
  @JsonKey()
  final String? encryptedSelf;

  /// Create a copy of Annotation
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$AnnotationCopyWith<_Annotation> get copyWith =>
      __$AnnotationCopyWithImpl<_Annotation>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _Annotation &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.author, author) || other.author == author) &&
            (identical(other.created, created) || other.created == created) &&
            (identical(other.modified, modified) ||
                other.modified == modified) &&
            (identical(other.text, text) || other.text == text) &&
            const DeepCollectionEquality().equals(other._markdown, _markdown) &&
            (identical(other.location, location) ||
                other.location == location) &&
            (identical(other.confidential, confidential) ||
                other.confidential == confidential) &&
            const DeepCollectionEquality().equals(other._tags, _tags) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      id,
      author,
      created,
      modified,
      text,
      const DeepCollectionEquality().hash(_markdown),
      location,
      confidential,
      const DeepCollectionEquality().hash(_tags),
      encryptedSelf);

  @override
  String toString() {
    return 'Annotation(id: $id, author: $author, created: $created, modified: $modified, text: $text, markdown: $markdown, location: $location, confidential: $confidential, tags: $tags, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class _$AnnotationCopyWith<$Res>
    implements $AnnotationCopyWith<$Res> {
  factory _$AnnotationCopyWith(
          _Annotation value, $Res Function(_Annotation) _then) =
      __$AnnotationCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String id,
      String? author,
      int? created,
      int? modified,
      String? text,
      Map<String, String> markdown,
      String? location,
      bool? confidential,
      Set<CodeStub> tags,
      String? encryptedSelf});
}

/// @nodoc
class __$AnnotationCopyWithImpl<$Res> implements _$AnnotationCopyWith<$Res> {
  __$AnnotationCopyWithImpl(this._self, this._then);

  final _Annotation _self;
  final $Res Function(_Annotation) _then;

  /// Create a copy of Annotation
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? author = freezed,
    Object? created = freezed,
    Object? modified = freezed,
    Object? text = freezed,
    Object? markdown = null,
    Object? location = freezed,
    Object? confidential = freezed,
    Object? tags = null,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_Annotation(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      author: freezed == author
          ? _self.author
          : author // ignore: cast_nullable_to_non_nullable
              as String?,
      created: freezed == created
          ? _self.created
          : created // ignore: cast_nullable_to_non_nullable
              as int?,
      modified: freezed == modified
          ? _self.modified
          : modified // ignore: cast_nullable_to_non_nullable
              as int?,
      text: freezed == text
          ? _self.text
          : text // ignore: cast_nullable_to_non_nullable
              as String?,
      markdown: null == markdown
          ? _self._markdown
          : markdown // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      location: freezed == location
          ? _self.location
          : location // ignore: cast_nullable_to_non_nullable
              as String?,
      confidential: freezed == confidential
          ? _self.confidential
          : confidential // ignore: cast_nullable_to_non_nullable
              as bool?,
      tags: null == tags
          ? _self._tags
          : tags // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

// dart format on

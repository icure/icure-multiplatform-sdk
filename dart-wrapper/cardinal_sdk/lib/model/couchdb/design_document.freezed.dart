// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'design_document.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$DesignDocument {
  String get id;
  String? get rev;
  Map<String, String> get revHistory;
  String? get language;
  Map<String, View> get views;
  Map<String, String> get lists;
  Map<String, String> get shows;
  Map<String, String>? get updateHandlers;
  Map<String, String> get filters;

  /// Create a copy of DesignDocument
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DesignDocumentCopyWith<DesignDocument> get copyWith =>
      _$DesignDocumentCopyWithImpl<DesignDocument>(
          this as DesignDocument, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is DesignDocument &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            const DeepCollectionEquality()
                .equals(other.revHistory, revHistory) &&
            (identical(other.language, language) ||
                other.language == language) &&
            const DeepCollectionEquality().equals(other.views, views) &&
            const DeepCollectionEquality().equals(other.lists, lists) &&
            const DeepCollectionEquality().equals(other.shows, shows) &&
            const DeepCollectionEquality()
                .equals(other.updateHandlers, updateHandlers) &&
            const DeepCollectionEquality().equals(other.filters, filters));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      id,
      rev,
      const DeepCollectionEquality().hash(revHistory),
      language,
      const DeepCollectionEquality().hash(views),
      const DeepCollectionEquality().hash(lists),
      const DeepCollectionEquality().hash(shows),
      const DeepCollectionEquality().hash(updateHandlers),
      const DeepCollectionEquality().hash(filters));

  @override
  String toString() {
    return 'DesignDocument(id: $id, rev: $rev, revHistory: $revHistory, language: $language, views: $views, lists: $lists, shows: $shows, updateHandlers: $updateHandlers, filters: $filters)';
  }
}

/// @nodoc
abstract mixin class $DesignDocumentCopyWith<$Res> {
  factory $DesignDocumentCopyWith(
          DesignDocument value, $Res Function(DesignDocument) _then) =
      _$DesignDocumentCopyWithImpl;
  @useResult
  $Res call(
      {String id,
      String? rev,
      Map<String, String> revHistory,
      String? language,
      Map<String, View> views,
      Map<String, String> lists,
      Map<String, String> shows,
      Map<String, String>? updateHandlers,
      Map<String, String> filters});
}

/// @nodoc
class _$DesignDocumentCopyWithImpl<$Res>
    implements $DesignDocumentCopyWith<$Res> {
  _$DesignDocumentCopyWithImpl(this._self, this._then);

  final DesignDocument _self;
  final $Res Function(DesignDocument) _then;

  /// Create a copy of DesignDocument
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? revHistory = null,
    Object? language = freezed,
    Object? views = null,
    Object? lists = null,
    Object? shows = null,
    Object? updateHandlers = freezed,
    Object? filters = null,
  }) {
    return _then(_self.copyWith(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      rev: freezed == rev
          ? _self.rev
          : rev // ignore: cast_nullable_to_non_nullable
              as String?,
      revHistory: null == revHistory
          ? _self.revHistory
          : revHistory // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      language: freezed == language
          ? _self.language
          : language // ignore: cast_nullable_to_non_nullable
              as String?,
      views: null == views
          ? _self.views
          : views // ignore: cast_nullable_to_non_nullable
              as Map<String, View>,
      lists: null == lists
          ? _self.lists
          : lists // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      shows: null == shows
          ? _self.shows
          : shows // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      updateHandlers: freezed == updateHandlers
          ? _self.updateHandlers
          : updateHandlers // ignore: cast_nullable_to_non_nullable
              as Map<String, String>?,
      filters: null == filters
          ? _self.filters
          : filters // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
    ));
  }
}

/// @nodoc

class _DesignDocument implements DesignDocument {
  const _DesignDocument(
      {required this.id,
      this.rev = null,
      final Map<String, String> revHistory = const {},
      this.language = null,
      final Map<String, View> views = const {},
      final Map<String, String> lists = const {},
      final Map<String, String> shows = const {},
      final Map<String, String>? updateHandlers = null,
      final Map<String, String> filters = const {}})
      : _revHistory = revHistory,
        _views = views,
        _lists = lists,
        _shows = shows,
        _updateHandlers = updateHandlers,
        _filters = filters;

  @override
  final String id;
  @override
  @JsonKey()
  final String? rev;
  final Map<String, String> _revHistory;
  @override
  @JsonKey()
  Map<String, String> get revHistory {
    if (_revHistory is EqualUnmodifiableMapView) return _revHistory;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_revHistory);
  }

  @override
  @JsonKey()
  final String? language;
  final Map<String, View> _views;
  @override
  @JsonKey()
  Map<String, View> get views {
    if (_views is EqualUnmodifiableMapView) return _views;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_views);
  }

  final Map<String, String> _lists;
  @override
  @JsonKey()
  Map<String, String> get lists {
    if (_lists is EqualUnmodifiableMapView) return _lists;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_lists);
  }

  final Map<String, String> _shows;
  @override
  @JsonKey()
  Map<String, String> get shows {
    if (_shows is EqualUnmodifiableMapView) return _shows;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_shows);
  }

  final Map<String, String>? _updateHandlers;
  @override
  @JsonKey()
  Map<String, String>? get updateHandlers {
    final value = _updateHandlers;
    if (value == null) return null;
    if (_updateHandlers is EqualUnmodifiableMapView) return _updateHandlers;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(value);
  }

  final Map<String, String> _filters;
  @override
  @JsonKey()
  Map<String, String> get filters {
    if (_filters is EqualUnmodifiableMapView) return _filters;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_filters);
  }

  /// Create a copy of DesignDocument
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DesignDocumentCopyWith<_DesignDocument> get copyWith =>
      __$DesignDocumentCopyWithImpl<_DesignDocument>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _DesignDocument &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            const DeepCollectionEquality()
                .equals(other._revHistory, _revHistory) &&
            (identical(other.language, language) ||
                other.language == language) &&
            const DeepCollectionEquality().equals(other._views, _views) &&
            const DeepCollectionEquality().equals(other._lists, _lists) &&
            const DeepCollectionEquality().equals(other._shows, _shows) &&
            const DeepCollectionEquality()
                .equals(other._updateHandlers, _updateHandlers) &&
            const DeepCollectionEquality().equals(other._filters, _filters));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      id,
      rev,
      const DeepCollectionEquality().hash(_revHistory),
      language,
      const DeepCollectionEquality().hash(_views),
      const DeepCollectionEquality().hash(_lists),
      const DeepCollectionEquality().hash(_shows),
      const DeepCollectionEquality().hash(_updateHandlers),
      const DeepCollectionEquality().hash(_filters));

  @override
  String toString() {
    return 'DesignDocument(id: $id, rev: $rev, revHistory: $revHistory, language: $language, views: $views, lists: $lists, shows: $shows, updateHandlers: $updateHandlers, filters: $filters)';
  }
}

/// @nodoc
abstract mixin class _$DesignDocumentCopyWith<$Res>
    implements $DesignDocumentCopyWith<$Res> {
  factory _$DesignDocumentCopyWith(
          _DesignDocument value, $Res Function(_DesignDocument) _then) =
      __$DesignDocumentCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String id,
      String? rev,
      Map<String, String> revHistory,
      String? language,
      Map<String, View> views,
      Map<String, String> lists,
      Map<String, String> shows,
      Map<String, String>? updateHandlers,
      Map<String, String> filters});
}

/// @nodoc
class __$DesignDocumentCopyWithImpl<$Res>
    implements _$DesignDocumentCopyWith<$Res> {
  __$DesignDocumentCopyWithImpl(this._self, this._then);

  final _DesignDocument _self;
  final $Res Function(_DesignDocument) _then;

  /// Create a copy of DesignDocument
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? revHistory = null,
    Object? language = freezed,
    Object? views = null,
    Object? lists = null,
    Object? shows = null,
    Object? updateHandlers = freezed,
    Object? filters = null,
  }) {
    return _then(_DesignDocument(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      rev: freezed == rev
          ? _self.rev
          : rev // ignore: cast_nullable_to_non_nullable
              as String?,
      revHistory: null == revHistory
          ? _self._revHistory
          : revHistory // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      language: freezed == language
          ? _self.language
          : language // ignore: cast_nullable_to_non_nullable
              as String?,
      views: null == views
          ? _self._views
          : views // ignore: cast_nullable_to_non_nullable
              as Map<String, View>,
      lists: null == lists
          ? _self._lists
          : lists // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      shows: null == shows
          ? _self._shows
          : shows // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      updateHandlers: freezed == updateHandlers
          ? _self._updateHandlers
          : updateHandlers // ignore: cast_nullable_to_non_nullable
              as Map<String, String>?,
      filters: null == filters
          ? _self._filters
          : filters // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
    ));
  }
}

// dart format on

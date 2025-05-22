// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'entity_template.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$EntityTemplate {
  String get id;
  String? get rev;
  int? get deletionDate;
  String? get userId;
  String? get descr;
  Set<String>? get keywords;
  String? get entityType;
  String? get subType;
  bool? get defaultTemplate;
  List<Map<String, dynamic>> get entity;

  /// Create a copy of EntityTemplate
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $EntityTemplateCopyWith<EntityTemplate> get copyWith =>
      _$EntityTemplateCopyWithImpl<EntityTemplate>(
          this as EntityTemplate, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is EntityTemplate &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            (identical(other.userId, userId) || other.userId == userId) &&
            (identical(other.descr, descr) || other.descr == descr) &&
            const DeepCollectionEquality().equals(other.keywords, keywords) &&
            (identical(other.entityType, entityType) ||
                other.entityType == entityType) &&
            (identical(other.subType, subType) || other.subType == subType) &&
            (identical(other.defaultTemplate, defaultTemplate) ||
                other.defaultTemplate == defaultTemplate) &&
            const DeepCollectionEquality().equals(other.entity, entity));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      id,
      rev,
      deletionDate,
      userId,
      descr,
      const DeepCollectionEquality().hash(keywords),
      entityType,
      subType,
      defaultTemplate,
      const DeepCollectionEquality().hash(entity));

  @override
  String toString() {
    return 'EntityTemplate(id: $id, rev: $rev, deletionDate: $deletionDate, userId: $userId, descr: $descr, keywords: $keywords, entityType: $entityType, subType: $subType, defaultTemplate: $defaultTemplate, entity: $entity)';
  }
}

/// @nodoc
abstract mixin class $EntityTemplateCopyWith<$Res> {
  factory $EntityTemplateCopyWith(
          EntityTemplate value, $Res Function(EntityTemplate) _then) =
      _$EntityTemplateCopyWithImpl;
  @useResult
  $Res call(
      {String id,
      String? rev,
      int? deletionDate,
      String? userId,
      String? descr,
      Set<String>? keywords,
      String? entityType,
      String? subType,
      bool? defaultTemplate,
      List<Map<String, dynamic>> entity});
}

/// @nodoc
class _$EntityTemplateCopyWithImpl<$Res>
    implements $EntityTemplateCopyWith<$Res> {
  _$EntityTemplateCopyWithImpl(this._self, this._then);

  final EntityTemplate _self;
  final $Res Function(EntityTemplate) _then;

  /// Create a copy of EntityTemplate
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? deletionDate = freezed,
    Object? userId = freezed,
    Object? descr = freezed,
    Object? keywords = freezed,
    Object? entityType = freezed,
    Object? subType = freezed,
    Object? defaultTemplate = freezed,
    Object? entity = null,
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
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      userId: freezed == userId
          ? _self.userId
          : userId // ignore: cast_nullable_to_non_nullable
              as String?,
      descr: freezed == descr
          ? _self.descr
          : descr // ignore: cast_nullable_to_non_nullable
              as String?,
      keywords: freezed == keywords
          ? _self.keywords
          : keywords // ignore: cast_nullable_to_non_nullable
              as Set<String>?,
      entityType: freezed == entityType
          ? _self.entityType
          : entityType // ignore: cast_nullable_to_non_nullable
              as String?,
      subType: freezed == subType
          ? _self.subType
          : subType // ignore: cast_nullable_to_non_nullable
              as String?,
      defaultTemplate: freezed == defaultTemplate
          ? _self.defaultTemplate
          : defaultTemplate // ignore: cast_nullable_to_non_nullable
              as bool?,
      entity: null == entity
          ? _self.entity
          : entity // ignore: cast_nullable_to_non_nullable
              as List<Map<String, dynamic>>,
    ));
  }
}

/// @nodoc

class _EntityTemplate implements EntityTemplate {
  const _EntityTemplate(
      {required this.id,
      this.rev = null,
      this.deletionDate = null,
      this.userId = null,
      this.descr = null,
      final Set<String>? keywords = null,
      this.entityType = null,
      this.subType = null,
      this.defaultTemplate = null,
      final List<Map<String, dynamic>> entity = const []})
      : _keywords = keywords,
        _entity = entity;

  @override
  final String id;
  @override
  @JsonKey()
  final String? rev;
  @override
  @JsonKey()
  final int? deletionDate;
  @override
  @JsonKey()
  final String? userId;
  @override
  @JsonKey()
  final String? descr;
  final Set<String>? _keywords;
  @override
  @JsonKey()
  Set<String>? get keywords {
    final value = _keywords;
    if (value == null) return null;
    if (_keywords is EqualUnmodifiableSetView) return _keywords;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(value);
  }

  @override
  @JsonKey()
  final String? entityType;
  @override
  @JsonKey()
  final String? subType;
  @override
  @JsonKey()
  final bool? defaultTemplate;
  final List<Map<String, dynamic>> _entity;
  @override
  @JsonKey()
  List<Map<String, dynamic>> get entity {
    if (_entity is EqualUnmodifiableListView) return _entity;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_entity);
  }

  /// Create a copy of EntityTemplate
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$EntityTemplateCopyWith<_EntityTemplate> get copyWith =>
      __$EntityTemplateCopyWithImpl<_EntityTemplate>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _EntityTemplate &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            (identical(other.userId, userId) || other.userId == userId) &&
            (identical(other.descr, descr) || other.descr == descr) &&
            const DeepCollectionEquality().equals(other._keywords, _keywords) &&
            (identical(other.entityType, entityType) ||
                other.entityType == entityType) &&
            (identical(other.subType, subType) || other.subType == subType) &&
            (identical(other.defaultTemplate, defaultTemplate) ||
                other.defaultTemplate == defaultTemplate) &&
            const DeepCollectionEquality().equals(other._entity, _entity));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      id,
      rev,
      deletionDate,
      userId,
      descr,
      const DeepCollectionEquality().hash(_keywords),
      entityType,
      subType,
      defaultTemplate,
      const DeepCollectionEquality().hash(_entity));

  @override
  String toString() {
    return 'EntityTemplate(id: $id, rev: $rev, deletionDate: $deletionDate, userId: $userId, descr: $descr, keywords: $keywords, entityType: $entityType, subType: $subType, defaultTemplate: $defaultTemplate, entity: $entity)';
  }
}

/// @nodoc
abstract mixin class _$EntityTemplateCopyWith<$Res>
    implements $EntityTemplateCopyWith<$Res> {
  factory _$EntityTemplateCopyWith(
          _EntityTemplate value, $Res Function(_EntityTemplate) _then) =
      __$EntityTemplateCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String id,
      String? rev,
      int? deletionDate,
      String? userId,
      String? descr,
      Set<String>? keywords,
      String? entityType,
      String? subType,
      bool? defaultTemplate,
      List<Map<String, dynamic>> entity});
}

/// @nodoc
class __$EntityTemplateCopyWithImpl<$Res>
    implements _$EntityTemplateCopyWith<$Res> {
  __$EntityTemplateCopyWithImpl(this._self, this._then);

  final _EntityTemplate _self;
  final $Res Function(_EntityTemplate) _then;

  /// Create a copy of EntityTemplate
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? deletionDate = freezed,
    Object? userId = freezed,
    Object? descr = freezed,
    Object? keywords = freezed,
    Object? entityType = freezed,
    Object? subType = freezed,
    Object? defaultTemplate = freezed,
    Object? entity = null,
  }) {
    return _then(_EntityTemplate(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      rev: freezed == rev
          ? _self.rev
          : rev // ignore: cast_nullable_to_non_nullable
              as String?,
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      userId: freezed == userId
          ? _self.userId
          : userId // ignore: cast_nullable_to_non_nullable
              as String?,
      descr: freezed == descr
          ? _self.descr
          : descr // ignore: cast_nullable_to_non_nullable
              as String?,
      keywords: freezed == keywords
          ? _self._keywords
          : keywords // ignore: cast_nullable_to_non_nullable
              as Set<String>?,
      entityType: freezed == entityType
          ? _self.entityType
          : entityType // ignore: cast_nullable_to_non_nullable
              as String?,
      subType: freezed == subType
          ? _self.subType
          : subType // ignore: cast_nullable_to_non_nullable
              as String?,
      defaultTemplate: freezed == defaultTemplate
          ? _self.defaultTemplate
          : defaultTemplate // ignore: cast_nullable_to_non_nullable
              as bool?,
      entity: null == entity
          ? _self._entity
          : entity // ignore: cast_nullable_to_non_nullable
              as List<Map<String, dynamic>>,
    ));
  }
}

// dart format on

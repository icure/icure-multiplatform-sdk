// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'agenda.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$Agenda {
  String get id;
  String? get rev;
  int? get created;
  int? get modified;
  String? get author;
  String? get responsible;
  String? get medicalLocationId;
  Set<CodeStub> get tags;
  Set<CodeStub> get codes;
  int? get endOfLife;
  int? get deletionDate;
  String? get name;
  String? get userId;
  List<Right> get rights;
  Map<String, UserAccessLevel> get userRights;
  Set<DecryptedPropertyStub> get properties;
  List<EmbeddedTimeTable> get timeTables;

  /// Create a copy of Agenda
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $AgendaCopyWith<Agenda> get copyWith =>
      _$AgendaCopyWithImpl<Agenda>(this as Agenda, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is Agenda &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.created, created) || other.created == created) &&
            (identical(other.modified, modified) ||
                other.modified == modified) &&
            (identical(other.author, author) || other.author == author) &&
            (identical(other.responsible, responsible) ||
                other.responsible == responsible) &&
            (identical(other.medicalLocationId, medicalLocationId) ||
                other.medicalLocationId == medicalLocationId) &&
            const DeepCollectionEquality().equals(other.tags, tags) &&
            const DeepCollectionEquality().equals(other.codes, codes) &&
            (identical(other.endOfLife, endOfLife) ||
                other.endOfLife == endOfLife) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.userId, userId) || other.userId == userId) &&
            const DeepCollectionEquality().equals(other.rights, rights) &&
            const DeepCollectionEquality()
                .equals(other.userRights, userRights) &&
            const DeepCollectionEquality()
                .equals(other.properties, properties) &&
            const DeepCollectionEquality()
                .equals(other.timeTables, timeTables));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      id,
      rev,
      created,
      modified,
      author,
      responsible,
      medicalLocationId,
      const DeepCollectionEquality().hash(tags),
      const DeepCollectionEquality().hash(codes),
      endOfLife,
      deletionDate,
      name,
      userId,
      const DeepCollectionEquality().hash(rights),
      const DeepCollectionEquality().hash(userRights),
      const DeepCollectionEquality().hash(properties),
      const DeepCollectionEquality().hash(timeTables));

  @override
  String toString() {
    return 'Agenda(id: $id, rev: $rev, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, endOfLife: $endOfLife, deletionDate: $deletionDate, name: $name, userId: $userId, rights: $rights, userRights: $userRights, properties: $properties, timeTables: $timeTables)';
  }
}

/// @nodoc
abstract mixin class $AgendaCopyWith<$Res> {
  factory $AgendaCopyWith(Agenda value, $Res Function(Agenda) _then) =
      _$AgendaCopyWithImpl;
  @useResult
  $Res call(
      {String id,
      String? rev,
      int? created,
      int? modified,
      String? author,
      String? responsible,
      String? medicalLocationId,
      Set<CodeStub> tags,
      Set<CodeStub> codes,
      int? endOfLife,
      int? deletionDate,
      String? name,
      String? userId,
      List<Right> rights,
      Map<String, UserAccessLevel> userRights,
      Set<DecryptedPropertyStub> properties,
      List<EmbeddedTimeTable> timeTables});
}

/// @nodoc
class _$AgendaCopyWithImpl<$Res> implements $AgendaCopyWith<$Res> {
  _$AgendaCopyWithImpl(this._self, this._then);

  final Agenda _self;
  final $Res Function(Agenda) _then;

  /// Create a copy of Agenda
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? created = freezed,
    Object? modified = freezed,
    Object? author = freezed,
    Object? responsible = freezed,
    Object? medicalLocationId = freezed,
    Object? tags = null,
    Object? codes = null,
    Object? endOfLife = freezed,
    Object? deletionDate = freezed,
    Object? name = freezed,
    Object? userId = freezed,
    Object? rights = null,
    Object? userRights = null,
    Object? properties = null,
    Object? timeTables = null,
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
      created: freezed == created
          ? _self.created
          : created // ignore: cast_nullable_to_non_nullable
              as int?,
      modified: freezed == modified
          ? _self.modified
          : modified // ignore: cast_nullable_to_non_nullable
              as int?,
      author: freezed == author
          ? _self.author
          : author // ignore: cast_nullable_to_non_nullable
              as String?,
      responsible: freezed == responsible
          ? _self.responsible
          : responsible // ignore: cast_nullable_to_non_nullable
              as String?,
      medicalLocationId: freezed == medicalLocationId
          ? _self.medicalLocationId
          : medicalLocationId // ignore: cast_nullable_to_non_nullable
              as String?,
      tags: null == tags
          ? _self.tags
          : tags // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      codes: null == codes
          ? _self.codes
          : codes // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      endOfLife: freezed == endOfLife
          ? _self.endOfLife
          : endOfLife // ignore: cast_nullable_to_non_nullable
              as int?,
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      userId: freezed == userId
          ? _self.userId
          : userId // ignore: cast_nullable_to_non_nullable
              as String?,
      rights: null == rights
          ? _self.rights
          : rights // ignore: cast_nullable_to_non_nullable
              as List<Right>,
      userRights: null == userRights
          ? _self.userRights
          : userRights // ignore: cast_nullable_to_non_nullable
              as Map<String, UserAccessLevel>,
      properties: null == properties
          ? _self.properties
          : properties // ignore: cast_nullable_to_non_nullable
              as Set<DecryptedPropertyStub>,
      timeTables: null == timeTables
          ? _self.timeTables
          : timeTables // ignore: cast_nullable_to_non_nullable
              as List<EmbeddedTimeTable>,
    ));
  }
}

/// @nodoc

class _Agenda implements Agenda {
  const _Agenda(
      {required this.id,
      this.rev = null,
      this.created = null,
      this.modified = null,
      this.author = null,
      this.responsible = null,
      this.medicalLocationId = null,
      final Set<CodeStub> tags = const {},
      final Set<CodeStub> codes = const {},
      this.endOfLife = null,
      this.deletionDate = null,
      this.name = null,
      this.userId = null,
      final List<Right> rights = const [],
      final Map<String, UserAccessLevel> userRights = const {},
      final Set<DecryptedPropertyStub> properties = const {},
      final List<EmbeddedTimeTable> timeTables = const []})
      : _tags = tags,
        _codes = codes,
        _rights = rights,
        _userRights = userRights,
        _properties = properties,
        _timeTables = timeTables;

  @override
  final String id;
  @override
  @JsonKey()
  final String? rev;
  @override
  @JsonKey()
  final int? created;
  @override
  @JsonKey()
  final int? modified;
  @override
  @JsonKey()
  final String? author;
  @override
  @JsonKey()
  final String? responsible;
  @override
  @JsonKey()
  final String? medicalLocationId;
  final Set<CodeStub> _tags;
  @override
  @JsonKey()
  Set<CodeStub> get tags {
    if (_tags is EqualUnmodifiableSetView) return _tags;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_tags);
  }

  final Set<CodeStub> _codes;
  @override
  @JsonKey()
  Set<CodeStub> get codes {
    if (_codes is EqualUnmodifiableSetView) return _codes;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_codes);
  }

  @override
  @JsonKey()
  final int? endOfLife;
  @override
  @JsonKey()
  final int? deletionDate;
  @override
  @JsonKey()
  final String? name;
  @override
  @JsonKey()
  final String? userId;
  final List<Right> _rights;
  @override
  @JsonKey()
  List<Right> get rights {
    if (_rights is EqualUnmodifiableListView) return _rights;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_rights);
  }

  final Map<String, UserAccessLevel> _userRights;
  @override
  @JsonKey()
  Map<String, UserAccessLevel> get userRights {
    if (_userRights is EqualUnmodifiableMapView) return _userRights;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_userRights);
  }

  final Set<DecryptedPropertyStub> _properties;
  @override
  @JsonKey()
  Set<DecryptedPropertyStub> get properties {
    if (_properties is EqualUnmodifiableSetView) return _properties;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_properties);
  }

  final List<EmbeddedTimeTable> _timeTables;
  @override
  @JsonKey()
  List<EmbeddedTimeTable> get timeTables {
    if (_timeTables is EqualUnmodifiableListView) return _timeTables;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_timeTables);
  }

  /// Create a copy of Agenda
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$AgendaCopyWith<_Agenda> get copyWith =>
      __$AgendaCopyWithImpl<_Agenda>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _Agenda &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.created, created) || other.created == created) &&
            (identical(other.modified, modified) ||
                other.modified == modified) &&
            (identical(other.author, author) || other.author == author) &&
            (identical(other.responsible, responsible) ||
                other.responsible == responsible) &&
            (identical(other.medicalLocationId, medicalLocationId) ||
                other.medicalLocationId == medicalLocationId) &&
            const DeepCollectionEquality().equals(other._tags, _tags) &&
            const DeepCollectionEquality().equals(other._codes, _codes) &&
            (identical(other.endOfLife, endOfLife) ||
                other.endOfLife == endOfLife) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.userId, userId) || other.userId == userId) &&
            const DeepCollectionEquality().equals(other._rights, _rights) &&
            const DeepCollectionEquality()
                .equals(other._userRights, _userRights) &&
            const DeepCollectionEquality()
                .equals(other._properties, _properties) &&
            const DeepCollectionEquality()
                .equals(other._timeTables, _timeTables));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      id,
      rev,
      created,
      modified,
      author,
      responsible,
      medicalLocationId,
      const DeepCollectionEquality().hash(_tags),
      const DeepCollectionEquality().hash(_codes),
      endOfLife,
      deletionDate,
      name,
      userId,
      const DeepCollectionEquality().hash(_rights),
      const DeepCollectionEquality().hash(_userRights),
      const DeepCollectionEquality().hash(_properties),
      const DeepCollectionEquality().hash(_timeTables));

  @override
  String toString() {
    return 'Agenda(id: $id, rev: $rev, created: $created, modified: $modified, author: $author, responsible: $responsible, medicalLocationId: $medicalLocationId, tags: $tags, codes: $codes, endOfLife: $endOfLife, deletionDate: $deletionDate, name: $name, userId: $userId, rights: $rights, userRights: $userRights, properties: $properties, timeTables: $timeTables)';
  }
}

/// @nodoc
abstract mixin class _$AgendaCopyWith<$Res> implements $AgendaCopyWith<$Res> {
  factory _$AgendaCopyWith(_Agenda value, $Res Function(_Agenda) _then) =
      __$AgendaCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String id,
      String? rev,
      int? created,
      int? modified,
      String? author,
      String? responsible,
      String? medicalLocationId,
      Set<CodeStub> tags,
      Set<CodeStub> codes,
      int? endOfLife,
      int? deletionDate,
      String? name,
      String? userId,
      List<Right> rights,
      Map<String, UserAccessLevel> userRights,
      Set<DecryptedPropertyStub> properties,
      List<EmbeddedTimeTable> timeTables});
}

/// @nodoc
class __$AgendaCopyWithImpl<$Res> implements _$AgendaCopyWith<$Res> {
  __$AgendaCopyWithImpl(this._self, this._then);

  final _Agenda _self;
  final $Res Function(_Agenda) _then;

  /// Create a copy of Agenda
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? created = freezed,
    Object? modified = freezed,
    Object? author = freezed,
    Object? responsible = freezed,
    Object? medicalLocationId = freezed,
    Object? tags = null,
    Object? codes = null,
    Object? endOfLife = freezed,
    Object? deletionDate = freezed,
    Object? name = freezed,
    Object? userId = freezed,
    Object? rights = null,
    Object? userRights = null,
    Object? properties = null,
    Object? timeTables = null,
  }) {
    return _then(_Agenda(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      rev: freezed == rev
          ? _self.rev
          : rev // ignore: cast_nullable_to_non_nullable
              as String?,
      created: freezed == created
          ? _self.created
          : created // ignore: cast_nullable_to_non_nullable
              as int?,
      modified: freezed == modified
          ? _self.modified
          : modified // ignore: cast_nullable_to_non_nullable
              as int?,
      author: freezed == author
          ? _self.author
          : author // ignore: cast_nullable_to_non_nullable
              as String?,
      responsible: freezed == responsible
          ? _self.responsible
          : responsible // ignore: cast_nullable_to_non_nullable
              as String?,
      medicalLocationId: freezed == medicalLocationId
          ? _self.medicalLocationId
          : medicalLocationId // ignore: cast_nullable_to_non_nullable
              as String?,
      tags: null == tags
          ? _self._tags
          : tags // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      codes: null == codes
          ? _self._codes
          : codes // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      endOfLife: freezed == endOfLife
          ? _self.endOfLife
          : endOfLife // ignore: cast_nullable_to_non_nullable
              as int?,
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      userId: freezed == userId
          ? _self.userId
          : userId // ignore: cast_nullable_to_non_nullable
              as String?,
      rights: null == rights
          ? _self._rights
          : rights // ignore: cast_nullable_to_non_nullable
              as List<Right>,
      userRights: null == userRights
          ? _self._userRights
          : userRights // ignore: cast_nullable_to_non_nullable
              as Map<String, UserAccessLevel>,
      properties: null == properties
          ? _self._properties
          : properties // ignore: cast_nullable_to_non_nullable
              as Set<DecryptedPropertyStub>,
      timeTables: null == timeTables
          ? _self._timeTables
          : timeTables // ignore: cast_nullable_to_non_nullable
              as List<EmbeddedTimeTable>,
    ));
  }
}

// dart format on

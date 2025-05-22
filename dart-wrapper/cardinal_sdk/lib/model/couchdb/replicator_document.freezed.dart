// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'replicator_document.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$ReplicatorDocument {
  String get id;
  String? get rev;
  Remote? get source;
  Remote? get target;
  String? get owner;
  bool? get create_target;
  bool? get continuous;
  List<String>? get doc_ids;
  String? get replicationState;
  String? get replicationStateTime;
  ReplicationStats? get replicationStats;
  int? get errorCount;
  List<Map<String, String>>? get revsInfo;
  Map<String, String>? get revHistory;

  /// Create a copy of ReplicatorDocument
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $ReplicatorDocumentCopyWith<ReplicatorDocument> get copyWith =>
      _$ReplicatorDocumentCopyWithImpl<ReplicatorDocument>(
          this as ReplicatorDocument, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is ReplicatorDocument &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.source, source) || other.source == source) &&
            (identical(other.target, target) || other.target == target) &&
            (identical(other.owner, owner) || other.owner == owner) &&
            (identical(other.create_target, create_target) ||
                other.create_target == create_target) &&
            (identical(other.continuous, continuous) ||
                other.continuous == continuous) &&
            const DeepCollectionEquality().equals(other.doc_ids, doc_ids) &&
            (identical(other.replicationState, replicationState) ||
                other.replicationState == replicationState) &&
            (identical(other.replicationStateTime, replicationStateTime) ||
                other.replicationStateTime == replicationStateTime) &&
            (identical(other.replicationStats, replicationStats) ||
                other.replicationStats == replicationStats) &&
            (identical(other.errorCount, errorCount) ||
                other.errorCount == errorCount) &&
            const DeepCollectionEquality().equals(other.revsInfo, revsInfo) &&
            const DeepCollectionEquality()
                .equals(other.revHistory, revHistory));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      id,
      rev,
      source,
      target,
      owner,
      create_target,
      continuous,
      const DeepCollectionEquality().hash(doc_ids),
      replicationState,
      replicationStateTime,
      replicationStats,
      errorCount,
      const DeepCollectionEquality().hash(revsInfo),
      const DeepCollectionEquality().hash(revHistory));

  @override
  String toString() {
    return 'ReplicatorDocument(id: $id, rev: $rev, source: $source, target: $target, owner: $owner, create_target: $create_target, continuous: $continuous, doc_ids: $doc_ids, replicationState: $replicationState, replicationStateTime: $replicationStateTime, replicationStats: $replicationStats, errorCount: $errorCount, revsInfo: $revsInfo, revHistory: $revHistory)';
  }
}

/// @nodoc
abstract mixin class $ReplicatorDocumentCopyWith<$Res> {
  factory $ReplicatorDocumentCopyWith(
          ReplicatorDocument value, $Res Function(ReplicatorDocument) _then) =
      _$ReplicatorDocumentCopyWithImpl;
  @useResult
  $Res call(
      {String id,
      String? rev,
      Remote? source,
      Remote? target,
      String? owner,
      bool? create_target,
      bool? continuous,
      List<String>? doc_ids,
      String? replicationState,
      String? replicationStateTime,
      ReplicationStats? replicationStats,
      int? errorCount,
      List<Map<String, String>>? revsInfo,
      Map<String, String>? revHistory});

  $RemoteCopyWith<$Res>? get source;
  $RemoteCopyWith<$Res>? get target;
  $ReplicationStatsCopyWith<$Res>? get replicationStats;
}

/// @nodoc
class _$ReplicatorDocumentCopyWithImpl<$Res>
    implements $ReplicatorDocumentCopyWith<$Res> {
  _$ReplicatorDocumentCopyWithImpl(this._self, this._then);

  final ReplicatorDocument _self;
  final $Res Function(ReplicatorDocument) _then;

  /// Create a copy of ReplicatorDocument
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? source = freezed,
    Object? target = freezed,
    Object? owner = freezed,
    Object? create_target = freezed,
    Object? continuous = freezed,
    Object? doc_ids = freezed,
    Object? replicationState = freezed,
    Object? replicationStateTime = freezed,
    Object? replicationStats = freezed,
    Object? errorCount = freezed,
    Object? revsInfo = freezed,
    Object? revHistory = freezed,
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
      source: freezed == source
          ? _self.source
          : source // ignore: cast_nullable_to_non_nullable
              as Remote?,
      target: freezed == target
          ? _self.target
          : target // ignore: cast_nullable_to_non_nullable
              as Remote?,
      owner: freezed == owner
          ? _self.owner
          : owner // ignore: cast_nullable_to_non_nullable
              as String?,
      create_target: freezed == create_target
          ? _self.create_target
          : create_target // ignore: cast_nullable_to_non_nullable
              as bool?,
      continuous: freezed == continuous
          ? _self.continuous
          : continuous // ignore: cast_nullable_to_non_nullable
              as bool?,
      doc_ids: freezed == doc_ids
          ? _self.doc_ids
          : doc_ids // ignore: cast_nullable_to_non_nullable
              as List<String>?,
      replicationState: freezed == replicationState
          ? _self.replicationState
          : replicationState // ignore: cast_nullable_to_non_nullable
              as String?,
      replicationStateTime: freezed == replicationStateTime
          ? _self.replicationStateTime
          : replicationStateTime // ignore: cast_nullable_to_non_nullable
              as String?,
      replicationStats: freezed == replicationStats
          ? _self.replicationStats
          : replicationStats // ignore: cast_nullable_to_non_nullable
              as ReplicationStats?,
      errorCount: freezed == errorCount
          ? _self.errorCount
          : errorCount // ignore: cast_nullable_to_non_nullable
              as int?,
      revsInfo: freezed == revsInfo
          ? _self.revsInfo
          : revsInfo // ignore: cast_nullable_to_non_nullable
              as List<Map<String, String>>?,
      revHistory: freezed == revHistory
          ? _self.revHistory
          : revHistory // ignore: cast_nullable_to_non_nullable
              as Map<String, String>?,
    ));
  }

  /// Create a copy of ReplicatorDocument
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $RemoteCopyWith<$Res>? get source {
    if (_self.source == null) {
      return null;
    }

    return $RemoteCopyWith<$Res>(_self.source!, (value) {
      return _then(_self.copyWith(source: value));
    });
  }

  /// Create a copy of ReplicatorDocument
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $RemoteCopyWith<$Res>? get target {
    if (_self.target == null) {
      return null;
    }

    return $RemoteCopyWith<$Res>(_self.target!, (value) {
      return _then(_self.copyWith(target: value));
    });
  }

  /// Create a copy of ReplicatorDocument
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $ReplicationStatsCopyWith<$Res>? get replicationStats {
    if (_self.replicationStats == null) {
      return null;
    }

    return $ReplicationStatsCopyWith<$Res>(_self.replicationStats!, (value) {
      return _then(_self.copyWith(replicationStats: value));
    });
  }
}

/// @nodoc

class _ReplicatorDocument implements ReplicatorDocument {
  const _ReplicatorDocument(
      {required this.id,
      this.rev = null,
      this.source = null,
      this.target = null,
      this.owner = null,
      this.create_target = null,
      this.continuous = null,
      final List<String>? doc_ids = null,
      this.replicationState = null,
      this.replicationStateTime = null,
      this.replicationStats = null,
      this.errorCount = null,
      final List<Map<String, String>>? revsInfo = null,
      final Map<String, String>? revHistory = null})
      : _doc_ids = doc_ids,
        _revsInfo = revsInfo,
        _revHistory = revHistory;

  @override
  final String id;
  @override
  @JsonKey()
  final String? rev;
  @override
  @JsonKey()
  final Remote? source;
  @override
  @JsonKey()
  final Remote? target;
  @override
  @JsonKey()
  final String? owner;
  @override
  @JsonKey()
  final bool? create_target;
  @override
  @JsonKey()
  final bool? continuous;
  final List<String>? _doc_ids;
  @override
  @JsonKey()
  List<String>? get doc_ids {
    final value = _doc_ids;
    if (value == null) return null;
    if (_doc_ids is EqualUnmodifiableListView) return _doc_ids;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(value);
  }

  @override
  @JsonKey()
  final String? replicationState;
  @override
  @JsonKey()
  final String? replicationStateTime;
  @override
  @JsonKey()
  final ReplicationStats? replicationStats;
  @override
  @JsonKey()
  final int? errorCount;
  final List<Map<String, String>>? _revsInfo;
  @override
  @JsonKey()
  List<Map<String, String>>? get revsInfo {
    final value = _revsInfo;
    if (value == null) return null;
    if (_revsInfo is EqualUnmodifiableListView) return _revsInfo;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(value);
  }

  final Map<String, String>? _revHistory;
  @override
  @JsonKey()
  Map<String, String>? get revHistory {
    final value = _revHistory;
    if (value == null) return null;
    if (_revHistory is EqualUnmodifiableMapView) return _revHistory;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(value);
  }

  /// Create a copy of ReplicatorDocument
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$ReplicatorDocumentCopyWith<_ReplicatorDocument> get copyWith =>
      __$ReplicatorDocumentCopyWithImpl<_ReplicatorDocument>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _ReplicatorDocument &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.source, source) || other.source == source) &&
            (identical(other.target, target) || other.target == target) &&
            (identical(other.owner, owner) || other.owner == owner) &&
            (identical(other.create_target, create_target) ||
                other.create_target == create_target) &&
            (identical(other.continuous, continuous) ||
                other.continuous == continuous) &&
            const DeepCollectionEquality().equals(other._doc_ids, _doc_ids) &&
            (identical(other.replicationState, replicationState) ||
                other.replicationState == replicationState) &&
            (identical(other.replicationStateTime, replicationStateTime) ||
                other.replicationStateTime == replicationStateTime) &&
            (identical(other.replicationStats, replicationStats) ||
                other.replicationStats == replicationStats) &&
            (identical(other.errorCount, errorCount) ||
                other.errorCount == errorCount) &&
            const DeepCollectionEquality().equals(other._revsInfo, _revsInfo) &&
            const DeepCollectionEquality()
                .equals(other._revHistory, _revHistory));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      id,
      rev,
      source,
      target,
      owner,
      create_target,
      continuous,
      const DeepCollectionEquality().hash(_doc_ids),
      replicationState,
      replicationStateTime,
      replicationStats,
      errorCount,
      const DeepCollectionEquality().hash(_revsInfo),
      const DeepCollectionEquality().hash(_revHistory));

  @override
  String toString() {
    return 'ReplicatorDocument(id: $id, rev: $rev, source: $source, target: $target, owner: $owner, create_target: $create_target, continuous: $continuous, doc_ids: $doc_ids, replicationState: $replicationState, replicationStateTime: $replicationStateTime, replicationStats: $replicationStats, errorCount: $errorCount, revsInfo: $revsInfo, revHistory: $revHistory)';
  }
}

/// @nodoc
abstract mixin class _$ReplicatorDocumentCopyWith<$Res>
    implements $ReplicatorDocumentCopyWith<$Res> {
  factory _$ReplicatorDocumentCopyWith(
          _ReplicatorDocument value, $Res Function(_ReplicatorDocument) _then) =
      __$ReplicatorDocumentCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String id,
      String? rev,
      Remote? source,
      Remote? target,
      String? owner,
      bool? create_target,
      bool? continuous,
      List<String>? doc_ids,
      String? replicationState,
      String? replicationStateTime,
      ReplicationStats? replicationStats,
      int? errorCount,
      List<Map<String, String>>? revsInfo,
      Map<String, String>? revHistory});

  @override
  $RemoteCopyWith<$Res>? get source;
  @override
  $RemoteCopyWith<$Res>? get target;
  @override
  $ReplicationStatsCopyWith<$Res>? get replicationStats;
}

/// @nodoc
class __$ReplicatorDocumentCopyWithImpl<$Res>
    implements _$ReplicatorDocumentCopyWith<$Res> {
  __$ReplicatorDocumentCopyWithImpl(this._self, this._then);

  final _ReplicatorDocument _self;
  final $Res Function(_ReplicatorDocument) _then;

  /// Create a copy of ReplicatorDocument
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? source = freezed,
    Object? target = freezed,
    Object? owner = freezed,
    Object? create_target = freezed,
    Object? continuous = freezed,
    Object? doc_ids = freezed,
    Object? replicationState = freezed,
    Object? replicationStateTime = freezed,
    Object? replicationStats = freezed,
    Object? errorCount = freezed,
    Object? revsInfo = freezed,
    Object? revHistory = freezed,
  }) {
    return _then(_ReplicatorDocument(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      rev: freezed == rev
          ? _self.rev
          : rev // ignore: cast_nullable_to_non_nullable
              as String?,
      source: freezed == source
          ? _self.source
          : source // ignore: cast_nullable_to_non_nullable
              as Remote?,
      target: freezed == target
          ? _self.target
          : target // ignore: cast_nullable_to_non_nullable
              as Remote?,
      owner: freezed == owner
          ? _self.owner
          : owner // ignore: cast_nullable_to_non_nullable
              as String?,
      create_target: freezed == create_target
          ? _self.create_target
          : create_target // ignore: cast_nullable_to_non_nullable
              as bool?,
      continuous: freezed == continuous
          ? _self.continuous
          : continuous // ignore: cast_nullable_to_non_nullable
              as bool?,
      doc_ids: freezed == doc_ids
          ? _self._doc_ids
          : doc_ids // ignore: cast_nullable_to_non_nullable
              as List<String>?,
      replicationState: freezed == replicationState
          ? _self.replicationState
          : replicationState // ignore: cast_nullable_to_non_nullable
              as String?,
      replicationStateTime: freezed == replicationStateTime
          ? _self.replicationStateTime
          : replicationStateTime // ignore: cast_nullable_to_non_nullable
              as String?,
      replicationStats: freezed == replicationStats
          ? _self.replicationStats
          : replicationStats // ignore: cast_nullable_to_non_nullable
              as ReplicationStats?,
      errorCount: freezed == errorCount
          ? _self.errorCount
          : errorCount // ignore: cast_nullable_to_non_nullable
              as int?,
      revsInfo: freezed == revsInfo
          ? _self._revsInfo
          : revsInfo // ignore: cast_nullable_to_non_nullable
              as List<Map<String, String>>?,
      revHistory: freezed == revHistory
          ? _self._revHistory
          : revHistory // ignore: cast_nullable_to_non_nullable
              as Map<String, String>?,
    ));
  }

  /// Create a copy of ReplicatorDocument
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $RemoteCopyWith<$Res>? get source {
    if (_self.source == null) {
      return null;
    }

    return $RemoteCopyWith<$Res>(_self.source!, (value) {
      return _then(_self.copyWith(source: value));
    });
  }

  /// Create a copy of ReplicatorDocument
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $RemoteCopyWith<$Res>? get target {
    if (_self.target == null) {
      return null;
    }

    return $RemoteCopyWith<$Res>(_self.target!, (value) {
      return _then(_self.copyWith(target: value));
    });
  }

  /// Create a copy of ReplicatorDocument
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $ReplicationStatsCopyWith<$Res>? get replicationStats {
    if (_self.replicationStats == null) {
      return null;
    }

    return $ReplicationStatsCopyWith<$Res>(_self.replicationStats!, (value) {
      return _then(_self.copyWith(replicationStats: value));
    });
  }
}

// dart format on

// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'replication_stats.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$ReplicationStats {
  int? get revisionsChecked;
  int? get missingRevisionsFound;
  int? get docsRead;
  int? get docsWritten;
  int? get changesPending;
  int? get docWriteFailures;
  String? get checkpointedSourceSeq;
  String? get startTime;
  String? get error;

  /// Create a copy of ReplicationStats
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $ReplicationStatsCopyWith<ReplicationStats> get copyWith =>
      _$ReplicationStatsCopyWithImpl<ReplicationStats>(
          this as ReplicationStats, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is ReplicationStats &&
            (identical(other.revisionsChecked, revisionsChecked) ||
                other.revisionsChecked == revisionsChecked) &&
            (identical(other.missingRevisionsFound, missingRevisionsFound) ||
                other.missingRevisionsFound == missingRevisionsFound) &&
            (identical(other.docsRead, docsRead) ||
                other.docsRead == docsRead) &&
            (identical(other.docsWritten, docsWritten) ||
                other.docsWritten == docsWritten) &&
            (identical(other.changesPending, changesPending) ||
                other.changesPending == changesPending) &&
            (identical(other.docWriteFailures, docWriteFailures) ||
                other.docWriteFailures == docWriteFailures) &&
            (identical(other.checkpointedSourceSeq, checkpointedSourceSeq) ||
                other.checkpointedSourceSeq == checkpointedSourceSeq) &&
            (identical(other.startTime, startTime) ||
                other.startTime == startTime) &&
            (identical(other.error, error) || other.error == error));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      revisionsChecked,
      missingRevisionsFound,
      docsRead,
      docsWritten,
      changesPending,
      docWriteFailures,
      checkpointedSourceSeq,
      startTime,
      error);

  @override
  String toString() {
    return 'ReplicationStats(revisionsChecked: $revisionsChecked, missingRevisionsFound: $missingRevisionsFound, docsRead: $docsRead, docsWritten: $docsWritten, changesPending: $changesPending, docWriteFailures: $docWriteFailures, checkpointedSourceSeq: $checkpointedSourceSeq, startTime: $startTime, error: $error)';
  }
}

/// @nodoc
abstract mixin class $ReplicationStatsCopyWith<$Res> {
  factory $ReplicationStatsCopyWith(
          ReplicationStats value, $Res Function(ReplicationStats) _then) =
      _$ReplicationStatsCopyWithImpl;
  @useResult
  $Res call(
      {int? revisionsChecked,
      int? missingRevisionsFound,
      int? docsRead,
      int? docsWritten,
      int? changesPending,
      int? docWriteFailures,
      String? checkpointedSourceSeq,
      String? startTime,
      String? error});
}

/// @nodoc
class _$ReplicationStatsCopyWithImpl<$Res>
    implements $ReplicationStatsCopyWith<$Res> {
  _$ReplicationStatsCopyWithImpl(this._self, this._then);

  final ReplicationStats _self;
  final $Res Function(ReplicationStats) _then;

  /// Create a copy of ReplicationStats
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? revisionsChecked = freezed,
    Object? missingRevisionsFound = freezed,
    Object? docsRead = freezed,
    Object? docsWritten = freezed,
    Object? changesPending = freezed,
    Object? docWriteFailures = freezed,
    Object? checkpointedSourceSeq = freezed,
    Object? startTime = freezed,
    Object? error = freezed,
  }) {
    return _then(_self.copyWith(
      revisionsChecked: freezed == revisionsChecked
          ? _self.revisionsChecked
          : revisionsChecked // ignore: cast_nullable_to_non_nullable
              as int?,
      missingRevisionsFound: freezed == missingRevisionsFound
          ? _self.missingRevisionsFound
          : missingRevisionsFound // ignore: cast_nullable_to_non_nullable
              as int?,
      docsRead: freezed == docsRead
          ? _self.docsRead
          : docsRead // ignore: cast_nullable_to_non_nullable
              as int?,
      docsWritten: freezed == docsWritten
          ? _self.docsWritten
          : docsWritten // ignore: cast_nullable_to_non_nullable
              as int?,
      changesPending: freezed == changesPending
          ? _self.changesPending
          : changesPending // ignore: cast_nullable_to_non_nullable
              as int?,
      docWriteFailures: freezed == docWriteFailures
          ? _self.docWriteFailures
          : docWriteFailures // ignore: cast_nullable_to_non_nullable
              as int?,
      checkpointedSourceSeq: freezed == checkpointedSourceSeq
          ? _self.checkpointedSourceSeq
          : checkpointedSourceSeq // ignore: cast_nullable_to_non_nullable
              as String?,
      startTime: freezed == startTime
          ? _self.startTime
          : startTime // ignore: cast_nullable_to_non_nullable
              as String?,
      error: freezed == error
          ? _self.error
          : error // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

/// @nodoc

class _ReplicationStats implements ReplicationStats {
  const _ReplicationStats(
      {this.revisionsChecked = null,
      this.missingRevisionsFound = null,
      this.docsRead = null,
      this.docsWritten = null,
      this.changesPending = null,
      this.docWriteFailures = null,
      this.checkpointedSourceSeq = null,
      this.startTime = null,
      this.error = null});

  @override
  @JsonKey()
  final int? revisionsChecked;
  @override
  @JsonKey()
  final int? missingRevisionsFound;
  @override
  @JsonKey()
  final int? docsRead;
  @override
  @JsonKey()
  final int? docsWritten;
  @override
  @JsonKey()
  final int? changesPending;
  @override
  @JsonKey()
  final int? docWriteFailures;
  @override
  @JsonKey()
  final String? checkpointedSourceSeq;
  @override
  @JsonKey()
  final String? startTime;
  @override
  @JsonKey()
  final String? error;

  /// Create a copy of ReplicationStats
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$ReplicationStatsCopyWith<_ReplicationStats> get copyWith =>
      __$ReplicationStatsCopyWithImpl<_ReplicationStats>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _ReplicationStats &&
            (identical(other.revisionsChecked, revisionsChecked) ||
                other.revisionsChecked == revisionsChecked) &&
            (identical(other.missingRevisionsFound, missingRevisionsFound) ||
                other.missingRevisionsFound == missingRevisionsFound) &&
            (identical(other.docsRead, docsRead) ||
                other.docsRead == docsRead) &&
            (identical(other.docsWritten, docsWritten) ||
                other.docsWritten == docsWritten) &&
            (identical(other.changesPending, changesPending) ||
                other.changesPending == changesPending) &&
            (identical(other.docWriteFailures, docWriteFailures) ||
                other.docWriteFailures == docWriteFailures) &&
            (identical(other.checkpointedSourceSeq, checkpointedSourceSeq) ||
                other.checkpointedSourceSeq == checkpointedSourceSeq) &&
            (identical(other.startTime, startTime) ||
                other.startTime == startTime) &&
            (identical(other.error, error) || other.error == error));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      revisionsChecked,
      missingRevisionsFound,
      docsRead,
      docsWritten,
      changesPending,
      docWriteFailures,
      checkpointedSourceSeq,
      startTime,
      error);

  @override
  String toString() {
    return 'ReplicationStats(revisionsChecked: $revisionsChecked, missingRevisionsFound: $missingRevisionsFound, docsRead: $docsRead, docsWritten: $docsWritten, changesPending: $changesPending, docWriteFailures: $docWriteFailures, checkpointedSourceSeq: $checkpointedSourceSeq, startTime: $startTime, error: $error)';
  }
}

/// @nodoc
abstract mixin class _$ReplicationStatsCopyWith<$Res>
    implements $ReplicationStatsCopyWith<$Res> {
  factory _$ReplicationStatsCopyWith(
          _ReplicationStats value, $Res Function(_ReplicationStats) _then) =
      __$ReplicationStatsCopyWithImpl;
  @override
  @useResult
  $Res call(
      {int? revisionsChecked,
      int? missingRevisionsFound,
      int? docsRead,
      int? docsWritten,
      int? changesPending,
      int? docWriteFailures,
      String? checkpointedSourceSeq,
      String? startTime,
      String? error});
}

/// @nodoc
class __$ReplicationStatsCopyWithImpl<$Res>
    implements _$ReplicationStatsCopyWith<$Res> {
  __$ReplicationStatsCopyWithImpl(this._self, this._then);

  final _ReplicationStats _self;
  final $Res Function(_ReplicationStats) _then;

  /// Create a copy of ReplicationStats
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? revisionsChecked = freezed,
    Object? missingRevisionsFound = freezed,
    Object? docsRead = freezed,
    Object? docsWritten = freezed,
    Object? changesPending = freezed,
    Object? docWriteFailures = freezed,
    Object? checkpointedSourceSeq = freezed,
    Object? startTime = freezed,
    Object? error = freezed,
  }) {
    return _then(_ReplicationStats(
      revisionsChecked: freezed == revisionsChecked
          ? _self.revisionsChecked
          : revisionsChecked // ignore: cast_nullable_to_non_nullable
              as int?,
      missingRevisionsFound: freezed == missingRevisionsFound
          ? _self.missingRevisionsFound
          : missingRevisionsFound // ignore: cast_nullable_to_non_nullable
              as int?,
      docsRead: freezed == docsRead
          ? _self.docsRead
          : docsRead // ignore: cast_nullable_to_non_nullable
              as int?,
      docsWritten: freezed == docsWritten
          ? _self.docsWritten
          : docsWritten // ignore: cast_nullable_to_non_nullable
              as int?,
      changesPending: freezed == changesPending
          ? _self.changesPending
          : changesPending // ignore: cast_nullable_to_non_nullable
              as int?,
      docWriteFailures: freezed == docWriteFailures
          ? _self.docWriteFailures
          : docWriteFailures // ignore: cast_nullable_to_non_nullable
              as int?,
      checkpointedSourceSeq: freezed == checkpointedSourceSeq
          ? _self.checkpointedSourceSeq
          : checkpointedSourceSeq // ignore: cast_nullable_to_non_nullable
              as String?,
      startTime: freezed == startTime
          ? _self.startTime
          : startTime // ignore: cast_nullable_to_non_nullable
              as String?,
      error: freezed == error
          ? _self.error
          : error // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

// dart format on

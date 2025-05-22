// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'database_info.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$DatabaseInfo {
  String get id;
  String? get updateSeq;
  int? get fileSize;
  int? get externalSize;
  int? get activeSize;
  int? get docs;
  int? get q;
  int? get n;
  int? get w;
  int? get r;

  /// Create a copy of DatabaseInfo
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DatabaseInfoCopyWith<DatabaseInfo> get copyWith =>
      _$DatabaseInfoCopyWithImpl<DatabaseInfo>(
          this as DatabaseInfo, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is DatabaseInfo &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.updateSeq, updateSeq) ||
                other.updateSeq == updateSeq) &&
            (identical(other.fileSize, fileSize) ||
                other.fileSize == fileSize) &&
            (identical(other.externalSize, externalSize) ||
                other.externalSize == externalSize) &&
            (identical(other.activeSize, activeSize) ||
                other.activeSize == activeSize) &&
            (identical(other.docs, docs) || other.docs == docs) &&
            (identical(other.q, q) || other.q == q) &&
            (identical(other.n, n) || other.n == n) &&
            (identical(other.w, w) || other.w == w) &&
            (identical(other.r, r) || other.r == r));
  }

  @override
  int get hashCode => Object.hash(runtimeType, id, updateSeq, fileSize,
      externalSize, activeSize, docs, q, n, w, r);

  @override
  String toString() {
    return 'DatabaseInfo(id: $id, updateSeq: $updateSeq, fileSize: $fileSize, externalSize: $externalSize, activeSize: $activeSize, docs: $docs, q: $q, n: $n, w: $w, r: $r)';
  }
}

/// @nodoc
abstract mixin class $DatabaseInfoCopyWith<$Res> {
  factory $DatabaseInfoCopyWith(
          DatabaseInfo value, $Res Function(DatabaseInfo) _then) =
      _$DatabaseInfoCopyWithImpl;
  @useResult
  $Res call(
      {String id,
      String? updateSeq,
      int? fileSize,
      int? externalSize,
      int? activeSize,
      int? docs,
      int? q,
      int? n,
      int? w,
      int? r});
}

/// @nodoc
class _$DatabaseInfoCopyWithImpl<$Res> implements $DatabaseInfoCopyWith<$Res> {
  _$DatabaseInfoCopyWithImpl(this._self, this._then);

  final DatabaseInfo _self;
  final $Res Function(DatabaseInfo) _then;

  /// Create a copy of DatabaseInfo
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? updateSeq = freezed,
    Object? fileSize = freezed,
    Object? externalSize = freezed,
    Object? activeSize = freezed,
    Object? docs = freezed,
    Object? q = freezed,
    Object? n = freezed,
    Object? w = freezed,
    Object? r = freezed,
  }) {
    return _then(_self.copyWith(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      updateSeq: freezed == updateSeq
          ? _self.updateSeq
          : updateSeq // ignore: cast_nullable_to_non_nullable
              as String?,
      fileSize: freezed == fileSize
          ? _self.fileSize
          : fileSize // ignore: cast_nullable_to_non_nullable
              as int?,
      externalSize: freezed == externalSize
          ? _self.externalSize
          : externalSize // ignore: cast_nullable_to_non_nullable
              as int?,
      activeSize: freezed == activeSize
          ? _self.activeSize
          : activeSize // ignore: cast_nullable_to_non_nullable
              as int?,
      docs: freezed == docs
          ? _self.docs
          : docs // ignore: cast_nullable_to_non_nullable
              as int?,
      q: freezed == q
          ? _self.q
          : q // ignore: cast_nullable_to_non_nullable
              as int?,
      n: freezed == n
          ? _self.n
          : n // ignore: cast_nullable_to_non_nullable
              as int?,
      w: freezed == w
          ? _self.w
          : w // ignore: cast_nullable_to_non_nullable
              as int?,
      r: freezed == r
          ? _self.r
          : r // ignore: cast_nullable_to_non_nullable
              as int?,
    ));
  }
}

/// @nodoc

class _DatabaseInfo implements DatabaseInfo {
  const _DatabaseInfo(
      {required this.id,
      this.updateSeq = null,
      this.fileSize = null,
      this.externalSize = null,
      this.activeSize = null,
      this.docs = null,
      this.q = null,
      this.n = null,
      this.w = null,
      this.r = null});

  @override
  final String id;
  @override
  @JsonKey()
  final String? updateSeq;
  @override
  @JsonKey()
  final int? fileSize;
  @override
  @JsonKey()
  final int? externalSize;
  @override
  @JsonKey()
  final int? activeSize;
  @override
  @JsonKey()
  final int? docs;
  @override
  @JsonKey()
  final int? q;
  @override
  @JsonKey()
  final int? n;
  @override
  @JsonKey()
  final int? w;
  @override
  @JsonKey()
  final int? r;

  /// Create a copy of DatabaseInfo
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DatabaseInfoCopyWith<_DatabaseInfo> get copyWith =>
      __$DatabaseInfoCopyWithImpl<_DatabaseInfo>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _DatabaseInfo &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.updateSeq, updateSeq) ||
                other.updateSeq == updateSeq) &&
            (identical(other.fileSize, fileSize) ||
                other.fileSize == fileSize) &&
            (identical(other.externalSize, externalSize) ||
                other.externalSize == externalSize) &&
            (identical(other.activeSize, activeSize) ||
                other.activeSize == activeSize) &&
            (identical(other.docs, docs) || other.docs == docs) &&
            (identical(other.q, q) || other.q == q) &&
            (identical(other.n, n) || other.n == n) &&
            (identical(other.w, w) || other.w == w) &&
            (identical(other.r, r) || other.r == r));
  }

  @override
  int get hashCode => Object.hash(runtimeType, id, updateSeq, fileSize,
      externalSize, activeSize, docs, q, n, w, r);

  @override
  String toString() {
    return 'DatabaseInfo(id: $id, updateSeq: $updateSeq, fileSize: $fileSize, externalSize: $externalSize, activeSize: $activeSize, docs: $docs, q: $q, n: $n, w: $w, r: $r)';
  }
}

/// @nodoc
abstract mixin class _$DatabaseInfoCopyWith<$Res>
    implements $DatabaseInfoCopyWith<$Res> {
  factory _$DatabaseInfoCopyWith(
          _DatabaseInfo value, $Res Function(_DatabaseInfo) _then) =
      __$DatabaseInfoCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String id,
      String? updateSeq,
      int? fileSize,
      int? externalSize,
      int? activeSize,
      int? docs,
      int? q,
      int? n,
      int? w,
      int? r});
}

/// @nodoc
class __$DatabaseInfoCopyWithImpl<$Res>
    implements _$DatabaseInfoCopyWith<$Res> {
  __$DatabaseInfoCopyWithImpl(this._self, this._then);

  final _DatabaseInfo _self;
  final $Res Function(_DatabaseInfo) _then;

  /// Create a copy of DatabaseInfo
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? updateSeq = freezed,
    Object? fileSize = freezed,
    Object? externalSize = freezed,
    Object? activeSize = freezed,
    Object? docs = freezed,
    Object? q = freezed,
    Object? n = freezed,
    Object? w = freezed,
    Object? r = freezed,
  }) {
    return _then(_DatabaseInfo(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      updateSeq: freezed == updateSeq
          ? _self.updateSeq
          : updateSeq // ignore: cast_nullable_to_non_nullable
              as String?,
      fileSize: freezed == fileSize
          ? _self.fileSize
          : fileSize // ignore: cast_nullable_to_non_nullable
              as int?,
      externalSize: freezed == externalSize
          ? _self.externalSize
          : externalSize // ignore: cast_nullable_to_non_nullable
              as int?,
      activeSize: freezed == activeSize
          ? _self.activeSize
          : activeSize // ignore: cast_nullable_to_non_nullable
              as int?,
      docs: freezed == docs
          ? _self.docs
          : docs // ignore: cast_nullable_to_non_nullable
              as int?,
      q: freezed == q
          ? _self.q
          : q // ignore: cast_nullable_to_non_nullable
              as int?,
      n: freezed == n
          ? _self.n
          : n // ignore: cast_nullable_to_non_nullable
              as int?,
      w: freezed == w
          ? _self.w
          : w // ignore: cast_nullable_to_non_nullable
              as int?,
      r: freezed == r
          ? _self.r
          : r // ignore: cast_nullable_to_non_nullable
              as int?,
    ));
  }
}

// dart format on

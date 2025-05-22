// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'group_databases_info.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$GroupDatabasesInfo {
  String get groupId;
  List<DatabaseInfo> get databasesInfo;
  int get gcpStorageSize;

  /// Create a copy of GroupDatabasesInfo
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $GroupDatabasesInfoCopyWith<GroupDatabasesInfo> get copyWith =>
      _$GroupDatabasesInfoCopyWithImpl<GroupDatabasesInfo>(
          this as GroupDatabasesInfo, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is GroupDatabasesInfo &&
            (identical(other.groupId, groupId) || other.groupId == groupId) &&
            const DeepCollectionEquality()
                .equals(other.databasesInfo, databasesInfo) &&
            (identical(other.gcpStorageSize, gcpStorageSize) ||
                other.gcpStorageSize == gcpStorageSize));
  }

  @override
  int get hashCode => Object.hash(runtimeType, groupId,
      const DeepCollectionEquality().hash(databasesInfo), gcpStorageSize);

  @override
  String toString() {
    return 'GroupDatabasesInfo(groupId: $groupId, databasesInfo: $databasesInfo, gcpStorageSize: $gcpStorageSize)';
  }
}

/// @nodoc
abstract mixin class $GroupDatabasesInfoCopyWith<$Res> {
  factory $GroupDatabasesInfoCopyWith(
          GroupDatabasesInfo value, $Res Function(GroupDatabasesInfo) _then) =
      _$GroupDatabasesInfoCopyWithImpl;
  @useResult
  $Res call(
      {String groupId, List<DatabaseInfo> databasesInfo, int gcpStorageSize});
}

/// @nodoc
class _$GroupDatabasesInfoCopyWithImpl<$Res>
    implements $GroupDatabasesInfoCopyWith<$Res> {
  _$GroupDatabasesInfoCopyWithImpl(this._self, this._then);

  final GroupDatabasesInfo _self;
  final $Res Function(GroupDatabasesInfo) _then;

  /// Create a copy of GroupDatabasesInfo
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? groupId = null,
    Object? databasesInfo = null,
    Object? gcpStorageSize = null,
  }) {
    return _then(_self.copyWith(
      groupId: null == groupId
          ? _self.groupId
          : groupId // ignore: cast_nullable_to_non_nullable
              as String,
      databasesInfo: null == databasesInfo
          ? _self.databasesInfo
          : databasesInfo // ignore: cast_nullable_to_non_nullable
              as List<DatabaseInfo>,
      gcpStorageSize: null == gcpStorageSize
          ? _self.gcpStorageSize
          : gcpStorageSize // ignore: cast_nullable_to_non_nullable
              as int,
    ));
  }
}

/// @nodoc

class _GroupDatabasesInfo implements GroupDatabasesInfo {
  const _GroupDatabasesInfo(
      {required this.groupId,
      required final List<DatabaseInfo> databasesInfo,
      required this.gcpStorageSize})
      : _databasesInfo = databasesInfo;

  @override
  final String groupId;
  final List<DatabaseInfo> _databasesInfo;
  @override
  List<DatabaseInfo> get databasesInfo {
    if (_databasesInfo is EqualUnmodifiableListView) return _databasesInfo;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_databasesInfo);
  }

  @override
  final int gcpStorageSize;

  /// Create a copy of GroupDatabasesInfo
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$GroupDatabasesInfoCopyWith<_GroupDatabasesInfo> get copyWith =>
      __$GroupDatabasesInfoCopyWithImpl<_GroupDatabasesInfo>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _GroupDatabasesInfo &&
            (identical(other.groupId, groupId) || other.groupId == groupId) &&
            const DeepCollectionEquality()
                .equals(other._databasesInfo, _databasesInfo) &&
            (identical(other.gcpStorageSize, gcpStorageSize) ||
                other.gcpStorageSize == gcpStorageSize));
  }

  @override
  int get hashCode => Object.hash(runtimeType, groupId,
      const DeepCollectionEquality().hash(_databasesInfo), gcpStorageSize);

  @override
  String toString() {
    return 'GroupDatabasesInfo(groupId: $groupId, databasesInfo: $databasesInfo, gcpStorageSize: $gcpStorageSize)';
  }
}

/// @nodoc
abstract mixin class _$GroupDatabasesInfoCopyWith<$Res>
    implements $GroupDatabasesInfoCopyWith<$Res> {
  factory _$GroupDatabasesInfoCopyWith(
          _GroupDatabasesInfo value, $Res Function(_GroupDatabasesInfo) _then) =
      __$GroupDatabasesInfoCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String groupId, List<DatabaseInfo> databasesInfo, int gcpStorageSize});
}

/// @nodoc
class __$GroupDatabasesInfoCopyWithImpl<$Res>
    implements _$GroupDatabasesInfoCopyWith<$Res> {
  __$GroupDatabasesInfoCopyWithImpl(this._self, this._then);

  final _GroupDatabasesInfo _self;
  final $Res Function(_GroupDatabasesInfo) _then;

  /// Create a copy of GroupDatabasesInfo
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? groupId = null,
    Object? databasesInfo = null,
    Object? gcpStorageSize = null,
  }) {
    return _then(_GroupDatabasesInfo(
      groupId: null == groupId
          ? _self.groupId
          : groupId // ignore: cast_nullable_to_non_nullable
              as String,
      databasesInfo: null == databasesInfo
          ? _self._databasesInfo
          : databasesInfo // ignore: cast_nullable_to_non_nullable
              as List<DatabaseInfo>,
      gcpStorageSize: null == gcpStorageSize
          ? _self.gcpStorageSize
          : gcpStorageSize // ignore: cast_nullable_to_non_nullable
              as int,
    ));
  }
}

// dart format on

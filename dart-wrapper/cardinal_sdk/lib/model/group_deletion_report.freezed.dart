// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'group_deletion_report.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$GroupDeletionReport {
  String get type;
  String get id;
  String get server;

  /// Create a copy of GroupDeletionReport
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $GroupDeletionReportCopyWith<GroupDeletionReport> get copyWith =>
      _$GroupDeletionReportCopyWithImpl<GroupDeletionReport>(
          this as GroupDeletionReport, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is GroupDeletionReport &&
            (identical(other.type, type) || other.type == type) &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.server, server) || other.server == server));
  }

  @override
  int get hashCode => Object.hash(runtimeType, type, id, server);

  @override
  String toString() {
    return 'GroupDeletionReport(type: $type, id: $id, server: $server)';
  }
}

/// @nodoc
abstract mixin class $GroupDeletionReportCopyWith<$Res> {
  factory $GroupDeletionReportCopyWith(
          GroupDeletionReport value, $Res Function(GroupDeletionReport) _then) =
      _$GroupDeletionReportCopyWithImpl;
  @useResult
  $Res call({String type, String id, String server});
}

/// @nodoc
class _$GroupDeletionReportCopyWithImpl<$Res>
    implements $GroupDeletionReportCopyWith<$Res> {
  _$GroupDeletionReportCopyWithImpl(this._self, this._then);

  final GroupDeletionReport _self;
  final $Res Function(GroupDeletionReport) _then;

  /// Create a copy of GroupDeletionReport
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? type = null,
    Object? id = null,
    Object? server = null,
  }) {
    return _then(_self.copyWith(
      type: null == type
          ? _self.type
          : type // ignore: cast_nullable_to_non_nullable
              as String,
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      server: null == server
          ? _self.server
          : server // ignore: cast_nullable_to_non_nullable
              as String,
    ));
  }
}

/// @nodoc

class _GroupDeletionReport implements GroupDeletionReport {
  const _GroupDeletionReport(
      {required this.type, required this.id, required this.server});

  @override
  final String type;
  @override
  final String id;
  @override
  final String server;

  /// Create a copy of GroupDeletionReport
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$GroupDeletionReportCopyWith<_GroupDeletionReport> get copyWith =>
      __$GroupDeletionReportCopyWithImpl<_GroupDeletionReport>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _GroupDeletionReport &&
            (identical(other.type, type) || other.type == type) &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.server, server) || other.server == server));
  }

  @override
  int get hashCode => Object.hash(runtimeType, type, id, server);

  @override
  String toString() {
    return 'GroupDeletionReport(type: $type, id: $id, server: $server)';
  }
}

/// @nodoc
abstract mixin class _$GroupDeletionReportCopyWith<$Res>
    implements $GroupDeletionReportCopyWith<$Res> {
  factory _$GroupDeletionReportCopyWith(_GroupDeletionReport value,
          $Res Function(_GroupDeletionReport) _then) =
      __$GroupDeletionReportCopyWithImpl;
  @override
  @useResult
  $Res call({String type, String id, String server});
}

/// @nodoc
class __$GroupDeletionReportCopyWithImpl<$Res>
    implements _$GroupDeletionReportCopyWith<$Res> {
  __$GroupDeletionReportCopyWithImpl(this._self, this._then);

  final _GroupDeletionReport _self;
  final $Res Function(_GroupDeletionReport) _then;

  /// Create a copy of GroupDeletionReport
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? type = null,
    Object? id = null,
    Object? server = null,
  }) {
    return _then(_GroupDeletionReport(
      type: null == type
          ? _self.type
          : type // ignore: cast_nullable_to_non_nullable
              as String,
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      server: null == server
          ? _self.server
          : server // ignore: cast_nullable_to_non_nullable
              as String,
    ));
  }
}

// dart format on

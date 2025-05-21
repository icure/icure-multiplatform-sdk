// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'deleted_attachment.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$DeletedAttachment {
  String? get couchDbAttachmentId;
  String? get objectStoreAttachmentId;
  String? get key;
  int? get deletionTime;

  /// Create a copy of DeletedAttachment
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DeletedAttachmentCopyWith<DeletedAttachment> get copyWith =>
      _$DeletedAttachmentCopyWithImpl<DeletedAttachment>(
          this as DeletedAttachment, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is DeletedAttachment &&
            (identical(other.couchDbAttachmentId, couchDbAttachmentId) ||
                other.couchDbAttachmentId == couchDbAttachmentId) &&
            (identical(
                    other.objectStoreAttachmentId, objectStoreAttachmentId) ||
                other.objectStoreAttachmentId == objectStoreAttachmentId) &&
            (identical(other.key, key) || other.key == key) &&
            (identical(other.deletionTime, deletionTime) ||
                other.deletionTime == deletionTime));
  }

  @override
  int get hashCode => Object.hash(runtimeType, couchDbAttachmentId,
      objectStoreAttachmentId, key, deletionTime);

  @override
  String toString() {
    return 'DeletedAttachment(couchDbAttachmentId: $couchDbAttachmentId, objectStoreAttachmentId: $objectStoreAttachmentId, key: $key, deletionTime: $deletionTime)';
  }
}

/// @nodoc
abstract mixin class $DeletedAttachmentCopyWith<$Res> {
  factory $DeletedAttachmentCopyWith(
          DeletedAttachment value, $Res Function(DeletedAttachment) _then) =
      _$DeletedAttachmentCopyWithImpl;
  @useResult
  $Res call(
      {String? couchDbAttachmentId,
      String? objectStoreAttachmentId,
      String? key,
      int? deletionTime});
}

/// @nodoc
class _$DeletedAttachmentCopyWithImpl<$Res>
    implements $DeletedAttachmentCopyWith<$Res> {
  _$DeletedAttachmentCopyWithImpl(this._self, this._then);

  final DeletedAttachment _self;
  final $Res Function(DeletedAttachment) _then;

  /// Create a copy of DeletedAttachment
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? couchDbAttachmentId = freezed,
    Object? objectStoreAttachmentId = freezed,
    Object? key = freezed,
    Object? deletionTime = freezed,
  }) {
    return _then(_self.copyWith(
      couchDbAttachmentId: freezed == couchDbAttachmentId
          ? _self.couchDbAttachmentId
          : couchDbAttachmentId // ignore: cast_nullable_to_non_nullable
              as String?,
      objectStoreAttachmentId: freezed == objectStoreAttachmentId
          ? _self.objectStoreAttachmentId
          : objectStoreAttachmentId // ignore: cast_nullable_to_non_nullable
              as String?,
      key: freezed == key
          ? _self.key
          : key // ignore: cast_nullable_to_non_nullable
              as String?,
      deletionTime: freezed == deletionTime
          ? _self.deletionTime
          : deletionTime // ignore: cast_nullable_to_non_nullable
              as int?,
    ));
  }
}

/// @nodoc

class _DeletedAttachment implements DeletedAttachment {
  const _DeletedAttachment(
      {this.couchDbAttachmentId = null,
      this.objectStoreAttachmentId = null,
      this.key = null,
      this.deletionTime = null});

  @override
  @JsonKey()
  final String? couchDbAttachmentId;
  @override
  @JsonKey()
  final String? objectStoreAttachmentId;
  @override
  @JsonKey()
  final String? key;
  @override
  @JsonKey()
  final int? deletionTime;

  /// Create a copy of DeletedAttachment
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DeletedAttachmentCopyWith<_DeletedAttachment> get copyWith =>
      __$DeletedAttachmentCopyWithImpl<_DeletedAttachment>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _DeletedAttachment &&
            (identical(other.couchDbAttachmentId, couchDbAttachmentId) ||
                other.couchDbAttachmentId == couchDbAttachmentId) &&
            (identical(
                    other.objectStoreAttachmentId, objectStoreAttachmentId) ||
                other.objectStoreAttachmentId == objectStoreAttachmentId) &&
            (identical(other.key, key) || other.key == key) &&
            (identical(other.deletionTime, deletionTime) ||
                other.deletionTime == deletionTime));
  }

  @override
  int get hashCode => Object.hash(runtimeType, couchDbAttachmentId,
      objectStoreAttachmentId, key, deletionTime);

  @override
  String toString() {
    return 'DeletedAttachment(couchDbAttachmentId: $couchDbAttachmentId, objectStoreAttachmentId: $objectStoreAttachmentId, key: $key, deletionTime: $deletionTime)';
  }
}

/// @nodoc
abstract mixin class _$DeletedAttachmentCopyWith<$Res>
    implements $DeletedAttachmentCopyWith<$Res> {
  factory _$DeletedAttachmentCopyWith(
          _DeletedAttachment value, $Res Function(_DeletedAttachment) _then) =
      __$DeletedAttachmentCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String? couchDbAttachmentId,
      String? objectStoreAttachmentId,
      String? key,
      int? deletionTime});
}

/// @nodoc
class __$DeletedAttachmentCopyWithImpl<$Res>
    implements _$DeletedAttachmentCopyWith<$Res> {
  __$DeletedAttachmentCopyWithImpl(this._self, this._then);

  final _DeletedAttachment _self;
  final $Res Function(_DeletedAttachment) _then;

  /// Create a copy of DeletedAttachment
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? couchDbAttachmentId = freezed,
    Object? objectStoreAttachmentId = freezed,
    Object? key = freezed,
    Object? deletionTime = freezed,
  }) {
    return _then(_DeletedAttachment(
      couchDbAttachmentId: freezed == couchDbAttachmentId
          ? _self.couchDbAttachmentId
          : couchDbAttachmentId // ignore: cast_nullable_to_non_nullable
              as String?,
      objectStoreAttachmentId: freezed == objectStoreAttachmentId
          ? _self.objectStoreAttachmentId
          : objectStoreAttachmentId // ignore: cast_nullable_to_non_nullable
              as String?,
      key: freezed == key
          ? _self.key
          : key // ignore: cast_nullable_to_non_nullable
              as String?,
      deletionTime: freezed == deletionTime
          ? _self.deletionTime
          : deletionTime // ignore: cast_nullable_to_non_nullable
              as int?,
    ));
  }
}

// dart format on

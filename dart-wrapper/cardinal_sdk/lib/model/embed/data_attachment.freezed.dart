// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'data_attachment.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$DataAttachment {
  String? get couchDbAttachmentId;
  String? get objectStoreAttachmentId;
  List<String> get utis;

  /// Create a copy of DataAttachment
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DataAttachmentCopyWith<DataAttachment> get copyWith =>
      _$DataAttachmentCopyWithImpl<DataAttachment>(
          this as DataAttachment, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is DataAttachment &&
            (identical(other.couchDbAttachmentId, couchDbAttachmentId) ||
                other.couchDbAttachmentId == couchDbAttachmentId) &&
            (identical(
                    other.objectStoreAttachmentId, objectStoreAttachmentId) ||
                other.objectStoreAttachmentId == objectStoreAttachmentId) &&
            const DeepCollectionEquality().equals(other.utis, utis));
  }

  @override
  int get hashCode => Object.hash(runtimeType, couchDbAttachmentId,
      objectStoreAttachmentId, const DeepCollectionEquality().hash(utis));

  @override
  String toString() {
    return 'DataAttachment(couchDbAttachmentId: $couchDbAttachmentId, objectStoreAttachmentId: $objectStoreAttachmentId, utis: $utis)';
  }
}

/// @nodoc
abstract mixin class $DataAttachmentCopyWith<$Res> {
  factory $DataAttachmentCopyWith(
          DataAttachment value, $Res Function(DataAttachment) _then) =
      _$DataAttachmentCopyWithImpl;
  @useResult
  $Res call(
      {String? couchDbAttachmentId,
      String? objectStoreAttachmentId,
      List<String> utis});
}

/// @nodoc
class _$DataAttachmentCopyWithImpl<$Res>
    implements $DataAttachmentCopyWith<$Res> {
  _$DataAttachmentCopyWithImpl(this._self, this._then);

  final DataAttachment _self;
  final $Res Function(DataAttachment) _then;

  /// Create a copy of DataAttachment
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? couchDbAttachmentId = freezed,
    Object? objectStoreAttachmentId = freezed,
    Object? utis = null,
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
      utis: null == utis
          ? _self.utis
          : utis // ignore: cast_nullable_to_non_nullable
              as List<String>,
    ));
  }
}

/// @nodoc

class _DataAttachment implements DataAttachment {
  const _DataAttachment(
      {this.couchDbAttachmentId = null,
      this.objectStoreAttachmentId = null,
      final List<String> utis = const []})
      : _utis = utis;

  @override
  @JsonKey()
  final String? couchDbAttachmentId;
  @override
  @JsonKey()
  final String? objectStoreAttachmentId;
  final List<String> _utis;
  @override
  @JsonKey()
  List<String> get utis {
    if (_utis is EqualUnmodifiableListView) return _utis;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_utis);
  }

  /// Create a copy of DataAttachment
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DataAttachmentCopyWith<_DataAttachment> get copyWith =>
      __$DataAttachmentCopyWithImpl<_DataAttachment>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _DataAttachment &&
            (identical(other.couchDbAttachmentId, couchDbAttachmentId) ||
                other.couchDbAttachmentId == couchDbAttachmentId) &&
            (identical(
                    other.objectStoreAttachmentId, objectStoreAttachmentId) ||
                other.objectStoreAttachmentId == objectStoreAttachmentId) &&
            const DeepCollectionEquality().equals(other._utis, _utis));
  }

  @override
  int get hashCode => Object.hash(runtimeType, couchDbAttachmentId,
      objectStoreAttachmentId, const DeepCollectionEquality().hash(_utis));

  @override
  String toString() {
    return 'DataAttachment(couchDbAttachmentId: $couchDbAttachmentId, objectStoreAttachmentId: $objectStoreAttachmentId, utis: $utis)';
  }
}

/// @nodoc
abstract mixin class _$DataAttachmentCopyWith<$Res>
    implements $DataAttachmentCopyWith<$Res> {
  factory _$DataAttachmentCopyWith(
          _DataAttachment value, $Res Function(_DataAttachment) _then) =
      __$DataAttachmentCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String? couchDbAttachmentId,
      String? objectStoreAttachmentId,
      List<String> utis});
}

/// @nodoc
class __$DataAttachmentCopyWithImpl<$Res>
    implements _$DataAttachmentCopyWith<$Res> {
  __$DataAttachmentCopyWithImpl(this._self, this._then);

  final _DataAttachment _self;
  final $Res Function(_DataAttachment) _then;

  /// Create a copy of DataAttachment
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? couchDbAttachmentId = freezed,
    Object? objectStoreAttachmentId = freezed,
    Object? utis = null,
  }) {
    return _then(_DataAttachment(
      couchDbAttachmentId: freezed == couchDbAttachmentId
          ? _self.couchDbAttachmentId
          : couchDbAttachmentId // ignore: cast_nullable_to_non_nullable
              as String?,
      objectStoreAttachmentId: freezed == objectStoreAttachmentId
          ? _self.objectStoreAttachmentId
          : objectStoreAttachmentId // ignore: cast_nullable_to_non_nullable
              as String?,
      utis: null == utis
          ? _self._utis
          : utis // ignore: cast_nullable_to_non_nullable
              as List<String>,
    ));
  }
}

// dart format on

// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'message_attachment.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$MessageAttachment {
  DocumentLocation? get type;
  List<String> get ids;

  /// Create a copy of MessageAttachment
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $MessageAttachmentCopyWith<MessageAttachment> get copyWith =>
      _$MessageAttachmentCopyWithImpl<MessageAttachment>(
          this as MessageAttachment, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is MessageAttachment &&
            (identical(other.type, type) || other.type == type) &&
            const DeepCollectionEquality().equals(other.ids, ids));
  }

  @override
  int get hashCode =>
      Object.hash(runtimeType, type, const DeepCollectionEquality().hash(ids));

  @override
  String toString() {
    return 'MessageAttachment(type: $type, ids: $ids)';
  }
}

/// @nodoc
abstract mixin class $MessageAttachmentCopyWith<$Res> {
  factory $MessageAttachmentCopyWith(
          MessageAttachment value, $Res Function(MessageAttachment) _then) =
      _$MessageAttachmentCopyWithImpl;
  @useResult
  $Res call({DocumentLocation? type, List<String> ids});
}

/// @nodoc
class _$MessageAttachmentCopyWithImpl<$Res>
    implements $MessageAttachmentCopyWith<$Res> {
  _$MessageAttachmentCopyWithImpl(this._self, this._then);

  final MessageAttachment _self;
  final $Res Function(MessageAttachment) _then;

  /// Create a copy of MessageAttachment
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? type = freezed,
    Object? ids = null,
  }) {
    return _then(_self.copyWith(
      type: freezed == type
          ? _self.type
          : type // ignore: cast_nullable_to_non_nullable
              as DocumentLocation?,
      ids: null == ids
          ? _self.ids
          : ids // ignore: cast_nullable_to_non_nullable
              as List<String>,
    ));
  }
}

/// @nodoc

class _MessageAttachment implements MessageAttachment {
  const _MessageAttachment(
      {this.type = null, final List<String> ids = const []})
      : _ids = ids;

  @override
  @JsonKey()
  final DocumentLocation? type;
  final List<String> _ids;
  @override
  @JsonKey()
  List<String> get ids {
    if (_ids is EqualUnmodifiableListView) return _ids;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_ids);
  }

  /// Create a copy of MessageAttachment
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$MessageAttachmentCopyWith<_MessageAttachment> get copyWith =>
      __$MessageAttachmentCopyWithImpl<_MessageAttachment>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _MessageAttachment &&
            (identical(other.type, type) || other.type == type) &&
            const DeepCollectionEquality().equals(other._ids, _ids));
  }

  @override
  int get hashCode =>
      Object.hash(runtimeType, type, const DeepCollectionEquality().hash(_ids));

  @override
  String toString() {
    return 'MessageAttachment(type: $type, ids: $ids)';
  }
}

/// @nodoc
abstract mixin class _$MessageAttachmentCopyWith<$Res>
    implements $MessageAttachmentCopyWith<$Res> {
  factory _$MessageAttachmentCopyWith(
          _MessageAttachment value, $Res Function(_MessageAttachment) _then) =
      __$MessageAttachmentCopyWithImpl;
  @override
  @useResult
  $Res call({DocumentLocation? type, List<String> ids});
}

/// @nodoc
class __$MessageAttachmentCopyWithImpl<$Res>
    implements _$MessageAttachmentCopyWith<$Res> {
  __$MessageAttachmentCopyWithImpl(this._self, this._then);

  final _MessageAttachment _self;
  final $Res Function(_MessageAttachment) _then;

  /// Create a copy of MessageAttachment
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? type = freezed,
    Object? ids = null,
  }) {
    return _then(_MessageAttachment(
      type: freezed == type
          ? _self.type
          : type // ignore: cast_nullable_to_non_nullable
              as DocumentLocation?,
      ids: null == ids
          ? _self._ids
          : ids // ignore: cast_nullable_to_non_nullable
              as List<String>,
    ));
  }
}

// dart format on

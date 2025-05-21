// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'list_of_ids.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$ListOfIds {
  List<String> get ids;

  /// Create a copy of ListOfIds
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $ListOfIdsCopyWith<ListOfIds> get copyWith =>
      _$ListOfIdsCopyWithImpl<ListOfIds>(this as ListOfIds, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is ListOfIds &&
            const DeepCollectionEquality().equals(other.ids, ids));
  }

  @override
  int get hashCode =>
      Object.hash(runtimeType, const DeepCollectionEquality().hash(ids));

  @override
  String toString() {
    return 'ListOfIds(ids: $ids)';
  }
}

/// @nodoc
abstract mixin class $ListOfIdsCopyWith<$Res> {
  factory $ListOfIdsCopyWith(ListOfIds value, $Res Function(ListOfIds) _then) =
      _$ListOfIdsCopyWithImpl;
  @useResult
  $Res call({List<String> ids});
}

/// @nodoc
class _$ListOfIdsCopyWithImpl<$Res> implements $ListOfIdsCopyWith<$Res> {
  _$ListOfIdsCopyWithImpl(this._self, this._then);

  final ListOfIds _self;
  final $Res Function(ListOfIds) _then;

  /// Create a copy of ListOfIds
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? ids = null,
  }) {
    return _then(_self.copyWith(
      ids: null == ids
          ? _self.ids
          : ids // ignore: cast_nullable_to_non_nullable
              as List<String>,
    ));
  }
}

/// @nodoc

class _ListOfIds implements ListOfIds {
  const _ListOfIds({final List<String> ids = const []}) : _ids = ids;

  final List<String> _ids;
  @override
  @JsonKey()
  List<String> get ids {
    if (_ids is EqualUnmodifiableListView) return _ids;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_ids);
  }

  /// Create a copy of ListOfIds
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$ListOfIdsCopyWith<_ListOfIds> get copyWith =>
      __$ListOfIdsCopyWithImpl<_ListOfIds>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _ListOfIds &&
            const DeepCollectionEquality().equals(other._ids, _ids));
  }

  @override
  int get hashCode =>
      Object.hash(runtimeType, const DeepCollectionEquality().hash(_ids));

  @override
  String toString() {
    return 'ListOfIds(ids: $ids)';
  }
}

/// @nodoc
abstract mixin class _$ListOfIdsCopyWith<$Res>
    implements $ListOfIdsCopyWith<$Res> {
  factory _$ListOfIdsCopyWith(
          _ListOfIds value, $Res Function(_ListOfIds) _then) =
      __$ListOfIdsCopyWithImpl;
  @override
  @useResult
  $Res call({List<String> ids});
}

/// @nodoc
class __$ListOfIdsCopyWithImpl<$Res> implements _$ListOfIdsCopyWith<$Res> {
  __$ListOfIdsCopyWithImpl(this._self, this._then);

  final _ListOfIds _self;
  final $Res Function(_ListOfIds) _then;

  /// Create a copy of ListOfIds
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? ids = null,
  }) {
    return _then(_ListOfIds(
      ids: null == ids
          ? _self._ids
          : ids // ignore: cast_nullable_to_non_nullable
              as List<String>,
    ));
  }
}

// dart format on

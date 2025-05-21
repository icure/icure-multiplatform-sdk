// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'view.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$View {
  String get map;
  String? get reduce;

  /// Create a copy of View
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $ViewCopyWith<View> get copyWith =>
      _$ViewCopyWithImpl<View>(this as View, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is View &&
            (identical(other.map, map) || other.map == map) &&
            (identical(other.reduce, reduce) || other.reduce == reduce));
  }

  @override
  int get hashCode => Object.hash(runtimeType, map, reduce);

  @override
  String toString() {
    return 'View(map: $map, reduce: $reduce)';
  }
}

/// @nodoc
abstract mixin class $ViewCopyWith<$Res> {
  factory $ViewCopyWith(View value, $Res Function(View) _then) =
      _$ViewCopyWithImpl;
  @useResult
  $Res call({String map, String? reduce});
}

/// @nodoc
class _$ViewCopyWithImpl<$Res> implements $ViewCopyWith<$Res> {
  _$ViewCopyWithImpl(this._self, this._then);

  final View _self;
  final $Res Function(View) _then;

  /// Create a copy of View
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? map = null,
    Object? reduce = freezed,
  }) {
    return _then(_self.copyWith(
      map: null == map
          ? _self.map
          : map // ignore: cast_nullable_to_non_nullable
              as String,
      reduce: freezed == reduce
          ? _self.reduce
          : reduce // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

/// @nodoc

class _View implements View {
  const _View({required this.map, this.reduce = null});

  @override
  final String map;
  @override
  @JsonKey()
  final String? reduce;

  /// Create a copy of View
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$ViewCopyWith<_View> get copyWith =>
      __$ViewCopyWithImpl<_View>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _View &&
            (identical(other.map, map) || other.map == map) &&
            (identical(other.reduce, reduce) || other.reduce == reduce));
  }

  @override
  int get hashCode => Object.hash(runtimeType, map, reduce);

  @override
  String toString() {
    return 'View(map: $map, reduce: $reduce)';
  }
}

/// @nodoc
abstract mixin class _$ViewCopyWith<$Res> implements $ViewCopyWith<$Res> {
  factory _$ViewCopyWith(_View value, $Res Function(_View) _then) =
      __$ViewCopyWithImpl;
  @override
  @useResult
  $Res call({String map, String? reduce});
}

/// @nodoc
class __$ViewCopyWithImpl<$Res> implements _$ViewCopyWith<$Res> {
  __$ViewCopyWithImpl(this._self, this._then);

  final _View _self;
  final $Res Function(_View) _then;

  /// Create a copy of View
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? map = null,
    Object? reduce = freezed,
  }) {
    return _then(_View(
      map: null == map
          ? _self.map
          : map // ignore: cast_nullable_to_non_nullable
              as String,
      reduce: freezed == reduce
          ? _self.reduce
          : reduce // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

// dart format on

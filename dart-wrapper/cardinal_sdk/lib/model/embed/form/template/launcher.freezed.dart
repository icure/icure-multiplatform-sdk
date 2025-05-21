// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'launcher.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$Launcher {
  String get name;
  Trigger get triggerer;
  bool get shouldPassValue;

  /// Create a copy of Launcher
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $LauncherCopyWith<Launcher> get copyWith =>
      _$LauncherCopyWithImpl<Launcher>(this as Launcher, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is Launcher &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.triggerer, triggerer) ||
                other.triggerer == triggerer) &&
            (identical(other.shouldPassValue, shouldPassValue) ||
                other.shouldPassValue == shouldPassValue));
  }

  @override
  int get hashCode =>
      Object.hash(runtimeType, name, triggerer, shouldPassValue);

  @override
  String toString() {
    return 'Launcher(name: $name, triggerer: $triggerer, shouldPassValue: $shouldPassValue)';
  }
}

/// @nodoc
abstract mixin class $LauncherCopyWith<$Res> {
  factory $LauncherCopyWith(Launcher value, $Res Function(Launcher) _then) =
      _$LauncherCopyWithImpl;
  @useResult
  $Res call({String name, Trigger triggerer, bool shouldPassValue});
}

/// @nodoc
class _$LauncherCopyWithImpl<$Res> implements $LauncherCopyWith<$Res> {
  _$LauncherCopyWithImpl(this._self, this._then);

  final Launcher _self;
  final $Res Function(Launcher) _then;

  /// Create a copy of Launcher
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? name = null,
    Object? triggerer = null,
    Object? shouldPassValue = null,
  }) {
    return _then(_self.copyWith(
      name: null == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String,
      triggerer: null == triggerer
          ? _self.triggerer
          : triggerer // ignore: cast_nullable_to_non_nullable
              as Trigger,
      shouldPassValue: null == shouldPassValue
          ? _self.shouldPassValue
          : shouldPassValue // ignore: cast_nullable_to_non_nullable
              as bool,
    ));
  }
}

/// @nodoc

class _Launcher implements Launcher {
  const _Launcher(
      {required this.name,
      required this.triggerer,
      this.shouldPassValue = false});

  @override
  final String name;
  @override
  final Trigger triggerer;
  @override
  @JsonKey()
  final bool shouldPassValue;

  /// Create a copy of Launcher
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$LauncherCopyWith<_Launcher> get copyWith =>
      __$LauncherCopyWithImpl<_Launcher>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _Launcher &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.triggerer, triggerer) ||
                other.triggerer == triggerer) &&
            (identical(other.shouldPassValue, shouldPassValue) ||
                other.shouldPassValue == shouldPassValue));
  }

  @override
  int get hashCode =>
      Object.hash(runtimeType, name, triggerer, shouldPassValue);

  @override
  String toString() {
    return 'Launcher(name: $name, triggerer: $triggerer, shouldPassValue: $shouldPassValue)';
  }
}

/// @nodoc
abstract mixin class _$LauncherCopyWith<$Res>
    implements $LauncherCopyWith<$Res> {
  factory _$LauncherCopyWith(_Launcher value, $Res Function(_Launcher) _then) =
      __$LauncherCopyWithImpl;
  @override
  @useResult
  $Res call({String name, Trigger triggerer, bool shouldPassValue});
}

/// @nodoc
class __$LauncherCopyWithImpl<$Res> implements _$LauncherCopyWith<$Res> {
  __$LauncherCopyWithImpl(this._self, this._then);

  final _Launcher _self;
  final $Res Function(_Launcher) _then;

  /// Create a copy of Launcher
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? name = null,
    Object? triggerer = null,
    Object? shouldPassValue = null,
  }) {
    return _then(_Launcher(
      name: null == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String,
      triggerer: null == triggerer
          ? _self.triggerer
          : triggerer // ignore: cast_nullable_to_non_nullable
              as Trigger,
      shouldPassValue: null == shouldPassValue
          ? _self.shouldPassValue
          : shouldPassValue // ignore: cast_nullable_to_non_nullable
              as bool,
    ));
  }
}

// dart format on

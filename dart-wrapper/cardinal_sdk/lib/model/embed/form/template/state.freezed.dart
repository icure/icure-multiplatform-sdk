// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'state.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$State {
  String get name;
  StateToUpdate get stateToUpdate;
  bool get canLaunchLauncher;

  /// Create a copy of State
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $StateCopyWith<State> get copyWith =>
      _$StateCopyWithImpl<State>(this as State, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is State &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.stateToUpdate, stateToUpdate) ||
                other.stateToUpdate == stateToUpdate) &&
            (identical(other.canLaunchLauncher, canLaunchLauncher) ||
                other.canLaunchLauncher == canLaunchLauncher));
  }

  @override
  int get hashCode =>
      Object.hash(runtimeType, name, stateToUpdate, canLaunchLauncher);

  @override
  String toString() {
    return 'State(name: $name, stateToUpdate: $stateToUpdate, canLaunchLauncher: $canLaunchLauncher)';
  }
}

/// @nodoc
abstract mixin class $StateCopyWith<$Res> {
  factory $StateCopyWith(State value, $Res Function(State) _then) =
      _$StateCopyWithImpl;
  @useResult
  $Res call({String name, StateToUpdate stateToUpdate, bool canLaunchLauncher});
}

/// @nodoc
class _$StateCopyWithImpl<$Res> implements $StateCopyWith<$Res> {
  _$StateCopyWithImpl(this._self, this._then);

  final State _self;
  final $Res Function(State) _then;

  /// Create a copy of State
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? name = null,
    Object? stateToUpdate = null,
    Object? canLaunchLauncher = null,
  }) {
    return _then(_self.copyWith(
      name: null == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String,
      stateToUpdate: null == stateToUpdate
          ? _self.stateToUpdate
          : stateToUpdate // ignore: cast_nullable_to_non_nullable
              as StateToUpdate,
      canLaunchLauncher: null == canLaunchLauncher
          ? _self.canLaunchLauncher
          : canLaunchLauncher // ignore: cast_nullable_to_non_nullable
              as bool,
    ));
  }
}

/// @nodoc

class _State implements State {
  const _State(
      {required this.name,
      required this.stateToUpdate,
      this.canLaunchLauncher = false});

  @override
  final String name;
  @override
  final StateToUpdate stateToUpdate;
  @override
  @JsonKey()
  final bool canLaunchLauncher;

  /// Create a copy of State
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$StateCopyWith<_State> get copyWith =>
      __$StateCopyWithImpl<_State>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _State &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.stateToUpdate, stateToUpdate) ||
                other.stateToUpdate == stateToUpdate) &&
            (identical(other.canLaunchLauncher, canLaunchLauncher) ||
                other.canLaunchLauncher == canLaunchLauncher));
  }

  @override
  int get hashCode =>
      Object.hash(runtimeType, name, stateToUpdate, canLaunchLauncher);

  @override
  String toString() {
    return 'State(name: $name, stateToUpdate: $stateToUpdate, canLaunchLauncher: $canLaunchLauncher)';
  }
}

/// @nodoc
abstract mixin class _$StateCopyWith<$Res> implements $StateCopyWith<$Res> {
  factory _$StateCopyWith(_State value, $Res Function(_State) _then) =
      __$StateCopyWithImpl;
  @override
  @useResult
  $Res call({String name, StateToUpdate stateToUpdate, bool canLaunchLauncher});
}

/// @nodoc
class __$StateCopyWithImpl<$Res> implements _$StateCopyWith<$Res> {
  __$StateCopyWithImpl(this._self, this._then);

  final _State _self;
  final $Res Function(_State) _then;

  /// Create a copy of State
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? name = null,
    Object? stateToUpdate = null,
    Object? canLaunchLauncher = null,
  }) {
    return _then(_State(
      name: null == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String,
      stateToUpdate: null == stateToUpdate
          ? _self.stateToUpdate
          : stateToUpdate // ignore: cast_nullable_to_non_nullable
              as StateToUpdate,
      canLaunchLauncher: null == canLaunchLauncher
          ? _self.canLaunchLauncher
          : canLaunchLauncher // ignore: cast_nullable_to_non_nullable
              as bool,
    ));
  }
}

// dart format on

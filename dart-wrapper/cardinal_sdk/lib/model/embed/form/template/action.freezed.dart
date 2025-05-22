// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'action.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$Action {
  List<Launcher>? get launchers;
  String? get expression;
  List<State>? get states;

  /// Create a copy of Action
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $ActionCopyWith<Action> get copyWith =>
      _$ActionCopyWithImpl<Action>(this as Action, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is Action &&
            const DeepCollectionEquality().equals(other.launchers, launchers) &&
            (identical(other.expression, expression) ||
                other.expression == expression) &&
            const DeepCollectionEquality().equals(other.states, states));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      const DeepCollectionEquality().hash(launchers),
      expression,
      const DeepCollectionEquality().hash(states));

  @override
  String toString() {
    return 'Action(launchers: $launchers, expression: $expression, states: $states)';
  }
}

/// @nodoc
abstract mixin class $ActionCopyWith<$Res> {
  factory $ActionCopyWith(Action value, $Res Function(Action) _then) =
      _$ActionCopyWithImpl;
  @useResult
  $Res call(
      {List<Launcher>? launchers, String? expression, List<State>? states});
}

/// @nodoc
class _$ActionCopyWithImpl<$Res> implements $ActionCopyWith<$Res> {
  _$ActionCopyWithImpl(this._self, this._then);

  final Action _self;
  final $Res Function(Action) _then;

  /// Create a copy of Action
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? launchers = freezed,
    Object? expression = freezed,
    Object? states = freezed,
  }) {
    return _then(_self.copyWith(
      launchers: freezed == launchers
          ? _self.launchers
          : launchers // ignore: cast_nullable_to_non_nullable
              as List<Launcher>?,
      expression: freezed == expression
          ? _self.expression
          : expression // ignore: cast_nullable_to_non_nullable
              as String?,
      states: freezed == states
          ? _self.states
          : states // ignore: cast_nullable_to_non_nullable
              as List<State>?,
    ));
  }
}

/// @nodoc

class _Action implements Action {
  const _Action(
      {final List<Launcher>? launchers = const [],
      this.expression = null,
      final List<State>? states = const []})
      : _launchers = launchers,
        _states = states;

  final List<Launcher>? _launchers;
  @override
  @JsonKey()
  List<Launcher>? get launchers {
    final value = _launchers;
    if (value == null) return null;
    if (_launchers is EqualUnmodifiableListView) return _launchers;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(value);
  }

  @override
  @JsonKey()
  final String? expression;
  final List<State>? _states;
  @override
  @JsonKey()
  List<State>? get states {
    final value = _states;
    if (value == null) return null;
    if (_states is EqualUnmodifiableListView) return _states;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(value);
  }

  /// Create a copy of Action
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$ActionCopyWith<_Action> get copyWith =>
      __$ActionCopyWithImpl<_Action>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _Action &&
            const DeepCollectionEquality()
                .equals(other._launchers, _launchers) &&
            (identical(other.expression, expression) ||
                other.expression == expression) &&
            const DeepCollectionEquality().equals(other._states, _states));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      const DeepCollectionEquality().hash(_launchers),
      expression,
      const DeepCollectionEquality().hash(_states));

  @override
  String toString() {
    return 'Action(launchers: $launchers, expression: $expression, states: $states)';
  }
}

/// @nodoc
abstract mixin class _$ActionCopyWith<$Res> implements $ActionCopyWith<$Res> {
  factory _$ActionCopyWith(_Action value, $Res Function(_Action) _then) =
      __$ActionCopyWithImpl;
  @override
  @useResult
  $Res call(
      {List<Launcher>? launchers, String? expression, List<State>? states});
}

/// @nodoc
class __$ActionCopyWithImpl<$Res> implements _$ActionCopyWith<$Res> {
  __$ActionCopyWithImpl(this._self, this._then);

  final _Action _self;
  final $Res Function(_Action) _then;

  /// Create a copy of Action
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? launchers = freezed,
    Object? expression = freezed,
    Object? states = freezed,
  }) {
    return _then(_Action(
      launchers: freezed == launchers
          ? _self._launchers
          : launchers // ignore: cast_nullable_to_non_nullable
              as List<Launcher>?,
      expression: freezed == expression
          ? _self.expression
          : expression // ignore: cast_nullable_to_non_nullable
              as String?,
      states: freezed == states
          ? _self._states
          : states // ignore: cast_nullable_to_non_nullable
              as List<State>?,
    ));
  }
}

// dart format on

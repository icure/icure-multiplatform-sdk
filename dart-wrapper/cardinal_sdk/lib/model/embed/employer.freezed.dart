// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'employer.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$Employer {
  String? get name;
  DecryptedAddress? get addresse;

  /// Create a copy of Employer
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $EmployerCopyWith<Employer> get copyWith =>
      _$EmployerCopyWithImpl<Employer>(this as Employer, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is Employer &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.addresse, addresse) ||
                other.addresse == addresse));
  }

  @override
  int get hashCode => Object.hash(runtimeType, name, addresse);

  @override
  String toString() {
    return 'Employer(name: $name, addresse: $addresse)';
  }
}

/// @nodoc
abstract mixin class $EmployerCopyWith<$Res> {
  factory $EmployerCopyWith(Employer value, $Res Function(Employer) _then) =
      _$EmployerCopyWithImpl;
  @useResult
  $Res call({String? name, DecryptedAddress? addresse});

  $DecryptedAddressCopyWith<$Res>? get addresse;
}

/// @nodoc
class _$EmployerCopyWithImpl<$Res> implements $EmployerCopyWith<$Res> {
  _$EmployerCopyWithImpl(this._self, this._then);

  final Employer _self;
  final $Res Function(Employer) _then;

  /// Create a copy of Employer
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? name = freezed,
    Object? addresse = freezed,
  }) {
    return _then(_self.copyWith(
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      addresse: freezed == addresse
          ? _self.addresse
          : addresse // ignore: cast_nullable_to_non_nullable
              as DecryptedAddress?,
    ));
  }

  /// Create a copy of Employer
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $DecryptedAddressCopyWith<$Res>? get addresse {
    if (_self.addresse == null) {
      return null;
    }

    return $DecryptedAddressCopyWith<$Res>(_self.addresse!, (value) {
      return _then(_self.copyWith(addresse: value));
    });
  }
}

/// @nodoc

class _Employer implements Employer {
  const _Employer({this.name = null, this.addresse = null});

  @override
  @JsonKey()
  final String? name;
  @override
  @JsonKey()
  final DecryptedAddress? addresse;

  /// Create a copy of Employer
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$EmployerCopyWith<_Employer> get copyWith =>
      __$EmployerCopyWithImpl<_Employer>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _Employer &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.addresse, addresse) ||
                other.addresse == addresse));
  }

  @override
  int get hashCode => Object.hash(runtimeType, name, addresse);

  @override
  String toString() {
    return 'Employer(name: $name, addresse: $addresse)';
  }
}

/// @nodoc
abstract mixin class _$EmployerCopyWith<$Res>
    implements $EmployerCopyWith<$Res> {
  factory _$EmployerCopyWith(_Employer value, $Res Function(_Employer) _then) =
      __$EmployerCopyWithImpl;
  @override
  @useResult
  $Res call({String? name, DecryptedAddress? addresse});

  @override
  $DecryptedAddressCopyWith<$Res>? get addresse;
}

/// @nodoc
class __$EmployerCopyWithImpl<$Res> implements _$EmployerCopyWith<$Res> {
  __$EmployerCopyWithImpl(this._self, this._then);

  final _Employer _self;
  final $Res Function(_Employer) _then;

  /// Create a copy of Employer
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? name = freezed,
    Object? addresse = freezed,
  }) {
    return _then(_Employer(
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      addresse: freezed == addresse
          ? _self.addresse
          : addresse // ignore: cast_nullable_to_non_nullable
              as DecryptedAddress?,
    ));
  }

  /// Create a copy of Employer
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $DecryptedAddressCopyWith<$Res>? get addresse {
    if (_self.addresse == null) {
      return null;
    }

    return $DecryptedAddressCopyWith<$Res>(_self.addresse!, (value) {
      return _then(_self.copyWith(addresse: value));
    });
  }
}

// dart format on

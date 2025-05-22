// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'time_series.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$TimeSeries {
  List<String> get fields;
  List<List<double>> get samples;
  List<double> get min;
  List<double> get max;
  List<double> get mean;
  List<double> get median;
  List<double> get variance;

  /// Create a copy of TimeSeries
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $TimeSeriesCopyWith<TimeSeries> get copyWith =>
      _$TimeSeriesCopyWithImpl<TimeSeries>(this as TimeSeries, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is TimeSeries &&
            const DeepCollectionEquality().equals(other.fields, fields) &&
            const DeepCollectionEquality().equals(other.samples, samples) &&
            const DeepCollectionEquality().equals(other.min, min) &&
            const DeepCollectionEquality().equals(other.max, max) &&
            const DeepCollectionEquality().equals(other.mean, mean) &&
            const DeepCollectionEquality().equals(other.median, median) &&
            const DeepCollectionEquality().equals(other.variance, variance));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      const DeepCollectionEquality().hash(fields),
      const DeepCollectionEquality().hash(samples),
      const DeepCollectionEquality().hash(min),
      const DeepCollectionEquality().hash(max),
      const DeepCollectionEquality().hash(mean),
      const DeepCollectionEquality().hash(median),
      const DeepCollectionEquality().hash(variance));

  @override
  String toString() {
    return 'TimeSeries(fields: $fields, samples: $samples, min: $min, max: $max, mean: $mean, median: $median, variance: $variance)';
  }
}

/// @nodoc
abstract mixin class $TimeSeriesCopyWith<$Res> {
  factory $TimeSeriesCopyWith(
          TimeSeries value, $Res Function(TimeSeries) _then) =
      _$TimeSeriesCopyWithImpl;
  @useResult
  $Res call(
      {List<String> fields,
      List<List<double>> samples,
      List<double> min,
      List<double> max,
      List<double> mean,
      List<double> median,
      List<double> variance});
}

/// @nodoc
class _$TimeSeriesCopyWithImpl<$Res> implements $TimeSeriesCopyWith<$Res> {
  _$TimeSeriesCopyWithImpl(this._self, this._then);

  final TimeSeries _self;
  final $Res Function(TimeSeries) _then;

  /// Create a copy of TimeSeries
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? fields = null,
    Object? samples = null,
    Object? min = null,
    Object? max = null,
    Object? mean = null,
    Object? median = null,
    Object? variance = null,
  }) {
    return _then(_self.copyWith(
      fields: null == fields
          ? _self.fields
          : fields // ignore: cast_nullable_to_non_nullable
              as List<String>,
      samples: null == samples
          ? _self.samples
          : samples // ignore: cast_nullable_to_non_nullable
              as List<List<double>>,
      min: null == min
          ? _self.min
          : min // ignore: cast_nullable_to_non_nullable
              as List<double>,
      max: null == max
          ? _self.max
          : max // ignore: cast_nullable_to_non_nullable
              as List<double>,
      mean: null == mean
          ? _self.mean
          : mean // ignore: cast_nullable_to_non_nullable
              as List<double>,
      median: null == median
          ? _self.median
          : median // ignore: cast_nullable_to_non_nullable
              as List<double>,
      variance: null == variance
          ? _self.variance
          : variance // ignore: cast_nullable_to_non_nullable
              as List<double>,
    ));
  }
}

/// @nodoc

class _TimeSeries implements TimeSeries {
  const _TimeSeries(
      {final List<String> fields = const [],
      final List<List<double>> samples = const [],
      final List<double> min = const [],
      final List<double> max = const [],
      final List<double> mean = const [],
      final List<double> median = const [],
      final List<double> variance = const []})
      : _fields = fields,
        _samples = samples,
        _min = min,
        _max = max,
        _mean = mean,
        _median = median,
        _variance = variance;

  final List<String> _fields;
  @override
  @JsonKey()
  List<String> get fields {
    if (_fields is EqualUnmodifiableListView) return _fields;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_fields);
  }

  final List<List<double>> _samples;
  @override
  @JsonKey()
  List<List<double>> get samples {
    if (_samples is EqualUnmodifiableListView) return _samples;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_samples);
  }

  final List<double> _min;
  @override
  @JsonKey()
  List<double> get min {
    if (_min is EqualUnmodifiableListView) return _min;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_min);
  }

  final List<double> _max;
  @override
  @JsonKey()
  List<double> get max {
    if (_max is EqualUnmodifiableListView) return _max;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_max);
  }

  final List<double> _mean;
  @override
  @JsonKey()
  List<double> get mean {
    if (_mean is EqualUnmodifiableListView) return _mean;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_mean);
  }

  final List<double> _median;
  @override
  @JsonKey()
  List<double> get median {
    if (_median is EqualUnmodifiableListView) return _median;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_median);
  }

  final List<double> _variance;
  @override
  @JsonKey()
  List<double> get variance {
    if (_variance is EqualUnmodifiableListView) return _variance;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_variance);
  }

  /// Create a copy of TimeSeries
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$TimeSeriesCopyWith<_TimeSeries> get copyWith =>
      __$TimeSeriesCopyWithImpl<_TimeSeries>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _TimeSeries &&
            const DeepCollectionEquality().equals(other._fields, _fields) &&
            const DeepCollectionEquality().equals(other._samples, _samples) &&
            const DeepCollectionEquality().equals(other._min, _min) &&
            const DeepCollectionEquality().equals(other._max, _max) &&
            const DeepCollectionEquality().equals(other._mean, _mean) &&
            const DeepCollectionEquality().equals(other._median, _median) &&
            const DeepCollectionEquality().equals(other._variance, _variance));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      const DeepCollectionEquality().hash(_fields),
      const DeepCollectionEquality().hash(_samples),
      const DeepCollectionEquality().hash(_min),
      const DeepCollectionEquality().hash(_max),
      const DeepCollectionEquality().hash(_mean),
      const DeepCollectionEquality().hash(_median),
      const DeepCollectionEquality().hash(_variance));

  @override
  String toString() {
    return 'TimeSeries(fields: $fields, samples: $samples, min: $min, max: $max, mean: $mean, median: $median, variance: $variance)';
  }
}

/// @nodoc
abstract mixin class _$TimeSeriesCopyWith<$Res>
    implements $TimeSeriesCopyWith<$Res> {
  factory _$TimeSeriesCopyWith(
          _TimeSeries value, $Res Function(_TimeSeries) _then) =
      __$TimeSeriesCopyWithImpl;
  @override
  @useResult
  $Res call(
      {List<String> fields,
      List<List<double>> samples,
      List<double> min,
      List<double> max,
      List<double> mean,
      List<double> median,
      List<double> variance});
}

/// @nodoc
class __$TimeSeriesCopyWithImpl<$Res> implements _$TimeSeriesCopyWith<$Res> {
  __$TimeSeriesCopyWithImpl(this._self, this._then);

  final _TimeSeries _self;
  final $Res Function(_TimeSeries) _then;

  /// Create a copy of TimeSeries
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? fields = null,
    Object? samples = null,
    Object? min = null,
    Object? max = null,
    Object? mean = null,
    Object? median = null,
    Object? variance = null,
  }) {
    return _then(_TimeSeries(
      fields: null == fields
          ? _self._fields
          : fields // ignore: cast_nullable_to_non_nullable
              as List<String>,
      samples: null == samples
          ? _self._samples
          : samples // ignore: cast_nullable_to_non_nullable
              as List<List<double>>,
      min: null == min
          ? _self._min
          : min // ignore: cast_nullable_to_non_nullable
              as List<double>,
      max: null == max
          ? _self._max
          : max // ignore: cast_nullable_to_non_nullable
              as List<double>,
      mean: null == mean
          ? _self._mean
          : mean // ignore: cast_nullable_to_non_nullable
              as List<double>,
      median: null == median
          ? _self._median
          : median // ignore: cast_nullable_to_non_nullable
              as List<double>,
      variance: null == variance
          ? _self._variance
          : variance // ignore: cast_nullable_to_non_nullable
              as List<double>,
    ));
  }
}

// dart format on

// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'tarification.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$Tarification {
  String get id;
  String? get rev;
  int? get deletionDate;
  Map<String, String>? get label;
  String? get context;
  String? get type;
  String? get code;
  String? get version;
  String? get author;
  Set<String> get regions;
  List<Periodicity> get periodicity;
  int? get level;
  List<String> get links;
  Map<LinkQualification, List<String>> get qualifiedLinks;
  Set<CodeFlag> get flags;
  Map<String, Set<String>> get searchTerms;
  String? get data;
  Map<AppendixType, String> get appendices;
  bool get disabled;
  Set<DecryptedValorisation> get valorisations;
  Map<String, String> get category;
  bool? get consultationCode;
  bool? get hasRelatedCode;
  bool? get needsPrescriber;
  Set<String> get relatedCodes;
  String? get ngroup;
  List<LetterValue> get letterValues;

  /// Create a copy of Tarification
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $TarificationCopyWith<Tarification> get copyWith =>
      _$TarificationCopyWithImpl<Tarification>(
          this as Tarification, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is Tarification &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            const DeepCollectionEquality().equals(other.label, label) &&
            (identical(other.context, context) || other.context == context) &&
            (identical(other.type, type) || other.type == type) &&
            (identical(other.code, code) || other.code == code) &&
            (identical(other.version, version) || other.version == version) &&
            (identical(other.author, author) || other.author == author) &&
            const DeepCollectionEquality().equals(other.regions, regions) &&
            const DeepCollectionEquality()
                .equals(other.periodicity, periodicity) &&
            (identical(other.level, level) || other.level == level) &&
            const DeepCollectionEquality().equals(other.links, links) &&
            const DeepCollectionEquality()
                .equals(other.qualifiedLinks, qualifiedLinks) &&
            const DeepCollectionEquality().equals(other.flags, flags) &&
            const DeepCollectionEquality()
                .equals(other.searchTerms, searchTerms) &&
            (identical(other.data, data) || other.data == data) &&
            const DeepCollectionEquality()
                .equals(other.appendices, appendices) &&
            (identical(other.disabled, disabled) ||
                other.disabled == disabled) &&
            const DeepCollectionEquality()
                .equals(other.valorisations, valorisations) &&
            const DeepCollectionEquality().equals(other.category, category) &&
            (identical(other.consultationCode, consultationCode) ||
                other.consultationCode == consultationCode) &&
            (identical(other.hasRelatedCode, hasRelatedCode) ||
                other.hasRelatedCode == hasRelatedCode) &&
            (identical(other.needsPrescriber, needsPrescriber) ||
                other.needsPrescriber == needsPrescriber) &&
            const DeepCollectionEquality()
                .equals(other.relatedCodes, relatedCodes) &&
            (identical(other.ngroup, ngroup) || other.ngroup == ngroup) &&
            const DeepCollectionEquality()
                .equals(other.letterValues, letterValues));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        id,
        rev,
        deletionDate,
        const DeepCollectionEquality().hash(label),
        context,
        type,
        code,
        version,
        author,
        const DeepCollectionEquality().hash(regions),
        const DeepCollectionEquality().hash(periodicity),
        level,
        const DeepCollectionEquality().hash(links),
        const DeepCollectionEquality().hash(qualifiedLinks),
        const DeepCollectionEquality().hash(flags),
        const DeepCollectionEquality().hash(searchTerms),
        data,
        const DeepCollectionEquality().hash(appendices),
        disabled,
        const DeepCollectionEquality().hash(valorisations),
        const DeepCollectionEquality().hash(category),
        consultationCode,
        hasRelatedCode,
        needsPrescriber,
        const DeepCollectionEquality().hash(relatedCodes),
        ngroup,
        const DeepCollectionEquality().hash(letterValues)
      ]);

  @override
  String toString() {
    return 'Tarification(id: $id, rev: $rev, deletionDate: $deletionDate, label: $label, context: $context, type: $type, code: $code, version: $version, author: $author, regions: $regions, periodicity: $periodicity, level: $level, links: $links, qualifiedLinks: $qualifiedLinks, flags: $flags, searchTerms: $searchTerms, data: $data, appendices: $appendices, disabled: $disabled, valorisations: $valorisations, category: $category, consultationCode: $consultationCode, hasRelatedCode: $hasRelatedCode, needsPrescriber: $needsPrescriber, relatedCodes: $relatedCodes, ngroup: $ngroup, letterValues: $letterValues)';
  }
}

/// @nodoc
abstract mixin class $TarificationCopyWith<$Res> {
  factory $TarificationCopyWith(
          Tarification value, $Res Function(Tarification) _then) =
      _$TarificationCopyWithImpl;
  @useResult
  $Res call(
      {String id,
      String? rev,
      int? deletionDate,
      Map<String, String>? label,
      String? context,
      String? type,
      String? code,
      String? version,
      String? author,
      Set<String> regions,
      List<Periodicity> periodicity,
      int? level,
      List<String> links,
      Map<LinkQualification, List<String>> qualifiedLinks,
      Set<CodeFlag> flags,
      Map<String, Set<String>> searchTerms,
      String? data,
      Map<AppendixType, String> appendices,
      bool disabled,
      Set<DecryptedValorisation> valorisations,
      Map<String, String> category,
      bool? consultationCode,
      bool? hasRelatedCode,
      bool? needsPrescriber,
      Set<String> relatedCodes,
      String? ngroup,
      List<LetterValue> letterValues});
}

/// @nodoc
class _$TarificationCopyWithImpl<$Res> implements $TarificationCopyWith<$Res> {
  _$TarificationCopyWithImpl(this._self, this._then);

  final Tarification _self;
  final $Res Function(Tarification) _then;

  /// Create a copy of Tarification
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? deletionDate = freezed,
    Object? label = freezed,
    Object? context = freezed,
    Object? type = freezed,
    Object? code = freezed,
    Object? version = freezed,
    Object? author = freezed,
    Object? regions = null,
    Object? periodicity = null,
    Object? level = freezed,
    Object? links = null,
    Object? qualifiedLinks = null,
    Object? flags = null,
    Object? searchTerms = null,
    Object? data = freezed,
    Object? appendices = null,
    Object? disabled = null,
    Object? valorisations = null,
    Object? category = null,
    Object? consultationCode = freezed,
    Object? hasRelatedCode = freezed,
    Object? needsPrescriber = freezed,
    Object? relatedCodes = null,
    Object? ngroup = freezed,
    Object? letterValues = null,
  }) {
    return _then(_self.copyWith(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      rev: freezed == rev
          ? _self.rev
          : rev // ignore: cast_nullable_to_non_nullable
              as String?,
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      label: freezed == label
          ? _self.label
          : label // ignore: cast_nullable_to_non_nullable
              as Map<String, String>?,
      context: freezed == context
          ? _self.context
          : context // ignore: cast_nullable_to_non_nullable
              as String?,
      type: freezed == type
          ? _self.type
          : type // ignore: cast_nullable_to_non_nullable
              as String?,
      code: freezed == code
          ? _self.code
          : code // ignore: cast_nullable_to_non_nullable
              as String?,
      version: freezed == version
          ? _self.version
          : version // ignore: cast_nullable_to_non_nullable
              as String?,
      author: freezed == author
          ? _self.author
          : author // ignore: cast_nullable_to_non_nullable
              as String?,
      regions: null == regions
          ? _self.regions
          : regions // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      periodicity: null == periodicity
          ? _self.periodicity
          : periodicity // ignore: cast_nullable_to_non_nullable
              as List<Periodicity>,
      level: freezed == level
          ? _self.level
          : level // ignore: cast_nullable_to_non_nullable
              as int?,
      links: null == links
          ? _self.links
          : links // ignore: cast_nullable_to_non_nullable
              as List<String>,
      qualifiedLinks: null == qualifiedLinks
          ? _self.qualifiedLinks
          : qualifiedLinks // ignore: cast_nullable_to_non_nullable
              as Map<LinkQualification, List<String>>,
      flags: null == flags
          ? _self.flags
          : flags // ignore: cast_nullable_to_non_nullable
              as Set<CodeFlag>,
      searchTerms: null == searchTerms
          ? _self.searchTerms
          : searchTerms // ignore: cast_nullable_to_non_nullable
              as Map<String, Set<String>>,
      data: freezed == data
          ? _self.data
          : data // ignore: cast_nullable_to_non_nullable
              as String?,
      appendices: null == appendices
          ? _self.appendices
          : appendices // ignore: cast_nullable_to_non_nullable
              as Map<AppendixType, String>,
      disabled: null == disabled
          ? _self.disabled
          : disabled // ignore: cast_nullable_to_non_nullable
              as bool,
      valorisations: null == valorisations
          ? _self.valorisations
          : valorisations // ignore: cast_nullable_to_non_nullable
              as Set<DecryptedValorisation>,
      category: null == category
          ? _self.category
          : category // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      consultationCode: freezed == consultationCode
          ? _self.consultationCode
          : consultationCode // ignore: cast_nullable_to_non_nullable
              as bool?,
      hasRelatedCode: freezed == hasRelatedCode
          ? _self.hasRelatedCode
          : hasRelatedCode // ignore: cast_nullable_to_non_nullable
              as bool?,
      needsPrescriber: freezed == needsPrescriber
          ? _self.needsPrescriber
          : needsPrescriber // ignore: cast_nullable_to_non_nullable
              as bool?,
      relatedCodes: null == relatedCodes
          ? _self.relatedCodes
          : relatedCodes // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      ngroup: freezed == ngroup
          ? _self.ngroup
          : ngroup // ignore: cast_nullable_to_non_nullable
              as String?,
      letterValues: null == letterValues
          ? _self.letterValues
          : letterValues // ignore: cast_nullable_to_non_nullable
              as List<LetterValue>,
    ));
  }
}

/// @nodoc

class _Tarification implements Tarification {
  const _Tarification(
      {required this.id,
      this.rev = null,
      this.deletionDate = null,
      final Map<String, String>? label = null,
      this.context = null,
      this.type = null,
      this.code = null,
      this.version = null,
      this.author = null,
      final Set<String> regions = const {},
      final List<Periodicity> periodicity = const [],
      this.level = null,
      final List<String> links = const [],
      final Map<LinkQualification, List<String>> qualifiedLinks = const {},
      final Set<CodeFlag> flags = const {},
      final Map<String, Set<String>> searchTerms = const {},
      this.data = null,
      final Map<AppendixType, String> appendices = const {},
      this.disabled = false,
      final Set<DecryptedValorisation> valorisations = const {},
      final Map<String, String> category = const {},
      this.consultationCode = null,
      this.hasRelatedCode = null,
      this.needsPrescriber = null,
      final Set<String> relatedCodes = const {},
      this.ngroup = null,
      final List<LetterValue> letterValues = const []})
      : _label = label,
        _regions = regions,
        _periodicity = periodicity,
        _links = links,
        _qualifiedLinks = qualifiedLinks,
        _flags = flags,
        _searchTerms = searchTerms,
        _appendices = appendices,
        _valorisations = valorisations,
        _category = category,
        _relatedCodes = relatedCodes,
        _letterValues = letterValues;

  @override
  final String id;
  @override
  @JsonKey()
  final String? rev;
  @override
  @JsonKey()
  final int? deletionDate;
  final Map<String, String>? _label;
  @override
  @JsonKey()
  Map<String, String>? get label {
    final value = _label;
    if (value == null) return null;
    if (_label is EqualUnmodifiableMapView) return _label;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(value);
  }

  @override
  @JsonKey()
  final String? context;
  @override
  @JsonKey()
  final String? type;
  @override
  @JsonKey()
  final String? code;
  @override
  @JsonKey()
  final String? version;
  @override
  @JsonKey()
  final String? author;
  final Set<String> _regions;
  @override
  @JsonKey()
  Set<String> get regions {
    if (_regions is EqualUnmodifiableSetView) return _regions;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_regions);
  }

  final List<Periodicity> _periodicity;
  @override
  @JsonKey()
  List<Periodicity> get periodicity {
    if (_periodicity is EqualUnmodifiableListView) return _periodicity;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_periodicity);
  }

  @override
  @JsonKey()
  final int? level;
  final List<String> _links;
  @override
  @JsonKey()
  List<String> get links {
    if (_links is EqualUnmodifiableListView) return _links;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_links);
  }

  final Map<LinkQualification, List<String>> _qualifiedLinks;
  @override
  @JsonKey()
  Map<LinkQualification, List<String>> get qualifiedLinks {
    if (_qualifiedLinks is EqualUnmodifiableMapView) return _qualifiedLinks;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_qualifiedLinks);
  }

  final Set<CodeFlag> _flags;
  @override
  @JsonKey()
  Set<CodeFlag> get flags {
    if (_flags is EqualUnmodifiableSetView) return _flags;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_flags);
  }

  final Map<String, Set<String>> _searchTerms;
  @override
  @JsonKey()
  Map<String, Set<String>> get searchTerms {
    if (_searchTerms is EqualUnmodifiableMapView) return _searchTerms;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_searchTerms);
  }

  @override
  @JsonKey()
  final String? data;
  final Map<AppendixType, String> _appendices;
  @override
  @JsonKey()
  Map<AppendixType, String> get appendices {
    if (_appendices is EqualUnmodifiableMapView) return _appendices;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_appendices);
  }

  @override
  @JsonKey()
  final bool disabled;
  final Set<DecryptedValorisation> _valorisations;
  @override
  @JsonKey()
  Set<DecryptedValorisation> get valorisations {
    if (_valorisations is EqualUnmodifiableSetView) return _valorisations;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_valorisations);
  }

  final Map<String, String> _category;
  @override
  @JsonKey()
  Map<String, String> get category {
    if (_category is EqualUnmodifiableMapView) return _category;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_category);
  }

  @override
  @JsonKey()
  final bool? consultationCode;
  @override
  @JsonKey()
  final bool? hasRelatedCode;
  @override
  @JsonKey()
  final bool? needsPrescriber;
  final Set<String> _relatedCodes;
  @override
  @JsonKey()
  Set<String> get relatedCodes {
    if (_relatedCodes is EqualUnmodifiableSetView) return _relatedCodes;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_relatedCodes);
  }

  @override
  @JsonKey()
  final String? ngroup;
  final List<LetterValue> _letterValues;
  @override
  @JsonKey()
  List<LetterValue> get letterValues {
    if (_letterValues is EqualUnmodifiableListView) return _letterValues;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_letterValues);
  }

  /// Create a copy of Tarification
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$TarificationCopyWith<_Tarification> get copyWith =>
      __$TarificationCopyWithImpl<_Tarification>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _Tarification &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            const DeepCollectionEquality().equals(other._label, _label) &&
            (identical(other.context, context) || other.context == context) &&
            (identical(other.type, type) || other.type == type) &&
            (identical(other.code, code) || other.code == code) &&
            (identical(other.version, version) || other.version == version) &&
            (identical(other.author, author) || other.author == author) &&
            const DeepCollectionEquality().equals(other._regions, _regions) &&
            const DeepCollectionEquality()
                .equals(other._periodicity, _periodicity) &&
            (identical(other.level, level) || other.level == level) &&
            const DeepCollectionEquality().equals(other._links, _links) &&
            const DeepCollectionEquality()
                .equals(other._qualifiedLinks, _qualifiedLinks) &&
            const DeepCollectionEquality().equals(other._flags, _flags) &&
            const DeepCollectionEquality()
                .equals(other._searchTerms, _searchTerms) &&
            (identical(other.data, data) || other.data == data) &&
            const DeepCollectionEquality()
                .equals(other._appendices, _appendices) &&
            (identical(other.disabled, disabled) ||
                other.disabled == disabled) &&
            const DeepCollectionEquality()
                .equals(other._valorisations, _valorisations) &&
            const DeepCollectionEquality().equals(other._category, _category) &&
            (identical(other.consultationCode, consultationCode) ||
                other.consultationCode == consultationCode) &&
            (identical(other.hasRelatedCode, hasRelatedCode) ||
                other.hasRelatedCode == hasRelatedCode) &&
            (identical(other.needsPrescriber, needsPrescriber) ||
                other.needsPrescriber == needsPrescriber) &&
            const DeepCollectionEquality()
                .equals(other._relatedCodes, _relatedCodes) &&
            (identical(other.ngroup, ngroup) || other.ngroup == ngroup) &&
            const DeepCollectionEquality()
                .equals(other._letterValues, _letterValues));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        id,
        rev,
        deletionDate,
        const DeepCollectionEquality().hash(_label),
        context,
        type,
        code,
        version,
        author,
        const DeepCollectionEquality().hash(_regions),
        const DeepCollectionEquality().hash(_periodicity),
        level,
        const DeepCollectionEquality().hash(_links),
        const DeepCollectionEquality().hash(_qualifiedLinks),
        const DeepCollectionEquality().hash(_flags),
        const DeepCollectionEquality().hash(_searchTerms),
        data,
        const DeepCollectionEquality().hash(_appendices),
        disabled,
        const DeepCollectionEquality().hash(_valorisations),
        const DeepCollectionEquality().hash(_category),
        consultationCode,
        hasRelatedCode,
        needsPrescriber,
        const DeepCollectionEquality().hash(_relatedCodes),
        ngroup,
        const DeepCollectionEquality().hash(_letterValues)
      ]);

  @override
  String toString() {
    return 'Tarification(id: $id, rev: $rev, deletionDate: $deletionDate, label: $label, context: $context, type: $type, code: $code, version: $version, author: $author, regions: $regions, periodicity: $periodicity, level: $level, links: $links, qualifiedLinks: $qualifiedLinks, flags: $flags, searchTerms: $searchTerms, data: $data, appendices: $appendices, disabled: $disabled, valorisations: $valorisations, category: $category, consultationCode: $consultationCode, hasRelatedCode: $hasRelatedCode, needsPrescriber: $needsPrescriber, relatedCodes: $relatedCodes, ngroup: $ngroup, letterValues: $letterValues)';
  }
}

/// @nodoc
abstract mixin class _$TarificationCopyWith<$Res>
    implements $TarificationCopyWith<$Res> {
  factory _$TarificationCopyWith(
          _Tarification value, $Res Function(_Tarification) _then) =
      __$TarificationCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String id,
      String? rev,
      int? deletionDate,
      Map<String, String>? label,
      String? context,
      String? type,
      String? code,
      String? version,
      String? author,
      Set<String> regions,
      List<Periodicity> periodicity,
      int? level,
      List<String> links,
      Map<LinkQualification, List<String>> qualifiedLinks,
      Set<CodeFlag> flags,
      Map<String, Set<String>> searchTerms,
      String? data,
      Map<AppendixType, String> appendices,
      bool disabled,
      Set<DecryptedValorisation> valorisations,
      Map<String, String> category,
      bool? consultationCode,
      bool? hasRelatedCode,
      bool? needsPrescriber,
      Set<String> relatedCodes,
      String? ngroup,
      List<LetterValue> letterValues});
}

/// @nodoc
class __$TarificationCopyWithImpl<$Res>
    implements _$TarificationCopyWith<$Res> {
  __$TarificationCopyWithImpl(this._self, this._then);

  final _Tarification _self;
  final $Res Function(_Tarification) _then;

  /// Create a copy of Tarification
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? deletionDate = freezed,
    Object? label = freezed,
    Object? context = freezed,
    Object? type = freezed,
    Object? code = freezed,
    Object? version = freezed,
    Object? author = freezed,
    Object? regions = null,
    Object? periodicity = null,
    Object? level = freezed,
    Object? links = null,
    Object? qualifiedLinks = null,
    Object? flags = null,
    Object? searchTerms = null,
    Object? data = freezed,
    Object? appendices = null,
    Object? disabled = null,
    Object? valorisations = null,
    Object? category = null,
    Object? consultationCode = freezed,
    Object? hasRelatedCode = freezed,
    Object? needsPrescriber = freezed,
    Object? relatedCodes = null,
    Object? ngroup = freezed,
    Object? letterValues = null,
  }) {
    return _then(_Tarification(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      rev: freezed == rev
          ? _self.rev
          : rev // ignore: cast_nullable_to_non_nullable
              as String?,
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      label: freezed == label
          ? _self._label
          : label // ignore: cast_nullable_to_non_nullable
              as Map<String, String>?,
      context: freezed == context
          ? _self.context
          : context // ignore: cast_nullable_to_non_nullable
              as String?,
      type: freezed == type
          ? _self.type
          : type // ignore: cast_nullable_to_non_nullable
              as String?,
      code: freezed == code
          ? _self.code
          : code // ignore: cast_nullable_to_non_nullable
              as String?,
      version: freezed == version
          ? _self.version
          : version // ignore: cast_nullable_to_non_nullable
              as String?,
      author: freezed == author
          ? _self.author
          : author // ignore: cast_nullable_to_non_nullable
              as String?,
      regions: null == regions
          ? _self._regions
          : regions // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      periodicity: null == periodicity
          ? _self._periodicity
          : periodicity // ignore: cast_nullable_to_non_nullable
              as List<Periodicity>,
      level: freezed == level
          ? _self.level
          : level // ignore: cast_nullable_to_non_nullable
              as int?,
      links: null == links
          ? _self._links
          : links // ignore: cast_nullable_to_non_nullable
              as List<String>,
      qualifiedLinks: null == qualifiedLinks
          ? _self._qualifiedLinks
          : qualifiedLinks // ignore: cast_nullable_to_non_nullable
              as Map<LinkQualification, List<String>>,
      flags: null == flags
          ? _self._flags
          : flags // ignore: cast_nullable_to_non_nullable
              as Set<CodeFlag>,
      searchTerms: null == searchTerms
          ? _self._searchTerms
          : searchTerms // ignore: cast_nullable_to_non_nullable
              as Map<String, Set<String>>,
      data: freezed == data
          ? _self.data
          : data // ignore: cast_nullable_to_non_nullable
              as String?,
      appendices: null == appendices
          ? _self._appendices
          : appendices // ignore: cast_nullable_to_non_nullable
              as Map<AppendixType, String>,
      disabled: null == disabled
          ? _self.disabled
          : disabled // ignore: cast_nullable_to_non_nullable
              as bool,
      valorisations: null == valorisations
          ? _self._valorisations
          : valorisations // ignore: cast_nullable_to_non_nullable
              as Set<DecryptedValorisation>,
      category: null == category
          ? _self._category
          : category // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      consultationCode: freezed == consultationCode
          ? _self.consultationCode
          : consultationCode // ignore: cast_nullable_to_non_nullable
              as bool?,
      hasRelatedCode: freezed == hasRelatedCode
          ? _self.hasRelatedCode
          : hasRelatedCode // ignore: cast_nullable_to_non_nullable
              as bool?,
      needsPrescriber: freezed == needsPrescriber
          ? _self.needsPrescriber
          : needsPrescriber // ignore: cast_nullable_to_non_nullable
              as bool?,
      relatedCodes: null == relatedCodes
          ? _self._relatedCodes
          : relatedCodes // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      ngroup: freezed == ngroup
          ? _self.ngroup
          : ngroup // ignore: cast_nullable_to_non_nullable
              as String?,
      letterValues: null == letterValues
          ? _self._letterValues
          : letterValues // ignore: cast_nullable_to_non_nullable
              as List<LetterValue>,
    ));
  }
}

// dart format on

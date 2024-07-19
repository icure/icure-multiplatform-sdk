from typing import List, Optional

from icure import IcureSdk
from icure.filters.AbstractFilterBuilder import AbstractFilterBuilder
from icure.model import PatientAbstractFilter, ComplementFilter, PatientByIdsFilter, \
    PatientByHcPartyAndIdentifiersFilter, PatientByHcPartyAndSsinsFilter, PatientByHcPartyAndSsinFilter, Identifier, \
    PatientByHcPartyDateOfBirthBetweenFilter, Patient, PatientByHcPartyNameContainsFuzzyFilter, \
    PatientByHcPartyGenderEducationProfession, PatientByHcPartyFilter, PatientByHcPartyAndActiveFilter, \
    PatientByHcPartyAndAddressFilter, PatientByHcPartyAndExternalIdFilter, \
    PatientByHcPartyAndTelecomFilter, PatientByHcPartyDateOfBirthFilter


class PatientFilters:
    """
    Factory and builder for creating patient filters.
    """

    @classmethod
    def complement_filter(cls, super_set: PatientAbstractFilter, sub_set: PatientAbstractFilter) -> PatientAbstractFilter:
        """
        :param super_set: a filter
        :param sub_set: a filter
        :return: A filter that provides all entities that are in super_set but not in subset. The result will preserve
        the same ordering it had in the super_set.
        """
        return ComplementFilter(super_set=super_set, sub_set=sub_set)

    @classmethod
    def all_patients_for_self_filter(
            cls,
            sdk: IcureSdk
    ) -> PatientAbstractFilter:
        """
        :param sdk: the sdk, used to get the id of the current data owner
        :return: A filter to get all patients accessible to the current data owner
        """
        return PatientByHcPartyFilter(sdk.data_owner.get_current_data_owner_id_blocking())

    @classmethod
    def all_patients_for_data_owner_filter(
            cls,
            data_owner_id: str
    ) -> PatientAbstractFilter:
        """
        :param data_owner_id: a data owner id. Note that you may need some special permissions to use the filter if the
        data owner id is not the current data owner.
        :return: A filter to get all patients accessible to the specified data owner
        """
        return PatientByHcPartyFilter(data_owner_id)

    class Builder(AbstractFilterBuilder[PatientAbstractFilter, 'PatientFilters.Builder']):
        """
        Allows to build complex filters for patients
        """

        def __init__(self, sdk: IcureSdk, data_owner_id: Optional[str] = None):
            """
            Initializes the filter builder
            :param sdk: the sdk, used to get some contextual information when needed.
            :param data_owner_id: id of a data owner to use in the filter. For most filters only data that is accessible to
            that data owner will be returned. If None will use the id of the data owner logged into the sdk.
            """
            self.__sdk = sdk
            self.__data_owner_id = data_owner_id if data_owner_id is not None else sdk.data_owner.get_current_data_owner_id_blocking()

        def by_ids(self, ids: List[str], sort: bool = False) -> 'PatientFilters.Builder':
            """
            The filter will return all patients with one of the provided ids. This filter ignores the data_owner_id of the
            builder.
            :param ids: a list of ids.
            :param sort: if True the data obtained through this filter will be returned in the same order as the input ids.
            :raises ValueError: if sort is True and another filter was previously set as the sort key.
            :return: self
            """
            return self._add_filter(
                PatientByIdsFilter(ids),
                sort
            )

        def by_identifiers(self, identifiers: List[Identifier], sort: bool = False) -> 'PatientFilters.Builder':
            """
            The filter will return all the entities that have at least one of the specified identifiers. The system and
            value of an identifier must match exactly for an entity to be returned by this filter (other properties
            of the identifier are ignored).
            :param identifiers: a list of identifiers
            :param sort: if True the data obtained through this filter will be returned in the same order as the input
            identifiers. In case an entity has multiple identifiers only the first matching identifier will be
            considered.
            :raises ValueError: if sort is True and another filter was previously set as the sort key.
            :return: self
            """
            return self._add_filter(
                PatientByHcPartyAndIdentifiersFilter(
                    identifiers=identifiers,
                    healthcare_party_id=self.__data_owner_id
                ),
                sort
            )

        def with_ssins(self, ssins: List[str], sort: bool = False) -> 'PatientFilters.Builder':
            """
            The filter will return all the patients where the ssin is one of the specified ones.
            :param ssins: a list of ssins
            :param sort: if True the data obtained through this filter will be returned in the same order as the input
            ssins.
            :raises ValueError: if sort is True and another filter was previously set as the sort key.
            :return: self
            """
            if len(ssins) == 1:
                return self._add_filter(
                    PatientByHcPartyAndSsinFilter(
                        ssin=ssins[0],
                        healthcare_party_id=self.__data_owner_id
                    ),
                    sort
                )
            else:
                return self._add_filter(
                    PatientByHcPartyAndSsinsFilter(
                        ssins=ssins.copy(),
                        healthcare_party_id=self.__data_owner_id
                    ),
                    sort
                )

        def date_of_birth_between(self, from_date: int, to_date: int, sort: bool = False) -> 'PatientFilters.Builder':
            """
            Includes all the patients with date of birth between from_date and to_date.
            :param from_date: the start date in YYYYMMDD format
            :param to_date: the end date in YYYYMMDD format
            :param sort: if true the data obtained through this filter result will be ordered by the patient date of birth.
            :raises ValueError: if sort is True and another filter was previously set as the sort key
            :return: self
            """
            if from_date == to_date:
                return self._add_filter(
                    PatientByHcPartyDateOfBirthBetweenFilter(
                        min_date_of_birth=from_date,
                        max_date_of_birth=to_date,
                        healthcare_party_id=self.__data_owner_id
                    ),
                    sort
                )
            else:
                return self._add_filter(
                    PatientByHcPartyDateOfBirthFilter(
                        date_of_birth=from_date,
                        healthcare_party_id=self.__data_owner_id
                    ),
                    sort
                )

        def contains_fuzzy(self, search_string: str, sort: bool = False) -> 'PatientFilters.Builder':
            """
            Includes all the patients which first name, last name, maiden name or spouse name matches, even partially,
            the search_string
            :param search_string: part of a patient name
            :param sort: if true the data obtained through this filter result will be ordered by the patient names
            :raises ValueError: if sort is True and another filter was previously set as the sort key.
            :return: self
            """
            return self._add_filter(
                PatientByHcPartyNameContainsFuzzyFilter(
                    search_string=search_string,
                    healthcare_party_id=self.__data_owner_id
                ),
                sort
            )

        def by_gender_education_profession(self, gender: Patient.GenderEnum, education: Optional[str], profession: Optional[str], sort: bool = False) -> 'PatientFilters.Builder':
            """
            Includes all the patients which gender, education, and profession are the ones specified.
            :param gender: the gender of the patients to include.
            :param education: the education of the patients to include. If None, it will be ignored (matches any).
            :param profession: the profession of the patients to include. If None, it will be ignored (matches any).
            Must be None if education is None
            :param sort: if true the data obtained through this filter will be ordered first by education then profession.
            Must be false if both education and profession are not None.
            :raises ValueError: if sort is True and another filter was previously set as the sort key, or if sort is True and
            both education and profession have a value that is not None.
            :return: self
            """
            if sort and education is not None and profession is not None:
                raise ValueError("No need to sort if education and profession are both fixed values")
            if profession is not None and education is None:
                raise ValueError("If you want to specify profession you must also specify education")
            return self._add_filter(
                PatientByHcPartyGenderEducationProfession(
                    gender=gender,
                    education=education,
                    profession=profession,
                    healthcare_party_id=self.__data_owner_id
                ),
                sort
            )

        def is_active(self, active: bool) -> 'PatientFilters.Builder':
            """
            Filters all patients where the `active` field is set to the provided value
            :param active:
            :return: self
            """
            return self._add_filter(
                PatientByHcPartyAndActiveFilter(
                    active=active,
                    healthcare_party_id=self.__data_owner_id
                ),
                False
            )

        def with_telecom(self, search_string: str, sort: bool = False) -> 'PatientFilters.Builder':
            """
            Finds all patient where there is at least an address with a telecom number (e.g. email or phone number) that
            starts with the search_string. Ignores non-alphanumeric characters.
            :param search_string: the beginning of the telecom number
            :param sort: if True the resulting patients will be sorted lexicographically by telecom number. In case of
            patients with multiple telecom numbers only the first matching number is considered.
            :raises ValueError: if sort is True and another filter was previously set as the sort key
            :return: self
            """
            return self._add_filter(
                PatientByHcPartyAndTelecomFilter(
                    search_string=search_string,
                    healthcare_party_id=self.__data_owner_id
                ),
                sort
            )

        def with_address_postal_code_house_number(self, search_string: str, postal_code: str, house_number: Optional[str], sort: bool = False) -> 'PatientFilters.Builder':
            """
            Find all users with at least an address that matches the provided parameters.
            :param search_string: a prefix of the normalized street+city to search for.
            :param postal_code: a postal code prefix.
            :param house_number: a house number prefix.
            :param sort: if True the resulting patients will be sorted lexicographically first by street+city, then postal
            code and finally house number. In case of patients with multiple address only the first matching address is
            considered.
            :raises ValueError: if sort is True and another filter was previously set as the sort key
            :return: self
            """
            return self._add_filter(
                PatientByHcPartyAndAddressFilter(
                    search_string=search_string,
                    postal_code=postal_code,
                    house_number=house_number,
                    healthcare_party_id=self.__data_owner_id
                ),
                sort
            )

        def with_address(self, search_string: str, sort: bool = False) -> 'PatientFilters.Builder':
            """
            Find all users with at least an address that matches the provided parameters.
            :param search_string: a prefix of the normalized street+postal_code+city to search for.
            :param sort: if True the resulting patients will be sorted lexicographically by street+postal_code+city. In case
            of patients with multiple address only the first matching address is considered.
            :raises ValueError: if sort is True and another filter was previously set as the sort key
            :return: self
            """
            return self._add_filter(
                PatientByHcPartyAndAddressFilter(
                    search_string=search_string,
                    postal_code=None,
                    house_number=None,
                    healthcare_party_id=self.__data_owner_id
                ),
                sort
            )

        def with_external_id(self, external_id: str, sort: bool=False) -> 'PatientFilters.Builder':
            """
            Find all patients with an `external_id` starting with the provided id
            :param external_id: a prefix for the external id
            :param sort: if True in case multiple patients start with the provided external id prefix the result will be
            sorted by the lexicographic order of the full external id of each patient.
            :raises ValueError: if sort is True and another filter was previously set as the sort key
            :return: self
            """
            return self._add_filter(
                PatientByHcPartyAndExternalIdFilter(
                    external_id=external_id,
                    healthcare_party_id=self.__data_owner_id
                ),
                sort
            )

from typing import List

from icure.filters.AbstractFilterBuilder import AbstractFilterBuilder
from icure.model import UserAbstractFilter, ComplementFilter, AllUsersFilter, UsersByPatientIdFilter, UserByIdsFilter, \
    UserByNameEmailPhoneFilter


class UserFilters:
    @classmethod
    def complement_filter(cls, super_set: UserAbstractFilter, sub_set: UserAbstractFilter) -> UserAbstractFilter:
        """
        :param super_set: a filter
        :param sub_set: a filter
        :return: A filter that provides all entities that are in super_set but not in subset. The result will preserve
        the same ordering it had in the super_set.
        """
        return ComplementFilter(super_set=super_set, sub_set=sub_set)

    @classmethod
    def all_users_filter(cls) -> UserAbstractFilter:
        """
        :return: A filter to get all users
        """
        return AllUsersFilter()

    class Builder(AbstractFilterBuilder[UserAbstractFilter, 'UserFilters.Builder']):
        """
        Allows to build complex filters for users
        """

        def by_ids(self, ids: List[str], sort: bool = False) -> 'UserFilters.Builder':
            """
            The filter will return all users with one of the provided ids.
            :param ids: a list of ids.
            :param sort: if True the data obtained through this filter will be returned in the same order as the input ids.
            :raises ValueError: if sort is True and another filter was previously set as the sort key.
            :return: self
            """
            return self._add_filter(
                UserByIdsFilter(ids),
                sort
            )

        def users_by_patient_id_filter(self, patient_id: str) -> 'UserFilters.Builder':
            """
            The filter gets user that are linked to a certain patient id
            :param patient_id: a patient id
            :return: self
            """
            return self._add_filter(
                UsersByPatientIdFilter(patient_id=patient_id),
                False
            )

        def user_by_name_email_or_phone(self, search_string: str, sort: bool = False) -> 'UserFilters.Builder':
            """
            The filter gets users that have a word starting with search_string in login, name, email or mobile_phone.
            :param search_string: a prefix to a word in the login, name, email or mobile_phone of users
            :param sort: if True the data obtained through this filter will be sorted by the matched string. In case of
            multiple matches for an entity only the first will be considered.
            :raises ValueError: if sort is True and another filter was previously set as the sort key.
            :return: self
            """
            return self._add_filter(
                UserByNameEmailPhoneFilter(search_string=search_string),
                sort
            )

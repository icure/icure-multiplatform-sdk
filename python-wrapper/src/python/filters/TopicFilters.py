from typing import Optional

from icure import IcureSdk
from icure.filters.AbstractFilterBuilder import AbstractFilterBuilder
from icure.model import TopicAbstractFilter, ComplementFilter, TopicByHcPartyFilter, TopicByParticipantFilter


class TopicFilters:
    """
    Factory and builder for creating topic filters.
    """

    @classmethod
    def complement_filter(cls, super_set: TopicAbstractFilter, sub_set: TopicAbstractFilter) -> TopicAbstractFilter:
        """
        :param super_set: a filter
        :param sub_set: a filter
        :return: A filter that provides all entities that are in super_set but not in subset. The result will preserve
        the same ordering it had in the super_set.
        """
        return ComplementFilter(super_set=super_set, sub_set=sub_set)

    @classmethod
    def all_topics_for_self_filter(
            cls,
            sdk: IcureSdk
    ) -> TopicAbstractFilter:
        """
        :param sdk: the sdk, used to get the id of the current data owner
        :return: A filter to get all topics accessible to the current data owner
        """
        return TopicByHcPartyFilter(sdk.data_owner.get_current_data_owner_id_blocking())

    @classmethod
    def all_topics_for_data_owner_filter(
            cls,
            data_owner_id: str
    ) -> TopicAbstractFilter:
        """
        :param data_owner_id: a data owner id. Note that you may need some special permissions to use the filter if the
        data owner id is not the current data owner.
        :return: A filter to get all patients accessible to the specified data owner
        """
        return TopicByHcPartyFilter(data_owner_id)

    class Builder(AbstractFilterBuilder[TopicAbstractFilter, 'TopicFilters.Builder']):
        """
        Allows to build complex filters for topics
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

        def by_participant(self, participant_id: str) -> 'TopicFilters.Builder':
            """
            Returns all the topics where the data owner passed as parameter is an active participant.
            :param participant_id: the id of the data owner.
            :return: self
            """
            return self._add_filter(
                TopicByParticipantFilter(participant_id),
                False
            )

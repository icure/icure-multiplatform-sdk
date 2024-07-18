from typing import Optional
from icure.filters.AbstractFilterBuilder import AbstractFilterBuilder
from icure.model import MessageAbstractFilter, ComplementFilter, MessageByHcPartyFilter, LatestMessageByHcPartyTransportGuidFilter
from icure import IcureSdk

class MessageFilters:
    @classmethod
    def complement_filter(cls, super_set: MessageAbstractFilter, sub_set: MessageAbstractFilter) -> MessageAbstractFilter:
        """
        :param super_set: a filter
        :param sub_set: a filter
        :return: A filter that provides all entities that are in super_set but not in subset. The result will preserve
        the same ordering it had in the super_set.
        """
        return ComplementFilter(super_set=super_set, sub_set=sub_set)

    @classmethod
    def all_messages_for_self_filter(
        cls,
        sdk: IcureSdk
    ) -> MessageAbstractFilter:
        """
        :param sdk: the sdk, used to get the id of the current data owner
        :return: A filter to get all messages accessible to the current data owner
        """
        return MessageByHcPartyFilter(hcp_id=sdk.data_owner.get_current_data_owner_id_blocking())

    @classmethod
    def all_messages_for_data_owner_filter(
        cls,
        data_owner_id: str
    ) -> MessageAbstractFilter:
        """
        :param data_owner_id: a data owner id. Note that you may need some special permissions to use the filter if the
        data owner id is not the current data owner.
        :return: A filter to get all messages accessible to the specified data owner
        """
        return MessageByHcPartyFilter(hcp_id=data_owner_id)

    class Builder(AbstractFilterBuilder[MessageAbstractFilter, 'MessageFilters.Builder']):
        """
        Allows to build complex filters for messages
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

        def by_transport_guid_date(self, transport_guid: str, sort: bool = False) -> 'MessageFilters.Builder':
            """
            Get all messages with a certain transport guid
            :param transport_guid: a transport guid, must match exactly
            :param sort: if True the result will be sorted by the creation date of the message
            :return: self
            """
            return self._add_filter(
                LatestMessageByHcPartyTransportGuidFilter(
                    transport_guid=transport_guid,
                    healthcare_party_id=self.__data_owner_id
                ),
                sort
            )

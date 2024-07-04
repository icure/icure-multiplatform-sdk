from icure.model.SingletonMeta import SingletonMeta


class FileSystemStorage(metaclass=SingletonMeta):

    def __serialize__(self) -> object:
        return {"type": "FileSystemStorage"}

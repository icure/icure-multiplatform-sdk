class GenericCardinalError(Exception):
    def __init__(self, message):
        super().__init__(message)

class RevisionConflictError(Exception):
    def __init__(self, message):
        super().__init__(message)
import json
from cardinal_sdk.errors import RevisionConflictError, GenericCardinalError

class CallResult:
    def __init__(self, success=None, failure=None):
        self.success = success
        self.failure = failure

    def __str__(self):
        return f"Success: {self.success}, Failure: {self.failure}"

def create_result_from_json(json_str):
    data = json.loads(json_str)
    if 'success' in data:
        return CallResult(success=data['success'])
    elif 'failure' in data:
        return CallResult(failure=data['failure'])
    else:
        raise Error("Invalid JSON string. Must contain either 'success' or 'failure'.")

def interpret_kt_error(error_json):
    type = error_json['type']
    stack = error_json['stack']
    if type == 'kotlin.IllegalArgumentException':
        return ValueError(stack)
    elif type == 'com.icure.cardinal.sdk.exceptions.RevisionConflictException':
        return RevisionConflictError(stack)
    else:
        return GenericCardinalError(stack)
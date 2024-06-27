import json

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
        raise ValueError("Invalid JSON string. Must contain either 'success' or 'failure'.")
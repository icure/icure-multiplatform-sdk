from dataclasses import dataclass


@dataclass
class UsernamePassword:
    username: str
    password: str

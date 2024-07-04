from dataclasses import dataclass


@dataclass
class UsernamePassword:
    username: str
    password: str

    def __serialize__(self) -> object:
        return {
            "username": self.username,
            "password": self.password,
            "type": "UsernamePasswordAuthentication"
        }

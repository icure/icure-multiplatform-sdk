import platform
from ctypes import CDLL
from importlib.resources import path

arch = platform.machine()
system = platform.system().lower()
lib_file_name = None

if system == 'linux' and arch == 'x86_64':
    lib_file_name = 'icure-sdk-linuxX64.so'
elif system == 'darwin' and arch == 'x86_64':
    lib_file_name = 'icure-sdk-macosX64.dylib'
elif system == 'darwin' and arch == 'arm64':
    lib_file_name = 'icure-sdk-macosArm64.dylib'
else:
    raise Exception(f"Your system ({system} {arch}) is not compatible with this version of the iCure SDK")

with path('icure.lib', lib_file_name) as lib_path:
    kdll = CDLL(str(lib_path))

import platform
from ctypes import CDLL

arch = platform.machine()
system = platform.system().lower()

if system == 'linux' and arch == 'x86_64':
    kdll = CDLL('../../build/bin/macosArm64/releaseShared/libicure_sdk_native_pylib.dylib')
elif system == 'darwin' and arch == 'x86_64':
    kdll = CDLL('../../build/bin/macosArm64/releaseShared/libicure_sdk_native_pylib.dylib')
elif system == 'darwin' and arch == 'arm64':
    kdll = CDLL('../../build/bin/macosArm64/releaseShared/libicure_sdk_native_pylib.dylib')
else:
    raise Exception(f"Your system ({system} {arch}) is not compatible with this version of the iCure SDK")

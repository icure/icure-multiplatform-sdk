import platform
from ctypes import CDLL
from importlib.resources import path
import os

arch = platform.machine()
system = platform.system().lower()
dependencies = []
package = None

if system == 'linux' and arch == 'x86_64':
    dependencies = ["libcurl.so.4.8.0"]
    package = 'icure.lib.linuxX64'
elif system == 'darwin' and arch == 'x86_64':
    package = 'icure.lib.macosX64'
elif system == 'darwin' and arch == 'arm64':
    package = 'icure.lib.macosArm64'
else:
    raise Exception(f"Your system ({system} {arch}) is not compatible with this version of the iCure SDK")

for d in dependencies:
    with path(package, d) as d_path:
        CDLL(str(d_path))

with path(package, 'icure-sdk.so') as lib_path:
    kdll = CDLL(str(lib_path))

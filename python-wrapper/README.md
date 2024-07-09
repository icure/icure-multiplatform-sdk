# Macos support

The python wrapper is usable on macos without any additional libraries or setup steps necessary.

# Linux support

The python wrapper on linux requires the openssl and libcurl libraries to work. These libraries will be available on 
most systems without performing any additional steps, however, if you in some cases (for example building a docker 
image from scratch) you may need to install the required libraries yourself.

## Websockets on linux

Some iCure features, such as the realtime entity notifications, are built on top of websockets. iCure on linux depends 
on libcurl to perform the websockets communication, but currently websockets is still an experimental feature for
curl ([it should become stable in september 2024](https://github.com/curl/curl/blob/67cc1e3400b77536a3ca529c986247e1ef985e6e/docs/EXPERIMENTAL.md?plain=1#L60-L65)).

Experimental features are not enabled in the standard distributions of curl, therefore if you want to use websockets you
will need to find a distribution that has the websocket feature enabled, or you need to build the library yourself.

In the distributed version of the python sdk we include the prebuilt libcurl with experimental websockets support.

### Building libcurl with websocket support

```bash
git clone https://github.com/curl/curl.git
autoreconf -fi
./configure --enable-websockets --with-openssl --prefix=$HOME/curl
make
``` 

(optional) you can use the version of curl you just built as the command line utility by running (you can verify if the
installation was successful by running `curl --version` and checking if the `ws` and `wss` protocols are available)
```bash
sudo make install
```

You now need to configure the runtime linker to use the version of curl you just built instead of the original system 
version.
1. Create a file `/etc/ld.so.conf.d/customcurl.conf` and add the line `$HOME/curl/lib` (TODO: I don't know if the 
   environment variables are actually supported in this file, you may need to expand it manually)
2. Run `sudo ldconfig`

You should now be able to use the subscribe methods of the python sdk even on linux.

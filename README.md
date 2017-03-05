# JNI Implementation
A basic [Java Native Interface](https://en.wikipedia.org/wiki/Java_Native_Interface) (JNI) C/C++ shared library implementation.

## Compiling the code
Example compile commands for C/C++ libraries using [GNU Compiler Collection](https://gcc.gnu.org/) (GCC) on Windows and Linux.

> **Note:** The below commands are preferred for C library only. Usually, to compile a C++ library, use the `g++` command instead of `gcc`.

**Descriptions**

    JAVA_HOME        # The JDK root directory (an environment variable)
    hello.c          # The C library program (library source file)
    hello.o          # The compiled Object file (object code format)
    libhello.so      # The Linux native library (Shared Object library)
    libhello.dll     # The Windows native library (Dynamic-Link Library)

### Windows

Compiles a C program directly to a Windows native library.

    > gcc -Wl,--kill-at -shared -I %JAVA_HOME%\include -I %JAVA_HOME%\include\win32 -o libhello.dll hello.c

Compiles a C program to an Object file first, then to a Windows native library.

    > gcc -c hello.c -I %JAVA_HOME%\include -I %JAVA_HOME%\include\win32
    > gcc -Wl,--kill-at -shared -o libhello.dll hello.o

### Linux

Compiles a C program directly to a Linux native library.

    $ gcc -fPIC -shared -I $JAVA_HOME/include -I $JAVA_HOME/include/linux -o libhello.so hello.c

Compiles a C program to an Object file first, then to a Linux native library.

    $ gcc -fPIC -c hello.c -I $JAVA_HOME/include -I $JAVA_HOME/include/linux
    $ gcc -Wl,-soname,hello -shared -o libhello.so hello.o

### Headers

Example compile commands to generate JNI-styled header files for the C/C++ libraries.

**Commands**

    javac     # The standard Java compiler command
    javah     # Command that generates header files

**Descriptions**

    Hello.java     # The Java source file to be compiled
    Hello          # The compiled Java class name

Compiles the source file first, then generate the header file.

    $> javac Hello.java
    $> javah Hello

## Running the code

Example command to run and test the program in Windows and Linux.

**Descriptions**

    -D                    # Sets a value for a specific system property
    java.library.path     # System property to locate native libraries
    Hello                 # The Java class name to run

> **Example:** Assuming that the `libhello` library resides in the folder `library` located in the user's desktop.

.Windows (Command Prompt)

    > java -Djava.library.path="C:/Users/Username/Desktop/library" Hello

Linux (Terminal)

    $ java -Djava.library.path="/home/username/Desktop/library" Hello

> **Important:** Linux native shared libraries should start with the `lib` prefix followed by the `soname` - the library name. Please visit [here](http://tldp.org/HOWTO/Program-Library-HOWTO/shared-libraries.html) for more details.

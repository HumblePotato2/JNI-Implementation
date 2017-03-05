/**
 * This is a sample class that demonstrates on how to load a <b>JNI</b>
 * (Java Native Interface) library. This little program simply tells the
 * interpreter to load the native C/C++ {@code libhello} library program
 * and call its {@code void} type function called {@code print}.
 */
public class Hello {
	
	/** Loads the native C/C++ library program. */
	static {
		System.loadLibrary("libhello");
		// Linux native libraries should start with the lib prefix followed
		// by the library name. This is important when loading Linux Shared
		// Object (SO) libraries so in that case, the above code should be
		// System.loadLibrary("hello"); where hello is the soname - the name
		// of the library. More details at:
		// http://tldp.org/HOWTO/Program-Library-HOWTO/shared-libraries.html
	}
	
	/** The library's {@code void} type function. */
	public native void print();
	
	/** Calls the native library's function - {@code print}. */
	public static void main(String[] args) {
		Hello hello = new Hello();
		hello.print();
	}
}

/**
 * This is a sample class that demonstrates on how to load a <b>JNI</b>
 * (Java Native Interface) library. This little program simply tells the
 * interpreter to load the native C/C++ {@code libhello} library program
 * and call its {@code void} type function called {@code print}.
 */
public class Hello {
	
	/** Loads the native C/C++ library program. */
	static { System.loadLibrary("libhello"); }
	
	/** The library's {@code void} type function. */
	public native void print();
	
	/** Calls the native library's function - {@code print}. */
	public static void main(String[] args) {
		Hello hello = new Hello();
		hello.print();
	}
}

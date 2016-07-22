package lck08_J_CSEAI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class ReentrantLockAction {

	public static void doSomething(File file, LockAction action) {
		Lock lock = new ReentrantLock(); InputStream in = null; lock.lock();
		try {
			in = new FileInputStream(file);
			action.doSomethingWithFile(in);
		} catch (FileNotFoundException fnf) {
	// Forward to handler 
			} finally {
				lock.unlock();
				if (in != null) { 
					try {
						in.close();
					} catch (IOException e) {
	// Forward to handler 
						}
					} 
				}
		} 
}

	
package lck08_J_CSEAI;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public final class Client {
	public void doSomething(File file) {
	
		ReentrantLockAction.doSomething(file, new LockAction() { 
			public void doSomethingWithFile(InputStream in) {
			// Perform operations on the open file 
			}
		});
	}
	
	public  void testCase(final File file){
		Thread test = new Thread(new Runnable() {
			public void run() {
				doSomething(file);
				}
			});
			   test.start();
	}
	
	public void main(String[] args) throws IOException { 
		File file1 = new File("a.txt");
		file1.createNewFile();
		File file2 = new File("b.txt");
		file2.createNewFile();
		testCase(file1); // starts thread 1 
		testCase(file2); // starts thread 2
	}
}

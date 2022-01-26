package dtcookie;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Override
    public void run(String... args) {
//    	Thread thread = new Thread() {
//    		@Override
//    		public void run() {
//    	    	for (;;) {
//    	        	try {
//    	        		URL url = new URL("http://localhost:8080/");
//    	        		try (InputStream in = url.openStream()) {
//    	        			drain(in);
//    	        		}
//    	        	} catch (Throwable t) {
//    	        		t.printStackTrace(System.err);
//    	        	}
//    	        	try {
//    	        		Thread.sleep(5000);	
//    	        	} catch (InterruptedException ie) {
//    	        		return;
//    	        	}
//    	        	
//    	    	}
//    	    }
//    	};
//    	thread.setDaemon(true);
//    	thread.start();
    	for (;;) {
        	try {
        		URL url = new URL("http://localhost:8080/");
        		try (InputStream in = url.openStream()) {
        			drain(in);
        		}
        	} catch (Throwable t) {
        		t.printStackTrace(System.err);
        	}
        	try {
        		Thread.sleep(5000);	
        	} catch (InterruptedException ie) {
        		return;
        	}
        	
    	}    	
    }
    
    private static void drain(InputStream in) throws IOException {
    	byte[] buffer = new byte[1024];
    	while (in.read(buffer) != -1) { }
    }
    
}
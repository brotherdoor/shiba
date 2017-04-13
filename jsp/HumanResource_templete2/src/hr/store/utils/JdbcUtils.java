package hr.store.utils;

public class JdbcUtils {

	public static void close(AutoCloseable...autoCloseables) {
		//
		for (AutoCloseable autoCloseable : autoCloseables) {
			if (autoCloseable == null) {
				continue;
			} 
			try {
				autoCloseable.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}


package rfry.jtoolkit.logging;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A collection of methods for logging information.
 * @author Robert E Fry
 * @date 28 Apr 2018
 * @time 23:21:34
 *
 */
public final class Logger {
	
	private static final SimpleDateFormat format = new SimpleDateFormat("dd/mm/yy HH:mm.ss");
	
	/**
	 * Calculates the time/date stamp as formatted by {@code format}.
	 * @return the time/date stamp.
	 */
	public static final String getStamp() {
		return format.format(new Date());
	}
	
	/**
	 * Logs a line-broken set of objects with a single stamp.
	 * @param strings.
	 */
	public static final void log(Object... part) {
		System.out.printf("[%s] %s%s", getStamp(), part[0], (part.length > 1) ? "\n" : "");
		for (int i = 1; i < part.length; i++ ) {
			System.out.printf("\t%s%s", part[i], (i < part.length - 1) ? "" : "");
		}
	}
	
	/**
	 * Logs a formatted string.
	 * @param format a format string.
	 * @param args arguments to format the string with.
	 */
	public static final void logf(String format, Object... args) {
		log(String.format(format, args));
	}
	
	/**
	 * Logs an exception.
	 * @param e the exception to log.
	 */
	public static final void log(Exception e) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		String sStackTrace = sw.toString().replaceAll("\n", "\n\t");
		log(sStackTrace);
	}
	
}

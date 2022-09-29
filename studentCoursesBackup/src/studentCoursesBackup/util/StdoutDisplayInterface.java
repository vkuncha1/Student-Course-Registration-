/**
 * Stdout Display Interface to write results
 *
 * @author  Venkata Achyuth Kunchapu
 *
 */
package studentCoursesBackup.util;

import java.io.IOException;

public interface StdoutDisplayInterface {
    public void writeResult() throws IOException;
    public void writeConflict(String conflictIn);
    public void writeError(String errorIn);
}


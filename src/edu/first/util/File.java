package edu.first.util;

import com.sun.squawk.microedition.io.FileConnection;
import java.io.IOException;
import java.io.InputStream;
import javax.microedition.io.Connector;

/**
 * Class to represent files to better organize them.
 * <p>
 * @since June 07 13
 * @author Joel Gallant
 */
public final class File
{

    private final String fullPath;

    /**
     * Constructs the file with the direct path. Most formats for files should
     * work here, but use "/" for path separators.
     * <p>
     * @param path the path to the file
     */
    public File(String path)
    {
        path = Strings.replace(path, "file:", "");
        while (path.startsWith("/")) {
            path = path.substring(1);
        }
        this.fullPath = "file:///" + path;
    }

    /**
     * Returns the full path of the file that can be used by IO.
     * <p>
     * @return complete path of the file
     */
    public String getFullPath()
    {
        return fullPath;
    }

    /**
     * Returns the path of the file as a user would usually see.
     * <p>
     * @return the path of the file
     */
    public String getPath()
    {
        return Strings.replace(fullPath, "file//", "");
    }

    /**
     * Returns the full path of the file that can be used by IO.
     * <p>
     * @see #getFullPath()
     * @return complete path of the file
     */
    public String toString()
    {
        return getFullPath();
    }

    public boolean exists()
    {
        FileConnection conn = null;
        InputStream is = null;
        try {
            conn = ((FileConnection) Connector.
                    open(getFullPath(),
                         Connector.READ_WRITE));
            conn.create();
            is = conn.openInputStream();
            int ret = is.read();
            System.out.println(ret);
            return ret!= -1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (conn != null) {
                    conn.close();
                }
                if (is != null) {
                    is.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }
}

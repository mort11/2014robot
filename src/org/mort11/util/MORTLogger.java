/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mort11.util;

import com.sun.squawk.io.BufferedWriter;
import com.sun.squawk.microedition.io.FileConnection;
import edu.first.util.File;
import edu.first.util.Strings;
import edu.first.util.TextFiles;
import edu.first.util.log.Logger;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Vector;
import javax.microedition.io.Connector;

/**
 *
 * @author gridbug
 */
public class MORTLogger
{

    private final File file;
    private final boolean quiet;
    private final Vector lines = new Vector();

    public MORTLogger(File f)
    {
        this(f, false);
    }

    public MORTLogger(File f, boolean quiet)
    {
        file = f;
        this.quiet = quiet;
    }

    public void open()
    {
        lines.removeAllElements();
        FileConnection conn = null;
        DataInputStream is = null;
        try {
            conn = (FileConnection) Connector.open(file.getFullPath(),
                                                   Connector.READ_WRITE);
            conn.create();
            is = conn.openDataInputStream();
            StringBuffer data = new StringBuffer();
            byte[] buf = new byte[4096];
            int len = -2;
            while ((len = is.read(buf)) != -1) {
                data.append(buf);
            }
            String rawLines = data.toString();
            String[] splitLines = Strings.split(rawLines, "\n");
            for (int i = 0; i < splitLines.length; i++) {
                lines.addElement(splitLines[i]);
            }
            is.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void writeLine(String line)
    {
        lines.addElement(line);
        if (!quiet) {
            System.out.println(line);
        }
    }

    public void flush()
    {
        FileConnection conn = null;
        DataOutputStream os = null;
        BufferedWriter writ = null;
        try {
            conn = (FileConnection) Connector.open(file.getFullPath(),
                                                   Connector.READ_WRITE);
            conn.create();
            os = conn.openDataOutputStream();
            writ = new BufferedWriter(new OutputStreamWriter(os));
            for (int i = 0; i < lines.size(); i++) {
                writ.write(String.valueOf(lines.elementAt(i)));
                writ.write("\n");
            }
            writ.flush();
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writ != null) {
                    writ.close();
                }
                if (os != null) {
                    os.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

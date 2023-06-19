/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

/**
 *
 * @author palloma.nunes
 */
import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import java.io.*;

public class FileServletInputStream extends ServletInputStream {
    private InputStream inputStream;

    public FileServletInputStream(File file) throws IOException {
        this.inputStream = new FileInputStream(file);
    }

    @Override
    public int read() throws IOException {
        return inputStream.read();
    }

    @Override
    public int read(byte[] b) throws IOException {
        return inputStream.read(b);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        return inputStream.read(b, off, len);
    }

    @Override
    public boolean isFinished() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isReady() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setReadListener(ReadListener listener) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void close() throws IOException {
        inputStream.close();
    }
}


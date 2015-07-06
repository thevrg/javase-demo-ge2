package hu.dpc.edu.javase.demo.io;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

/**
 *
 * @author IQJB
 */
public class CharacterReplacerFilter extends FilterReader{

    private char what;
    private char toWhat;

    public CharacterReplacerFilter(char what, char toWhat, Reader in) {
        super(in);
        this.what = what;
        this.toWhat = toWhat;
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        int numberOfReadChars = super.read(cbuf, off, len);
        for (int i = off; i < off + len; i++) {
            char c = cbuf[i];
            if (c == what) {
                cbuf[i] = toWhat;
            }
        }
        return numberOfReadChars;
    }
}

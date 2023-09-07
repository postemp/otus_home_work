package hw20.client;

import java.io.*;

public class PingClient implements AutoCloseable{
    private DataInputStream in;
    private DataOutputStream out;

    public PingClient(InputStream in, OutputStream out) {
        this.in = new DataInputStream(new BufferedInputStream(in));
        this.out = new DataOutputStream(new BufferedOutputStream(out));
    }

    public void ping(byte[] bytes) throws IOException {
        out.write(bytes);
        out.flush();
    }

    @Override
    public void close() throws Exception {
        in.close();
        out.close();
    }
}

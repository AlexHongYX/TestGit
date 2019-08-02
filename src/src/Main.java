import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        //InputStream is = System.in;
        //String message = "+OK";
        //String message = "-ERR unknown command 'put'\r\n";
        //String message = ":-100\r\n";
        //String message = "$5\r\nhello\r\n";
        //String message = "*5\r\n$5\r\nlpush\r\n$3\r\nkey\r\n$1\r\n1\r\n$1\r\n2\r\n$1\r\n3\r\n";
        ByteInputStream is = new ByteInputStream(message.getBytes(), message.getBytes().length);

        List<byte[]> list = (List<byte[]>)Protocol.read(new ProtocolInputStream(is));
        for (byte[] b : list) {
            System.out.println(new String(b));
        }
    }
}

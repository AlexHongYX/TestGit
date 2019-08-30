import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, BedisException, InstantiationException, IllegalAccessException {
        //InputStream is = System.in;
        //String message = "+OK";
        //String message = "-ERR unknown command 'put'\r\n";
        //String message = ":-100\r\n";
        //String message = "$5\r\nhello\r\n";
        String message;
        message = "*5\r\n$5\r\nlpush\r\n$3\r\nkey\r\n$1\r\n1\r\n$1\r\n2\r\n$1\r\n3\r\n";
        ProtocolInputStream is = new ProtocolInputStream(new ByteArrayInputStream(message.getBytes()));
        Command command = Protocol.readCommand(is);
        command.run();

        message = "*4\r\n$6\r\nlrange\r\n$3\r\nkey\r\n$1\r\n0\r\n$2\r\n-1\r\n";
        is = new ProtocolInputStream(new ByteArrayInputStream(message.getBytes()));
        command = Protocol.readCommand(is);
        command.run();
    }
}

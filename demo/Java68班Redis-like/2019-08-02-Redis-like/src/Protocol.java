import java.io.IOException;
import java.io.InputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Protocol {
    public static Object read(ProtocolInputStream is) throws IOException {
        return process(is);
    }

    public static Command readCommand(ProtocolInputStream is) throws IOException, BedisException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Object o  = read(is);
        if (!(o instanceof List)) {
            throw new BedisException("命令必须是 Array 类型");
        }

        List<Object> list = (List<Object>)o;
        if (list.size() <= 1) {
            throw new BedisException("命令元素个数必须大于 1");
        }

        Object o2 = list.remove(0);
        if (!(o2 instanceof byte[])) {
            throw new BedisException("错误的命令类型");
        }

        byte[] array = (byte[])o2;
        String commandName = new String(array);
        String className = String.format("%sCommand", commandName.toUpperCase());
        Class<?> cls = Class.forName(className);
        if (!Command.class.isAssignableFrom(cls)) {
            throw new BedisException("错误的命令");
        }
        Command command = (Command)cls.newInstance();
        command.setArgs(list);

        return command;
    }

    private static String processSimpleString(ProtocolInputStream is) throws IOException {
        return is.readLine();
    }

    private static String processError(ProtocolInputStream is) throws IOException {
        return is.readLine();
    }

    private static long processInteger(ProtocolInputStream is) throws IOException {
        return is.readInteger();
    }

    private static byte[] processBulkString(ProtocolInputStream is) throws IOException {
        int len = (int)is.readInteger();
        if (len == -1) {
            // "$-1\r\n"    ==> null
            return null;
        }

        byte[] r = new byte[len];
        is.read(r, 0, len);
        /*
        for (int i = 0; i < len; i++) {
            int b = is.read();
            r[i] = (byte)b;
        }
        */

        // "$5\r\nhello\r\n";
        is.read();
        is.read();

        return r;
    }

    private static List<Object> processArray(ProtocolInputStream is) throws IOException {
        int len = (int)is.readInteger();
        if (len == -1) {
            // "*-1\r\n"        ==> null
            return null;
        }

        List<Object> list = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            try {
                list.add(process(is));
            } catch (RemoteException e) {
                list.add(e);
            }
        }

        return list;
    }
    private static Object process(ProtocolInputStream is) throws IOException {
        int b = is.read();
        if (b == -1) {
            throw new RuntimeException("不应该读到结尾的");
        }

        switch (b) {
            case '+':
                return processSimpleString(is);
            case '-':
                throw new RemoteException(processError(is));
            case ':':
                return processInteger(is);
            case '$':
                return processBulkString(is);
            case '*':
                return processArray(is);
            default:
                throw new RuntimeException("不识别的类型");
        }
    }
}

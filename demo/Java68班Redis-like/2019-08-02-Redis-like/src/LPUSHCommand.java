import java.util.List;

public class LPUSHCommand implements Command {
    private List<Object> args;

    @Override
    public void setArgs(List<Object> args) {
        this.args = args;
    }

    @Override
    public void run() {
        Database database = Database.getInstance();
        String key = new String((byte[])args.remove(0));
        List<String> list = database.getList(key);
        for (Object e : args) {
            String value = new String((byte[])e);
            list.add(0, value);
        }

        System.out.println(list.size());
    }
}

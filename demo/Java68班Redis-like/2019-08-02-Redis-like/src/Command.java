import java.util.List;

public interface Command {
    void setArgs(List<Object> args);

    void run();
}

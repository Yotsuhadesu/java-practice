import java.util.ArrayList;

/**
 * An interface for automated file I/O.
 */
public interface IPersistable {
    // Turns this object into one line of text for the file.
    String toFileLine();

    // Fills this object in from one line of text read from the file.
    void fromFileLine(String line);
}
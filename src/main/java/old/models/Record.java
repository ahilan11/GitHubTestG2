package old.models;

import old.additional.Printer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Record implements Printer {

private int id;
    private final static Logger LOG = LogManager.getLogger("Запись");
    public Record(int id) {
        this.id = id;
        LOG.info("old.models.Record: " + id);
    }

    public int getId() {
        return id;
    }
}

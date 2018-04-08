import org.apache.log4j.Logger;

public class Log4j {

    private static final Logger log = Logger.getLogger(Log4j.class);

    public static void main(String[] args) throws Exception {

        for (int i = 0; i < 10; i++) {
            log.info(i);

        }

    }

}
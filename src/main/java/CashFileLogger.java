import java.util.List;

public class CashFileLogger extends FileEventLogger {

    private int cacheSize;
    private List<Event> cache;

    CashFileLogger(int cacheSize){
        this.cacheSize = cacheSize;
    }

    @Override
    public void logEvent(Event event){
        cache.add(event);

        if (cache.size() == cacheSize){
       //     writeElementsFromCache(); //todo
            cache.clear();
        }
    }

}

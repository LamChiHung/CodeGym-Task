import java.util.ArrayList;
import java.util.List;

public class SortList {
    private SortStrategy sortStrategy;
    private List <String> items = new ArrayList <>();

    public SortList(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public void add(String name) {
        items.add(name);
    }

    public void useSort() {
        sortStrategy.sort(items);
    }
}

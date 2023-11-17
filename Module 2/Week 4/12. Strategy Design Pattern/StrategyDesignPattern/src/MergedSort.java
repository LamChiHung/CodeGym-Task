import java.util.List;

public class MergedSort implements SortStrategy {
    @Override
    public <T> void sort(List <T> item) {
        System.out.println("MergedSort");
    }
}

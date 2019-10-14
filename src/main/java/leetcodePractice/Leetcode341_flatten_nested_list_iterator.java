import Utils.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Leetcode341_flatten_nested_list_iterator implements Iterator<Integer> {

    private List<Integer> list = new ArrayList<>();
    private int curr = 0;

    public Leetcode341_flatten_nested_list_iterator(List<NestedInteger> nestedList) {
        for (NestedInteger item : nestedList) {
            recursiveGetList(item);
        }
    }

    @Override
    public Integer next() {
        return list.get(curr++);
    }

    @Override
    public boolean hasNext() {
        return curr < list.size();
    }

    private void recursiveGetList(NestedInteger item) {
        if (item.isInteger()) {
            list.add(item.getInteger());
        } else {
            for (NestedInteger i : item.getList()) {
                recursiveGetList(i);
            }
        }
    }
}

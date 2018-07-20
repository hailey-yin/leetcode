package java;

import java.util.List;
import java.util.Stack;

/**
 * Created by haileyyin on 7/20/18.
 */
public class FlattenNestedListIterator {
    Stack<NestedInteger> stack;

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    public Integer next() {
        return stack.pop().getInteger();
    }

    public boolean hasNext() {
        while (!stack.isEmpty()) {
            if (stack.peek().isInteger()) {
                return true;
            } else {
                List<NestedInteger> temp = stack.pop().getList();
                for (int i = temp.size() - 1; i >= 0; i--) {
                    stack.push(temp.get(i));
                }
                return hasNext();
            }
        }
        return false;
    }
}

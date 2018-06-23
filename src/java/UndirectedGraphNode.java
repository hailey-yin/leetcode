package java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haileyyin on 6/13/18.
 */
public class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}

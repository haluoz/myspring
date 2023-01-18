import com.lxj.leetcode.tree.MaximumDepthOfNaryTree559;
import com.lxj.leetcode.tree.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Xingjing.Li
 * @since 2022/9/26
 */
public class ModelCheck {
    private Integer maxDepth(Node node) {
        if (node == null) {
            return 0;
        }
        int maxChildDepth = 0;
        List<Node> childNodes = node.children;
        if (childNodes != null) {
            for (Node child : childNodes) {
                int childDepth = maxDepth(child);
                maxChildDepth = Math.max(maxChildDepth, childDepth);
            }
        }
        return maxChildDepth + 1;
    }

    public static void main(String[] args) {
        ModelCheck solution = new ModelCheck();
        List<Node> model = new ArrayList<>();
        Node root1 = new Node(1, Arrays.asList(new Node(2 )));
        Node root2 = new Node(10, Arrays.asList(new Node(11, Arrays.asList(new Node(3)))));
        model.add(root1);
        model.add(root2);
        int depth = 0;
        for (Node node : model) {
            Integer childDepth = solution.maxDepth(node);
            System.out.println(node.val+":"+childDepth);
            depth = Math.max(childDepth,depth);
        }
        for (Node node : model) {
            Integer childDepth = solution.maxDepth(node);
            if (childDepth != depth){
                throw new RuntimeException("depth does not equal");
            }
        }
        System.out.println(depth);
    }
}

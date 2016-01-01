/**
 * Created by Nikita on 22.12.2015.
 */

import com.sanny.API;
import com.sanny.Algo;
import com.sanny.Node;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TreeIterates extends Algo {

    List<Integer> nodeArray;

    private TreeIterates() {
        this.nodeArray = null;
    }

    @Override
    public Collection execute(Node node) {

        if (this.nodeArray == null) {
            this.nodeArray = new ArrayList<>();
            this.nodeArray.add(Integer.valueOf(node.getValue()));
        }
        for (Node child : node.getChildren()) {
            this.nodeArray.add(Integer.valueOf(child.getValue()));
            if (child.isNode()) {
                this.execute(child);
            }
        }
        return this.nodeArray;
    }


    public static void main(String args[]) {
        Node tree = API.generateTree();
        System.out.println(tree);
        TreeIterates it = new TreeIterates();

        TreeIterates tiForCheck = new TreeIterates();

        //System.out.println(it.execute(tree));
        API.checkAlgorythm(tree, it);
        API.printRightOrder(tree);
    }

}

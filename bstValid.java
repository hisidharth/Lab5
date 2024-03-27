import java.util.*;

public class bstValid {

    static List<Integer> leftStack = new ArrayList<Integer>();
    public static void getNodes(TreeNode node) {
        if (node == null) {
            return;
        }
        getNodes(node.left);
        leftStack.add(node.val);
        getNodes(node.right);
    }
    public boolean isValidBst(TreeNode root){
        getNodes(root);

        for(int i = 0; i< leftStack.size() -1 ; i++){
            if(leftStack.get(i) > leftStack.get(i+1)){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(3);
        root.right = new TreeNode(1);

        //TreeNode roott = new TreeNode();

        bstValid test = new bstValid();
        boolean isValid = test.isValidBst(root);
        System.out.println(isValid);
    }



}

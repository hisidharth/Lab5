class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class BstValid:
    def __init__(self):
        self.left_stack = []

    def getNodes(self, node):
        if node is None:
            return
        self.getNodes(node.left)
        self.left_stack.append(node.val)
        self.getNodes(node.right)

    def isValidBst(self, root):
        self.getNodes(root)
        for i in range(len(self.left_stack) - 1):
            if self.left_stack[i] > self.left_stack[i + 1]:
                return False
        return True

if __name__ == "__main__":

    root = TreeNode(3)
    root.left = TreeNode(3)
    root.right = TreeNode(10)
    root.right.right = TreeNode(11)
    root.right.left = TreeNode(4)
    bstValidator = BstValid()

    isValid = bstValidator.isValidBst(root)
    print(isValid)

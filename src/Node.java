public class Node {
    private Object value;
    private Node nextNode;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Node() {
        this.value = null;
        this.nextNode = null;
    }

    public Node(Object value) {
        this.value = value;
        this.nextNode = null;
    }

    public Node(Object value, Node nextNode) {
        this.value = value;
        this.nextNode = nextNode;
    }

    public boolean nodeEqualValue(Node node) {
        return (this.getValue() == node.getValue());
    }
}


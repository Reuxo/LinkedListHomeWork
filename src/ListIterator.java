import java.util.Iterator;

public class ListIterator implements Iterator<Node> {
    private List list;
    private Node nodeTmp;
    private int counter;

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Node getNodeTmp() {
        return nodeTmp;
    }

    public void setNodeTmp(Node nodeTmp) {
        this.nodeTmp = nodeTmp;
    }

    public ListIterator(List list) {
        this.list = list;
        this.nodeTmp = list.getHead();
        this.counter = 0;
    }

    @Override
    public boolean hasNext() {
        return this.counter < this.list.getLength();
    }

    @Override
    public Node next() {
        Node tmp = nodeTmp;
        counter++;
        nodeTmp = nodeTmp.getNextNode();
        return tmp;
    }
}

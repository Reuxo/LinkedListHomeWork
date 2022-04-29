public class List {
    private Node head;
    private int length;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getNodeByIndex(int index) { //Возвращаем ноду по индексу
        Node nodeTmp = this.head;
        int count = 0;
        while (nodeTmp != null) {
            if (count == index) {
                return nodeTmp;
            }
            count++;
            nodeTmp = nodeTmp.getNextNode();
        }
        return new Node(null, null);
    }

    public List() {
        this.head = null;
        this.length = 0;
    }

    public List(Node head) {
        this.head = head;
        this.length = 1;
    }

    public List(Object[] arrayInput) { // КОнструктор списка от массива
        this.head = new Node(arrayInput[0]);
        for (int i = 1; i < arrayInput.length; i++) {
            this.push(arrayInput[i]);
        }
        this.length = arrayInput.length;
    }

    public List(List list) {
        this.head = new Node(list.getHead().getValue());
        Node nodeTmp = list.getHead().getNextNode();
        while (nodeTmp != null) {
            this.push(nodeTmp.getValue());
            nodeTmp = nodeTmp.getNextNode();
        }
    }

    public Node getLast() { // Возвращает последний элемент списка
        Node nodeTmp = this.head;
        while (nodeTmp.getNextNode() != null) {
            nodeTmp = nodeTmp.getNextNode();
        }
        return nodeTmp;
    }

    public void printList() {
        System.out.print("[");
        Node nodeTmp = this.head;
        while (nodeTmp.getNextNode() != null) {
            System.out.print(nodeTmp.getValue() + ", ");
            nodeTmp = nodeTmp.getNextNode();
        }
        System.out.print(nodeTmp.getValue() + "]");
        System.out.println();
    }

    public void push(Object value) { //Добавление элемента в конец списка
        Node nodeTmp = this.head;
        while (nodeTmp.getNextNode() != null) {
            nodeTmp = nodeTmp.getNextNode();
        }
        nodeTmp.setNextNode(new Node(value));
        this.length++;
    }

    public void push(Object value, int index) { //Добавление элемента по идексу
        if (index == 0) {
            this.pushHead(value);
        } else {
            Node nodeTmp = this.head;
            for (int i = 0; i < index - 1 && nodeTmp.getNextNode() != null; i++) {
                nodeTmp = nodeTmp.getNextNode();
            }
            Node newNode = new Node(value, nodeTmp.getNextNode());
            nodeTmp.setNextNode(newNode);
            this.length++;
        }
    }

    public void pushHead(Object value) { //Добавление головы
        Node node = new Node(value, this.head);
        this.head = node;
        this.length++;
    }

    public void pop() { // Удаление ноды
        Node nodeTmp = this.head;
        while (nodeTmp.getNextNode().getNextNode() != null) {
            nodeTmp = nodeTmp.getNextNode();
        }
        nodeTmp.setNextNode(null);
        this.length--;
    }

    public void pop(int index) { // Удаление элемента по индексу
        if (index == 0) {
            popHead();
        } else {
            Node nodeTmp = this.head;
            for (int i = 0; i < index - 1 && nodeTmp.getNextNode().getNextNode() != null; i++) {
                nodeTmp = nodeTmp.getNextNode();
            }
            nodeTmp.setNextNode(nodeTmp.getNextNode().getNextNode());
            this.length--;
        }
    }

    public void popValue(Object value) { //Удаление элемента по значению
        Node nodeTmp = this.head;
        int count = 0;
        while (nodeTmp != null) {
            if (nodeTmp.getValue() == value) {
                this.pop(count);
                count--;
                break;
            }
            count++;
            nodeTmp = nodeTmp.getNextNode();
        }
    }

    public void popAllValues(Object value) { //Удаление всех элементов по значению
        Node nodeTmp = this.head;
        int count = 0;
        while (nodeTmp != null) {
            if (nodeTmp.getValue() == value) {
                this.pop(count);
                count--;
            }
            count++;
            nodeTmp = nodeTmp.getNextNode();
        }
    }

    public void popAll() { //удаление всех элементов списка
        while (this.head != null) {
            this.popHead();
        }
    }

    public void replace(Object valuePrev, Object valueNew) { //Изменение всех элементов списка с данным значением на новое.
        Node nodeTmp = this.head;
        while (nodeTmp != null) {
            if (nodeTmp.getValue() == valuePrev) {
                nodeTmp.setValue(valueNew);
            }

            nodeTmp = nodeTmp.getNextNode();
        }

    }

    public boolean isSymmetric() { //Определение, является ли список симметричным.
        for (int i = 0; i < this.length / 2; i++) {
            if (getNodeByIndex(i).getValue() != getNodeByIndex(this.length - 1 - i).getValue()) {
                return false;
            }
        }
        return true;
    }

    public boolean isVoid() { //ПРоверка списка на пустоту
        return (this.length == 0);
    }

    public Node nodeByValue(Object value) { //Поиск значение в списке (возвращает ноду с этим значением)
        Node nodeTmp = this.head;
        while (nodeTmp != null) {
            if (value == nodeTmp.getValue()) {
                return nodeTmp;
            }
            nodeTmp = nodeTmp.getNextNode();
        }
        return new Node(null, null);
    }

    public static boolean twoValuesDel(List list) { //можно ли удалить из списка каких-нибудь два элемента так,
        // чтобы новый список оказался упорядоченным.
        int counterDel = 0;
        Node nodeTmp;

        nodeTmp = list.getHead();
        while (nodeTmp.getNextNode() != null) {
            if (Integer.valueOf(nodeTmp.getValue().toString()) > Integer.valueOf(nodeTmp.getNextNode().getValue().toString())) {
                list.popValue(nodeTmp.getValue());
                counterDel++;
            }
            nodeTmp = nodeTmp.getNextNode();
        }

        return (counterDel == 2 || counterDel == 0);
    }

    public int uniqueValues() { //	Определение, сколько различных значений содержится в списке.
        List newList = new List(this);
        int countUnique = 0;
        while (newList.getHead() != null) {
            newList.popAllValues(newList.getHead().getValue());
            countUnique++;
        }
        return countUnique;
    }

    public void popHead() { //Удаление головы
        this.head = this.head.getNextNode();
        this.length--;
    }

    private void popClones(int index) { //Удаление клона в списке по индексу первого вхождения
        for (int i = 0; i < this.getLength(); i++) {
            if (i != index && this.getNodeByIndex(i).getValue() == this.getNodeByIndex(index).getValue()) {
                this.pop(i);
                i--;
            }
        }
    }

    public void popAllClones() { //Удаление всех клонов
        for (int i = 0; i < this.length; i++) {
            this.popClones(i);
        }
    }

    public void reversesValue() { //Изменение порядка элементов на обратный.
        Object tmp;
        for (int i = 0; i < this.length / 2; i++) {
            tmp = this.getNodeByIndex(this.length - i - 1).getValue();
            this.getNodeByIndex(this.length - i - 1).setValue(this.getNodeByIndex(i).getValue());
            this.getNodeByIndex(i).setValue(tmp);
        }
    }

    public void reversesLinks() { //Изменение порядка элементов на обратный. Вариант 2
        for (int i = 0; i < this.getLength(); i++) {
            this.push(this.getLast().getValue(), i);
            this.pop();
        }
    }

    public void bubbleSort() { //Сортировка Пузырек со сменой value
        Object tmp;
        for (int i = this.length - 1; i > 0; i--) {
            Node nodeTmp = this.head;
            while (nodeTmp.getNextNode() != null) {
                if (Integer.parseInt(nodeTmp.getValue().toString()) > Integer.parseInt(nodeTmp.getNextNode().getValue().toString())) {
                    tmp = nodeTmp.getValue();
                    nodeTmp.setValue(nodeTmp.getNextNode().getValue());
                    nodeTmp.getNextNode().setValue(tmp);
                }
                nodeTmp = nodeTmp.getNextNode();
            }
        }
    }


}
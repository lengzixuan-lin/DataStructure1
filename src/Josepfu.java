public class Josepfu {
    public static void main(String[] args) {
        SingleLinkedList2 list2 = new SingleLinkedList2();
        list2.addBoy(5);
        list2.showBoy();
        list2.showBoyJ(1,2,5);

    }

}

class SingleLinkedList2{
    Boy first = null;
    Boy curBoy = null;
    Boy boy = null;

    public void addBoy(int boyNum){
        if(boyNum < 1){
            System.out.println("节点数为正");
            return;
        }
        for(int i = 0;i < boyNum;i++){
            if(i == 0){
                first = new Boy(i+1);
                curBoy = first;
                curBoy.setNext(first);
                continue;
            }
            boy = new Boy(i+1);
            curBoy.setNext(boy);
            boy.setNext(first);
            curBoy = boy;
        }
    }

    public void showBoy(){
        Boy curBoy = first;
        if(curBoy == null){
            System.out.println("环形链表数据为空！");
            return;
        }
        while(true){
            System.out.printf("环形链表编号%d\n",curBoy.getNo());
            if(curBoy.getNext() == first){
                break;
            }
            curBoy = curBoy.getNext();
        }

    }

    public void showBoyJ(int startNum,int countNum,int boyNum){
        if(startNum < 1 || boyNum < 1){
            System.out.println("输入数据错误！");
            return;
        }
        Boy helper = first;
        while(true){
            if (helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }
        for(int j = 0;j < startNum - 1;j++){
            first = first.getNext();
            helper = helper.getNext();
        }
        while(true){
            if(helper == first){
                break;
            }
            for(int i = 0;i < countNum-1;i++){
                first = first.getNext();
                helper = helper.getNext();
                System.out.printf("出圈的小孩的编号为%d\n", first.getNo());
            }
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("出圈的小孩的编号为%d\n", first.getNo());
    }

}

class Boy{
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
}

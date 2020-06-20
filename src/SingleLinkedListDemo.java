/**
 * 需求：将水浒英雄按顺序存放
 * 解决方案：定义一个单向链表类进行存放
 */
public class SingleLinkedListDemo {
    //测试
    public static void main(String[] args) {
        SingleLikedList likedList = new SingleLikedList();

        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        likedList.addByOrder(hero1);
        likedList.addByOrder(hero3);
        likedList.addByOrder(hero2);
        likedList.addByOrder(hero4);

        likedList.getSingleLikedList();
        likedList.update(new HeroNode(2, "小卢", "玉麒麟！！"));
        System.out.println("更新后的链表");
        likedList.getSingleLikedList();
        likedList.del(2);
        likedList.del(2);
        System.out.println("删除2号节点后的链表");
        likedList.getSingleLikedList();
    }
}

class SingleLikedList{
    public HeroNode head = new HeroNode(0,"","");

    //添加节点
    public void addNode(HeroNode newHeroNode){
        HeroNode temp = head;
        while(true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = newHeroNode;
    }
    //按顺序添加节点
    public void addByOrder(HeroNode newHeroNode){
        HeroNode temp = head;
        boolean flag = false;
        while(true){
            if(temp.next == null){
                break;
            }else if(temp.next.no > newHeroNode.no){
                break;
            }else if(temp.next.no == newHeroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            System.out.println("节点已存在");
        }else{
            newHeroNode.next = temp.next;
            temp.next = newHeroNode;
        }
    }

    //更新节点参数
    public void update(HeroNode newHeroNode){
        HeroNode temp = head;
        boolean flag = false;
        while(true){
            if(temp.next == null){
                break;
            }else if(temp.next.no == newHeroNode.no){
                temp = temp.next;
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        }else{
            System.out.println("未找到该节点");
        }
    }
    //删除链表节点
    public void del(int no){
        HeroNode temp = head;
        boolean flag = false;
        while(true){
            if(temp.next == null){
                break;
            }else if(temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.next = temp.next.next;
        }else{
            System.out.println("未找到该节点");
        }
    }
    //遍历链表
    public void getSingleLikedList(){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while(true){
            System.out.println(temp);
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }

    }

}

class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no,String name,String nickName){
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}

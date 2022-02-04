import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ReArrangeOrders {
    public static void main(String[] args) {

//        LinkedHashSet<RuleOrder> ruleOrders = new LinkedHashSet<>();
//        for(int i=1; i<=5; i++){
//           ruleOrders.add(new RuleOrder("r"+i, i));
//        }
//        ruleOrders.add(new RuleOrder("r"+1, 2));
//
//        ruleOrders.forEach(x->System.out.println(x.id + " : "+x.order));

        System.out.println("*****");
        //LinkedHashMap<String, Integer> ruleOrderMap = new LinkedHashMap<>();
        List<String> ruleOrderMap = new ArrayList<>();
        for(int i=1; i<=9; i++){
            ruleOrderMap.add("r"+i);
        }

        System.out.println("*** Existing Ids In ascending Order **");
        ruleOrderMap.forEach(id->System.out.println(id));

        //Deleted Ids set
        List<String> deletedIds = Arrays.asList("r1", "r4");
        System.out.println("*** Deleted Ids **");
        deletedIds.forEach(id->System.out.println(id));

        for(String id: deletedIds){
           ruleOrderMap.remove(id);
        }

        System.out.println("***Ids after delete **");
        ruleOrderMap.forEach(id->System.out.println(id));

//        LinkedHashMap<Integer, String> reversedRuleOrderMap = new LinkedHashMap<>();

//        //Rearrange order
//        System.out.println("** Rearrange after delete ***");
//        AtomicInteger newOrder= new AtomicInteger();
//        ruleOrderMap.forEach((id, order)->{
//            int newIntOrder = newOrder.incrementAndGet();
//            ruleOrderMap.put(id, newIntOrder);
//            reversedRuleOrderMap.put(newIntOrder, id);
//        });
//        ruleOrderMap.forEach((id, order)->System.out.println(id +" : "+order));

        //Edit Ids
        LinkedHashMap<String, Integer> editedRuleOrders = new LinkedHashMap<>();
        editedRuleOrders.put("r7", 2);
        editedRuleOrders.put("r3", 5);
        editedRuleOrders.put("r9", 20);
        editedRuleOrders.put("r8", 30);

        System.out.println("*** Edited Ids with new edited order**");
        editedRuleOrders.forEach((id, order)->System.out.println(id + " : "+order));


        editedRuleOrders.forEach((id, order)->{
            int indexId = ruleOrderMap.indexOf(id);
            if(indexId >= 0) {
                if (order <= ruleOrderMap.size()) {
                    String tempId = ruleOrderMap.get(order - 1);
                    ruleOrderMap.set(indexId, tempId);
                    ruleOrderMap.set(order - 1, id);
                } else {
                    ruleOrderMap.remove(id);
                    ruleOrderMap.add(id);
                }
            }else{
                System.out.println(id + "Not exists");
            }
        });

        System.out.println("** List after edit ***");
        ruleOrderMap.forEach(x->System.out.println(x));

        //Add orders
        LinkedHashMap<String, Integer> addedRuleOrders = new LinkedHashMap<>();
        addedRuleOrders.put("r10", 1);
        addedRuleOrders.put("r11", 4);
        addedRuleOrders.put("r12", 7);
        addedRuleOrders.put("r13", 100);
        System.out.println("*** Added Ids with new order**");
        addedRuleOrders.forEach((id, order)->System.out.println(id + " : "+order));
        addedRuleOrders.forEach((id, order)->{
            if(order <= ruleOrderMap.size()){
                ruleOrderMap.add(order-1, id);
            }else{
                ruleOrderMap.add(id);
            }
        });

        System.out.println("** List after Add ***");
        ruleOrderMap.forEach(x->System.out.println(x));
    }

    static class RuleOrder{
        String id;
        int order;
        RuleOrder(String id, int order){
            this.id = id;
            this.order = order;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            RuleOrder ruleOrder = (RuleOrder) o;
            return order == ruleOrder.order && id.equals(ruleOrder.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, order);
        }
    }
}

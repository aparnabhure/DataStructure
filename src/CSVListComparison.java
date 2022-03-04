import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CSVListComparison {

    private static Map<String, String> domainCustomerIdMap;
    public static void main(String[] args) throws IOException {
//        Set<String> verifyInactive1 = getListFromCSVByAbsoluatePath("/Users/ab732698/Downloads/02-24-154315-domainIds.csv");
//        System.out.println("********** verifyInactive1" + verifyInactive1.size());
//        verifyInactive1.forEach(x-> {
//                if(!x.startsWith("TEST"))
//                System.out.println(x);
//            }
//        );

        domainCustomerIdMap = new HashMap<>();
        validateDomainsVerify();

    }

    private static void validateDomainsVerify() throws IOException {
        Set<String> inactiveDomains = getListFromCSV("verify_inactive_domains.csv");
        System.out.println("********** inactiveDomains "+inactiveDomains.size());

        Set<String> verifyInactive1 = getListFromCSVByAbsoluatePath("/Users/ab732698/Downloads/02-24-154315-domainIds.csv");
        System.out.println("********** verifyInactive1 "+verifyInactive1.size());
        //verifyInactive1.forEach(x->System.out.println(x));

        Set<String> verifyInactive2 = getListFromCSVByAbsoluatePath("/Users/ab732698/Downloads/2022-03-02-Verify-InactiveDomains1.csv");
        System.out.println("********** verifyInactive2 "+verifyInactive2.size());
        //verifyInactive2.forEach(x->System.out.println(x));

        Set<String> verifyInactive3 = getListFromCSVByAbsoluatePath("/Users/ab732698/Downloads/2022-03-02-Verify-InactiveDomains2.csv");
        System.out.println("********** verifyInactive3 "+verifyInactive3.size());
        //verifyInactive3.forEach(x->System.out.println(x));

        Set<String> verifyInactive4 = getListFromCSVByAbsoluatePath("/Users/ab732698/Downloads/2022-03-02-Verify-InactiveDomains3.csv");
        System.out.println("********** verifyInactive4 "+verifyInactive4.size());
        //verifyInactive4.forEach(x->System.out.println(x));

        Set<String> verifyInactive5 = getListFromCSVByAbsoluatePath("/Users/ab732698/Downloads/2022-03-02-Verify-InactiveDomains4.csv");
        System.out.println("********** verifyInactive5 "+verifyInactive5.size());
        //verifyInactive5.forEach(x->System.out.println(x));

        Set<String> verifyInactive6 = getListFromCSVByAbsoluatePath("/Users/ab732698/Downloads/2022-03-02-Verify-InactiveDomains5.csv");
        System.out.println("********** verifyInactive6 "+verifyInactive6.size());
        //verifyInactive6.forEach(x->System.out.println(x));

        Set<String> adaptationsDomains = getListFromCSV("acm_adaptations_domains.csv");
        Set<String> avRecommendationsDomains = getListFromCSV("app_version_recommendations_domains.csv");
        Set<String> barReportsDomains = getListFromCSV("bar_reports_domains.csv");
        Set<String> deviceFileDriftDomains = getListFromCSV("device_file_drift_domains.csv");
        Set<String> fileRecommendationsDomains = getListFromCSV("file_recommendations_domains.csv");
        Set<String> heatMapDomains = getListFromCSV("heatmap_domains.csv");
        Set<String> policyDiscoveredDomains = getListFromCSV("policy_discovered_file_hahs_domains.csv");
        Set<String> policyOrgUnitMapDomains = getListFromCSV("policy_org_unit_map_domains.csv");
        Set<String> rulesDomains = getListFromCSV("rule_domains.csv");
        Set<String> userExperienceDomains = getListFromCSV("user_experience_domains.csv");
        Set<String> agentPolicyDomains = getListFromCSV("agent_policy_state_domains.csv");
        Set<String> biDomains1 = getListFromCSV("bi_domains.csv");
        Set<String> biDomains2 = getListFromCSV("bi_domains_1.csv");
        Set<String> biDomains3 = getListFromCSV("bi_domains_2.csv");
        Set<String> biDomains4 = getListFromCSV("bi_domains_3.csv");

        Set<String> combinedPendingDomains = new HashSet<>();

        System.out.println("**************************inactiveDomains************************");
        validateDomains(combinedPendingDomains, inactiveDomains, adaptationsDomains, avRecommendationsDomains, barReportsDomains,
            deviceFileDriftDomains, fileRecommendationsDomains, heatMapDomains, policyDiscoveredDomains,
            policyOrgUnitMapDomains, rulesDomains, userExperienceDomains, agentPolicyDomains, biDomains1, biDomains2, biDomains3, biDomains4);

        System.out.println("**************************verifyInactive1************************");
        validateDomains(combinedPendingDomains, verifyInactive1, adaptationsDomains, avRecommendationsDomains, barReportsDomains,
            deviceFileDriftDomains, fileRecommendationsDomains, heatMapDomains, policyDiscoveredDomains,
            policyOrgUnitMapDomains, rulesDomains, userExperienceDomains, agentPolicyDomains, biDomains1, biDomains2, biDomains3, biDomains4);

        System.out.println("**************************verifyInactive2************************");
        validateDomains(combinedPendingDomains, verifyInactive2, adaptationsDomains, avRecommendationsDomains, barReportsDomains,
            deviceFileDriftDomains, fileRecommendationsDomains, heatMapDomains, policyDiscoveredDomains,
            policyOrgUnitMapDomains, rulesDomains, userExperienceDomains, agentPolicyDomains, biDomains1, biDomains2, biDomains3, biDomains4);

        System.out.println("**************************verifyInactive3************************");
        validateDomains(combinedPendingDomains, verifyInactive3, adaptationsDomains, avRecommendationsDomains, barReportsDomains,
            deviceFileDriftDomains, fileRecommendationsDomains, heatMapDomains, policyDiscoveredDomains,
            policyOrgUnitMapDomains, rulesDomains, userExperienceDomains, agentPolicyDomains, biDomains1, biDomains2, biDomains3, biDomains4);

        System.out.println("**************************verifyInactive4************************");
        validateDomains(combinedPendingDomains, verifyInactive4, adaptationsDomains, avRecommendationsDomains, barReportsDomains,
            deviceFileDriftDomains, fileRecommendationsDomains, heatMapDomains, policyDiscoveredDomains,
            policyOrgUnitMapDomains, rulesDomains, userExperienceDomains, agentPolicyDomains, biDomains1, biDomains2, biDomains3, biDomains4);

        System.out.println("**************************verifyInactive5************************");
        validateDomains(combinedPendingDomains, verifyInactive5, adaptationsDomains, avRecommendationsDomains, barReportsDomains,
            deviceFileDriftDomains, fileRecommendationsDomains, heatMapDomains, policyDiscoveredDomains,
            policyOrgUnitMapDomains, rulesDomains, userExperienceDomains, agentPolicyDomains, biDomains1, biDomains2, biDomains3, biDomains4);

        System.out.println("**************************verifyInactive6************************");
        validateDomains(combinedPendingDomains, verifyInactive6, adaptationsDomains, avRecommendationsDomains, barReportsDomains,
            deviceFileDriftDomains, fileRecommendationsDomains, heatMapDomains, policyDiscoveredDomains,
            policyOrgUnitMapDomains, rulesDomains, userExperienceDomains, agentPolicyDomains, biDomains1, biDomains2, biDomains3, biDomains4);

        System.out.println("\n*****************Final pending Domains list " + combinedPendingDomains.size());

        writeIntoCsv(new ArrayList<>(combinedPendingDomains), "verify_inactive_ac_domains_only.csv");

//        List<Customer> finalPendingCustomers = new ArrayList<>();
//        combinedPendingDomains.forEach(id->{
//            finalPendingCustomers.add(new Customer(domainCustomerIdMap.get(id), id));
//        });
//
//        System.out.println("\n*****************Final pending Customers list " + finalPendingCustomers.size());

        List<String> finalPendingCustomers = new ArrayList<>();
        combinedPendingDomains.forEach(id->{
            finalPendingCustomers.add(domainCustomerIdMap.get(id)+","+ id);
        });
        System.out.println("\n*****************Final pending Customers list " + finalPendingCustomers.size());

        writeIntoCsv(finalPendingCustomers, "verify_inactive_ac_domains.csv");
    }


    private static void validateDomains(Set<String> combinedPendingDomains,
                                        Set<String> inactiveDomains,
                                        Set<String> adaptationsDomains,
                                        Set<String> avRecommendationsDomains,
                                        Set<String> barReportsDomains,
                                        Set<String> deviceFileDriftDomains,
                                        Set<String> fileRecommendationsDomains,
                                        Set<String> heatMapDomains,
                                        Set<String> policyDiscoveredDomains,
                                        Set<String> policyOrgUnitMapDomains,
                                        Set<String> rulesDomains,
                                        Set<String> userExperienceDomains,
                                        Set<String> agentPolicyDomains,
                                        Set<String> biDomains1,
                                        Set<String> biDomains2,
                                        Set<String> biDomains3,
                                        Set<String> biDomains4){
        Set<String> pendingDomains = fetchRemainingInactiveDomains(adaptationsDomains, inactiveDomains);
        System.out.println("Pending Adaptation Domains " + pendingDomains.size());
        combinedPendingDomains.addAll(pendingDomains);
        pendingDomains = fetchRemainingInactiveDomains(avRecommendationsDomains, inactiveDomains);
        System.out.println("Pending avRecommendationsDomains Domains " + pendingDomains.size());
        combinedPendingDomains.addAll(pendingDomains);
        pendingDomains = fetchRemainingInactiveDomains(barReportsDomains, inactiveDomains);
        System.out.println("Pending barReportsDomains Domains " + pendingDomains.size());
        combinedPendingDomains.addAll(pendingDomains);
        pendingDomains = fetchRemainingInactiveDomains(deviceFileDriftDomains, inactiveDomains);
        System.out.println("Pending deviceFileDriftDomains Domains " + pendingDomains.size());
        combinedPendingDomains.addAll(pendingDomains);
        pendingDomains = fetchRemainingInactiveDomains(fileRecommendationsDomains, inactiveDomains);
        System.out.println("Pending fileRecommendationsDomains Domains " + pendingDomains.size());
        combinedPendingDomains.addAll(pendingDomains);
        pendingDomains = fetchRemainingInactiveDomains(heatMapDomains, inactiveDomains);
        System.out.println("Pending heatMapDomains Domains " + pendingDomains.size());
        combinedPendingDomains.addAll(pendingDomains);
        pendingDomains = fetchRemainingInactiveDomains(policyDiscoveredDomains, inactiveDomains);
        System.out.println("Pending policyDiscoveredDomains Domains " + pendingDomains.size());
        combinedPendingDomains.addAll(pendingDomains);
        pendingDomains = fetchRemainingInactiveDomains(policyOrgUnitMapDomains, inactiveDomains);
        System.out.println("Pending policyOrgUnitMapDomains Domains " + pendingDomains.size());
        combinedPendingDomains.addAll(pendingDomains);
        pendingDomains = fetchRemainingInactiveDomains(rulesDomains, inactiveDomains);
        System.out.println("Pending rulesDomains Domains " + pendingDomains.size());
        combinedPendingDomains.addAll(pendingDomains);
        pendingDomains = fetchRemainingInactiveDomains(userExperienceDomains, inactiveDomains);
        System.out.println("Pending userExperienceDomains Domains " + pendingDomains.size());
        combinedPendingDomains.addAll(pendingDomains);
        pendingDomains = fetchRemainingInactiveDomains(agentPolicyDomains, inactiveDomains);
        System.out.println("Pending agentPolicyDomains Domains " + pendingDomains.size());
        pendingDomains = fetchRemainingInactiveDomains(biDomains1, inactiveDomains);
        System.out.println("Pending biDomains1 " + pendingDomains.size());
        combinedPendingDomains.addAll(pendingDomains);
        pendingDomains = fetchRemainingInactiveDomains(biDomains2, inactiveDomains);
        System.out.println("Pending biDomains2 " + pendingDomains.size());
        combinedPendingDomains.addAll(pendingDomains);
        pendingDomains = fetchRemainingInactiveDomains(biDomains3, inactiveDomains);
        System.out.println("Pending biDomains3 " + pendingDomains.size());
        combinedPendingDomains.addAll(pendingDomains);
        pendingDomains = fetchRemainingInactiveDomains(biDomains4, inactiveDomains);
        System.out.println("Pending biDomains4 " + pendingDomains.size());
        combinedPendingDomains.addAll(pendingDomains);
    }

    private static Set<String> fetchRemainingInactiveDomains(final Set<String> domains, final Set<String> inactiveDomains){
        Set<String> remainingDomains = new HashSet<>();
        for(String domain: domains){
            if(inactiveDomains.contains(domain)){
                remainingDomains.add(domain);
            }
        }
        return remainingDomains;
    }

    private static void compare2csv()  throws IOException{
        Set<String> list1 = getListFromCSV("list1.csv");
        Set<String> list2 = getListFromCSV("list2.csv");
        System.out.println("list1 size "+list1.size() +" \nlist2 size "+list2.size());
        boolean status = list2.removeAll(list1);
        System.out.println("Duplicate removal status " + status);
        System.out.println("List 2 size after duplicate removal " + list2.size());
        List<String> sortedList = list2.stream().sorted().collect(Collectors.toList());
        System.out.println("Sorted List size" + sortedList.size());
        writeIntoCsv(sortedList, "outout.csv");
    }

    private static Set<String> getListFromCSVByAbsoluatePath(final String filePath){
        Set<String> records = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
               // System.out.println(line);
                String[] columns = line.split(",");
                String domainId = columns[2];
                String customerId = columns[1];
                records.add(domainId);
                domainCustomerIdMap.put(domainId, customerId);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }

    private static Set<String> getListFromCSV(final String fileName){
        Set<String> records = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CSVListComparison.class.getClassLoader().getResource(fileName).getPath()))) {
            String line;
            while ((line = br.readLine()) != null) {
                records.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }

    private static void writeIntoCsv(List<String> result, String fileName) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        String collect = result.stream().collect(Collectors.joining("\n"));
        //System.out.println(collect);
        writer.write(collect);
        writer.close();
    }

    static class Customer{
        String customerId;
        String domainId;
        public Customer(String customerId, String domainId){
            this.customerId = customerId;
            this.domainId = domainId;
        }
    }
}

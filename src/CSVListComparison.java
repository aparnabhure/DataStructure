import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CSVListComparison {
    public static void main(String[] args) throws IOException {

        Set<String> list1 = getListFromCSV("list1.csv");
        Set<String> list2 = getListFromCSV("list2.csv");
        System.out.println("list1 size "+list1.size() +" \nlist2 size "+list2.size());
        boolean status = list2.removeAll(list1);
        System.out.println("Duplicate removal status " + status);
        System.out.println("List 2 size after duplicate removal " + list2.size());
        List<String> sortedList = list2.stream().sorted().collect(Collectors.toList());
        System.out.println("Sorted List size" + sortedList.size());
        writeIntoCsv(sortedList);
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

    private static void writeIntoCsv(List<String> result) throws IOException {
        FileWriter writer = new FileWriter("output.csv");
        String collect = result.stream().collect(Collectors.joining("\n"));
        System.out.println(collect);
        writer.write(collect);
        writer.close();
    }

}

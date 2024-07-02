import java.util.*;
public class RowCount {

    public static int getRowCount(List<Map<String, String>> data) {
        return data.size();
    }

    // Example usage:
    public static void main(String[] args) {
        // Dummy original data
        List<Map<String, String>> originalData = new ArrayList<>();
        Map<String, String> row1 = new HashMap<>();
        row1.put("id", "1");
        row1.put("name", "Nachiket Jagtap");
        originalData.add(row1);

        Map<String, String> row2 = new HashMap<>();
        row2.put("id", "2");
        row2.put("name", "Piyush More");
        originalData.add(row2);

        

        // Dummy migrated data (assuming the same data has been migrated)
        List<Map<String, String>> migratedData = new ArrayList<>();
        Map<String, String> migratedRow1 = new HashMap<>();
        migratedRow1.put("id", "1");
        migratedRow1.put("name", "Nachiket Jagtap");
        migratedData.add(migratedRow1);

        Map<String, String> migratedRow2 = new HashMap<>();
        migratedRow2.put("id", "2");
        migratedRow2.put("name", "Piyush More");
        migratedData.add(migratedRow2);

        int originalRowCount = getRowCount(originalData);
        int migratedRowCount = getRowCount(migratedData);

        System.out.println("Original Row Count: " + originalRowCount);
        System.out.println("Migrated Row Count: " + migratedRowCount);

        if (originalRowCount == migratedRowCount) {
            System.out.println("Row counts match. Data transfer complete.");
        } else {
            System.out.println("Row counts do not match. Data transfer incomplete or corrupted.");
        }
    }
}


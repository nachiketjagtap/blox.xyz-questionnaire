
import java.util.*;
import java.security.*;

public class CheckSumCalc{

    public static String calculateChecksum(List<Map<String, String>> data) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            StringBuilder sb = new StringBuilder();

            for (Map<String, String> map : data) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    sb.append(entry.getKey());
                    sb.append(entry.getValue());
                }
            }

            byte[] hash = digest.digest(sb.toString().getBytes());
            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
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

        String originalChecksum = calculateChecksum(originalData);
        String migratedChecksum = calculateChecksum(migratedData);

        System.out.println("Original Checksum: " + originalChecksum);
        System.out.println("Migrated Checksum: " + migratedChecksum);

        if (originalChecksum.equals(migratedChecksum)) {
            System.out.println("Checksums match. Data integrity preserved.");
        } else {
            System.out.println("Checksums do not match. Data integrity compromised.");
        }
    }
}

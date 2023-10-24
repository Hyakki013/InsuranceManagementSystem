import java.util.Scanner;

public class InsuranceManagementSystem {
    private static final int MAX_POLICIES = 100;
    private static String[] policyNumbers = new String[MAX_POLICIES];
    private static String[] customerNames = new String[MAX_POLICIES];
    private static String[] customerAddresses = new String[MAX_POLICIES];
    private static double[] premiums = new double[MAX_POLICIES];
    private static boolean[] hasClaim = new boolean[MAX_POLICIES];
    private static int policyCount = 0;
    private static String[] policyTypes = new String[MAX_POLICIES];

    private static final String[] predefinedPolicyTypes = {
        "Life Insurance",
        "Health Insurance",
        "Auto Insurance",
        "Home Insurance",
        "Travel Insurance"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n\t\t+-----------------------------------+");
            System.out.println("\t\t| Insurance Management System Menu  |");
            System.out.println("\t\t+-----------------------------------+");
            System.out.println("\t\t|  Option  |          Description   |");
            System.out.println("\t\t+-----------------------------------+");
            System.out.println("\t\t|    1     |    Add Policy          |");
            System.out.println("\t\t|    2     |    Search Policy       |");
            System.out.println("\t\t|    3     |    Update Policy       |");
            System.out.println("\t\t|    4     |    Delete Policy       |");
            System.out.println("\t\t|    5     |    Show Policy List    |");
            System.out.println("\t\t|    6     |    Check Claim Status  |");
            System.out.println("\t\t|    0     |    Exit                |");
            System.out.println("\t\t+-----------------------------------+");
            System.out.print("Enter your choice from the option above: ");
            choice = scanner.nextInt();
            scanner.nextLine();
        
            switch (choice) {
                case 1:
                    addPolicy();
                    break;
                case 2:
                    searchPolicy();
                    break;
                case 3:
                    updatePolicy();
                    break;
                case 4:
                    deletePolicy();
                    break;
                case 5:
                    showPolicyList();
                    break;
                case 6:
                    checkClaimStatus();
                    break;
                case 0:
                    System.out.println("Exiting....");
                    break;
                default:
                    System.out.println("Invalid Input!");
                    break;
            }
        } while (choice != 0);
        
        scanner.close();
    }

    public static void addPolicy() {
        if (policyCount >= MAX_POLICIES) {
            System.out.println("Maximum policies reached. Cannot add more.");
            return;
        }
    
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nPolicy number: ");
        String policyNumber = scanner.nextLine();
    
        for (int i = 0; i < policyCount; i++) {
            if (policyNumbers[i] != null && policyNumbers[i].equalsIgnoreCase(policyNumber)) {
                System.out.println("Policy with this number already exists. Cannot add a duplicate policy.");
                return;
            }
        }
    
        System.out.print("Customer name: ");
        String customerName = scanner.nextLine();
        System.out.print("Customer address: ");
        String customerAddress = scanner.nextLine();
        System.out.print("Premium amount: ");
        double premium = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Has Claim (Yes/No): ");
        String claimInput = scanner.nextLine().toLowerCase();
        boolean claimStatus = claimInput.equals("yes") || claimInput.equals("y");
    
        System.out.println("\nSelect Policy Type:");
        System.out.println("+---------------------------------+");
        System.out.println("|  Number  |  Policy Type         |");
        System.out.println("+---------------------------------+");
        for (int i = 0; i < predefinedPolicyTypes.length; i++) {
            System.out.printf("|  %2d     |  %-20s |\n", (i + 1), predefinedPolicyTypes[i]);
        }
        System.out.println("+---------------------------------+");
    
        System.out.print("Enter the number corresponding to the policy type: ");
        int typeChoice = scanner.nextInt();
        scanner.nextLine();
    
        if (typeChoice >= 1 && typeChoice <= predefinedPolicyTypes.length) {
            String policyType = predefinedPolicyTypes[typeChoice - 1];
    
            policyNumbers[policyCount] = policyNumber;
            customerNames[policyCount] = customerName;
            customerAddresses[policyCount] = customerAddress;
            premiums[policyCount] = premium;
            hasClaim[policyCount] = claimStatus;
            policyTypes[policyCount] = policyType;
            policyCount++;
            System.out.println("Policy added successfully.");
        } else {
            System.out.println("Invalid policy type selection.");
        }
    }
    


    public static void searchPolicy() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSearch Policy");
        System.out.print("Enter Policy Number to search: ");
        String search = scanner.nextLine();
    
        for (int i = 0; i < policyCount; i++) {
            if (policyNumbers[i].equalsIgnoreCase(search)) {
                System.out.println("+-----------------------------------------------------------+");
                System.out.println("|                   Policy Information:                     |");
                System.out.println("+-----------------------------------------------------------+");
                System.out.printf("| Policy Number:      %-38s|\n", policyNumbers[i]);
                System.out.printf("| Customer Name:      %-38s|\n", customerNames[i]);
                System.out.printf("| Customer Address:   %-38s|\n", customerAddresses[i]);
                System.out.printf("| Policy Price:       %-38.2f|\n", premiums[i]);
                System.out.printf("| Has Claim:          %-38s|\n", (hasClaim[i] ? "Yes" : "No"));
                System.out.printf("| Policy Type:        %-38s|\n", policyTypes[i]);
                System.out.println("+-----------------------------------------------------------+");
                return;
            }
        }
        System.out.println("Policy Number not found!");
    }
    

    public static void updatePolicy() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Policy Number to be updated: ");
        String search = scanner.nextLine();
    
        for (int i = 0; i < policyCount; i++) {
            if (policyNumbers[i].equalsIgnoreCase(search)) {
                System.out.print("\nPolicy Number: ");
                String newPolicyNumber = scanner.nextLine();
                System.out.print("Customer Name: ");
                String newCustomerName = scanner.nextLine();
                System.out.print("Customer Address: ");
                String newCustomerAddress = scanner.nextLine();
                System.out.print("Policy Price: ");
                double newPremium = scanner.nextDouble();
                scanner.nextLine();
    
                System.out.println("\nSelect Policy Type:");
                System.out.println("+---------------------------------+");
                System.out.println("|  Number  |  Policy Type         |");
                System.out.println("+---------------------------------+");
                for (int j = 0; j < predefinedPolicyTypes.length; j++) {
                    System.out.printf("|  %2d     |  %-20s  |\n", (j + 1), predefinedPolicyTypes[j]);
                }
                System.out.println("+---------------------------------+");
    
                System.out.print("Enter the number corresponding to the new policy type: ");
                int typeChoice = scanner.nextInt();
                scanner.nextLine();
    
                if (typeChoice >= 1 && typeChoice <= predefinedPolicyTypes.length) {
                    String newPolicyType = predefinedPolicyTypes[typeChoice - 1];
                    policyNumbers[i] = newPolicyNumber;
                    customerNames[i] = newCustomerName;
                    customerAddresses[i] = newCustomerAddress;
                    premiums[i] = newPremium;
                    policyTypes[i] = newPolicyType;
    
                    System.out.print("Has Claim (Y/N): ");
                    String claimInput = scanner.nextLine().toLowerCase();
                    hasClaim[i] = claimInput.equals("y");
    
                    System.out.println("Policy updated successfully!");
                    return;
                } else {
                    System.out.println("Invalid policy type selection. Policy type remains unchanged.");
                    return;
                }
            }
        }
        System.out.println("\n-------Policy Number not found. Update failed.-------\n");
    }
    

    public static void deletePolicy() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Policy Number to be deleted: ");
        String search = scanner.nextLine();

        for (int i = 0; i < policyCount; i++) {
            if (policyNumbers[i].equalsIgnoreCase(search)) {
                System.out.println("Policy Number: " + policyNumbers[i]);
                System.out.println("Has Claim: " + (hasClaim[i] ? "Yes" : "No"));

                System.out.print("Are you sure you want to delete this policy? (y/n): ");
                String confirmation = scanner.nextLine().toLowerCase();
                if (confirmation.equals("y")) {
                    for (int j = i; j < policyCount - 1; j++) {
                        policyNumbers[j] = policyNumbers[j + 1];
                        customerNames[j] = customerNames[j + 1];
                        customerAddresses[j] = customerAddresses[j + 1];
                        premiums[j] = premiums[j + 1];
                        hasClaim[j] = hasClaim[j + 1];
                        policyTypes[j] = policyTypes[j + 1];
                    }
                    policyCount--;
                    policyNumbers[policyCount] = null;
                    customerNames[policyCount] = null;
                    customerAddresses[policyCount] = null;
                    premiums[policyCount] = 0.0;
                    hasClaim[policyCount] = false;
                    policyTypes[policyCount] = null;

                    System.out.println("Policy deleted successfully.");
                    return;
                } else {
                    System.out.println("Deletion canceled.");
                    return;
                }
            }
        }

        System.out.println("\n-------Policy Number not found. Deletion failed.-------\n");
    }

    public static void showPolicyList() {
        if (policyCount == 0) {
            System.out.println("No policies to show.");
            return;
        }

        System.out.println("=============================================================================================================");
        System.out.println("|\t\t\t\t\t\tList of Customers\t\t\t\t\t|");
        System.out.println("=============================================================================================================");
        System.out.printf("| %-14s | %-20s | %-20s | %-10s | %-10s | %-16s |\n", "Policy Numbers", "Customer Name", "Customer Address", "Premiums", "Has Claim", "Policy Type");
        System.out.println("=============================================================================================================");

        for (int i = 0; i < policyCount; i++) {
            System.out.printf("| %-14s | %-20s | %-20s | %-10.2f | %-10s | %-16s |\n",
                    policyNumbers[i], customerNames[i], customerAddresses[i], premiums[i], (hasClaim[i] ? "Yes" : "No"), policyTypes[i]);
        }

        System.out.println("=============================================================================================================");
    }

    public static void checkClaimStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Policy Number to check claim status: ");
        String search = scanner.nextLine();

        for (int i = 0; i < policyCount; i++) {
            if (policyNumbers[i].equalsIgnoreCase(search)) {
                System.out.println("Policy Number: " + policyNumbers[i]);
                System.out.println("Has Claim: " + (hasClaim[i] ? "Yes" : "No"));
                return;
            }
        }
        System.out.println("Policy Number not found!");
    }
}
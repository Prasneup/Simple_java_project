import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Person {
    private int age;
    private String gender;
    private double weight;
    private double height;
    
    public Person(int age, String gender, double weight, double height) {
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
    }
    
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public double getWeight() { return weight; }
    public double getHeight() { return height; }
}

public class NutritionAwarenessSystem {
    private static Map<String, Map<String, Double>> ageNutrientRequirements;
    
    static {
        ageNutrientRequirements = new HashMap<>();
        
        // Children (6-12)
        Map<String, Double> childrenNeeds = new HashMap<>();
        childrenNeeds.put("Protein (g)", 19.0);
        childrenNeeds.put("Calcium (mg)", 1000.0);
        childrenNeeds.put("Iron (mg)", 10.0);
        childrenNeeds.put("Vitamin D (IU)", 600.0);
        childrenNeeds.put("Vitamin C (mg)", 45.0);
        childrenNeeds.put("Zinc (mg)", 8.0);
        ageNutrientRequirements.put("CHILD", childrenNeeds);
        
        // Teenagers (13-19)
        Map<String, Double> teenNeeds = new HashMap<>();
        teenNeeds.put("Protein (g)", 34.0);
        teenNeeds.put("Calcium (mg)", 1300.0);
        teenNeeds.put("Iron (mg)", 11.0);
        teenNeeds.put("Vitamin D (IU)", 600.0);
        teenNeeds.put("Vitamin C (mg)", 65.0);
        teenNeeds.put("Zinc (mg)", 9.0);
        ageNutrientRequirements.put("TEEN", teenNeeds);
        
        // Adults (20-45+)
        Map<String, Double> adultNeeds = new HashMap<>();
        adultNeeds.put("Protein (g)", 46.0);
        adultNeeds.put("Calcium (mg)", 1000.0);
        adultNeeds.put("Iron (mg)", 18.0);
        adultNeeds.put("Vitamin D (IU)", 600.0);
        adultNeeds.put("Vitamin C (mg)", 75.0);
        adultNeeds.put("Zinc (mg)", 11.0);
        ageNutrientRequirements.put("ADULT", adultNeeds);
    }
    
    public static Map<String, Double> getNutrientRequirements(Person person) {
        String ageGroup;
        
        if (person.getAge() >= 6 && person.getAge() <= 12) {
            ageGroup = "CHILD";
        } else if (person.getAge() >= 13 && person.getAge() <= 19) {
            ageGroup = "TEEN";
        } else {
            ageGroup = "ADULT";
        }
        
        return ageNutrientRequirements.get(ageGroup);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to Nutrition Awareness System");
        System.out.println("Please enter your details:");
        
        System.out.print("Age: ");
        int age = scanner.nextInt();
        
        scanner.nextLine(); // Clear buffer
        
        System.out.print("Gender (M/F): ");
        String gender = scanner.nextLine();
        
        System.out.print("Weight (kg): ");
        double weight = scanner.nextDouble();
        
        System.out.print("Height (cm): ");
        double height = scanner.nextDouble();
        
        Person person = new Person(age, gender, weight, height);
        Map<String, Double> requirements = getNutrientRequirements(person);
        
        System.out.println("\nBased on your age group, here are your daily nutrient requirements:");
        System.out.println("================================================");
        
        for (Map.Entry<String, Double> entry : requirements.entrySet()) {
            System.out.printf("%s: %.1f%n", entry.getKey(), entry.getValue());
        }
        
        System.out.println("\nRecommendations for meeting these requirements:");
        System.out.println("1. Protein: Consume lean meats, fish, eggs, legumes");
        System.out.println("2. Calcium: Include dairy products, leafy greens");
        System.out.println("3. Iron: Eat red meat, spinach, fortified cereals");
        System.out.println("4. Vitamin D: Get sunlight exposure, consume fatty fish");
        System.out.println("5. Vitamin C: Eat citrus fruits, bell peppers, broccoli");
        System.out.println("6. Zinc: Eat meat, shellfish, legumes, nuts");
        
        scanner.close();
    }
}
public class Main {
    public static void main(String[] args) {
        Product[] products = {
                new Product(102, "Shoes", "Footwear"),
                new Product(205, "Laptop", "Electronics"),
                new Product(301, "T-shirt", "Clothing"),
                new Product(101, "Smartphone", "Electronics")
        };

        // Linear search
        System.out.println("🔍 Linear Search:");
        Product result1 = LinearSearch.search(products, 205);
        System.out.println(result1 != null ? "Found: " + result1 : "Product not found.");

        // Binary search
        System.out.println("\n🔍 Binary Search:");
        BinarySearch.sortProducts(products); // must sort before binary search
        Product result2 = BinarySearch.search(products, 205);
        System.out.println(result2 != null ? "Found: " + result2 : "Product not found.");
    }
}

import java.util.Arrays;
import java.util.Comparator;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}

public class SearchAlgorithms {

    // Linear Search Implementation
    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.productId == targetId) {
                return product;
            }
        }
        return null; // Not found
    }

    // Binary Search Implementation (Requires sorted array)
    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (products[mid].productId == targetId) {
                return products[mid];
            }
            if (products[mid].productId < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // Not found
    }

    public static void main(String[] args) {
        Product[] inventory = {
            new Product(105, "Laptop", "Electronics"),
            new Product(101, "Mouse", "Electronics"),
            new Product(109, "Desk", "Furniture"),
            new Product(102, "Chair", "Furniture")
        };

        // Linear search can be performed on an unsorted array
        Product foundLinear = linearSearch(inventory, 109);
        
        // Binary search requires the array to be sorted first
        Arrays.sort(inventory, Comparator.comparingInt(p -> p.productId));
        Product foundBinary = binarySearch(inventory, 109);
    }
}
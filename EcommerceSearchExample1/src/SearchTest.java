public class SearchTest {

    public static void main(String[] args) {

        Product[] products = {

            new Product(101,"Laptop","Electronics"),
            new Product(102,"Phone","Electronics"),
            new Product(103,"Shoes","Fashion"),
            new Product(104,"Watch","Accessories"),
            new Product(105,"Bag","Fashion")

        };

        System.out.println("Linear Search:");

        Product result = linearSearch(products,104);

        if(result != null)
            result.display();
        else
            System.out.println("Not Found");

        System.out.println();

        System.out.println("Binary Search:");

        Product result2 = binarySearch(products,103);

        if(result2 != null)
            result2.display();
        else
            System.out.println("Not Found");

    }

    public static Product linearSearch(Product[] products, int id) {

        for(Product p : products) {

            if(p.productId == id)
                return p;

        }

        return null;
        
    }

    public static Product binarySearch(Product[] products, int id) {

        int low = 0;
        int high = products.length - 1;

        while(low <= high) {

            int mid = (low + high) / 2;

            if(products[mid].productId == id)
                return products[mid];

            else if(products[mid].productId < id)
                low = mid + 1;

            else
                high = mid - 1;

        }

        return null;

    }

}
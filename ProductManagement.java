import java.io.*;
import java.util.*;

public class ProductManagement extends Product {
    private List<Product> products = new ArrayList<Product>();

    public void displayProductList() {
        System.out.println("Product list");
        for (int i = 0; i < products.size(); i++) {
            System.out.println("ID: " + products.get(i).getId() + " Product Name: " + products.get(i).getName() + " Price: " + products.get(i).getPrice());
        }
    }

    public void addFile() throws IOException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("D:/File/src/main/java/productfile/product.txt");
            ObjectOutputStream output = new ObjectOutputStream(fileOutputStream);
            output.writeObject(products);
            output.close();
            System.out.println("Ghi file thành công");
        } catch (IOException e) {
            System.out.println("Ghi file không thành công");
        }
    }

    public void readFile() throws IOException {
        List<Product> products;
        try {
            FileInputStream fileInputStream = new FileInputStream("D:/File/src/main/java/productfile/product.txt");
            ObjectInputStream input = new ObjectInputStream(fileInputStream);
            products = (List<Product>) input.readObject();
            for (int i =0; i < products.size(); i++){
                System.out.println(products.get(i));
            }
            input.close();
        } catch (IOException | ClassNotFoundException e){
            System.out.println("Không tìm thấy file");
        }
    }

    public void addProduct(int id, String name, int price){
        products.add(new Product(id, name, price));
    }

    public void addNewProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID");
        int id = scanner.nextInt();
        System.out.println("Enter Product name");
        String name = scanner.next();
        System.out.println("Enter product price");
        int price = scanner.nextInt();
        Product product = new Product(id, name, price);
        products.add(product);
    }

    public void editProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id you want to edit");
        int editId = scanner.nextInt();
        checkEditId(editId);
    }

    public void deleteProductId() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the product id you want to delete");
        int id = scanner.nextInt();
        checkDeleteId(id);
    }

    public void searchProductName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the product you want to search");
        String name = scanner.nextLine();
        checkName(name);
    }

    public void checkName(String name) {
        boolean check = true;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equals(name)) {
                System.out.println("ID: " + products.get(i).getId() + " Name: " + products.get(i).getName() + " Price: " + products.get(i).getPrice());
                check = false;
            }
        }
        if (check) {
            throw new IndexOutOfBoundsException("Product name not found");
        }
    }

    public void checkEditId(int id) {
        boolean check = true;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).getId()) {
                System.out.println("Enter edit product name");
                String name = scanner.next();
                products.get(i).setName(name);
                System.out.println("Enter edit product price");
                int price = scanner.nextInt();
                products.get(i).setPrice(price);
                check = false;
            }
        }
        if (check) {
            throw new IndexOutOfBoundsException("id not found");
        }
    }

    public void checkDeleteId(int id) {
        Product product = null;
        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).getId()) {
                product = products.get(i);
                break;
            }
        }
        if (product != null) {
            products.remove(product);
            System.out.println("delete successful");
        } else {
            throw new IndexOutOfBoundsException("id not found");
        }
    }

    public void sortUpAscending() {
        displayProductList();
        Collections.sort(products, (o1, o2) -> (o1.getPrice() - o2.getPrice()));
        displayProductList();
    }

    public void sortedDescending() {
        displayProductList();
        Collections.sort(products, (o1, o2) -> (o2.getPrice() - o1.getPrice()));
        displayProductList();
    }
}

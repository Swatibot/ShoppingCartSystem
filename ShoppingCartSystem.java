import javax.swing.*;
import java.awt.*;

public class ShoppingCartSystem extends JFrame {

    private JTextArea displayArea;
    private double total = 0;

    public ShoppingCartSystem() {

        setTitle("E-Commerce Shopping Cart System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Heading
        JLabel heading = new JLabel("E-Commerce Shopping Cart", SwingConstants.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 24));
        add(heading, BorderLayout.NORTH);

        // Display Area
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 15));

        displayArea.setText(
                "============== AVAILABLE PRODUCTS ==============\n\n" +
                "1. Laptop          - ₹50000\n" +
                "2. Smartphone      - ₹25000\n" +
                "3. Headphones      - ₹2000\n" +
                "4. Smart Watch     - ₹5000\n" +
                "5. Keyboard        - ₹1500\n" +
                "6. Mouse           - ₹800\n" +
                "7. Printer         - ₹12000\n" +
                "8. Camera          - ₹30000\n" +
                "9. Tablet          - ₹18000\n" +
                "10. Speaker        - ₹3500\n\n" +
                "Click any product button to add it to your cart.\n\n"
        );

        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel(new GridLayout(3, 4, 10, 10));

        JButton laptopBtn = new JButton("Laptop");
        JButton smartphoneBtn = new JButton("Smartphone");
        JButton headphonesBtn = new JButton("Headphones");
        JButton watchBtn = new JButton("Smart Watch");
        JButton keyboardBtn = new JButton("Keyboard");
        JButton mouseBtn = new JButton("Mouse");
        JButton printerBtn = new JButton("Printer");
        JButton cameraBtn = new JButton("Camera");
        JButton tabletBtn = new JButton("Tablet");
        JButton speakerBtn = new JButton("Speaker");
        JButton checkoutBtn = new JButton("Checkout");

        buttonPanel.add(laptopBtn);
        buttonPanel.add(smartphoneBtn);
        buttonPanel.add(headphonesBtn);
        buttonPanel.add(watchBtn);
        buttonPanel.add(keyboardBtn);
        buttonPanel.add(mouseBtn);
        buttonPanel.add(printerBtn);
        buttonPanel.add(cameraBtn);
        buttonPanel.add(tabletBtn);
        buttonPanel.add(speakerBtn);
        buttonPanel.add(checkoutBtn);

        add(buttonPanel, BorderLayout.SOUTH);

        // Action Listeners
        laptopBtn.addActionListener(e -> addProduct("Laptop", 50000));
        smartphoneBtn.addActionListener(e -> addProduct("Smartphone", 25000));
        headphonesBtn.addActionListener(e -> addProduct("Headphones", 2000));
        watchBtn.addActionListener(e -> addProduct("Smart Watch", 5000));
        keyboardBtn.addActionListener(e -> addProduct("Keyboard", 1500));
        mouseBtn.addActionListener(e -> addProduct("Mouse", 800));
        printerBtn.addActionListener(e -> addProduct("Printer", 12000));
        cameraBtn.addActionListener(e -> addProduct("Camera", 30000));
        tabletBtn.addActionListener(e -> addProduct("Tablet", 18000));
        speakerBtn.addActionListener(e -> addProduct("Speaker", 3500));

        checkoutBtn.addActionListener(e -> {
            displayArea.append("\n=================================\n");
            displayArea.append("CHECKOUT\n");
            displayArea.append("Total Amount: ₹" + total + "\n");
            displayArea.append("Order Placed Successfully!\n");
            displayArea.append("Thank You For Shopping!\n");
            displayArea.append("=================================\n");
        });

        setVisible(true);
    }

    private void addProduct(String product, double price) {
        total += price;

        displayArea.append(
                "Added to Cart: " + product +
                " (₹" + price + ")\n" +
                "Current Total: ₹" + total + "\n\n"
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ShoppingCartSystem());
    }
}
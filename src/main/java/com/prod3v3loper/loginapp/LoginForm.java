package com.prod3v3loper.loginapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginForm extends JFrame
{
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton cancelButton;
    private JLabel logoLabel;
    private JLabel titleLabel;
    private JLabel copyrightLabel;

    public LoginForm()
    {
        // Main panel setup
        mainPanel = new JPanel(new GridLayout(1, 2));
        leftPanel = new JPanel(new GridBagLayout());
        rightPanel = new JPanel(new GridBagLayout());

        // Background color for the left panel
        leftPanel.setBackground(new Color(255, 255, 255));

        // Add logo and title
        logoLabel = new JLabel(new ImageIcon(getClass().getResource("/images/p3.png")));
        titleLabel = new JLabel("prod3v3loper");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        // Add copyright label
        copyrightLabel = new JLabel("© 2024 prod3v3loper");
        copyrightLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        copyrightLabel.setForeground(Color.GRAY);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        leftPanel.add(logoLabel, gbc);

        gbc.gridy = 1;
        leftPanel.add(titleLabel, gbc);

        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.PAGE_END;
        leftPanel.add(copyrightLabel, gbc);

        // Username and password fields
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);

        // Styling for input fields
        usernameField.setFont(new Font("Arial", Font.PLAIN, 16));
        passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
        usernameField.setPreferredSize(new Dimension(200, 30));
        passwordField.setPreferredSize(new Dimension(200, 30));

        // Styling for labels
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));

        // Login and cancel buttons
        loginButton = new JButton("Login");
        cancelButton = new JButton("Cancel");
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.WHITE);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);

        Dimension buttonSize = new Dimension(100, 30); // Same size for both buttons
        loginButton.setPreferredSize(buttonSize);
        cancelButton.setPreferredSize(buttonSize);

        // Layout adjustments
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        rightPanel.add(usernameLabel, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        rightPanel.add(usernameField, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        rightPanel.add(passwordLabel, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        rightPanel.add(passwordField, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.insets = new Insets(20, 10, 10, 5);
        rightPanel.add(loginButton, gbc);

        gbc.gridx = 1;
        gbc.insets = new Insets(20, 5, 10, 10);
        rightPanel.add(cancelButton, gbc);

        // Registration link label
        JLabel registerLabel = new JLabel("<html>You have no account? <a href=''>Create one</a></html>");
        registerLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        registerLabel.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                try {
                    Desktop.getDesktop().browse(new URI("http://localhost:8002/"));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        gbc.gridwidth = 2;
        gbc.gridy = 5;
        gbc.gridx = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        rightPanel.add(registerLabel, gbc);

        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);

        // Window settings
        setContentPane(mainPanel);
        setTitle("Login Form");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Window in the middle of the screen
        setVisible(true);

        // Action for the login button
        loginButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (authenticate(username, password)) {
                    // Open the dashboard after successful login
                    new DashboardFrame(username).setVisible(true);
                    dispose(); // Close the login window
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password.");
                }
            }
        });

        // Action for the cancel button
        cancelButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
    }

    private boolean authenticate(String username, String password)
    {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            return resultSet.next(); // If a result is returned, the credentials are correct

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new LoginForm());
    }
}

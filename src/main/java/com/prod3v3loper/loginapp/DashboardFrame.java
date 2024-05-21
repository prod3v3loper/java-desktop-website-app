package com.prod3v3loper.loginapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DashboardFrame extends JFrame
{
    private JPanel menuPanel;
    private JPanel contentPanel;
    private CardLayout cardLayout;

    public DashboardFrame(String username)
    {
        // Window settings
        setTitle("Dashboard");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu panel
        menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setPreferredSize(new Dimension(200, 600));
        menuPanel.setBackground(Color.WHITE);

        // Menu panels separate with a line
        menuPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));

        JButton dashboardButton = createMenuButton("Dashboard");
        JButton accountButton = createMenuButton("Account");
        JButton settingsButton = createMenuButton("Settings");

        menuPanel.add(dashboardButton);
        menuPanel.add(accountButton);
        menuPanel.add(settingsButton);

        // Create content panel
        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);

        // Create different panels
        JPanel dashboardPanel = new JPanel();
        dashboardPanel.add(new JLabel("Welcome to the Dashboard!"));

        JPanel accountPanel = new JPanel();
        accountPanel.add(new JLabel("Username: " + username));

        JPanel settingsPanel = new JPanel();
        settingsPanel.add(new JLabel("Settings"));

        // Add panels to the content panel
        contentPanel.add(dashboardPanel, "Dashboard");
        contentPanel.add(accountPanel, "Account");
        contentPanel.add(settingsPanel, "Settings");

        // Event listener for the buttons
        dashboardButton.addActionListener(e -> cardLayout.show(contentPanel, "Dashboard"));
        accountButton.addActionListener(e -> cardLayout.show(contentPanel, "Account"));
        settingsButton.addActionListener(e -> cardLayout.show(contentPanel, "Settings"));

        // Set layout
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(menuPanel, BorderLayout.WEST);
        getContentPane().add(contentPanel, BorderLayout.CENTER);
    }

    private JButton createMenuButton(String text)
    {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(200, 50));
        button.setMaximumSize(new Dimension(200, 50));
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));

        button.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent e)
            {
                button.setBackground(Color.BLACK);
                button.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                button.setBackground(Color.WHITE);
                button.setForeground(Color.BLACK);
            }

            @Override
            public void mousePressed(MouseEvent e)
            {
                button.setBackground(Color.BLACK);
                button.setForeground(Color.WHITE);
            }
        });

        return button;
    }
}

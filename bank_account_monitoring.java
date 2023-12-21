import java.awt.*;
import java.awt.event.*;

public class bank_account_monitoring extends Frame 
{
    private TextField usernameField;
    private TextField passwordField;
    private Button submitButton;
    private Button resetButton;
    private Image backgroundImage;

    public bank_account_monitoring() 
    {
        setTitle("Login Page");
        setSize(1920, 1080);
        setLayout(null);

        Font headingFont = new Font("Algerian", Font.BOLD, 48);

        Label headingLabel = new Label("BANK MONITORING SYSTEM");
        headingLabel.setFont(headingFont);
        headingLabel.setBounds(280, 200, 700, 100);
        add(headingLabel);

        Label usernameLabel = new Label("Username :");
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        usernameLabel.setBounds(400, 330, 150, 30);
        add(usernameLabel);

        usernameField = new TextField(20);
        usernameField.setBounds(580, 330, 250, 30);
        add(usernameField);

        Label passwordLabel = new Label("Password :");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        passwordLabel.setBounds(400, 390, 150, 30);
        add(passwordLabel);

        passwordField = new TextField(20);
        passwordField.setBounds(580, 390, 250, 30);
        passwordField.setEchoChar('*');
        add(passwordField);

        submitButton = new Button("SUBMIT");
        submitButton.setBackground(Color.GREEN);
        submitButton.setForeground(Color.WHITE);
        submitButton.setBounds(450, 470, 100, 30);
        submitButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                String username = usernameField.getText();
                String password = passwordField.getText();

                if (username.isEmpty() || password.isEmpty()) 
                {
                    System.out.println("Please enter both username and password.");
                } else {
                    System.out.println("Login successful");
                    AccountDetailsChecker();
                }
            }
        });
        add(submitButton);

        resetButton = new Button("Reset");
        resetButton.setBounds(600, 470, 100, 30);
        resetButton.setBackground(Color.RED);
        resetButton.setForeground(Color.WHITE);
        resetButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                usernameField.setText("");
                passwordField.setText("");
            }
        });
        add(resetButton);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        backgroundImage = toolkit.getImage("E:\\image\\s.jpg");

        setVisible(true);

        addWindowListener(new WindowAdapter() 
        {
            public void windowClosing(WindowEvent windowEvent) 
            {
                System.exit(0);
            }
        });
    }

    public void AccountDetailsChecker() 
    {
        AccountDetailsCheckerFrame a = new AccountDetailsCheckerFrame();
        a.setVisible(true);
        dispose();
    }

    @Override
    public void paint(Graphics g) 
    {
        super.paint(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }

    class AccountDetailsCheckerFrame extends Frame implements ActionListener 
    {
        Label bankname;
        Label accountLabel;
        Label passwordLabel;
        Label ifscCodeLabel;
        Choice accountNumberChoice;
        Choice pincodeChoice;
        Choice ifscCodeChoice;
        Button checkButton;
        Button checkDetailsButton;
        Button loanButton;
        Image backgroundImage;

        AccountDetailsCheckerFrame() 
        {
            setTitle("AccountDetailsChecker");
            Font headingFont = new Font("Arial", Font.BOLD, 48);
            bankname = new Label("INDIAN STATE SERVICE BANK");
            bankname.setFont(headingFont);
            bankname.setBounds(280, 200, 700, 100);

            Font labelFont = new Font("Arial", Font.PLAIN, 24);
            accountLabel = new Label("Account Number: ");
            accountLabel.setFont(labelFont);
            accountLabel.setBounds(380, 310, 220, 20);

            accountNumberChoice = new Choice();
            accountNumberChoice.setBounds(620, 310, 200, 30);
            accountNumberChoice.add("106601000012756");
            accountNumberChoice.add("123456789012345");
            accountNumberChoice.add("987654321098765");

            passwordLabel = new Label("Pincode: ");
            passwordLabel.setFont(labelFont);
            passwordLabel.setBounds(380, 380, 220, 20);

            pincodeChoice = new Choice();
            pincodeChoice.setBounds(620, 380, 200, 30);
            pincodeChoice.add("2004");
            pincodeChoice.add("4321");
            pincodeChoice.add("5678");

            ifscCodeLabel = new Label("IFSC Code: ");
            ifscCodeLabel.setFont(labelFont);
            ifscCodeLabel.setBounds(380, 450, 220, 20);

            ifscCodeChoice = new Choice();
            ifscCodeChoice.setBounds(620, 450, 200, 30);
            ifscCodeChoice.add("ABC123");
            ifscCodeChoice.add("DEF456");
            ifscCodeChoice.add("GHI789");

            checkButton = new Button("Check Balance");
            checkButton.setBounds(440, 550, 150, 30);
            checkButton.setBackground(Color.GREEN);
            checkButton.setForeground(Color.WHITE);

            checkDetailsButton = new Button("Check Details");
            checkDetailsButton.setBounds(620, 550, 150, 30);
            checkDetailsButton.setBackground(Color.GREEN);
            checkDetailsButton.setForeground(Color.WHITE);

            loanButton = new Button("Loan");
            loanButton.setBounds(800, 550, 150, 30);
            loanButton.setBackground(Color.BLUE);
            loanButton.setForeground(Color.WHITE);

            add(bankname);
            add(accountLabel);
            add(accountNumberChoice);
            add(passwordLabel);
            add(pincodeChoice);
            add(checkButton);
            add(ifscCodeLabel);
            add(ifscCodeChoice);
            add(checkDetailsButton);
            add(loanButton);
            setLocationRelativeTo(null);
            setSize(1920, 1080);
            setBounds(1, 1, 1500, 1000);
            setLayout(null);

            checkButton.addActionListener(this);
            checkDetailsButton.addActionListener(this);
            loanButton.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    LoanFrame loanFrame = new LoanFrame();
                    loanFrame.setVisible(true);
                }
            });

            Toolkit toolkit = Toolkit.getDefaultToolkit();
            backgroundImage = toolkit.getImage("E:\\image\\bank2.jpg");

            addWindowListener(new WindowAdapter() 
            {
                public void windowClosing(WindowEvent windowEvent) 
                {
                    System.exit(0);
                }
            });
        }

        public void actionPerformed(ActionEvent e) 
        {
            if (e.getSource() == checkButton) 
            {
                String accountNumber = accountNumberChoice.getSelectedItem();
                String pincode = pincodeChoice.getSelectedItem();
                String ifscCode = ifscCodeChoice.getSelectedItem();

                boolean isValid = validateAccountDetails(accountNumber, pincode, ifscCode);

                if (isValid) 
                {
                    showMessageDialog("Account details are valid. Balance: $5000");
                    System.out.println("Account Number: " + accountNumber);
                    System.out.println("Pincode: " + pincode);
                    System.out.println("IFSC Code: " + ifscCode);
                } 
                else 
                {
                    showMessageDialog("Invalid account details. Please try again.");
                    System.out.println("Sorry, try again.");
                }
            } 
            else if (e.getSource() == checkDetailsButton) 
            {
                String accountNumber = accountNumberChoice.getSelectedItem();
                String pincode = pincodeChoice.getSelectedItem();
                String ifscCode = ifscCodeChoice.getSelectedItem();

                CheckDetailsFrame checkDetailsFrame = new CheckDetailsFrame(accountNumber, pincode, ifscCode);
                checkDetailsFrame.setVisible(true);
            }
        }

        boolean validateAccountDetails(String accountNumber, String pincode, String ifscCode) 
        {
            return true;
        }

        void showMessageDialog(String message) 
        {
            Dialog dialog = new Dialog(this, "Message");
            dialog.setSize(300, 150);
            dialog.setLayout(new BorderLayout());
            dialog.setLocationRelativeTo(this);

            Label label = new Label(message);
            label.setForeground(Color.BLUE);
            label.setAlignment(Label.CENTER);
            dialog.add(label, BorderLayout.SOUTH);

            Button okButton = new Button("OK");
            okButton.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    dialog.dispose();
                }
            });
            Panel buttonPanel = new Panel();
            buttonPanel.setBackground(Color.LIGHT_GRAY);
            buttonPanel.add(okButton);
            dialog.add(buttonPanel, BorderLayout.CENTER);

            dialog.setVisible(true);
        }

        @Override
        public void paint(Graphics g) 
        {
            super.paint(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    class CheckDetailsFrame extends Frame 
    {
        Label titleLabel;
        TextArea detailsTextArea;
        Image backgroundImage;

        CheckDetailsFrame(String accountNumber, String pincode, String ifscCode) 
        {
            setTitle("Check Details");
            setSize(800, 600);
            setLayout(new BorderLayout());
            setLocationRelativeTo(null);

            titleLabel = new Label("Account Details");
            titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
            titleLabel.setAlignment(Label.CENTER);
            add(titleLabel, BorderLayout.NORTH);

            Panel detailsPanel = new Panel(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.insets = new Insets(10, 10, 10, 10);

            detailsTextArea = new TextArea();
            detailsTextArea.setEditable(false);
            detailsTextArea.setFont(new Font("Arial", Font.PLAIN, 24));
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.BOTH;
            detailsPanel.add(detailsTextArea, gbc);

            Button closeButton = new Button("Close");
            closeButton.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    dispose();
                }
            });
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.NONE;
            detailsPanel.add(closeButton, gbc);

            Toolkit toolkit = Toolkit.getDefaultToolkit();
            backgroundImage = toolkit.getImage("E:\\image\\lap.jpg");

            add(detailsPanel, BorderLayout.CENTER);

            addWindowListener(new WindowAdapter() 
            {
                public void windowClosing(WindowEvent windowEvent) 
                {
                    dispose();
                }
            });

            String accountDetails = getAccountDetails(accountNumber);
            detailsTextArea.setText(accountDetails);
        }

        String getAccountDetails(String accountNumber) 
        {
            if (accountNumber.equals("106601000012756")) 
            {
                String Name = "Tyson";
                String accountNum = "106601000012756";
                String pin = "2004";
                String phoneNumber = "9944519953";
                String address = "123 Nheru St, Karur, Chennai";
                String openedOn = "01/01/2022";
                double minBalance = 1000.00;
                double maxBalance = 10000.00;

                StringBuilder details = new StringBuilder();
                details.append("Name: ").append(Name).append("\n");
                details.append("Account Number: ").append(accountNum).append("\n");
                details.append("Pincode: ").append(pin).append("\n");
                details.append("Phone Number: ").append(phoneNumber).append("\n");
                details.append("Address: ").append(address).append("\n");
                details.append("Opened On: ").append(openedOn).append("\n");
                details.append("Minimum Balance: $").append(minBalance).append("\n");
                details.append("Maximum Balance: $").append(maxBalance);

                return details.toString();
            } 
            else if (accountNumber.equals("123456789012345")) 
            {
                String Name = "Free Dela Hoya";
                String accountNum = "123456789012345";
                String pin = "4321";
                String phoneNumber = "9564512353";
                String address = "12/3 Gandhi Street, City, Chennai";
                String openedOn = "12/4/2000";
                double minBalance = 1000.00;
                double maxBalance = 500000.00;

                StringBuilder details = new StringBuilder();
                details.append("Name: ").append(Name).append("\n");
                details.append("Account Number: ").append(accountNum).append("\n");
                details.append("Pincode: ").append(pin).append("\n");
                details.append("Phone Number: ").append(phoneNumber).append("\n");
                details.append("Address: ").append(address).append("\n");
                details.append("Opened On: ").append(openedOn).append("\n");
                details.append("Minimum Balance: $").append(minBalance).append("\n");
                details.append("Maximum Balance: $").append(maxBalance);

                return details.toString();

            } 
            else if (accountNumber.equals("987654321098765")) 
            {
                String Name = "Ravi";
                String accountNum = "987654321098765";
                String pin = "5678";
                String phoneNumber = "9876512353";
                String address = "12/3 Bharathi Street, Kattur, Chennai";
                String openedOn = "21/7/2002";
                double minBalance = 1000.00;
                double maxBalance = 50000.00;

                StringBuilder details = new StringBuilder();
                details.append("Name: ").append(Name).append("\n");
                details.append("Account Number: ").append(accountNum).append("\n");
                details.append("Pincode: ").append(pin).append("\n");
                details.append("Phone Number: ").append(phoneNumber).append("\n");
                details.append("Address: ").append(address).append("\n");
                details.append("Opened On: ").append(openedOn).append("\n");
                details.append("Minimum Balance: $").append(minBalance).append("\n");
                details.append("Maximum Balance: $").append(maxBalance);

                return details.toString();
            } 
            else 
            {
                return "Account details not found.";
            }
        }

        @Override
        public void paint(Graphics g) 
        {
            super.paint(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    class LoanFrame extends Frame implements ActionListener 
    {
        public LoanFrame() 
        {
            setTitle("Loan Options");
            setSize(1920, 1080);
            setLayout(new GridLayout(6, 2));
            setLocationRelativeTo(null);

            Font headingFont = new Font("Arial", Font.BOLD, 48);
            Label na = new Label("TYPES OF LOANS AVAILABLE");
            na.setFont(headingFont);
            add(na);

            Button homeLoanButton = new Button("Home Loan");
            homeLoanButton.addActionListener(this);
            add(homeLoanButton);

            Button goldLoanButton = new Button("Gold Loan");
            goldLoanButton.addActionListener(this);
            add(goldLoanButton);

            Button educationalLoanButton = new Button("Educational Loan");
            educationalLoanButton.addActionListener(this);
            add(educationalLoanButton);

            Button vehicleLoanButton = new Button("Vehicle Loan");
            vehicleLoanButton.addActionListener(this);
            add(vehicleLoanButton);

            addWindowListener(new WindowAdapter() 
            {
                public void windowClosing(WindowEvent windowEvent) 
                {
                    dispose();
                }
            });
        }

        public void actionPerformed(ActionEvent e) 
        {
            if (e.getActionCommand().equals("Home Loan")) 
            {
                System.out.println("Home Loan button clicked");
                openCIBILScoreFrame();
            } 
            else if (e.getActionCommand().equals("Gold Loan")) 
            {
                System.out.println("Gold Loan button clicked");
                openCIBILScoreFrame();
            } 
            else if (e.getActionCommand().equals("Educational Loan")) 
            {
                System.out.println("Educational Loan button clicked");
                openCIBILScoreFrame();
            } 
            else if (e.getActionCommand().equals("Vehicle Loan")) 
            {
                System.out.println("Vehicle Loan button clicked");
                openCIBILScoreFrame();
            }
        }

        void openCIBILScoreFrame() 
        {
            CIBILScoreFrame cibilScoreFrame = new CIBILScoreFrame();
            cibilScoreFrame.setVisible(true);
        }
    }

    class CIBILScoreFrame extends Frame 
    {
        Image cibilbackgroundImage;

        CIBILScoreFrame() 
        {
            setTitle("CIBIL Score");
            setSize(800, 600);
            
            setLocationRelativeTo(null);

            Toolkit toolkit = Toolkit.getDefaultToolkit();
            cibilbackgroundImage = toolkit.getImage("E:\\image\\bank.jpg");
            //add(cibilbackgroundImage);

            
            Label titleLabel = new Label("CIBIL Score Checking");
            titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
            titleLabel.setAlignment(Label.CENTER);
            add(titleLabel, BorderLayout.NORTH);

            Label emailLabel = new Label("Email Address:");
            TextField emailField = new TextField(30);
            Label nameLabel = new Label("Name:");
            TextField nameField = new TextField(30);
            Label idTypeLabel = new Label("ID Type:");

            Choice idTypeChoice = new Choice();
            idTypeChoice.add("Aadhaar Card");
            idTypeChoice.add("Passport");
            idTypeChoice.add("Driver's License");

            Label idNumberLabel = new Label("ID Number:");
            TextField idNumberField = new TextField(30);

            Label dobLabel = new Label("Date of Birth:");
            TextField dobField = new TextField(30);

            Label pincodeLabel = new Label("Pancard_no:");
            TextField pincodeField = new TextField(30);

            Label monthlyIncomeLabel = new Label("Monthly Income:");
            TextField monthlyIncomeField = new TextField(30);

            Button checkScoreButton = new Button("Check CIBIL Score");
            checkScoreButton.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    String email = emailField.getText();
                    String name = nameField.getText();
                    String idType = idTypeChoice.getSelectedItem();
                    String idNumber = idNumberField.getText();
                    String dob = dobField.getText();
                    String pincode = pincodeField.getText();
                    String monthlyIncome = monthlyIncomeField.getText();

                    System.out.println("Email: " + email);
                    System.out.println("Name: " + name);
                    System.out.println("ID Type: " + idType);
                    System.out.println("ID Number: " + idNumber);
                    System.out.println("DOB: " + dob);
                    System.out.println("Pincode: " + pincode);
                    System.out.println("Monthly Income: " + monthlyIncome);

                    EligibilityFrame eligibilityFrame = new EligibilityFrame();
                    eligibilityFrame.setVisible(true);
                }
            });

            Panel formPanel = new Panel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.anchor = GridBagConstraints.WEST;
            gbc.insets = new Insets(10, 10, 10, 10);

            gbc.gridx = 0;
            gbc.gridy = 0;
            formPanel.add(emailLabel, gbc);
            gbc.gridx = 1;
            formPanel.add(emailField, gbc);

            gbc.gridx = 0;
            gbc.gridy = 1;
            formPanel.add(nameLabel, gbc);
            gbc.gridx = 1;
            formPanel.add(nameField, gbc);

            gbc.gridx = 0;
            gbc.gridy = 2;
            formPanel.add(idTypeLabel, gbc);
            gbc.gridx = 1;
            formPanel.add(idTypeChoice, gbc);

            gbc.gridx = 0;
            gbc.gridy = 3;
            formPanel.add(idNumberLabel, gbc);
            gbc.gridx = 1;
            formPanel.add(idNumberField, gbc);

            gbc.gridx = 0;
            gbc.gridy = 4;
            formPanel.add(dobLabel, gbc);
            gbc.gridx = 1;
            formPanel.add(dobField, gbc);

            gbc.gridx = 0;
            gbc.gridy = 5;
            formPanel.add(pincodeLabel, gbc);
            gbc.gridx = 1;
            formPanel.add(pincodeField, gbc);

            gbc.gridx = 0;
            gbc.gridy = 6;
            formPanel.add(monthlyIncomeLabel, gbc);
            gbc.gridx = 1;
            formPanel.add(monthlyIncomeField, gbc);

            gbc.gridx = 0;
            gbc.gridy = 7;
            gbc.gridwidth = 2;
            gbc.anchor = GridBagConstraints.CENTER;
            formPanel.add(checkScoreButton, gbc);

            add(formPanel);
            addWindowListener(new WindowAdapter() 
            {
                public void windowClosing(WindowEvent windowEvent) 
                {
                    dispose();
                }
            });
        }
        @Override
        public void paint(Graphics g) 
        {
            super.paint(g);
            g.drawImage(cibilbackgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    class EligibilityFrame extends Frame 
    {
        Image ebbackgroundImage;
        EligibilityFrame() 
        {
            setTitle("Loan Eligibility");
            setSize(800, 600);
            //setLayout(null);
            setLocationRelativeTo(null);

            Toolkit toolkit = Toolkit.getDefaultToolkit();
            ebbackgroundImage = toolkit.getImage("E:\\image\\bank.jpg");
    
            Label cibilScoreLabel;
            TextField cibilScoreTextField;
            Button checkEligibilityButton;
            Panel loanPanel = new Panel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.anchor = GridBagConstraints.WEST;
            gbc.insets = new Insets(10, 10, 10, 10);
    
            Font headingFont = new Font("Arial", Font.BOLD, 48);
            Label loanEligibilityLabel = new Label("Loan Eligibility");
            loanEligibilityLabel.setFont(headingFont);
            loanPanel.add(loanEligibilityLabel, gbc);
    
            Label nameLabel = new Label("Name: ");
            nameLabel.setFont(new Font("Arial", Font.PLAIN, 24));
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.NONE;
            loanPanel.add(nameLabel, gbc);
    
            TextField nameTextField = new TextField(20);
            nameTextField.setFont(new Font("Arial", Font.PLAIN, 24));
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            loanPanel.add(nameTextField, gbc);
    
            Label loanAmountLabel = new Label("Loan Amount: ");
            loanAmountLabel.setFont(new Font("Arial", Font.PLAIN, 24));
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.fill = GridBagConstraints.NONE;
            loanPanel.add(loanAmountLabel, gbc);
    
            TextField loanAmountTextField = new TextField(20);
            loanAmountTextField.setFont(new Font("Arial", Font.PLAIN, 24));
            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            loanPanel.add(loanAmountTextField, gbc);
    
            cibilScoreLabel = new Label("CIBIL Score: ");
            cibilScoreLabel.setFont(new Font("Arial", Font.PLAIN, 24));
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.fill = GridBagConstraints.NONE;
            loanPanel.add(cibilScoreLabel, gbc);
    
            cibilScoreTextField = new TextField(20);
            cibilScoreTextField.setFont(new Font("Arial", Font.PLAIN, 24));
            gbc.gridx = 1;
            gbc.gridy = 2;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            loanPanel.add(cibilScoreTextField, gbc);
    
            checkEligibilityButton = new Button("Check Eligibility");
            checkEligibilityButton.setFont(new Font("Arial", Font.BOLD, 24));
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.gridwidth = 2;
            gbc.anchor = GridBagConstraints.CENTER;
            loanPanel.add(checkEligibilityButton, gbc);
    
            checkEligibilityButton.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    String name = nameTextField.getText();
                    double loanAmount = Double.parseDouble(loanAmountTextField.getText());
                    int cibilScore = Integer.parseInt(cibilScoreTextField.getText());
    
                    String message;
                    if (cibilScore > 750) {
                        message = "Congratulations, " + name + "! You are eligible to apply for a loan of amount $" + loanAmount;
                    } else {
                        message = "Sorry, " + name + ". You are not eligible to apply for a loan.";
                    }
    
                    showMessageDialog(message);
                }
            });
    
            add(loanPanel);
            addWindowListener(new WindowAdapter() 
            {
                public void windowClosing(WindowEvent windowEvent) 
                {
                    dispose();
                }
            });
        }
    
        void showMessageDialog(String message) 
        {
            Dialog dialog = new Dialog(this, "Loan Eligibility");
            dialog.setSize(300, 150);
            dialog.setLayout(new BorderLayout());
            dialog.setLocationRelativeTo(this);
    
            Label label = new Label(message);
            label.setForeground(Color.BLUE);
            label.setAlignment(Label.CENTER);
            dialog.add(label, BorderLayout.SOUTH);
    
            Button okButton = new Button("OK");
            okButton.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    dialog.dispose();
                }
            });
            Panel buttonPanel = new Panel();
            buttonPanel.setBackground(Color.LIGHT_GRAY);
            buttonPanel.add(okButton);
            dialog.add(buttonPanel, BorderLayout.CENTER);
    
            dialog.setVisible(true);
        }
        @Override
        public void paint(Graphics g) 
        {
            super.paint(g);
            g.drawImage(ebbackgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
    

    public static void main(String[] args) 
    {
        new bank_account_monitoring();
    }
}

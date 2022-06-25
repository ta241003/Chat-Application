//package server;
//
//import java.awt.BorderLayout;
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//
//import server.MainScreen;
//
//import java.awt.Toolkit;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//
//import java.awt.Font;
//import javax.swing.JTextField;
//import javax.swing.JPasswordField;
//import javax.swing.JButton;
//import javax.swing.ImageIcon;
//import java.awt.Color;
//import java.awt.Dialog.ModalExclusionType;
//
//public class LoginServer extends JFrame implements ActionListener{
//
//	static Connection conn;
//    static String sql = "";
//    static PreparedStatement preparedStatement;
//    static ResultSet rs;
//	private JPanel contentPane;
//	private JTextField textField;
//	private JPasswordField passwordField;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		new LoginServer();
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//					LoginServer frame = new LoginServer();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public LoginServer() {
//		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
//		setAlwaysOnTop(true);
//		setAutoRequestFocus(false);
//		setTitle("Login Server");
//		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\ChatApplication\\ChatServer\\files\\login-icon.png"));
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 684, 450);
//		contentPane = new JPanel();
//		contentPane.setBackground(Color.PINK);
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		JLabel lblNewLabel = new JLabel("Username");
//		lblNewLabel.setBounds(74, 145, 129, 25);
//		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 24));
//		contentPane.add(lblNewLabel);
//		
//		JLabel lblNewLabel_1 = new JLabel("Password");
//		lblNewLabel_1.setBounds(76, 247, 113, 25);
//		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 24));
//		contentPane.add(lblNewLabel_1);
//		
//		textField = new JTextField();
//		textField.setBounds(238, 145, 277, 29);
//		contentPane.add(textField);
//		textField.setColumns(10);
//		
//		passwordField = new JPasswordField();
//		passwordField.setBounds(238, 247, 277, 29);
//		contentPane.add(passwordField);
//		
//		JButton btnNewButton = new JButton("Login");
//		btnNewButton.setBounds(166, 326, 113, 53);
//		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
//		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Acer\\OneDrive\\Pictures\\Saved Pictures\\login.png"));
//		btnNewButton.addActionListener(this);
//		contentPane.add(btnNewButton);
//		
//		JButton btnNewButton_1 = new JButton("Exit");
//		btnNewButton_1.setBounds(359, 326, 118, 53);
//		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
//		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Acer\\OneDrive\\Pictures\\Saved Pictures\\cancel.png"));
//		btnNewButton_1.addActionListener(this);
//		contentPane.add(btnNewButton_1);
//		
//		JLabel lblNewLabel_2 = new JLabel("Welcome, please login to continue !");
//		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
//		lblNewLabel_2.setBounds(122, 26, 480, 40);
//		contentPane.add(lblNewLabel_2);
//		
//   
//        setLocationRelativeTo(null);
//	}
//	
//	public void checkLogin() {
//        String na = textField.getText();
//        String pass = passwordField.getText();
//        if(na.equals("") || pass.equals(""))
//        {
//            JOptionPane.showMessageDialog(null, "You need to enter enough account information and password", "Alert",JOptionPane.WARNING_MESSAGE);
//        }
//        else
//        {
//            try {
//                conn = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-1B9TLU6P;databaseName=ChatApplication;user=sa;password=Theanh241003");
//                sql = "select * from FormLogin where username = ? and password = ?";
//                preparedStatement = conn.prepareStatement(sql);
//                preparedStatement.setString(1, na);
//                preparedStatement.setString(2, pass);
//                rs = preparedStatement.executeQuery();
//                if(rs.next())
//                {
//                    System.out.println("Success");
//                    this.setVisible(true);
//                	new MainScreen(); 
//                }
//                else 
//                {	
//                	JOptionPane.showMessageDialog(null, "Wrong username or password", "Alert",JOptionPane.WARNING_MESSAGE);
////                	System.out.println("Wrong username or password");
//                }
//
//            } catch (Exception e) {
//                //TODO: handle exception
//                System.out.println(e.getMessage());
//                System.out.println(sql);
//            }
//        }
//    }
//	@Override
//    public void actionPerformed(ActionEvent e) {
//        // TODO Auto-generated method stub
//        if(e.getActionCommand().equals("Login"))
//        {   
//           checkLogin();
//           this.setVisible(false);
//        }
//        else
//        {   
//        	System.exit(0);
//        }
//    }
//}

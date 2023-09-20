package front;

import back.MarketPlace;
import back.Product;
import back.ProductNotFoundException;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class GUI extends JFrame {

    public GUI() {
        initComponents();
    }
    private void initComponents() {

        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jButton5 = new JButton();
        jButton6 = new JButton();
        jButton7 = new JButton();

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 48)); // NOI18N
        jLabel1.setText("Market");

        jButton3.setText("register");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("search");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("remove");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("modify");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("exit");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton6)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel1))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(47, 47, 47)
                                                .addComponent(jButton7)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton3)
                                        .addComponent(jButton4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton6)
                                        .addComponent(jButton5))
                                .addGap(18, 18, 18)
                                .addComponent(jButton7)
                                .addContainerGap(15, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }



    private void jButton3ActionPerformed(ActionEvent evt) { //cadastrar
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do produto: "));
        String nome = JOptionPane.showInputDialog("Digite o nome do produto: ");
        int quant = Integer.parseInt(JOptionPane.showInputDialog("Digite o quantidade do produto: "));
        double preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do produto: "));
        Product p = new Product(codigo, nome, quant, preco);
        if(sistema.registerProduct(p)) {
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        }
    }

    private void jButton4ActionPerformed(ActionEvent evt) { //pesquisar
        int code = Integer.parseInt(JOptionPane.showInputDialog("Digite o código que deseja pesquisar: "));

        try {
            Product p = sistema.searchProduct(code);
            JOptionPane.showMessageDialog(null, p);
        } catch (ProductNotFoundException e) {

        }
    }

    private void jButton5ActionPerformed(ActionEvent evt) { //remover
        int code =  Integer.parseInt(JOptionPane.showInputDialog("Digite o código do produto que deseja remover: "));
        try {
            Product p = sistema.searchProduct(code);
            if(sistema.removeProduct(p)) {
                JOptionPane.showMessageDialog(null, "Produto removido com sucesso!");
            }
        } catch (ProductNotFoundException e) {

        }
    }
    private void jButton6ActionPerformed(ActionEvent evt) { //modificar
        int code = Integer.parseInt(JOptionPane.showInputDialog("Digite o código que deseja pesquisar: "));
        try {
            Product p = sistema.searchProduct(code);
            int amount = Integer.parseInt(JOptionPane.showInputDialog("Digite a nova quantidade de produtos: "));
            if(sistema.modifyAmountProduct(p, amount)) {
                JOptionPane.showMessageDialog(null,"Produto modificado com sucesso!");
            }
        } catch (ProductNotFoundException e) {

        }

    }

    private void jButton7ActionPerformed(ActionEvent evt) {
        sistema.sairDoSistema(); //gravando
        System.exit(0);
    }

    public static void main(String args[]) {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    MarketPlace sistema = new MarketPlace();

    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton6;
    private JButton jButton7;
    private JLabel jLabel1;
    private JPanel jPanel1;

}

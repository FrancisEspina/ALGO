import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Input extends javax.swing.JPanel {
    public Input() {
       initComponents();
    }
    public static ArrayList<Integer> arrivalArray = new ArrayList<Integer>();
    public static ArrayList<Integer> burstArray = new ArrayList<Integer>();
    public static ArrayList<Integer> pidArray = new ArrayList<Integer>();
    public static ArrayList<Integer> general_burst = new ArrayList<Integer>();
    public static ArrayList<Integer> general_arrival = new ArrayList<Integer>();
    public static ArrayList<Integer> general_priority = new ArrayList<Integer>();


    private void initComponents() {
        minimize = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        input_labels = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        input_table = new javax.swing.JTable();
        input_burstIn = new javax.swing.JTextField();
        input_arrivalIn = new javax.swing.JTextField();
        input_prioIn = new javax.swing.JTextField();
        input_quantumIn = new javax.swing.JTextField();
        input_fms = new javax.swing.JLabel();
        input_quantum = new javax.swing.JLabel();
        input_input5 = new javax.swing.JLabel();
        input_priority = new javax.swing.JLabel();
        input_input4 = new javax.swing.JLabel();
        input_arrival = new javax.swing.JLabel();
        input_input3 = new javax.swing.JLabel();
        input_burst = new javax.swing.JLabel();
        input_input2 = new javax.swing.JLabel();
        input_algo = new javax.swing.JLabel();
        input_random = new javax.swing.JButton();
        input_simulate = new javax.swing.JButton();
        input_import = new javax.swing.JButton();
        input_input = new javax.swing.JButton();
        input_return = new javax.swing.JButton();
        input_vol = new javax.swing.JButton();
        input_bg = new javax.swing.JLabel();

        setLayout(null);

        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/window/minimize.png"))); 
        minimize.setBorder(null);
        minimize.setBorderPainted(false);
        minimize.setContentAreaFilled(false);
        minimize.setFocusPainted(false);
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimizeMouseExited(evt);
            }
        });
        minimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizeActionPerformed(evt);
            }
        });
        add(minimize);
        minimize.setBounds(1190, 10, 40, 40);

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/window/close.png"))); 
        exit.setBorder(null);
        exit.setBorderPainted(false);
        exit.setContentAreaFilled(false);
        exit.setFocusPainted(false);
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitMouseExited(evt);
            }
        });
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        add(exit);
        exit.setBounds(1230, 10, 40, 40);

        input_labels.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        input_labels.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/input/input_labels.png"))); 
        input_labels.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(input_labels);
        input_labels.setBounds(570, 110, 580, 90);

        input_table.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); 
        input_table.setFocusable(false);
        input_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        input_table.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(input_table);
        if (input_table.getColumnModel().getColumnCount() > 0) {
            input_table.getColumnModel().getColumn(0).setResizable(false);
            input_table.getColumnModel().getColumn(0).setPreferredWidth(10);
            input_table.getColumnModel().getColumn(1).setResizable(false);
            input_table.getColumnModel().getColumn(1).setPreferredWidth(100);
            input_table.getColumnModel().getColumn(2).setResizable(false);
            input_table.getColumnModel().getColumn(2).setPreferredWidth(90);
            input_table.getColumnModel().getColumn(3).setResizable(false);
            input_table.getColumnModel().getColumn(3).setPreferredWidth(80);
        }

        add(jScrollPane2);
        jScrollPane2.setBounds(580, 190, 560, 402);

        input_burstIn.setFont(new java.awt.Font("Poppins SemiBold", 0, 24)); 
        input_burstIn.setForeground(new java.awt.Color(153, 153, 153));
        input_burstIn.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        input_burstIn.setText("1-30");
        input_burstIn.setToolTipText("1-30");
        input_burstIn.setBorder(null);
        input_burstIn.setOpaque(false);
        input_burstIn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                input_burstInFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                input_burstInFocusLost(evt);
            }
        });
        add(input_burstIn);
        input_burstIn.setBounds(390, 250, 130, 50);

        input_arrivalIn.setFont(new java.awt.Font("Poppins SemiBold", 0, 24)); 
        input_arrivalIn.setForeground(new java.awt.Color(153, 153, 153));
        input_arrivalIn.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        input_arrivalIn.setText("1-30");
        input_arrivalIn.setToolTipText("1-30");
        input_arrivalIn.setBorder(null);
        input_arrivalIn.setOpaque(false);
        input_arrivalIn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                input_arrivalInFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                input_arrivalInFocusLost(evt);
            }
        });
        add(input_arrivalIn);
        input_arrivalIn.setBounds(390, 310, 130, 50);

        input_prioIn.setFont(new java.awt.Font("Poppins SemiBold", 0, 24)); 
        input_prioIn.setForeground(new java.awt.Color(153, 153, 153));
        input_prioIn.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        input_prioIn.setText("1-30");
        input_prioIn.setToolTipText("1-30");
        input_prioIn.setBorder(null);
        input_prioIn.setOpaque(false);
        input_prioIn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                input_prioInFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                input_prioInFocusLost(evt);
            }
        });
        add(input_prioIn);
        input_prioIn.setBounds(390, 370, 130, 50);

        input_quantumIn.setFont(new java.awt.Font("Poppins SemiBold", 0, 24)); 
        input_quantumIn.setForeground(new java.awt.Color(153, 153, 153));
        input_quantumIn.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        input_quantumIn.setText("1-10");
        input_quantumIn.setToolTipText("1-10");
        input_quantumIn.setBorder(null);
        input_quantumIn.setOpaque(false);
        input_quantumIn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                input_quantumInFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                input_quantumInFocusLost(evt);
            }
        });
        add(input_quantumIn);
        input_quantumIn.setBounds(390, 430, 130, 50);

        input_fms.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/select/fms-dark.png"))); 
        input_fms.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(input_fms);
        input_fms.setBounds(1030, 20, 240, 130);

        input_quantum.setFont(new java.awt.Font("Poppins Black", 0, 32)); 
        input_quantum.setForeground(new java.awt.Color(255, 255, 255));
        input_quantum.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        input_quantum.setText("Time Quantum:");
        add(input_quantum);
        input_quantum.setBounds(90, 430, 280, 50);

        input_input5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/input/input_box.png"))); 
        input_input5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(input_input5);
        input_input5.setBounds(390, 430, 130, 50);

        input_priority.setFont(new java.awt.Font("Poppins Black", 0, 32)); 
        input_priority.setForeground(new java.awt.Color(255, 255, 255));
        input_priority.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        input_priority.setText("Priority:");
        add(input_priority);
        input_priority.setBounds(90, 370, 280, 50);

        input_input4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/input/input_box.png"))); 
        input_input4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(input_input4);
        input_input4.setBounds(390, 370, 130, 50);

        input_arrival.setFont(new java.awt.Font("Poppins Black", 0, 32)); 
        input_arrival.setForeground(new java.awt.Color(255, 255, 255));
        input_arrival.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        input_arrival.setText("Arrival Time:");
        add(input_arrival);
        input_arrival.setBounds(90, 310, 280, 50);

        input_input3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/input/input_box.png"))); 
        input_input3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(input_input3);
        input_input3.setBounds(390, 310, 130, 50);

        input_burst.setFont(new java.awt.Font("Poppins Black", 0, 32)); 
        input_burst.setForeground(new java.awt.Color(255, 255, 255));
        input_burst.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        input_burst.setText("Burst Time:");
        add(input_burst);
        input_burst.setBounds(90, 250, 280, 50);

        input_input2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/input/input_box.png"))); 
        input_input2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(input_input2);
        input_input2.setBounds(390, 250, 130, 50);

        input_algo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/input/fcfs-title.png"))); 
        input_algo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(input_algo);
        input_algo.setBounds(110, 70, 470, 110);

        input_random.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/input/random.png"))); 
        input_random.setBorder(null);
        input_random.setBorderPainted(false);
        input_random.setContentAreaFilled(false);
        input_random.setFocusPainted(false);
        input_random.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                input_randomMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                input_randomMouseExited(evt);
            }
        });
        input_random.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_randomActionPerformed(evt);
            }
        });
        add(input_random);
        input_random.setBounds(280, 580, 160, 50);

        input_simulate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/input/simulate.png"))); 
        input_simulate.setBorder(null);
        input_simulate.setBorderPainted(false);
        input_simulate.setContentAreaFilled(false);
        input_simulate.setFocusPainted(false);
        input_simulate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                input_simulateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                input_simulateMouseExited(evt);
            }
        });
        input_simulate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_simulateActionPerformed(evt);
            }
        });
        add(input_simulate);
        input_simulate.setBounds(760, 630, 190, 50);

        input_import.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/input/import.png"))); 
        input_import.setBorder(null);
        input_import.setBorderPainted(false);
        input_import.setContentAreaFilled(false);
        input_import.setFocusPainted(false);
        input_import.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                input_importMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                input_importMouseExited(evt);
            }
        });
        input_import.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_importActionPerformed(evt);
            }
        });
        add(input_import);
        input_import.setBounds(200, 520, 150, 50);

        input_input.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/input/input.png"))); 
        input_input.setBorder(null);
        input_input.setBorderPainted(false);
        input_input.setContentAreaFilled(false);
        input_input.setFocusPainted(false);
        input_input.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                input_inputMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                input_inputMouseExited(evt);
            }
        });
        input_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_inputActionPerformed(evt);
            }
        });
        add(input_input);
        input_input.setBounds(370, 520, 150, 50);

        input_return.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/window/return.png"))); 
        input_return.setBorder(null);
        input_return.setBorderPainted(false);
        input_return.setContentAreaFilled(false);
        input_return.setFocusPainted(false);
        input_return.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                input_returnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                input_returnMouseExited(evt);
            }
        });
        input_return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_returnActionPerformed(evt);
            }
        });
        add(input_return);
        input_return.setBounds(1180, 620, 70, 70);

        input_vol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/menu/buttons/mute.png"))); 
        input_vol.setBorder(null);
        input_vol.setBorderPainted(false);
        input_vol.setContentAreaFilled(false);
        input_vol.setFocusPainted(false);
        input_vol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                input_volMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                input_volMouseExited(evt);
            }
        });
        input_vol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_volActionPerformed(evt);
            }
        });
        add(input_vol);
        input_vol.setBounds(50, 630, 60, 50);

        input_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/input/input_bg.png"))); 
        input_bg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        input_bg.setOpaque(true);
        add(input_bg);
        input_bg.setBounds(0, 0, 1280, 720);
    }

    private void input_returnMouseEntered(java.awt.event.MouseEvent evt) {                                          
        input_return.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/window/return_hover.png")));
    }                                         

    private void input_returnMouseExited(java.awt.event.MouseEvent evt) {                                         
        input_return.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/window/return.png")));
    }                                        

    public void input_returnActionPerformed(java.awt.event.ActionEvent evt) {   

        Music.sfx();
        count = 1;
        ALGO.card.show(ALGO.mainPanel, "1");
        arrivalArray.clear();
        burstArray.clear();
        pidArray.clear();
        DefaultTableModel model = (DefaultTableModel) input_table.getModel();
        model.setRowCount(0);

        input_burstIn.setText("");
        input_arrivalIn.setText("");
        input_prioIn.setText("");
        input_quantumIn.setText("");

        input_burstInFocusLost(null);
        input_arrivalInFocusLost(null);
        input_prioInFocusLost(null);
        input_quantumInFocusLost(null);
    }                                            

    private void input_importMouseEntered(java.awt.event.MouseEvent evt) {                                          
        input_import.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/input/import_hover.png")));
    }                                         

    private void input_importMouseExited(java.awt.event.MouseEvent evt) {                                         
        input_import.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/input/import.png")));
    }                                        

    private void input_importActionPerformed(java.awt.event.ActionEvent evt) {                                             
        Music.sfx();

        final JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(null);

        File file = fc.getSelectedFile();
        try (Scanner read = new Scanner(file)) {
            read.useDelimiter(",");
           
            String process, burst, arrival, priority;
            int id = 0;
            while (read.hasNext()) {
                id++;
                process = read.next().trim();
                burst = read.next();
                arrival = read.next();
                priority = read.next();
                javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel)input_table.getModel();
                Object[] row = { "P"+ id, burst, arrival, "--" };
                model.addRow(row);

                if(ALGO.select.algo == "fcfs"){
                    input_to_fcfs(id, Integer.parseInt(burst), Integer.parseInt(arrival));
                    count = id + 1;
                }

            }
            read.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
        
    }                                            

    private void input_inputMouseEntered(java.awt.event.MouseEvent evt) {                                         
        input_input.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/input/input_hover.png")));
    }                                        

    private void input_inputMouseExited(java.awt.event.MouseEvent evt) {                                        
        input_input.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/input/input.png")));
    }       

    public int counter = 0;

    public void input_to_fcfs(int pid, int burst, int arrival){
        pidArray.add(pid);
        arrivalArray.add(burst);
        burstArray.add(arrival);
        
        System.out.println(pidArray);
        System.out.println(arrivalArray);
        System.out.println(burstArray);
    }

    public void input_to_rr(int pid, int burst, int arrival, int quantum){
        pidArray.add(pid);
        arrivalArray.add(burst);
        burstArray.add(arrival);
        
      
    }

    public void input_inputActionPerformed(java.awt.event.ActionEvent evt) {                                            
        Music.sfx();
        System.out.println(ALGO.select.algo);
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel)input_table.getModel();
        try {
            if(count == 20){
                JOptionPane.showMessageDialog(null, "Twenty (20) Processes Only");
                return;
            }
            
            if(ALGO.select.algo == "fcfs") {
                System.out.println("fcfs selected");
                int id = count;
                int burst = Integer.parseInt(input_burstIn.getText());
                int arrival = Integer.parseInt(input_arrivalIn.getText());
                
                if(burst > 30 | burst < 1 | arrival > 30 | arrival < 1) {
                    return;
                }
                input_to_fcfs(id, burst, arrival);
                Object[] row = { "P"+ id, burst, arrival, "--" };
                model.addRow(row);
                count++;
                
                if (input_table.getColumnModel().getColumnCount() > 0) {
                    javax.swing.table.DefaultTableCellRenderer cellRenderer = new javax.swing.table.DefaultTableCellRenderer();
                    cellRenderer.setHorizontalAlignment(javax.swing.JLabel.CENTER);
                }
            }
            else if(ALGO.select.algo == "rr"){
                
                System.out.println("rr selected");
                int id = count;
                int burst = Integer.parseInt(input_burstIn.getText());
                int arrival = Integer.parseInt(input_arrivalIn.getText());
                int quantum = Integer.parseInt(input_quantumIn.getText());
                input_to_rr(id, burst, arrival, quantum);
                count++;
            }
            else if(ALGO.select.algo == "prio-np"){
                count++;
                System.out.println("prio-np selected");
                int id = count;
                int burst = Integer.parseInt(input_burstIn.getText());
                int arrival = Integer.parseInt(input_arrivalIn.getText());
                //int prio = Integer.parseInt(input_prioIn.getText());
                //int quantum = Integer.parseInt(input_quantumIn.getText());
                
            }
            else if(ALGO.select.algo == "prio-p"){
                count++;
                System.out.println("prio-p selected");
                int id = count;
                int burst = Integer.parseInt(input_burstIn.getText());
                int arrival = Integer.parseInt(input_arrivalIn.getText());
                //int prio = Integer.parseInt(input_prioIn.getText());
                //int quantum = Integer.parseInt(input_quantumIn.getText());

            }
            else if(ALGO.select.algo == "sjf-np"){
                count++;
                System.out.println("sjf-np selected");
                int id = count;
                int burst = Integer.parseInt(input_burstIn.getText());
                int arrival = Integer.parseInt(input_arrivalIn.getText());
                //int prio = Integer.parseInt(input_prioIn.getText());
                //int quantum = Integer.parseInt(input_quantumIn.getText());
                
            }
            else if(ALGO.select.algo == "sjf-p"){
                count++;
                System.out.println("sjf-p selected");
                int id = count;
                int burst = Integer.parseInt(input_burstIn.getText());
                int arrival = Integer.parseInt(input_arrivalIn.getText());
                //int prio = Integer.parseInt(input_prioIn.getText());
                //int quantum = Integer.parseInt(input_quantumIn.getText());

            }
        } catch (Exception e) {
            return;
        }

        input_burstIn.setText("");
        input_arrivalIn.setText("");
        input_prioIn.setText("");
        input_quantumIn.setText("");

        input_burstInFocusLost(null);
        input_arrivalInFocusLost(null);
        input_prioInFocusLost(null);
        input_quantumInFocusLost(null);
    }

    private void input_randomMouseEntered(java.awt.event.MouseEvent evt) {                                          
        input_random.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/input/random_hover.png")));
    }                                         

    private void input_randomMouseExited(java.awt.event.MouseEvent evt) {                                         
        input_random.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/input/random.png")));
    }                                        
    
    private void input_randomActionPerformed(java.awt.event.ActionEvent evt) {   
        int upperbound, lowerbound, seed;
        upperbound = 30;
        lowerbound = 1;   
        seed = (int) System.currentTimeMillis();
        Random rand = new Random(seed);
        int random_arrival = rand.nextInt(upperbound-lowerbound) + lowerbound;         
        int random_burst = rand.nextInt(upperbound-lowerbound) + lowerbound;
        int random_prio = rand.nextInt(upperbound-lowerbound) + lowerbound;
        
        input_burstIn.setText(String.valueOf(random_burst));
        input_arrivalIn.setText(String.valueOf(random_arrival));

        // System.out.println(random_arrival + "arrival");
        // System.out.println(random_burst + "burst");
        // System.out.println(random_prio + "prio");

        Music.sfx();
        if(ALGO.select.algo == "prio-np"){
            input_prioIn.setText(String.valueOf(random_prio));
        }
        else if(ALGO.select.algo == "prio-p"){
            input_prioIn.setText(String.valueOf(random_prio));
        }
    }                                            

    private void input_simulateMouseEntered(java.awt.event.MouseEvent evt) {                                            
        input_simulate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/input/simulate_hover.png")));
    }                                           

    private void input_simulateMouseExited(java.awt.event.MouseEvent evt) {                                           
        input_simulate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/input/simulate.png")));
    }                                          
    public void input_simulateActionPerformed(java.awt.event.ActionEvent evt) {    
        Music.sfx();
        
        if(pidArray.size() < 3){
            JOptionPane.showMessageDialog(null, "Input atleast three (3) processes.");
            return;
        }
        
        Music.sfx();
        if(ALGO.select.algo == "fcfs"){
            fcfs fcfs = new fcfs(arrivalArray, burstArray);
            // System.out.println(fcfs);
            javax.swing.table.DefaultTableModel model2 = (javax.swing.table.DefaultTableModel)Results.results_table.getModel();
          
            try {
                // "ID", "Burst Time", "Arrival Time", "Priority", "Waiting Time", "Turnaround Time"
                for(int i = 0; i < fcfs.getProcessIDs().length; i++) {
                    int id, burst, arrival, waiting, turnaround;
                    id = fcfs.getProcessIDs()[i];
                    System.out.println(id);
                    burst = fcfs.getBurstTime().get(i);
                    arrival = fcfs.getArrivalTime().get(i);
                    waiting = fcfs.getWaitingTimes()[i];
                    turnaround = fcfs.getTurnaroundTimes()[i];
                Object[] row = { "P"+ (id), burst, arrival, "-", waiting, turnaround, "-", "-"};
                model2.addRow(row);
                }
                // "Avg Waiting Time", "Avg Turnaround Time"
                Object[] row2 = { "", "", "", "", "", "", Math.round(fcfs.averageWaitingTime * 100.0) / 100.0, Math.round(fcfs.averageTurnaroundTime * 100.0) / 100.0};
                model2.addRow(row2);
            } catch (Exception e) {
                return;
            }

        }
        else if(ALGO.select.algo == "rr"){
            
        }
        else if(ALGO.select.algo == "prio-np"){
            
        }
        else if(ALGO.select.algo == "prio-p"){

        }
        else if(ALGO.select.algo == "sjf-np"){
            
        }
        else if(ALGO.select.algo == "sjf-p"){

        }
        
        ALGO.card.show(ALGO.mainPanel, "7");
        count = 1;
        arrivalArray.clear();
        burstArray.clear();
        pidArray.clear();
        DefaultTableModel model = (DefaultTableModel) input_table.getModel();
        model.setRowCount(0);

        input_burstIn.setText("");
        input_arrivalIn.setText("");
        input_prioIn.setText("");
        input_quantumIn.setText("");

        input_burstInFocusLost(null);
        input_arrivalInFocusLost(null);
        input_prioInFocusLost(null);
        input_quantumInFocusLost(null);
    }                                              

    private void minimizeMouseEntered(java.awt.event.MouseEvent evt) {                                      
        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/window/minimize_hover.png")));
    }                                     

    private void minimizeMouseExited(java.awt.event.MouseEvent evt) {                                     
        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/window/minimize.png")));
    }                                    

    private void minimizeActionPerformed(java.awt.event.ActionEvent evt) {                                         
        Music.sfx();
        ALGO.mainFrame.setState(java.awt.Frame.ICONIFIED);
    }                                        

    private void exitMouseEntered(java.awt.event.MouseEvent evt) {                                  
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/window/close_hover.png")));
    }                                 

    private void exitMouseExited(java.awt.event.MouseEvent evt) {                                 
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/window/close.png")));
    }                                

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {                                     
        Music.sfx();
        System.exit(0);
    }                                    

    private void input_volMouseEntered(java.awt.event.MouseEvent evt) {                                       
        if(ALGO.sound == true) {
            input_vol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/menu/buttons/mute_hover.png")));
        } else {
            input_vol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/menu/buttons/muteX_hover.png")));
        }
    }                                      

    private void input_volMouseExited(java.awt.event.MouseEvent evt) {                                      
        if(ALGO.sound == true) {
            input_vol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/menu/buttons/mute.png")));
        } else {
            input_vol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/menu/buttons/muteX.png")));
        }
    }                                     

    private void input_volActionPerformed(java.awt.event.ActionEvent evt) {                                          
        Music.sfx();
        if(ALGO.sound == true) {
            input_vol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/menu/buttons/muteX.png")));
            ALGO.sound = false;
            
            Music.bgMusic.pause();
        } else {
            input_vol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/menu/buttons/mute.png")));
            ALGO.sound = true;
           
            try {
                Music.bgMusic.resume();
            } catch (Exception ex) {}
        }
    }                                         

    private void input_burstInFocusGained(java.awt.event.FocusEvent evt) {                                          
        if(input_burstIn.getText().equals("1-30")) {
            input_burstIn.setText("");
        }
        input_burstIn.setForeground(new java.awt.Color(0, 0, 0));
    }                                         

    public void input_burstInFocusLost(java.awt.event.FocusEvent evt) {                                        
        if(input_burstIn.getText().equals("")) {
            input_burstIn.setText("1-30");
            input_burstIn.setForeground(new java.awt.Color(153, 153, 153));
        }
    }                                       

    private void input_arrivalInFocusGained(java.awt.event.FocusEvent evt) {                                            
        if(input_arrivalIn.getText().equals("1-30")) {
            input_arrivalIn.setText("");
        }
        input_arrivalIn.setForeground(new java.awt.Color(0, 0, 0));
    }                                           

    public void input_arrivalInFocusLost(java.awt.event.FocusEvent evt) {                                          
        if(input_arrivalIn.getText().equals("")) {
            input_arrivalIn.setText("1-30");
            input_arrivalIn.setForeground(new java.awt.Color(153, 153, 153));
        }
    }                                         

    private void input_prioInFocusGained(java.awt.event.FocusEvent evt) {                                         
        if(input_prioIn.getText().equals("1-30")) {
            input_prioIn.setText("");
        }
        input_prioIn.setForeground(new java.awt.Color(0, 0, 0));
    }                                        

    public void input_prioInFocusLost(java.awt.event.FocusEvent evt) {                                       
        if(input_prioIn.getText().equals("")) {
            input_prioIn.setText("1-30");
            input_prioIn.setForeground(new java.awt.Color(153, 153, 153));
        }
    }                                      

    private void input_quantumInFocusGained(java.awt.event.FocusEvent evt) {                                            
        if(input_quantumIn.getText().equals("1-10")) {
            input_quantumIn.setText("");
        }
        input_quantumIn.setForeground(new java.awt.Color(0, 0, 0));
    }                                           

    public void input_quantumInFocusLost(java.awt.event.FocusEvent evt) {                                          
        if(input_quantumIn.getText().equals("")) {
            input_quantumIn.setText("1-10");
            input_quantumIn.setForeground(new java.awt.Color(153, 153, 153));
        }
    }         
    
    public void setInputs() {
        System.out.println(ALGO.select.algo + " algo");
        if(ALGO.select.algo == "fcfs" || ALGO.select.algo == "sjf-np" || ALGO.select.algo == "sjf-p") {
            ALGO.input.input_burstIn.setEnabled(true);
            ALGO.input.input_burst.setEnabled(true);
            ALGO.input.input_arrivalIn.setEnabled(true);
            ALGO.input.input_arrival.setEnabled(true);
            ALGO.input.input_prioIn.setEnabled(false);
            ALGO.input.input_priority.setEnabled(false);
            ALGO.input.input_quantumIn.setEnabled(false);
            ALGO.input.input_quantum.setEnabled(false);
            if(ALGO.select.algo == "fcfs")
                input_algo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/input/fcfs-title.png"))); 
            else if(ALGO.select.algo == "sjf-np")
                input_algo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/input/sjf_np-title.png"))); 
            else
                input_algo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/input/sjf_p-title.png"))); 
        }else if(ALGO.select.algo == "rr") {
            ALGO.input.input_burstIn.setEnabled(true);
            ALGO.input.input_burst.setEnabled(true);
            ALGO.input.input_arrivalIn.setEnabled(true);
            ALGO.input.input_arrival.setEnabled(true);
            ALGO.input.input_prioIn.setEnabled(false);
            ALGO.input.input_priority.setEnabled(false);
            ALGO.input.input_quantumIn.setEnabled(true);
            ALGO.input.input_quantum.setEnabled(true);
            input_algo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/input/rr-title.png"))); 
        }else if(ALGO.select.algo == "prio-np" || ALGO.select.algo == "prio-p") {
            ALGO.input.input_burstIn.setEnabled(true);
            ALGO.input.input_burst.setEnabled(true);
            ALGO.input.input_arrivalIn.setEnabled(true);
            ALGO.input.input_arrival.setEnabled(true);
            ALGO.input.input_prioIn.setEnabled(true);
            ALGO.input.input_priority.setEnabled(true);
            ALGO.input.input_quantumIn.setEnabled(false);
            ALGO.input.input_quantum.setEnabled(false);
            if(ALGO.select.algo == "prio-np")
                input_algo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/input/prio_np-title.png"))); 
            else
                input_algo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/input/prio_p-title.png"))); 
        }
    }
    
    public void resetAudioButton() {
        if(ALGO.sound == true) {
            input_vol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/menu/buttons/mute.png")));
        } else {
            input_vol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/menu/buttons/muteX.png")));
        }
    }

    private javax.swing.JButton exit;
    private javax.swing.JLabel input_algo;
    private javax.swing.JLabel input_arrival;
    private javax.swing.JTextField input_arrivalIn;
    private javax.swing.JLabel input_bg;
    private javax.swing.JLabel input_burst;
    private javax.swing.JTextField input_burstIn;
    private javax.swing.JLabel input_fms;
    private javax.swing.JButton input_import;
    private javax.swing.JButton input_input;
    private javax.swing.JLabel input_input2;
    private javax.swing.JLabel input_input3;
    private javax.swing.JLabel input_input4;
    private javax.swing.JLabel input_input5;
    private javax.swing.JLabel input_labels;
    private javax.swing.JTextField input_prioIn;
    private javax.swing.JLabel input_priority;
    private javax.swing.JLabel input_quantum;
    private javax.swing.JTextField input_quantumIn;
    private javax.swing.JButton input_random;
    private javax.swing.JButton input_return;
    private javax.swing.JButton input_simulate;
    public static javax.swing.JTable input_table;
    private javax.swing.JButton input_vol;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton minimize;

    public int count = 1;
}

package fr.proagenda.ihm;
 
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import fr.proagenda.application.Application;
import fr.proagenda.classes.User;
import fr.proagenda.redefineswing.RoundedCornerBorder;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

@SuppressWarnings("serial")
public class IhmNouvelUtilisateur extends JPanel {
	private static int posXErr = 425;
	private static int posYErr =270;


private JTextField textFieldPrenom;
private JTextField textFieldPseudo;
private JPasswordField passwordField;
private JPasswordField passwordField_1;
private JProgressBar progressBar;
private JComboBox<String> comboBox;
private JButton btnRetour_1;
private JButton btnValider;
private JRadioButton rdbtnAfficher;
private JCheckBox chckbxNewCheckBox;
private JLabel lblTaillemdp;
private JTextField textFieldNom;
private JPanel panelMainFenetre;
private int posX;
private int posY;

/**
	 * @param fils : fenetre principale qu'on va effacer
	 * D�claration de tous les �l�ments graphique de la fonction nouvelUtilisateur 
	 */
	public IhmNouvelUtilisateur(){
		int font = Application.getRandomNumber();

	// TOP WINDOW 
	
			JPanel panelCloseWindow = new JPanel();
			panelCloseWindow.setBounds(876, 0, 29, 23);
			this.add(panelCloseWindow);
			panelCloseWindow.setLayout(null);
			
			JButton btnX = new JButton(new ImageIcon(Ihm.class.getResource("/fr/proagenda/img/close-window-32.png")));
			btnX.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					((Window) getRootPane().getParent()).dispose();

				}
			});
			
			addMouseListener(new MouseAdapter() {

				@Override
	            //on recupere les coordonn�es de la souris
	            public void mousePressed(MouseEvent e) {
	                posX = e.getX();    //Position X de la souris au clic
	                posY = e.getY();    //Position Y de la souris au clic
	            }
	        });

			btnX.setVisible(true);
			panelCloseWindow.add(btnX);
			btnX.setBounds(0, 0, 23, 23);
			btnX.setBackground(Color.DARK_GRAY);
//			panelCloseWindow.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnX}));
			
			panelMainFenetre = new JPanel();
			panelMainFenetre.setBackground(Color.DARK_GRAY);
			panelMainFenetre.setBounds(0, 0, 900, 522);
			this.add(panelMainFenetre);
			panelMainFenetre.setLayout(null);

		/*Variables*/
	    int Decalage = 130;
	    
	    /*d�marrage*/
//	    fils.removeAll();
//	    fils.repaint();
	    this.setBounds(0, 0, 900, 500);
	    
	    /*D�claration et initialisation JLabels*/
	    this.setLayout(null);
	    JLabel lblNom = new JLabel("Nom : ");
	    lblNom.setForeground(Color.LIGHT_GRAY);
	    lblNom.setBounds(327,96,87,14);
	    panelMainFenetre.add(lblNom);
	    
	    JLabel lblPrenom = new JLabel("Prenom : ");
	    lblPrenom.setForeground(Color.LIGHT_GRAY);
	    lblPrenom.setBounds(327, 139, 87, 14);
	    panelMainFenetre.add(lblPrenom);
	    
	    JLabel lblPseudo = new JLabel("Pseudo : ");
	    lblPseudo.setForeground(Color.LIGHT_GRAY);
	    lblPseudo.setBounds(327, 174, 87, 14);
	    panelMainFenetre.add(lblPseudo);
	    
	    JLabel lblMetier = new JLabel("metier :");
	    lblMetier.setForeground(Color.LIGHT_GRAY);
	    lblMetier.setBounds(327, 208, 46, 14);
	    panelMainFenetre.add(lblMetier);
	    
	    JLabel lblMotDePasse = new JLabel("Mot de passe : ");
	    lblMotDePasse.setForeground(Color.LIGHT_GRAY);
	    lblMotDePasse.setBounds(327, 240, 126, 14);
	    panelMainFenetre.add(lblMotDePasse);
	    
	    JLabel lblRetapezLeMot = new JLabel("Retapez le Mot de passe : ");
	    lblRetapezLeMot.setForeground(Color.LIGHT_GRAY);
	    lblRetapezLeMot.setBounds(327, 321, 168, 14);
	    panelMainFenetre.add(lblRetapezLeMot);
	    
	    
	    	    
	    /*D�claration JTextField*/
	    textFieldNom = new JTextField() {
			  @Override protected void paintComponent(Graphics g) {
				    if (!isOpaque() && getBorder() instanceof RoundedCornerBorder) {
				      Graphics2D g2 = (Graphics2D) g.create();
				      g2.setPaint(getBackground());
				      g2.fill(((RoundedCornerBorder) getBorder()).getBorderShape(
				          0, 0, getWidth() - 1, getHeight() - 1));
				      g2.dispose();
				    }
				    super.paintComponent(g);
				  }
				  @Override public void updateUI() {
				    super.updateUI();
				    setOpaque(false);
				    setBorder(new RoundedCornerBorder());
				  }
				};
	    textFieldNom.setBounds(494, 93, 285, 20);
	    panelMainFenetre.add(textFieldNom);
	    
	    textFieldPrenom = new JTextField() {
			  @Override protected void paintComponent(Graphics g) {
				    if (!isOpaque() && getBorder() instanceof RoundedCornerBorder) {
				      Graphics2D g2 = (Graphics2D) g.create();
				      g2.setPaint(getBackground());
				      g2.fill(((RoundedCornerBorder) getBorder()).getBorderShape(
				          0, 0, getWidth() - 1, getHeight() - 1));
				      g2.dispose();
				    }
				    super.paintComponent(g);
				  }
				  @Override public void updateUI() {
				    super.updateUI();
				    setOpaque(false);
				    setBorder(new RoundedCornerBorder());
				  }
				};
	    textFieldPrenom.setEnabled(false);
	    textFieldPrenom.setBounds(494, 136, 285, 20);
	    panelMainFenetre.add(textFieldPrenom);
	    
	    textFieldPseudo = new JTextField() {
			  @Override protected void paintComponent(Graphics g) {
				    if (!isOpaque() && getBorder() instanceof RoundedCornerBorder) {
				      Graphics2D g2 = (Graphics2D) g.create();
				      g2.setPaint(getBackground());
				      g2.fill(((RoundedCornerBorder) getBorder()).getBorderShape(
				          0, 0, getWidth() - 1, getHeight() - 1));
				      g2.dispose();
				    }
				    super.paintComponent(g);
				  }
				  @Override public void updateUI() {
				    super.updateUI();
				    setOpaque(false);
				    setBorder(new RoundedCornerBorder());
				  }
				};
	    textFieldPseudo.setEnabled(false);
	    textFieldPseudo.setBounds(494, 167, 285, 20);
	    panelMainFenetre.add(textFieldPseudo);
	    
	    passwordField = new JPasswordField() {
			  @Override protected void paintComponent(Graphics g) {
				    if (!isOpaque() && getBorder() instanceof RoundedCornerBorder) {
				      Graphics2D g2 = (Graphics2D) g.create();
				      g2.setPaint(getBackground());
				      g2.fill(((RoundedCornerBorder) getBorder()).getBorderShape(
				          0, 0, getWidth() - 1, getHeight() - 1));
				      g2.dispose();
				    }
				    super.paintComponent(g);
				  }
				  @Override public void updateUI() {
				    super.updateUI();
				    setOpaque(false);
				    setBorder(new RoundedCornerBorder());
				  }
				};
	    passwordField.setEnabled(false);
	    passwordField.setBounds(494, 237, 285, 20);
	    panelMainFenetre.add(passwordField);
	    
	    passwordField_1 = new JPasswordField() {
			  @Override protected void paintComponent(Graphics g) {
				    if (!isOpaque() && getBorder() instanceof RoundedCornerBorder) {
				      Graphics2D g2 = (Graphics2D) g.create();
				      g2.setPaint(getBackground());
				      g2.fill(((RoundedCornerBorder) getBorder()).getBorderShape(
				          0, 0, getWidth() - 1, getHeight() - 1));
				      g2.dispose();
				    }
				    super.paintComponent(g);
				  }
				  @Override public void updateUI() {
				    super.updateUI();
				    setOpaque(false);
				    setBorder(new RoundedCornerBorder());
				  }
				};
	    passwordField_1.setEnabled(false);
	    passwordField_1.setBounds(494, 318, 285, 20);
	    panelMainFenetre.add(passwordField_1);
	    
	    
	    
	    /*ProgressBar*/
	    progressBar = new JProgressBar();
	    progressBar.setBounds(530, 293, 220, 14);
	    panelMainFenetre.add(progressBar);
	    
	    
	    
	    /*listes*/
	    comboBox = new JComboBox<String>();
	    comboBox.setEnabled(false);
	    comboBox.setBounds(578, 206, 109, 20);
			
	    panelMainFenetre.add(comboBox);
	    comboBox.addItem("");
	    comboBox.addItem("Technicien");
	    comboBox.addItem("Autre");
	    
	    
	    
	    /*D�claration des Boutons*/
	    btnRetour_1 = new JButton("Retour");
	    btnRetour_1.setIcon(new ImageIcon(Ihm.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
        btnRetour_1.setBounds(325, 11, 89, 23);
        panelMainFenetre.add(btnRetour_1);
	    
	    btnValider = new JButton("Valider");
	    btnValider.setEnabled(false);
	    btnValider.setBounds(595, 385, 89, 23);
	    panelMainFenetre.add(btnValider);
	    
	     
	    
	    /*D�claration checkBox / radioButton*/
	    rdbtnAfficher = new JRadioButton("afficher");
	    rdbtnAfficher.setForeground(Color.LIGHT_GRAY);
	    rdbtnAfficher.setBackground(Color.DARK_GRAY);
	    rdbtnAfficher.setEnabled(false);
	    rdbtnAfficher.setBounds(785, 236, 109, 23);
	    panelMainFenetre.add(rdbtnAfficher);
	    
	    chckbxNewCheckBox = new JCheckBox("");
	    chckbxNewCheckBox.setBackground(Color.DARK_GRAY);
	    chckbxNewCheckBox.setForeground(Color.LIGHT_GRAY);
	    chckbxNewCheckBox.setEnabled(false);
	    chckbxNewCheckBox.setBounds(785, 321, 97, 23);
	    panelMainFenetre.add(chckbxNewCheckBox);
	    JPanel panelTopWindow = new JPanel();
	    
		    panelTopWindow.addMouseMotionListener(new MouseMotionAdapter() {
		   // A chaque deplacement on recalcul le positionnement de la fenetre
		   @SuppressWarnings("static-access")
		@Override
		   public void mouseDragged(MouseEvent e) {
		       int depX = e.getX() - posX;
		       int depY = e.getY() - posY;
		       JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(panelMainFenetre);
               for(int i = 0 ; i < topFrame.getWindows().length ; i++) {
            	   topFrame.getWindows()[i].setLocation(getX()+depX, getY()+depY);
               }
		   }
		    });
		    panelTopWindow.setBounds(0, 0, 866, 23);
		    this.add(panelTopWindow);
		    panelTopWindow.setLayout(null);
	    
	    
	    /*JLabel "dynamique"*/
	    lblTaillemdp = new JLabel("Mot de passe court ");
	    
	    @SuppressWarnings("unused")
		JLabel lblErreurSQL = new JLabel("Pseudo d�j� utilis�");
	    
	    
	    JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Ihm.class.getResource("/fr/proagenda/img/fond_"+font+".jpeg")));
		label.setBounds(-5, 0, 320, 500);
		panelMainFenetre.add(label);
	    
	    
	    /*Appel Des Listenner*/
	    nouvelUtilisateurLstenner();
	    
	}
	
	/**
	 * d�finis les listenner de DefineNouvelUtilisateurFenetre
	 * @param fils : JPanel de DefineNouvelUtilisateurFenetre
	 */
	public void nouvelUtilisateurLstenner() {
		/*Variables*/
	    int Decalage = 130;
	    
	    
	    btnRetour_1.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {
	        	((Window) getRootPane().getParent()).dispose();
	            Ihm retour=new Ihm();
	            retour.setVisible(true);
	        }
	    });
		textFieldNom.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e){
				textFieldPrenom.setEnabled(true);
			}
		});
		
		textFieldPrenom.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent e) {
					textFieldPseudo.setEnabled(true);
				}
		});
		
		textFieldPseudo.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e){
				comboBox.setEnabled(true);
			}
		});
		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				passwordField.setEnabled(true);
				passwordField_1.setEnabled(true);
				rdbtnAfficher.setEnabled(true);
			}
		});
		
		rdbtnAfficher.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            if(rdbtnAfficher.isSelected()) {
	                passwordField.setEchoChar((char)0);
	                passwordField_1.setEnabled(false);
	            }else {
	                passwordField.setEchoChar('�');
	                passwordField_1.setEnabled(true);
	            }

	        }
	    });
		
		passwordField.addKeyListener(new KeyAdapter() {
	        @SuppressWarnings("deprecation")
			@Override
	        public void keyReleased(KeyEvent e){
	            int val =100 * passwordField.getCaretPosition() /40 ;
	            progressBar.setValue(val);
	             try{
	                InputStream flux=new FileInputStream("C:/Users/mathieu/Documents/MostPopularPasswords.txt"); 
	                InputStreamReader lecture=new InputStreamReader(flux);
	                BufferedReader buff=new BufferedReader(lecture);
	                String ligne;
	                int valT =0;
	                ligne=buff.readLine();
	                while ((ligne=buff.readLine())!=null){
	                    if(passwordField.getText().equals(ligne)) {
	                        lblTaillemdp.setText("mot de passe Courant, modifiez le !");
	                        lblTaillemdp.setBounds(posXErr+Decalage, posYErr, 200, 14);
	                        lblTaillemdp.setForeground(Color.RED);
	                        valT=2;
	                        progressBar.setForeground(Color.RED);
	                    }else if(passwordField.getText().indexOf(ligne)>=0) {
	                        lblTaillemdp.setText("Un mot de passe courant est contenu");
	                        lblTaillemdp.setBounds(posXErr+Decalage-5, posYErr, 220, 14);
	                        lblTaillemdp.setForeground(Color.ORANGE);
	                        valT =1;
	                        progressBar.setForeground(Color.ORANGE);
	                    }else if(passwordField.getCaretPosition()<10 && valT !=2 && valT!=1) {
	                        lblTaillemdp.setText("mot de passe Court !");
	                        lblTaillemdp.setBounds(posXErr+Decalage+30, posYErr, 200, 14);
	                        lblTaillemdp.setForeground(Color.CYAN);
	                        if(valT==1) {
	                            progressBar.setForeground(Color.ORANGE);
	                        }else if(valT==2){
	                            progressBar.setForeground(Color.RED);
	                        }else {
	                            progressBar.setForeground(Color.BLUE);
	                        }
	                        valT=3;

	                    }else if(passwordField.getText().indexOf(ligne)==-1){
	                        if(valT==0) {
	                            lblTaillemdp.setText("Bon mot de passe");
	                            lblTaillemdp.setBounds(260+Decalage, 229, 200, 14);
	                            lblTaillemdp.setForeground(Color.GREEN);
	                            progressBar.setForeground(Color.GREEN);
	                        }else if(valT == 1) {

	                        }else if (valT ==2) {

	                        }else if(valT == 3) {

	                        }
	                    }
	                }
	                buff.close(); 
	                }		
	            catch (Exception f){
	                System.out.println(f.toString());
	            }
	            panelMainFenetre.add(lblTaillemdp);
	            if(passwordField.getCaretPosition()==0) {
	                panelMainFenetre.remove(lblTaillemdp);
	            }
	            panelMainFenetre.revalidate();
	            panelMainFenetre.repaint();
	        }
	    });
		
		
		passwordField_1.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyReleased(KeyEvent e) {
	            char []mdp1=passwordField.getPassword();
	            char []mdp2=passwordField_1.getPassword();
	            if(new String (mdp1).equals(new String (mdp2))) {
//					
	                        chckbxNewCheckBox.setSelected(true);
	                        chckbxNewCheckBox.revalidate();
	                        chckbxNewCheckBox.repaint();
	                        btnValider.setEnabled(true);
	            }else {
	                chckbxNewCheckBox.setSelected(false);
	                btnValider.setEnabled(false);
	            }
	        }
	    });
	    
		
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				char []mdp1=passwordField.getPassword();
				char []mdp2=passwordField_1.getPassword();
				int save=-1;
				
				System.out.println("0x001");
				if(new String (mdp1).equals(new String (mdp2))) {
					System.out.println("0x002");
					chckbxNewCheckBox.setSelected(true);
					chckbxNewCheckBox.revalidate();
					chckbxNewCheckBox.repaint();
					if(comboBox.getSelectedItem().equals("Technicien")) {
						User temp = new User(textFieldNom.getText(),textFieldPrenom.getText(),1,textFieldPseudo.getText(), Application.getShaApp(new String (mdp1)));
						save = Application.saveUserApp(temp);
						if(save==1000) {
							((Window) getRootPane().getParent()).dispose();
							Ihm continuer=new Ihm();
							continuer.setVisible(true);
						}else if(save==0x003) {
							
						}
					}else if(comboBox.getSelectedItem().equals("Autre")) {
						User temp = new User(textFieldNom.getText(),textFieldPrenom.getText(),0,textFieldPseudo.getText(), Application.getShaApp(new String (mdp1)));
						save = Application.saveUserApp(temp);
						if(save==1000) {
							((Window) getRootPane().getParent()).dispose();
							Ihm continuer=new Ihm();
							continuer.setVisible(true);
						}
					}
				}	
			}
		});
	}
	

}

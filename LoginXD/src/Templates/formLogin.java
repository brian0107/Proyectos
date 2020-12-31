package Templates;

import Components.*;

import javax.swing.*;
import java.awt.*;

public class formLogin extends panel {

    private GridBagConstraints gbc = new GridBagConstraints();

    private JPanel panelTop = new JPanel();
    private JPanel panelBottom = new JPanel();

    private JLabel lbUser = new JLabel("Usuario");
    private JLabel lbPass = new JLabel("Contraseña");
    private textfield txtUser = new textfield();
    private textpassword txtpass = new textpassword();


    public formLogin(int Width, int Height) {
        super(Width, Height);
        setLocation(Width, 0);
        setBackground(new Color(0, 0, 255));
        setLayout(null);

        initComponents();
    }

    private void initComponents() {
        panelTop.setSize(this.getWidth(), (this.getHeight() / 2) - 50);
        panelTop.setBackground(new Color(255, 255, 255));
        panelTop.setLocation(0, 0);

        panelBottom.setSize(this.getWidth(), (this.getHeight() / 2) + 50);
        panelBottom.setBackground(new Color(0, 255, 255));
        panelBottom.setLocation(0, (this.getHeight()/2)-50 );


        initPanelBottom();
        this.add(panelTop);
        this.add(panelBottom);
    }

    private void initPanelTop(){

    }

    private void initPanelBottom(){
        gbc(0,0,2);
        panelBottom.add(lbUser);
        gbc(0,1,2);
        panelBottom.add(lbPass);
    }

    private void gbc(int gX, int gY, int gW){
        gbc.gridx = gX;
        gbc.gridwidth = gW;
        gbc.gridy = gY;
    }

    private void gbcInsets(int t, int l, int r, int b){
        gbc.insets.top = t;
        gbc.insets.left = l;
        gbc.insets.right = r;
        gbc.insets.bottom = b;
    }
}




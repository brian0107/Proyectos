package Views;

import Apps.config_size;
import Components.panel;
import Controllers.Fondoimagen;
import Templates.formLogin;

import javax.swing.*;
import java.awt.*;

public class login extends JFrame {
    config_size configSize= new config_size();
    formLogin Formlogin = new formLogin((configSize.Width-500)/2, configSize.Height-300);
    private panel PanelImage = new panel((configSize.Width-500)/2, configSize.Height-300);
    public login() {
        super("ventana de acceso");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(configSize.Width-500,configSize.Height-300);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        initcomponents();



    }
    private void initcomponents(){
        PanelImage.setLocation(0,0);
        PanelImage.setBackground(new Color(23,211,33));
        PanelImage.setBorder(new Fondoimagen("../Controllers/administrador.jpg"));
        this.add(PanelImage);
        this.add(Formlogin);


    }
}

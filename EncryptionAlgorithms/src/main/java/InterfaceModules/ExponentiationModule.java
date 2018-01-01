package InterfaceModules;

import Logic.Logic;

import javax.swing.*;
import java.awt.*;


public class ExponentiationModule extends AbstractModule{
    private JTextField a;
    private JTextField p;
    private JTextField x;
    private JLabel ans;

    public ExponentiationModule(JPanel panel){
        super(panel);

        a = new JTextField();
        a.setPreferredSize(new Dimension(50, 25));
        panel.add(a);

        JLabel aux1 = new JLabel("^");
        aux1.setPreferredSize(new Dimension(15, 25));
        panel.add(aux1);

        x = new JTextField();
        x.setPreferredSize(new Dimension(50, 25));
        panel.add(x);

        JLabel aux2 = new JLabel("mod");
        aux2.setPreferredSize(new Dimension(40, 25));
        panel.add(aux2);

        p = new JTextField();
        p.setPreferredSize(new Dimension(50, 25));
        panel.add(p);

        JLabel aux3 = new JLabel("=");
        aux3.setPreferredSize(new Dimension(15, 25));
        panel.add(aux3);

        ans = new JLabel("?");
        ans.setPreferredSize(new Dimension(100, 25));
        panel.add(ans);
    }

    protected void calculate(){
        int ans = Logic.exponentiation(Integer.parseInt(a.getText()),
                Integer.parseInt(x.getText()),
                Integer.parseInt(p.getText()));
        this.ans.setText(String.valueOf(ans));
    }


}

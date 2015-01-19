import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class Main {

    public static void main(String[] args) {
        Main bp = new Main();
        bp.makeGui();

    }
    public void makeGui(){
        JFrame frame = new JFrame(" Расчет площади ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JTabbedPane jtp = new JTabbedPane();

        jtp.addTab("First",  new FirstPanel());

        frame.getContentPane().add(jtp);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @SuppressWarnings("serial")
    class FirstPanel extends JPanel implements ActionListener {
        double widthSource;//исходная ширина
        double heightSource;// исходная высота
        double numYears;//срок погашения ссуды в годах
        double areaDouble; // исходная площадь
        final int payPerYear = 12;// количество платежей
        NumberFormat nf;
        JTextField amountText,  paymentText, periodText, rateText, areaText;
        JButton dolt;

        public FirstPanel(){




            GridBagLayout gbag = new GridBagLayout();
            GridBagConstraints gbc = new GridBagConstraints();
            setLayout(gbag);

            JLabel heading= new JLabel("Расчет по площади");
            JLabel amountLab = new JLabel("Ширина исходная: ");
            JLabel periodLab= new JLabel("Высота исходная: ");
            JLabel rateLab = new JLabel("Ширина расчетная:");
            JLabel paymentLab = new JLabel("Высота расчетная: ");
            JLabel areaLabel = new JLabel("Площадь: ");

            amountText = new JTextField(10);
            periodText = new JTextField(10);
            areaText = new JTextField(10);
            paymentText = new JTextField(10);
            rateText = new JTextField(10);
            paymentText.setEditable(false);
            rateText.setEditable(false);
            dolt = new JButton("Вычислить");

            gbc.weighty = 1.0;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.NORTH;
            gbag.setConstraints(heading, gbc);

            gbc.anchor = GridBagConstraints.EAST;
            gbc.gridwidth = GridBagConstraints.RELATIVE;
            gbag.setConstraints(amountLab, gbc);
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbag.setConstraints(amountText, gbc);

            gbc.gridwidth = GridBagConstraints.RELATIVE;
            gbag.setConstraints(periodLab, gbc);
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbag.setConstraints(periodText, gbc);

            gbc.gridwidth = GridBagConstraints.RELATIVE;
            gbag.setConstraints(rateLab, gbc);
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbag.setConstraints(rateText, gbc);

            gbc.gridwidth = GridBagConstraints.RELATIVE;
            gbag.setConstraints(paymentLab, gbc);
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbag.setConstraints(paymentText, gbc);

            gbc.gridwidth = GridBagConstraints.RELATIVE;
            gbag.setConstraints(areaLabel, gbc);
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbag.setConstraints(areaText, gbc);

            gbc.anchor = GridBagConstraints.CENTER;
            gbag.setConstraints(dolt, gbc);

            add(heading);
            add(amountLab);
            add(amountText);
            add(periodLab);
            add(periodText);
            add(areaLabel);
            add(areaText);
            add(dolt);
            add(rateLab);
            add(rateText);
            add(paymentLab);
            add(paymentText);


            amountText.addActionListener(this);
            dolt.addActionListener(this);
            periodText.addActionListener(this);
            rateText.addActionListener(this);

            nf = NumberFormat.getInstance();
            nf.setMinimumFractionDigits(2);
            nf.setMaximumFractionDigits(2);
        }




        public void actionPerformed(ActionEvent e) {
            double resultWidth =0.0;
            double resultHeight =0.0;


            String amountStr = amountText.getText();
            String periodStr = periodText.getText();
            String areaStr = areaText.getText();
            try{
                if(amountStr.length() !=0 && periodStr.length() !=0 && areaStr.length() != 0){
                    widthSource = Double.parseDouble(amountStr);
                    heightSource = Double.parseDouble(periodStr);
                    areaDouble = Double.parseDouble(areaStr);

                    //логика приложения

                    resultWidth =widthSource*((Math.sqrt (areaDouble/(widthSource*heightSource)))*1000);
                    resultHeight = heightSource*((Math.sqrt (areaDouble/(widthSource*heightSource)))*1000);
                    //положим в ячейки найденные значения
                    paymentText.setText(nf.format(resultWidth));
                    rateText.setText(nf.format(resultHeight));
                    //intRate.setText(nf.format(rateStr);
                    //result = compute();

                }
            }catch(Exception e1){
                System.out.println("Exception!!!");
            }


        }

    }}

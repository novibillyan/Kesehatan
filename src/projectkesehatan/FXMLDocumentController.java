/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectkesehatan;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField nama;
    @FXML
    private TextField tinggi;
    @FXML
    private TextField berat;
    @FXML
    private RadioButton lakilaki;
    @FXML
    private ToggleGroup jenis;
    @FXML
    private RadioButton perempuan;
    @FXML
    private TextField idealanda;
    @FXML
    private TextArea hasil;
    @FXML
    private TextArea kritik;
    @FXML
    private Button idproses;
    @FXML
    private Button idreset;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void proses(ActionEvent event) {
        
          if(nama.getText().equals("")||tinggi.getText().equals("")||berat.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Lengkapi data diri Anda");
          }
          else{
          
        
        String Nama = nama.getText();
        String Tinggi = tinggi.getText();
        String Berat = berat.getText();
        
        String Jenis = "";     
        double ideal=0;
        double ting = Double.parseDouble(tinggi.getText());  
        double ber = Double.parseDouble(berat.getText());
        
        if (perempuan.isSelected()){
            Jenis = "Perempuan";
            ideal = ting-100;
        }
        else if (lakilaki.isSelected()){
            Jenis = "Laki-Laki";
            ideal = ting-110;
        }
        else {
            JOptionPane.showMessageDialog(null, "Pilih Jenis Kelamin!");
        }
               
        String hsl="";
        String krtk="";
        if (ber<ideal){
            hsl="Kurang Gizi";
            krtk="Perbanyak Asupan Gizi!, Jaga Pola Makan Anda ";
         }
        else if (ber==ideal){
            hsl="Ideal";
        krtk="Good Job! Jaga Kondisi Anda !";}
        else if (ber>ideal){
            hsl="Kelebihan Gizi";
        krtk="Perbanyak Olahraga!, Jaga Pola Makan Anda";}
        hasil.setText("Nama Pasien: "+Nama+"\nTinggi Badan: "+Tinggi+" cm \nBerat Badan: "+Berat+" Kg \nJenis Kelamin : "+Jenis+"\n "+hsl);
        idealanda.setText(""+ideal);
        kritik.setText(""+krtk);
       
          }
    }

    @FXML
    private void reset(ActionEvent event) {
   
        hasil.setText("");
        kritik.setText("");
        idealanda.setText("");
        nama.setText("");
        tinggi.setText("");
        perempuan.setSelected(false);
        lakilaki.setSelected(false);
        berat.setText("");
    }
    
}

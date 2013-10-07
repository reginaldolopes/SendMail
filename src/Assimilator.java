import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Assimilator {
	public static void main(String[] args) {
		Properties props = new Properties();
		Session session = Session.getInstance(props);
		MimeMessage msg = new MimeMessage(session);
		Transport t = null;
		try {
			Address yahoo = new InternetAddress("reginaldolopes@policiamilitar.sp.gov.br",
					"Reginaldo Lopes");
			Address reginaldo = new InternetAddress("reginaldoflopes@gmail.com");
			msg.setText("Valida seu office 2013 sem ativadores ou serial\n"+
			"Aqui mostro-lhes os passos para ativar os programas do office 2013 sem série todos ofline único modificar o regedit\n"
			+ "PROCEDIMENTO\n"
			+ "1)  ir a Inicio >Regedit\n"
			+ "2) ir a >HKEY_LOCAL_MACHINE/SOFTWARE/Microsoft/Office/15.0\n"
			+ "3) Apagar a pasta " +"Registo\n"
			+ "O office e não requer ativação, mas que se aparece a caixa por chamada ou via web. Eles vão aceitar e ainda o validam para o resto da vida.");
			msg.setFrom(yahoo);
			msg.setRecipient(Message.RecipientType.TO, reginaldo);
			msg.setSubject("Java E-mail API");
			t = session.getTransport("smtps");
			t.connect("smtp.gmail.com", "reginaldoflopes", "silvalopes%$");
			t.sendMessage(msg, msg.getAllRecipients());
			System.out.print("E-mail enviado com sucesso!");
		} catch (MessagingException | UnsupportedEncodingException ex) {
			ex.printStackTrace();
		} finally { // Transport does not implement AutoCloseable :-(
			if (t != null) {
				try {
					t.close();
				} catch (MessagingException ex) {
				}
			}
		}
	}
}
package views;

import java.util.Map;

import javax.swing.JFrame;

import controllers.ControllerRespuesta;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Color;

public class PantallaRespuesta extends JFrame {

	public PantallaRespuesta(Map results, ControllerRespuesta c) {
		BorderLayout borderLayout = (BorderLayout) getContentPane().getLayout();
		borderLayout.setVgap(10);
		borderLayout.setHgap(10);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 1, 0, 0));
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));

		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Gracias por su participacion");
		lblNewLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Su puntaje total fue:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel_1);
		
		JLabel resultLabel = new JLabel((String) results.get("total_puntaje"));
		resultLabel.setBorder(new EmptyBorder(0, 20, 20, 20));
		resultLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(resultLabel);
		
		JPanel panelDesc = new JPanel();
		panelDesc.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel labelOK = new JLabel("Respuestas Correctas");
		labelOK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelDesc.add(labelOK);
		JLabel labelTOK = new JLabel((String) results.get("total_correctas"));
		labelTOK.setHorizontalAlignment(SwingConstants.RIGHT);
		labelTOK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		if(results.get("total_correctas").equals("0")) {
			labelTOK.setForeground(Color.RED);
		}
		labelTOK.setBorder(new EmptyBorder(0, 0, 0, 20));
		panelDesc.add(labelTOK);
		
		JLabel labelE = new JLabel("Respuestas Incorrectas");
		labelE.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelDesc.add(labelE);
		
		JLabel labelTE = new JLabel((String) results.get("total_incorrectas"));
		labelTE.setHorizontalAlignment(SwingConstants.RIGHT);
		labelTE.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelTE.setBorder(new EmptyBorder(0, 0, 0, 20));
		panelDesc.add(labelTE);
		
		panel.add(panelDesc);
		
		
		
		 // TODO Auto-generated constructor stub
	}

}

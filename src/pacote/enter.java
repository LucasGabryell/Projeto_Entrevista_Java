package pacote;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;

public class enter extends JFrame {

	private JButton Cadastro_Entrevistados;
	private JButton Cadastro_Perguntas;
	private JButton Consulta_Entrevistados;
	private JButton Consulta_Perguntas;
	private JButton Registro_Entrevistas;
	private JButton Relatorio_Entrevistas;
	ArrayList<cad_ent> entrevistados = new ArrayList<>();
	ArrayList<cad_perg> perguntas = new ArrayList<>();
	ArrayList<relatorio> reg_perguntas = new ArrayList<>();
	ArrayList<relatorio> perg = new ArrayList<>();

	public enter() {
		this.setTitle("Questão 1");
		setBounds(100, 300, 500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		Cadastro_Entrevistados = new JButton();
		Cadastro_Entrevistados.setText("Cadastro de Entrevistados");
		Cadastro_Entrevistados.setBounds(1, 200, 200, 100);
		this.add(Cadastro_Entrevistados);
		// cadastro de entrevistado
		Cadastro_Entrevistados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String entrevistado;
				String ruas;
				cad_ent Cad_Entrevistado = new cad_ent();
				entrevistado = JOptionPane.showInputDialog("Digite o nome do entrevistado");
				Cad_Entrevistado.setNome(entrevistado);
				ruas = JOptionPane.showInputDialog("Digite a rua onde mora");
				Cad_Entrevistado.setRua(ruas);
				entrevistados.add(Cad_Entrevistado);
				JOptionPane.showMessageDialog(null, "Cadastro de entrevistado concluido!");
			}
		});

		Cadastro_Perguntas = new JButton();
		Cadastro_Perguntas.setText("Cadastro de Perguntas");
		Cadastro_Perguntas.setBounds(1, 20, 200, 100);
		this.add(Cadastro_Perguntas);
		// cadastro de perguntas
		Cadastro_Perguntas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String id;
				String desc;
				cad_perg Cad_Pergunta = new cad_perg();
				id = JOptionPane.showInputDialog("Digite o ID da pergunta");
				Cad_Pergunta.setId(Integer.parseInt(id));
				desc = JOptionPane.showInputDialog("Digite a descrição da pergunta");
				Cad_Pergunta.setDescricao(desc);
				JOptionPane.showMessageDialog(null, "Cadastro de perguntas concluido!");
				perguntas.add(Cad_Pergunta);
			}
		});
		// consultar entrevistados
		Consulta_Entrevistados = new JButton();
		Consulta_Entrevistados.setText("Consulta de Entrevistados");
		Consulta_Entrevistados.setBounds(1, 400, 200, 100);
		this.add(Consulta_Entrevistados);

		Consulta_Entrevistados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cad_ent Cons_Entrevistado = new cad_ent();
				String verific;
				verific = JOptionPane.showInputDialog("Digite a Rua ou trazer todos");
				Cons_Entrevistado.setVerificar(verific);
				for (cad_ent consulta_ent : entrevistados) {
					if (Cons_Entrevistado.getVerificar().equals(consulta_ent.getRua())) {
						String save = "Nome: " + consulta_ent.getNome() + "\nRua: " + consulta_ent.getRua();
						JOptionPane.showMessageDialog(null, save, " Consulta por Rua ", JOptionPane.PLAIN_MESSAGE);
					}
				}
				if (Cons_Entrevistado.getVerificar().equals("trazer todos"))
					for (cad_ent cad_entrev : entrevistados) {
						String save1 = "Nome: " + cad_entrev.getNome() + "\nRua: " + cad_entrev.getRua();
						JOptionPane.showMessageDialog(null, save1, " Consulta de Entrevistados ",
								JOptionPane.PLAIN_MESSAGE);
					}
			}
		});
		// consultar perguntas
		Consulta_Perguntas = new JButton();
		Consulta_Perguntas.setText("Consulta de Perguntas");
		Consulta_Perguntas.setBounds(400, 400, 200, 100);
		this.add(Consulta_Perguntas);

		Consulta_Perguntas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				for (cad_perg cad_pergunta : perguntas) {
					JOptionPane.showMessageDialog(null, cad_pergunta.getDescricao(), " Perguntas ",
							JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		Registro_Entrevistas = new JButton();
		Registro_Entrevistas.setText("Registro da Entrevista");
		Registro_Entrevistas.setBounds(400, 200, 200, 100);
		this.add(Registro_Entrevistas);
		// perguntas pro entrevistado
		Registro_Entrevistas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String entrevistado;
				String pergunta;
				String datas;
				relatorio Reg_Entrevistado = new relatorio();
				entrevistado = JOptionPane.showInputDialog("Digite o nome do entrevistado");
				Reg_Entrevistado.setVerificar_Nome(entrevistado);
				for (cad_ent registro_ent : entrevistados) {
					if (Reg_Entrevistado.getVerificar_Nome().equals(registro_ent.getNome())) {
						datas = JOptionPane.showInputDialog("Digite a data da entrevista");
						Reg_Entrevistado.setData(Integer.parseInt(datas));
						for (cad_perg reg_ent : perguntas) {
							pergunta = JOptionPane.showInputDialog(reg_ent.getDescricao());
							Reg_Entrevistado.setReposta(pergunta);
							Reg_Entrevistado.setDesc2(reg_ent.getDescricao());
							
						}
						for (cad_ent ruas : entrevistados) {
							if (entrevistado.equals(ruas.getNome())) {
								Reg_Entrevistado.setRua(ruas.getRua());
							}
						}
						JOptionPane.showMessageDialog(null, " Registro concluido com sucesso! ");
					} else if (Reg_Entrevistado.getVerificar_Nome().contains(registro_ent.getNome())) {
						JOptionPane.showMessageDialog(null, " Pessoa não encontrada! ");
					}
				}
				reg_perguntas.add((relatorio) Reg_Entrevistado);
			}
		});
		// relatorio de entrevistas
		Relatorio_Entrevistas = new JButton();
		Relatorio_Entrevistas.setText("Relatório de Entrevistas");
		Relatorio_Entrevistas.setBounds(400, 20, 200, 100);
		this.add(Relatorio_Entrevistas);
		Relatorio_Entrevistas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String datas;
				relatorio Relat_Entrevistado = new relatorio();
				datas = JOptionPane.showInputDialog("Digite a data da entrevista");
				Relat_Entrevistado.setVerific_Data(Integer.parseInt(datas));
				for (relatorio relat_ent : reg_perguntas) {
					JOptionPane.showMessageDialog(null, relat_ent.getDesc2());
					if (Relat_Entrevistado.getVerific_Data() == relat_ent.getData()) {
						String save2 = ("Nome: " + relat_ent.getVerificar_Nome() + "\nRua: " + relat_ent.getRua()
								+ "\nDescrição: " + relat_ent.getDesc2() + "\nRespostas " + relat_ent.getPerg());
			
						JOptionPane.showMessageDialog(null, save2, " Relatorio de Entrevistas ",
								JOptionPane.PLAIN_MESSAGE);

					} else if (Relat_Entrevistado.getVerific_Data() != relat_ent.getData()) {
						JOptionPane.showMessageDialog(null, " Data não encontrada! ");
						break;
					}
				}
			}
		});
	}
}

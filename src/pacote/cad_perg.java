package pacote;

import java.util.ArrayList;

public class cad_perg {
	private int id;
	private String descricao;
	private int data;
	private ArrayList<String> perg = new ArrayList<>();
	private int verific_Data;
	private ArrayList<String> desc2 = new ArrayList<>();

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public void setReposta(String resposta) {
		this.perg.add(resposta);
	}

	public int getVerific_Data() {
		return verific_Data;
	}

	public void setVerific_Data(int verific_Data) {
		this.verific_Data = verific_Data;
	}

	public ArrayList<String> getPerg() {
		return perg;
	}

	public void setPerg(ArrayList<String> perg) {
		this.perg = perg;
	}

	public ArrayList<String> getDesc2() {
		return desc2;
	}

	public void setDesc2(String desc2) {
		this.desc2.add(desc2);
	}
	
	

}

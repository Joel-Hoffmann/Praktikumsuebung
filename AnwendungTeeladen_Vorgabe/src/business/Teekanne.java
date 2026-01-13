package business;

public class Teekanne {

	private String modell;
	private String material;
	private int fuellmengeMl;

	public Teekanne(String modell, String material, String fuellmengeMl) {
		super();
		this.modell = modell;
		this.material = material;
		this.fuellmengeMl = Integer.parseInt(fuellmengeMl);
	}

	public String gibTeekanneZurueck(char trenner) {
		return this.getModell() + trenner
			+ this.getMaterial() + trenner
			+ this.getFuellmengeMl();
	}

	public String getModell() {
		return modell;
	}

	public void setModell(String modell) {
		this.modell = modell;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public int getFuellmengeMl() {
		return fuellmengeMl;
	}

	public void setFuellmengeMl(int fuellmengeMl) {
		this.fuellmengeMl = fuellmengeMl;
	}
}
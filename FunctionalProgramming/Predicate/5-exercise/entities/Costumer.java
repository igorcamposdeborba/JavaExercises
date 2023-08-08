package entities;

public class Costumer {
	private Long id;
	private String name;
	private Integer tier;
	
	public Costumer() {}
	public Costumer(Long id, String name, Integer tier) {
		this.id = id;
		this.name = name;
		this.tier = tier;
	}
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Integer getTier() {
		return tier;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTier(Integer tier) {
		this.tier = tier;
	}
	
	@Override
	public String toString() {
		return "Id: " + id + ", Nome: " + name + ", Tier: " + tier;
	}
}

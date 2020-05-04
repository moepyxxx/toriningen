package toriningen;

public abstract class Bird {
	protected int strength;
	protected int sex;

	Bird(int sex, int strength) {
		this.sex = sex;
		this.strength = strength;
	}

	public int getSex() {
		return this.sex;
	}
	public String getSexString() {
		if(this.sex == 0) {
			return "オス";
		} else {
			return "メス";
		}
	}

	public abstract int getSelectResult(Hero hero, int act);
}
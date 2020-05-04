package toriningen;

public class Enemy extends Bird {
	private String name = "インコ";
	private int type;

	Enemy(int type, int strength, int sex) {
		super(strength, sex);
		this.type = type;
	}
	public String getName() {
		return this.name;
	}
	public String getStrengthString() {
		if(this.strength == 1) {
			return "つよい ";
		} else {
			return "よわい ";
		}
	}
	public int getSelectResult(Hero hero, int act) {
		int point = this.getAttackEffectPoint(hero, act);
		String impression = this.getAttackEffectImp(hero, act);
		boolean flag = this.getAttackEffectStrengthFlag(hero, act);
		System.out.println(impression);
		isStrength(flag);
		String comment = damageComment(point, flag);
		int restPoint = calcRestPoint(point, flag, hero);
		System.out.println("[にんげんゲージ] は "+ point + "%" + comment);
		System.out.println("[にんげんゲージ] はいま " + restPoint + "% となっている！");
		return restPoint;
	}
	public int getAttackEffectPoint(Hero hero, int act) {
		return 0;
	}
	public String getAttackEffectImp(Hero hero, int act) {
		return "インコデフォルトコメント";
	}
	public boolean getAttackEffectStrengthFlag(Hero hero, int act) {
		return true;
	}
	public String damageComment(int point, boolean flag) {
		System.out.print("[にんげんゲージ] が へんどうした。");
		String comment;
		if(flag == true) {
			comment = " さがってしまった。";
		} else {
			comment = " かいふくした そのちょうしだ！";
		}
		return comment;
	}
	public int calcRestPoint(int point, boolean flag, Hero hero) {
		int restPoint;
		if(flag == true) {
			restPoint = hero.getHumanGage() - point;
			if(restPoint <= 0) {
				restPoint = 0;
			}
		} else {
			restPoint = hero.getHumanGage() + point;
			if(restPoint >= 100) {
				restPoint = 100;
			}
		}
		return restPoint;
	}
	public void isStrength(boolean flag) {
		if(this.strength == 1 && flag == true) {
			System.out.println("つよいとりに えいきょうを うけて [にんげんゲージ] は ２ばい さがってしまった！");
		} else if(this.strength == 1 && flag == false) {
			System.out.println("つよいとりに えいきょうを うけて [にんげんゲージ] は ２ばい かいふくした！");
		}
	}
}

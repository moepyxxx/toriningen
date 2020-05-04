package toriningen;

public class Kogane extends Enemy {
	private String name = "コガネメキシコインコ";
	Kogane(int type, int strength, int sex) {
		super(type, strength, sex);
	}
	public String getName() {
		return this.name;
	}
	public int getAttackEffectPoint(Hero hero, int act) {
		int point = 0;
		int adjustment = this.strength + 1;
		switch(act) {
		case 0:
			point = 30 * adjustment;
			break;
		case 1:
			point = 20 * adjustment;
			break;
		case 2:
			point = 20 * adjustment;
			break;
		case 3:
			int birdSex = this.sex;
			int heroSex = hero.getSex();
			if(birdSex == heroSex) {
				point = 25 * adjustment;
			} else {
				point = 40 * adjustment;
			}
			break;
		}
		return point;
	}
	public String getAttackEffectImp(Hero hero, int act) {
		String impression = "";
		switch(act) {
		case 0:
			System.out.println("こわがりの オカメインコは にげていった。なわばりあらそいを して とりによりちかづいた！");
			break;
		case 1:
			System.out.println("なついてきてくれた。とりをめでる ひとのきもちを おもいだして ひとにもどった！");
			break;
		case 2:
			System.out.println("ごはんにむかうのを おいかけたいしょうどうに。 みかくがかわっている とりに ちかづいた！");
			break;
		case 3:
			int birdSex = this.sex;
			int heroSex = hero.getSex();
			if(birdSex == heroSex) {
				System.out.println("どうせいだったので ことわられた。われにかえった ひとにもどった！");
			} else {
				System.out.println("いせいだったので OKされた。とりのくらしに おもいをはせて とりに ちかづいた！");
			}
			break;
		}
		return impression;
	}
	public boolean getAttackEffectStrengthFlag(Hero hero, int act) {
		boolean flag = true;
		switch(act) {
		case 0:
			flag = true;
			break;
		case 1:
			flag = false;
			break;
		case 2:
			flag = true;
			break;
		case 3:
			int birdSex = this.sex;
			int heroSex = hero.getSex();
			if(birdSex == heroSex) {
				flag = false;
			} else {
				flag = true;
			}
			break;
		}
		return flag;
	}
}
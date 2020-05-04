package toriningen;

public class Botan extends Enemy {
	private String name = "ボタンインコ";
	Botan(int type, int strength, int sex) {
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
			point = 25 * adjustment;
			break;
		case 1:
			point = 10 * adjustment;
			break;
		case 2:
			point = 15 * adjustment;
			break;
		case 3:
			int birdSex = this.sex;
			int heroSex = hero.getSex();
			if(birdSex == heroSex) {
				point = 50 * adjustment;
			} else {
				point = 25 * adjustment;
			}
			break;
		}
		return point;
	}
	public String getAttackEffectImp(Hero hero, int act) {
		String impression = "";
		switch(act) {
		case 0:
			System.out.println("いかくしかえされた。 「とりってこわい」と スズメのきもちになり とりに ちかづいた！");
			break;
		case 1:
			System.out.println("きやすくさわるなと くちばしでツンツン された。ツンツンを しかえして とりに ちかづいた！");
			break;
		case 2:
			System.out.println("おれいにあたまを カキカキされて じぶんもとりを カキカキしたくなった ひとにもどった！");
			break;
		case 3:
			int birdSex = this.sex;
			int heroSex = hero.getSex();
			if(birdSex == heroSex) {
				System.out.println("どうせいだったが こどくな こころのきんせんにふれて りょうおもいに。とりに ちかづいた！");
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
			flag = true;
			break;
		case 2:
			flag = false;
			break;
		case 3:
			int birdSex = this.sex;
			int heroSex = hero.getSex();
			if(birdSex == heroSex) {
				flag = true;
			} else {
				flag = true;
			}
			break;
		}
		return flag;
	}
}

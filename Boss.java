package toriningen;

public class Boss extends Bird {
	private String name = "タイハクのじょおうさま";

	Boss(int strength, int sex) {
		super(strength, sex);
	}
	public String getName() {
		return this.name;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getSelectResult(Hero hero, int act) {
		int point = 0;
		int adjustment = this.strength + 1;
		switch(act) {
		case 0:
			System.out.print("「こしゃくな、このわたしにむかって、なわばりポーズだと！」");
			System.out.println(this.getName() + "は おこってしまった！");
			point = adjustment * 50;
			break;
		case 1:
			System.out.print("「これで ぜんりょくの カキカキとは とりをなめてるな」");
			System.out.println("といいつつも " + this.getName() + " は すこし きもちよさそうだ");
			point = adjustment * 15;
			break;
		case 2:
			System.out.print("「わたしのえさは あわではない きのみだ！」");
			System.out.println(this.getName() + "は ばかにされていると おもい じたんだをふんだ！");
			point = adjustment * 20;
			break;
		case 3:
			int birdSex = this.sex;
			int heroSex = hero.getSex();
			if(birdSex == heroSex) {
				System.out.print("「おんなどうしだぞ、このせっそうなし！」" + this.getName() + "は");
				System.out.println("わきあがるいかりを おさえることができない");
				point = adjustment * 100;
			} else {
				System.out.print("「わたしは 300ねんいきる としうえだぞ それでもよいのか …ってそうではないぞ」");
				System.out.println(this.getName() + "は あわてている");
				point = adjustment * 5;
			}
			break;
		}
		int restPoint = hero.getHumanGage() - point;
		if(restPoint <= 0) {
			restPoint = 0;
		}
		String comment = damageComment(point);
		System.out.println("[にんげんゲージ] は"+ point + "%さがった。" + comment);
		System.out.println("[にんげんゲージ] はいま" + restPoint + "%となっている。");
		return restPoint;
	}
	public String damageComment(int point) {
		String comment;
		if(point >= 80) {
			comment = "ちめいてきな だいダメージを うけてしまった。";
		} else if(point >= 30) {
			comment = "なんとか だいダメージは さけられたみたいだ。";
		} else {
			comment = "おもったよりも よゆうだったみたいだ。";
		}
		return comment;
	}
	public void bossButtleResult(Hero hero) {
		int restPoint = hero.getHumanGage();
		int score = getEndScore(restPoint);
		resultJudge(score, hero);
	}
	public int getEndScore(int restPoint) {
		int score;
		if(this.strength == 0) {
			score = restPoint * 3;
		} else if(this.strength == 1) {
			score = restPoint * 2;
		} else {
			score = restPoint * 1;
		}
		return score;
	}
	public void resultJudge(int score, Hero hero) {
		System.out.print("「いまの [にんげんゲージ] は" + hero.getHumanGage() + "％か…」");
		System.out.println(this.getName() + "はつぶやいた。そして……");
		int humanGage;
		if(score >= 60) {
			System.out.println("「とりとして いきるのがしあわせだと おもったから きみをとりにしたが まちがいだったみたいだ」");
			System.out.print("ふっふっふと わらって" + this.getName() + "は ");
			System.out.println(hero.getName() + "の [にんげんゲージ] を100%にしてくれた！");
			System.out.println(hero.getName() + "はみごと" + this.getName() + "にうちかち ひととしてのじぶんを とりもどした。");
			humanGage = 100;
		} else {
			if(score == 0) {
				System.out.println("「もうたたかうちからは のこっていまい。[にんげんゲージ] はゼロだ。とりとしていきるがよい」");
				System.out.println("ふっふっふと"+ this.getName() + "はわらった。");
			} else {
				System.out.println("「もう [にんげんゲージ] は あまり のこっていないではないか。とりになった方が しあわせだぞ」");
				System.out.print("ふっふっふと わらって " + this.getName() + "は ");
				System.out.println(hero.getName() + "の [にんげんゲージ] を 0にしてしまった！");
			}
			humanGage = 0;
		}
		hero.setHumanGage(humanGage);
	}
}
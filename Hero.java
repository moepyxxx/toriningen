package toriningen;
import java.util.Scanner;

public class Hero {
	Scanner scanner = new Scanner(System.in);
	private String name;
	private int sex;
	private String fPerson;
	private int humanGage = 100;
	private int walkCount;
	private Road road;

	Hero(String name, int sex) {
		this.name = name;
		this.sex = sex;
		if(this.sex == 0) {
			this.fPerson = "ぼく";
		} else {
			this.fPerson = "わたし";
		}
	}

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSex() {
		return this.sex;
	}
	public String getSexString() {
		if(this.sex == 0) {
			return "おとこ";
		} else {
			return "おんな";
		}
	}
	public String getFPerson() {
		return this.fPerson;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getHumanGage() {
		return this.humanGage;
	}
	public void setHumanGage(int humanGage) {
		this.humanGage = humanGage;
	}
	public int getWalkCount() {
		return this.walkCount;
	}
	public void setWalkCount(int num) {
		this.walkCount = num;
	}
	public void setRoad(Road road) {
		this.road = road;
	}

	public boolean goAdventure(Story story, Road road) {
		for(int i = 0; i < road.getWalkTimes() ; i++) {
			this.walkField();
			Enemy enemy = story.createEnemy();
			this.battleEnemy(enemy);
			if(this.getHumanGage() == 0) {
				break;
			}
		}
		if(this.getHumanGage() == 0) {
			return false;
		} else {
			return true;
		}
	}
	public void walkField() {
		System.out.println("どこへいきますか？：");
		int num = setPlaceNum();
		String[] places = road.getSelectPlace(num);
		System.out.println("（" + places[0] + "：0、" + places[1] + "：1）");
		int select = scanner.nextInt();
		System.out.println("よし、" + places[select] + "にきめた！ あるきはじめた。");
		this.walkCount --;
	}
	public void battleEnemy(Enemy enemy) {
		this.encounterEnemy(enemy);
		int act = this.selectAct(enemy);
		int restPoint = enemy.getSelectResult(this, act);
		this.setHumanGage(restPoint);
	}
	public void encounterEnemy(Enemy enemy) {
		System.out.print(this.name + "は" + enemy.getStrengthString() + enemy.getName());
		System.out.println("（" + enemy.getSexString() + "）とであった。");
		System.out.print(enemy.getStrengthString() + enemy.getName() + "は どうやら");
		System.out.println("しょうぶ を したいようである。" + this.getName() + "はどうする？");
	}
	public int setPlaceNum() {
		int num = 0;
		if(this.walkCount == 3) {
			num = 0;
		} else if(this.walkCount == 2) {
			num = 1;
		} else if(this.walkCount == 1) {
			num = 2;
		}
		return num;
	}
	public int selectAct(Enemy enemy) {
		String[] selectList = {
			"はねをひろげる" ,
			"けづくろいしてあげる",
			"ごはんのばしょをおしえる",
			"プロポーズする"
		};
		System.out.println("（はねをひろげる:0 , けづくろいしてあげる:1 , ごはんのばしょをおしえる:2 , プロポーズする:3）");
		int select = scanner.nextInt();
		System.out.println("よし ここは【" + selectList[select] + "】をしてみよう！");
		return select;
	}
	public boolean selectBattleBoss(Boss boss) {
		boolean bossPrepare;
		System.out.print("やっと"  + boss.getName() + "のいえへとたどりついた！");
		System.out.println("とりさんの ぼうがいにはあったけれど ぶじ ひとのこころをもったままだ。");
		System.out.println("ここからどうする？：（ただいまの [にんげんゲージ] は" + this.humanGage + "％だ）");
		System.out.println("（ひとにもどして もらえるよう こうしょうへいく:0 , さんさくして [にんげんゲージ] をあげる:1）");
		int select = scanner.nextInt();
		if(select == 0) {
			bossPrepare = true;
		} else {
			bossPrepare = false;
		}
		return bossPrepare;
	}
	public void encounterBoss(Boss boss) {
		System.out.print("よし " + boss.getName() + "のいえへいってみよう！");
		System.out.println("へやへはいったら、"  + boss.getName() +  "があらわれた。");
		System.out.println("「にんげんに もどして ほしいなら このわたしとたたかいたまえ」だって！");
		System.out.println("せんたくのチャンスは １かいだ！ がんばって さいてきなせんたくを しよう。");
	}
	public boolean battleBoss(Boss boss) {
		this.encounterBoss(boss);
		int act = this.selectBossAct(boss);
		int restPoint = boss.getSelectResult(this, act);
		this.setHumanGage(restPoint);
		boss.bossButtleResult(this);
		if(this.getHumanGage() == 0) {
			return false;
		} else {
			return true;
		}
	}
	public int selectBossAct(Boss boss) {
		String[] selectList = {
			"はねをめいいっぱいひろげる" ,
			"すっごいていねいにけづくろい",
			"ありったけのごはんのばしょをでんじゅ",
			"とうしんだいのあいをプロポーズ"
		};
		System.out.print("（はねをめいいっぱいひろげる:0 , すっごいていねいにけづくろい:1 , ");
		System.out.println("ありったけのごはんのばしょをでんじゅ:2 , とうしんだいのあいをプロポーズ:3）");
		int select = scanner.nextInt();
		System.out.println("よし、ここは【" + selectList[select] + "】をしてみよう！");
		return select;
	}
}
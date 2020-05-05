package toriningen;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Hero extends Player {
	private String fPerson;
	private int humanGage = 100;
	private int walkCount;
	private Road road;

	Hero(String name, int sex) {
		super(name, sex);
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
		return this.isRestHumanGage();
	}
	public void walkField() {
		int num = setPlaceNum();
		String[] places = road.getSelectPlace(num);
		ArrayList<String> roads = new ArrayList<String>();
		roads.add(places[0]);
		roads.add(places[1]);
		try {
			System.out.println("どこへいきますか？：");
			int select = getCorrectUserData(roads);
			System.out.println("よし、" + roads.get(select) + "にきめた！ あるきはじめた。");
			this.walkCount --;
		}
		catch(InputMismatchException e) {
			this.catchInputMismatchException(roads);
			walkField();
		}
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
		ArrayList<String> selectList = new ArrayList<String>();
		selectList.add("はねをひろげる");
		selectList.add("けづくろいしてあげる");
		selectList.add("ごはんのばしょをおしえる");
		selectList.add("プロポーズする");
		try {
			int select =  this.getCorrectUserData(selectList);
			System.out.println("よし ここは【" + selectList.get(select) + "】をしてみよう！");
			return select;
		}
		catch(InputMismatchException e) {
			this.catchInputMismatchException(selectList);
			return selectAct(enemy);
		}
	}
	public boolean selectBattleBoss(Boss boss) {
		System.out.print("やっと"  + boss.getName() + "のいえへとたどりついた！");
		System.out.println("とりさんの ぼうがいにはあったけれど ぶじ ひとのこころをもったままだ。");
		System.out.println("ここからどうする？：（ただいまの [にんげんゲージ] は" + this.humanGage + "％だ）");
		ArrayList<String> selectList = new ArrayList<String>();
		selectList.add("ひとにもどして もらえるよう こうしょうへいく");
		selectList.add("さんさくして [にんげんゲージ] をあげる");
		try {
			int select = this.getCorrectUserData(selectList);
			return this.changeIntBoolean(select);
		}
		catch(InputMismatchException e) {
			this.catchInputMismatchException(selectList);
			return selectBattleBoss(boss);
		}
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
		return this.isRestHumanGage();
	}
	public int selectBossAct(Boss boss) {
		ArrayList<String> selectList = new ArrayList<String>();
		selectList.add("はねをめいいっぱいひろげる");
		selectList.add("すっごいていねいにけづくろい");
		selectList.add("ありったけのごはんのばしょをでんじゅ");
		selectList.add("とうしんだいのあいをプロポーズ");
		try {
			int select =  this.getCorrectUserData(selectList);
			System.out.println("よし ここは【" + selectList.get(select) + "】をしてみよう！");
			return select;
		}
		catch(InputMismatchException e) {
			this.catchInputMismatchException(selectList);
			return selectBossAct(boss);
		}
	}
	public boolean isRestHumanGage() {
		if(this.getHumanGage() == 0) {
			return false;
		} else {
			return true;
		}
	}
}
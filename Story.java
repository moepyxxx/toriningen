package toriningen;

public class Story {

	public void settingGame(Hero hero, Boss boss) {
		String playerName = hero.setPlayerName(this);
		int playerSex = hero.setPlayerSex(this);
		int bossStrength = hero.setBossStrength(boss);
		hero.setName(playerName);
		hero.setSex(playerSex);
		boss.setStrength(bossStrength);
		System.out.print("あなたのなまえ：" + hero.getName() + "、あなたのせいべつ：" + hero.getSexString());
		System.out.println("…ということで ゲームかいしです！");
	}
	public void firstExplained(Boss boss, Hero hero) {
		System.out.println("【 とりにんげん 〜 とりになってしまったひと 〜 】");
		System.out.print("あさおきたら" + hero.getFPerson() + "はとりになってしまっていました。");
		System.out.println("このゲームは " + hero.getFPerson() + "が");
		System.out.println("とりのせかいをおさめている" + boss.getName() + "のところへいき ひとにもどしてもらう ゲームです。");
		System.out.println(hero.getFPerson() + "にはいま [にんげんゲージ] がある。いまは100%ですが ゲージが0%になってしまうと");
		System.out.println("ひとであったことを わすれて ほんもののとりになってしまう。ちゅうい しなければならない。");
		System.out.println("ではしゅっぱつを しよう。" + boss.getName() + "のいえをめざして！");
	}
	public Enemy createEnemy() {
		int typeNum = this.rBirdType();
		int strengthNum = this.rBirdStrength();
		int sexNum = this.rBirdSex();
		Enemy e = new Enemy(typeNum, strengthNum, sexNum);
		switch (typeNum) {
		case 0:
			e = new Okame(typeNum, strengthNum, sexNum);
			break;
		case 1:
			e = new Kogane(typeNum, strengthNum, sexNum);
			break;
		case 2:
			e = new Botan(typeNum, strengthNum, sexNum);
			break;
		}
		return e;
	}
	public int rBirdType() {
		int r = new java.util.Random().nextInt(3);
		return r;
	}
	public int rBirdStrength() {
		int r = new java.util.Random().nextInt(2);
		return r;
	}
	public int rBirdSex() {
		int r = new java.util.Random().nextInt(2);
		return r;
	}
	public void gameOver(Hero hero) {
		System.out.println("[にんげんゲージ] がすべてなくなった。そのせつな " + hero.getFPerson() + "は ひとであることを わすれた。");
		System.out.println("ああ そらがあおい。ぜっこうの はばたきびよりだ。" + hero.getFPerson() + "は はねをひろげて とびだした！");
		System.out.println("そして しあわせにくらした。はたして このけつまつは ほんとうに バッドエンドだったのか。それは だれにもわからない。");
		System.out.println("ピヨピヨ・・・ピヨピヨピヨピヨ・・・・・・・・・・・・・・・・・・・・。");
		System.out.println("【 とりにんげん 〜 GAME OVER 〜 】");
	}
	public void gameClear(Hero hero) {
		System.out.println("[にんげんゲージ] がかいふくした。そのせつな " + hero.getFPerson() + "は 自分が人であることを思い出した。");
		System.out.println("あの美味しいからあげのことも、思い出したのだ。" + hero.getFPerson() + "は、人間に戻れて本当に良かった！");
		System.out.println("でも忘れないでください・・・人であることをやめようと思ったら、また鳥の王様がいたずらをするかもしれない・・・。");
		System.out.println("【 とりにんげん 〜 GAME CLEAR 〜 】");
	}
}
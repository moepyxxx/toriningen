package toriningen;

public class Main {
	public static void main(String[] args) {
		Story story = new Story();
		Road road = new Road();
		Hero hero = new Hero("主人公", 1);
		Boss boss = new Boss(1, 1);
		hero.setRoad(road);
		boolean tryPrepare = true;
		while(tryPrepare) {
			story.settingGame(hero, boss);
			System.out.println("= = = = = = = = = = = = = = = = = =");
			boolean endAdventure = false;
			boolean playerActive = true;
			story.firstExplained(boss, hero);
			while(!(endAdventure)) {
				hero.setWalkCount(road.getWalkTimes());
				playerActive = hero.goAdventure(story, road);
				if(playerActive) {
					endAdventure = hero.selectBattleBoss(boss);
				} else {
					endAdventure = true;
				}
			}
			if(playerActive) {
				playerActive = hero.battleBoss(boss);
			}
			if(playerActive) {
				story.gameClear(hero);
			} else {
				story.gameOver(hero);
			}
			tryPrepare = story.gameRetry();
		}
		System.out.println("= = = = = = = = = = = = = = = = = =");
	}
}
package toriningen;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Player {
	Scanner scanner = new Scanner(System.in);
	protected String name;
	protected int sex;

	Player(String name, int sex) {
		this.name = name;
		this.sex = sex;
	}

	public String setPlayerName(Story story) {
		System.out.println("あなたの なまえ を おしえてください：");
		String name = scanner.next();
		return name;
	}
	public int setPlayerSex(Story story) {
		ArrayList<String> sexes = new ArrayList<String>();
		sexes.add("おとこ");
		sexes.add("おんな");
		try {
			System.out.println("あなたの せいべつ をおしえてください：");
			return this.getCorrectUserData(sexes);
		}
		catch(InputMismatchException e) {
			this.catchInputMismatchException(sexes);
			return this.setPlayerSex(story);
		}
	}
	public int setBossStrength(Boss boss) {
		ArrayList<String> bossStrengthes = new ArrayList<String>();
		bossStrengthes.add("そこそこつよい");
		bossStrengthes.add("むっちゃつよい");
		bossStrengthes.add("やばい（ほぼクリアできない）");
		try {
			System.out.println("ボスである " + boss.getName() + "の つよさを えらんでください：");
			return this.getCorrectUserData(bossStrengthes);
		}
		catch(InputMismatchException e) {
			this.catchInputMismatchException(bossStrengthes);
			return this.setBossStrength(boss);
		}
	}
	public boolean gameRetry() {
		ArrayList<String> answeres = new ArrayList<String>();
		answeres.add("トライする");
		answeres.add("もうやめる");
		try {
			System.out.println("もういちど トライしますか？");
			int answer = getCorrectUserData(answeres);
			return this.changeIntBoolean(answer);
		}
		catch(InputMismatchException e) {
			this.catchInputMismatchException(answeres);
			return this.gameRetry();
		}
	}
	public boolean changeIntBoolean(int answer) {
		boolean alter;
		if(answer == 0) {
			alter = true;
		} else {
			alter = false;
		}
		return alter;
	}
	public int getCorrectUserData(ArrayList<String> datas) {
		String printText = "（";
		int maxSize = datas.size() - 1;
		for(int i = 0; i < datas.size(); i++) {
			String addPrintText = "";
			addPrintText += datas.get(i) + " : " + i + " ";
			if( i == maxSize) {
				addPrintText += "）";
			} else {
				addPrintText += ", ";
			}
			printText += addPrintText;
		}
		System.out.println(printText);
		int select = scanner.nextInt();
		while(!(select >= 0 && select < datas.size())) {
			System.out.print("0〜" + maxSize + " いがい が にゅうりょく されました。");
			System.out.println("もういちど にゅうりょく してください。：");
			System.out.println(printText);
			select = scanner.nextInt();
		}
		return select;
	}
	public void catchInputMismatchException(ArrayList<String> datas) {
		int maxSize = datas.size() - 1;
		System.out.print("0〜" + maxSize + " いがい が にゅうりょく されました。");
		System.out.println("もういちど にゅうりょく してください。：");
		scanner.next();
	}
}

package toriningen;
public class Road {
	private int walkTimes = 3;
	private String[][] places = {
		{"しずかなかわべ", "ひろいおおぞら"},
		{"みどりのもり", "ごつごつのいわば"},
		{"こわそうなほらあな", "さわがしいまちなか"}
	};

	public int getWalkTimes() {
		return this.walkTimes;
	}
	public String[] getSelectPlace(int num) {
		return this.places[num];
	}
}
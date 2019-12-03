package cn.sxt.action;

import java.util.List;

public class UserAction {
	private String name;
	private String[] hobbies;
	private List<String> games;
	public String execute(){
		System.out.println("name="+name);
		System.out.print("hobbies=");
		for(int i=0;i<hobbies.length;i++){
			System.out.print(hobbies[i]+"  ");
		}
		System.out.println();
		System.out.println("games="+games);
		return "success";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	public List<String> getGames() {
		return games;
	}
	public void setGames(List<String> games) {
		this.games = games;
	}
}

package lessonone;

import java.util.ArrayList;

import extra.Util;

public class QuizParticipant {

	private String identifier;			//e pandryshueshme
	private ArrayList<Double> points;	//nuk mund t hiqen te dhena 

	public QuizParticipant(String identifier) {
		this.identifier = identifier;
		points = new ArrayList<Double>();
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public Double getPoints(int index) {
		if(index >= 0 && index < points.size()) {
			return points.get(index);
		}
		return null;
	}
	
	public void addPoints(double points) {
		this.points.add(points);
	}
	
	public int getNumberOfQuizzes() {
		return points.size();
	}
	
	public double getTotalPoints() {
		return Util.getSum(points);
	}
	
	public Double getAveragePoints() {
		if(points.isEmpty()) {
			return null;
		}
		return getTotalPoints() / getNumberOfQuizzes();
	}
	
}

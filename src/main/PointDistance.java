package main;
import java.awt.*;

public class PointDistance extends Point {

	public int distance = Integer.MAX_VALUE;

	public PointDistance(Point point) {
		super(point);
	}

	public void Update(PointDistance point) {
		this.x = point.x;
		this.y = point.y;
		this.distance = point.distance;
	}
	public void Update(Point point, Integer distance) {
		this.x = point.x;
		this.y = point.y;
		this.distance = distance;
	}
}
package extra;
import java.io.*;
import java.util.*;


/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.

 (1,2), (0, 1), (-2, -3), (4, 1), (0,0), (0, 5), (1, 1)

k = 3

(0,0)

 */

class Point{
    int x, y;
    Point(int x, int y){
        this.x = x;
        this.y =y;
    }
}

class DistancePoint{
    Point p;
    float distance;
    DistancePoint(Point p,float distance ){
        this.p= p;
        this.distance = distance;
    }

}

public class ClosestPointToOrigin {

    public static void main(String[] args) {

        int [][] points = {{1,2}, {0, 1}, {-2, -3}, {4, 1}, {0,0}, {0, 5}, {1, 1}};
        List<DistancePoint> pointsDistance = new ArrayList<>();
        Point start = new Point(0,0);

        for(int i =0; i< points.length; i ++){
            Point p = new Point(points[i][0],points[i][1] );
            float dist = dist(start,p);
            DistancePoint dp = new DistancePoint(p, dist);
            pointsDistance.add(dp);

        }

        Collections.sort(pointsDistance,(x,y)-> Float.compare(x.distance,y.distance));

        pointsDistance.stream().limit(5).forEach(x->{
            System.out.println(x.p.x + " " + x.p.y + " Distance = " + x.distance );
        });
    }
    
    static float dist( Point p1, Point p2){
        return (float)Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    }

}

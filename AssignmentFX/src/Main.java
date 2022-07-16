import javafx.application.Application;
import java.nio.file.Paths;
import java.sql.*;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import java.io.IOException;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

enum MyColor{
 	MAROON(128,0,0,255),
 	DARKRED(139,0,255,255),
 	BROWN(165,42,42,255),
 	FIREBRICK(178,34,34,255),
 	CRIMSON(220,20,60,255),
 	RED(255,0,0,255),
 	TOMATO(255,99,71,255),
 	CORAL(255,127,80,255),
 	INDIANRED(205,92,92,255),
 	LIGHTCORAL(240,128,128,255),
 	DARKSALMON(233,150,122,255),
 	SALMON(250,128,114,255),
 	LIGHTSALMON(255,160,122,255),
 	ORANGERED(255,69,0,255),
 	DARKORANGE(255,140,0,255),
 	ORANGE(255,165,0,255),
 	GOLD(255,215,0,255),
 	DARKGOLDENROD(184,134,11,255),
 	GOLDENROD(218,165,32,255),
 	PALEGOLDENROD(238,232,170,255),
 	DARKKHAKI(189,183,107,255),
 	KHAKI(240,230,140,255),
 	OLIVE(128,128,0,255),
 	YELLOW(255,255,0,255),
 	YELLOWGREEN(154,205,50,255),
 	DARKOLIVEGREEN(85,107,47,255),
 	OLIVEDRAB(107,142,35,255),
 	LAWNGREEN(124,252,0,255),
 	CHARTREUSE(127,255,0,255),
 	GREENYELLOW(173,255,47,255),
 	DARKGREEN(0,100,0,255),
 	GREEN(0,128,0,255),
 	FORESTGREEN(34,139,34,255),
 	LIME(0,255,0,255),
 	LIMEGREEN(50,205,50,255),
 	LIGHTGREEN(144,238,144,255),
 	PALEGREEN(152,251,152,255),
 	DARKSEAGREEN(143,188,143,255),
 	MEDIUMSPRINGGREEN(0,250,154,255),
 	SPRINGGREEN(0,255,127,255),
 	SEAGREEN(46,139,87,255),
 	MEDIUMAQUAMARINE(102,205,170,255),
 	MEDIUMSEAGREEN(60,179,113,255),
 	LIGHTSEAGREEN(32,178,170,255),
 	DARKSLATEGRAY(47,79,79,255),
 	TEAL(0,128,128,255),
 	DARKCYAN(0,139,139,255),
 	AQUA(0,255,255,255),
 	CYAN(0,255,255,255),
 	LIGHTCYAN(224,255,255,255),
 	DARKTURQUOISE(0,206,209,255),
 	TURQUOISE(64,224,208,255),
 	MEDIUMTURQUOISE(72,209,204,255),
 	PALETURQUOISE(175,238,238,255),
 	AQUAMARINE(127,255,212,255),
 	POWDERBLUE(176,224,230,255),
 	CADETBLUE(95,158,160,255),
 	STEELBLUE(70,130,180,255),
 	CORNFLOWERBLUE(100,149,237,255),
 	DEEPSKYBLUE(0,191,255,255),
 	DODGERBLUE(30,144,255,255),
 	LIGHTBLUE(173,216,230,255),
 	SKYBLUE(135,206,235,255),
 	LIGHTSKYBLUE(135,206,250,255),
 	MIDNIGHTBLUE(25,25,112,255),
 	NAVY(0,0,128,255),
 	DARKBLUE(0,0,139,255),
 	MEDIUMBLUE(0,0,205,255),
 	BLUE(0,0,255,255),
 	ROYALBLUE(65,105,225,255),
 	BLUEVIOLET(138,43,226,255),
 	INDIGO(75,0,130,255),
 	DARKSLATEBLUE(72,61,139,255),
 	SLATEBLUE(106,90,205,255),
 	MEDIUMSLATEBLUE(123,104,238,255),
 	MEDIUMPURPLE(147,112,219,255),
 	DARKMAGENTA(139,0,139,255),
 	DARKVIOLET(148,0,211,255),
 	DARKORCHID(153,50,204,255),
 	MEDIUMORCHID(186,85,211,255),
 	PURPLE(128,0,128,255),
 	THISTLE(216,191,216,255),
 	PLUM(221,160,221,255),
 	VIOLET(238,130,238,255),
 	MAGENTA(255,0,255,255),
 	ORCHID(218,112,214,255),
 	MEDIUMVIOLETRED(199,21,133,255),
 	PALEVIOLETRED(219,112,147,255),
 	DEEPPINK(255,20,147,255),
 	HOTPINK(255,105,180,255),
 	LIGHTPINK(255,182,193,255),
 	PINK(255,192,203,255),
 	ANTIQUEWHITE(250,235,215,255),
 	BEIGE(245,245,220,255),
 	BISQUE(255,228,196,255),
 	BLANCHEDALMOND(255,235,205,255),
 	WHEAT(245,222,179,255),
 	CORNSILK(255,248,220,255),
 	LEMONCHIFFON(255,250,205,255),
 	LIGHTGOLDENRODYELLOW(250,250,210,255),
 	LIGHTYELLOW(255,255,224,255),
 	SADDLEBROWN(139,69,19,255),
 	SIENNA(160,82,45,255),
 	CHOCOLATE(210,105,30,255),
 	PERU(205,133,63,255),
 	SANDYBROWN(244,164,96,255),
 	BURLYWOOD(222,184,135,255),
 	TAN(210,180,140,255),
 	ROSYBROWN(188,143,143,255),
 	MOCCASIN(255,228,181,255),
 	NAVAJOWHITE(255,222,173,255),
 	PEACHPUFF(255,218,185,255),
 	MISTYROSE(255,228,225,255),
 	LAVENDERBLUSH(255,240,245,255),
 	LINEN(250,240,230,255),
 	OLDLACE(253,245,230,255),
 	PAPAYAWHIP(255,239,213,255),
 	SEASHELL(255,245,238,255),
 	MINTCREAM(245,255,250,255),
 	SLATEGRAY(112,128,144,255),
 	LIGHTSLATEGRAY(119,136,153,255),
 	LIGHTSTEELBLUE(176,196,222,255),
 	LAVENDER(230,230,250,255),
 	FLORALWHITE(255,250,240,255),
 	ALICEBLUE(240,248,255,255),
 	GHOSTWHITE(248,248,255,255),
 	HONEYDEW(240,255,240,255),
 	IVORY(255,255,240,255),
 	AZURE(240,255,255,255),
 	SNOW(255,250,250,255),
 	BLACK(0,0,0,255),
 	DIMGRAY(105,105,105,255),
 	GRAY(128,128,128,255),
 	DARKGRAY(169,169,169,255),
 	SILVER(192,192,192,255),
 	LIGHTGRAY(211,211,211,255),
 	GAINSBORO(220,220,220,255),
 	WHITESMOKE(245,245,245,255),
 	WHITE(255,255,255,255);
	
 	private int r,g,b,a;
	private int rgba;
	public void setR(int r) {
		this.r = r;
	}
	public void setG(int g) {
		this.g = g;
	}
	public void setB(int b) {
		this.b = b;
	}
	public void setA(int a) {
		this.a = a;
	}
 	MyColor(int r,int g, int b, int a){
 		if (r<256 && g<256 && b<256 && a<256) {
			setA(a);
			setR(r);
			setB(b);
			setG(g);
			setRGBA(r,g,b,a);
		}
 	}
 	public void setRGBA(int r, int g, int b, int a) {
 		rgba =	(a<<24)& 0xFF000000 |
 				(r<<16)& 0x00FF0000 |
 				(g<<24)& 0x0000FF00 |
 				b;
 	}
 	public String getHexRep() {
 		return "#" + Integer.toHexString(rgba).toUpperCase();
 	}
 	public Color getJavaFXColor() {
		return Color.web("rgba(" + r + "," + g + "," + b + ",1.0)");
	}
}
interface MyShapeInterface {
	MyRectangle getMyBoundingRectangle();
	boolean pointInMyShape(MyPoint point);
	static boolean rectangleOverlap(MyRectangle r1, MyRectangle r2) {
		int h1=r1.getHeight();
		int w1=r1.getWidth();
		int h2=r2.getHeight();
		int w2=r2.getWidth();
		int x1=r1.getP().getX();
		int y1=r1.getP().getY();
		int x2=r2.getP().getX();
		int y2=r2.getP().getY();
		if (y1 + h1 < y2 || y1 > y2 + h2) return false;
		if (x1 + w1< x2 || x1 > x2 + w2) return false;
		return true;
	}
	static boolean shapeOverlap(MyShape s1, MyShape s2) {
		MyRectangle r1=s1.getMyBoundingRectangle();
		MyRectangle r2=s2.getMyBoundingRectangle();
		return rectangleOverlap(r1,r2);
	};
	public static List<MyPoint> intersectMyShapes(MyShape s1, MyShape s2) {
		MyRectangle r1=s1.getMyBoundingRectangle();
		MyRectangle r2=s2.getMyBoundingRectangle();
		if(shapeOverlap(s1,s2)) {
			int x1 = r1.getP().getX();
			int y1 = r1.getP().getY();
			int w1 = r1.getWidth();
			int h1 = r1.getHeight();
			int x2 = r2. getP().getX();
			int y2 = r2.getP().getY();
			int w2 = r2.getWidth();
			int h2 = r2. getHeight();
			
			int SquareX = Math.max(x1, x2);
			int SquareY = Math.max(y1, y2);
			int SquareX2 = Math.min(x1+w1, x2+w2);
			int SquareY2 = Math.min(y1+h1, y2+h2);
			
			int w = Math.abs(SquareX-SquareX2);
			int h = Math.abs(SquareY-SquareY2);
			
			List<MyPoint> pointList = new ArrayList<MyPoint>();
			for (int i=0; i< w; i++){
				int z = SquareX+i;
				for (int j= 0; j< h; j++){
					MyPoint p = new MyPoint(z, SquareY + j, MyColor.BLACK);
					if (s1.pointInMyShape(p) && s2.pointInMyShape(p)){
						pointList.add(p);
					}
				}
			}
			return pointList;
		}
		else {
			return null;
		}
	}
	public default Canvas drawIntersectMyShapes(MyShape s1, MyShape s2){
		List<MyPoint> points = intersectMyShapes(s1,s2);
		Canvas cv = new Canvas(1000,1000) ;
		GraphicsContext gc = cv.getGraphicsContext2D();
		for(int i = 0; i<points.size()-1;i++) {
			MyLine l = new MyLine(points.get(i),MyColor.BLACK,points.get(i+1));
			l.draw(gc);
		}
		return cv;
	}
}
class MyPoint{
	private int x,y;
	private MyColor color;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public MyColor getColor() {
		return color;
	}
	public void setColor(MyColor color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "[x=" + x + ", y=" + y + "]";
	}
	public double distance(MyPoint p1) {
		int h = x-p1.getX();
		int l = y-p1.getY();
		return Math.sqrt((h*h)+(l*l));
	}
	public double angleX(MyPoint p1) {
		double dx=p1.getX()-x;
		double dy=p1.getY()-y;
		return Math.toDegrees(Math.atan2(dy,dx));
	}
	public MyPoint(){x = 0;y = 0; color = MyColor.WHITE;}
	public MyPoint(int userX, int userY, MyColor userColor ){x = userX;y = userY; color = userColor;}
	public void draw(GraphicsContext Gc) {
		Gc.setStroke(color.getJavaFXColor());
		Gc.strokeLine(x, y, x, y);;
	}
	
}
abstract class MyShape implements MyShapeInterface{
	private MyPoint p1;
	private MyColor color;
	public MyPoint getP1() {
		return p1;
	}
	public void setP1(MyPoint p1) {
		this.p1 = p1;
	}
	public MyColor getColor() {
		return color;
	}
	public void setColor(MyColor color) {
		this.color = color;
	}
	public MyShape(MyPoint p1, MyColor color) {
		this.p1 = p1;
		this.color = color;
	}
	public int area() {return 0;}
	public int perimeter() {return 0;}
	@Override
	public String toString() {
		return "MyShape [p1=" + p1.toString() + ", color=" + color.getHexRep() + "]";
	}
	public void draw(GraphicsContext Gc) {
		Gc.setStroke(color.getJavaFXColor());
		Gc.fillRect(0, 0, Gc.getCanvas().getWidth(), Gc.getCanvas().getHeight());
	}
	
}
class MyLine extends MyShape{
	private MyPoint p1,p2;
	private MyColor lColor;
	
	public MyPoint getP1() {
		return p1;
	}
	public void setP1(MyPoint p1) {
		this.p1 = p1;
	}
	public MyPoint getP2() {
		return p2;
	}
	public void setP2(MyPoint p2) {
		this.p2 = p2;
	}
	public MyColor getlColor() {
		return lColor;
	}
	public void setlColor(MyColor lColor) {
		this.lColor = lColor;
	}
	public MyLine(MyPoint p1, MyColor color, MyPoint p2) {
		super(p1, color);
		this.p1 = p1;
		this.p2 = p2;
		this.lColor = color;
	}
	public double length() {
		return p1.distance(p2);
	}
	public double xAngle() {
		int x = p2.getX()-p1.getX();
		int y = p2.getY()-p1.getY();
		return Math.atan2(y,x);
	}
	@Override
	public String toString() {
		return "MyLine [p1=" + p1.getX()+ ", "+ p1.getY() + ", p2=" + p2.getX()+ ", "+ p2.getY() + ", length=" + length() +"angle= "+ xAngle() +"]";
	}
	@Override
	public void draw(GraphicsContext Gc) {
		Gc.setStroke(lColor.getJavaFXColor());
		Gc.strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
	}
	@Override
	public MyRectangle getMyBoundingRectangle() {
		int xmin = Math.min(p1.getX(), p2.getX());
		int ymin = Math.min(p1.getY(), p2.getY());
		int xmax = Math.max(p1.getX(), p2.getX());
		int ymax = Math.max(p1.getY(), p2.getY());
		MyPoint p = new MyPoint(xmin,ymin,lColor);
		MyRectangle r = new MyRectangle(p, ymax-ymin, xmax-xmin, MyColor.ALICEBLUE);
		return r;
	}
	@Override
	public boolean pointInMyShape(MyPoint point) {
		if (p1.distance(point) + p2.distance(point) == p1.distance(p2))
		    return true;
		else {
		return false;}
	}

}
class MyPolygon extends MyShape{
	private int n, radius;
	private MyColor color;
	private MyPoint center;
	
	public MyPolygon(int n, int radius, MyColor color2, MyPoint center) {
		super(center, color2);
		this.n = n;
		this.radius = radius;
		color = color2;
		this.center = center;
	}
	public MyPoint getCenter(){
		return center;
	}
	public int getAngle(){
			return (int) Math.toDegrees(((n-2)*Math.PI)/n);
	}
	public double getSide(){
		return 2*apothem()*Math.tan(Math.PI/n);
	}
	public double apothem() {
		return Math.abs(radius*Math.cos(Math.PI/n));
	}
	public void draw(GraphicsContext Gc) {
		double[] x = new double[n];
		double[] y = new double[n];
		double theta=2*Math.PI/n;
		double theta2 = Math.PI/2;
		for(int i = 0;i<x.length;i++) {
			theta2+=theta;
			x[i]= (-radius*Math.cos(theta2)+center.getX());
			y[i]= (-radius*Math.sin(theta2)+center.getY());
		}
		Gc.setStroke(MyColor.BLACK.getJavaFXColor());
		Gc.setFill(color.getJavaFXColor());
		Gc.strokePolygon(x, y, n);
		Gc.fillPolygon(x, y, n);
	}
	@Override
	public int area() {return (int) ((apothem()*perimeter())/2);}
	@Override
	public int perimeter() {return (int) (getSide()*n);}
	@Override
	public String toString() {
		return "MyPolygon [center=" + center.getX() +", "+ center.getY() +", side length= "+ getSide()+ ", interior angle="+ getAngle()+ ", perimeter="+perimeter()+", area="+area()+ "]";
	}
	@Override
	public MyRectangle getMyBoundingRectangle() {
		double[] x = new double[n];
		double[] y = new double[n];
		double theta=2*Math.PI/n;
		double theta2 = Math.PI/2;
		for(int i = 0;i<x.length;i++) {
			theta2+=theta;
			x[i]= (-radius*Math.cos(theta2)+center.getX());
			y[i]= (-radius*Math.sin(theta2)+center.getY());
		}
		int xmax = (int) x[0];
		int ymax = (int) y[0];
		int xmin = (int) x[0];
		int ymin = (int) y[0];
		for(int i = 0;i<x.length;i++) {
			if(x[i]>xmax) xmax=(int) x[i];
			if(y[i]>ymax) ymax=(int) y[i];
			if(x[i]<xmin) xmin=(int) x[i];
			if(y[i]<ymin) ymin=(int) y[i];
		}
		MyPoint p = new MyPoint(xmin,ymin,color);
		MyRectangle r = new MyRectangle(p, ymax, xmax, MyColor.ALICEBLUE);
		return r;
	}
	@Override
	public boolean pointInMyShape(MyPoint point) {
		//We create lines between the given point and the vertices of the polygon
		double theta=2*Math.PI/n;
		double theta2 = Math.PI/2;
		List<MyLine> linesList = new ArrayList<MyLine>();//List for the lines
		for(int i=0; i<n; i++) {
			theta2+=theta;
			int x = (int)(-radius*Math.cos(theta2)+center.getX());
			int y = (int)(-radius*Math.sin(theta2)+center.getY());
			MyPoint p = new MyPoint(x,y,MyColor.BLACK);
			MyLine l = new MyLine(p,MyColor.BLACK,point);
			linesList.add(l);//we add the lines to the list
		}
		
		//We add the angles between the lines (In case of a pentagon AB, BC, CD, DE) 
		double totalAngle = 0;
		for(int i=0; i<linesList.size()-1;i++) {
			double dx=linesList.get(i).getP1().getX()-linesList.get(i).getP2().getX();
			double dy=linesList.get(i).getP1().getY()-linesList.get(i).getP2().getY();
			double dx2=linesList.get(i+1).getP1().getX()-linesList.get(i+1).getP2().getX();
			double dy2=linesList.get(i+1).getP1().getY()-linesList.get(i+1).getP2().getY();
			double slope1 = dy/dx;
			double slope2 = dy2/dx2;
			double angleBetween = Math.abs(Math.toDegrees(Math.atan((double)(slope2-slope1)/(1+(double)(slope1*slope2)))));
			totalAngle += (angleBetween);
		}	
		//We add the last angle between the first and last lines of the list
		double dx=(double)linesList.get(0).getP1().getX()-(double)linesList.get(0).getP2().getX();
		double dy=(double)linesList.get(0).getP1().getY()-(double)linesList.get(0).getP2().getY();
		double dx2=(double)linesList.get(n-1).getP1().getX()-(double)linesList.get(n-1).getP2().getX();
		double dy2=(double)linesList.get(n-1).getP1().getY()-(double)linesList.get(n-1).getP2().getY();
		double slope2 = dy2/dx2;
		double slope1 = dy/dx;
		double angleBetween =  Math.abs(Math.toDegrees(Math.atan((double)(slope2-slope1)/(1+(double)(slope1*slope2)))));
		totalAngle += (angleBetween);
		
		//If the angles between the lines is higher than 180 degrees then the point is in the polygon
		if (Math.round(totalAngle) >180 ) {
			return true;
		}
		else {
	    	return false;
	    }
	}
}
class MyRectangle extends MyShape{
	private MyPoint p1;
	private int height, width;
	private MyColor color;
	public MyPoint getP() {
		return p1;
	}
	public void setP(MyPoint p) {
		p1 = p;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public MyColor getColor() {
		return color;
	}
	public void setColor(MyColor color) {
		this.color = color;
	}
	public MyRectangle( MyPoint p, int height, int width, MyColor color2) {
		super(p, color2);
		p1 = p;
		this.height = height;
		this.width = width;
		color = color2;
	}
	@Override
	public int area() {return width*height;}
	@Override
	public int perimeter() {return 2 * width * height;}
	@Override
	public String toString() {
		return "MyRectangle [P=" + p1.getX()+ ", "+ p1.getY() + ", height=" + height + ", width=" + width + ", perimeter=" + perimeter()+ ", area=" + area() + "]";
	}
	@Override
	public void draw(GraphicsContext Gc) {
		Gc.setStroke(MyColor.BLACK.getJavaFXColor());
		Gc.strokeRect(p1.getX(), p1.getY(), width, height);
		Gc.setFill(color.getJavaFXColor());
		Gc.fillRect(p1.getX(), p1.getY(), width, height);
	}
	@Override
	public MyRectangle getMyBoundingRectangle() {
		MyPoint p = new MyPoint(p1.getX(),p1.getY(),color);
		MyRectangle r = new MyRectangle(p, height, width, MyColor.ALICEBLUE);
		return r;
	}
	@Override
	public boolean pointInMyShape(MyPoint point) {
		if (point.getX() > p1.getX() && point.getX() < p1.getX()+width && point.getY() > p1.getY() && point.getY() < p1.getY()+height)
			    return true;
			 
			return false;
	}

	
} 
class MyCircle extends MyShape{
	private MyPoint center;
	private int radius;
	private MyColor color;
	public MyPoint getCenter() {
		return center;
	}
	public void setCenter(MyPoint center) {
		this.center = center;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public MyColor getColor() {
		return color;
	}
	public void setColor(MyColor color) {
		this.color = color;
	}
	@Override
	public int area() {return (int) (Math.PI*(radius*radius));}
	@Override
	public int perimeter() {return (int) (2 * Math.PI * radius);}
	public MyCircle( MyPoint center1, int radius, MyColor color2) {
		super(center1, color2);
		this.center = center1;
		this.radius = radius;
		color = color2;
	}
	@Override
	public String toString() {
		return "MyCircle [center=" + center + ", radius=" + radius +", perimeter=" + perimeter() +", area=" + area() + "]";
	}
	@Override
	public void draw(GraphicsContext Gc) {
		Gc.setStroke(MyColor.BLACK.getJavaFXColor());
		Gc.strokeOval(center.getX()-radius,center.getY()-radius,radius*2,radius*2);
		Gc.setFill(color.getJavaFXColor());
		Gc.fillOval(center.getX()-radius,center.getY()-radius,radius*2,radius*2);
	}
	@Override
	public MyRectangle getMyBoundingRectangle() {
		MyPoint p = new MyPoint(center.getX()-radius,center.getY()-radius,color);
		MyRectangle r = new MyRectangle(p, radius*2, radius*2, MyColor.ALICEBLUE);
		return r;
	}
	@Override
	public boolean pointInMyShape(MyPoint point) {
		if (point.distance(center) <= radius)
			return true;
		else {
	    	return false;}
	}

	
} 
class MyArc extends MyShape{
	private MyPoint center;
	private MyPoint p1, p2;
	private double startAngle,angle,endAngle;
	private MyColor color;
	MyArc (MyPoint p, double startAngle, double angle, MyColor color){
		super(new MyPoint(), null);
		this.center = p;
		this.startAngle= startAngle;
		this.angle = angle;
		this.color = color;
		endAngle=angle+startAngle;
	}
	MyArc (MyPoint p1, MyPoint p2, MyPoint p, MyColor color){
		super(new MyPoint(), null);
		this.center = p;
		this.color = color;
		this.p1 = p1;
		this.p2 = p2;
		this.p1 = p1;
		this.p2 = p2;
		double radius = p1.distance(center);
		double chordLength = p1.distance(p2);
		angle = Math.toDegrees(2*Math.asin(chordLength/(2*radius)));
		startAngle = center.angleX(p1);
		endAngle=angle+startAngle;
	}
	public MyPoint getCenter() {
		return center;
	}
	public void setCenter(MyPoint center) {
		this.center = center;
	}
	public MyPoint getP1() {
		return p1;
	}
	public void setP1(MyPoint p1) {
		this.p1 = p1;
	}
	public MyPoint getP2() {
		return p2;
	}
	public void setP2(MyPoint p2) {
		this.p2 = p2;
	}
	public double getStartAngle() {
		return startAngle;
	}
	public void setStartAngle(double startAngle) {
		this.startAngle = startAngle;
	}
	public double getAngle() {
		return angle;
	}
	public void setAngle(double angle) {
		this.angle = angle;
	}
	public MyColor getColor() {
		return color;
	}
	public void setColor(MyColor color) {
		this.color = color;
	}
	@Override
	public int area() {
		double chordLength = p1.distance(p2);
		double radius = p1.distance(center);
		double arcLength = Math.toDegrees(2*radius*Math.asin(chordLength/(2*radius)));
		return (int) ((arcLength/360)*Math.PI*radius*radius);
		
	}
	@Override
	public int perimeter() {
		double chordLength = p1.distance(p2);
		double radius = p1.distance(center);
		double arcLength = Math.toDegrees(2*radius*Math.asin(chordLength/(2*radius)));
		return (int) (2*radius + arcLength);
	}
	@Override
	public String toString() {
		return "MyArc [center=(" + center.getX() + "," + center.getY() + ")" +  ", angle=" + angle + ", area()=" + area()
				+ ", perimeter()=" + perimeter() + "]";
	}
	@Override
	public void draw(GraphicsContext Gc) {
		double radius = p1.distance(center);
		Gc.setStroke(color.getJavaFXColor());
		Gc.strokeArc((double)center.getX(), (double)center.getY(), radius, radius, startAngle, angle,ArcType.ROUND);
	}
	@Override
	public boolean pointInMyShape(MyPoint point) {
		double InitialstartAngle = center.angleX(point);
		double radius = point.distance(center);
		MyPoint initialPoint = new MyPoint(center.getX()+(int)radius,center.getY(),MyColor.BLACK);
		double chordLength = point.distance(initialPoint);
		double pointAngle = Math.toDegrees(2*Math.asin(chordLength/(2*radius)));
		if(point.distance(center)==p1.distance(center) && (InitialstartAngle+pointAngle)<(startAngle+angle)&& (InitialstartAngle+pointAngle)>(startAngle)) {
			return true;
		}
		else{
			return false;
		}
	}
	@Override
	public MyRectangle getMyBoundingRectangle() {
		double radius = p1.distance(center);
		MyPoint left= new MyPoint(center.getX()-(int)radius,center.getY(),MyColor.BLACK);
		MyPoint right= new MyPoint(center.getX()+(int)radius,center.getY(),MyColor.BLACK);
		MyPoint up= new MyPoint(center.getX(),center.getY()-(int)radius,MyColor.BLACK);
		MyPoint down= new MyPoint(center.getX(),center.getY()+(int)radius,MyColor.BLACK);
		int leftMax,rightMax,upMax,downMax;
		if(pointInMyShape(left)==true) {
			leftMax = center.getX()-(int)radius;
			int minY = Math.min(p1.getY(),p2.getY());
			MyPoint cornerP = new MyPoint(leftMax,minY,MyColor.BLACK);
			int maxY = Math.max(p1.getY(),p2.getY());
			MyRectangle r = new MyRectangle(cornerP,center.getX()-cornerP.getX(),maxY-cornerP.getY(),MyColor.ALICEBLUE);
			return r;
		}
		if(pointInMyShape(right)==true) {
			rightMax =  center.getX()+(int)radius;
			int minY = Math.min(p1.getY(),p2.getY());
			MyPoint cornerP = new MyPoint(center.getX(),minY,MyColor.BLACK);
			int maxY = Math.max(p1.getY(),p2.getY());
			MyRectangle r = new MyRectangle(cornerP,center.getX()-cornerP.getX(),maxY-cornerP.getY(),MyColor.ALICEBLUE);
			return r;
			
		}
		if(pointInMyShape(up)==true) {
			upMax = center.getY()-(int)radius;
			int minX = Math.min(p1.getX(),p2.getX());
			MyPoint cornerP = new MyPoint(minX,upMax,MyColor.BLACK);
			int maxX = Math.max(p1.getX(),p2.getX());
			MyRectangle r = new MyRectangle(cornerP,center.getY()-cornerP.getY(),maxX-cornerP.getX(),MyColor.ALICEBLUE);
			return r;
			
		}
		if(pointInMyShape(down)==true) {
			downMax = center.getY()+(int)radius;
			int minX = Math.min(p1.getX(),p2.getX());
			MyPoint cornerP = new MyPoint(minX,center.getX(),MyColor.BLACK);
			int maxX = Math.max(p1.getX(),p2.getX());
			MyRectangle r = new MyRectangle(cornerP,center.getY()-cornerP.getY(),maxX-cornerP.getX(),MyColor.ALICEBLUE);
			return r;
		}
		int maxX = Math.max(Math.max(p1.getX(),p2.getX()),center.getX());
		int minX = Math.min(Math.min(p1.getX(),p2.getX()),center.getX());
		int maxY = Math.max(Math.max(p1.getY(),p2.getY()),center.getY());
		int minY = Math.min(Math.min(p1.getY(),p2.getY()),center.getY());
		
		MyPoint cornerP = new MyPoint(minX,minY,MyColor.BLACK);
		MyRectangle r = new MyRectangle(cornerP,maxX-minX,maxY-minY,MyColor.BLACK);
		return r;
	}
}
class Slice{
	private MyPoint center;
	private int radius;
	private double startAngle,angle,endAngle;
	private MyColor color;
	Slice (MyPoint p, int radius, double startAngle, double angle, MyColor color){
		this.center = p;
		this.color = color;
		this.radius=radius;
		this.startAngle=startAngle;
		this.angle = angle;
	}
	public void draw(GraphicsContext Gc) {
		Gc.setFill(color.getJavaFXColor());
		Gc.fillArc((double)center.getX()-radius, (double)center.getY()-radius, 2*radius, 2*radius, startAngle+90.0, angle,ArcType.ROUND);
	}

	public int area() {
		return (int) (0.5*angle*Math.pow(radius, 2));
		
	}
	public int perimeter() {
		return (int) (radius*angle);
	}
	@Override
	public String toString() {
		return "Slice [center= (" + center.getX() + "," + center.getY() + ")" + ", Start angle=" + startAngle + ", angle=" + angle + ", area()=" + area()
				+ ", perimeter()=" + perimeter() + "]";
	}
	public void setCenter(MyPoint center) {
		this.center = center;
	}
	public double getStartAngle() {
		return startAngle;
	}
	public void setStartAngle(double startAngle) {
		this.startAngle = startAngle;
	}
	public MyPoint getCenter() {
		return center;
	}
	public int getRadius() {
		return radius;
	}
	public double getAngle() {
		return angle;
	}
	public void setAngle(double angle) {
		this.angle = angle;
	}
}

class HistogramAlphaBet{
	private Map<Character, Integer> frequency = new HashMap<Character, Integer>();
	private Map<Character, Double> probability = new HashMap<Character, Double>();
	HistogramAlphaBet (String text){
		String w = text.replaceAll("Io--21","").toLowerCase();
		for(int i= 0; i<w.length(); i++) {
			Character key= w.charAt(i);
			incrementFrequency(frequency, key);
		}
	}
	HistogramAlphaBet (Map<Character,Integer> m){
		frequency.putAll(m);
	}
	public Integer totalFrequency() {
		return frequency.values().stream().reduce(0, Integer::sum);
	}
	public Map<Character, Double> getprobability(){
		double inverse = 1.0 / totalFrequency();
		for (Character key : frequency.keySet()){
			probability.put(key, (double) frequency.get(key)* inverse);
		}
		return probability.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1,e2)->e2,LinkedHashMap::new));
	}
	private void incrementFrequency(Map<Character, Integer> frequency2, Character key) {
		frequency2.putIfAbsent(key, 0);
		frequency2.put(key, frequency2.get(key)+1);
	}
	class MyPieChart{
		private Map<Character, Slice> slices = new HashMap<Character, Slice>();
		private int n;
		private MyPoint center1;
		private int radius;
		private double angle;
		MyPieChart(int n, MyPoint p, int r, double angle){
			this.n = n;
			this.center1 = p;
			this.radius = r;
			this.angle = angle;
			probability = getprobability();
			slices = getMyPieChart();
		}
		public Map<Character,Slice> getMyPieChart(){
			MyColor arrColors[] = MyColor.values();
			double newAngle = angle, sliceAngle, totalPercentage=0.0;
			int i =0, k=0;
			for(Character Key: probability.keySet()) {
				totalPercentage += 360.0*probability.get(Key);
				k++;
				if(k>(n-1)) {
					break;
				}
			}
			for(Character Key: probability.keySet()) {
				sliceAngle = 360.0*probability.get(Key);
				slices.put(Key, new Slice(center1,radius, (360.0-totalPercentage)+newAngle,sliceAngle,arrColors[++i]));
				newAngle += sliceAngle;
			}
			return slices;
		}
		public void draw(GraphicsContext Gc) {
			int k = 0;
			double totalPercentage = 0, totalNumber = 0;
			boolean allDrawn=true;
			for(Character Key: probability.keySet()) {
				totalNumber += frequency.get(Key);
				totalPercentage -= probability.get(Key);
				slices.get(Key).draw(Gc);
				Gc.setFill(MyColor.BLACK.getJavaFXColor());
				double p =slices.get(Key).getStartAngle()+(slices.get(Key).getAngle()/2)+90;
				double pointX = center1.getX() + (radius* 1.2 * Math.cos(Math.toRadians(p)));
				double pointY = center1.getY() - (radius* 1.2 * Math.sin(Math.toRadians(p)));
				Gc.fillText(Key+", "+frequency.get(Key), pointX, pointY);
				k++;
				if(k>(n-1)) {
					allDrawn = false;
					break;
				}
			}
			if(allDrawn==false){
				double p =(((1.0+totalPercentage)*360)/2)+90;
				double pointX = center1.getX() + (radius*1.8 * Math.cos(Math.toRadians(p)));
				double pointY = center1.getY() - (radius*1.1 * Math.sin(Math.toRadians(p)));
				Gc.fillText("Other grades, " + (int)totalNumber , pointX, pointY);
				Slice s = new Slice(center1,radius,0,(1.0+totalPercentage)*360,MyColor.LIGHTGOLDENRODYELLOW);
				s.draw(Gc);
			}
		}
	}
}
interface ClassSchedule{
	public String insertTableSQL = "";
	public String queryTableSQL = "";
	public String createTableSQL = "";
	
	public void insertSql(String ITSQL) throws SQLException;
	public ResultSet querySql(String QTSQL) throws SQLException;
	public void createSql(String CTSQL) throws SQLException;
}
class Database implements ClassSchedule{
	private Connection conn;
	
	Database(){
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "password"); 
		} 
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	class Schedule{
		String sqlTable;
		Schedule(String sqlTable, Scanner input) throws SQLException{
			String sql = "DROP TABLE IF EXISTS schedule"; 
			this.sqlTable = sqlTable;
			PreparedStatement preparedSchedule= conn.prepareStatement(sql);
			preparedSchedule.executeUpdate();
			createSql(sqlTable);
		    input.nextLine();
		    while(input.hasNext()) {
		        String[] words = input.nextLine().split("	", -1);
		        String Course = words[0];
		        String SectionNum = words[1];
		        String Title = words[2];
		        String Year = words[3];
		        String Semester = words[4];
		        String Instructor = words[5];
		        String Department = words[6];
		        String Program = words[7];
		        sql = "INSERT INTO Schedule " + 
		       		  "Value('" + Course +
		       		  "', " + SectionNum + 
		       		  ", '" + Title +
		       		  "', " + Year +
		       		  ", '" + Semester + 
		       		  "', '"+ Instructor + 
		       		  "', '"+ Department + 
		       		  "', '"+ Program + "')";
		        insertSql(sql);
		    }
		}
	}
	class Students{
		String sqlTable;
		Students(String sqlTable,String sqlInsert) throws SQLException{
			String sql = "DROP TABLE IF EXISTS Students"; 
			
			this.sqlTable= sqlTable;
			PreparedStatement preparedStudents= conn.prepareStatement(sql);
			preparedStudents.executeUpdate();
			createSql(sqlTable);
			insertSql(sqlInsert);
		}
	}
	class Courses{
		String sqlTable;
		Courses(String sqlTable, String sqlInsert) throws SQLException{
			String sql = "DROP TABLE IF EXISTS Courses"; 

			this.sqlTable= sqlTable;
			PreparedStatement preparedCourses= conn.prepareStatement(sql);
			preparedCourses.executeUpdate();
			createSql(sqlTable);
			insertSql(sqlInsert);
		}
	}
	class Classes{
		String sqlTable;
		Classes(String sqlTable, String sqlInsert) throws SQLException{
			String sql = "DROP TABLE IF EXISTS Classes"; 
			this.sqlTable= sqlTable;
			PreparedStatement preparedClasses= conn.prepareStatement(sql);
			preparedClasses.executeUpdate();
			createSql(sqlTable);
			insertSql(sqlInsert);
			
		}
	}
	class AggregateGrades{
		String sqlTable;
		AggregateGrades(String sqlTable, String sqlInsert) throws SQLException{
			String sql = "DROP TABLE IF EXISTS AggregateGrades"; 
			
			this.sqlTable= sqlTable;
			PreparedStatement preparedGrades= conn.prepareStatement(sql);
			preparedGrades.executeUpdate();
			createSql(sqlTable);
			insertSql(sqlInsert);
		}
		public Map<Character,Integer> getAggregateGrades(String sql) throws SQLException{
			Map<Character,Integer> myGrades = new HashMap<Character,Integer>();
			ResultSet rs = querySql(sql);
			while(rs.next()) {
				myGrades.put(rs.getString("grade").charAt(0), rs.getInt("numberStudents"));
			}
			return myGrades;
		}
	}
	@Override
	public void insertSql(String ITSQL) throws SQLException{
		PreparedStatement prepared= conn.prepareStatement(ITSQL);
		prepared.executeUpdate();
		
	}
	@Override
	public ResultSet querySql(String QTSQL) throws SQLException{
		PreparedStatement prepared= conn.prepareStatement(QTSQL);
		ResultSet r = prepared.executeQuery();
		return r;
	}
	@Override
	public void createSql(String CTSQL) throws SQLException {
		PreparedStatement prepared= conn.prepareStatement(CTSQL);
		prepared.executeUpdate();
	}
}
public class Main extends Application{
	Scanner input;
	public void openFile() {
		try {
			input = new Scanner(Paths.get("E:\\Downloads\\ScheduleSpring2021.txt"));
		}
		catch(IOException e) {
			System.out.println("File not found");
		}
	}
	public void readFile(GraphicsContext gc) throws SQLException {
		String sql,sqlInsert;
		Database d = new Database();
		sql = "CREATE TABLE Schedule " +
	        	  "(Course VARCHAR(255), " +
	              " Section INTEGER not NULL, " +
	              " Title VARCHAR(255), " + 
	              " Year INTEGER not NULL, " + 
	              " Semester VARCHAR(255), " + 
	              " Instructor VARCHAR(255), " + 
	              " Department VARCHAR(255), " + 
	              " Program VARCHAR(255), " + 
	              " PRIMARY KEY ( Course, Section))"; 
		
		Database.Schedule s =  d.new Schedule(sql,input);
		sql = "CREATE TABLE Students " +
	        	  "(empID INTEGER not NULL, " +
	              " firstName VARCHAR(255), " +
	              " lastName VARCHAR(255), " + 
	              " Email VARCHAR(255), " + 
	              " Gender ENUM('M','F','U'), " + 
	              " PRIMARY KEY ( empID ))"; 
		sqlInsert="INSERT INTO Students "+
				"Values (345678, 'Craig', 'Lapel', 'clapel@citymail.cuny.edu','U'),"
				+ " (234567, 'Mike', 'Pratt', 'mpratt@citymail.cuny.edu','M'),"
				+ " (123456, 'Alex', 'Brall', 'abrall@citymail.cuny.edu','M'),"
				+ " (456789, 'Lexa', 'Smith', 'lsmith@citymail.cuny.edu','F'),"
				+ " (567891, 'Philip', 'Vitale', 'pvitale@citymail.cuny.edu','M'),"
				+ " (678912, 'Amanda', 'Becker', 'jbecker@citymail.cuny.edu','F'),"
				+ " (789123, 'Myson', 'Riliey', 'mriliey@citymail.cuny.edu','U')";
		Database.Students St =  d.new Students(sql,sqlInsert);
		sql = "CREATE TABLE Courses " +
		          "(courseID VARCHAR(255), " +
		          " courseTitle VARCHAR(255), " +
		          " department VARCHAR(255), " + 
		          " PRIMARY KEY ( courseID ))"; 
		sqlInsert="INSERT INTO Courses "
				+ "SELECT Course, Title, Department "
				+ "FROM Schedule";
		Database.Courses C =  d.new Courses(sql,sqlInsert);
		sql = "CREATE TABLE Classes " +
	        	  "(courseID VARCHAR(255), " +
	              " studentID INTEGER not NULL, " +
	              " sectionNo INTEGER not NULL, " + 
	              " Year INTEGER not NULL, " + 
	              " Semester VARCHAR(255), " + 
	              " Grade ENUM('A','B','C','D','F','W'), " + 
	              " PRIMARY KEY ( studentID ))"; 
		sqlInsert="INSERT INTO Classes "+
				"Values ('10000 PP', 345678, 34143, 2021,'Spring','A'),"
				+ " ('21200 BC', 234567,32129 , 2021,'Spring','C'),"
				+ " ('22000 D', 123456,32148 ,2021,'Spring','A'),"
				+ " ('47200 P', 456789,32163 , 2021,'Spring','C'),"
				+ " ('51003 Q', 567891,32174 ,2021,'Spring','C'),"
				+ " ('59866 D', 678912,32189 , 2021,'Spring','F'),"
				+ " ('59867 05', 789123,33412 ,2021,'Spring','A')";
		Database.Classes Cl =  d.new Classes(sql,sqlInsert);
		sql = "CREATE TABLE AggregateGrades " +
	        	  "(Grade Char, " +
	              " numberStudents INT, " +
	              " PRIMARY KEY ( Grade ))"; 
		sqlInsert = "INSERT into AggregateGrades "
				+ "SELECT Grade, COUNT(Grade) "
				+ "FROM Classes "
				+ "GROUP BY Grade";
		Database.AggregateGrades Ag = d.new AggregateGrades(sql,sqlInsert);	
		
		double h = gc.getCanvas().getHeight();
		double w = gc.getCanvas().getWidth();
		int z = (int) Math.min(h, w);
		int radius = z/2;
		MyPoint center = new MyPoint(radius,radius,MyColor.BLACK);
		
		sql = "SELECT * from AggregateGrades";
		HistogramAlphaBet H1 = new HistogramAlphaBet(Ag.getAggregateGrades(sql));
		HistogramAlphaBet.MyPieChart P = H1.new MyPieChart(5,center,radius-100,0);
		P.draw(gc);
		
	}
	public void closeFile() {
		if(input!=null) {
			input.close();
		}
	}
	@Override
	public void start(Stage PS){
		PS.setTitle("Stage Result");
		
		
	    Group root = new Group();
		Scene SC = new Scene(root);
		int h = 500;
		int w = 1000;
		
		Canvas cv = new Canvas(w,h);
		GraphicsContext Gc = cv.getGraphicsContext2D();
		openFile();
		try {
			readFile(Gc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeFile();
		root.getChildren().add(cv);
		PS.setScene(SC);
		PS.show();
		
	}
	public static void main(String [] args) {
		launch(args);
	}
	
}
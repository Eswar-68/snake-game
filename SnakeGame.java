import java.util.*;
public class SnakeGame{
	private static final int height=10;
	private static final int width=20;
	private static final char SNAKE='#';
	private static final char FOOD='*';
	private static final char EMPTY='-';
	private static final int init_size=3;
	private List<int[]> snake;
	private int[] food;
	private boolean running;
	private boolean opposite;
	private int direction=1;
	public SnakeGame(){
		snake=new ArrayList<>();
		direction=3;
		running=true;
		opposite=false;
		initGame();
	}
	public void initGame(){
		for(int i=0;i<init_size;i++){
			snake.add(new int[]{height/2,width/2-i});
		}
		placeFood();
	}
	public void placeFood(){
		Random rand=new Random();
		do{
			food=new int[]{rand.nextInt(height),rand.nextInt(width)};
		}while(foodIsOnSnake());
	}
	public boolean foodIsOnSnake(){
		for(int[] s:snake){
			if(s[0]==food[0] && s[1]==food[1]){
				return true;
			}
		}
		return false;
	}
	public void printBoard(){
		for(int r=0;r<height;r++){
			for(int c=0;c<width;c++){
				if(r==food[0] && c==food[1]){
					System.out.print(FOOD);
				}
				else if(isSnakeSegment(r,c)){
					System.out.print(SNAKE);
				}
				else{
					System.out.print(EMPTY);
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	public boolean isSnakeSegment(int r, int c){
		for(int[] s:snake){
			if(s[0]==r && s[1]==c){
				return true;
			}
		}
		return false;
	}
	public void processInput(char input){
		switch(input){
			case 'w':
				if(direction!=1){
					direction=0;
				}
				else{
					opposite=true;
					return;
				}
					break;
			case 's':
				if(direction!=0){
					direction=1;
				}
				else{
					opposite=true;
					return;
				}
					break;
			case 'a':
				if(direction!=3){
					direction=2;
				}
				else{
					opposite=true;
					return;
				}
					break;
			case 'd':
				if(direction!=2){
					direction=3;
				}
				else{
					opposite=true;
					return;
				}
					break;
		}
	}
	public void updateGame(){
		if(opposite){
			opposite=false;
			return;
		}
		int[] head=snake.get(0);
		int newHeadRow=head[0];
		int newHeadCol=head[1];
		switch(direction){
			case 0:
				newHeadRow--;
				break;
			case 1:
				newHeadRow++;
				break;
			case 2:
				newHeadCol--;
				break;
			case 3:
				newHeadCol++;
				break;
		}
		if(newHeadRow<0 || newHeadRow>=height || newHeadCol<0 || newHeadCol>=width || isSnakeSegment(newHeadRow,newHeadCol)){
			running=false;
			return;
		}
		if(newHeadRow==food[0] && newHeadCol==food[1]){
			snake.add(0,new int[]{newHeadRow,newHeadCol});
			placeFood();
		}
		else{
			for(int i=snake.size()-1;i>0;i--){
				snake.set(i,snake.get(i-1));
			}
			snake.set(0,new int[]{newHeadRow,newHeadCol});
		}
		
	}
	public void start(){
		Scanner sc=new Scanner(System.in);
		printBoard();
		while(running){
			if(sc.hasNextLine()){
				char c=sc.next().charAt(0);
				if(c!='w' && c!='s' && c!='a' && c!='d'){
					continue;
				}
				processInput(c);
				updateGame();
				printBoard();
			}
		}
		System.out.println("oops! game over!! \nYour score = "+(snake.size()-init_size));
	}
	public static void main(String[] args){
		SnakeGame obj=new SnakeGame();
		obj.start();
	}
}
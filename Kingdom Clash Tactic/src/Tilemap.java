import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;

public class Tilemap {
	private String name;
	private int tile_size;
	private int x;
	private int y;
	private int [][] map;
	private int map_width;
	private int map_height;
	
	public Tilemap(String fileName, int tileSize) {
		this.tile_size = tileSize;
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			
			//get mapWidth and mapHeight
			map_width = Integer.parseInt(br.readLine());
			map_height = Integer.parseInt(br.readLine());
			
			//make map with mapHeight & mapWidth
			map = new int [map_height][map_width];
			
			//Separate every integer by " "
			String separate = " ";
			for(int baris = 0; baris < map_height; baris++) {
				//read every line
				String line = br.readLine();
				String[] tokens = line.split(separate);
				for(int kolom = 0; kolom < map_width; kolom++) {
					//convert + input every integer
					map[baris][kolom] = Integer.parseInt(tokens[kolom]);
				}
				br.close();
			}
		}catch(Exception e) {
			System.out.println("File not found!");
		}
	}
	
	public Tilemap() {
		// TODO Auto-generated constructor stub
	}
	
	public void draw(Graphics g) {
		System.out.println("Map width = " + map_width);
		System.out.println("Map height = " + map_height);
		for(int i = 0;i < map_height;i++) {
			for(int j = 0;j < map_width;j++) {
				int curr = map[i][j];
				if(i == 0 || i == map_height - 1 || j == 0 || j == map_width - 1 ) {
					curr = 1;
				}
				System.out.print(curr + " ");
				if(curr == 1) {
					g.setColor(Color.BLACK);
					g.fillRect(x + i*tile_size, y + j*tile_size, tile_size	, tile_size);
				}else if(curr == 0) {
					g.setColor(Color.GREEN);
					g.drawRect(x + i*tile_size, y + j*tile_size, tile_size, tile_size);
				}
				System.out.println();
			}
		}
	}
}

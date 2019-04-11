import java.io.BufferedReader;
import java.io.FileReader;

public class Tilemap {

	private int[][] mapCode;
	
	public Tilemap() {
		// TODO Auto-generated constructor stub
	}
	
	public Tilemap(String fileName , int size) {
		
		mapCode =  new int[size][size];
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			
//			int mapWidth = Integer.parseInt(br.readLine());
			
			String separator = " ";
			
			for(int i = 0;i < size;i++) {
				String line = br.readLine();
				if(line != null) {
					String[] token = line.split(separator);
					for(int j = 0;j < size;j++) {
						mapCode[j][i] = Integer.parseInt(token[j]);
					}
				}
			}
			br.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Tilemap(String fileName) {
		
		mapCode = new int[30][30];
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			
			String separator = " ";
			
			for(int i = 0;i < 30;i++) {
				
				String line = br.readLine();
				if(line != null) {
					String[] token = line.split(separator);
					for(int j = 0;j < 30;j++) {
						mapCode[j][i] = Integer.parseInt(token[j]);
					}
				}
			}
			br.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public int[][] getMapCode() {
		return mapCode;
	}

	public void setMapCode(int[][] mapCode) {
		this.mapCode = mapCode;
	}
}

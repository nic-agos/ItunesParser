package main.java;

import java.io.File;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;

public class Main {

	private static final Logger log = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) throws Exception {
		File file = new File("src/main/resources/Libreria.xml");
		Parser parser = new Parser(file);
		parser.parse();

		String playlistName = "Disco 9";
		Map<Integer, Playlist> playlists = parser.getPlaylists();

		Utils utils = new Utils();

		int id = utils.findPlaylist(playlists, playlistName);
		System.out.println("ID: " + id);



		if (id != 0){

			// the get method expects as parameter the playlist ID defined in the .xml file
			Playlist playlist1 = playlists.get(id);

			Map<Integer, Track> tracksOfPlaylist1 = playlist1.getPlaylistItems();
			Map<Integer, Track> treeMap = new TreeMap<>(tracksOfPlaylist1);
			String path = "C:/Users/nicco/Desktop/";

			WriteDataToExcel writeClass = new WriteDataToExcel();
			writeClass.writer(treeMap, path);


		}else{
			log.warning("Playlist with name: "+ playlistName + " not found");
			return;
		}

	}
}
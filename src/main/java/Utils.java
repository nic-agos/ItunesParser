package main.java;

import java.util.Map;

public class Utils {

    public int findPlaylist(Map<Integer, Playlist> map, String name){

        int[] id = new int[1];
        id[0] = 0;
        map.values().forEach(v -> {
            if (v.getName().compareTo(name) == 0){
                id[0] = v.getPlaylistID();
            }
        });

        return id[0];
    }
}

package lt.playList;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

	private ArrayList<Song> songs;
	private String name;
	private String artist;

	public Album(String name, String artist) {
		super();
		this.name = name;
		this.artist = artist;
		this.songs = new ArrayList<>();
	}

	public boolean addSong(String name, double duration) {

		if (findSong(name) == null) {
			this.songs.add(new Song(name, duration));
			return true;
		}
		return false;

	}

	public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
		int index = trackNumber - 1;
		if ((index >= 0) && (index <= this.songs.size())) {
			playList.add(this.songs.get(index));
			return true;
		}

		System.out.println("This album does not have a track " + trackNumber);
		return false;

	}

	public boolean addToPlayList(String name, LinkedList<Song> playList) {
		Song checkedSong = findSong(name);

		if (checkedSong != null) {
			playList.add(checkedSong);
			return true;
		}
		System.out.println("The song " + name + " is not in this album");
		return false;
	}

	private Song findSong(String name) {
		for (Song checkedSong : this.songs) {
			if (checkedSong.getName().equals(name)) {
				return checkedSong;
			}
		}
		return null;
	}

}

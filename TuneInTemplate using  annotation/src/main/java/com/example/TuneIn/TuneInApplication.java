package com.example.TuneIn;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.reactive.HttpHandlerAutoConfiguration.AnnotationConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class TuneInApplication {

	public static void main(String[] args) {

		/*
		 * 1. Fetch context from ApplicationContext.xml and initiate Scanner.
		 * 2. Fetch User details from Console.
		 * 3. Get the required bean from context.
		 * 4. Get the songs from Console and add them to the playlist
		 * 5. Display the playlist reference Id
		 * 6. Display the list of songs with their reference Id
		 */

		Scanner in = new Scanner(System.in);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.example.TuneIn");

		System.out.println("Welcome to Music Playlist Application");
		System.out.println("What is your name?");
		String name = in.nextLine();
		System.out.println("What is your age?");
		Integer age = in.nextInt();
		MyUser user = (MyUser) context.getBean("myUser");
		user.setUserDetail(name, age);
		MyPlaylist playlist = (MyPlaylist) context.getBean("myPlaylist");

		while (true) {
			System.out.println("Do you want to add Songs to the playlist\n" + //
					"1. Yes\n" + //
					"2. No");
			int ans = in.nextInt();
			switch (ans) {
				case 1:
					MySong song = (MySong) context.getBean("mySong");
					System.out.println("Enter name of the song");
					in.nextLine();
					String songName = in.nextLine();
					song.setName(songName);
					playlist.addSong(song);
					break;
				case 2:
					System.out.println("Your Playlist with reference Id: @" +playlist.hashCode()+" is Ready!!");
					for (Song x : playlist.getPlaylistSongs()) {
						System.out.println("Song name:"+x.getSongName()+" Reference Id: @" +x.hashCode());
					}
					break;
				default:
					break;
			}

		}

	}

}

import java.io.File;
import java.net.URL;
import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Interface extends Application{
	
	static boolean play = true;
	Random rand = new Random();
	int value = rand.nextInt(10)+1;
	String musicFile = "mp3s/"+Integer.toString(value)+".mp3";
	URL musicfile = Interface.class.getResource(musicFile);
	Media sound = new Media(musicfile.toString());
	MediaPlayer mediaPlayer = new MediaPlayer(sound);

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub	
		

		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		mediaPlayer.play();
		
		Button btnPlayer = new Button("暂停");
		btnPlayer.setOnAction(event->{
			if(play) {
				btnPlayer.setText("播放");
				play = false;
				mediaPlayer.pause();
			}else {
				btnPlayer.setText("暂停");
				play = true;
				mediaPlayer.play();
			}
		});
		btnPlayer.setPrefSize(160, 50);
		Button btnNext = new Button("下一首");
		btnNext.setOnAction(event->{
			mediaPlayer.stop();
			value = rand.nextInt(10)+1;
			musicFile = "mp3s/"+Integer.toString(value)+".mp3";
			musicfile = Interface.class.getResource(musicFile);
			sound = new Media(musicfile.toString());
			mediaPlayer = new MediaPlayer(sound);
			mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
			mediaPlayer.play();
			btnPlayer.setText("暂停");
			play = true;
		});
		btnNext.setPrefSize(160, 50);
		BorderPane pane = new BorderPane();
		pane.setLeft(btnPlayer);
		pane.setRight(btnNext);

		Scene scene = new Scene(pane,320,50);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Rain Player");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
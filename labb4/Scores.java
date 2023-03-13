import java.io.FileWriter;
import java.io.File;
import java.util.Scanner;
import javax.swing.DefaultListModel;

public class Scores extends DefaultListModel<String> {
    DefaultListModel<String> original = new DefaultListModel<String>();
    String path;
    int highscore;
    int lowscore;

    public void readFile(String path){
        this.path = path;
        try {
            Scanner reader = new Scanner(new File(path));
            
            while (reader.hasNextLine()){
                addElement(reader.nextLine());
            }

            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        for (int i = 0; i < size(); i++){
            original.addElement(getElementAt(i));
        }

        System.out.println(this);
    }

    public void writeFile(){
        try {
            FileWriter writer = new FileWriter(this.path);
            for (int i = 0; i < this.size(); i++){
                writer.write(this.getElementAt(i).toString());
                writer.write("\n");
            }
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public DefaultListModel<String> formattedLatestScores(){
        DefaultListModel<String> formatted = new DefaultListModel<String>();
        for (int i = 0; i < this.size(); i++){
            formatted.addElement(i+1 + ": " + get(i).toString());
        }
        return formatted;
    }

    public void genHighScore(){
        for (int i = 0; i < this.size(); i++){
            String[] split = get(i).toString().split(" ");
            if (Integer.parseInt(split[1]) > highscore){
                highscore = Integer.parseInt(split[1]);
            }
            if (Integer.parseInt(split[1]) < lowscore){
                lowscore = Integer.parseInt(split[1]);
            }
        }

        sortHighscore();
    }

    public void sortHighscore(){
        for (int i = 0; i < this.size(); i++){
            for (int j = 0; j < this.size(); j++){
                String[] split = get(i).toString().split(" ");
                String[] split2 = get(j).toString().split(" ");
                if (Integer.parseInt(split[1]) > Integer.parseInt(split2[1])){
                    String temp = get(i).toString();
                    set(i, get(j).toString());
                    set(j, temp);
                }
            }
        }

        if (this.size() > 10){
            remove(10);
        }
    }
}

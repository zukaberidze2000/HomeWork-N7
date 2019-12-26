
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main
{
    static void modifyFile(String filePath, String oldString, String newString)
    {
        File file = new File(filePath);
        String oldContent = "";
        BufferedReader reader = null;
        FileWriter writer = null;

        try
        {
            reader = new BufferedReader(new FileReader(file));
            //Reading all the lines of input text file into oldContent
            String line = reader.readLine();

            while (line != null) {
                oldContent = oldContent + line + System.lineSeparator();
                line = reader.readLine();
            }

            //Replacing oldString with newString in the oldContent
            String newContent = oldContent.replaceAll(oldString, newString);
            //Rewriting the input text file with newContent
            writer = new FileWriter(file);
            writer.write(newContent);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                //Closing the resources
                reader.close();
                writer.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        modifyFile("C:\\Users\\sekizo\\IdeaProjects\\exm N1\\src\\MyFile.txt", "seu", "sangu");

        System.out.println("done");
    }
}
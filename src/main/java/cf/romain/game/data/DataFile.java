package cf.romain.game.data;

import cf.romain.game.Game;

import java.io.File;
import java.io.IOException;

public abstract class DataFile {

    private File    file;

    public DataFile(String filename) {
        File nfile = new File(filename + ".game");
        try {
            if (!nfile.exists()) nfile.createNewFile();
        } catch (IOException e) {
            String error = "[Error :: 3] Can't create a new data file.\n"
                    + "-    File name:   " + filename + "\n"
                    + "-    Reference:   DataFile - constructor.";
            Game.LOGS.log(error);
            System.out.println(error);
        }

        file = nfile;
    }

    /**
     * Get file object
     * @return File
     */
    public File getFile() {
        return file;
    }


}

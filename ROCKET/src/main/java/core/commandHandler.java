package core;

import commands.Command;
import javafx.scene.web.HTMLEditorSkin;

import java.io.IOException;
import java.util.HashMap;


/**
 * Created by Svenk on 19.06.2017.
 */

public class commandHandler {

    public static final commandParser parse = new commandParser();
    public static HashMap<String, Command> commands = new HashMap<>();

    public static void handleCommand(commandParser.commandContainer cmd) {

        if (commands.containsKey(cmd.invoke)) {

            boolean safe = commands.get(cmd.invoke).called(cmd.args, cmd.event);

            if (!safe) {
                try {
                    commands.get(cmd.invoke).action(cmd.args, cmd.event);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                commands.get(cmd.invoke).executed(safe, cmd.event);
            } else {
                commands.get(cmd.invoke).executed(safe, cmd.event);
            }

        }

    }

}
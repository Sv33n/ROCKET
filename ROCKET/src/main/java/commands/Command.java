package commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.io.IOException;

/**
 * Created by Svenk on 12.06.2017.
 */
public interface Command {

   boolean called(String[] args, MessageReceivedEvent event);
   void action (String[] args, MessageReceivedEvent event) throws IOException;
   void executed (boolean  sucess, MessageReceivedEvent event);
   String help();

}
